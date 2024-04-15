package br.com.dateoflove.dao;


import br.com.dateoflove.model.InfoCasamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InfoCasamentoDao {

    public void criarInfoCasamento(InfoCasamento infoCasamento) {
        try {
            String SQL = "INSERT INTO tb_info_casamento (id_usuario, dt_casamento, ds_localidade, nr_convidados) " +
                    "VALUES (?, ?, ?, ?)";
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, infoCasamento.getIdUsuario());
            preparedStatement.setDate(2, new java.sql.Date(infoCasamento.getDataCasamento().getTime()));
            preparedStatement.setString(3, infoCasamento.getLocalidade());
            preparedStatement.setInt(4, infoCasamento.getNumeroConvidados());

            int linhasAfetadas = preparedStatement.executeUpdate();

            if (linhasAfetadas == 1) {
                ResultSet chavesGeradas = preparedStatement.getGeneratedKeys();
                if (chavesGeradas.next()) {
                    int idInfoCasamento = chavesGeradas.getInt(1);
                    infoCasamento.setIdCasamento(idInfoCasamento);
                }
                System.out.println("Informações do casamento criadas com sucesso!");
            } else {
                System.out.println("Falha ao criar informações do casamento.");
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("Erro ao criar informações do casamento: " + e.getMessage());
        }
    }

    public List<InfoCasamento> encontrarTodosInfosCasamento() {
        try {
            String SQL = "SELECT * FROM tb_info_casamento";
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<InfoCasamento> infosCasamento = new ArrayList<>();

            while (resultSet.next()) {
                int idCasamento = resultSet.getInt("id_casamento");
                int idUsuario = resultSet.getInt("id_usuario");
                Date dataCasamento = resultSet.getDate("dt_casamento");
                String localidade = resultSet.getString("ds_localidade");
                int numeroConvidados = resultSet.getInt("nr_convidados");

                InfoCasamento infoCasamento = new InfoCasamento(idCasamento, idUsuario, dataCasamento, localidade, numeroConvidados);
                infosCasamento.add(infoCasamento);
            }

            System.out.println("Informações de casamento encontradas com sucesso!");
            return infosCasamento;
        } catch (Exception e) {
            System.out.println("Erro ao encontrar informações de casamento: " + e.getMessage());
        }
        return Collections.emptyList();
    }

    public void deletarInfoCasamentoPorId(int idCasamento) {
        try {
            String SQL = "DELETE FROM tb_info_casamento WHERE id_casamento = ?";
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, idCasamento);
            preparedStatement.execute();
            System.out.println("Informações de casamento deletadas com sucesso!");
            connection.close();
        } catch (Exception e) {
            System.out.println("Falha ao deletar informações de casamento: " + e.getMessage());
        }
    }
}

