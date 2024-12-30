<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.dateoflove.model.Usuario" %>
<%@ page import="br.com.dateoflove.model.Servico" %>
<%@ page import="java.util.List" %>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("login");
        return;
    }

    List<Servico> servicos = (List<Servico>) request.getAttribute("servicos");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/criar-orcamento1.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
    <script src="${pageContext.request.contextPath}/js/criar-orcamento.js"></script>
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

                <c:forEach var="servico" items="${servicos}">
                    <tr>
                        <td>${servico.nomeServico}</td>
                        <td>
                            <select name="servico${servico.idServico}" class="styled-select">
                                <option value="simples">Simples - ${servico.descricaoSimples}</option>
                                <option value="cumum">Comum - ${servico.descricaoComum}</option>
                                <option value="premium">Premium - ${servico.descricaoPremium}</option>
                                <option value="exclusivo">Exclusivo - ${servico.descricaoExclusivo}</option>
                            </select>
                        </td>
                    </tr>
                </c:forEach>
            </table>

            <div class="input-container">
                <label for="quantidadePessoas">Quantidade de Convidados (máx. 700):</label>
                <input type="number" name="quantidadePessoas" id="quantidadePessoas" min="100" max="700" placeholder="Digite o número de convidados" required />
                <label id="quantidadeFeedback" style="color: red; display: none;">A quantidade deve ser entre 100 e 700.</label>

                <h3>Data do casamento</h3>
                <input type="date" id="dataCasamento" name="dataCasamento" />
                <label id="dataFeedback" style="color: red; display: none;">Data inválida! A data deve ser 9 meses após a data atual.</label>

                <h3>Local do Casamento</h3>
                <div class="local-casamento">
                    <label for="localFazenda" class="local-option">
                        <input type="radio" name="localCasamento" value="fazenda" id="localFazenda" required>
                        <img src="<%=request.getContextPath()%>/img/fazenda.jpeg" alt="Fazenda">
                        <span>Fazenda</span>
                    </label>
                    <label for="localPraia" class="local-option">
                        <input type="radio" name="localCasamento" value="praia" id="localPraia" required>
                        <img src="<%=request.getContextPath()%>/img/praia.png" alt="Praia">
                        <span>Praia</span>
                    </label>
                    <label for="localIgreja" class="local-option">
                        <input type="radio" name="localCasamento" value="igreja" id="localIgreja" required>
                        <img src="<%=request.getContextPath()%>/img/igreja.jpg" alt="Igreja">
                        <span>Igreja</span>
                    </label>
                </div>

                <h3>Tipo de Cerimônia</h3>
                <select name="tipoCerimonia" required class="styled-select">
                    <option value="religiosa">Religiosa</option>
                    <option value="ambas">Civil e Religiosa</option>
                </select>

                <h3>Forma de Pagamento</h3>
                <select name="formaPagamento" required class="styled-select">
                    <option value="avista">À vista</option>
                    <option value="parcelado">Parcelado</option>
                    <option value="financiado">Financiado</option>
                </select>

                <h3>Valor Estimado</h3>
                <input type="text" name="orcamentoMedio" id="orcamentoMedio" placeholder="Informe o orçamento estimado" class="input-text vl_total">
                <div id="valorEstimadoFeedback" style="color: red; display: none;"></div>

                <h3>Observações Gerais</h3>
                <textarea rows="7" cols="50" name="observacao"></textarea>

                <h3>Comentários Adicionais</h3>
                <textarea rows="7" cols="50" name="comentarios"></textarea>

                <button type="submit" class="criar-button">Criar Orçamento</button>
            </div>
        </form>
    </div>

</body>
</html>