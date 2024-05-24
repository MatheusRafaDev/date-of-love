<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.dateoflove.model.Usuario" %>
<%@ page import="br.com.dateoflove.model.Orcamentos" %>
<%@ page import="br.com.dateoflove.dao.OrcamentosDao" %>
<%@ page import="java.util.List" %>

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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adm-orcamento.css">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
</head>
<body>

<%@ include file="/componente/adm-header.jsp" %>

<div class="perfil-casal">
    <div class="card orcamento">
        <div class="card-body">
            <h3>Orçamentos</h3>
            <table class="table">
                <thead class="table-secondary">
                    <tr>
                        <th scope="col">Id.Orçamento</th>
                        <th scope="col">Casal</th>
                        <th scope="col">Orçado por</th>
                        <th scope="col">Valor Orçado</th>
                        <th scope="col">Status</th>
                        <th scope="col">Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <form action="${pageContext.request.contextPath}/orcamento-editar" method="GET">
                        <%
                            OrcamentosDao orcamentosDao = new OrcamentosDao();
                            List<Orcamentos> listaOrcamentos = orcamentosDao.selecionarTodosOrcamentos();

                            for (Orcamentos orcamento : listaOrcamentos) {
                                %>
                                   <tr>
                                       <td><input type="text" id="id" name="id" value="<%= orcamento.getIdOrcamento() %>"></td>
                                       <td><%= orcamento.getNomeOrcador() %></td>
                                       <td>R$ <%= orcamento.getValorMedio() %></td>
                                       <td>R$ <%= orcamento.getValorTotal() %></td>
                                       <td><%= orcamento.getStatus() %></td>
                                       <td>
                                           <button type="submit" class="btn-visualizar">Editar</button>
                                       </td>
                                   </tr>
                                <%
                            }
                        %>
                    </form>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
