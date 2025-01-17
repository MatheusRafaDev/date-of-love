<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.dateoflove.model.Usuario" %>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajuda</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ajuda3.css">
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/src/assets/images/favicon.ico">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-cuKkm2YlNU7mF5z3ZyD5G9fR9PpKcoZX3WqcxE8Tt1ZzQW1ytTmS0POsb3qzYWQf" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</head>
<body>
    <%@ include file="/componente/header.jsp" %>

    <main>
        <h3 class="text-center mb-4">Ajuda</h3>
        <section class="duvida-box">
            <h4>Descreva sua dúvida</h4>
            <div id="erroMensagem" style="color: red; display: none;"></div>
            <form action="${pageContext.request.contextPath}/enviar-duvida" method="post">
                <input class="email" type="text" name="nome" placeholder="Digite seu nome aqui...">
                <input class="email" type="text" name="email" placeholder="Digite seu email aqui...">
                <textarea class="texto" name="mensagem" placeholder="Digite sua dúvida aqui..."></textarea>
                <button type="submit" class="-">Enviar</button>
            </form>
        </section>

        <section class="perguntas">
            <h4>Perguntas frequentes</h4>
            <div class="faq-container">
                <div class="faq-item">
                    <div class="question" onclick="toggleAnswer(this)">Quantas pessoas cabem no Espaço?</div>
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
                    <div class="answer">Não cobramos rolhas de whiskies, vinhos e espumantes. As cervejas e o bar de caipirinha já estão inclusos no pacote!</div>
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
        </section>
    </main>

    <%@ include file="/componente/footer.jsp" %>


    <script>
        function validarFormulario() {
            var nome = document.getElementById("nome").value;
            var email = document.getElementById("email").value;
            var mensagem = document.getElementById("mensagem").value;
            var erroMensagem = document.getElementById("erroMensagem");

            erroMensagem.style.display = "none";
            erroMensagem.innerHTML = "";

            if (nome === "" || email === "" || mensagem === "") {
                erroMensagem.style.display = "block";
                erroMensagem.innerHTML = "Todos os campos são obrigatórios!";
                return false;  // Impede o envio do formulário
            }

            var regexEmail = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
            if (!regexEmail.test(email)) {
                erroMensagem.style.display = "block";
                erroMensagem.innerHTML = "Por favor, insira um e-mail válido.";
                return false;
            }

            return true;
        }

        function toggleAnswer(element) {
            const answer = element.nextElementSibling;
            answer.classList.toggle('show');
        }
    </script>
</body>
</html>
