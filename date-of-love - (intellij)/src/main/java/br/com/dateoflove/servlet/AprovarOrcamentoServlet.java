package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.OrcamentosDao;
import br.com.dateoflove.dao.UsuarioDao;
import br.com.dateoflove.funcao.Email;
import br.com.dateoflove.model.Orcamentos;
import br.com.dateoflove.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/aprovar-orcamento")
public class AprovarOrcamentoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idOrcamentoStr = req.getParameter("idOrcamento");
        String idUsuarioStr = req.getParameter("idUsuario");

        if (idOrcamentoStr != null && !idOrcamentoStr.isEmpty()) {

            int idOrcamento = Integer.parseInt(idOrcamentoStr);
            int idUsuario = Integer.parseInt(idUsuarioStr);

            OrcamentosDao orcamentosDao = new OrcamentosDao();
            orcamentosDao.aprovarOrcamento(idOrcamento,idUsuario);

            UsuarioDao usuarioDao = new UsuarioDao();
            OrcamentosDao orcamentoDao = new OrcamentosDao();

            Usuario usuario =  usuarioDao.buscarUsuarioPorId(idUsuario);
            Orcamentos orcamentos = orcamentoDao.buscarOrcamentoPorId(idOrcamento);

            Email email = new Email("","",usuario.getEmail(),"","","");


            resp.sendRedirect(req.getContextPath() + "/perfil.jsp");

            email.enviarOrcamentoAprovado(orcamentos,usuario);
        } else {
            resp.sendRedirect(req.getContextPath() + "/perfil.jsp");
        }
    }
}
