package br.com.dateoflove.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dateoflove.dao.ServicoDao;
import br.com.dateoflove.model.Servico;

@WebServlet("/servicos")
public class ServicoServlet extends HttpServlet {

    private ServicoDao servicoDao;

    @Override
    public void init() throws ServletException {
        super.init();
        servicoDao = new ServicoDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Servico> servicos = servicoDao.encontrarTodosServicos();
        req.setAttribute("servicos", servicos);
        req.getRequestDispatcher("servicos.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "criar":
                    criarServico(req, resp);
                    break;
                case "deletar":
                    deletarServico(req, resp);
                    break;
                default:
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ação desconhecida: " + action);
            }
        }
    }

    private void criarServico(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomeProduto = req.getParameter("nome_produto");
        String tipoProduto = req.getParameter("tipo_produto");
        String descricaoProduto = req.getParameter("descricao_produto");
        String[] itensProduto = req.getParameterValues("itens_produto");
        double valorProduto = Double.parseDouble(req.getParameter("valor_produto"));

        Servico servico = new Servico(nomeProduto, tipoProduto, descricaoProduto, itensProduto, valorProduto);
        servicoDao.criarServico(servico);

        resp.sendRedirect(req.getContextPath() + "/servicos");
    }

    private void deletarServico(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomeProduto = req.getParameter("nome_produto");
        servicoDao.deletarServicoPorId(nomeProduto);

        resp.sendRedirect(req.getContextPath() + "/servicos");
    }
}
