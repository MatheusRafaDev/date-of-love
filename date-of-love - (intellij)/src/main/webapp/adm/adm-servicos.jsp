<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.dateoflove.model.Usuario" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="br.com.dateoflove.dao.ServicoDao" %>
<%@ page import="br.com.dateoflove.model.Servico" %>

<%
   Usuario usuario2 = (Usuario) session.getAttribute("usuario2");
   if (usuario2 == null || !usuario2.getEmail().equals("adm")) {
      response.sendRedirect("/login");
      return;
   }
%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adm-servicos.css">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <title>Editar Serviço</title>
</head>

<body>
    <%@ include file="/componente/adm-header.jsp" %>

    <h2 class="texto">Editar Serviço</h2>
    <form action="${pageContext.request.contextPath}/editar-servico" method="post" class="servicos-container">
        <c:forEach var="servico" items="${servico}">
            <div class="servico-item">
                <input type="hidden" name="id_servico" value="${servico.getIdServico()}">
                <label for="nm_servico">Nome do Serviço:</label><br>
                <input type="text" id="nm_servico" name="nm_servico" value="${servico.getNomeServico()}"><br>
                <label for="ds_servico">Descrição do Serviço:</label><br>
                <textarea id="ds_servico" name="ds_servico">${servico.getObservacao()}</textarea><br>
                <label for="ds_valor">Valor:</label><br>
                <input type="number" id="vl_preco" name="vl_preco" value="${servico.getPreco()}" step="0.01"><br>
                <input type="submit" value="Salvar">
            </div>
        </c:forEach>
    </form>
</body>
</html>
