package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.OrcamentosDao;
import br.com.dateoflove.model.Usuario;
import br.com.dateoflove.model.Orcamentos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/perfil")
public class VisualizarOrcamentoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");

        if (usuario == null) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        int id = (int) usuario.getIdUsuario();


        OrcamentosDao orcamentoDao = new OrcamentosDao();
        List<Orcamentos> listaOrcamentos = orcamentoDao.buscarOrcamentoPorUsuario(id);


        req.getSession().setAttribute("listaOrcamentos", listaOrcamentos);

        resp.sendRedirect(req.getContextPath() + "/perfil.jsp");
    }
}
