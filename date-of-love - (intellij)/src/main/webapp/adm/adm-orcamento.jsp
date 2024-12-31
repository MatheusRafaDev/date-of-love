<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.dateoflove.model.Usuario" %>
<%@ page import="br.com.dateoflove.model.Orcamentos" %>
<%@ page import="br.com.dateoflove.dao.OrcamentosDao" %>
<%@ page import="br.com.dateoflove.dao.UsuarioDao" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
   Usuario usuario2 = (Usuario) session.getAttribute("usuario2");
   if (usuario2 == null || !usuario2.getEmail().equals("adm")) {
      response.sendRedirect("/login");
      return;
   }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adm/adm-orcamento1.css">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
</head>
<body>

<%@ include file="/componente/adm-header.jsp" %>

<div class="perfil-casal">
    <h3>Orçamentos</h3>
    <div class="card orcamento">
        <div class="card-body">
            <table class="table-orcamentos">
                <thead>
                    <tr>
                        <th>Id.Orçamento</th>
                        <th>Casal</th>
                        <th>Orçado por</th>
                        <th>Valor Estimado</th>
                        <th>Valor Total</th>
                        <th>Status</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        OrcamentosDao orcamentosDao = new OrcamentosDao();
                        List<Orcamentos> listaOrcamentos = orcamentosDao.selecionarTodosOrcamentos();
                        for (Orcamentos orcamento : listaOrcamentos) {
                            int idUsuario = orcamento.getIdUsuario();
                            UsuarioDao usuarioDao = new UsuarioDao();
                            Usuario usuario3 = usuarioDao.buscarUsuarioPorId(idUsuario);
                    %>
                        <tr>
                            <td><%= orcamento.getIdOrcamento() %></td>
                            <td><%= usuario3 != null ? usuario3.getNomesConcatenados() : "Nome do usuário não encontrado" %></td>
                            <td><%= orcamento.getNomeOrcador() %></td>
                            <td>R$ <fmt:formatNumber value="<%= orcamento.getValorEstimado() %>" type="currency" currencySymbol=""/></td>
                            <td>R$ <fmt:formatNumber value="<%= orcamento.getValorTotal() %>" type="currency" currencySymbol=""/></td>
                            <td><%= orcamento.getStatus() %></td>
                            <td>
                                <form action="${pageContext.request.contextPath}/detalhe-orcamento" method="GET">
                                    <input type="hidden" name="id" value="<%= orcamento.getIdOrcamento() %>">
                                    <button type="submit" class="btn-visualizar">Editar</button>
                                </form>
                            </td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>