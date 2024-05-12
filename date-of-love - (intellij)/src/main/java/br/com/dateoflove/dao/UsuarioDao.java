package br.com.dateoflove.dao;


import br.com.dateoflove.funcao.Email;
import br.com.dateoflove.model.Usuario;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

    public class UsuarioDao {

        public Usuario criarUsuario(Usuario usuario) {
            try {
                String SQL = "INSERT INTO tb_usuarios (nm_noivo, nm_noiva, ds_email, ds_senha, dt_cadastro, nm_noivos_concatenado) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";
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

                        System.out.println("Usuário criado com sucesso!");
                    } else {
                        System.out.println("Falha ao obter o ID do usuário.");
                    }
                } else {
                    System.out.println("Falha ao criar o usuário.");
                }

                connection.close();
            } catch (Exception e) {
                System.out.println("Erro ao criar o usuário: " + e.getMessage());
            }

            return usuario;
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

        public void atualizarUsuario(Usuario usuario) {
            try {
                Usuario usuarioAntigo = buscarUsuarioPorId(usuario.getIdUsuario());
                if (usuarioAntigo == null) {
                    System.out.println("Usuário não encontrado para atualização.");
                    return;
                }

                if (!usuario.getNomeNoivo().equals(usuarioAntigo.getNomeNoivo())) {
                    usuarioAntigo.setNomeNoivo(usuario.getNomeNoivo());
                }
                if (!usuario.getNomeNoiva().equals(usuarioAntigo.getNomeNoiva())) {
                    usuarioAntigo.setNomeNoiva(usuario.getNomeNoiva());
                }
                if (!usuario.getEmail().equals(usuarioAntigo.getEmail())) {
                    usuarioAntigo.setEmail(usuario.getEmail());
                }
                if (!usuario.getSenha().equals(usuarioAntigo.getSenha())) {
                    usuarioAntigo.setSenha(usuario.getSenha());
                }
                if (!usuario.getNomesConcatenados().equals(usuarioAntigo.getNomesConcatenados())) {
                    usuarioAntigo.setNomesConcatenados(usuario.getNomesConcatenados());
                }

                // Agora atualizamos os campos no banco de dados
                String SQL = "UPDATE tb_usuarios SET nm_noivo = ?, nm_noiva = ?, ds_email = ?, ds_senha = ?, nm_noivos_concatenado = ? WHERE id_usuario = ?";
                Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setString(1, usuarioAntigo.getNomeNoivo());
                preparedStatement.setString(2, usuarioAntigo.getNomeNoiva());
                preparedStatement.setString(3, usuarioAntigo.getEmail());
                preparedStatement.setString(4, usuarioAntigo.getSenha());
                preparedStatement.setString(5, usuarioAntigo.getNomesConcatenados());
                preparedStatement.setInt(6, usuarioAntigo.getIdUsuario());

                int linhasAfetadas = preparedStatement.executeUpdate();

                if (linhasAfetadas == 1) {
                    System.out.println("Usuário atualizado com sucesso!");
                } else {
                    System.out.println("Falha ao atualizar o usuário.");
                }

                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao atualizar o usuário: " + e.getMessage());
            }
        }

        public Usuario buscarUsuarioPorId(int idUsuario) {
            Usuario usuario = null;

            try {
                String SQL = "SELECT * FROM tb_usuarios WHERE id_usuario = ?";
                Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setInt(1, idUsuario);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {

                    String nomeNoivo = resultSet.getString("nm_noivo");
                    String nomeNoiva = resultSet.getString("nm_noiva");
                    String email = resultSet.getString("ds_email");
                    String senha = resultSet.getString("ds_senha");
                    java.util.Date dataCadastro = resultSet.getDate("dt_cadastro");
                    String nomesConcatenados = resultSet.getString("nm_noivos_concatenado");

                    usuario = new Usuario(idUsuario, nomeNoivo, nomeNoiva, email, senha, dataCadastro, nomesConcatenados);
                }
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao buscar usuário por ID: " + e.getMessage());
            }
            return usuario;
        }

    }


