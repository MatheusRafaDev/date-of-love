<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.dateoflove.model.Usuario" %>
<%@ page import="br.com.dateoflove.model.Casamento" %>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    Casamento casamento = (Casamento) session.getAttribute("casamento");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home/home-cont.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home/home-slide.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home/home-style.css">
        <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">


    <title>Date Of Love</title>

</head>
<body>
   <%@ include file="/componente/header.jsp" %>

<header>
    <section class="slider">
        <div class="slider-content">
            <input type="radio" name="btn-radio" id="radio1">
            <input type="radio" name="btn-radio" id="radio2">
            <input type="radio" name="btn-radio" id="radio3">

            <div class="slide-box primeiro">
                <img class="img-desktop" src="<%=request.getContextPath()%>/src/assets/images-home/slide-1.jpg" alt="slide 1">
                <img class="img-mobile" src="<%=request.getContextPath()%>/src/assets/images-home/slide-1-mob.jpg" alt="slide 1">
            </div>

            <div class="slide-box">
                <img class="img-desktop" src="<%=request.getContextPath()%>/src/assets/images-home/slide-2.jpg" alt="slide 2">
                <img class="img-mobile" src="<%=request.getContextPath()%>/src/assets/images-home/slide-2-mob.jpg" alt="slide 2">
            </div>

            <div class="slide-box">
                <img class="img-desktop" src="<%=request.getContextPath()%>/src/assets/images-home/slide-3.jpg" alt="slide 3">
                <img class="img-mobile" src="<%=request.getContextPath()%>/src/assets/images-home/slide-3-mob.jpg" alt="slide 3">
            </div>

            <div class="nav-auto">
                <div class="auto-btn1"></div>
                <div class="auto-btn2"></div>
                <div class="auto-btn3"></div>
            </div>

            <div class="nav-manual">
                <label for="radio1" class="manual-btn"></label>
                <label for="radio2" class="manual-btn"></label>
                <label for="radio3" class="manual-btn"></label>
            </div>
        </div>
    </section>
</header>

<section id="base">
    <div class="container2"><img src="<%=request.getContextPath()%>/src/assets/images-home/casal2.png" alt="imagemcasal" class="casal2"> </div>

    <div class="container21">
        <h2>Quem somos</h2>
        <p>Seja bem-vindo ao universo de celebrações e experiências únicas!</p>
        <p>Date of Love é especialista em transformar sonhos em realidade</p>
        <p>e tornar momentos especiais em memórias inesquecíveis.</p>
        <p>São mais de 13 anos no mercado de eventos e uma equipe </p>
        <p>apaixonada por oferecer serviços de excelência, criatividade e inovação.</p>
        <button class="botaoquem">Nossa História </button>
    </div>

    <div class="container3">
        <h2>O melhor da festa é esperar por ela!</h2>
        <p>No mundo atual, onde o tempo é escasso, ter <br>
            tranquilidade em todo o processo de planejamento do<br
            >casamento é fundamental para que o casal possa<br>
            aproveitar todos os preparativos e a organização do<br>grande dia livre de preocupações.<br>
            Por isso, além do tom intimista, na Date Of love<br>
            queremos proporcionar praticidade.</p>
            <button>Descubra o que está incluso<br>na nossa “Festa Completa”!</button>
    </div>

    <div class="fotos">

    <div class="box">
        <img src="<%=request.getContextPath()%>/src/assets/images-home/icones/cardapio.png"/>
        <span> Cardápio <br>
            Completo

            </span>
    </div>
    <div class="box">
        <img src="<%=request.getContextPath()%>/src/assets/images-home/icones/bebidas.png"/>
        <span> Bebidas </span>
    </div>
    <div class="box">
        <img src="<%=request.getContextPath()%>/src/assets/images-home/icones/bolo.png"/>
        <span> Bolo Cenográfico e <br>
            Bolo de Corte</span>
    </div>
    <div class="box">
        <img src="<%=request.getContextPath()%>/src/assets/images-home/icones/espaco.png"/>
        <span> Espaço com <br>
            Mobiliário </span>
    </div>

    </div>

    <div class="fotos1">

    <div class="box1">
        <img src="<%=request.getContextPath()%>/src/assets/images-home/icones/flores.png"/>
        <span> Flores e <br>
            Decoração </span>
    </div>
    <div class="box1">
        <img src="<%=request.getContextPath()%>/src/assets/images-home/icones/assessoria.png"/>
        <span> Coordenação <br>
            do Dia</span>
    </div>
    <div class="box1">
        <img src="<%=request.getContextPath()%>/src/assets/images-home/icones/DJ.png"/>
        <span> DJ </span>
    </div>
    <div class="box1">
        <img src="<%=request.getContextPath()%>/src/assets/images-home/icones/doces.png"/>
        <span> Doces e <br>
            Bem-Casados</span>
    </div>
</div>

<h1>Reunimos fornecedores e parceiros incríveis para a melhor festa da sua vida!</h1>

</div>

