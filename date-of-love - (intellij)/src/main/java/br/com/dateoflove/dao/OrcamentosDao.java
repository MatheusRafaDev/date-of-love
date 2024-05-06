package br.com.dateoflove.dao;

import br.com.dateoflove.model.Orcamentos;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrcamentosDao {

    public Orcamentos criarOrcamento(Orcamentos orcamento) {
        try {
            String SQL = "INSERT INTO tb_orcamentos (id_usuario, id_casamento, dt_orcamento, ds_status, ds_observacao, nm_orcador, vl_total) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, orcamento.getIdUsuario());
            preparedStatement.setInt(2, orcamento.getIdCasamento());
            preparedStatement.setDate(3, new java.sql.Date(orcamento.getDataOrcamento().getTime()));
            preparedStatement.setString(4, orcamento.getStatus());
            preparedStatement.setString(5, orcamento.getObservacao());
            preparedStatement.setString(6, orcamento.getNomeOrcador());
            preparedStatement.setDouble(7, orcamento.getValorTotal());

            int linhasAfetadas = preparedStatement.executeUpdate();

            if (linhasAfetadas == 1) {
                ResultSet chavesGeradas = preparedStatement.getGeneratedKeys();
                if (chavesGeradas.next()) {
                    int idOrcamento = chavesGeradas.getInt(1);
                    orcamento.setIdOrcamento(idOrcamento);
                    System.out.println("Orçamento criado com sucesso! ID: " + idOrcamento);
                } else {
                    System.out.println("Falha ao obter o ID do orçamento criado.");
                }
            } else {
                System.out.println("Falha ao criar o orçamento.");
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("Erro ao criar o orçamento: " + e.getMessage());
        }

        return orcamento;
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

    public void atualizarOrcamento(Orcamentos orcamento) {
        try {
            String SQL = "UPDATE tb_orcamentos SET id_usuario = ?, id_casamento = ?, dt_orcamento = ?, ds_status = ?, ds_observacao = ?, nm_orcador = ? WHERE id_orcamento = ?";
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, orcamento.getIdUsuario());
            preparedStatement.setInt(2, orcamento.getIdCasamento());
            preparedStatement.setDate(3, new java.sql.Date(orcamento.getDataOrcamento().getTime()));
            preparedStatement.setString(4, orcamento.getStatus());
            preparedStatement.setString(5, orcamento.getObservacao());
            preparedStatement.setString(6, orcamento.getNomeOrcador());
            preparedStatement.setInt(7, orcamento.getIdOrcamento());

            int linhasAfetadas = preparedStatement.executeUpdate();

            if (linhasAfetadas == 1) {
                System.out.println("Orçamento atualizado com sucesso!");
            } else {
                System.out.println("Falha ao atualizar o orçamento.");
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o orçamento: " + e.getMessage());
        }
    }

    public List<Orcamentos> buscarOrcamentoPorUsuario(int idUsuario) {
        List<Orcamentos> listaOrcamentos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            String query = "SELECT * FROM tb_orcamentos WHERE id_usuario = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, idUsuario);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Orcamentos orcamento = new Orcamentos();
                orcamento.setIdOrcamento(rs.getInt("id_orcamento"));
                orcamento.setIdUsuario(rs.getInt("id_usuario"));
                orcamento.setIdCasamento(rs.getInt("id_casamento"));
                orcamento.setDataOrcamento(rs.getDate("dt_orcamento"));
                orcamento.setStatus(rs.getString("ds_status"));
                orcamento.setObservacao(rs.getString("ds_observacao"));
                orcamento.setNomeOrcador(rs.getString("nm_orcador"));
                orcamento.setValorTotal(rs.getDouble("vl_total"));

                listaOrcamentos.add(orcamento);
            }
        } catch (SQLException e) {

        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {

            }
        }
        return listaOrcamentos;
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

    public Orcamentos buscarOrcamentoPorId(int idOrcamento) {
        Orcamentos orcamento = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            String query = "SELECT * FROM tb_orcamentos WHERE id_orcamento = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, idOrcamento);
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
                orcamento.setValorTotal(rs.getDouble("vl_total"));

            }
        } catch (SQLException e) {

        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
            }
        }
        return orcamento;
    }

}