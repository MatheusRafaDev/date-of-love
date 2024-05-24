package br.com.dateoflove.dao;

import br.com.dateoflove.model.Orcamentos;
import br.com.dateoflove.funcao.Email;
import br.com.dateoflove.model.Usuario;
import br.com.dateoflove.config.PoolConfig;
import com.sun.jndi.ldap.pool.Pool;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class OrcamentosDao {

    public Orcamentos criarOrcamento(Orcamentos orcamento) {
        try {

            String SQL = "INSERT INTO tb_orcamentos (id_usuario, id_casamento, dt_orcamento, ds_status, ds_observacao, nm_orcador, vl_total, tg_aprovado, ds_observacao_orcador,vl_totalmedio,tg_cancelado) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection connection = PoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, orcamento.getIdUsuario());
            preparedStatement.setInt(2, orcamento.getIdCasamento());
            preparedStatement.setDate(3, new java.sql.Date(orcamento.getDataOrcamento().getTime()));
            preparedStatement.setString(4, orcamento.getStatus());
            preparedStatement.setString(5, orcamento.getObservacao());
            preparedStatement.setString(6, orcamento.getNomeOrcador());
            preparedStatement.setDouble(7, orcamento.getValorTotal());
            preparedStatement.setBoolean(8, false);
            preparedStatement.setString(9, orcamento.getObservacaoOrcador());
            preparedStatement.setDouble(10, orcamento.getValorMedio());
            preparedStatement.setBoolean(11, false);

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
            Connection connection = PoolConfig.getConnection();
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
            String SQL = "UPDATE tb_orcamentos SET id_usuario = ?, id_casamento = ?, dt_orcamento = ?, ds_status = ?, ds_observacao = ?, nm_orcador = ?, vl_total = ?  WHERE id_orcamento = ?";
            Connection connection = PoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, orcamento.getIdUsuario());
            preparedStatement.setInt(2, orcamento.getIdCasamento());
            preparedStatement.setDate(3, new java.sql.Date(orcamento.getDataOrcamento().getTime()));
            preparedStatement.setString(4, orcamento.getStatus());
            preparedStatement.setString(5, orcamento.getObservacao());
            preparedStatement.setString(6, orcamento.getNomeOrcador());
            preparedStatement.setDouble(7, orcamento.getValorTotal());
            preparedStatement.setDouble(8, orcamento.getValorMedio());
            preparedStatement.setInt(9, orcamento.getIdOrcamento());

            int linhasAfetadas = preparedStatement.executeUpdate();

            if (linhasAfetadas == 1) {
                System.out.println("Orçamento atualizado com sucesso!");
            } else {
                System.out.println("Falha ao atualizar o orçamento.");
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o orçamento: " + e.getMessage());
        }
    }

    public List<Orcamentos> buscarOrcamentoPorUsuario(int idUsuario) {
        List<Orcamentos> listaOrcamentos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Connection connection = PoolConfig.getConnection();
            String query = "SELECT * FROM tb_orcamentos WHERE id_usuario = ?";
            stmt = connection.prepareStatement(query);
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
                orcamento.setObservacaoOrcador(rs.getString("ds_observacao_orcador"));
                orcamento.setNomeOrcador(rs.getString("nm_orcador"));
                orcamento.setValorTotal(rs.getDouble("vl_total"));
                orcamento.setValorMedio(rs.getDouble("vl_totalmedio"));
                orcamento.setAprovado(rs.getBoolean("tg_aprovado"));
                orcamento.setCancelado(rs.getBoolean("tg_cancelado"));
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
            Connection connection = PoolConfig.getConnection();
            stmt = connection.prepareStatement(sql);
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
            Connection connection = PoolConfig.getConnection();
            String query = "SELECT * FROM tb_orcamentos WHERE id_orcamento = ?";
            stmt = connection .prepareStatement(query);
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
                orcamento.setObservacaoOrcador(rs.getString("ds_observacao_orcador"));
                orcamento.setNomeOrcador(rs.getString("nm_orcador"));
                orcamento.setValorTotal(rs.getDouble("vl_total"));
                orcamento.setValorMedio(rs.getDouble("vl_totalmedio"));
                orcamento.setAprovado(rs.getBoolean("tg_aprovado"));
                orcamento.setCancelado(rs.getBoolean("tg_cancelado"));

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

    public void aprovarOrcamento(int idOrcamento,int idUsuario) {
        try {

            String SQL = "UPDATE tb_orcamentos SET tg_aprovado = true,ds_status ='Aprovado' WHERE id_orcamento = ?";

            Connection connection = PoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, idOrcamento);

            int linhasAfetadas = preparedStatement.executeUpdate();
            if (linhasAfetadas == 1) {
                System.out.println("Orçamento aprovado com sucesso!");
            } else {
                System.out.println("Falha ao aprovar o orçamento.");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao aprovar o orçamento: " + e.getMessage());
        }
    }

    public void CancelarOrcamento(int idOrcamento,int idUsuario) {
        try {

            String SQL = "UPDATE tb_orcamentos SET tg_cancelado = true,ds_status ='Cancelado' WHERE id_orcamento = ?";

            Connection connection = PoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, idOrcamento);

            int linhasAfetadas = preparedStatement.executeUpdate();
            if (linhasAfetadas == 1) {
                System.out.println("Orçamento cancelado com sucesso!");
            } else {
                System.out.println("Falha ao cancelar o orçamento.");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao cancelar o orçamento: " + e.getMessage());
        }
    }

    public List<Orcamentos> selecionarTodosOrcamentos() {
        List<Orcamentos> listaOrcamentos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Connection connection = PoolConfig.getConnection();
            String query = "SELECT * FROM tb_orcamentos";
            stmt = connection.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Orcamentos orcamento = new Orcamentos();
                orcamento.setIdOrcamento(rs.getInt("id_orcamento"));
                orcamento.setIdUsuario(rs.getInt("id_usuario"));
                orcamento.setIdCasamento(rs.getInt("id_casamento"));
                orcamento.setDataOrcamento(rs.getDate("dt_orcamento"));
                orcamento.setStatus(rs.getString("ds_status"));
                orcamento.setObservacao(rs.getString("ds_observacao"));
                orcamento.setObservacaoOrcador(rs.getString("ds_observacao_orcador"));
                orcamento.setNomeOrcador(rs.getString("nm_orcador"));
                orcamento.setValorTotal(rs.getDouble("vl_total"));
                orcamento.setValorMedio(rs.getDouble("vl_totalmedio"));
                orcamento.setAprovado(rs.getBoolean("tg_aprovado"));
                orcamento.setCancelado(rs.getBoolean("tg_cancelado"));
                listaOrcamentos.add(orcamento);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar todos os orçamentos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar os recursos de banco de dados: " + e.getMessage());
            }
        }
        return listaOrcamentos;
    }

    public Orcamentos selecionarOrcamentoPorId(int idOrcamento) {
        Orcamentos orcamento = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Connection connection = PoolConfig.getConnection();
            String query = "SELECT * FROM tb_orcamentos WHERE id_orcamento = ?";
            stmt = connection.prepareStatement(query);
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
                orcamento.setObservacaoOrcador(rs.getString("ds_observacao_orcador"));
                orcamento.setNomeOrcador(rs.getString("nm_orcador"));
                orcamento.setValorTotal(rs.getDouble("vl_total"));
                orcamento.setValorMedio(rs.getDouble("vl_totalmedio"));
                orcamento.setAprovado(rs.getBoolean("tg_aprovado"));
                orcamento.setCancelado(rs.getBoolean("tg_cancelado"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar o orçamento por ID: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar os recursos de banco de dados: " + e.getMessage());
            }
        }
        return orcamento;
    }

}