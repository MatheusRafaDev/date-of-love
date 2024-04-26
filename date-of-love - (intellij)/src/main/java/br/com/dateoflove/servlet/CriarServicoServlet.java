package br.com.dateoflove.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dateoflove.dao.ServicoDao;
import br.com.dateoflove.model.Servico;

@WebServlet("/criar-servico")
public class CriarServicoServlet extends HttpServlet{
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        String nomeProduto = req.getParameter("nome_produto");
        String tipoProduto= req.getParameter("tipo_produto");
        String descricaoProduto = req.getParameter("descricao_produto");
        String itensProduto = req.getParameter("itens_produtos");

        System.out.println(nomeProduto);

        req.getRequestDispatcher("servicos.jsp").forward(req, resp);;
    }
}
