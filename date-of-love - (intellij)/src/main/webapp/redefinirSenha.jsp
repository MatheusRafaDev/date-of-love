<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/esqueci.css">

    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
    <title>Redefina sua senha</title>
</head>

<body>

<div class="container">
    <img src="<%=request.getContextPath()%>/src/assets/images/logo.png" alt="logo" class="logo"/>
    <h1 class="conta">Redefina sua senha</h1>
    <form action="${pageContext.request.contextPath}/redefinirSenha" method="POST">
        <div class="email">Seu email</div>
        <input type="email" id="email" name="email" required><br>

        <div class="senha">Nova Senha</div>
        <input type="password" name="novaSenha" required><br>
        <button type="submit" class="redefinir">Redefinir Senha</button>
    </form>

    <p class="voltar" ><a href="/login.jsp">Voltar ao login</a></p>
</div>
</body>

</html>