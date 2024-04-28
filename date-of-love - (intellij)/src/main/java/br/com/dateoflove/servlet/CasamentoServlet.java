import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dateoflove.dao.CasamentoDao;
import br.com.dateoflove.model.Casamento;

@WebServlet("/casamento")
public class CasamentoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CasamentoDao casamentoDao;

    public void init() {
        casamentoDao = new CasamentoDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("id_usuario"));
        Date dataCasamento = new Date();
        String localidade = request.getParameter("localidade");
        int numeroConvidados = Integer.parseInt(request.getParameter("numero_convidados"));

        Casamento casamento = new Casamento(0, idUsuario, dataCasamento, localidade, numeroConvidados);
        casamentoDao.criarCasamento(casamento);
        response.sendRedirect(request.getContextPath() + "/casamento");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Casamento> casamentos = casamentoDao.encontrarTodosCasamento();
        request.setAttribute("casamentos", casamentos);
        request.getRequestDispatcher("/listarCasamentos.jsp").forward(request, response);
    }


}
