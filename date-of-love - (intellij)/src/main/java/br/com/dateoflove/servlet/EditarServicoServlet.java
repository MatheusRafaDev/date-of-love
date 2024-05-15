
package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.ServicoDao;
import br.com.dateoflove.model.Servico;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editar-servico")
public class EditarServicoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idServico = Integer.parseInt(request.getParameter("id"));
        ServicoDao servicoDao = new ServicoDao();
        Servico servico = servicoDao.encontrarServicoPorId(idServico);
        request.setAttribute("servico", servico);
        request.getRequestDispatcher("edit_servico.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idServico = Integer.parseInt(request.getParameter("id_servico"));
        String nomeServico = request.getParameter("nm_servico");
        String descricaoServico = request.getParameter("ds_servico");
        double preco = Double.parseDouble(request.getParameter("vl_preco"));

        Servico servico = new Servico();
        servico.setIdServico(idServico);
        servico.setNomeServico(nomeServico);
        servico.setObservacao(descricaoServico);
        servico.setPreco(preco);

        ServicoDao servicoDao = new ServicoDao();
        servicoDao.atualizarServico(servico);
        response.sendRedirect("adm/servicos.jsp");
    }
}
