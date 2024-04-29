<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="br.com.dateoflove.model.Usuario" %>
<%@ page import="br.com.dateoflove.model.Casamento" %>

<% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>
<% Casamento casamento = (Casamento) session.getAttribute("casamento"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajuda</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ajuda.css">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>
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
                <a class="nome" href="/perfil.jsp"><%= usuario.getNomesConcatenados() %></a>
                <img src="<%=request.getContextPath()%>/src/assets/images/casal.png" alt="Foto do Usuário">
                <a class="sair" href="sair">Sair</a>
            </div>
        </div>
     </header>

    <h2 class="ajuda">Ajuda</h2>

    <div class="duvida-box">
        <h2>Descreva sua dúvida</h2>
        <input class="texto" type="text" placeholder="Digite sua dúvida aqui...">
        <button type="button" class="btn btn-primary btn-sm">Enviar</button>
    </div>
</body>
</html>