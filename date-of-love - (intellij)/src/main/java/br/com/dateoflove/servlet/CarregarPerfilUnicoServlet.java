package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.CasamentoDao;
import br.com.dateoflove.dao.OrcamentosDao;
import br.com.dateoflove.dao.ServicoDao;
import br.com.dateoflove.dao.UsuarioDao;
import br.com.dateoflove.model.Casamento;
import br.com.dateoflove.model.Orcamentos;
import br.com.dateoflove.model.Servico;
import br.com.dateoflove.model.Usuario;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/carregar-usuario-unico")
public class CarregarPerfilUnicoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String email = req.getParameter("email");

        UsuarioDao usuarioDao = new UsuarioDao();
        OrcamentosDao orcamentoDao = new OrcamentosDao();
        CasamentoDao casamentoDao = new CasamentoDao();

        Usuario usuario = usuarioDao.buscarUsuarioPorEmail(email);
        List<Orcamentos> listaOrcamentos = orcamentoDao.buscarOrcamentoPorUsuario(usuario.getIdUsuario());
        Casamento casamento = casamentoDao.encontrarCasamentoPorIdUsuario(usuario.getIdUsuario());


        req.getSession().setAttribute("usuario", usuario);
        req.getSession().setAttribute("casamento", casamento);
        req.getSession().setAttribute("listaOrcamentos", listaOrcamentos);

        resp.sendRedirect(req.getContextPath() + "/adm/adm-visualizar-perfil.jsp");
    }

}
