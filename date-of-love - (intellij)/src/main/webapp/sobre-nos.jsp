<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="br.com.dateoflove.model.Usuario" %>
<%@ page import="br.com.dateoflove.model.Casamento" %>

<% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>
<% Casamento casamento = (Casamento) session.getAttribute("casamento"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sobre-nos.css">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
    <title>Sobre nós</title>
    
</head>

<body>
    <%@ include file="/componente/header.jsp" %>
    
    <div class="sob">
        <h2>Sobre nós</h2>
    </div>
    

        <div class="container">
           
            <p class="texto">
            Desde 2024, a DateOfLove tem sido o destino definitivo para casais que buscam tornar seus sonhos de casamento uma realidade deslumbrante. Fundada pelos visionários Igor Alves, Alexandre Fidelis, Thiago Fernandes e Matheus Rafael, nossa empresa nasceu da paixão por criar momentos verdadeiramente memoráveis para os nossos clientes.
            Com um amplo espaço que abrange desde elegantes salões de festas a jardins exuberantes, a Eventos dos Sonhos oferece o cenário perfeito para celebrar o amor e a união. Nossa equipe altamente capacitada e apaixonada trabalha incansavelmente para garantir que cada detalhe.
            
            Nossa jornada começou com um simples objetivo: proporcionar aos casais uma experiência sem estresse e inesquecível, desde o momento em que pisam em nossas instalações até o último brinde à sua felicidade. Ao longo dos anos, nos tornamos conhecidos por nossa dedicação à excelência, nossa atenção aos detalhes e nosso compromisso inabalável com a satisfação do cliente.
            
            Na DateOfLove, acreditamos que cada casamento é único e especial. É por isso que trabalhamos em estreita colaboração com nossos clientes para entender suas visões e transformá-las em realidade. Desde cerimônias íntimas até celebrações grandiosas, estamos aqui para tornar cada evento verdadeiramente extraordinário.
            
            Junte-se a nós na DateOfLove e deixe-nos transformar sua jornada rumo ao casamento em uma experiência mágica e inesquecível. Porque, para nós, não se trata apenas de planejar um evento; trata-se de criar memórias que durarão para sempre.
        </p>
        </div>

        
    <footer>
        <img src="<%=request.getContextPath()%>/src/assets/images/logobranco.png" alt="Logo" class="brancologo">
        <p>&copy; 2024 Date Of Love. Todos os direitos reservados.<br>Desenvolvido por Alexandre Fidelis, Igor Alves, Matheus Rafael e Thiago Fernandes.
        </p>
    </footer>
</body>
</html>