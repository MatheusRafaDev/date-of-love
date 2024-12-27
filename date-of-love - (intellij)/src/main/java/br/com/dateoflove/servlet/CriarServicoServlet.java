package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.ServicoDao;
import br.com.dateoflove.model.Servico;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/criar-servico")
public class CriarServicoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenha os parâmetros do formulário

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String nomeServico = request.getParameter("nm_servico");
        double precoSimples = Double.parseDouble(request.getParameter("vl_preco_simples").replace(".", "").replace(",", "."));
        double precoComum = Double.parseDouble(request.getParameter("vl_preco_comum").replace(".", "").replace(",", "."));
        double precoPremium = Double.parseDouble(request.getParameter("vl_preco_premium").replace(".", "").replace(",", "."));
        double precoExclusivo = Double.parseDouble(request.getParameter("vl_preco_exclusivo").replace(".", "").replace(",", "."));
        String descricaoSimples = request.getParameter("ds_simples");
        String descricaoComum = request.getParameter("ds_comum");
        String descricaoPremium = request.getParameter("ds_premium");
        String descricaoExclusivo = request.getParameter("ds_exclusivo");

        // Crie um objeto Servico com os dados do formulário
        Servico servico = new Servico();
        servico.setNomeServico(nomeServico);
        servico.setPrecoSimples(precoSimples);
        servico.setPrecoComum(precoComum);
        servico.setPrecoPremium(precoPremium);
        servico.setPrecoExclusivo(precoExclusivo);
        servico.setDescricaoSimples(descricaoSimples);
        servico.setDescricaoComum(descricaoComum);
        servico.setDescricaoPremium(descricaoPremium);
        servico.setDescricaoExclusivo(descricaoExclusivo);

        ServicoDao servicoDao = new ServicoDao();
        servicoDao.salvarServico(servico);

        response.sendRedirect(request.getContextPath() + "/carregar-servico");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("adm/adm-criar-servico.jsp");
    }
}