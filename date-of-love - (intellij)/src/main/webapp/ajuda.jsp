<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajuda</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ajuda.css">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
</head>
<body>

    <header>
        <img src="" alt="Foto do Usuário">
        <nav>
            <a href="#">HOME</a>
            <a href="#">CATÁLOGO</a>
            <a href="#">CONTATO</a>
            <a href="#">SOBRE NÓS</a>
            <a href="#">ORÇAMENTO</a>
        </nav>
        <button type="button">SAIR</button>
    </header>

    <h1>Ajuda</h1>

    <div class="duvida-box">
        <h2>Descreva sua dúvida</h2>
        <input class="texto" type="text" placeholder="Digite sua dúvida aqui...">
        <button type="button" class="btn btn-primary btn-sm">Enviar</button>
    </div>
</body>
</html>