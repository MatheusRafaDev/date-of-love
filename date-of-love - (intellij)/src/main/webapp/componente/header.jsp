<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="br.com.dateoflove.model.Usuario" %>
<%@ page import="br.com.dateoflove.model.Orcamentos" %>
<%@ page import="br.com.dateoflove.model.Casamento" %>

<%
    Usuario usuario2 = (Usuario) session.getAttribute("usuario");
%>

<%
    String imagemPath = usuario2.getImagem();
    String defaultImagePath = request.getContextPath() + "/src/assets/images/casal.png";
    String finalImagePath;

    if (imagemPath != null && !imagemPath.isEmpty()) {
        // Verifica se o arquivo de imagem existe
        java.io.File file = new java.io.File(getServletContext().getRealPath(imagemPath));
        if (file.exists()) {
            finalImagePath = request.getContextPath() + imagemPath;
        } else {
            finalImagePath = defaultImagePath;
        }
    } else {
        finalImagePath = defaultImagePath;
    }
%>


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
</head>

<%
    if (usuario != null) {
%>
    <header>
        <img src="<%=request.getContextPath()%>/src/assets/images/logo.png" alt="logo" class="logo"/>
        <div class="logo-navigation">
            <nav>
                <a href="/home.jsp">Home</a>
                <a href="/servicos.jsp">Serviços</a>
                <a href="/ajuda.jsp">Ajuda</a>
                <a href="/sobre-nos.jsp">Sobre nós</a>
            </nav>
            <form action="${pageContext.request.contextPath}/perfil" method="GET">
                <div class="user-items">
                    <input type="text" id="id" name="id" value="${usuario.getIdUsuario()}" style="display: none;">
                    <button type="submit" class="nomeCasal"><%= usuario2.getNomesConcatenados() %></button>
                    <img src="<%= finalImagePath %>" alt="Foto do Usuário">
                </div>
            </form>
            <form action="${pageContext.request.contextPath}/sair" method="GET">
                <button type="submit" class="nomeCasal">Sair</button>
            </form>
        </div>
    </header>
<%
    } else {
%>
    <header>
        <img src="<%=request.getContextPath()%>/src/assets/images/logo.png" alt="logo" class="logo"/>
        <div class="logo-navigation">
            <nav>
                <a href="/home.jsp">Home</a>
                <a href="/servicos.jsp">Serviços</a>
                <a href="/ajuda.jsp">Ajuda</a>
                <a href="/sobre-nos.jsp">Sobre nós</a>
            </nav>

            <div class="user-items">
                <a href="/criar-conta.jsp">Criar conta</a>
                <form action="${pageContext.request.contextPath}/sair" method="GET">
                    <button type="submit" class="login">Login</button>
                </form>
            </div>

        </div>
    </header>
<%
    }
%>
