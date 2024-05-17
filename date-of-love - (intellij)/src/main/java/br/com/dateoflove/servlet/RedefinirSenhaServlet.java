package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.UsuarioDao;
import br.com.dateoflove.model.Usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redefinirSenha")
public class RedefinirSenhaServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String novaSenha = request.getParameter("novaSenha");
        String email = request.getParameter("email");
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.atualizarSenhaPorEmail(email, novaSenha);

        // Redirecionar para a página JSP apropriada
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}