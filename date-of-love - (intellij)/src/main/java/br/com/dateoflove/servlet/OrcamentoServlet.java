package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.OrcamentosDao;
import br.com.dateoflove.model.Orcamentos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/orcamento")
public class OrcamentoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idOrcamento = Integer.parseInt(req.getParameter("idOrcamento"));
        OrcamentosDao orcamentoDao = new OrcamentosDao();
        Orcamentos orcamento = orcamentoDao.buscarOrcamentoPorUsuario(idOrcamento);
        req.setAttribute("orcamento", orcamento);
        req.getRequestDispatcher("orcamento.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Create or Update
        int idOrcamento = Integer.parseInt(req.getParameter("idOrcamento"));
        int idUsuario = Integer.parseInt(req.getParameter("idUsuario"));
        int idCasamento = Integer.parseInt(req.getParameter("idCasamento"));
        String status = req.getParameter("status");
        String observacao = req.getParameter("observacao");
        String nomeOrcador = req.getParameter("nomeOrcador");

        OrcamentosDao orcamentoDao = new OrcamentosDao();
        Orcamentos orcamento = new Orcamentos(idOrcamento, idUsuario, idCasamento, new java.util.Date(), status, observacao, nomeOrcador);

        if (orcamentoDao.existeOrcamentoPorUsuario(idUsuario)) {
            orcamentoDao.atualizarOrcamento(orcamento);
        } else {
            orcamentoDao.criarOrcamento(orcamento);
        }

        resp.sendRedirect("/orcamento.jsp");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Delete
        int idOrcamento = Integer.parseInt(req.getParameter("idOrcamento"));
        OrcamentosDao orcamentoDao = new OrcamentosDao();
        orcamentoDao.deletarOrcamentoPorId(idOrcamento);
        resp.sendRedirect("/orcamento.jsp");
    }
}