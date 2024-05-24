package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.OrcamentosDao;
import br.com.dateoflove.model.Orcamentos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/carregar-orcamento")
public class CarregarOrcamentoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OrcamentosDao OrcamentosDao = new OrcamentosDao();
        List<Orcamentos> listaOrcamentos = OrcamentosDao.selecionarTodosOrcamentos();
        req.getSession().setAttribute("listaOrcamentos", listaOrcamentos);

        req.getRequestDispatcher( "/adm/adm-orcamento.jsp").forward(req, resp);
    }
}