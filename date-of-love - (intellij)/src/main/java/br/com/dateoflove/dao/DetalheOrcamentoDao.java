package br.com.dateoflove.dao;

import br.com.dateoflove.model.DetalheOrcamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DetalheOrcamentoDao {

    public void criarDetalheOrcamento(DetalheOrcamento detalheOrcamento) {
        try {
            String SQL = "INSERT INTO tb_detalhe_orcamento (id_orcamento, id_servico, quantidade, preco, observacao_servico) " +
                    "VALUES (?, ?, ?, ?, ?)";
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, detalheOrcamento.getIdOrcamento());
            preparedStatement.setInt(2, detalheOrcamento.getIdServico());
            preparedStatement.setInt(3, detalheOrcamento.getQuantidade());
            preparedStatement.setDouble(4, detalheOrcamento.getPreco());
            preparedStatement.setString(5, detalheOrcamento.getObservacaoServico());

            int linhasAfetadas = preparedStatement.executeUpdate();

            if (linhasAfetadas == 1) {
                ResultSet chavesGeradas = preparedStatement.getGeneratedKeys();
                if (chavesGeradas.next()) {
                    int idDetalheOrcamento = chavesGeradas.getInt(1);
                    detalheOrcamento.setIdDetalheOrcamento(idDetalheOrcamento);
                }
                System.out.println("Detalhe do orçamento criado com sucesso!");
            } else {
                System.out.println("Falha ao criar detalhe do orçamento.");
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("Erro ao criar detalhe do orçamento: " + e.getMessage());
        }
    }

    public List<DetalheOrcamento> encontrarTodosDetalhesOrcamento() {
        try {
            String SQL = "SELECT * FROM tb_detalhe_orcamento";
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<DetalheOrcamento> detalhesOrcamento = new ArrayList<>();

            while (resultSet.next()) {
                int idDetalheOrcamento = resultSet.getInt("id_detalhe_orcamento");
                int idOrcamento = resultSet.getInt("id_orcamento");
                int idServico = resultSet.getInt("id_servico");
                int quantidade = resultSet.getInt("quantidade");
                double preco = resultSet.getDouble("preco");
                String observacaoServico = resultSet.getString("observacao_servico");

                DetalheOrcamento detalheOrcamento = new DetalheOrcamento(idDetalheOrcamento, idOrcamento, idServico, quantidade, preco, observacaoServico);
                detalhesOrcamento.add(detalheOrcamento);
            }

            System.out.println("Detalhes do orçamento encontrados com sucesso!");
            return detalhesOrcamento;
        } catch (Exception e) {
            System.out.println("Erro ao encontrar detalhes do orçamento: " + e.getMessage());
        }
        return Collections.emptyList();
    }

    public void deletarDetalheOrcamentoPorId(int idDetalheOrcamento) {
        try {
            String SQL = "DELETE FROM tb_detalhe_orcamento WHERE id_detalhe_orcamento = ?";
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, idDetalheOrcamento);
            preparedStatement.execute();
            System.out.println("Detalhe do orçamento deletado com sucesso!");
            connection.close();
        } catch (Exception e) {
            System.out.println("Falha ao deletar detalhe do orçamento: " + e.getMessage());
        }
    }
}
