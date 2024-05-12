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

        String servico1 = req.getParameter("servico1");
        String servico2 = req.getParameter("servico2");
        String servico3 = req.getParameter("servico3");
        String servico4 = req.getParameter("servico4");
        String servico5 = req.getParameter("servico5");

        String servico6 = req.getParameter("servico6");
        String servico7 = req.getParameter("servico7");
        String servico8 = req.getParameter("servico8");

        boolean cardapio = servico1 != null && servico1.equals("simples");
        boolean flores = servico2 != null && servico2.equals("simples");
        boolean bebidas = servico3 != null && servico3.equals("simples");
        boolean doces = servico4 != null && servico4.equals("simples");
        boolean bolos = servico5 != null && servico5.equals("simples");

        DetalheOrcamentoDao detalheOrcamentoDAO = new DetalheOrcamentoDao();
        DetalheOrcamento detalheOrcamento = new DetalheOrcamento();

        Orcamentos orcamento = new Orcamentos();
        OrcamentosDao orcamentosDao = new OrcamentosDao();

        orcamento.setIdCasamento(casamento.getIdCasamento());
        orcamento.setIdUsuario(usuario.getIdUsuario());
        orcamento.setDataOrcamento(new Date());
        orcamento.setObservacao(observacao);
        orcamento.setStatus("Pendente");
        orcamento.setValorTotal(0);

        orcamento = orcamentosDao.criarOrcamento(orcamento);

        detalheOrcamento.setIdOrcamento(orcamento.getIdOrcamento());
        detalheOrcamento.setIdServico(1);
        detalheOrcamento.setQuantidade(1);
        detalheOrcamento.setPrecoEditavel(0);
        detalheOrcamento.setObservacaoServico("");
        detalheOrcamento.setCompleto(cardapio);
        detalheOrcamento.setIncluso(false);

        detalheOrcamentoDAO.criarDetalheOrcamento(detalheOrcamento);

        detalheOrcamento.setIdOrcamento(orcamento.getIdOrcamento());
        detalheOrcamento.setIdServico(2);
        detalheOrcamento.setQuantidade(1);
        detalheOrcamento.setPrecoEditavel(0);
        detalheOrcamento.setObservacaoServico("");
        detalheOrcamento.setCompleto(flores);
        detalheOrcamento.setIncluso(false);

        detalheOrcamentoDAO.criarDetalheOrcamento(detalheOrcamento);

        detalheOrcamento.setIdOrcamento(orcamento.getIdOrcamento());
        detalheOrcamento.setIdServico(3);
        detalheOrcamento.setQuantidade(1);
        detalheOrcamento.setPrecoEditavel(0);
        detalheOrcamento.setObservacaoServico("");
        detalheOrcamento.setCompleto(bebidas);
        detalheOrcamento.setIncluso(false);

        detalheOrcamentoDAO.criarDetalheOrcamento(detalheOrcamento);

        detalheOrcamento.setIdOrcamento(orcamento.getIdOrcamento());
        detalheOrcamento.setIdServico(4);
        detalheOrcamento.setQuantidade(1);
        detalheOrcamento.setPrecoEditavel(0);
        detalheOrcamento.setObservacaoServico("");
        detalheOrcamento.setCompleto(doces);
        detalheOrcamento.setIncluso(false);

        detalheOrcamentoDAO.criarDetalheOrcamento(detalheOrcamento);

        detalheOrcamento.setIdOrcamento(orcamento.getIdOrcamento());
        detalheOrcamento.setIdServico(5);
        detalheOrcamento.setQuantidade(1);
        detalheOrcamento.setPrecoEditavel(0);
        detalheOrcamento.setObservacaoServico("");
        detalheOrcamento.setCompleto(bolos);
        detalheOrcamento.setIncluso(false);

        Servico servico = new Servico();
        ServicoDao servicoDao = new ServicoDao();

        detalheOrcamentoDAO.criarDetalheOrcamento(detalheOrcamento);
        servico  = servicoDao.encontrarServicoPorId(6);

        detalheOrcamento.setIdOrcamento(orcamento.getIdOrcamento());
        detalheOrcamento.setIdServico(6);
        detalheOrcamento.setQuantidade(1);
        detalheOrcamento.setPrecoEditavel(servico.getPreco());
        detalheOrcamento.setObservacaoServico(servico.getObservacao());
        detalheOrcamento.setIncluso(true);

        detalheOrcamentoDAO.criarDetalheOrcamento(detalheOrcamento);
        servico  = servicoDao.encontrarServicoPorId(7);

        detalheOrcamento.setIdOrcamento(orcamento.getIdOrcamento());
        detalheOrcamento.setIdServico(7);
        detalheOrcamento.setQuantidade(1);
        detalheOrcamento.setPrecoEditavel(servico.getPreco());
        detalheOrcamento.setObservacaoServico(servico.getObservacao());
        detalheOrcamento.setIncluso(true);

        detalheOrcamentoDAO.criarDetalheOrcamento(detalheOrcamento);
        servico  = servicoDao.encontrarServicoPorId(8);

        detalheOrcamento.setIdOrcamento(orcamento.getIdOrcamento());
        detalheOrcamento.setIdServico(8);
        detalheOrcamento.setQuantidade(1);
        detalheOrcamento.setPrecoEditavel(servico.getPreco());
        detalheOrcamento.setObservacaoServico(servico.getObservacao());
        detalheOrcamento.setIncluso(true);

        detalheOrcamentoDAO.criarDetalheOrcamento(detalheOrcamento);


        OrcamentosDao orcamentoDao = new OrcamentosDao();
        List<Orcamentos> listaOrcamentos = orcamentoDao.buscarOrcamentoPorUsuario(usuario.getIdUsuario());
        req.getSession().setAttribute("listaOrcamentos", listaOrcamentos);

        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.buscarUsuarioPorId(orcamento.getIdUsuario());

        Email email = new Email("","",usuario.getEmail(),"","","");

        resp.sendRedirect(req.getContextPath() + "/perfil.jsp");

        email.enviarOrcamentoPendente(orcamento,usuario);
    }

}
