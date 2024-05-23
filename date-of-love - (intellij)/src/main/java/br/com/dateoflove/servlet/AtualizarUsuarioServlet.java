package br.com.dateoflove.servlet;

import br.com.dateoflove.dao.CasamentoDao;
import br.com.dateoflove.dao.UsuarioDao;
import br.com.dateoflove.model.Usuario;
import br.com.dateoflove.model.Casamento;

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
            String dataCasamentoStr = request.getParameter("dataCasamento");
            String localidade = request.getParameter("localizacao");
            String numConvidadosStr = request.getParameter("num_convidados");
            String estiloFesta = request.getParameter("estilo_festa");

            String primeiroNomeNoivo = nomeNoivo.split(" ")[0];
            String primeiroNomeNoiva = nomeNoiva.split(" ")[0];
            String nomesConcatenados = primeiroNomeNoivo + " & " + primeiroNomeNoiva;

            if (idUsuarioStr == null || idUsuarioStr.isEmpty()) {
                throw new IllegalArgumentException("ID do usuário não pode ser nulo ou vazio.");
            }
            int idUsuario = Integer.parseInt(idUsuarioStr);

            UsuarioDao usuarioDao = new UsuarioDao();
            CasamentoDao casamentoDao = new CasamentoDao();

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
            usuarioNovo.setImagem(imagem);

            usuarioDao.atualizarUsuarioParcial(usuarioAtual, usuarioNovo);

            Casamento casamentoAtual = casamentoDao.encontrarCasamentoPorIdUsuario(idUsuario);

            if (casamentoAtual == null) {
                throw new IllegalArgumentException("Casamento não encontrado.");
            }

            Casamento casamentoNovo = new Casamento();
            casamentoNovo.setIdCasamento(casamentoAtual.getIdCasamento());
            casamentoNovo.setIdUsuario(idUsuario);
            casamentoNovo.setDataCasamento(dataCasamentoStr != null ? java.sql.Date.valueOf(dataCasamentoStr) : null);
            casamentoNovo.setLocalidade(localidade);
            casamentoNovo.setNumeroConvidados(numConvidadosStr != null ? Integer.parseInt(numConvidadosStr) : 0);
            casamentoNovo.setEstiloFesta(estiloFesta);

            casamentoDao.atualizarCasamentoParcial(casamentoAtual, casamentoNovo);


            request.getSession().setAttribute("usuario", usuarioNovo);
            request.getSession().setAttribute("casamento", casamentoNovo);

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
