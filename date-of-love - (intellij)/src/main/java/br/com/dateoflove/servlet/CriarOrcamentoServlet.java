package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.DetalheOrcamentoDao;
import br.com.dateoflove.dao.OrcamentosDao;
import br.com.dateoflove.dao.ServicoDao;
import br.com.dateoflove.dao.UsuarioDao;
import br.com.dateoflove.funcao.Email;
import br.com.dateoflove.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/criar-orcamento")
public class CriarOrcamentoServlet extends HttpServlet {

    private static final double VALOR_INICIAL = 0.0;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");


        String observacao = req.getParameter("observacao");

        // Extraindo e formatando o valor médio do orçamento com tratamento de exceção
        double valorOrcamentoMedio = parseValor(req.getParameter("orcamentoMedio"));

        String local = req.getParameter("local");
        String tipoCerimonia = req.getParameter("tipoCerimonia");
        String formaPagamento = req.getParameter("formaPagamento");
        double valorEstimado = parseValor(req.getParameter("valorEstimado"));
        String observacaoGeral = req.getParameter("observacaoGeral");
        String comentarioAdicional = req.getParameter("comentarioAdicional");

        boolean cardapio = isServicoSimples(req, "servico1");
        boolean flores = isServicoSimples(req, "servico2");
        boolean bebidas = isServicoSimples(req, "servico3");
        boolean doces = isServicoSimples(req, "servico4");
        boolean bolos = isServicoSimples(req, "servico5");

        DetalheOrcamentoDao detalheOrcamentoDAO = new DetalheOrcamentoDao();
        OrcamentosDao orcamentosDao = new OrcamentosDao();
        ServicoDao servicoDao = new ServicoDao();

        Orcamentos orcamento = new Orcamentos();
        orcamento.setValorMedio(valorOrcamentoMedio);
        orcamento.setIdUsuario((int) usuario.getIdUsuario());
        orcamento.setDataOrcamento(new Date());
        orcamento.setObservacao(observacao);
        orcamento.setStatus("Pendente");
        orcamento.setValorTotal(VALOR_INICIAL);

        orcamento.setLocal(local);
        orcamento.setTipoCerimonia(tipoCerimonia);
        orcamento.setFormaPagamento(formaPagamento);
        orcamento.setValorEstimado(valorEstimado);
        orcamento.setObservacaoGeral(observacaoGeral);
        orcamento.setComentarioAdicional(comentarioAdicional);

        orcamento = orcamentosDao.criarOrcamento(orcamento);

        // IDs e serviços
        String[] servicosIds = {"1", "2", "3", "4", "5", "6", "7", "8"};
        boolean[] servicosSimples = {cardapio, flores, bebidas, doces, bolos, true, true, true};
        boolean[] servicosInclusos = {false, false, false, false, false, true, true, true};

        for (int i = 0; i < servicosIds.length; i++) {
            int servicoId = Integer.parseInt(servicosIds[i]);
            boolean servicoSimples = servicosSimples[i];
            boolean servicoIncluso = servicosInclusos[i];

            Servico servico = servicoDao.encontrarServicoPorId(servicoId);
            if (servico != null) {
                double preco = servico.getPreco();

                DetalheOrcamento detalheOrcamento = new DetalheOrcamento();
                detalheOrcamento.setIdOrcamento(orcamento.getIdOrcamento());
                detalheOrcamento.setIdServico(servicoId);
                detalheOrcamento.setQuantidade(1);
                detalheOrcamento.setPrecoEditavel(preco);
                detalheOrcamento.setObservacaoServico(servico.getObservacao());
                detalheOrcamento.setCompleto(servicoSimples);
                detalheOrcamento.setIncluso(servicoIncluso);
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


