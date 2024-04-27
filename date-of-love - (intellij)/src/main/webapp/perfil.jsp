<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="br.com.dateoflove.model.Usuario" %>
<% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/perfil.css">
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
                                <img src="<%=request.getContextPath()%>/src/assets/images/casalDoAno.png" alt="Imagem do Casal" class="img-cabecalho">
                                <div class="nomeCasal"><%= usuario.getNomesConcatenados() %></div>
                                <div class="dataCasamento">Data do Casamento: <%= new SimpleDateFormat("dd/MM/yyyy").format(usuario.getDataCasamento()) %></div>
                                <div class="id">Id: <%= usuario.getIdUsuario() %></div>
                            </div>
                            <div class="details">
                                <div class="form-group">
                                    <label for="nomeNoivo">Nome do Noivo:</label>
                                    <input type="text" id="nomeNoivo" class="form-control" value="<%= usuario.getNomeNoivo() %>" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="nomeNoiva">Nome da Noiva:</label>
                                    <input type="text" id="nomeNoiva" class="form-control" value="<%= usuario.getNomeNoiva() %>" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="email">Email:</label>
                                    <input type="email" id="email" class="form-control" value="<%= usuario.getEmail() %>" readonly>
                                </div>
                                <button id="btnSalvar" class="btn-salvar">Salvar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="col-sm-6">
                <div class="card orcamento">
                    <div class="card-body">
                        <h5 class="card-title titulo-tabela">Orçamento</h5>
                        <div class="container text-center">
                            <table class="table">
                                <thead class="table-secondary">
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Orçado por</th>
                                        <th scope="col">Nº Convidados</th>
                                        <th scope="col">Orçamento</th>
                                        <th scope="col">Visualizar</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>123123</td>
                                        <td>Tio Thif</td>
                                        <td>100</td>
                                        <td>R$50.000,00</td>
                                        <td><a href="#" class="btn-visualizar">Visualizar</a></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
