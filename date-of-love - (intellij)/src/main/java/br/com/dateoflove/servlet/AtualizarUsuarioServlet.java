package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.UsuarioDao;
import br.com.dateoflove.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/atualizar-usuario")
public class AtualizarUsuarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idUsuarioStr = request.getParameter("id");
            String nomeNoivo = request.getParameter("nomeNoivo");
            String nomeNoiva = request.getParameter("nomeNoiva");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String imagem = request.getParameter("imagem");


            String primeiroNomeNoivo = nomeNoivo.split(" ")[0];
            String primeiroNomeNoiva = nomeNoiva.split(" ")[0];
            String nomesConcatenados = primeiroNomeNoivo + " & " + primeiroNomeNoiva;

            if (idUsuarioStr == null || idUsuarioStr.isEmpty()) {
                throw new IllegalArgumentException("ID do usuário não pode ser nulo ou vazio.");
            }
            int idUsuario = Integer.parseInt(idUsuarioStr);

            UsuarioDao usuarioDao = new UsuarioDao();


            Usuario usuarioAtual = usuarioDao.buscarUsuarioPorId(idUsuario);

            if (usuarioAtual == null) {
                throw new IllegalArgumentException("Usuário não encontrado.");
            }

            Usuario usuarioNovo = new Usuario();
            usuarioNovo.setIdUsuario(idUsuario);
            usuarioNovo.setNomeNoivo(nomeNoivo);
            usuarioNovo.setNomeNoiva(nomeNoiva);
            usuarioNovo.setEmail(email);
            usuarioNovo.setSenha(senha);
            usuarioNovo.setNomesConcatenados(nomesConcatenados);
            usuarioNovo.setImagem(usuarioAtual.getImagem());

            usuarioDao.atualizarUsuarioParcial(usuarioAtual, usuarioNovo);

            request.getSession().setAttribute("usuario", usuarioNovo);

            response.sendRedirect("/perfil.jsp");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato de número inválido: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erro ao atualizar o usuário: " + e.getMessage());
        }
    }
}
