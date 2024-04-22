package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.UsuarioDao;
import br.com.dateoflove.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = usuarioDao.buscarUsuarioPorEmail(email);

        if (usuario != null && usuario.getSenha().equals(senha)) {
            req.getSession().setAttribute("id", usuario.getIdUsuario());
            resp.sendRedirect("/ajuda.jsp");
        } else {
            req.setAttribute("errorMessage", "Usuário ou Senha inválidos!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
