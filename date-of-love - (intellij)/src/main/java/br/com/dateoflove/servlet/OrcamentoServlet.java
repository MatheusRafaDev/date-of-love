package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.DetalheOrcamentoDao;
import br.com.dateoflove.dao.OrcamentosDao;
import br.com.dateoflove.dao.ServicoDao;

import br.com.dateoflove.model.DetalheOrcamento;
import br.com.dateoflove.model.Orcamentos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/orcamento")
public class OrcamentoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);

        ServicoDao servicoDao = new ServicoDao();
        DetalheOrcamentoDao detalheOrcamentoDao = new DetalheOrcamentoDao();
        OrcamentosDao orcamentoDao = new OrcamentosDao();

        Orcamentos orcamento = orcamentoDao.buscarOrcamentoPorId(id);

        List<DetalheOrcamento> detalheOrcamento = detalheOrcamentoDao.encontrarDetalhesOrcamentoPorIdOrcamento(id);
        List<DetalheOrcamento> detalheOrcamento2 = detalheOrcamentoDao.encontrarDetalhesOrcamentoPorIdOrcamento2(id);

        req.getSession().setAttribute("orcamento", orcamento);
        req.getSession().setAttribute("detalheorcamento", detalheOrcamento);
        req.getSession().setAttribute("detalheorcamento2", detalheOrcamento2);
        req.getSession().setAttribute("servicoDao", servicoDao);


        resp.sendRedirect(req.getContextPath() + "/orcamento.jsp");
    }

}
