package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.DetalheOrcamentoDao;
import br.com.dateoflove.model.DetalheOrcamento;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/detalheOrcamento")
public class DetalheOrcamentoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);

        DetalheOrcamentoDao detalheOrcamentoDao = new DetalheOrcamentoDao();
        List<DetalheOrcamento> detalheOrcamento = detalheOrcamentoDao.encontrarDetalhesOrcamentoPorIdOrcamento(id);

        req.setAttribute("detalheOrcamento", detalheOrcamento);
        req.getRequestDispatcher("detalheOrcamento.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Falta a lógica para criar um novo DetalheOrcamento
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Falta a lógica para atualizar um DetalheOrcamento existente
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Falta a lógica para deletar um DetalheOrcamento
    }
}