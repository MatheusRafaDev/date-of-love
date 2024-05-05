package br.com.dateoflove.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/enviarDuvida")
public class EnviarDuvidaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String duvida = request.getParameter("duvida");


        response.sendRedirect(request.getContextPath() + "/ajuda.jsp");
    }
}
