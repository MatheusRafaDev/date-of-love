<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.dateoflove.model.Usuario" %>
<%@ page import="br.com.dateoflove.model.Orcamentos" %>
<%@ page import="java.util.List" %>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("/login");
        return;
    }



    String imagemPath2 = usuario.getImagem();
    String defaultImagePath2 = request.getContextPath() + "/src/assets/images/casal.png";
    String finalImagePath2;

    if (imagemPath2 != null && !imagemPath2.isEmpty()) {
        java.io.File file = new java.io.File(getServletContext().getRealPath(imagemPath2));
        if (file.exists()) {
            finalImagePath2 = request.getContextPath() + imagemPath2;
        } else {
            finalImagePath2 = defaultImagePath2;
        }
    } else {
        finalImagePath2 = defaultImagePath2;
    }
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

    <script>
        var dataAtual = new Date();
        var dataMaxima = new Date(dataAtual.getFullYear(), dataAtual.getMonth() + 9, dataAtual.getDate());
        var dataFormatada = dataMaxima.toISOString().slice(0, 10);

        document.getElementById("data_casamento").setAttribute("min", dataFormatada);
    </script>


</head>
<body>

<%@ include file="/componente/header.jsp" %>

<div class="perfil-casal">
    <div class="row">
        <div class="col-sm-6 mb-3 mb-sm-0">
            <div class="card">
                <div class="card-body">
                    <div class="profile-info">
                        <div class="img-container">
                            <img src="<%= finalImagePath2 %>" alt="Imagem do Casal" class="img-cabecalho">
                            <div class="nomeCasal2"><%= usuario.getNomesConcatenados() %></div>
                            <div class="id">Id: <%= usuario.getIdUsuario() %></div>

                            <div class="form-container2">

                                <form action="${pageContext.request.contextPath}/mandar-imagem" method="post" enctype="multipart/form-data">
                                    <input style="display: none;" name="id" id="id" value="<%= usuario.getIdUsuario() %>">
                                    <label for="image">Escolha uma imagem</label>
                                    <input type="file" name="image" id="image">
                                    <button type="submit" id="btnSalvar" class="btn-salvar2">Salvar</button>
                                </form>

                                <div class="botoes">
                                    <form action="${pageContext.request.contextPath}/remover-foto" method="post">
                                        <input type="hidden" name="idUsuario" value="<%= usuario.getIdUsuario() %>">
                                        <button type="submit" class="btn-remover-foto">Remover Foto</button>
                                    </form>
                                </div>

                           </div>

                        </div>

                        <div class="details">
                            <form action="${pageContext.request.contextPath}/atualizar-usuario" method="post">
                                <input style="display: none;" name="id" id="id" value="<%= usuario.getIdUsuario() %>">

                                <div class="form-group">
                                    <label for="nomeNoivo">Nome do Noivo:</label>
                                    <input type="text" id="nomeNoivo" name="nomeNoivo" class="form-control" value="<%= usuario.getNomeNoivo() %>">
                                </div>
                                <div class="form-group">
                                    <label for="nomeNoiva">Nome da Noiva:</label>
                                    <input type="text" id="nomeNoiva" name="nomeNoiva" class="form-control" value="<%= usuario.getNomeNoiva() %>">
                                </div>

                                <div class="form-group">
                                    <label for="email">Email:</label>
                                    <input type="email" id="email" name="email" class="form-control" value="<%= usuario.getEmail() %>" readonly style="background-color: #e0e0e0; color: #555;">
                                </div>

                                <button type="submit" id="btnSalvar" class="btn-salvar">Salvar</button>

                                <form action="${pageContext.request.contextPath}/deletar-usuario" method="post">
                                    <input type="hidden" name="id" value="<%= usuario.getIdUsuario() %>">
                                    <button type="submit" class="btn-deletar-perfil">Deletar Perfil</button>
                                </form>

                            </form>
                        </div>
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
                                <th scope="col">Ação</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="orcamento" items="${listaOrcamentos}">
                                <tr>
                                    <form action="${pageContext.request.contextPath}/visualizar-orcamento" method="GET">
                                        <td><input type="text" id="id" name="id" value="${orcamento.getIdOrcamento()}"></td>
                                        <td>${orcamento.getNomeOrcador()}</td>
                                        <td>R$ ${orcamento.getValorEstimado()}</td>
                                        <td>R$ ${orcamento.getValorTotal()}</td>
                                        <td>${orcamento.getStatus()}</td>
                                        <td>
                                            <button type="submit" class="btn-visualizar">Visualizar</button>
                                        </td>
                                    </form>

                                    <c:if test="${orcamento.getStatus().equals('Pendente') || orcamento.getStatus().equals('Esperando Aprovação')}">
                                        <form action="${pageContext.request.contextPath}/cancelar" method="POST">
                                            <td>
                                                <input type="hidden" id="idOrcamento" name="idOrcamento" value="${orcamento.getIdOrcamento()}">
                                                <input type="hidden" id="idUsuario" name="idUsuario" value="${usuario.getIdUsuario()}">
                                                <button type="submit" class="btn-visualizar">Cancelar</button>
                                            </td>
                                        </form>
                                    </c:if>
                                </tr>
                            </c:forEach>


                           <tr>
                               <td colspan="5">
                                   <button type="button" class="btn-criar" onclick="window.location.href='<%=request.getContextPath()%>/carregar-criar-orcamento'">Criar Novo Orçamento</button>
                               </td>
                           </tr>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

