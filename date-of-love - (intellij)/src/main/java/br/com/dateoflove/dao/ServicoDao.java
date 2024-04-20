package br.com.dateoflove.dao;

import br.com.dateoflove.model.Servico;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServicoDao {

    public void criarServico(Servico servico) {
        try {
            String SQL = "INSERT INTO tb_servico (id_nome_produto, id_tipo_produto, id_descricao_produto, id_itens_produto) " +
                    "VALUES (?, ?, ?, ?)";
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, servico.getIdNomeProduto());
            preparedStatement.setString(2, servico.getIdTipoProduto());
            preparedStatement.setString(3, servico.getIdDescricaoProduto());
            preparedStatement.setArray(4, connection.createArrayOf("VARCHAR", servico.getIdItensProduto()));

            int linhasAfetadas = preparedStatement.executeUpdate();

            if (linhasAfetadas == 1) {
                ResultSet chavesGeradas = preparedStatement.getGeneratedKeys();
                if (chavesGeradas.next()) {
                    String idServico = chavesGeradas.getString(1);
                    servico.setIdNomeProduto(idServico);
                }
                System.out.println("Serviço criado com sucesso!");
            } else {
                System.out.println("Falha ao criar serviço.");
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("Erro ao criar serviço: " + e.getMessage());
        }
    }

    public List<Servico> encontrarTodosServicos() {
        try {
            String SQL = "SELECT * FROM tb_servico";
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Servico> servicos = new ArrayList<>();

            while (resultSet.next()) {
                String idNomeProduto = resultSet.getString("id_nome_produto");
                String idTipoProduto = resultSet.getString("id_tipo_produto");
                String idDescricaoProduto = resultSet.getString("id_descricao_produto");
                Array idItensProdutoArray = resultSet.getArray("id_itens_produto");
                String[] idItensProduto = (String[]) idItensProdutoArray.getArray();

                Servico servico = new Servico(idNomeProduto, idTipoProduto, idDescricaoProduto, idItensProduto);
                servicos.add(servico);
            }

            System.out.println("Serviços encontrados com sucesso!");
            return servicos;
        } catch (Exception e) {
            System.out.println("Erro ao encontrar serviços: " + e.getMessage());
        }
        return Collections.emptyList();
    }

    public void deletarServicoPorId(String idNomeProduto) {
        try {
            String SQL = "DELETE FROM tb_servico WHERE id_nome_produto = ?";
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, idNomeProduto);
            preparedStatement.execute();
            System.out.println("Serviço deletado com sucesso!");
            connection.close();
        } catch (Exception e) {
            System.out.println("Falha ao deletar serviço: " + e.getMessage());
        }
    }

    // Método para obter a conexão com o banco de dados
    private Connection getConnection() throws SQLException {
        String url = "jdbc:h2:~/test";
        String user = "sa";
        String password = "sa";
        return DriverManager.getConnection(url, user, password);
    }
}
