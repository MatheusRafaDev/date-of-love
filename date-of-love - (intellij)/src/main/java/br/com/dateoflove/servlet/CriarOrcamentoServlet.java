package br.com.dateoflove.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dateoflove.dao.DetalheOrcamentoDao;
import br.com.dateoflove.dao.OrcamentosDao;
import br.com.dateoflove.dao.ServicoDao;
import br.com.dateoflove.funcao.Email;
import br.com.dateoflove.model.DetalheOrcamento;
import br.com.dateoflove.model.Orcamentos;
import br.com.dateoflove.model.Servico;
import br.com.dateoflove.model.Usuario;

@WebServlet("/criar-orcamento")
public class CriarOrcamentoServlet extends HttpServlet {

    private static final double VALOR_INICIAL = 0.0;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        DetalheOrcamentoDao detalheOrcamentoDAO = new DetalheOrcamentoDao();
        OrcamentosDao orcamentosDao = new OrcamentosDao();
        ServicoDao servicoDao = new ServicoDao();

        double valorEstimado = parseValor(req.getParameter("orcamentoMedio"));
        String local = req.getParameter("localCasamento");
        String tipoCerimonia = req.getParameter("tipoCerimonia");
        String formaPagamento = req.getParameter("formaPagamento");
        String observacao = req.getParameter("observacao");
        String comentarioAdicional = req.getParameter("comentarios");

        String dataCasamentoStr = req.getParameter("dataCasamento");

        Date dataCasamento = null;
        if (dataCasamentoStr != null && !dataCasamentoStr.isEmpty()) {
            try {
                dataCasamento = java.sql.Date.valueOf(dataCasamentoStr);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        String quantidadePessoasStr = req.getParameter("quantidadePessoas");
        int convidados = 0;
        if (quantidadePessoasStr != null && !quantidadePessoasStr.isEmpty()) {
            convidados = Integer.parseInt(quantidadePessoasStr);
        }

        Orcamentos orcamento = new Orcamentos();
        orcamento.setQtdConvidados(convidados);
        orcamento.setIdUsuario((int) usuario.getIdUsuario());
        orcamento.setDataOrcamento(new Date());
        orcamento.setObservacao(observacao);
        orcamento.setStatus("Pendente");
        orcamento.setValorTotal(VALOR_INICIAL);
        orcamento.setLocal(local);
        orcamento.setTipoCerimonia(tipoCerimonia);
        orcamento.setFormaPagamento(formaPagamento);
        orcamento.setValorEstimado(valorEstimado);
        orcamento.setNomeOrcador("");
        orcamento.setObservacaoOrcador("");
        orcamento.setComentarioAdicional(comentarioAdicional);
        orcamento.setAprovado(false);
        orcamento.setCancelado(false);
        if (dataCasamento != null) {
            orcamento.setDataCasamento(dataCasamento);
        }

        orcamento = orcamentosDao.criarOrcamento(orcamento);

        String[] servicosIds = {"1", "2", "3", "4", "5"};

        for (String servicoIdStr : servicosIds) {
            int servicoId = Integer.parseInt(servicoIdStr);
            String tipoServico = req.getParameter("servico" + servicoId);

            Servico servico = servicoDao.encontrarServicoPorId(servicoId);
            if (servico != null) {
                double preco = 0.0;
                String observacaoServico = "";
                char tipo = 'S'; // Default to 'S' for Simples
                switch (tipoServico) {
                    case "simples":
                        preco = servico.getPrecoSimples();
                        observacaoServico = servico.getDescricaoSimples();
                        tipo = 'S';
                        break;
                    case "comum":
                        preco = servico.getPrecoComum();
                        observacaoServico = servico.getDescricaoComum();
                        tipo = 'C';
                        break;
                    case "premium":
                        preco = servico.getPrecoPremium();
                        observacaoServico = servico.getDescricaoPremium();
                        tipo = 'P';
                        break;
                    case "exclusivo":
                        preco = servico.getPrecoExclusivo();
                        observacaoServico = servico.getDescricaoExclusivo();
                        tipo = 'E';
                        break;
                }

                DetalheOrcamento detalheOrcamento = new DetalheOrcamento();
                detalheOrcamento.setIdOrcamento(orcamento.getIdOrcamento());
                detalheOrcamento.setIdServico(servicoId);
                detalheOrcamento.setQuantidade(1);
                detalheOrcamento.setPrecoEditavel(preco);
                detalheOrcamento.setObservacaoServico(observacaoServico);
                detalheOrcamento.setTipo(tipo);
                detalheOrcamentoDAO.criarDetalheOrcamento(detalheOrcamento);
            }
        }

        List<Orcamentos> listaOrcamentos = orcamentosDao.buscarOrcamentoPorUsuario(usuario.getIdUsuario());
        req.getSession().setAttribute("listaOrcamentos", listaOrcamentos);

        Email email = new Email("", "", usuario.getEmail(), "", "", "");
        email.enviarOrcamentoPendente(orcamento, usuario);

        resp.sendRedirect(req.getContextPath() + "/perfil.jsp");
    }

    private boolean isServicoSimples(HttpServletRequest req, String parametro) {
        return req.getParameter(parametro) != null && req.getParameter(parametro).equals("simples");
    }

    private double parseValor(String valorString) {
        if (valorString == null || valorString.isEmpty()) {
            return VALOR_INICIAL;
        }
        try {
            String valorSemPontosMilhar = valorString.replaceAll("\\.", "");
            String valorFormatado = valorSemPontosMilhar.replace(',', '.');
            return Double.parseDouble(valorFormatado);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return VALOR_INICIAL;
        }
    }
}