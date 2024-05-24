package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.UsuarioDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletar-usuario")
public class DeletarUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idUsuario = Integer.parseInt(req.getParameter("id"));

        UsuarioDao UsuarioDao = new UsuarioDao();
        UsuarioDao.deletarUsuarioPorId(idUsuario);

        req.getSession().invalidate();
        resp.sendRedirect("/login");
    }
}
