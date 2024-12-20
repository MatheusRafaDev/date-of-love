package br.com.dateoflove.dao;

import br.com.dateoflove.model.Orcamentos;
import br.com.dateoflove.config.PoolConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrcamentosDao {

    private Connection connection;

    public OrcamentosDao(Connection connection) {
        this.connection = connection;
    }

    public OrcamentosDao() {}

    public Orcamentos criarOrcamento(Orcamentos orcamento) {
        String SQL = "INSERT INTO orcamentos (valor_medio, id_usuario, data_orcamento, observacao, " +
                "status, valor_total, local, tipo_cerimonia, forma_pagamento, vl_estimado, " +
                "observacao_geral, comentario_adicional, qtd_convidados) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = PoolConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setDouble(1, orcamento.getValorMedio());
            stmt.setLong(2, orcamento.getIdUsuario());
            stmt.setDate(3, new java.sql.Date(orcamento.getDataOrcamento().getTime()));
            stmt.setString(4, orcamento.getObservacao());
            stmt.setString(5, orcamento.getStatus());
            stmt.setDouble(6, orcamento.getValorTotal());
            stmt.setString(7, orcamento.getLocal());
            stmt.setString(8, orcamento.getTipoCerimonia());
            stmt.setString(9, orcamento.getFormaPagamento());
            stmt.setDouble(10, orcamento.getValorEstimado());
            stmt.setString(11, orcamento.getObservacaoGeral());
            stmt.setString(12, orcamento.getComentarioAdicional());
            stmt.setInt(13, orcamento.getQtdConvidados());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 1) {
                ResultSet chavesGeradas = stmt.getGeneratedKeys();
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
        } catch (Exception e) {
            System.out.println("Erro ao criar o orçamento: " + e.getMessage());
        }

        return orcamento;
    }

    public Orcamentos buscarOrcamentoPorId(Long idOrcamento) {
        String sql = "SELECT * FROM orcamentos WHERE id_orcamento = ?";
        try (Connection connection = PoolConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, idOrcamento);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Orcamentos orcamento = new Orcamentos();
                    orcamento.setIdOrcamento(rs.getInt("id_orcamento"));
                    orcamento.setIdUsuario(rs.getInt("id_usuario"));
                    orcamento.setDataOrcamento(rs.getDate("dt_orcamento"));
                    orcamento.setStatus(rs.getString("ds_status"));
                    orcamento.setObservacao(rs.getString("ds_observacao"));
                    orcamento.setObservacaoOrcador(rs.getString("ds_observacao_orcador"));
                    orcamento.setNomeOrcador(rs.getString("nm_orcador"));
                    orcamento.setValorTotal(rs.getDouble("vl_total"));
                    orcamento.setValorMedio(rs.getDouble("vl_totalmedio"));
                    orcamento.setAprovado(rs.getBoolean("tg_aprovado"));
                    orcamento.setCancelado(rs.getBoolean("tg_cancelado"));

                    // Campos adicionais
                    orcamento.setLocal(rs.getString("ds_local"));
                    orcamento.setTipoCerimonia(rs.getString("ds_tipo_cerimonia"));
                    orcamento.setFormaPagamento(rs.getString("ds_forma_pagamento"));
                    orcamento.setValorEstimado(rs.getDouble("vl_estimado"));
                    orcamento.setObservacaoGeral(rs.getString("ds_observacao_geral"));
                    orcamento.setComentarioAdicional(rs.getString("ds_comentario_adicional"));
                    orcamento.setQtdConvidados(rs.getInt("qtd_convidados"));

                    return orcamento;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar orçamento: " + e.getMessage());
        }
        return null;
    }

    public boolean atualizarOrcamento(Orcamentos orcamento) {
        String sql = "UPDATE orcamentos SET valor_medio = ?, id_usuario = ?, data_orcamento = ?, observacao = ?, " +
                "status = ?, valor_total = ?, local = ?, tipo_cerimonia = ?, forma_pagamento = ?, " +
                "vl_estimado = ?, observacao_geral = ?, comentario_adicional = ?, qtd_convidados = ? " +
                "WHERE id_orcamento = ?";
        try (Connection connection = PoolConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setDouble(1, orcamento.getValorMedio());
            stmt.setLong(2, orcamento.getIdUsuario());
            stmt.setDate(3, new java.sql.Date(orcamento.getDataOrcamento().getTime()));
            stmt.setString(4, orcamento.getObservacao());
            stmt.setString(5, orcamento.getStatus());
            stmt.setDouble(6, orcamento.getValorTotal());
            stmt.setString(7, orcamento.getLocal());
            stmt.setString(8, orcamento.getTipoCerimonia());
            stmt.setString(9, orcamento.getFormaPagamento());
            stmt.setDouble(10, orcamento.getValorEstimado());
            stmt.setString(11, orcamento.getObservacaoGeral());
            stmt.setString(12, orcamento.getComentarioAdicional());
            stmt.setInt(13, orcamento.getQtdConvidados());
            stmt.setLong(14, orcamento.getIdOrcamento());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar orçamento: " + e.getMessage());
        }
        return false;
    }

    public boolean excluirOrcamento(Long idOrcamento) {
        String sql = "DELETE FROM orcamentos WHERE id_orcamento = ?";
        try (Connection connection = PoolConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, idOrcamento);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir orçamento: " + e.getMessage());
        }
        return false;
    }

    public List<Orcamentos> listarOrcamentos() {
        List<Orcamentos> orcamentosList = new ArrayList<>();
        String sql = "SELECT * FROM orcamentos";
        try (Connection connection = PoolConfig.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Orcamentos orcamento = new Orcamentos();
                orcamento.setIdOrcamento(rs.getInt("id_orcamento"));
                orcamento.setIdUsuario(rs.getInt("id_usuario"));
                orcamento.setDataOrcamento(rs.getDate("dt_orcamento"));
                orcamento.setStatus(rs.getString("ds_status"));
                orcamento.setObservacao(rs.getString("ds_observacao"));
                orcamento.setObservacaoOrcador(rs.getString("ds_observacao_orcador"));
                orcamento.setNomeOrcador(rs.getString("nm_orcador"));
                orcamento.setValorTotal(rs.getDouble("vl_total"));
                orcamento.setValorMedio(rs.getDouble("vl_totalmedio"));
                orcamento.setAprovado(rs.getBoolean("tg_aprovado"));
                orcamento.setCancelado(rs.getBoolean("tg_cancelado"));

                // Campos adicionais
                orcamento.setLocal(rs.getString("ds_local"));
                orcamento.setTipoCerimonia(rs.getString("ds_tipo_cerimonia"));
                orcamento.setFormaPagamento(rs.getString("ds_forma_pagamento"));
                orcamento.setValorEstimado(rs.getDouble("vl_estimado"));
                orcamento.setObservacaoGeral(rs.getString("ds_observacao_geral"));
                orcamento.setComentarioAdicional(rs.getString("ds_comentario_adicional"));
                orcamento.setQtdConvidados(rs.getInt("qtd_convidados"));

                orcamentosList.add(orcamento);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar orçamentos: " + e.getMessage());
        }
        return orcamentosList;
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
                orcamento.setDataOrcamento(rs.getDate("dt_orcamento"));
                orcamento.setStatus(rs.getString("ds_status"));
                orcamento.setObservacao(rs.getString("ds_observacao"));
                orcamento.setObservacaoOrcador(rs.getString("ds_observacao_orcador"));
                orcamento.setNomeOrcador(rs.getString("nm_orcador"));
                orcamento.setValorTotal(rs.getDouble("vl_total"));
                orcamento.setValorMedio(rs.getDouble("vl_totalmedio"));
                orcamento.setAprovado(rs.getBoolean("tg_aprovado"));
                orcamento.setCancelado(rs.getBoolean("tg_cancelado"));
                orcamento.setValorEstimado(rs.getDouble("vl_estimado"));
                orcamento.setObservacaoGeral(rs.getString("ds_observacao_geral"));
                orcamento.setComentarioAdicional(rs.getString("ds_comentario_adicional"));
                orcamento.setQtdConvidados(rs.getInt("qtd_convidados"));
                listaOrcamentos.add(orcamento);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar orçamento por usuário: " + e.getMessage());
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

    public void aprovarOrcamento(int idOrcamento, int idUsuario) {
        try {
            String SQL = "UPDATE tb_orcamentos SET tg_aprovado = true, ds_status ='Aprovado' WHERE id_orcamento = ?";
            Connection connection = PoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, idOrcamento);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao aprovar orçamento: " + e.getMessage());
        }
    }

    public void cancelarOrcamento(int idOrcamento) {
        try {
            String SQL = "UPDATE tb_orcamentos SET tg_cancelado = true, ds_status ='Cancelado' WHERE id_orcamento = ?";
            Connection connection = PoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, idOrcamento);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao cancelar orçamento: " + e.getMessage());
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
                orcamento.setDataOrcamento(rs.getDate("dt_orcamento"));
                orcamento.setStatus(rs.getString("ds_status"));
                orcamento.setObservacao(rs.getString("ds_observacao"));
                orcamento.setObservacaoOrcador(rs.getString("ds_observacao_orcador"));
                orcamento.setNomeOrcador(rs.getString("nm_orcador"));
                orcamento.setValorTotal(rs.getDouble("vl_total"));
                orcamento.setValorMedio(rs.getDouble("vl_totalmedio"));
                orcamento.setAprovado(rs.getBoolean("tg_aprovado"));
                orcamento.setCancelado(rs.getBoolean("tg_cancelado"));

                // Campos adicionais
                orcamento.setLocal(rs.getString("ds_local"));
                orcamento.setTipoCerimonia(rs.getString("ds_tipo_cerimonia"));
                orcamento.setFormaPagamento(rs.getString("ds_forma_pagamento"));
                orcamento.setValorEstimado(rs.getDouble("vl_estimado"));
                orcamento.setObservacaoGeral(rs.getString("ds_observacao_geral"));
                orcamento.setComentarioAdicional(rs.getString("ds_comentario_adicional"));
                orcamento.setQtdConvidados(rs.getInt("qtd_convidados"));

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
                orcamento.setDataOrcamento(rs.getDate("dt_orcamento"));
                orcamento.setStatus(rs.getString("ds_status"));
                orcamento.setObservacao(rs.getString("ds_observacao"));
                orcamento.setObservacaoOrcador(rs.getString("ds_observacao_orcador"));
                orcamento.setNomeOrcador(rs.getString("nm_orcador"));
                orcamento.setValorTotal(rs.getDouble("vl_total"));
                orcamento.setValorMedio(rs.getDouble("vl_totalmedio"));
                orcamento.setAprovado(rs.getBoolean("tg_aprovado"));
                orcamento.setCancelado(rs.getBoolean("tg_cancelado"));

                // Campos adicionais
                orcamento.setLocal(rs.getString("ds_local"));
                orcamento.setTipoCerimonia(rs.getString("ds_tipo_cerimonia"));
                orcamento.setFormaPagamento(rs.getString("ds_forma_pagamento"));
                orcamento.setValorEstimado(rs.getDouble("vl_estimado"));
                orcamento.setObservacaoGeral(rs.getString("ds_observacao_geral"));
                orcamento.setComentarioAdicional(rs.getString("ds_comentario_adicional"));
                orcamento.setQtdConvidados(rs.getInt("qtd_convidados"));
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
