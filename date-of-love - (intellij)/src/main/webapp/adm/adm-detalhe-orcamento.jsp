<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="br.com.dateoflove.model.Usuario" %>
<%@ page import="br.com.dateoflove.model.DetalheOrcamento" %>
<%@ page import="br.com.dateoflove.model.Orcamentos" %>
<%@ page import="br.com.dateoflove.dao.ServicoDao" %>
<%@ page import="br.com.dateoflove.model.Servico" %>
<%@ page import="java.util.List" %>

<%
    ServicoDao servicoDao = new ServicoDao();
    Orcamentos orcamento = (Orcamentos) session.getAttribute("orcamento");

    Usuario usuario2 = (Usuario) session.getAttribute("usuario2");

    if (usuario2 == null || !usuario2.getEmail().equals("adm")) {
        response.sendRedirect("/login");
        return;
    }

    List<DetalheOrcamento> detalheorcamento = (List<DetalheOrcamento>) session.getAttribute("detalheorcamento");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adm-detalhe-orcamento2.css">
    <title>Visualizar Orçamento</title>

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Inputmask -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/inputmask/5.0.7/jquery.inputmask.min.js"></script>
</head>
<body>
    <%@ include file="/componente/adm-header.jsp" %>

    <div class="card">
        <form action="${pageContext.request.contextPath}/editar-orcamento" method="POST">

            <div class="orcamento-header">
                <h1>Orçamento - ${orcamento.getIdOrcamento()}</h1>
                <p><strong>Orçador:</strong> <input type="text" name="nomeOrcador" value="${orcamento.getNomeOrcador()}" /></p>
                <p><strong>Status:</strong>
                    <select name="status">
                        <option value="Pendente" ${orcamento.getStatus() == 'Pendente' ? 'selected' : ''}>Pendente</option>
                        <option value="Andamento" ${orcamento.getStatus() == 'Andamento' ? 'selected' : ''}>Andamento</option>
                        <option value="Esperando Aprovação" ${orcamento.getStatus() == 'Esperando Aprovação' ? 'selected' : ''}>Esperando Aprovação</option>
                        <option value="Aprovado" ${orcamento.getStatus() == 'Aprovado' ? 'selected' : ''}>Aprovado</option>
                        <option value="Cancelado" ${orcamento.getStatus() == 'Cancelado' ? 'selected' : ''}>Cancelado</option>
                    </select>
                </p>
            </div>

            <div class="orcamento-details">
                <h3>Detalhes do Orçamento</h3>
                <div class="orcamento-summary">
                    <div><strong>Valor Total:</strong> R$ <input type="text" name="valorTotal" class="money" value="${orcamento.getValorTotal()}" /></div>
                    <div><strong>Valor Estimado:</strong> R$ <input type="text" name="valorEstimado" class="money" value="${orcamento.getValorEstimado()}" /></div>
                    <div><strong>Data de Criação:</strong> ${orcamento.getDataOrcamento()}</div>
                </div>
            </div>

            <h3>Detalhes dos Serviços</h3>
            <table class="checklist-table">
                <thead>
                    <tr>
                        <th>Serviço</th>
                        <th>Opções</th>
                        <th>Observações</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="detalhe" items="${detalheorcamento}">
                        <c:set var="servico" value="${servicoDao.encontrarServicoPorId(detalhe.idServico)}" />
                        <tr>
                            <td>${servico.nomeServico}</td>
                            <td>
                                <select name="servico${detalhe.idServico}" class="styled-select">
                                    <option value="simples" ${fn:escapeXml(detalhe.tipo) == 'S' ? "selected" : ""}>
                                        Simples - ${servico.descricaoSimples}
                                    </option>
                                    <option value="comum" ${fn:escapeXml(detalhe.tipo) == 'C' ? "selected" : ""}>
                                        Comum - ${servico.descricaoComum}
                                    </option>
                                    <option value="premium" ${fn:escapeXml(detalhe.tipo) == 'P' ? "selected" : ""}>
                                        Premium - ${servico.descricaoPremium}
                                    </option>
                                    <option value="exclusivo" ${fn:escapeXml(detalhe.tipo) == 'E' ? "selected" : ""}>
                                        Exclusivo - ${servico.descricaoExclusivo}
                                    </option>
                                </select>
                            </td>
                            <td><textarea name="observacaoServico${detalhe.idServico}" rows="3" cols="30">${detalhe.observacaoServico}</textarea></td>
                            <td>R$ <input type="text" name="precoEditavel${detalhe.idServico}" class="money" value="${detalhe.precoEditavel}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <div class="orcamento-observacoes">
                <div><strong>Observações Gerais:</strong> <textarea name="observacao" rows="3" cols="50">${orcamento.getObservacao()}</textarea></div>
                <div><strong>Observações do Orçador:</strong> <textarea name="observacaoOrcador" rows="3" cols="50">${orcamento.getObservacaoOrcador()}</textarea></div>
            </div>

            <div class="form-actions">
                <input type="hidden" id="idOrcamento" name="idOrcamento" value="${orcamento.getIdOrcamento()}">
                <button type="submit" class="botao">Salvar</button>
            </div>
        </form>

        <c:if test="${!orcamento.isAprovado() && 'Esperando Aprovação'.equals(orcamento.getStatus())}">
            <form action="${pageContext.request.contextPath}/aprovar-orcamento" method="POST" class="aprovar-form">
                <input type="hidden" id="idOrcamento" name="idOrcamento" value="${orcamento.getIdOrcamento()}">
                <input type="hidden" id="idUsuario" name="idUsuario" value="${usuario.getIdUsuario()}">
                <button type="submit" class="aprovar-btn">Aprovar Orçamento</button>
            </form>
        </c:if>
    </div>

</body>
</html>