<div class="Estrutura">

    <div class="boxestru">
        <img src="<%=request.getContextPath()%>/src/assets/images-home/Hall de Entrada.png"/>
        <h1>Hall de Entrada</h1>
        <p>Com uma decoração intimista,<br>
            nosso hall de entrada é um cantinho<br>
            personalizado e cheio de significado.</p>
    </div>


    <div class="boxestru">
        <img src="<%=request.getContextPath()%>/src/assets/images-home/cerimonias.png"/>
        <h1> Local para Cerimônias</h1>
        <p>Com toda a estrutura e decoração<br>
            necessária para fazer uma festa
            incrível</p>
    </div>

    <div class="boxestru">
        <img src="<%=request.getContextPath()%>/src/assets/images-home/Salão Principal.png"/>
        <h1>Salão Principal</h1>
        <p>com pé direito de 5 metros<br>
            (capacidade para 350 pessoas sentadas)</p>
    </div>

    <div class="Estrutura1">

        <div class="boxestru">
            <img src="<%=request.getContextPath()%>/src/assets/images-home/gastro.png"/>
            <h1>Gastronomia Exclusiva</h1>
            <p>Em nossa busca por excelência<br>
                gastronômica, desenvolvemos um<br>
                conceito inovador de “gastronomia<br>
                própria”.</p>
        </div>


        <div class="boxestru">
            <img src="<%=request.getContextPath()%>/src/assets/images-home/bar.png"/>
            <h1>Bar exclusivo</h1>
            <p>É o momento dos convidados sentarem<br>
                com os amigos para experimentar<br>
                drinks irresistíveis e se divertirem a<br>
                noite toda!

                </p>
        </div>

        <div class="boxestru">
            <img src="<%=request.getContextPath()%>/src/assets/images-home/acessoria.png"/>
            <h1>Assessoria</h1>
            <p>E a partir deste momento os noivos<br>
                podem pensar mais neles e na família<br>
                porque tudo o resto vai estar muito<br>
                bem entregue!</p>
        </div>

</div>

<div class="partecasal">
    <img src="<%=request.getContextPath()%>/src/assets/images-home/icones/casaemo.png" alt="imagem do casal png ">
    <div class="textoemo"><p>
        • Foyer com 190 m² com mezanino<br>
        • Área externa para fumantes com jardim vertical <br>e cascata<br>
        • Sala VIP com banheira de relaxamento<br>
        • Estacionamento próprio com serviço de Valet<br>
        • Equipe de seguranças<br>
        • Gerador de alta capacidade<br>
        • Sistema de isolamento acústico<br>
        • Sistema de ar condicionado central<br>
        • Camarins<br>
        • Chapelaria<br>
        • Coffee Bar<br>
        • Cozinha ampla e equipada<br>
        • Acessibilidade<br>
        • Bombeiro de plantão</p></div>
</div>

<div class="fundopretocominfo">
    <h2>Gastronomia</h2>
    <p>Em nossa busca por excelência gastronômica, desenvolvemos um conceito<br> inovador de “gastronomia própria”. Isso significa que cada prato servido<br> em nosso buffet foi cuidadosamente concebido e preparado de maneira exclusiva,<br> levando em consideração o equilíbrio perfeito de sabores, a apresentação<br> impecável e a qualidade dos ingredientes.<br>
    <br>Oferecemos também menus especiais para diabéticos,<br> celíacos, vegetarianos e crianças.</p>
    <h3>Menus</h3>
    <p1>Qual o melhor serviço para o seu casamento?<br><br>Isso vai depender do estilo que vocês desejam imprimir no evento, ou<br> seja, formal ou informal. Para que a escolha seja bem-feita,<br> será necessário definir a quantidade de<br> pessoas na sua lista, conhecer os aspectos de cada serviço e se adequar ao melhor<br> formato, considerando a quantidade e o perfil dos convidados. Conheça o gostos e<br> costumes dos seus familiares e amigos e sua escolha será assertiva.<br>
    <br>Conheça as duas opções de menus do Espaço!</p1>

</div>

<div class="infosfundoimagem"><img src="<%=request.getContextPath()%>/src/assets/images-home/icones/logoGastro.png"> </div>

<div class="backpng"><img src="<%=request.getContextPath()%>/src/assets/images-home/icones/floresmetade.png"> </div>

<div class="fundopretocominfo2"><div class="Gastroimagens">
    <div class="pola1"><img src="<%=request.getContextPath()%>/src/assets/images-home/ref1.png"></div>
    <div class="pola2"><img src="<%=request.getContextPath()%>/src/assets/images-home/ref2.png"></div>
</div>

<div class="fimpagina"><div class="fimpag">
    <div class="casalfim"><img src="<%=request.getContextPath()%>/src/assets/images-home/FOTO COM QUADRO.png"></div>
    <h1>Festa <br>Completa</h1>
    <p>
        Planejar o casamento dos<br>
        sonhos envolve muitas etapas<br>
        importantes. São diversos<br>
        detalhes que precisam ser<br>
        bem alinhados e definidos para<br>
        que tudo saia do jeito que você<br>
        gostaria.
        </p>
</div>

</div>
<div class="bn"><button02>SAIBA MAIS</button02></div>

</section>

</body>
<footer class="rodape">
    <p>© 2024 Date Of Love. Todos os direitos reservados.<br>Desenvolvido por Alexandre Fidelis, Igor Alves, Matheus Rafael e Thiago Fernandes</p>
    <div class="rodafoto"><img src="<%=request.getContextPath()%>/src/assets/images-home/logobranco.png"></div>
</footer>
</html>
