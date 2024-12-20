package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.*;
import br.com.dateoflove.model.Casamento;
import br.com.dateoflove.model.DetalheOrcamento;
import br.com.dateoflove.model.Orcamentos;
import br.com.dateoflove.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
        CasamentoDao casamentoDao = new CasamentoDao();


        Orcamentos orcamento = orcamentoDao.buscarOrcamentoPorId( id);
        Usuario usuario = usuarioDao.buscarUsuarioPorId(orcamento.getIdUsuario());

        List<DetalheOrcamento> detalheOrcamento = detalheOrcamentoDao.encontrarDetalhesOrcamentoPorIdOrcamento(id);
        List<DetalheOrcamento> detalheOrcamento2 = detalheOrcamentoDao.encontrarDetalhesOrcamentoPorIdOrcamento2(id);

        req.getSession().setAttribute("orcamento", orcamento);
        req.getSession().setAttribute("detalheorcamento", detalheOrcamento);
        req.getSession().setAttribute("detalheorcamento2", detalheOrcamento2);
        req.getSession().setAttribute("servicoDao", servicoDao);

        req.getSession().setAttribute("usuario", usuario);


        resp.sendRedirect(req.getContextPath() + "/adm/adm-detalhe-orcamento.jsp");
    }

}