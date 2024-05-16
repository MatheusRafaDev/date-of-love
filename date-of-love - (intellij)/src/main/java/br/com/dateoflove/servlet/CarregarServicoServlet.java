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
import java.io.IOException;
import java.util.List;

@WebServlet("/carregar-servico")
public class CarregarServicoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServicoDao servicoDao = new ServicoDao();
        List<Servico> servico = servicoDao.listarServicos();
        req.getSession().setAttribute("servico", servico);

        req.getRequestDispatcher( "/adm/adm-servicos.jsp").forward(req, resp);
    }
}
