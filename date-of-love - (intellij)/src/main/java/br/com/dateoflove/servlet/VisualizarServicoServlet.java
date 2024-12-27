package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.ServicoDao;
import br.com.dateoflove.model.Servico;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/visualizar-servico")
public class VisualizarServicoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idServico = request.getParameter("id");
        if (idServico == null || idServico.isEmpty()) {
            response.sendRedirect("adm/adm-servicos.jsp");
            return;
        }


        ServicoDao servicoDao = new ServicoDao();
        Servico servico = servicoDao.encontrarServicoPorId(Integer.parseInt(idServico));

        if (servico == null) {
            response.sendRedirect("adm/adm-servicos.jsp");
            return;
        }

        request.setAttribute("servico", servico);


        request.getRequestDispatcher("adm/adm-editar-servico.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}