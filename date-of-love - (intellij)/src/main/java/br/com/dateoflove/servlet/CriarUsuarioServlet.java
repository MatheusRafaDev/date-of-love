package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.OrcamentosDao;
import br.com.dateoflove.dao.UsuarioDao;
import br.com.dateoflove.dao.CasamentoDao;
import br.com.dateoflove.funcao.Email;
import br.com.dateoflove.model.Casamento;
import br.com.dateoflove.model.Orcamentos;
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
import java.util.List;

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

        usuario = usuarioDao.buscarUsuarioPorEmail(email);

        Casamento casamento = new Casamento();
        OrcamentosDao orcamentoDao = new OrcamentosDao();
        casamento = casamentoDao.criarCasamento(new Casamento(0, usuario.getIdUsuario(), dataCasamento, local, Convidados, estilo));
        List<Orcamentos> listaOrcamentos = orcamentoDao.buscarOrcamentoPorUsuario(usuario.getIdUsuario());

        req.getSession().setAttribute("usuario", usuario);
        req.getSession().setAttribute("casamento", casamento);
        req.getSession().setAttribute("listaOrcamentos", listaOrcamentos);


        Email email2 = new Email("","",usuario.getEmail(),"","","");


        //resp.sendRedirect(req.getContextPath() + "/home.jsp");
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
        email2.enviarBoasVindas(usuario);
    }
}
