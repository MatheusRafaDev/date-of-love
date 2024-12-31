<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.dateoflove.dao.ServicoDao" %>
<%@ page import="br.com.dateoflove.model.Servico" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    // Instancia o DAO e busca todos os serviços
    ServicoDao servicoDao = new ServicoDao();
    List<Servico> servicos = servicoDao.buscarTodosServicos();
    // Define a lista de serviços como um atributo da request
    request.setAttribute("servicos", servicos);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Serviços</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/servicos.css">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</head>
<body>
    <%@ include file="/componente/header.jsp" %>

    <div class="container py-4">
        <h2 class="titulo">Serviços</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Nome do Serviço</th>
                    <th>Descrição Comum</th>
                    <th>Descrição Simples</th>
                    <th>Descrição Premium</th>
                    <th>Descrição Exclusivo</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="servico" items="${servicos}">
                    <tr>
                        <td>${servico.nomeServico}</td>
                        <td>${servico.descricaoComum}</td>
                        <td>${servico.descricaoSimples}</td>
                        <td>${servico.descricaoPremium}</td>
                        <td>${servico.descricaoExclusivo}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <%@ include file="/componente/footer.jsp" %>
</body>
</html>