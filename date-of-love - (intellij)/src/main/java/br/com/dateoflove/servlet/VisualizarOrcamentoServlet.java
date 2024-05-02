package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.CasamentoDao;
import br.com.dateoflove.dao.OrcamentosDao;
import br.com.dateoflove.dao.UsuarioDao;
import br.com.dateoflove.model.Casamento;
import br.com.dateoflove.model.Orcamentos;
import br.com.dateoflove.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/perfil")
public class VisualizarOrcamentoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);

        OrcamentosDao orcamentoDao = new OrcamentosDao();
        List<Orcamentos> listaOrcamentos = orcamentoDao.buscarOrcamentoPorUsuario(id);

        req.setAttribute("listaOrcamentos", listaOrcamentos);
        req.getRequestDispatcher("perfil.jsp").forward(req, resp);

    }
}
