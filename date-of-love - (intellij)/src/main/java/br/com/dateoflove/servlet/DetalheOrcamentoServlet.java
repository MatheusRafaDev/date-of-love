package br.com.dateoflove.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dateoflove.dao.DetalheOrcamentoDao;
import br.com.dateoflove.dao.OrcamentosDao;
import br.com.dateoflove.dao.ServicoDao;
import br.com.dateoflove.dao.UsuarioDao;
import br.com.dateoflove.model.DetalheOrcamento;
import br.com.dateoflove.model.Orcamentos;
import br.com.dateoflove.model.Usuario;

@WebServlet("/detalhe-orcamento")
public class DetalheOrcamentoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);

        UsuarioDao usuarioDao = new UsuarioDao();
        ServicoDao servicoDao = new ServicoDao();
        DetalheOrcamentoDao detalheOrcamentoDao = new DetalheOrcamentoDao();
        OrcamentosDao orcamentoDao = new OrcamentosDao();


        Orcamentos orcamento = orcamentoDao.buscarOrcamentoPorId( id);
        Usuario usuario = usuarioDao.buscarUsuarioPorId(orcamento.getIdUsuario());

        List<DetalheOrcamento> detalheOrcamento = detalheOrcamentoDao.encontrarDetalhesOrcamentoPorIdOrcamento(id);


        req.getSession().setAttribute("orcamento", orcamento);
        req.getSession().setAttribute("detalheorcamento", detalheOrcamento);
        req.getSession().setAttribute("servicoDao", servicoDao);

        req.getSession().setAttribute("usuario", usuario);


        resp.sendRedirect(req.getContextPath() + "/adm/adm-detalhe-orcamento.jsp");
    }

}