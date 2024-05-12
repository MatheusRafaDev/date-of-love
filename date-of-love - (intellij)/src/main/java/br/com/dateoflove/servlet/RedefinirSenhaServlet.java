package br.com.dateoflove.servlet;

import br.com.dateoflove.model.Usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redefinirSenha")
public class RedefinirSenhaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String senhaAntiga = request.getParameter("senhaAntiga");
        String novaSenha = request.getParameter("novaSenha");

        // Aqui você pode adicionar a lógica para redefinir a senha
        // Obtenha o usuário atual de alguma forma, por exemplo, da sessão
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

        // Verifique se a senha antiga é correta
        if (usuario.getSenha().equals(senhaAntiga)) {
            // Se a senha antiga for correta, atualize a senha do usuário
            usuario.setSenha(novaSenha);

            // Aqui você pode adicionar o código para salvar o usuário atualizado no banco de dados

            // Redirecione para uma página de sucesso
            request.getRequestDispatcher("sucesso.jsp").forward(request, response);
        } else {
            // Se a senha antiga não for correta, retorne uma mensagem de erro
            request.setAttribute("erro", "A senha antiga está incorreta.");
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }

        // Redirecionar para a página JSP apropriada
        request.getRequestDispatcher("redefinirSenha.jsp").forward(request, response);
    }
}