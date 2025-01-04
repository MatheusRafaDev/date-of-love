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
    private static final double MAX_TOTAL_VAL = 500000.00; // Limite de R$ 500.000,00 para o valor total
    private static final double MAX_SERVICE_VAL = 50000.00; // Limite de R$ 50.000,00 para cada serviço

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
        String desconto = request.getParameter("desconto");

        double valorTotalDouble = formatarValorParaDouble(valorTotal);
        double valorEstimadoDouble = formatarValorParaDouble(valorEstimado);

        // Verificação de limite para valor total
        if (valorTotalDouble > MAX_TOTAL_VAL) {
            valorTotalDouble = MAX_TOTAL_VAL;
        }

        Orcamentos orcamento = new Orcamentos();
        orcamento.setIdOrcamento(idOrcamento);
        orcamento.setNomeOrcador(nomeOrcador);
        orcamento.setStatus(status);
        orcamento.setValorTotal(valorTotalDouble);
        orcamento.setValorEstimado(valorEstimadoDouble);
        orcamento.setObservacao(observacao);
        orcamento.setObservacaoOrcador(observacaoOrcador);
        orcamento.setPorcentagemDesconto(Integer.parseInt(desconto));

        OrcamentosDao orcamentoDao = new OrcamentosDao();
        orcamentoDao.atualizarOrcamento(orcamento);

        HttpSession session = request.getSession();
        List<DetalheOrcamento> detalhes = (List<DetalheOrcamento>) session.getAttribute("detalheorcamento");

        for (DetalheOrcamento detalhe : detalhes) {
            String valor = request.getParameter("precoEditavel" + detalhe.getIdServico());
            double precoEditavel = formatarValorParaDouble(valor);


            if (precoEditavel > MAX_SERVICE_VAL) {
                precoEditavel = MAX_SERVICE_VAL;
            }

            String observacaoServico = request.getParameter("observacaoServico" + detalhe.getIdServico());

            detalhe.setPrecoEditavel(precoEditavel);
            detalhe.setObservacaoServico(observacaoServico);
            orcamentoDao.atualizarDetalheOrcamento(detalhe);
        }

        response.sendRedirect(request.getContextPath() + "/carregar-orcamento");
    }

    private double formatarValorParaDouble(String valor) {
        if (valor == null || valor.isEmpty()) {
            return 0.0;
        }

        String valorFormatado = valor.replace(".", "").replace(",", ".").replace("R$", "").trim();

        if (valorFormatado.indexOf('.') != valorFormatado.lastIndexOf('.')) {
            valorFormatado = valorFormatado.replaceAll("\\.(?=.*\\.)", "");
        }

        try {
            return Double.parseDouble(valorFormatado);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}