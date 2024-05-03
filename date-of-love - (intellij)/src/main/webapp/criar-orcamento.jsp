<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="br.com.dateoflove.model.Usuario" %>
<% Usuario usuario = (Usuario) session.getAttribute("usuario");%>

<!DOCTYPE html>
<html lang="pt-br">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/criar-orcamento.css">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
    <title>Criar Orçamento</title>

</head>

<body>
    <header>
            <img src="/src/main/webapp/src/assets/images/logo.png" alt="logo" class="logo"/>
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

    <body>
      <h1>Checklist</h1>

        <div class="checklist">
            <h2>• Cardápio</h2>
            <form id="menuForm1">
                <label>
                    <input type="radio" name="menu" value="simples" checked>
                    Simples
                </label>
                <br>
                <label>
                    <input type="radio" name="menu" value="completo">
                    Completo
                </label>
            </form>
        </div>

        <div class="checklist">
            <h2>• Flores e Decoração</h2>
            <form id="menuForm2">
                <label>
                    <input type="radio" name="menu" value="simples" checked>
                    Simples
                </label>
                <br>
                <label>
                    <input type="radio" name="menu" value="completo">
                    Completo
                </label>
            </form>
        </div>

        <div class="checklist">
            <h2>• Bebidas</h2>
            <form id="menuForm3">
                <label>
                    <input type="radio" name="menu" value="simples" checked>
                    Simples
                </label>
                <br>
                <label>
                    <input type="radio" name="menu" value="completo">
                    Completo
                </label>
            </form>
        </div>

        <div class="checklist">
            <h2>• Doces e Bem-casados</h2>
            <form id="menuForm4">
                <label>
                    <input type="radio" name="menu" value="simples" checked>
                    Simples
                </label>
                <br>
                <label>
                    <input type="radio" name="menu" value="completo">
                    Completo
                </label>
            </form>
        </div>

        <div class="checklist">
            <h2>• Bolo Cenográfico e Bolo de corte</h2>
            <form id="menuForm5">
                <label>
                    <input type="radio" name="menu" value="simples" checked>
                    Simples
                </label>
                <br>
                <label>
                    <input type="radio" name="menu" value="completo">
                    Completo
                </label>
            </form>
        </div>

        <div class="checklist">
            <h2>• Espaço com Mobiliário</h2>
            <form id="menuForm6">
                <label>
                    ✔ Incluso no Pacote
                </label>
            </form>
        </div>

        <div class="checklist">
            <h2>• Coordenação do Dia</h2>
            <form id="menuForm7">
                <label>
                    ✔ Incluso no Pacote
                </label>
            </form>
        </div>

        <div class="checklist">
            <h2>• DJ</h2>
            <form id="menuForm8">
                <label>
                    ✔ Incluso no Pacote
                </label>
            </form>
        </div>

    <button id="verDetalhesBtn">Ver detalhes</button>

    <div class="observacoes">
      <h2>Observações Gerais</h2>
      <textarea id="observacoesInput" rows="4" placeholder="Digite suas observações aqui..."></textarea>
    </div>

    <button id="verDetalhesBtn1">Salvar</button>

</body>
</html>
