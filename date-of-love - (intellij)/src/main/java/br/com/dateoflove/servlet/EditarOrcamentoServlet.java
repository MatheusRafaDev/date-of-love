package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.OrcamentosDao;
import br.com.dateoflove.model.DetalheOrcamento;
import br.com.dateoflove.model.Orcamentos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/editar-orcamento")
public class EditarOrcamentoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int idOrcamento = Integer.parseInt(request.getParameter("idOrcamento"));
        String nomeOrcador = request.getParameter("nomeOrcador");
        String status = request.getParameter("status");
        String valorTotal = request.getParameter("valorTotal");
        String valorEstimado = request.getParameter("valorEstimado");
        String observacao = request.getParameter("observacao");
        String observacaoOrcador = request.getParameter("observacaoOrcador");

        // Remover formatações e converter os valores para double
        String valorTotalFormatado = valorTotal.replace(".", "").replace(",", ".").replace("R$", "").trim();
        String valorEstimadoFormatado = valorEstimado.replace(".", "").replace(",", ".").replace("R$", "").trim();

        try {
            double valorTotalDouble = Double.parseDouble(valorTotalFormatado);
            double valorEstimadoDouble = Double.parseDouble(valorEstimadoFormatado);

            // Validação no lado do servidor
            if (valorTotalDouble > 1000000 || valorEstimadoDouble > 1000000) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "O valor máximo permitido é 1.000.000,00");
                return;
            }

            Orcamentos orcamento = new Orcamentos();
            orcamento.setIdOrcamento(idOrcamento);
            orcamento.setNomeOrcador(nomeOrcador);
            orcamento.setStatus(status);
            orcamento.setValorTotal(valorTotalDouble);
            orcamento.setValorEstimado(valorEstimadoDouble);
            orcamento.setObservacao(observacao);
            orcamento.setObservacaoOrcador(observacaoOrcador);

            // Atualizar o orçamento no banco de dados
            OrcamentosDao orcamentoDao = new OrcamentosDao();
            orcamentoDao.atualizarOrcamento(orcamento);

            HttpSession session = request.getSession();
            List<DetalheOrcamento> detalhes = (List<DetalheOrcamento>) session.getAttribute("detalheorcamento");

            for (DetalheOrcamento detalhe : detalhes) {
                String valor = request.getParameter("precoEditavel" + detalhe.getIdServico());
                valor = valor.replace(".", "").replace(",", ".");
                double precoEditavel = Double.parseDouble(valor);

                // Validação no lado do servidor para cada detalhe
                if (precoEditavel > 1000000) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "O valor máximo permitido é 1.000.000,00");
                    return;
                }

                detalhe.setPrecoEditavel(precoEditavel);
                orcamentoDao.atualizarDetalheOrcamento(detalhe);
            }

            response.sendRedirect(request.getContextPath() + "/carregar-orcamento");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erro na formatação dos valores.");
        }
    }
}