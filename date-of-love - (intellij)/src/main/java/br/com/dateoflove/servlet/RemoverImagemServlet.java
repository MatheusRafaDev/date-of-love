package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.UsuarioDao;
import br.com.dateoflove.model.Usuario;
import br.com.dateoflove.model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/remover-foto")
public class RemoverImagemServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idUsuario = Integer.parseInt(req.getParameter("idUsuario"));

        UsuarioDao usuarioDAO = new UsuarioDao();
        usuarioDAO.deletarImagem(idUsuario);

        Usuario usuario = new UsuarioDao().buscarUsuarioPorId(idUsuario);

        req.getSession().setAttribute("usuario", usuario);
        resp.sendRedirect(req.getContextPath() + "/perfil.jsp");
    }
}
