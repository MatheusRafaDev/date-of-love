<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Redefina sua senha</title>
</head>
<body>
<h1>Redefina sua senha</h1>
<form action="${pageContext.request.contextPath} method="post">
    <input type="email" id="email" name="email" placeholder="Seu email">

    <input type="password" name="password" placeholder="Nova Senha">
    <button type="submit" class="redefinir">Redefinir Senha</button>
</form>
<a href="/login.jsp">Voltar ao login</a>
</body>
</html>
