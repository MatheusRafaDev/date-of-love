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
            <th>Novo Valor</th> <!-- Adicionando coluna para o novo valor -->
        </tr>

        <tr>
            <td>Cardápio Completo</td>
            <td><input type="radio" name="servico1" value="simples"></td>
            <td><input type="radio" name="servico1" value="completo"></td>
            <td><input type="text" value=""></td>
            <td>R$ 800</td>
            <td><input type="text" id="novoValor1"></td> <!-- Campo para novo valor -->
        </tr>
        <!-- Adicione campos semelhantes para outros serviços -->
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

    <!-- Outros serviços aqui -->

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
    <button id="verDetalhesBtn1">Salvar</button>
</div>

<script>
    // Função para calcular e atualizar o valor total
    function calcularValorTotal() {
        // Obter todos os elementos de input para os novos valores dos serviços
        var inputsNovoValor = document.querySelectorAll('input[id^="novoValor"]');
        var total = 0;

        // Iterar sobre os inputs e adicionar os valores aos totais
        inputsNovoValor.forEach(function(input) {
            total += parseFloat(input.value || 0);
        });

        // Atualizar o campo de valor total
        document.getElementById("valorTotal").value = total.toFixed(2);
    }

    // Adicionar listeners de evento para os inputs de novo valor
    var inputsNovoValor = document.querySelectorAll('input[id^="novoValor"]');
    inputsNovoValor.forEach(function(input) {
        input.addEventListener('input', calcularValorTotal);
    });



    // Calcular o valor total inicial
    calcularValorTotal();

    // -------------------------------------------------------------------------
    // Coletar os dados do orçamento (incluindo novos valores dos serviços)
    // Exemplo: suponha que os novos valores dos serviços estejam armazenados em variáveis service1, service2, etc.
    var idOrcamento = 1; // Suponha que você tenha o ID do orçamento
    var novoValorService1 = document.getElementById("novoValor1").value;
    // Coletar outros dados relevantes, se necessário

    // Enviar os dados para o backend
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/atualizar-orcamento", true);
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Resposta recebida do backend
            console.log(xhr.responseText);
        }
    };

    var data = JSON.stringify({
        idOrcamento: idOrcamento,
        novoValorService1: novoValorService1
        // Enviar outros dados relevantes, se necessário
    });

    // Enviar os dados para o backend
    xhr.send(data);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                // Resposta recebida do backend
                console.log(xhr.responseText);
                // Redirecionar de volta à página de orçamento
                window.location.href = "/orcamento-admin.jsp";
            } else {
                // Se houver um erro, você pode lidar com isso aqui
                console.error('Erro ao atualizar o orçamento:', xhr.status);
            }
        }
    };
</script>
</body>
</html>
