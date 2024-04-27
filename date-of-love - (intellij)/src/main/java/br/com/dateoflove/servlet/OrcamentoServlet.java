package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.OrcamentosDao;
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

        System.out.println(2);

        int idOrcamento = Integer.parseInt(req.getParameter("id"));
        System.out.println(idOrcamento);

        OrcamentosDao orcamentoDao = new OrcamentosDao();
        Orcamentos orcamento = orcamentoDao.buscarOrcamentoPorId(idOrcamento);

        req.setAttribute("orcamento", orcamento);

        req.getRequestDispatcher("visualizar-orcamento.jsp").forward(req, resp);
    }

}
