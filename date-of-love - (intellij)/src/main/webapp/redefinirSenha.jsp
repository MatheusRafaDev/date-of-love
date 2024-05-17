<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">

        <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
        <title>Redefina sua senha</title>
    </head>

    <body>

        <div class="container">
            <img src="<%=request.getContextPath()%>/src/assets/images/logo.png" alt="logo" class="logo" />
            <div class="dados">
                <div class="conta">Redefina sua senha</div><br>

                <form action="${pageContext.request.contextPath}/redefinirSenha" method="POST">

                    <div class="email">Seu email</div><br>
                    <input type="email" id="email" name="email" required><br><br>

                    <div class="senha">Nova Senha</div><br>
                    <input type="password" name="novaSenha" required><br><br>
                    <button type="submit" class="entrar">Redefinir Senha</button><br>
                </form>

                <p class="esqueci-senha"><a class="esqueci" href="/login.jsp">Voltar ao login</a></p>
            </div>
        </div>
    </body>
    2

    </html>