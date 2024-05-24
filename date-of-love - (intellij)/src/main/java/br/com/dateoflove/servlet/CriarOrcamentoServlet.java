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
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Casamento casamento = (Casamento) session.getAttribute("casamento");

        String observacao = req.getParameter("observacao");

        String valorMedioString = req.getParameter("orcamentoMedio");
        String valorSemPontosMilhar = valorMedioString.replaceAll("\\.", "");
        String valorFormatado = valorSemPontosMilhar.replace(',', '.');
        double valorOrcamentoMedio = Double.parseDouble(valorFormatado);

        boolean cardapio = req.getParameter("servico1") != null && req.getParameter("servico1").equals("simples");
        boolean flores = req.getParameter("servico2") != null && req.getParameter("servico2").equals("simples");
        boolean bebidas = req.getParameter("servico3") != null && req.getParameter("servico3").equals("simples");
        boolean doces = req.getParameter("servico4") != null && req.getParameter("servico4").equals("simples");
        boolean bolos = req.getParameter("servico5") != null && req.getParameter("servico5").equals("simples");

        DetalheOrcamentoDao detalheOrcamentoDAO = new DetalheOrcamentoDao();
        OrcamentosDao orcamentosDao = new OrcamentosDao();
        ServicoDao servicoDao = new ServicoDao();

        Orcamentos orcamento = new Orcamentos();
        orcamento.setValorMedio(valorOrcamentoMedio);
        orcamento.setIdCasamento(casamento.getIdCasamento());
        orcamento.setIdUsuario(usuario.getIdUsuario());
        orcamento.setDataOrcamento(new Date());
        orcamento.setObservacao(observacao);
        orcamento.setStatus("Pendente");
        orcamento.setValorTotal(0);
        orcamento = orcamentosDao.criarOrcamento(orcamento);

        String[] servicosIds = {"1", "2", "3", "4", "5", "6", "7", "8"};
        boolean[] servicosSimples = {cardapio, flores, bebidas, doces, bolos, true, true, true};
        boolean[] servicosInclusos = {false, false, false, false, false, true, true, true};

        for (int i = 0; i < servicosIds.length; i++) {
            int servicoId = Integer.parseInt(servicosIds[i]);
            boolean servicoSimples = servicosSimples[i];
            boolean servicoIncluso = servicosInclusos[i];

            Servico servico = servicoDao.encontrarServicoPorId(servicoId);

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


        List<Orcamentos> listaOrcamentos = orcamentosDao.buscarOrcamentoPorUsuario(usuario.getIdUsuario());
        req.getSession().setAttribute("listaOrcamentos", listaOrcamentos);

        Email email = new Email("", "", usuario.getEmail(), "", "", "");
        resp.sendRedirect(req.getContextPath() + "/perfil.jsp");
        email.enviarOrcamentoPendente(orcamento, usuario);
    }
}
