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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adm-orcamento2.css">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
</head>
<body>

<%@ include file="/componente/adm-header.jsp" %>

<div class="perfil-casal">
    <div class="card orcamento">
        <div class="card-body">
            <h3>Orçamentos</h3>
            <table class="table-orcamentos">
                <thead>
                    <tr>
                        <th>Nome do Serviço</th>
                        <th>Descrição do Serviço</th>
                        <th>Valor</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="servico" items="${servico}">
                        <tr>
                            <td>
                                <form action="${pageContext.request.contextPath}/editar-servico" method="post">
                                    <input type="hidden" name="id_servico" value="${servico.getIdServico()}">
                                    <input type="text" name="nm_servico" value="${servico.getNomeServico()}">
                            </td>
                            <td>
                                    <textarea name="ds_servico">${servico.getObservacao()}</textarea>
                            </td>
                            <td>
                                    <input type="text" name="vl_preco" value="${servico.getPreco()}" class="vl_preco">
                            </td>
                            <td>
                                    <button type="submit" value="Salvar" class="btn-visualizar">Salvar</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
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
