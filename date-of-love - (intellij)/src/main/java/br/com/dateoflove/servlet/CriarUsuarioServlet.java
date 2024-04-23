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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomeNoivo = req.getParameter("nome_noivo");
        String nomeNoiva = req.getParameter("nome_noiva");
        String email = req.getParameter("email");
        String dataCasamentoStr = req.getParameter("data_casamento");
        String senha = req.getParameter("senha");
        String confirmarSenha = req.getParameter("confirmar_senha");

        UsuarioDao usuarioDao = new UsuarioDao();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date dataCasamento = null;
        try {
            dataCasamento = formatter.parse(dataCasamentoStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Date dataAtual = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataAtual);
        cal.add(Calendar.MONTH, 9);
        Date dataNoveMesesDepois = cal.getTime();

        if (usuarioDao.existeUsuarioPorEmail(email)) {
            req.setAttribute("errorMessage1", "Este email já está em uso.");
            req.getRequestDispatcher("criar-conta.jsp").forward(req, resp);
            return;
        }

        if (!senha.equals(confirmarSenha)) {
            req.setAttribute("errorMessage2", "As senhas não coincidemo");
            req.getRequestDispatcher("criar-conta.jsp").forward(req, resp);
            return;
        }

        if (!dataCasamento.after(dataNoveMesesDepois)) {
            req.setAttribute("errorMessage3", "A data do casamento deve ser 9 meses à frente");
            req.getRequestDispatcher("criar-conta.jsp").forward(req, resp);
            return;
        }


        Usuario usuario = new Usuario(0, nomeNoivo, nomeNoiva, email, senha, new Date(), dataCasamento, nomeNoivo + " & " + nomeNoiva);


        usuarioDao.criarUsuario(usuario);

        resp.sendRedirect("/home.jsp");
    }
}
