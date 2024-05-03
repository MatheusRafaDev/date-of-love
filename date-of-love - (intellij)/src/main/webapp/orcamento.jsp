<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.dateoflove.model.Usuario" %>
<% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>
<%@ page import="br.com.dateoflove.model.DetalheOrcamento" %>
<%@ page import="br.com.dateoflove.dao.ServicoDao" %>
<%@ page import="br.com.dateoflove.model.Servico" %>
<% ServicoDao servicoDao = new ServicoDao();%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/orcamento.css">

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
                <form action="${pageContext.request.contextPath}/perfil" method="GET">
                    <div class="user-items">
                        <input type="text" id="id" name="id" value="${usuario.getIdUsuario()}" style="display: none;">
                        <button type="submit" class="nomeCasal"><%= usuario.getNomesConcatenados() %></button>
                        <img src="<%=request.getContextPath()%>/src/assets/images/casal.png" alt="Foto do Usuário">
                        <a class="sair" href="sair">Sair</a>
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

</body>
</html>
