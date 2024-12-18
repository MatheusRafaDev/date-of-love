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
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">

    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
    <title>Date Of Love</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>

</head>
<body>
    <%@ include file="/componente/header.jsp" %>


       <div class="container-fluid p-0">
           <div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
               <div class="carousel-inner">
                   <div class="carousel-item active">
                       <img src="<%=request.getContextPath()%>/src/assets/images-home/casal.jpg" class="d-block w-100 carousel-image" alt="slide 1">
                   </div>
                   <div class="carousel-item">
                       <img src="<%=request.getContextPath()%>/src/assets/images-home/casal2.jpg" class="d-block w-100 carousel-image" alt="slide 2">
                   </div>
                   <div class="carousel-item">
                       <img src="<%=request.getContextPath()%>/src/assets/images-home/casal3.jpg" class="d-block w-100 carousel-image" alt="slide 3">
                   </div>
               </div>
               <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
                   <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                   <span class="visually-hidden">Previous</span>
               </button>
               <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
                   <span class="carousel-control-next-icon" aria-hidden="true"></span>
                   <span class="visually-hidden">Next</span>
               </button>
           </div>
       </div>







        <div class="container21">
            <h2 class="titulo">Quem somos</h2>
            <p class="descricao">Seja bem-vindo ao universo de celebrações e experiências únicas!</p>
            <p class="descricao">Date of Love é especialista em transformar sonhos em realidade e tornar momentos especiais em memórias inesquecíveis.</p>
            <p class="descricao">Com mais de 13 anos no mercado de eventos, nossa equipe é apaixonada por oferecer serviços de excelência, criatividade e inovação.</p>
            <button class="botaoquem" onclick="window.location.href='<%=request.getContextPath()%>/sobre-nos.jsp'">Nossa História</button>
        </div>

        <div class="container3">
            <h2 class="titulo">O melhor da festa é esperar por ela!</h2>
            <p class="descricao">No mundo atual, onde o tempo é escasso, ter tranquilidade em todo o processo de planejamento do casamento é fundamental para que o casal possa aproveitar todos os preparativos e a organização do grande dia livre de preocupações.</p>
            <p class="descricao">Por isso, além do tom intimista, na Date of Love, queremos proporcionar praticidade e conforto para que você aproveite cada momento.</p>
        </div>


        <section id="base">
            <div class="fotos">

                <div class="row">

                    <div class="box">
                        <img src="<%=request.getContextPath()%>/src/assets/images-home/icones/cardapio.png" />
                        <span> Cardápio <br>Completo</span>
                    </div>

                    <div class="box">
                        <img src="<%=request.getContextPath()%>/src/assets/images-home/icones/bebidas.png" />
                        <span> Bebidas </span>
                    </div>

                    <div class="box">
                        <img src="<%=request.getContextPath()%>/src/assets/images-home/icones/bolo.png" />
                        <span> Bolo Cenográfico e <br>Bolo de Corte</span>
                    </div>

                    <div class="box">
                        <img src="<%=request.getContextPath()%>/src/assets/images-home/icones/espaco.png" />
                        <span> Espaço com <br>Mobiliário </span>
                    </div>

                    <div class="box">
                        <img src="<%=request.getContextPath()%>/src/assets/images-home/icones/flores.png" />
                        <span> Flores e <br>Decoração </span>
                    </div>


                    <div class="box">
                        <img src="<%=request.getContextPath()%>/src/assets/images-home/icones/assessoria.png" />
                        <span> Coordenação <br>do Dia</span>
                    </div>

                    <div class="box">
                        <img src="<%=request.getContextPath()%>/src/assets/images-home/icones/DJ.png" />
                        <span> DJ </span>
                    </div>

                    <div class="box">
                        <img src="<%=request.getContextPath()%>/src/assets/images-home/icones/doces.png" />
                        <span> Doces e <br>Bem-Casados</span>
                    </div>

                </div>
            </div>

            <h1>Reunimos fornecedores e parceiros incríveis para a melhor festa da sua vida!</h1>
        </section>

        <div class="Estrutura">

            <div class="boxestru">
                <img src="<%=request.getContextPath()%>/src/assets/images-home/Hall de Entrada.png" />
                <h1>Hall de Entrada</h1>
                <p>Com uma decoração intimista,<br>
                    nosso hall de entrada é um cantinho<br>
                    personalizado e cheio de significado.</p>
            </div>

            <div class="boxestru">
                <img src="<%=request.getContextPath()%>/src/assets/images-home/cerimonias.png" />
                <h1> Local para Cerimônias</h1>
                <p>Com toda a estrutura e decoração<br>
                    necessária para fazer uma festa
                    incrível</p>
            </div>

            <div class="boxestru">
                <img src="<%=request.getContextPath()%>/src/assets/images-home/salao Principal.png" />
                <h1>Salão Principal</h1>
                <p>com pé direito de 5 metros<br>
                    (capacidade para 350 pessoas sentadas)</p>
            </div>

            <div class="boxestru">
                <img src="<%=request.getContextPath()%>/src/assets/images-home/gastro.png" />
                <h1>Gastronomia Exclusiva</h1>
                <p>Em nossa busca por excelência<br>
                    gastronômica, desenvolvemos um<br>
                    conceito inovador de “gastronomia<br>
                    própria”.</p>
            </div>

            <div class="boxestru">
                <img src="<%=request.getContextPath()%>/src/assets/images-home/bar.png" />
                <h1>Bar exclusivo</h1>
                <p>É o momento dos convidados sentarem<br>
                    com os amigos para experimentar<br>
                    drinks irresistíveis e se divertirem a<br>
                    noite toda!</p>
            </div>

            <div class="boxestru">
                <img src="<%=request.getContextPath()%>/src/assets/images-home/acessoria.png" />
                <h1>Assessoria</h1>
                <p>E a partir deste momento os noivos<br>
                    podem pensar mais neles e na família<br>
                    porque tudo o resto vai estar muito<br>
                    bem entregue!</p>
            </div>

        </div>

        <div class="partecasal">
            <div class="textoemo">
                <p>
                    • Foyer com 190 m² com mezanino<br>
                    • Área externa para fumantes com jardim vertical<br>e cascata<br>
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
                    • Bombeiro de plantão
                </p>
            </div>
        </div>

        <div class="fundopretocominfo">
            <h2>Gastronomia</h2>
            <p>Em nossa busca por excelência gastronômica, desenvolvemos um conceito<br>
                inovador de “gastronomia própria”. Isso significa que cada prato servido<br>
                em nosso buffet foi cuidadosamente concebido e preparado de maneira exclusiva,<br>
                levando em consideração o equilíbrio perfeito de sabores, a apresentação<br>
                impecável e a qualidade dos ingredientes.<br><br>
                Oferecemos também menus especiais para diabéticos,<br>
                celíacos, vegetarianos e crianças.</p>

        </div>

        <div class="fundopretocominfo2">

            <div class="fimpagina">
                <div class="fimpag">
                    <h3>Menus</h3>
                    <p1>Qual o melhor serviço para o seu casamento?<br><br>
                        Isso vai depender do estilo que vocês desejam imprimir no evento, ou<br>
                        seja, formal ou informal. Para que a escolha seja bem-feita,<br>
                        será necessário definir a quantidade de<br>
                        pessoas na sua lista, conhecer os aspectos de cada serviço e se adequar ao melhor<br>
                        formato, considerando a quantidade e o perfil dos convidados. Conheça os gostos e<br>
                        costumes dos seus familiares e amigos e sua escolha será assertiva.<br><br>
                        Conheça as duas opções de menus do Espaço!</p1>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="/componente/footer.jsp" %>
</body>
</html>
