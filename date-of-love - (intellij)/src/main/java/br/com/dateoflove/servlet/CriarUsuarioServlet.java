package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.UsuarioDao;
import br.com.dateoflove.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/criar-usuario")
public class CriarUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String nomeNoivo = request.getParameter("nome_noivo");
        String nomeNoiva = request.getParameter("nome_noiva");
        String email = request.getParameter("email");
        String dataCasamentoStr = request.getParameter("data_casamento");
        String senha = request.getParameter("senha");
        String confirmarSenha = request.getParameter("confirmar_senha");


        if (!senha.equals(confirmarSenha)) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "As senhas não coincidem");
            return;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dataCasamento = null;
        try {
            dataCasamento = formatter.parse(dataCasamentoStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Usuario usuario = new Usuario(0, nomeNoivo, nomeNoiva, email, senha, new Date(), dataCasamento, nomeNoivo + " & " + nomeNoiva);

        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.criarUsuario(usuario);

        resp.sendRedirect("/home.jsp");
    }
}
