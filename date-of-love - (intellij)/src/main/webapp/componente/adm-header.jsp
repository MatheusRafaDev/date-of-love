<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header-adm.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <title>Tela de Administração</title>
</head>
<body>
    <header>
        <img src="${pageContext.request.contextPath}/src/assets/images/logo.png" alt="logo" class="logo"/>
        <nav class="logo-navigation">
            <a href="${pageContext.request.contextPath}/carregar-servico">Serviços</a>
            <a href="${pageContext.request.contextPath}/carregar-orcamento">Orçamentos</a>
            <a href="${pageContext.request.contextPath}/carregar-perfils">Usuários</a>
            <a href="${pageContext.request.contextPath}/sair">Sair</a>
        </nav>
    </header>
</body>
</html>
