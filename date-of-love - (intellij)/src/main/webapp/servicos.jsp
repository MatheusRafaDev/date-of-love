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
    <title>Serviços</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/servicos3.css">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
</head>

<body>
    <%@ include file="/componente/header.jsp" %>

    <div class="container py-4">
        <h2 class="text-center mb-4">Serviços</h2>


        <section class="mb-4">
            <h3 class="mb-3">Cardápio</h3>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <button class="btn btn-outline-success w-100" onclick="mostrarSimples('cardapio')">
                        <div class="card">
                            <img src="./src/assets/images/image 3.png" class="card-img-top" alt="Simples">
                            <div class="card-body">

                                <h5 class="card-title">Simples</h5>
                                <p class="card-text">Entradas: Canapés de Salmão Gravlax<br>Pratos Principais: Frango ao Molho de Ervas Finas<br>Sobremesas: Mini Cheesecakes de Frutas Vermelhas</p>
                            </div>
                        </div>
                    </button>
                </div>

                <div class="col-md-6 mb-3">
                    <button class="btn btn-outline-success w-100" onclick="mostrarCompleto('cardapio')">
                        <div class="card">
                            <img src="./src/assets/images/image 4.png" class="card-img-top" alt="Completo">
                            <div class="card-body">
                                <h5 class="card-title">Completo</h5>
                                <p class="card-text">Entradas: Canapés de Salmão Gravlax, Bruschettas de Tomate e Queijo de Cabra<br>Pratos Principais: Frango ao Molho de Ervas Finas, Massa Pappardelle com Molho de Tomate e Manjericão<br>Sobremesas: Mini Cheesecakes de Frutas Vermelhas, Sorvete de Baunilha com Calda de Caramelo</p>
                            </div>
                        </div>
                    </button>
                </div>
            </div>
        </section>


        <section class="mb-4">
            <h3 class="mb-3">Bolos de Casamento</h3>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <button class="btn btn-outline-warning w-100" onclick="mostrarBoloSimples('bolos')">
                        <div class="card">
                            <img src="./src/assets/images/image 7.png" class="card-img-top" alt="Bolo Simples">
                            <div class="card-body">
                                <h5 class="card-title">Simples</h5>
                                <p class="card-text">O bolo de casamento tem um delicioso sabor de baunilha, proporcionando uma experiência clássica.</p>
                            </div>
                        </div>
                    </button>
                </div>

                <div class="col-md-6 mb-3">
                    <button class="btn btn-outline-warning w-100" onclick="mostrarBoloCompleto('bolos')">
                        <div class="card">
                            <img src="./src/assets/images/image 8.png" class="card-img-top" alt="Bolo Completo">
                            <div class="card-body">
                                <h5 class="card-title">Completo</h5>
                                <p class="card-text">Clássico Red Velvet com creme de queijo.</p>
                            </div>
                        </div>
                    </button>
                </div>
            </div>
        </section>

        <section class="mb-4">
            <h3 class="mb-3">Doces e Salgados</h3>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <button class="btn btn-outline-danger w-100" onclick="mostrarDoceSimples('doces')">
                        <div class="card">
                            <img src="./src/assets/images/image 9.png" class="card-img-top" alt="Doce Simples">
                            <div class="card-body">
                                <h5 class="card-title">Simples</h5>
                                <p class="card-text">Doces: Torta de Limão Merengada em Porções Individuais<br>Salgados: Canapés de Salmão Gravlax x50</p>
                            </div>
                        </div>
                    </button>
                </div>

                <div class="col-md-6 mb-3">
                    <button class="btn btn-outline-danger w-100" onclick="mostrarDoceCompleto('doces')">
                        <div class="card">
                            <img src="./src/assets/images/image 10.png" class="card-img-top" alt="Doce Completo">
                            <div class="card-body">
                                <h5 class="card-title">Completo</h5>
                                <p class="card-text">Doces: Torta de Limão Merengada, Mini Profiteroles com Creme de Chocolate x80<br>Salgados: Estação de Frutos do Mar x80</p>
                            </div>
                        </div>
                    </button>
                </div>
            </div>
        </section>


        <section class="mb-4">
            <h3 class="mb-3">Bebidas</h3>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <button class="btn btn-outline-info w-100" onclick="mostrarBebidaSimples('bebidas')">
                        <div class="card">
                            <img src="./src/assets/images/image 11.png" class="card-img-top" alt="Bebida Simples">
                            <div class="card-body">
                                <h5 class="card-title">Simples</h5>
                                <p class="card-text">Não Alcoólicas: Água com Gás e Limão, Mocktail de Frutas</p>
                            </div>
                        </div>
                    </button>
                </div>

                <div class="col-md-6 mb-3">
                    <button class="btn btn-outline-info w-100" onclick="mostrarBebidaCompleto('bebidas')">
                        <div class="card">
                            <img src="./src/assets/images/image 12.png" class="card-img-top" alt="Bebida Completo">
                            <div class="card-body">
                                <h5 class="card-title">Completo</h5>
                                <p class="card-text">Alcoólicas: Espumante ou Vinho Branco Seco, Coquetel de Frutas com Vodka</p>
                            </div>
                        </div>
                    </button>
                </div>
            </div>
        </section>


        <section class="mb-4">
            <h3 class="mb-3">Flores e Decorações</h3>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <button class="btn btn-outline-primary w-100" onclick="mostrarFloresSimples('flores')">
                        <div class="card">
                            <img src="./src/assets/images/image 15.png" class="card-img-top" alt="Flores Simples">
                            <div class="card-body">
                                <h5 class="card-title">Simples</h5>
                                <p class="card-text">Buquê destaca-se pela elegância com flores da estação.</p>
                            </div>
                        </div>
                    </button>
                </div>

                <div class="col-md-6 mb-3">
                    <button class="btn btn-outline-primary w-100" onclick="mostrarFloresCompleto('flores')">
                        <div class="card">
                            <img src="./src/assets/images/image 16.png" class="card-img-top" alt="Flores Completo">
                            <div class="card-body">
                                <h5 class="card-title">Completo</h5>
                                <p class="card-text">Buquê exclusivo de flores exóticas e decorativas.</p>
                            </div>
                        </div>
                    </button>
                </div>
            </div>
        </section>

    </div>

    <%@ include file="/componente/footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-cuKkm2YlNU7mF5z3ZyD5G9fR9PpKcoZX3WqcxE8Tt1ZzQW1ytTmS0POsb3qzYWQf" crossorigin="anonymous"></script>

</body>
</html>
