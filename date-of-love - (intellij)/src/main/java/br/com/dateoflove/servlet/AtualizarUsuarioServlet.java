package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.CasamentoDao;
import br.com.dateoflove.dao.UsuarioDao;
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
import java.util.Date;

@WebServlet("/atualizar-usuario")
public class AtualizarUsuarioServlet extends HttpServlet  {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter("id_usuario");
        int idUsuario = Integer.parseInt(idString);

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

        System.out.println("teste");
        req.getRequestDispatcher("/perfil.jsp").forward(req, resp);
    }

}
