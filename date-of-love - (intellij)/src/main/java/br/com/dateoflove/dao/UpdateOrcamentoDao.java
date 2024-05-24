package br.com.dateoflove.dao;

import br.com.dateoflove.config.PoolConfig;
import br.com.dateoflove.model.DetalheOrcamento;
import br.com.dateoflove.model.Orcamentos;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UpdateOrcamentoDao {

    public void atualizarOrcamento(Orcamentos orcamento) {
        String sql = "UPDATE tb_orcamentos SET  vl_total = ?, ds_observacao_orcador = ?,  ds_status = ?, nm_orcador = ? WHERE id_orcamento = ?";

        try {
            Connection connection = PoolConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setDouble(1, orcamento.getValorTotal());
            stmt.setString(2, orcamento.getObservacaoOrcador());
            stmt.setString(3, orcamento.getStatus());
            stmt.setString(4, orcamento.getNomeOrcador());
            stmt.setInt(5, orcamento.getIdOrcamento());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarDetalheOrcamento(DetalheOrcamento detalhe) {
        String sql = "UPDATE tb_detalhes_orcamento SET vl_preco_editavel = ? WHERE id_detalhe_orcamento = ?";

        try {
            Connection connection = PoolConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setDouble(1, detalhe.getPrecoEditavel());
            stmt.setInt(2, detalhe.getIdDetalheOrcamento());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

