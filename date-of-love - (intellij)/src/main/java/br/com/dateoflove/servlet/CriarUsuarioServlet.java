package br.com.dateoflove.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dateoflove.dao.OrcamentosDao;
import br.com.dateoflove.dao.UsuarioDao;
import br.com.dateoflove.funcao.Email;
import br.com.dateoflove.model.Casamento;
import br.com.dateoflove.model.Orcamentos;
import br.com.dateoflove.model.Usuario;

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
       
       
        String imagem = req.getParameter("");


        if (usuarioDao.existeUsuarioPorEmail(email)) {
            req.setAttribute("errorMessage1", "Este email já está em uso.");

            req.setAttribute("nomeNoivo", nomeNoivo);
            req.setAttribute("nomeNoiva", nomeNoiva);
            req.setAttribute("email", email);


            req.getRequestDispatcher("criar-conta.jsp").forward(req, resp);
            return;
        }

        if (!senha.equals(confirmarSenha)) {
            req.setAttribute("errorMessage2", "As senhas não coincidem");

            req.setAttribute("nomeNoivo", nomeNoivo);
            req.setAttribute("nomeNoiva", nomeNoiva);
            req.setAttribute("email", email);


            req.getRequestDispatcher("criar-conta.jsp").forward(req, resp);
            return;
        }


        Usuario usuario = new Usuario(0, nomeNoivo, nomeNoiva, email, senha, new Date(),  nomeNoivo + " & " + nomeNoiva,imagem);
        usuario = usuarioDao.criarUsuario(usuario);

        usuario = usuarioDao.buscarUsuarioPorEmail(email);

        Casamento casamento = new Casamento();
        OrcamentosDao orcamentoDao = new OrcamentosDao();
        
        List<Orcamentos> listaOrcamentos = orcamentoDao.buscarOrcamentoPorUsuario(usuario.getIdUsuario());

        req.getSession().setAttribute("usuario", usuario);
        req.getSession().setAttribute("casamento", casamento);
        req.getSession().setAttribute("listaOrcamentos", listaOrcamentos);


        Email email2 = new Email("","",usuario.getEmail(),"","","");

        req.getRequestDispatcher("/").forward(req, resp);
        email2.enviarBoasVindas(usuario);
    }
}
