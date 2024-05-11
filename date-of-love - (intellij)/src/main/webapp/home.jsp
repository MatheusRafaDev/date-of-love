<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="br.com.dateoflove.model.Usuario" %>
<%@ page import="br.com.dateoflove.model.Casamento" %>

<% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>
<% Casamento casamento = (Casamento) session.getAttribute("casamento"); %>


<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/home.js">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
    <link href="https://fonts.googleapis.com/css2?family=Allison&family=Architects+Daughter&display=swap" rel="stylesheet">
    <title>Home</title>
</head>
<body>

<%@ include file="/componente/header.jsp" %>

<section class="slider">
    <div class="slider-content">
        <input type="radio" name="btn-radio" id="radio1">
        <input type="radio" name="btn-radio" id="radio2">
        <input type="radio" name="btn-radio" id="radio3">

        <div class="slide-box primeiro">
            <img class="img-desktop" src="/img - home/slide-1.jpg" alt="slide 1">
            <img class="img-mobile" src="/img - home/slide-1-mob.jpg" alt="slide 1">
        </div>

        <div class="slide-box">
            <img class="img-desktop" src="/img - home/slide-2.jpg" alt="slide 3">
            <img class="img-mobile" src="/img - home/slide-2-mob.jpg" alt="slide 1">
        </div>

        <div class="slide-box">
            <img class="img-desktop" src="/img - home/slide-3.jpg" alt="slide 3">
            <img class="img-mobile" src="/img - home/slide-3-mob.jpg" alt="slide 3">
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

<section id="sobre">
    <div class="container2">
        <img src="/img - home/casal2.png" alt="imagemcasal" class="casal2">
        <h2>Quem somos</h2>
        <p>Seja bem-vindo ao universo de celebrações e experiências únicas!</p>
        <p>Date of Love é especialista em transformar sonhos em realidade</p>
        <p>e tornar momentos especiais em memórias inesquecíveis.</p>
        <p>São mais de 13 anos no mercado de eventos e uma equipe </p>
        <p>apaixonada por oferecer serviços de excelência, criatividade e inovação.</p>
        <button class="botaoquem">Nossa História </button>
    </div>
</section>

