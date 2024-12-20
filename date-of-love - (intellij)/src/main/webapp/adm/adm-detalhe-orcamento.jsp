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
        $(document).ready(function(){

            function formatInitialValue(value) {
                    var number = parseFloat(value.replace(',', '.'));
                    return number.toLocaleString('pt-BR', { minimumFractionDigits: 2, maximumFractionDigits: 2 }).replace('.', ',');
            }


             $('.valor').each(function() {
                var precoElement = $(this);
                var initialValue = precoElement.val();

                if (initialValue) {
                    var formattedValue = formatInitialValue(initialValue);
                    precoElement.val(formattedValue);
                }

                precoElement.mask('000.000.000,00', { reverse: true });
            });

            $('#calcularBtn').click(function() {
                var total = 0;
                $('input.valor').each(function() {
                    var value = parseFloat($(this).val().replace(/\./g, '').replace(',', '.')) || 0;
                    total += value;
                });

                var formattedTotal = total.toLocaleString('pt-BR', { minimumFractionDigits: 2, maximumFractionDigits: 2 });
                $('#valorTotal').val(formattedTotal);
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
            <h4>Orçamento - ${orcamento.getIdOrcamento()}</h4>
            <td><input type="hidden" id="idOrcamento" name="idOrcamento" value="${orcamento.getIdOrcamento()}"></td>
            <h4>Valor Estimado: R$ ${orcamento.getValorEstimado()}</h4>
            <h4>Valor Total: R$ ${orcamento.getValorTotal()}</h4>

            <%
                if (orcamento.getStatus().equals("Cancelado")) {
            %>
                <h5>Status:
                    <select name="status" id="status">
                        <option value="Cancelado" selected>Cancelado</option>
                    </select>
                </h5>
            <%
                } else {
            %>
                <h5>Status:
                    <select name="status" id="status">
                        <option value="Pendente" ${orcamento.getStatus().equals('Pendente') ? 'selected' : ''}>Pendente</option>
                        <option value="Andamento" ${orcamento.getStatus().equals('Andamento') ? 'selected' : ''}>Andamento</option>
                        <option value="Esperando Aprovação" ${orcamento.getStatus().equals('Esperando Aprovação') ? 'selected' : ''}>Esperando Aprovação</option>
                        <option value="Aprovado" ${orcamento.getStatus().equals('Aprovado') ? 'selected' : ''}>Aprovado</option>
                        <option value="Cancelado" ${orcamento.getStatus().equals('Cancelado') ? 'selected' : ''}>Cancelado</option>
                    </select>
                </h5>
            <%
                }
            %>
        </div>

    <div class="budget-container2">
        <h4>Nome casal: ${usuario.getNomesConcatenados()}</h4>
        <h4>Convidados: ${casamento.getNumeroConvidados()}</h4>
        <h4>Estilo Festa: ${casamento.getEstiloFesta()}</h4>
        <h4>Localidade: ${casamento.getLocalidade()}</h4>
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

         <td>Acrescimo</td>
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
