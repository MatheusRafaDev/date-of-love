package br.com.dateoflove.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/criar-usuario")
public class CriarUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nomeNoivo = request.getParameter("nome_noivo");
        String nomeNoiva = request.getParameter("nome_noiva");
        String email = request.getParameter("email");
        String dataCasamento = request.getParameter("data_casamento");
        String estiloFesta = request.getParameter("estilo_festa");
        String localizacao = request.getParameter("localizacao");
        String numConvidados = request.getParameter("num_convidados");
        String senha = request.getParameter("senha");
        String confirmarSenha = request.getParameter("confirmar_senha");

        System.out.println("Nome do Noivo: " + nomeNoivo);
        System.out.println("Nome da Noiva: " + nomeNoiva);
        System.out.println("Email: " + email);
        System.out.println("Data do Casamento: " + dataCasamento);
        System.out.println("Estilo da Festa: " + estiloFesta);
        System.out.println("Localização: " + localizacao);
        System.out.println("Número de Convidados: " + numConvidados);
        System.out.println("Senha: " + senha);
        System.out.println("Confirmar Senha: " + confirmarSenha);

        request.getRequestDispatcher("index.html").forward(request, response);
    }
}
