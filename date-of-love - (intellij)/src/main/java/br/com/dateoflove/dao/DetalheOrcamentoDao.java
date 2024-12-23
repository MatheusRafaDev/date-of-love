package br.com.dateoflove.dao;

import br.com.dateoflove.config.PoolConfig;
import br.com.dateoflove.model.DetalheOrcamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DetalheOrcamentoDao {

    public void criarDetalheOrcamento(DetalheOrcamento detalheOrcamento) {
        try {
            String SQL = "INSERT INTO tb_detalhes_orcamento (id_orcamento, id_servico, nr_quantidade, vl_preco_editavel, ds_observacao_servico, tg_tipo) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            Connection connection = PoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, detalheOrcamento.getIdOrcamento());
            preparedStatement.setInt(2, detalheOrcamento.getIdServico());
            preparedStatement.setInt(3, detalheOrcamento.getQuantidade());
            preparedStatement.setDouble(4, detalheOrcamento.getPrecoEditavel());
            preparedStatement.setString(5, detalheOrcamento.getObservacaoServico());
            preparedStatement.setString(6, String.valueOf(detalheOrcamento.getTipo()));

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
            String SQL = "SELECT * FROM tb_detalhes_orcamento";
            Connection connection = PoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<DetalheOrcamento> detalhesOrcamento = new ArrayList<>();

            while (resultSet.next()) {
                int idDetalheOrcamento = resultSet.getInt("id_detalhe_orcamento");
                int idOrcamento = resultSet.getInt("id_orcamento");
                int idServico = resultSet.getInt("id_servico");
                int quantidade = resultSet.getInt("nr_quantidade");
                double preco = resultSet.getDouble("vl_preco_editavel");
                String observacaoServico = resultSet.getString("ds_observacao_servico");
                char tipo = resultSet.getString("tg_tipo").charAt(0);

                DetalheOrcamento detalheOrcamento = new DetalheOrcamento(idDetalheOrcamento, idOrcamento, idServico, quantidade, preco, observacaoServico, tipo);
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
            String SQL = "DELETE FROM tb_detalhes_orcamento WHERE id_detalhe_orcamento = ?";
            Connection connection = PoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, idDetalheOrcamento);
            preparedStatement.execute();
            System.out.println("Detalhe do orçamento deletado com sucesso!");
            connection.close();
        } catch (Exception e) {
            System.out.println("Falha ao deletar detalhe do orçamento: " + e.getMessage());
        }
    }

    public List<DetalheOrcamento> encontrarDetalhesOrcamentoPorIdOrcamento(int idOrcamento) {
        List<DetalheOrcamento> detalhesOrcamento = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM tb_detalhes_orcamento WHERE id_orcamento = ?";
            Connection connection = PoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, idOrcamento);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idDetalheOrcamento = resultSet.getInt("id_detalhe_orcamento");
                int idServico = resultSet.getInt("id_servico");
                int quantidade = resultSet.getInt("nr_quantidade");
                double preco = resultSet.getDouble("vl_preco_editavel");
                String observacaoServico = resultSet.getString("ds_observacao_servico");
                char tipo = resultSet.getString("tg_tipo").charAt(0);

                DetalheOrcamento detalheOrcamento = new DetalheOrcamento(idDetalheOrcamento, idOrcamento, idServico, quantidade, preco, observacaoServico, tipo);
                detalhesOrcamento.add(detalheOrcamento);
            }

        } catch (Exception e) {
            System.out.println("Erro ao encontrar detalhes do orçamento: " + e.getMessage());
        }
        return detalhesOrcamento;
    }
}