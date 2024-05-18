package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.OrcamentosDao;
import br.com.dateoflove.model.Orcamentos;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/atualizar-orcamento")
public class AtualizarOrcamentoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Receber os dados da requisição
            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader reader = request.getReader()) {
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
            }

            // Extrair os dados do objeto JSON
            JSONObject requestData = new JSONObject(stringBuilder.toString());
            int idOrcamento = requestData.optInt("idOrcamento");
            double novoValorService1 = requestData.optDouble("novoValorService1");

            // Validação dos dados
            if (idOrcamento <= 0 || Double.isNaN(novoValorService1)) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            // Atualizar o orçamento no banco de dados usando o DAO OrcamentosDao
            OrcamentosDao orcamentosDao = new OrcamentosDao();
            Orcamentos orcamento = orcamentosDao.buscarOrcamentoPorId(idOrcamento);
            if (orcamento == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            orcamento.setValorTotal(novoValorService1);
            orcamentosDao.atualizarOrcamento(orcamento);

            // Enviar uma resposta de confirmação para o frontend
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"message\": \"Orçamento atualizado com sucesso!\"}");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
