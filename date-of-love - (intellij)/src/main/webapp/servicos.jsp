<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="br.com.dateoflove.model.Usuario" %>
<%@ page import="br.com.dateoflove.model.Casamento" %>

<% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>
<% Casamento casamento = (Casamento) session.getAttribute("casamento"); %>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Serviços</title>
    <link rel="stylesheet" href="./css/servicos.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
    <link href="https://fonts.googleapis.com/css2?family=Allison&family=Architects+Daughter&display=swap" rel="stylesheet">

</head>

<body>
     <%@ include file="/componente/header.jsp" %>

    <h2 class="servico"> Serviços</h2>
    <hr>
    <section>

        <div class="titulo-servico">
            <p>
                Cardapio
            </p>
        </div>

        <div class="cardapio">
            <button onclick="mostrarSimples('cardapio')" class="botao-simples selecionado">
                <div class="info-cardapio">
                    <div class="servico-titulo">
                        <p> Simples </p>
                    </div>
                    <img src="./src/assets/images/image 3.png" class="pratos">
                    <div class="texto-cardapio">
                        <p>
                            Entradas: <br>
                            Canapés de Salmão Gravlax
                        </p>
                        <p>
                            Pratos Principais: <br>
                            Frango ao Molho de Ervas Finas
                        </p>
                        <p>
                            Sobremesas:<br>
                            Mini Cheesecakes de Frutas Vermelhas
                        </p>
                    </div>
                </div>
            </button>

            <button onclick="mostrarCompleto('cardapio')" class="botao-completo">
                <div class="info-cardapio">
                    <div class="servico-titulo">
                        <p> Completo </p>
                    </div>
                    <img src="./src/assets/images/image 4.png" class="pratos">
                    <div class="texto-cardapio">
                        <p>
                            Entradas: <br>
                            Canapés de Salmão Gravlax<br>
                            Bruschettas de Tomate e Queijo de Cabra
                        </p>
                        <p>
                            Pratos Principais: <br>
                            Frango ao Molho de Ervas Finas <br>
                            Massa Pappardelle com Molho de Tomate e Manjericão
                        </p>
                        <p>
                            Sobremesas:<br>
                            Mini Cheesecakes de Frutas Vermelhas<br>
                            Sorvete de Baunilha com Calda de Caramelo
                        </p>
                    </div>
                </div>
            </button>
        </div>

    </section>

    <section>
        <div class="titulo-servico">
            <p>
                Bolos de Casamento
            </p>
        </div>

        <div class="bolos">
            <button onclick="mostrarBoloSimples('bolos')" class="botao-simples selecionado">
                <div class="info-cardapio">
                    <div class="servico-titulo">
                        <p> Simples </p>
                    </div>
                    <img src="./src/assets/images/image 7.png" class="pratos">
                    <div class="texto-cardapio">

                        <p>
                            O bolo de casamento tem um delicioso sabor de baunilha, proporcionando uma experiência
                            clássica.
                        </p>
                        <p> Um bolo de casamento simples tem três camadas cobertas com buttercream branco, decorado com
                            arabescos delicados.
                            Flores frescas adornam a parte superior, refletindo as cores do casamento.
                        </p>
                    </div>
                </div>
            </button>

            <button onclick="mostrarBoloCompleto('bolos')" class="botao-completo">
                <div class="info-cardapio">
                    <div class="servico-titulo">
                        <p> Completo </p>
                    </div>
                    <img src="./src/assets/images/image 8.png" class="pratos">
                    <div class="texto-cardapio">
                        <p>
                            Clássico Red Velvet com creme de queijo. As camadas de bolo Red Velvet são ricas,
                            úmidas e ligeiramente chocolatudas, contrastando com o cremoso recheio de creme de queijo.
                        </p>
                    </div>
                </div>
            </button>
        </div>

    </section>

    <section>
        <div class="titulo-servico">
            <p>
                Doces e Salgados
            </p>
        </div>

        <div class="doces">
            <button onclick="mostrarDoceSimples('doces')" class="botao-simples selecionado">
                <div class="info-cardapio">
                    <div class="servico-titulo">
                        <p> Simples </p>
                    </div>
                    <img src="./src/assets/images/image 9.png" class="pratos">
                    <div class="texto-cardapio">
                        <p>
                            Doces: <br>
                            Torta de Limão Merengada em Porções Individuais <br>
                            Mini Profiteroles com Creme de Chocolate x80
                            Taças de Mousse de Maracujá x80
                        </p>
                        <p>
                            Salgados: <br>
                            Canapés de Salmão Gravlax x50 <br>
                            Mini Quiches de Queijo e Ervas x50 <br>
                            Espetinhos de Frango Teriyaki x50 <br>
                            Bruschettas de Tomate e Manjericão x50 <br>
                        </p>
                    </div>
                </div>
            </button>

            <button onclick="mostrarDoceCompleto('doces')" class="botao-completo">
                <div class="info-cardapio">
                    <div class="servico-titulo">
                        <p> Completo </p>
                    </div>
                    <img src="./src/assets/images/image 10.png" class="pratos">
                    <div class="texto-cardapio">
                        <p>
                            Doces: <br>
                            Torta de Limão Merengada em Porções Individuais <br>
                            Mini Profiteroles com Creme de Chocolate x80 <br>
                            Taças de Mousse de Maracujá x80
                        </p>
                        <p>
                            Salgados: <br>
                            Estação de Frutos do Mar x80 <br>
                            Risoto de Cogumelos Selvagens com Trufas x80
                            Mini Filé Mignon Wellingtonx50

                        </p>
                    </div>
                </div>
            </button>
        </div>

    </section>

    <section>
        <div class="titulo-servico">
            <p>
                Bebidas
            </p>
        </div>

        <div class="bebidas">
            <button onclick="mostrarBebidaSimples('bebidas')" class="botao-simples selecionado">
                <div class="info-cardapio">
                    <div class="servico-titulo">
                        <p> Simples </p>
                    </div>
                    <img src="./src/assets/images/image 11.png" class="pratos">
                    <div class="texto-cardapio">
                        <p>
                            Não Alcoólicas:
                            Água com Gás e Limão<br>
                            Mocktail de Frutas<br>
                            Chá Gelado de Pêssego<br>
                            Limonada com Manjericão

                        </p>
                        <p>
                            Alcoólicas:
                            Espumante ou Vinho Branco Seco <br>
                            Coquetel de Frutas com Vodka <br>
                            Caipirinha <br>
                            Cerveja Artesanal
                        </p>
                    </div>
                </div>
            </button>

            <button onclick="mostrarBebidaCompleto('bebidas')" class="botao-completo">
                <div class="info-cardapio">
                    <div class="servico-titulo">
                        <p> Completo </p>
                    </div>
                    <img src="./src/assets/images/image 12.png" class="pratos">
                    <div class="texto-cardapio">
                        <p>
                            Não Alcoólicas:
                            Água com Gás e Limão<br>
                            Mocktail de Frutas<br>
                            Chá Gelado de Pêssego<br>
                            Limonada com Manjericão

                        </p>
                        <p>
                            Alcoólicas:
                            Espumante ou Vinho Branco Seco <br>
                            Coquetel de Frutas com Vodka <br>
                            Caipirinha <br>
                            Cerveja Artesanal
                        </p>
                    </div>
                </div>
            </button>
        </div>

    </section>

    <section>
        <div class="titulo-servico">
            <p>
                Flores e Decorações
            </p>
        </div>

        <div class="flores">
            <button onclick="mostrarFloresSimples('flores')" class="botao-simples selecionado">
                <div class="info-cardapio">
                    <div class="servico-titulo">
                        <p> Simples </p>
                    </div>
                    <img src="./src/assets/images/image 15.png" class="pratos">
                    <div class="texto-cardapio">
                        <p>
                            Buquê destaca-se pela elegância com flores da estação. 
                            Arranjos discretos decoram a cerimônia e os centros de mesa são compostos por pequenos arranjos em potes de vidro.
                            Guirlandas simples e elementos naturais.

                        </p>
                        <p>
                            A decoração inclui iluminação suave, tecidos leves e detalhes encantadores, como cartões decorativos e marcadores de mesa. 
                            O foco é na harmonia e simplicidade, criando uma celebração autêntica e charmosa.
                        </p>
                    </div>
                </div>
            </button>

            <button onclick="mostrarFloresCompleto('flores')" class="botao-completo">
                <div class="info-cardapio">
                    <div class="servico-titulo">
                        <p> Completo </p>
                    </div>
                    <img src="./src/assets/images/image 16.png" class="pratos">
                    <div class="texto-cardapio">
                        <p>
                            O buquê da noiva brilha com a elegância de flores da estação, refletindo simplicidade e sofisticação. 
                            Os arranjos discretos marcam corredores e o altar, enquanto centros de mesa encantam com pequenos arranjos em potes de vidro. 
                            Guirlandas e elementos naturais adicionam charme a áreas específicas.
                    </div>
                </div>
            </button>
        </div>

    </section>

</body>

</html>