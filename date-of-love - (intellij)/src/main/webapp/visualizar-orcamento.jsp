<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/visualizar-orcamento.css">

    <title>Visualizar Orçamento</title>
</head>

<body>
    <header>
        <img src="<%=request.getContextPath()%>/src/assets/images/logo.png" alt="logo" class="logo"/>
        <div class="logo-navigation">
            <nav>
                <a href="/home.jsp">Home</a>
                <a href="/servicos.jsp">Serviços</a>
                <a href="/ajuda.jsp">Ajuda</a>
                <a href="/sobre-nos.jsp">Sobre nós</a>
            </nav>
            <div class="user-items">
                <a class="nome" href="/perfil.jsp"></a>
                <img src="<%=request.getContextPath()%>/src/assets/images/casal.png" alt="Foto do Usuário">
                <a class="sair" href="sair">Sair</a>
            </div>
        </div>
    </header>

<div class="budget-container">
    <h3>Orçamento</h3>
    <h3>Serviços</h3>
    <table>
        <tr>
            <th>Serviço</th>
            <th>Pacote Simples</th>
            <th>Pacote Completo</th>
            <th>Observações</th>
            <th>Valor</th>
        </tr>
        <tr>
            <td>Cardápio Completo</td>
            <td><input type="radio" name="cardapio" value="simples"></td>
            <td><input type="radio" name="cardapio" value="completo"></td>
            <td><input type="text" value="Observações sobre o cardápio"></td>
            <td>R$ 1500</td>
        </tr>
        <tr>
            <td>Flores e Decoração</td>
            <td><input type="radio" name="flores" value="simples"></td>
            <td><input type="radio" name="flores" value="completo"></td>
            <td><input type="text" value="Observações sobre as flores"></td>
            <td>R$ 2000</td>
        </tr>
        <tr>
            <td>Bebidas</td>
            <td><input type="radio" name="bebidas" value="simples"></td>
            <td><input type="radio" name="bebidas" value="completo"></td>
            <td><input type="text" value="Observações sobre as bebidas"></td>
            <td>R$ 1000</td>
        </tr>
        <tr>
            <td>Doces e Bem Casados</td>
            <td><input type="radio" name="doces" value="simples"></td>
            <td><input type="radio" name="doces" value="completo"></td>
            <td><input type="text" value="Observações sobre os doces"></td>
            <td>R$ 800</td>
        </tr>
        <tr>
            <td>Bolos</td>
            <td><input type="radio" name="bolos" value="simples"></td>
            <td><input type="radio" name="bolos" value="completo"></td>
            <td><input type="text" value="Observações sobre os bolos"></td>
            <td>R$ 1200</td>
        </tr>
    </table>

    <h3>Outros Serviços Já Inclusos</h3>
    <table>
        <tr>
            <th>Serviço</th>
            <th>Observações</th>
            <th>Valor</th>
        </tr>
        <tr>
            <td>DJ</td>
            <td><input type="text" value="Observações sobre o DJ"></td>
            <td>R$ 2000</td>
        </tr>
        <tr>
            <td>Coordenação do Dia</td>
            <td><input type="text" value="Observações sobre a coordenação"></td>
            <td>R$ 1500</td>
        </tr>
        <tr>
            <td>Espaço</td>
            <td><input type="text" value="Observações sobre o espaço"></td>
            <td>R$ 3000</td>
        </tr>
    </table>

    <h3>Observações Gerais</h3>
    <textarea rows="7" cols="50">Observações gerais sobre o orçamento</textarea>
</div>

</body>
</html>
