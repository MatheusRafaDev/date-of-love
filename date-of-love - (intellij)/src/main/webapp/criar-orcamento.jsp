<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="br.com.dateoflove.model.Usuario" %>
<%@ page import="br.com.dateoflove.model.Casamento" %>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    Casamento casamento = (Casamento) session.getAttribute("casamento");
%>

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
                   <button type="submit" class="nomeCasal">
                       <%= usuario.getNomesConcatenados() %>
                   </button>
                   <img src="<%=request.getContextPath()%>/src/assets/images/casal.png" alt="Foto do Usuário">
                   <a class="sair" href="sair">Sair</a>
               </div>
           </form>
       </div>
   </header>

    <h1>Checklist</h1>

    <table class="checklist-table">
        <caption>Serviços</caption>
        <tr>
            <th>Serviço</th>
            <th>Opções</th>
        </tr>
        <tr>
            <td>Cardápio</td>
            <td>
                <form id="menuForm1">
                    <label>
                        <input type="radio" name="menu1" value="simples" checked>
                        Simples
                    </label>
                    <label>
                        <input type="radio" name="menu1" value="completo">
                        Completo
                    </label>
                </form>
            </td>
        </tr>
        <tr>
            <td>Flores e Decoração</td>
            <td>
                <form id="menuForm2">
                    <label>
                        <input type="radio" name="menu2" value="simples" checked>
                        Simples
                    </label>
                    <label>
                        <input type="radio" name="menu2" value="completo">
                        Completo
                    </label>
                </form>
            </td>
        </tr>
        <tr>
            <td>Bebidas</td>
            <td>
                <form id="menuForm3">
                    <label>
                        <input type="radio" name="menu3" value="simples" checked>
                        Simples
                    </label>
                    <label>
                        <input type="radio" name="menu3" value="completo">
                        Completo
                    </label>
                </form>
            </td>
        </tr>
        <tr>
            <td>Doces e Bem-casados</td>
            <td>
                <form id="menuForm4">
                    <label>
                        <input type="radio" name="menu4" value="simples" checked>
                        Simples
                    </label>
                    <label>
                        <input type="radio" name="menu4" value="completo">
                        Completo
                    </label>
                </form>
            </td>
        </tr>
        <tr>
            <td>Bolo Cenográfico e Bolo de corte</td>
            <td>
                <form id="menuForm5">
                    <label>
                        <input type="radio" name="menu5" value="simples" checked>
                        Simples
                    </label>
                    <label>
                        <input type="radio" name="menu5" value="completo">
                        Completo
                    </label>
                </form>
            </td>
        </tr>
        <tr>
            <td>Espaço com Mobiliário</td>
            <td>
                <form id="menuForm6">
                    <label>
                        <input type="checkbox" name="menu6" checked disabled>
                        Incluso no Pacote
                    </label>
                </form>
            </td>
        </tr>
        <tr>
            <td>Coordenação do Dia</td>
            <td>
                <form id="menuForm7">
                    <label>
                        <input type="checkbox" name="menu7" checked disabled>
                        Incluso no Pacote
                    </label>
                </form>
            </td>
        </tr>
        <tr>
            <td>DJ</td>
            <td>
                <form id="menuForm8">
                    <label>
                        <input type="checkbox" name="menu8" checked disabled>
                        Incluso no Pacote
                    </label>
                </form>
            </td>
        </tr>
    </table>

     <div class="observacao">
            <label for="observacao">Observação:</label>
            <textarea id="observacao" name="observacao" rows="4" cols="50"></textarea>
     </div>

</body>
</html>
