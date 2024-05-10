<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
</head>

<header>
    <img src="<%=request.getContextPath()%>/src/assets/images/logo.png" alt="logo" class="logo"/>
    <div class="logo-navigation">
        <nav>
            <a href="home.jsp">Home</a>
            <a href="servicos.jsp">Serviços</a>
            <a href="ajuda.jsp">Ajuda</a>
            <a href="sobre-nos.jsp">Sobre nós</a>
        </nav>
        <form action="${pageContext.request.contextPath}/perfil" method="GET">
            <div class="user-items">
                <input type="text" id="id" name="id" value="${usuario.getIdUsuario()}" style="display: none;">
                <button type="submit" class="nomeCasal"><%= usuario.getNomesConcatenados() %></button>
                <img src="<%=request.getContextPath()%>/src/assets/images/casal.png" alt="Foto do Usuário">
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/sair" method="GET">
            <button type="submit" class="nomeCasal">Sair</button>
        </form>
    </div>
</header>
