<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

   <%@ include file="/componente/header.jsp" %>

    <div class="card">
        <h3>Checklist</h3>
        <form action="${pageContext.request.contextPath}/criar-orcamento" method="POST">
            <table class="checklist-table">
                <tr>
                    <th>Serviço</th>
                    <th>Opções</th>
                </tr>
                <tr>
                    <td>Cardápio</td>
                    <td>
                        <select name="servico1">
                            <option value="simples">Simples</option>
                            <option value="completo">Completo</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Flores e Decoração</td>
                    <td>
                        <select name="servico2">
                            <option value="simples">Simples</option>
                            <option value="completo">Completo</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Bebidas</td>
                    <td>
                        <select name="servico3">
                            <option value="simples">Simples</option>
                            <option value="completo">Completo</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Doces e Bem-casados</td>
                   <td>
                       <select name="servico4">
                            <option value="simples">Simples</option>
                            <option value="completo">Completo</option>
                        </select>
                   </td>
                </tr>
                <tr>
                    <td>Bolo Cenográfico e Bolo de corte</td>
                    <td>
                        <select name="servico5">
                            <option value="simples">Simples</option>
                            <option value="completo">Completo</option>
                        </select>
                    </td>
                </tr>

                </table>

                <h3>Ja incluso no Pacote</h3>
                <table class="checklist-table">
                <tr>
                    <td>Espaço com Mobiliário</td>
                    <td>
                            <label>
                                <input type="checkbox" name="menu6" checked disabled>
                                Incluso no Pacote
                            </label>
                    </td>
                </tr>
                <tr>
                    <td>Coordenação do Dia</td>
                    <td>
                        <label>
                            <input type="checkbox" name="menu7" checked disabled>
                            Incluso no Pacote
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>DJ</td>
                    <td>
                        <label>
                            <input type="checkbox" name="menu8" checked disabled>
                            Incluso no Pacote
                        </label>
                    </td>
                </tr>
            </table>

            <h3>Observações Gerais</h3>
            <textarea rows="7" cols="50" name="observacao"></textarea>

            <button type="submit" class="criar-button">Criar Orçamento</button>
         </form>

         <button class="detalhes" href="/servicos.jsp" >Detalhes</button>
    </div>
</body>
</html>
