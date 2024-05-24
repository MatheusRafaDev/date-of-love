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

    <div class="dados">
        <form action="${pageContext.request.contextPath}/criar-usuario" method="POST">
            <div class="conta">Crie sua conta</div>

            <label for="nome_noivo">Nome Completo do Noivo</label>
            <input type="text" id="nome_noivo" name="nome_noivo" required maxlength="100" value="${requestScope.nomeNoivo}">

            <label for="nome_noiva">Nome Completo da Noiva</label>
            <input type="text" id="nome_noiva" name="nome_noiva" required maxlength="100" value="${requestScope.nomeNoiva}">

            <label for="email">Seu email</label>
            <div class="container2">
                <input type="email" id="email" name="email" required maxlength="254" value="${requestScope.email}">
                <br>
                <span class="error-message">${requestScope.errorMessage1}</span>
            </div>

            <h5 class="data">*Data do casamento deve ser 9 meses a frente para o planejamento.</h5>
            <label for="data_casamento">Data do Casamento</label>
            <div class="container2">
                 <input type="date" id="data_casamento" name="data_casamento" class="form-control" required value="${requestScope.dataCasamento}">
                 <br>
                 <span class="errorMessage1">${requestScope.errorMessage1}</span>
            </div>

            <section>
                <label for="estilo_festa">Estilo da Festa</label>
                <select id="estilo_festa" name="estilo_festa" class="campo-grande" required>
                    <option value="classico" ${requestScope.estilo == 'classico' ? 'selected' : ''}>Clássico</option>
                    <option value="rustico" ${requestScope.estilo == 'rustico' ? 'selected' : ''}>Rústico</option>
                    <option value="praia" ${requestScope.estilo == 'praia' ? 'selected' : ''}>Praia</option>
                    <option value="moderno" ${requestScope.estilo == 'moderno' ? 'selected' : ''}>Moderno</option>
                    <option value="vintage" ${requestScope.estilo == 'vintage' ? 'selected' : ''}>Vintage</option>
                </select>
            </section>

            <section>
                <label for="localizacao">Localização</label>
                <select id="localizacao" name="localizacao" required>
                    <option value="igreja" ${requestScope.localizacao == 'igreja' ? 'selected' : ''}>Igreja</option>
                    <option value="salao_festas" ${requestScope.localizacao == 'salao_festas' ? 'selected' : ''}>Salão de festas</option>
                    <option value="campo" ${requestScope.localizacao == 'campo' ? 'selected' : ''}>Campo</option>
                    <option value="hotel" ${requestScope.localizacao == 'hotel' ? 'selected' : ''}>Hotel</option>
                </select>
            </section>

            <label for="num_convidados">Número de Convidados</label>
            <input type="number" id="num_convidados" name="num_convidados" required maxlength="4" max="1000" value="${requestScope.numConvidados}">

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

<script>
    var dataAtual = new Date();
    var dataMaxima = new Date(dataAtual.getFullYear(), dataAtual.getMonth() + 9, dataAtual.getDate());
    var dataFormatada = dataMaxima.toISOString().slice(0, 10);

    document.getElementById("data_casamento").setAttribute("min", dataFormatada);
</script>