<section class="conteudo">
    <div class="container3">
        <h2>O melhor da festa é esperar por ela!</h2>
        <p>No mundo atual, onde o tempo é escasso, ter <br>
            tranquilidade em todo o processo de planejamento do<br>
            casamento é fundamental para que o casal possa<br>
            aproveitar todos os preparativos e a organização do<br>grande dia livre de preocupações.<br>
            Por isso, além do tom intimista, na Date Of love<br>
            queremos proporcionar praticidade.</p>
        <button>Descubra o que está incluso<br>na nossa “Festa Completa”!</button>
    </div>

    <div class="imagens">
        <div class="imagem"><img src="/img - home/icones/cardapio.png" alt="Imagem 1"></div>
        <div class="imagem"><img src="/img - home/icones/bebidas.png" alt="Imagem 2"></div>
        <div class="imagem"><img src="/img - home/icones/bolo.png" alt="Imagem 3"></div>
        <div class="imagem"><img src="/img - home/icones/espaco.png" alt="Imagem 4"></div>
    </div>

    <div class="completo"><p>Cardápio <br> Completo</p></div>
    <div class="completo1"><p>Bebidas</p></div>
    <div class="completo2"><p>Bolo Cenográfico e<br> Bolo de Corte</p></div>
    <div class="completo3"><p>Espaço com<br>Mobiliário</p></div>

    <div class="imagens">
        <div class="imagem"><img src="/img - home/icones/flores.png" alt="Imagem 1"></div>
        <div class="imagem"><img src="/img - home/icones/assessoria.png" alt="Imagem 2"></div>
        <div class="imagem"><img src="/img - home/icones/DJ.png" alt="Imagem 3"></div>
        <div class="imagem"><img src="/img - home/icones/doces.png" alt="Imagem 4"></div>
    </div>

    <div class="completo4"><p>Flores e  <br> Decoração</p></div>
    <div class="completo5"><p>Coordenação <br> do Dia</p></div>
    <div class="completo6"><p>DJ</p></div>
    <div class="completo7"><p>Doces e<br>Bem-Casados</p></div>

    <h5>Reunimos fornecedores e parceiros incríveis para a melhor festa da sua vida!</h5>
    <button00>Estrutura DateOfLove</button00>
    <div class="Estrutura">
        <div class="estr"><img src="/img - home/Hall de Entrada.png" alt="Imagem 1"></div>
        <div class="estr"><img src="/img - home/cerimonias.png" alt="Imagem 2"></div>
        <div class="estr"><img src="/img - home/Salão Principal.png" alt="Imagem 3"></div>
    </div>
    <button01>                                           </button01>
    <button01>                                           </button01>
    <button01>                                           </button01>

    <div class="completo8"><p>Hall de Entrada </p></div>
    <div class="completo9"><p>Local para Cerimônias</p></div>
    <div class="completo10"><p>Salão Principal</p></div>

    <div class="iestru"><p>Com uma decoração intimista,<br> nosso hall de entrada é um cantinho<br> personalizado e cheio de significado.</p></div>
    <div class="iestru1"><p>Com toda a estrutura e decoração<br> necessária para fazer uma festa<br> incrível</p></div>
    <div class="iestru2"><p>com pé direito de 5 metros<br> (capacidade para 350 pessoas sentadas)</p></div>

    <div class="Estrutura">
        <div class="estr"><img src="/img - home/gastro.png" alt="Imagem 1"></div>
        <div class="estr"><img src="/img - home/bar.png" alt="Imagem 2"></div>
        <div class="estr"><img src="/img - home/acessoria.png" alt="Imagem 3"></div>
    </div>
    <button01>                                            </button01>
    <button01>                                           </button01>
    <button01>                                           </button01>

    <div class="completo11"><p>Gastronomia Exclusiva </p></div>
    <div class="completo12"><p>Bar exclusivo</p></div>
    <div class="completo13"><p>Assessoria</p></div>

    <div class="iestru4"><p>Em nossa busca por excelência <br> gastronômica, desenvolvemos um <br> conceito inovador de “gastronomia<br>própria”.</p></div>
    <div class="iestru1"><p>É o momento dos convidados sentarem<br> com os amigos para experimentar <br> drinks irresistíveis e se divertirem a<br>noite toda!</p></div>
    <div class="iestru3"><p>E a partir deste momento os noivos<br>podem pensar mais neles e na família<br>porque tudo o resto vai estar muito<br>bem entregue! </p></div>

    <div class="partecasal">
        <img src="/img - home/icones/casaemo.png" alt="imagem do casal png ">
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
        <div class="infosfundo">
            <h2>Gastronomia</h2>
            <p>Em nossa busca por excelência gastronômica, desenvolvemos um conceito<br> inovador de “gastronomia própria”. Isso significa que cada prato servido<br> em nosso buffet foi cuidadosamente concebido e preparado de maneira exclusiva,<br> levando em consideração o equilíbrio perfeito de sabores, a apresentação<br> impecável e a qualidade dos ingredientes.<br>
                <br>Oferecemos também menus especiais para diabéticos,<br> celíacos, vegetarianos e crianças.</p>
        </div>

        <div class="infosfundo2">
            <h3>Menus</h3>
            <p>Qual o melhor serviço para o seu casamento?<br><br>Isso vai depender do estilo que vocês desejam imprimir no evento, ou<br> seja, formal ou informal. Para que a escolha seja bem-feita,<br> será necessário definir a quantidade de<br> pessoas na sua lista, conhecer os aspectos de cada serviço e se adequar ao melhor<br> formato, considerando a quantidade e o perfil dos convidados. Conheça o gostos e<br> costumes dos seus familiares e amigos e sua escolha será assertiva.<br>

                <br>Conheça as duas opções de menus do Espaço!</p>
        </div>
        <div class="infosfundoimagem"><img src="/img - home/icones/logoGastro.png"> </div>
        <div class="infosfundoimagem1"><img src="/img - home/icones/flores png 1.png"></div>
        <div class="infosfundoimagem2"><img src="/img - home/icones/floresmetade.png"></div>
    </div>

    <div class="fundopretocominfo2">
        <div class="Gastroimagens">
            <div class="Pola1"><img src="/img - home/ref1.png"></div>
            <div class="Pola2"><img src="/img - home/ref2.png"></div>
        </div>

        <div class="fimpagina">
            <div class="fimpag">
                <div class="casalfim"><img src="/img - home/FOTO COM QUADRO.png"></div>
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

        <footer class="rodape">
            <p>© 2024 Date Of Love. Todos os direitos reservados.<br>Desenvolvido por Alexandre Fidelis, Igor Alves, Matheus Rafael e Thiago Fernandes</p>
            <div class="rodafoto"><img src="/img - home/logodateoflove.png"></div>
        </footer>
    </div>
</section>