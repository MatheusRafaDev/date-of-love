<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.dateoflove.model.Usuario" %>
<%@ page import="br.com.dateoflove.model.Casamento" %>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    Casamento casamento = (Casamento) session.getAttribute("casamento");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajuda</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ajuda.css">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AjudaFAQ.css">
</head>
<body>
    <%@ include file="/componente/header.jsp" %>

    <h2 class="ajuda">Ajuda</h2>

    <div class="duvida-box">
        <h2>Descreva sua dúvida</h2>
        <form action="${pageContext.request.contextPath}/enviarDuvida" method="post">
            <input class="texto" type="text" name="duvida" placeholder="Digite sua dúvida aqui...">
            <button type="submit" class="btn btn-primary btn-sm">Enviar</button>
        </form>
    </div>

    <div class="perguntas">
        <h2>PERGUNTAS FREQUENTES</h2>
        
        <div class="faq-container">
            <div class="faq-item">
                <div class="question" onclick="toggleAnswer(this)">Quantas pessoas cabem no Espaço?
                </div>
                <div class="answer">A capacidade do Espaço Quintal é de 50 a 350 convidados (incluindo os noivos).</div>
            </div>
            <div class="faq-item">
                <div class="question" onclick="toggleAnswer(this)">Quero casar no sábado! Existe alguma restrição?</div>
                <div class="answer">O Espaço recebe aos sábados apenas eventos a partir de 200 convidados, contratados dentro do pacote “festa completa”.</div>
            </div>
            <div class="faq-item">
                <div class="question" onclick="toggleAnswer(this)">Posso alterar a decoração do Espaço?</div>
                <div class="answer">Decorações externas não serão permitidas no Espaço. A logística, formatação e montagem do evento são de nossa responsabilidade. Os contratantes não estão autorizados a mudar móveis ou objetos de decoração de lugar, nem trazer itens decorativos externos.</div>
            </div>
            <div class="faq-item">
                <div class="question" onclick="toggleAnswer(this)">O Espaço cobra rolha de bebidas adicionais?</div>
                <div class="answer">Não cobramos rolhas de whiskies, vinhos e espumantes. As cervejas e o bar de caipirinha já estão inclusos no pacotes!.</div>
            </div>
            <div class="faq-item">
                <div class="question" onclick="toggleAnswer(this)">O casal ou um dos noivos não mora em SP. Como fazemos?</div>
                <div class="answer">As reuniões com a coordenação e decoração poderão ser realizadas via Zoom ou Google Meeting, mediante agendamento prévio.</div>
            </div>
            <div class="faq-item">
                <div class="question" onclick="toggleAnswer(this)">Como reservar uma data?</div>
                <div class="answer">As datas são reservadas com uma entrada de 25% do valor total do contrato. O restante pode ser pago de forma parcelada.</div>
            </div>
            <div class="faq-item">
                <div class="question" onclick="toggleAnswer(this)">Qual a duração da festa?</div>
                <div class="answer">As festas têm duração de 8 horas, com possibilidade de contratação de hora extra.</div>
            </div>
        </div>

    </div>



    
        <script>
            function toggleAnswer(element) {
                const answer = element.nextElementSibling;
                answer.classList.toggle('show');
            }
        </script>
    </body>
</html>