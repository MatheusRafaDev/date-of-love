package br.com.dateoflove.dao;


import br.com.dateoflove.model.Casamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CasamentoDao {

    public void criarCasamento(Casamento casamento) {
        try {
            String SQL = "INSERT INTO tb_casamento (id_usuario, dt_casamento, ds_localidade, nr_convidados) " +
                    "VALUES (?, ?, ?, ?)";
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, casamento.getIdUsuario());
            preparedStatement.setDate(2, new java.sql.Date(casamento.getDataCasamento().getTime()));
            preparedStatement.setString(3, casamento.getLocalidade());
            preparedStatement.setInt(4, casamento.getNumeroConvidados());

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

    public List<Casamento> encontrarTodosCasamento() {
        try {
            String SQL = "SELECT * FROM tb_casamento";
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Casamento> infosCasamento = new ArrayList<>();

            while (resultSet.next()) {
                int idCasamento = resultSet.getInt("id_casamento");
                int idUsuario = resultSet.getInt("id_usuario");
                Date dataCasamento = resultSet.getDate("dt_casamento");
                String localidade = resultSet.getString("ds_localidade");
                int numeroConvidados = resultSet.getInt("nr_convidados");

                Casamento casamento = new Casamento(idCasamento, idUsuario, dataCasamento, localidade, numeroConvidados);
                infosCasamento.add(casamento);
            }

            System.out.println("Informações de casamento encontradas com sucesso!");
            return infosCasamento;
        } catch (Exception e) {
            System.out.println("Erro ao encontrar informações de casamento: " + e.getMessage());
        }
        return Collections.emptyList();
    }

    public void deletarCasamentoPorId(int idCasamento) {
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

