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
        OrcamentosDao orcamentoDao = new OrcamentosDao();
        CasamentoDao casamentoDao = new CasamentoDao();

        Usuario usuario = usuarioDao.buscarUsuarioPorEmail(email);

        if (usuario != null && usuario.getSenha().equals(senha)) {

            List<Orcamentos> listaOrcamentos = orcamentoDao.buscarOrcamentoPorUsuario(usuario.getIdUsuario());

            Casamento casamento =  casamentoDao.encontrarCasamentoPorIdUsuario(usuario.getIdUsuario());

            req.getSession().setAttribute("usuario", usuario);
            req.getSession().setAttribute("casamento", casamento);
            req.getSession().setAttribute("listaOrcamentos", listaOrcamentos);

            resp.sendRedirect(req.getContextPath() + "/perfil.jsp");

            //req.getRequestDispatcher("/perfil.jsp").forward(req, resp);

        } else {
            req.setAttribute("errorMessage", "Usuário ou Senha inválidos!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
