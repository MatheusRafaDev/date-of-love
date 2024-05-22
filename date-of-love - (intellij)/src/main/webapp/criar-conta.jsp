<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/criar-conta2.css">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
    <title>Criar Conta</title>
</head>
<body>
<div class="container">

    <div class="dados">
        <form action="${pageContext.request.contextPath}/criar-usuario" method="POST">
            <div class="conta">Crie sua conta</div>

            <label for="nome_noivo">Nome Completo do Noivo</label>
            <input type="text" id="nome_noivo" name="nome_noivo" required maxlength="100">

            <label for="nome_noiva">Nome Completo da Noiva</label>
            <input type="text" id="nome_noiva" name="nome_noiva" required maxlength="100">

            <label for="email">Seu email</label>
            <div class="container2">
                <input type="email" id="email" name="email" required maxlength="254">
                 <br>
                <span class="error-message">${requestScope.errorMessage1}</span>
            </div>

            <label for="data_casamento">Data do Casamento</label>
            <div class="container2">
                 <input type="date" id="data_casamento" name="data_casamento" required>
                 <br>
                 <span class="error-message">${requestScope.errorMessage3}</span>
            </div>

            <section>
                <label for="estilo_festa">Estilo da Festa</label>
                <select id="estilo_festa" name="estilo_festa" class="campo-grande" required>
                    <option value="">Selecione o estilo</option>
                    <option value="classico">Clássico</option>
                    <option value="rustico">Rústico</option>
                    <option value="praia">Praia</option>
                    <option value="moderno">Moderno</option>
                    <option value="vintage">Vintage</option>
                </select>
            </section>

            <section>
                <label for="localizacao">Localização</label>
                <select id="localizacao" name="localizacao" required>
                    <option value="">Selecione a localização</option>
                    <option value="igreja">Igreja</option>
                    <option value="salao_festas">Salão de festas</option>
                    <option value="campo">Campo</option>
                    <option value="hotel">Hotel</option>
                </select>
            </section>


            <label for="num_convidados">Número de Convidados</label>
            <input type="number" id="num_convidados" name="num_convidados" required maxlength="40">

            <label for="senha">Sua senha</label>
            <input type="password" id="senha" name="senha" required maxlength="25">

            <label for="confirmar_senha">Confirme sua senha</label>

            <div class="container2">
                <input type="password" id="confirmar_senha" name="confirmar_senha" required maxlength="25">
                <br>
                <span class="error-message">${requestScope.errorMessage2}</span>
            </div>

            <button type="submit" class="cadastrar">CADASTRAR</button>
        </form>
        <a href="login.jsp">Já tem uma conta? Faça login aqui</a>
    </div>
</div>
</body>
</html>
