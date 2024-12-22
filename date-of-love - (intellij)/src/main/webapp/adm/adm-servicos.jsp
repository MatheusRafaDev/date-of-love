<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.dateoflove.model.Usuario" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="br.com.dateoflove.dao.ServicoDao" %>
<%@ page import="br.com.dateoflove.model.Servico" %>
<%@ page import="java.text.DecimalFormat" %>

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
    <title>Editar Serviço</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/adm-servicos.css">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
</head>
<body>

<%@ include file="/componente/adm-header.jsp" %>

<div class="perfil-casal">
    <h3>Orçamentos</h3>
    <c:forEach var="servico" items="${servico}">
        <div class="service-card">
            <form action="${pageContext.request.contextPath}/editar-servico" method="post">
                <input type="hidden" name="id_servico" value="${servico.idServico}">

                <div class="form-group">
                    <label for="nm_servico_${servico.idServico}">Nome do Serviço</label>
                    <input type="text" id="nm_servico_${servico.idServico}" name="nm_servico" value="${servico.nomeServico}">
                </div>

                <div class="card-container">
                    <div class="service-sub-card">
                        <h4>Simples</h4>
                        <div class="form-group">
                            <label for="vl_preco_simples_${servico.idServico}">Preço Simples</label>
                            <input type="text" id="vl_preco_simples_${servico.idServico}" name="vl_preco_simples" value="${servico.precoSimples}" class="vl_preco">
                        </div>
                        <div class="form-group">
                            <label for="ds_simples_${servico.idServico}">Descrição Simples</label>
                            <textarea id="ds_simples_${servico.idServico}" name="ds_simples">${servico.descricaoSimples}</textarea>
                        </div>
                    </div>

                    <div class="service-sub-card">
                        <h4>Comum</h4>
                        <div class="form-group">
                            <label for="vl_preco_comum_${servico.idServico}">Preço Comum</label>
                            <input type="text" id="vl_preco_comum_${servico.idServico}" name="vl_preco_comum" value="${servico.precoComum}" class="vl_preco">
                        </div>
                        <div class="form-group">
                            <label for="ds_comum_${servico.idServico}">Descrição Comum</label>
                            <textarea id="ds_comum_${servico.idServico}" name="ds_comum">${servico.descricaoComum}</textarea>
                        </div>
                    </div>

                    <div class="service-sub-card">
                        <h4>Premium</h4>
                        <div class="form-group">
                            <label for="vl_preco_premium_${servico.idServico}">Preço Premium</label>
                            <input type="text" id="vl_preco_premium_${servico.idServico}" name="vl_preco_premium" value="${servico.precoPremium}" class="vl_preco">
                        </div>
                        <div class="form-group">
                            <label for="ds_premium_${servico.idServico}">Descrição Premium</label>
                            <textarea id="ds_premium_${servico.idServico}" name="ds_premium">${servico.descricaoPremium}</textarea>
                        </div>
                    </div>

                    <div class="service-sub-card">
                        <h4>Exclusivo</h4>
                        <div class="form-group">
                            <label for="vl_preco_exclusivo_${servico.idServico}">Preço Exclusivo</label>
                            <input type="text" id="vl_preco_exclusivo_${servico.idServico}" name="vl_preco_exclusivo" value="${servico.precoExclusivo}" class="vl_preco">
                        </div>
                        <div class="form-group">
                            <label for="ds_exclusivo_${servico.idServico}">Descrição Exclusivo</label>
                            <textarea id="ds_exclusivo_${servico.idServico}" name="ds_exclusivo">${servico.descricaoExclusivo}</textarea>
                        </div>
                    </div>
                </div>

                <button type="submit" value="Salvar" class="btn-visualizar">Salvar</button>
            </form>
        </div>
    </c:forEach>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
<script>
    $(document).ready(function(){

        function formatInitialValue(value) {
            var number = parseFloat(value.replace(',', '.'));
            return number.toLocaleString('pt-BR', { minimumFractionDigits: 2, maximumFractionDigits: 2 }).replace('.', ',');
        }

        $('.vl_preco').each(function() {
            var precoElement = $(this);
            var initialValue = precoElement.val();

            if (initialValue) {
                var formattedValue = formatInitialValue(initialValue);
                precoElement.val(formattedValue);
            }

            precoElement.mask('000.000.000,00', { reverse: true });
        });
    });
</script>

</body>
</html>