package br.com.dateoflove.dao;

import br.com.dateoflove.model.Orcamentos;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrcamentosDao {

    public void criarOrcamento(Orcamentos orcamento) {
        try {
            String SQL = "INSERT INTO tb_orcamentos (id_usuario, id_casamento, dt_orcamento, ds_status, ds_observacao, nm_orcador) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, orcamento.getIdUsuario());
            preparedStatement.setInt(2, orcamento.getIdCasamento());
            preparedStatement.setDate(3, new java.sql.Date(orcamento.getDataOrcamento().getTime()));
            preparedStatement.setString(4, orcamento.getStatus());
            preparedStatement.setString(5, orcamento.getObservacao());
            preparedStatement.setString(6, orcamento.getNomeOrcador());

            int linhasAfetadas = preparedStatement.executeUpdate();

            if (linhasAfetadas == 1) {
                ResultSet chavesGeradas = preparedStatement.getGeneratedKeys();
                if (chavesGeradas.next()) {
                    int idOrcamento = chavesGeradas.getInt(1);
                    orcamento.setIdOrcamento(idOrcamento);
                }
                System.out.println("Orçamento criado com sucesso!");
            } else {
                System.out.println("Falha ao criar o orçamento.");
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("Erro ao criar o orçamento: " + e.getMessage());
        }
    }

    public List<Orcamentos> encontrarTodosOrcamentos() {
        try {
            String SQL = "SELECT * FROM tb_orcamentos";
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Orcamentos> orcamentos = new ArrayList<>();

            while (resultSet.next()) {
                int idOrcamento = resultSet.getInt("id_orcamento");
                int idUsuario = resultSet.getInt("id_usuario");
                int idCasamento = resultSet.getInt("id_casamento");
                java.util.Date dataOrcamento = resultSet.getDate("dt_orcamento");
                String status = resultSet.getString("ds_status");
                String observacao = resultSet.getString("ds_observacao");
                String nomeOrcador = resultSet.getString("nm_orcador");

                Orcamentos orcamento = new Orcamentos(idOrcamento, idUsuario, idCasamento, dataOrcamento, status, observacao, nomeOrcador);
                orcamentos.add(orcamento);
            }

            System.out.println("Orçamentos encontrados com sucesso!");
            return orcamentos;
        } catch (Exception e) {
            System.out.println("Erro ao encontrar orçamentos: " + e.getMessage());
        }
        return Collections.emptyList();
    }

    public void deletarOrcamentoPorId(int idOrcamento) {
        try {
            String SQL = "DELETE FROM tb_orcamentos WHERE id_orcamento = ?";
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, idOrcamento);
            preparedStatement.execute();
            System.out.println("Orçamento deletado com sucesso!");
            connection.close();
        } catch (Exception e) {
            System.out.println("Falha ao deletar o orçamento: " + e.getMessage());
        }
    }

    public Orcamentos buscarOrcamentoPorUsuario(int idUsuario) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Orcamentos orcamento = null;

        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            String query = "SELECT * FROM tb_orcamentos WHERE id_usuario = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, idUsuario);
            rs = stmt.executeQuery();

            if (rs.next()) {
                orcamento = new Orcamentos();
                orcamento.setIdOrcamento(rs.getInt("id_orcamento"));
                orcamento.setIdUsuario(rs.getInt("id_usuario"));
                orcamento.setIdCasamento(rs.getInt("id_casamento"));
                orcamento.setDataOrcamento(rs.getDate("dt_orcamento"));
                orcamento.setStatus(rs.getString("ds_status"));
                orcamento.setObservacao(rs.getString("ds_observacao"));
                orcamento.setNomeOrcador(rs.getString("nm_orcador"));

                System.out.println("Orçamento encontrado: " + orcamento.getIdOrcamento());
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar orçamento por usuário: " + e.getMessage());
        }
        return orcamento;
    }

    public boolean existeOrcamentoPorUsuario(int idUsuario) {
        String sql = "SELECT COUNT(*) FROM tb_orcamentos WHERE id_usuario = ?";
        PreparedStatement stmt = null;

        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar a existência do orçamento por usuário", e);
        }
        return false;
    }
}