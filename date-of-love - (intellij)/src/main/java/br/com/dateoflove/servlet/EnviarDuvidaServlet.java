package br.com.dateoflove.servlet;

import br.com.dateoflove.funcao.ConstrutorHTML;
import br.com.dateoflove.funcao.Email;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/enviar-duvida")
public class EnviarDuvidaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String mensagem = request.getParameter("mensagem");

         Email email2 = new Email("","",email ,"","","html");
         email2.enviarDuvida(nome,email,mensagem);
         response.sendRedirect(request.getContextPath() + "/ajuda.jsp");

    }
}
