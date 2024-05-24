package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.CasamentoDao;
import br.com.dateoflove.dao.OrcamentosDao;
import br.com.dateoflove.dao.UsuarioDao;
import br.com.dateoflove.model.Casamento;
import br.com.dateoflove.model.DetalheOrcamento;
import br.com.dateoflove.model.Orcamentos;
import br.com.dateoflove.model.Usuario;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orcamento-editar")
public class EditarOrcamentoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String idOrcamentoStr = req.getParameter("id");

        int idOrcamento = Integer.parseInt(idOrcamentoStr);

        OrcamentosDao orcamentoDao = new OrcamentosDao();

        Orcamentos orcamentos = orcamentoDao.selecionarOrcamentoPorId(idOrcamento);
        req.getSession().setAttribute("orcamentos", orcamentos);

        resp.sendRedirect(req.getContextPath() + "/adm/adm-detalhe-orcamento.jsp");
    }

}