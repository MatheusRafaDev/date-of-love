<%--
  Created by IntelliJ IDEA.
  User: alexandre.fsilva49
  Date: 03/05/2024
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
        <form action="${pageContext.request.contextPath}/perfil" method="GET">
            <div class="user-items">
                <input type="text" id="id" name="id" value="${usuario.getIdUsuario()}" style="display: none;">
                <button type="submit" class="nomeCasal"><%= usuario.getNomesConcatenados() %></button>
                <img src="<%=request.getContextPath()%>/src/assets/images/casal.png" alt="Foto do Usuário">
                <form action="${pageContext.request.contextPath}/sair" method="GET">
                    <button type="submit" class="sair">Sair</button>
                </form>
            </div>
        </form>
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
        <c:forEach var="detalhe" items="${detalheorcamento}">
            <c:set var="servico" value="${servicoDao.encontrarServicoPorId(detalhe.idServico)}" />
            <tr>
                <td><c:out value="${servico.getNomeServico()}" /></td>
                <td><input type="radio" name="" value="simples" ${!detalhe.isCompleto() ? "checked" : ""} disabled></td>
                <td><input type="radio" name="" value="completo" ${detalhe.isCompleto() ? "checked" : ""} disabled></td>
                <td>${detalhe.getObservacaoServico()}</td>
                <td>R$ ${detalhe.getPrecoEditavel()}</td>
                <td><input type="text" id="observacao_${detalhe.id}" value="${detalhe.getObservacaoServico()}"></td>
                <td>R$ <input type="text" id="preco_${detalhe.id}" value="${detalhe.getPrecoEditavel()}"></td>

            </tr>
        </c:forEach>
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
            <td><input type="text" value=""></td>
            <td>R$ 2000</td>
        </tr>
        <tr>
            <td>Coordenação do Dia</td>
            <td><input type="text" value=""></td>
            <td>R$ 1500</td>
        </tr>
        <tr>
            <td>Espaço</td>
            <td><input type="text" value=""></td>
            <td>R$ 3000</td>
        </tr>
    </table>

    <h3>Observações Gerais</h3>
    <textarea rows="7" cols="50"></textarea>
</div>
<div class="botao-orcamento-admin">
    <button class="botao-editar-orcamento"><a> Editar Orçamento</a> </button>
    <button class="botao-editar-orcamento"><a> Visualizar Orçamento</a> </button>
</div>

<button onclick="salvarEdicoes()">Salvar Alterações</button>

</body>
</html>

<script !src="">

    function salvarEdicoes() {
        var detalhesEditados = [];
        var detalhes = ${detalheorcamento};

        detalhes.forEach(function(detalhe) {
            var id = detalhe.id;
            var observacao = document.getElementById("observacao_" + id).value;
            var preco = document.getElementById("preco_" + id).value;

            detalhesEditados.push({
                id: id,
                observacao: observacao,
                preco: preco
            });
        });

    }
</script>
