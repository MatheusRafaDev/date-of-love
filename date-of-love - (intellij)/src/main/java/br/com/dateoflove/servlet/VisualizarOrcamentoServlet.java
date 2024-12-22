package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.DetalheOrcamentoDao;
import br.com.dateoflove.dao.OrcamentosDao;
import br.com.dateoflove.dao.ServicoDao;

import br.com.dateoflove.model.DetalheOrcamento;
import br.com.dateoflove.model.Orcamentos;
import br.com.dateoflove.model.Servico;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import java.io.IOException;
import java.util.List;

@WebServlet("/visualizar-orcamento")
public class VisualizarOrcamentoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idString = req.getParameter("id");

        if (idString != null && idString.matches("\\d+")) {
            int id = Integer.parseInt(idString);

            ServicoDao servicoDao = new ServicoDao();
            DetalheOrcamentoDao detalheOrcamentoDao = new DetalheOrcamentoDao();
            OrcamentosDao orcamentoDao = new OrcamentosDao();


            Orcamentos orcamento = orcamentoDao.buscarOrcamentoPorId(id);
            List<DetalheOrcamento> detalheOrcamento = detalheOrcamentoDao.encontrarDetalhesOrcamentoPorIdOrcamento(id);

            List<Servico> servicos = servicoDao.buscarTodosServicos();


            if (orcamento != null) {
                req.getSession().setAttribute("orcamento", orcamento);
                req.getSession().setAttribute("detalheorcamento", detalheOrcamento);
                req.getSession().setAttribute("servicoDao", servicoDao);
                req.getSession().setAttribute("servicos", servicos);


                RequestDispatcher dispatcher = req.getRequestDispatcher("/visualizar-orcamento.jsp");
                dispatcher.forward(req, resp);
            } else {

                resp.sendRedirect(req.getContextPath() + "/erro.jsp");
            }

        } else {

            resp.sendRedirect(req.getContextPath() + "/erro.jsp");
        }
    }

}
