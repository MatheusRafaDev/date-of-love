package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.ServicoDao;
import br.com.dateoflove.model.Servico;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/editar-servico")
public class EditarServicoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());

        String idServicoStr = request.getParameter("id_servico");
        String nomeServico = request.getParameter("nm_servico");
        String descricaoComum = request.getParameter("ds_comum");
        String descricaoSimples = request.getParameter("ds_simples");
        String descricaoPremium = request.getParameter("ds_premium");
        String descricaoExclusivo = request.getParameter("ds_exclusivo");

        String valorComum = request.getParameter("vl_preco_comum");
        String valorSimples = request.getParameter("vl_preco_simples");
        String valorPremium = request.getParameter("vl_preco_premium");
        String valorExclusivo = request.getParameter("vl_preco_exclusivo");

        double precoComum = parseDoubleFromString(valorComum);
        double precoSimples = parseDoubleFromString(valorSimples);
        double precoPremium = parseDoubleFromString(valorPremium);
        double precoExclusivo = parseDoubleFromString(valorExclusivo);

        int idServico = Integer.parseInt(idServicoStr);

        Servico servico = new Servico();
        servico.setIdServico(idServico);
        servico.setNomeServico(nomeServico);
        servico.setDescricaoComum(descricaoComum);
        servico.setDescricaoSimples(descricaoSimples);
        servico.setDescricaoPremium(descricaoPremium);
        servico.setDescricaoExclusivo(descricaoExclusivo);
        servico.setPrecoComum(precoComum);
        servico.setPrecoSimples(precoSimples);
        servico.setPrecoPremium(precoPremium);
        servico.setPrecoExclusivo(precoExclusivo);

        ServicoDao servicoDao = new ServicoDao();
        servicoDao.atualizarServico(servico);

        response.sendRedirect(request.getContextPath() + "/carregar-servico");
    }

    private double parseDoubleFromString(String value) {
        if (value == null || value.isEmpty()) {
            return 0.0;
        }
        value = value.replace(".", "").replace(",", ".");
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}