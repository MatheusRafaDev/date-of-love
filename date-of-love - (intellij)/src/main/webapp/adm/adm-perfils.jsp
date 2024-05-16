<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar Perfis</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adm-perfils.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
</head>

<body>
    <%@ include file="/componente/adm-header.jsp" %>

    <h2>Listar da usuários</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome Noivo</th>
                <th>Nome Noiva</th>
                <th>Email</th>
                <th>Data de Cadastro</th>
                <th>Acão</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="usuario" items="${usuarios}">
                <tr>
                    <td>${usuario.getIdUsuario()}</td>
                    <td>${usuario.getNomeNoivo()}</td>
                    <td>${usuario.getNomeNoiva()}</td>
                    <td>${usuario.getEmail()}</td>
                    <td>${usuario.getDataCadastro()}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/carregar-usuario-unico" method="get">
                            <input type="hidden" name="idUsuario" value="${usuario.getIdUsuario()}">
                            <input type="hidden" name="email" value="${usuario.getEmail()}">
                            <button type="submit" class="botao">Ver Perfil</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
