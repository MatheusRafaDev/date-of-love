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
        String descricaoServico = request.getParameter("ds_servico");

        String valor= request.getParameter("vl_preco");
        valor = valor.replace(".", "").replace(",", ".");
        double preco = Double.parseDouble(valor);

        int idServico = Integer.parseInt(idServicoStr);

        Servico servico = new Servico();
        servico.setIdServico(idServico);
        servico.setNomeServico(nomeServico);
        servico.setObservacao(descricaoServico);
        servico.setPreco(preco);

        ServicoDao servicoDao = new ServicoDao();
        servicoDao.atualizarServico(servico);

        response.sendRedirect(request.getContextPath() + "/carregar-servico");
    }
}
