package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.DetalheOrcamentoDao;
import br.com.dateoflove.model.DetalheOrcamento;
import br.com.dateoflove.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/criar-orcamento")
public class CriarOrcamentoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //HttpSession session = request.getSession();
       // Usuario usuario = (Usuario) session.getAttribute("usuario");

        System.out.println("teste");

        String servico1 = request.getParameter("servico1");
        System.out.println(servico1);

        String servico2 = request.getParameter("servico2");
        System.out.println(servico2);

        String servico3 = request.getParameter("servico3");
        System.out.println(servico3);

        String servico4 = request.getParameter("servico4");
        System.out.println(servico4);

        String servico5 = request.getParameter("servico5");
        System.out.println(servico5);


        DetalheOrcamento detalheOrcamento = new DetalheOrcamento();
        //detalheOrcamento.setIdOrcamento(idOrcamento);
        //detalheOrcamento.setIdServico(idServico);
        //detalheOrcamento.setQuantidade(quantidade);
        //detalheOrcamento.setPrecoEditavel(precoEditavel);
        //detalheOrcamento.setObservacaoServico(observacaoServico);
        //detalheOrcamento.setCompleto(completo);

        DetalheOrcamentoDao detalheOrcamentoDAO = new DetalheOrcamentoDao();
        detalheOrcamentoDAO.criarDetalheOrcamento(detalheOrcamento);

        response.sendRedirect(request.getContextPath() + "/orcamento-criado.jsp");
    }

}
