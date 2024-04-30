package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.UsuarioDao;
import br.com.dateoflove.dao.CasamentoDao;
import br.com.dateoflove.model.Casamento;
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
        String senha = req.getParameter("senha");
        String confirmarSenha = req.getParameter("confirmar_senha");
        UsuarioDao usuarioDao = new UsuarioDao();
        CasamentoDao casamentoDao = new CasamentoDao();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


        int Convidados = Integer.parseInt(req.getParameter("num_convidados"));
        String dataCasamentoStr = req.getParameter("data_casamento");
        String local = req.getParameter("localizacao");
        String estilo = req.getParameter("estilo_festa");


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

        Usuario usuario = new Usuario(0, nomeNoivo, nomeNoiva, email, senha, new Date(),  nomeNoivo + " & " + nomeNoiva);
        usuario = usuarioDao.criarUsuario(usuario);

        casamentoDao.criarCasamento(new Casamento(0, usuario.getIdUsuario(), dataCasamento, local, Convidados, estilo));


        resp.sendRedirect("/home.jsp");
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idUsuario = Integer.parseInt(req.getParameter("id_usuario"));
        String nomeNoivo = req.getParameter("nome_noivo");
        String nomeNoiva = req.getParameter("nome_noiva");
        String email = req.getParameter("email");
        String dataCasamentoStr = req.getParameter("data_casamento");
        String localizacao = req.getParameter("localizacao");
        int numConvidados = Integer.parseInt(req.getParameter("num_convidados"));
        String estiloFesta = req.getParameter("estilo_festa");

        if (dataCasamentoStr == null || dataCasamentoStr.isEmpty()) {
            req.setAttribute("errorMessage", "A data do casamento é obrigatória.");
            req.getRequestDispatcher("/perfil.jsp").forward(req, resp);
            return;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dataCasamento = null;
        try {
            dataCasamento = formatter.parse(dataCasamentoStr);
        } catch (ParseException e) {
            req.setAttribute("errorMessage", "Formato de data inválido.");
            req.getRequestDispatcher("/perfil.jsp").forward(req, resp);
            return;
        }


        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        usuario.setNomeNoivo(nomeNoivo);
        usuario.setNomeNoiva(nomeNoiva);
        usuario.setEmail(email);
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.atualizarUsuario(usuario);


        Casamento casamento = new Casamento();
        CasamentoDao casamentoDao = new CasamentoDao();

        casamento.setLocalidade(localizacao);
        casamento.setNumeroConvidados(numConvidados);
        casamento.setEstiloFesta(estiloFesta);

        casamentoDao.atualizarCasamento(casamento);

        resp.sendRedirect( "/perfil.jsp");
    }

}
