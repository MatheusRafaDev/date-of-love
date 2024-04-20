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
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = usuarioDao.buscarUsuarioPorEmail(email);

        if (usuario != null && usuario.getSenha().equals(senha)) {
            Cookie cookie = new Cookie("usuarioId", String.valueOf(usuario.getIdUsuario()));

            cookie.setPath("/");
            cookie.setMaxAge(24 * 60 * 60);

            resp.addCookie(cookie);


            resp.sendRedirect("/home.jsp");
        } else {
            resp.setContentType("text/html");
            resp.getWriter().println("<script>alert('Credenciais inválidas. Por favor, tente novamente ');</script>");
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Credenciais inválidas. Por favor, tente novamente.");
        }
    }
}
