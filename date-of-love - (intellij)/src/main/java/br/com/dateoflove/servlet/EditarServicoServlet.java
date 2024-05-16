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
        // Set request encoding to UTF-8
        request.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());

        String idServicoStr = request.getParameter("id_servico");
        String nomeServico = request.getParameter("nm_servico");
        String descricaoServico = request.getParameter("ds_servico");
        String precoStr = request.getParameter("vl_preco");

        // Parse the ID and price
        int idServico = Integer.parseInt(idServicoStr);
        double preco = Double.parseDouble(precoStr);

        // Update the service
        Servico servico = new Servico();
        servico.setIdServico(idServico);
        servico.setNomeServico(nomeServico);
        servico.setObservacao(descricaoServico);
        servico.setPreco(preco);

        ServicoDao servicoDao = new ServicoDao();
        servicoDao.atualizarServico(servico);

        // Redirect to a confirmation page or back to the list
        response.sendRedirect(request.getContextPath() + "/carregar-servico");
    }
}
