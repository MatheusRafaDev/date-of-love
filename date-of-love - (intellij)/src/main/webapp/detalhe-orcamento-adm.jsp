<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="icon" type="image/x-icon" href="/src/assets/images/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/detalhe-orcamento-adm.css">

    <title>Visualizar Orçamento ADM</title>
</head>
<body>
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
            <th>Novo Valor</th>
        </tr>

        <tr>
            <td>Cardápio Completo</td>
            <td><input type="radio" name="servico1" value="simples"></td>
            <td><input type="radio" name="servico1" value="completo"></td>
            <td><input type="text" value=""></td>
            <td>R$ 800</td>
            <td><input type="text" id="novoValor1"></td>
        </tr>

        <tr>
            <td>Flores e Decoração</td>
            <td><input type="radio" name="servico2" value="simples"></td>
            <td><input type="radio" name="servico2" value="completo"></td>
            <td><input type="text" value=""></td>
            <td>R$ 800</td>
            <td><input type="text" id="novoValor2"></td>
        </tr>
        <tr>
            <td>Bebidas</td>
            <td><input type="radio" name="servico3" value="simples"></td>
            <td><input type="radio" name="servico3" value="completo"></td>
            <td><input type="text" value=""></td>
            <td>R$ 800</td>
            <td><input type="text" id="novoValor3"></td>
        </tr>
        <tr>
            <td>Doces e Bem Casados</td>
            <td><input type="radio" name="servico4" value="simples"></td>
            <td><input type="radio" name="servico4" value="completo"></td>
            <td><input type="text" value=""></td>
            <td>R$ 800</td>
            <td><input type="text" id="novoValor4"></td>
        </tr>
        <tr>
            <td>Bolos</td>
            <td><input type="radio" name="servico5" value="simples"></td>
            <td><input type="radio" name="servico5" value="completo"></td>
            <td><input type="text" value=""></td>
            <td>R$ 800</td>
            <td><input type="text" id="novoValor5"></td>
        </tr>
    </table>



    <div class="container">
        <label for="convidados">Nº Convidados:</label>
        <input type="number" id="convidados" name="convidados">

        <label for="valorTotal">Valor total:</label>
        <input type="text" id="valorTotal" name="valorTotal" placeholder="" required>

        <label for="responsavel">Nome do responsável pelo orçamento:</label>
        <input type="text" id="responsavel" name="responsavel" value="Fabrício">
    </div>

    <h3>Observações Gerais</h3>
    <textarea id="observacoesGerais" rows="7" cols="50"></textarea>
    <button id="verDetalhesBtn1" onclick="window.location.href='/perfil.jsp' ">Salvar</button>
</div>

<script>
<c:forEach var="orcamento" items="${listaOrcamentos}">

    document.getElementById("verDetalhesBtn1").addEventListener("click", function() {
    var idOrcamento =${orcamento.getIdOrcamento()}; // Obtenha o ID do orçamento de maneira adequada
    var responsavel = document.getElementById("responsavel").value;
    var novosValores = [];
    var valorTotal = 0;

    document.querySelectorAll('input[id^="novoValor"]').forEach(function(input) {
    var novoValor = parseFloat(input.value.replace(/[^\d.-]/g, '')) || 0;
    novosValores.push({
    id: input.id,
    valor: novoValor
    });
    valorTotal += novoValor;
    });

    document.getElementById("valorTotal").value = valorTotal.toFixed(2);

    var data = JSON.stringify({
    idOrcamento: idOrcamento,
    responsavel: responsavel,
    novosValores: novosValores
    });

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/atualizar-orcamento", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
    if (xhr.status === 200) {
    console.log(xhr.responseText);
    window.location.href = "/perfil.jsp?valorTotal=" + valorTotal.toFixed(2);
    } else {
    console.error('Erro ao atualizar o orçamento:', xhr.status);
    }
    }
    };
    xhr.send(data);

    });

</c:forEach>

</script>

    </body>
    </html>
