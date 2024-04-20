<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/criar-conta.css">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
    <title>Criar Conta</title>
</head>
<body>
<div class="container">
    <img src="<%=request.getContextPath()%>/src/assets/images/logo.png" alt="logo" class="logo"/>
    <div class="dados">
        <form action="${pageContext.request.contextPath}/criar-usuario" method="POST">
            <div class="conta">Crie sua conta</div><br>

            <label for="nome_noivo">Nome Completo do Noivo</label><br>
            <input type="text" id="nome_noivo" name="nome_noivo" required maxlength="100"><br>

            <label for="nome_noiva">Nome Completo da Noiva</label><br>
            <input type="text" id="nome_noiva" name="nome_noiva" required maxlength="100"><br>

            <label for="email">Seu email</label><br>
            <input type="email" id="email" name="email" required maxlength="254"><br>

            <label for="data_casamento">Data do Casamento</label><br>
            <input type="date" id="data_casamento" name="data_casamento" required><br>

            <label for="estilo_festa">Estilo da Festa</label><br>
            <input type="text" id="estilo_festa" name="estilo_festa" class="campo-grande" required><br>

            <label for="localizacao">Localização</label><br>
            <input type="text" id="localizacao" name="localizacao" required><br>


            <label for="num_convidados">Número Estimado de Convidados</label><br>
            <input type="number" id="num_convidados" name="num_convidados" required maxlength="40"><br>

            <label for="senha">Sua senha</label><br>
            <input type="password" id="senha" name="senha" required maxlength="25"><br>

            <label for="confirmar_senha">Confirme sua senha</label><br>
            <input type="password" id="confirmar_senha" name="confirmar_senha" required maxlength="25"><br>

            <button type="submit" class="cadastrar">CADASTRAR</button>
        </form>
    </div>
</div>
</body>
</html>
