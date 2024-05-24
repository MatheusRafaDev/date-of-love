<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.dateoflove.model.*" %>
<%@ page import="br.com.dateoflove.dao.ServicoDao" %>
<%@ page import="java.util.List" %>

<%
    ServicoDao servicoDao = new ServicoDao();
    Usuario usuario2 = (Usuario) session.getAttribute("usuario2");
    if (usuario2 == null || !"adm".equals(usuario2.getEmail())) {
        response.sendRedirect("/login");
        return;
    }

    Usuario usuario = (Usuario) session.getAttribute("usuario");
    Orcamentos orcamento = (Orcamentos) session.getAttribute("orcamento");
    Casamento casamento = (Casamento) session.getAttribute("casamento");
    List<DetalheOrcamento> detalheorcamento = (List<DetalheOrcamento>) session.getAttribute("detalheorcamento");
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="icon" type="image/x-icon" href="/src/assets/images/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adm-detalhe-orcamento.css">
    <title>Visualizar Orçamento ADM</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
    <script>

            $(document).ready(function() {
                let orcamentoValorTotal = <%= orcamento.getValorTotal() %>;
                let formattedValorTotal = orcamentoValorTotal.toFixed(2).replace('.', ',').replace(/\d(?=(\d{3})+,)/g, '$&.');
                $("#valorTotal").val(formattedValorTotal);
                $('#valorTotal').mask('000.000.000,00', {reverse: true});
            });

            $(document).ready(function(){
                $('.valor').mask('000.000.000,00', {reverse: true});
                $('#valorTotal').mask('000.000.000,00', {reverse: true});

                $("#calcularBtn").click(function() {
                    let total = 0;
                    $("input.valor").each(function() {
                        let value = $(this).val().replace(/\./g, '').replace(',', '.');
                        total += parseFloat(value) || 0;
                    });

                    let formattedTotal = total.toFixed(2).replace('.', ',').replace(/\d(?=(\d{3})+,)/g, '$&.');
                    $("#valorTotal").val(formattedTotal);
                    $('#valorTotal').mask('000.000.000,00', {reverse: true});
                });

            });

        </script>


</head>
<body>

<%@ include file="/componente/adm-header.jsp" %>

<form action="${pageContext.request.contextPath}/atualizarOrcamento" method="post">
<div class="budget-container">
    <h3>Orçamento</h3>
    <div class="budget-container2">
        <h5>Orçamento - ${orcamento.getIdOrcamento()}</h5>
        <td><input type="hidden" id="idOrcamento" name="idOrcamento" value="${orcamento.getIdOrcamento()}"></td>
        <h5>Valor Estimado: R$ ${orcamento.getValorMedio()}</h5>

        <%
            if (!orcamento.getStatus().equals("Cancelado") && !orcamento.getStatus().equals("Aprovado")) {
        %>
            <h5>Status:
                <select name="status" id="status">
                    <option value="Pendente" ${orcamento.getStatus().equals('Pendente') ? 'selected' : ''}>Pendente</option>
                    <option value="Andamento" ${orcamento.getStatus().equals('Andamento') ? 'selected' : ''}>Andamento</option>
                    <option value="Esperando Aprovação" ${orcamento.getStatus().equals('Esperando Aprovação') ? 'selected' : ''}>Esperando Aprovação</option>
                </select>
            </h5>
        <%
            } else {
        %>
            <h5>Status:
                <select name="status" id="status">
                    <option value="Aprovado" ${orcamento.getStatus().equals('Aprovado') ? 'selected' : ''}>Aprovado</option>
                    <option value="Cancelado" ${orcamento.getStatus().equals('Cancelado') ? 'selected' : ''}>Cancelado</option>
                </select>
            </h5>
        <%
            }
        %>


        <h5>Nome casal: ${usuario.getNomesConcatenados()}</h5>
        <h5>Convidados: ${casamento.getNumeroConvidados()}</h5>
        <h5>Estilo Festa: ${casamento.getEstiloFesta()}</h5>
        <h5>Localidade: ${casamento.getLocalidade()}</h5>
    </div>

    <h3>Observações do casal</h3>
    <p><%= orcamento.getObservacao() %></p>

    <h3>Serviços</h3>
    <table>
        <tr>
            <th>Orcamentos</th>
            <th>Serviço</th>
            <th>Pacote Simples</th>
            <th>Pacote Completo</th>
            <th>Observações</th>
            <th>Valor</th>
        </tr>

        <c:forEach var="detalhe" items="${detalheorcamento}">
            <c:set var="servico" value="${servicoDao.encontrarServicoPorId(detalhe.idServico)}" />
            <tr>
                <td><c:out value="${detalhe.getIdDetalheOrcamento()}" /></td>
                <td><c:out value="${servico.nomeServico}" /></td>
                <td><input type="radio" name="pacote-${detalhe.idServico}" value="simples" ${!detalhe.completo ? "checked" : ""} disabled></td>
                <td><input type="radio" name="pacote-${detalhe.idServico}" value="completo" ${detalhe.completo ? "checked" : ""} disabled></td>
                <td><c:out value="${detalhe.observacaoServico}" /></td>
                <td><input type="text" name="valor-${detalhe.idServico}" class="valor" value="${detalhe.precoEditavel}"></td>
            </tr>
        </c:forEach>

         <td>Valor de serviço</td>
         <td></td>
         <td></td>
         <td></td>
         <td></td>
         <td><input type="text" class="valor"></td>
    </table>

    <button type="button" id="calcularBtn" class="botao">Calcular</button>

    <div class="container">
        <label for="valorTotal">Valor total:</label>
        <input type="text" id="valorTotal" name="valorTotal" value="<%= orcamento.getValorTotal() %>" required readonly>

        <label for="responsavel">Nome do responsável pelo orçamento:</label>
        <input type="text" id="responsavel" name="responsavel" value="<%= orcamento.getNomeOrcador() %>">
    </div>

    <h3>Observações Gerais do Orçados</h3>

    <textarea id="observacoesGerais" name="observacoesGerais" rows="7" cols="50"><%= orcamento.getObservacaoOrcador() %></textarea>
    <button type="submit" id="salvarBtn" class="botao">Salvar</button>
</div>
</form>
</body>
</html>
