package br.com.dateoflove.dao;

import br.com.dateoflove.model.Servico;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import br.com.dateoflove.config.PoolConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServicoDao {

    public Servico encontrarServicoPorId(int id) {
        Servico servico = null;
        String query = "SELECT * FROM tb_servicos WHERE id_servico = ?";

        try (Connection connection = PoolConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    servico = new Servico();
                    servico.setIdServico(rs.getInt("id_servico"));
                    servico.setNomeServico(rs.getString("nm_servico"));
                    servico.setPreco(rs.getDouble("vl_preco"));
                    servico.setObservacao(rs.getString("ds_servico"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Trate a exceção de acordo com a necessidade do seu aplicativo
        }
        return servico;
    }

    public List<Servico> listarServicos() {
        List<Servico> servicos = new ArrayList<>();
        String query = "SELECT * FROM tb_servicos";

        try (Connection connection = PoolConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Servico servico = new Servico();
                servico.setIdServico(rs.getInt("id_servico"));
                servico.setNomeServico(rs.getString("nm_servico"));
                servico.setPreco(rs.getDouble("vl_preco"));
                servico.setObservacao(rs.getString("ds_servico"));
                servicos.add(servico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Trate a exceção de acordo com a necessidade do seu aplicativo
        }

        return servicos;
    }

    public void atualizarServico(Servico servico) {
        String query = "UPDATE tb_servicos SET nm_servico = ?, ds_servico = ?, vl_preco = ? WHERE id_servico = ?";

        try (Connection connection = PoolConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, servico.getNomeServico());
            ps.setString(2, servico.getObservacao());
            ps.setDouble(3, servico.getPreco());
            ps.setInt(4, servico.getIdServico());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}

