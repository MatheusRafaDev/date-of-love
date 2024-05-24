package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.UpdateOrcamentoDao;
import br.com.dateoflove.model.DetalheOrcamento;
import br.com.dateoflove.model.Orcamentos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

@WebServlet("/atualizarOrcamento")
public class AtualizarOrcamentoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int idOrcamento = Integer.parseInt(request.getParameter("idOrcamento"));

        String valorMedio = request.getParameter("valorTotal");
        String valorSemPontos = valorMedio.replaceAll("\\.", "");
        String valorFormatado = valorSemPontos.replace(",", ".");
        valorFormatado = valorFormatado.replace("R$", "");
        valorFormatado = valorFormatado.replaceAll(" ", "");
        valorFormatado = valorFormatado.trim();
        double valorTotal = Double.parseDouble(valorFormatado);



        String observacao = request.getParameter("observacoesGerais");
        String status = request.getParameter("status");
        String responsavel = request.getParameter("responsavel");

        Orcamentos orcamento = new Orcamentos();
        orcamento.setNomeOrcador(responsavel);
        orcamento.setIdOrcamento(idOrcamento);
        orcamento.setValorTotal(valorTotal);
        orcamento.setObservacaoOrcador(observacao);
        orcamento.setStatus(status);


        List<DetalheOrcamento> detalheorcamento = null;

        HttpSession session = request.getSession();
        List<DetalheOrcamento> detalhes = (List<DetalheOrcamento>) session.getAttribute("detalheorcamento");
        UpdateOrcamentoDao dao = new UpdateOrcamentoDao();

        for (DetalheOrcamento Detalhes : detalhes) {

            String valor = request.getParameter("valor-" + Detalhes.getIdServico());
            valor = valor.replace(".", "").replace(",", ".");
            double precoEditavel = Double.parseDouble(valor);

            DetalheOrcamento detalhe = new DetalheOrcamento();
            detalhe.setIdDetalheOrcamento( Detalhes.getIdDetalheOrcamento());
            detalhe.setPrecoEditavel(precoEditavel);

            dao.atualizarDetalheOrcamento(detalhe);
        }



        dao.atualizarOrcamento(orcamento);
        response.sendRedirect(request.getContextPath() + "/carregar-orcamento");
    }

}
