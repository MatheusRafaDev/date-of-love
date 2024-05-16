<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.dateoflove.model.Usuario" %>
<%@ page import="br.com.dateoflove.model.Orcamento" %>
<%@ page import="br.com.dateoflove.model.Casamento" %>
<%@ page import="java.util.List" %>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return; // Importante adicionar um return aqui para parar a execução após o redirecionamento
    }

    Casamento casamento = (Casamento) session.getAttribute("casamento");

    String imagemPath2 = usuario.getImagem();
    String defaultImagePath2 = request.getContextPath() + "/src/assets/images/casal.png";
    String finalImagePath2 = (imagemPath2 != null && !imagemPath2.isEmpty()) ? request.getContextPath() + imagemPath2 : defaultImagePath2;
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/perfil.css">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
</head>
<body>

<%@ include file="/componente/header.jsp" %>

<div class="perfil-casal">
    <div class="row">
        <div class="col-sm-6 mb-3 mb-sm-0">
            <div class="card">
            </div>
        </div>

        <div class="col-sm-6">
            <div class="card orcamento">
                <div class="card-body">
                    <h5 class="card-title titulo-tabela">Orçamentos</h5>
                    <div class="container text-center">
                        <div class="table-wrapper">
                            <table class="table">
                                <thead class="table-secondary">
                                <tr>
                                    <th scope="col">Id.Orçamento</th>
                                    <th scope="col">Orçado por</th>
                                    <th scope="col">Valor Orçado</th>
                                    <th scope="col">Status</th>
                                    <th scope="col"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="orcamento" items="${listaOrcamentos}">
                                    <tr>
                                        <form action="${pageContext.request.contextPath}/orcamento" method="GET">
                                            <td>${orcamento.getIdOrcamento()}</td>
                                            <td>${orcamento.getNomeOrcador()}</td>
                                            <td>${orcamento.getValorOrçado()}</td>
                                            <td>${orcamento.getStatus()}</td>
                                            <td>
                                                <button type="submit" class="btn-visualizar" onclick="window.location.href='/detalhe-orcamento-adm.jsp?id=${orcamento.getIdOrcamento()}">Editar</button>
                                            </td>
                                        </form>

                                        <c:if test="${orcamento.getStatus().equals('Pendente') || orcamento.getStatus().equals('Esperando Aprovação')}">
                                            <form action="${pageContext.request.contextPath}/cancelar" method="POST">
                                                <td>
                                                    <input type="hidden" id="idOrcamento" name="idOrcamento" value="${orcamento.getIdOrcamento()}">
                                                    <input type="hidden" id="idUsuario" name="idUsuario" value="${usuario.getIdUsuario()}">
                                                    <button type="submit" class="btn-visualizar" onclick="return confirm('Tem certeza que deseja cancelar este orçamento?')">Cancelar</button>
                                                </td>
                                            </form>
                                        </c:if>
                                    </tr>
                                </c:forEach>

                                <tr>
                                    <td colspan="5">

                                    </td>
                                </tr>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
