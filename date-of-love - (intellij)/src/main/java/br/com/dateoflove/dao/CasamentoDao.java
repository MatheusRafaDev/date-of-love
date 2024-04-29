package br.com.dateoflove.dao;


import br.com.dateoflove.model.Casamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CasamentoDao {

        public void criarCasamento(Casamento casamento) {
            try {
                String SQL = "INSERT INTO tb_casamento (id_usuario, dt_casamento, ds_localidade, nr_convidados, ds_estilo_festa) " +
                        "VALUES (?, ?, ?, ?, ?)";
                Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
                PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

                preparedStatement.setInt(1, casamento.getIdUsuario());
                preparedStatement.setDate(2, new java.sql.Date(casamento.getDataCasamento().getTime()));
                preparedStatement.setString(3, casamento.getLocalidade());
                preparedStatement.setInt(4, casamento.getNumeroConvidados());
                preparedStatement.setString(5, casamento.getEstiloFesta());

                int linhasAfetadas = preparedStatement.executeUpdate();

                if (linhasAfetadas == 1) {
                    ResultSet chavesGeradas = preparedStatement.getGeneratedKeys();
                    if (chavesGeradas.next()) {
                        int idInfoCasamento = chavesGeradas.getInt(1);
                        casamento.setIdCasamento(idInfoCasamento);
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

        public Casamento encontrarCasamentoPorIdUsuario(int idUsuario) {
            try {
                String SQL = "SELECT * FROM tb_casamento WHERE id_usuario = ?";
                Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setInt(1, idUsuario);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    int idCasamento = resultSet.getInt("id_casamento");
                    Date dataCasamento = resultSet.getDate("dt_casamento");
                    String localidade = resultSet.getString("ds_localidade");
                    String estilo = resultSet.getString("ds_estilo_festa");
                    int numeroConvidados = resultSet.getInt("nr_convidados");

                    Casamento casamento = new Casamento(idCasamento, idUsuario, dataCasamento, localidade, numeroConvidados,estilo);

                    return casamento;
                } else {

                }
            } catch (Exception e) {
                System.out.println("Erro ao encontrar casamento por ID de usuário: " + e.getMessage());
            }
            return null;
        }

}

