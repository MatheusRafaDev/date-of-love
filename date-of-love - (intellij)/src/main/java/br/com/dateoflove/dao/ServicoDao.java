package br.com.dateoflove.dao;

import br.com.dateoflove.model.Servico;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServicoDao {

    public Servico encontrarServicoPorId(int id) {
        Servico servico = null;
        try {
            String query = "SELECT * FROM tb_servicos WHERE id_servico = ?";
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                servico = new Servico();
                servico.setIdServico(rs.getInt("id_servico"));
                servico.setNomeServico(rs.getString("nm_servico"));
                servico.setPreco(rs.getDouble("vl_preco"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return servico;
    }
}
