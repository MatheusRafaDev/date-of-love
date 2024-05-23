package br.com.dateoflove.dao;

import java.util.Date;
import br.com.dateoflove.config.PoolConfig;
import br.com.dateoflove.model.Casamento;
import org.apache.commons.pool2.impl.BaseObjectPoolConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CasamentoDao {

    public Casamento criarCasamento(Casamento casamento) {
        try {
            String SQL = "INSERT INTO tb_casamento (id_usuario, dt_casamento, ds_localidade, nr_convidados, ds_estilo_festa) " +
                    "VALUES (?, ?, ?, ?, ?)";

            Connection connection = PoolConfig.getConnection();

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

            return casamento;
        } catch (Exception e) {
            System.out.println("Erro ao criar informações do casamento: " + e.getMessage());
            return null;
        }
    }

    public Casamento encontrarCasamentoPorIdUsuario(int idUsuario) {
            try {
                String SQL = "SELECT * FROM tb_casamento WHERE id_usuario = ?";
                Connection connection = PoolConfig.getConnection();
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

    public void atualizarCasamentoParcial(Casamento casamentoAtual, Casamento casamentoNovo) throws SQLException {
        StringBuilder sql = new StringBuilder("UPDATE tb_casamento SET ");
        boolean needsUpdate = false;

        if (casamentoNovo.getDataCasamento() != null && !casamentoNovo.getDataCasamento().equals(casamentoAtual.getDataCasamento())) {
            sql.append("dt_casamento = ?, ");
            needsUpdate = true;
        }
        if (casamentoNovo.getLocalidade() != null && !casamentoNovo.getLocalidade().equals(casamentoAtual.getLocalidade())) {
            sql.append("ds_localidade = ?, ");
            needsUpdate = true;
        }
        if (casamentoNovo.getNumeroConvidados() != 0 && casamentoNovo.getNumeroConvidados() != casamentoAtual.getNumeroConvidados()) {
            sql.append("nr_convidados = ?, ");
            needsUpdate = true;
        }
        if (casamentoNovo.getEstiloFesta() != null && !casamentoNovo.getEstiloFesta().equals(casamentoAtual.getEstiloFesta())) {
            sql.append("ds_estilo_festa = ?, ");
            needsUpdate = true;
        }

        if (needsUpdate) {
            sql.setLength(sql.length() - 2);
            sql.append(" WHERE id_casamento = " + casamentoAtual.getIdCasamento());

            try (Connection conn = PoolConfig.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

                int index = 1;

                if (casamentoNovo.getDataCasamento() != null && !casamentoNovo.getDataCasamento().equals(casamentoAtual.getDataCasamento())) {
                    stmt.setDate(index++, (java.sql.Date) casamentoNovo.getDataCasamento());
                }
                if (casamentoNovo.getLocalidade() != null && !casamentoNovo.getLocalidade().equals(casamentoAtual.getLocalidade())) {
                    stmt.setString(index++, casamentoNovo.getLocalidade());
                }
                if (casamentoNovo.getNumeroConvidados() != 0 && casamentoNovo.getNumeroConvidados() != casamentoAtual.getNumeroConvidados()) {
                    stmt.setInt(index++, casamentoNovo.getNumeroConvidados());
                }
                if (casamentoNovo.getEstiloFesta() != null && !casamentoNovo.getEstiloFesta().equals(casamentoAtual.getEstiloFesta())) {
                    stmt.setString(index++, casamentoNovo.getEstiloFesta());
                }

                stmt.executeUpdate();
            }
        }
    }

}

