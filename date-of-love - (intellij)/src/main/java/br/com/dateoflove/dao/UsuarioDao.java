package br.com.dateoflove.dao;


import br.com.dateoflove.model.Usuario;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

    public class UsuarioDao {

        public void criarUsuario(Usuario usuario) {
            try {
                String SQL = "INSERT INTO tb_usuarios (nm_noivo, nm_noiva, ds_email, ds_senha, dt_cadastro, nm_noivos_concatenado) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
                Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
                PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);


                preparedStatement.setString(1, usuario.getNomeNoivo());
                preparedStatement.setString(2, usuario.getNomeNoiva());
                preparedStatement.setString(3, usuario.getEmail());
                preparedStatement.setString(4, usuario.getSenha());
                preparedStatement.setDate(5, java.sql.Date.valueOf(LocalDate.now()));
                preparedStatement.setString(6, usuario.getNomesConcatenados());

                int linhasAfetadas = preparedStatement.executeUpdate();

                if (linhasAfetadas == 1) {
                    ResultSet chavesGeradas = preparedStatement.getGeneratedKeys();
                    if (chavesGeradas.next()) {
                        int idUsuario = chavesGeradas.getInt(1);
                        usuario.setIdUsuario(idUsuario);
                    }
                    System.out.println("Usuário criado com sucesso!");
                } else {
                    System.out.println("Falha ao criar o usuário.");
                }

                connection.close();
            } catch (Exception e) {
                System.out.println("Erro ao criar o usuário: " + e.getMessage());
            }
        }

        public List<Usuario> encontrarTodosUsuarios() {
            try {
                String SQL = "SELECT * FROM tb_usuarios";
                Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                ResultSet resultSet = preparedStatement.executeQuery();
                List<Usuario> usuarios = new ArrayList<>();

                while (resultSet.next()) {
                    int idUsuario = resultSet.getInt("id_usuario");
                    String nomeNoivo = resultSet.getString("nome_noivo");
                    String nomeNoiva = resultSet.getString("nome_noiva");
                    String email = resultSet.getString("ds_email");
                    String senha = resultSet.getString("ds_senha");
                    java.util.Date dataCadastro = resultSet.getDate("dt_cadastro");
                    String nomesConcatenados = resultSet.getString("nm_noivos_concatenado");

                    Usuario usuario = new Usuario(idUsuario, nomeNoivo, nomeNoiva, email, senha, dataCadastro, nomesConcatenados);
                    usuarios.add(usuario);
                }

                return usuarios;
            } catch (Exception e) {
                System.out.println("Erro ao encontrar usuários: " + e.getMessage());
            }
            return Collections.emptyList();
        }

        public void deletarUsuarioPorId(int idUsuario) {
            try {
                String SQL = "DELETE FROM tb_usuarios WHERE id_usuario = ?";
                Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setInt(1, idUsuario);
                preparedStatement.execute();
                System.out.println("Usuário deletado com sucesso!");
                connection.close();
            } catch (Exception e) {
                System.out.println("Falha ao deletar o usuário: " + e.getMessage());
            }
        }

        public Usuario buscarUsuarioPorEmail(String email) {
            PreparedStatement stmt = null;
            ResultSet rs = null;
            Usuario usuario = null;

            try {
                Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
                String query = "SELECT * FROM tb_usuarios WHERE ds_email = ?";
                stmt = conn.prepareStatement(query);
                stmt.setString(1, email);
                rs = stmt.executeQuery();

                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("id_usuario"));
                    usuario.setNomeNoivo(rs.getString("nm_noivo"));
                    usuario.setNomeNoiva(rs.getString("nm_noiva"));
                    usuario.setEmail(rs.getString("ds_email"));
                    usuario.setSenha(rs.getString("ds_senha"));
                    usuario.setDataCadastro(rs.getDate("dt_cadastro"));
                    usuario.setNomesConcatenados(rs.getString("nm_noivos_concatenado"));

                }
            } catch (SQLException e) {
                System.out.println("Erro ao buscar usuário por email: " + e.getMessage());
            }
            return usuario;
        }

        public boolean existeUsuarioPorEmail(String email) {
            String sql = "SELECT COUNT(*) FROM tb_usuarios WHERE ds_email = ?";
            PreparedStatement stmt = null;

            try {

                Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, email);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao verificar a existência do usuário por email", e);
            }
            return false;
        }
    }


