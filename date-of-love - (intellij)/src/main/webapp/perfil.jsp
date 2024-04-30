<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.dateoflove.model.Usuario" %>
<%@ page import="br.com.dateoflove.model.Orcamentos" %>
<%@ page import="br.com.dateoflove.model.Casamento" %>

<% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>
<% Casamento casamento = (Casamento) session.getAttribute("casamento"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/perfil2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
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
            <div class="user-items">
                <a class="nome" href="/perfil.jsp"><%= usuario.getNomesConcatenados() %></a>
                <img src="<%=request.getContextPath()%>/src/assets/images/casal.png" alt="Foto do Usuário">
                <a class="sair" href="sair">Sair</a>
            </div>
        </div>
    </header>

    <div class="perfil-casal">
        <div class="row">
            <div class="col-sm-6 mb-3 mb-sm-0">
                <div class="card">
                    <div class="card-body">
                        <div class="profile-info">
                            <div class="img-container">
                                <img src="<%=request.getContextPath()%>/src/assets/images/casal.png" alt="Imagem do Casal" class="img-cabecalho">
                                <div class="nomeCasal"><%= usuario.getNomesConcatenados() %></div>
                                <div class="id">Id: <%= usuario.getIdUsuario() %></div>
                            </div>

                            <div class="details">
                                <form action="${pageContext.request.contextPath}/criar-usuario" method="PUT">

                                        <div class="form-group">
                                            <label for="nomeNoivo">Nome do Noivo:</label>
                                            <input type="text" id="nomeNoivo" class="form-control" value="<%= usuario.getNomeNoivo() %>">
                                        </div>
                                        <div class="form-group">
                                            <label for="nomeNoiva">Nome da Noiva:</label>
                                            <input type="text" id="nomeNoiva" class="form-control" value="<%= usuario.getNomeNoiva() %>">
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Email:</label>
                                            <input type="email" id="email" class="form-control" value="<%= usuario.getEmail() %>">
                                        </div>
                                        <div class="form-group">
                                            <label for="dataCasamento">Data do Casamento:</label>
                                            <input type="date" id="dataCasamento" class="form-control" value="<%= new SimpleDateFormat("yyyy-MM-dd").format(casamento.getDataCasamento()) %>">
                                        </div>

                                         <div class="form-group">
                                               <label for="localizacao">Localização</label>
                                               <input type="text" id="localizacao" name="localizacao" class="form-control" value="<%= casamento.getLocalidade() %>">
                                         </div>

                                         <div class="form-group">
                                              <label for="num_convidados">Número de Convidados</label>
                                              <input type="number" id="num_convidados" name="num_convidados" class="form-control" value="<%= casamento.getNumeroConvidados() %>">
                                         </div>

                                         <div class="form-group">
                                               <label for="num_convidados">Estilo festa</label>
                                               <input type="text" id="estilo_festa" name="estilo_festa" class="form-control" value="<%= casamento.getEstiloFesta() %>">
                                         </div>

                                    <button type="submit" id="btnSalvar" class="btn-salvar">Salvar</button>
                                </form>
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
                                            <th scope="col">Valor total</th>
                                            <th scope="col">Status</th>
                                            <th scope="col">Ação</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="orcamento" items="${listaOrcamentos}">
                                            <tr>
                                                <form action="${pageContext.request.contextPath}/orcamento" method="GET">
                                                    <td><input type="text" id="id" name="id" value="${orcamento.getIdOrcamento()}"></td>
                                                    <td>${orcamento.getNomeOrcador()}</td>
                                                    <td>${orcamento.getValorTotal()}</td>
                                                    <td>${orcamento.getStatus()}</td>
                                                    <td>
                                                        <button type="submit" class="btn-visualizar">Visualizar</button>
                                                    </td>
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
