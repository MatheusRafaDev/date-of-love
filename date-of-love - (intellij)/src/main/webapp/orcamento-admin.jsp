<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.dateoflove.model.Usuario" %>
<%@ page import="br.com.dateoflove.model.Casamento" %>
<%@ page import="br.com.dateoflove.model.DetalheOrcamento" %>
<%@ page import="br.com.dateoflove.model.Orcamentos" %>

<%@ page import="br.com.dateoflove.dao.ServicoDao" %>
<%@ page import="br.com.dateoflove.model.Servico" %>
<% ServicoDao servicoDao = new ServicoDao();%>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    Orcamentos orcamento = (Orcamentos) session.getAttribute("orcamento");

    if (usuario == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    Casamento casamento = (Casamento) session.getAttribute("casamento");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href=,"https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/orcamento.css">

    <style>
        .editavel-ativo {
            background-color: #f0f0f0; /* Cor de fundo para destacar campos editáveis */
        }
    </style>

    <title>Visualizar Orçamento</title>
</head>

<body>

<div class="budget-container">
    <h3>Orçamento</h3>
    <h3>Serviços</h3>
    <form id="formOrcamento" method="POST" action="${pageContext.request.contextPath}/orcamento.jsp">
        <table>
            <tr>
                <th>Serviço</th>
                <th>Pacote Simples</th>
                <th>Pacote Completo</th>
                <th>Observações</th>
                <th>Valor</th>
            </tr>
            <c:forEach var="detalhe" items="${detalheorcamento}" varStatus="status">
                <c:set var="servico" value="${servicoDao.encontrarServicoPorId(detalhe.idServico)}" />
                <tr class="editavel">
                    <td><c:out value="${servico.getNomeServico()}" /></td>

                    <td><input type="radio" name="pacote_${status.index}" value="simples" ${!detalhe.isCompleto() ? "checked" : ""} ${detalhe.isEditavel() ? "" : "disabled"}></td>
                    <td><input type="radio" name="pacote_${status.index}" value="completo" ${detalhe.isCompleto() ? "checked" : ""} ${detalhe.isEditavel() ? "" : "disabled"}></td>
                    <td><input type="text" name="observacao_${status.index}" value="${detalhe.getObservacaoServico()}" ${detalhe.isEditavel() ? "" : "disabled"}></td>
                    <td><input type="text" name="preco_${status.index}" value="${detalhe.getPrecoEditavel()}" ${detalhe.isEditavel() ? "" : "disabled"}></td>
                    <input type="hidden" class="idServico" name="idServico_${status.index}" value="${detalhe.idServico}" />
                </tr>
            </c:forEach>
        </table>

        <button id="btnConfirmar" type="submit" style="display: none;">Confirmar Alterações</button>
    </form>

    <h3>Outros Serviços Já Inclusos</h3>
    <table>
        <tr>
            <th>Serviço</th>
            <th>Observações</th>
            <th>Valor</th>
        </tr>
        <tr>
            <td>DJ</td>
            <td></td>
            <td>R$ 0</td>
        </tr>
        <tr>
            <td>Coordenação do Dia</td>
            <td></td>
            <td>R$ 0</td>
        </tr>
        <tr>
            <td>Espaço</td>
            <td></td>
            <td>R$ 0</td>
        </tr>
    </table>

    <h3>Observações Gerais</h3>
   
</div>

</div>

<button id="btnEditar" onclick="habilitarEdicao()">Editar Orçamento</button>

<script>
    function habilitarEdicao() {
        document.querySelectorAll('input[type="radio"], input[type="text"]').forEach(function(input) {
            input.disabled = false;
        });

        document.querySelectorAll('.editavel').forEach(function(row) {
            row.classList.add('editavel-ativo');
        });

        document.getElementById('btnConfirmar').style.display = 'inline-block';
    }
</script>
</body>
</html>
