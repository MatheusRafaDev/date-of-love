<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico">
    <title>Login</title>
</head>

<body>
    <div class="container">
        <img src="<%=request.getContextPath()%>/src/assets/images/logo.png" alt="logo" class="logo"/>
        <div class="dados">
            <div class="conta">Entre em sua conta</div><br>

            <form action="${pageContext.request.contextPath}/login" method="POST">
                <span>${requestScope.message}</span>
                <span class="error-message">${requestScope.errorMessage}</span>

                <div class="email">Seu email</div><br>
                <input type="email" id="email" name="email" required><br>

                <div class="senha">Sua senha</div><br>
                <input type="password" id="senha" name="senha" required><br>
                <p id="erro-msg" class="erro-msg"></p>

                <p class="esqueci-senha"><a class="esqueci" href="#">Esqueceu a senha?</a></p>

                <button type="submit" class="entrar">ENTRAR</button>
            </form>

            <button
                type="button"
                class="criar"
                onclick="window.location.href = '${pageContext.request.contextPath}/criar-conta.jsp';">
                CRIAR CONTA
            </button>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/login.js"></script>

</body>

</html>
