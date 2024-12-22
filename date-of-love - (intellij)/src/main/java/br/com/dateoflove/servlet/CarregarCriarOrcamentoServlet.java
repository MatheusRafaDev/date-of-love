package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.ServicoDao;
import br.com.dateoflove.model.Servico;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/carregar-criar-orcamento")
public class CarregarCriarOrcamentoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServicoDao servicoDao = new ServicoDao();
        List<Servico> servicos = servicoDao.buscarTodosServicos();
        request.setAttribute("servicos", servicos);
        request.getRequestDispatcher("/criar-orcamento.jsp").forward(request, response);
    }
}