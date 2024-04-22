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
    <style>
        header {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 20px;
            background-color: #D4EAFF;
            border:0;
            border:none;
        }

        nav {
            display: flex;
        }

        nav a {
            margin-right: 15px;
            text-decoration: none;
            color: black;
        }

        .right-items {
            display: flex;
            align-items: center;
        }

        .right-items img {
            width: 50px;
            height: 50px;
            border-radius: 50%;
            margin-right: 10px;
        }

        .right-items button {
            padding: 10px 20px;
            background-color: #94CBFF;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>

</head>
<body>

    <header>
            <nav>
                <a href="#">Home</a>
                <a href="#">Catálogo</a>
                <a href="#">Contato</a>
                <a href="#">Sobre nós</a>
                <a href="#">Orçamento</a>
            </nav>
            <div class="right-items">
                <img src="" alt="Foto do Usuário">
                <a href="sair">Sair</a>
            </div>
    </header>

    <h1>Ajuda</h1>

    <div class="duvida-box">
        <h2>Descreva sua dúvida</h2>
        <input class="texto" type="text" placeholder="Digite sua dúvida aqui...">
        <button type="button" class="btn btn-primary btn-sm">Enviar</button>
    </div>
</body>
</html>