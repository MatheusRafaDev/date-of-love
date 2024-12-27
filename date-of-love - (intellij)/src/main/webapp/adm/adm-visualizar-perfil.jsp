<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.dateoflove.model.Usuario" %>
<%@ page import="br.com.dateoflove.model.Orcamentos" %>

<%@ page import="java.util.List" %>

<%

  Usuario usuario2 = (Usuario) session.getAttribute("usuario2");
  Usuario usuarioperfil = (Usuario) session.getAttribute("usuarioperfil");
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adm-visualizar-perfil.css">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
</head>
<body>

 <%@ include file="/componente/adm-header.jsp" %>

    <div class="perfil-casal">
        <div class="row">
            <div class="col-sm-6 mb-3 mb-sm-0">
                <div class="card">
                    <div class="card-body">
                        <div class="profile-info">
                            <div class="img-container">
                                <div class="nomeCasal2" ><%= usuarioperfil.getNomesConcatenados() %></div>
                                <div class="id">Id: <%= usuarioperfil.getIdUsuario() %></div>
                            </div>

                            <div class="details">

                                <div class="form-group">
                                    <label for="nomeNoivo">Nome do Noivo:</label>
                                    <input type="text" id="nomeNoivo" class="form-control" value="<%= usuarioperfil.getNomeNoivo() %>" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="nomeNoiva">Nome da Noiva:</label>
                                    <input type="text" id="nomeNoiva" class="form-control" value="<%= usuarioperfil.getNomeNoiva() %>" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="email">Email:</label>
                                    <input type="email" id="email" class="form-control" value="<%= usuarioperfil.getEmail() %>" readonly>
                                </div>

                            </div>
                        </div>
                    </div>
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
                                            <th scope="col">Valor Estimado</th>
                                            <th scope="col">Valor total</th>
                                            <th scope="col">Status</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="orcamento" items="${listaOrcamentos}">
                                            <tr>
                                                <form action="${pageContext.request.contextPath}/orcamento" method="GET">
                                                    <td>${orcamento.getIdOrcamento()}</td>
                                                    <td>${orcamento.getNomeOrcador()}</td>
                                                    <td>R$ ${orcamento.getValorEstimado()}</td>
                                                    <td>R$ ${orcamento.getValorTotal()}</td>
                                                    <td>${orcamento.getStatus()}</td>
                                                </form>
                                            </tr>
                                        </c:forEach>

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
