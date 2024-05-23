package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.UsuarioDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletar-perfil")
public class DeletarUsuarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        UsuarioDao usuarioDAO = new UsuarioDao();

        UsuarioDao.deletarUsuarioPorId(idUsuario);

        request.getSession().invalidate();

        response.sendRedirect("/login");
    }
}
