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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/servico.css">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-cuKkm2YlNU7mF5z3ZyD5G9fR9PpKcoZX3WqcxE8Tt1ZzQW1ytTmS0POsb3qzYWQf" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>

</head>


<body>
    <%@ include file="/componente/header.jsp" %>

    <div class="container py-4">
        <h2 class="text-center mb-4">Serviços</h2>

        <!-- Cardápio Section -->
        <section class="mb-4">
            <div class="d-flex justify-content-between align-items-center">
                <h3 class="mb-4">Cardápio</h3>
            </div>

            <div class="row">
                <div class="col-md-6 mb-3 d-flex justify-content-center">
                    <button class="btn w-50" onclick="mostrarSimples('cardapio')">
                        <div class="card text-center">
                            <img src="./src/assets/images/image 3.png" class="card-img-top mx-auto" alt="Simples">
                            <div class="card-body">
                                <h5 class="card-title">Simples</h5>
                            </div>
                        </div>
                    </button>
                    <p class="text-center">Entradas: Canapés de Salmão Gravlax<br>Pratos Principais: Frango ao Molho de Ervas Finas<br>Sobremesas: Mini Cheesecakes de Frutas Vermelhas</p>
                </div>

                <div class="col-md-6 mb-3 d-flex justify-content-center">
                    <button class="btn w-50" onclick="mostrarCompleto('cardapio')">
                        <div class="card text-center">
                            <img src="./src/assets/images/image 4.png" class="card-img-top mx-auto" alt="Completo">
                            <div class="card-body">
                                <h5 class="card-title">Completo</h5>
                            </div>
                        </div>
                    </button>
                    <p class="text-center">Entradas: Canapés de Salmão Gravlax, Bruschettas de Tomate e Queijo de Cabra<br>Pratos Principais: Frango ao Molho de Ervas Finas, Massa Pappardelle com Molho de Tomate e Manjericão<br>Sobremesas: Mini Cheesecakes de Frutas Vermelhas, Sorvete de Baunilha com Calda de Caramelo</p>
                </div>
            </div>
        </section>

        <!-- Bolos de Casamento Section -->
        <section class="mb-4">
            <div class="d-flex justify-content-between align-items-center">
                <h3 class="mb-3">Bolos de Casamento</h3>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3 d-flex justify-content-center">
                    <button class="btn w-50" onclick="mostrarBoloSimples('bolos')">
                        <div class="card text-center">
                            <img src="./src/assets/images/image 7.png" class="card-img-top mx-auto" alt="Bolo Simples">
                            <div class="card-body">
                                <h5 class="card-title">Simples</h5>
                            </div>
                        </div>
                    </button>
                    <p class="text-center">O bolo de casamento tem um delicioso sabor de baunilha, proporcionando uma experiência clássica.</p>
                </div>

                <div class="col-md-6 mb-3 d-flex justify-content-center">
                    <button class="btn w-50" onclick="mostrarBoloCompleto('bolos')">
                        <div class="card text-center">
                            <img src="./src/assets/images/image 8.png" class="card-img-top mx-auto" alt="Bolo Completo">
                            <div class="card-body">
                                <h5 class="card-title">Completo</h5>
                            </div>
                        </div>
                    </button>
                    <p class="text-center">Clássico Red Velvet com creme de queijo.</p>
                </div>
            </div>
        </section>

        <!-- Doces e Salgados Section -->
        <section class="mb-4">
            <div class="d-flex justify-content-between align-items-center">
                <h3 class="mb-3">Doces e Salgados</h3>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3 d-flex justify-content-center">
                    <button class="btn w-50" onclick="mostrarDoceSimples('doces')">
                        <div class="card text-center">
                            <img src="./src/assets/images/image 9.png" class="card-img-top mx-auto" alt="Doce Simples">
                            <div class="card-body">
                                <h5 class="card-title">Simples</h5>
                            </div>
                        </div>
                    </button>
                    <p class="text-center">Doces: Torta de Limão Merengada em Porções Individuais<br>Salgados: Canapés de Salmão Gravlax x50</p>
                </div>

                <div class="col-md-6 mb-3 d-flex justify-content-center">
                    <button class="btn w-50" onclick="mostrarDoceCompleto('doces')">
                        <div class="card text-center">
                            <img src="./src/assets/images/image 10.png" class="card-img-top mx-auto" alt="Doce Completo">
                            <div class="card-body">
                                <h5 class="card-title">Completo</h5>
                            </div>
                        </div>
                    </button>
                    <p class="text-center">Doces: Torta de Limão Merengada, Mini Profiteroles com Creme de Chocolate x80<br>Salgados: Estação de Frutos do Mar x80</p>
                </div>
            </div>
        </section>

        <!-- Bebidas Section -->
        <section class="mb-4">
            <div class="d-flex justify-content-between align-items-center">
                <h3 class="mb-3">Bebidas</h3>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3 d-flex justify-content-center">
                    <button class="btn w-50" onclick="mostrarBebidaSimples('bebidas')">
                        <div class="card text-center">
                            <img src="./src/assets/images/image 11.png" class="card-img-top mx-auto" alt="Bebida Simples">
                            <div class="card-body">
                                <h5 class="card-title">Simples</h5>
                            </div>
                        </div>
                    </button>
                    <p class="text-center">Não Alcoólicas: Água com Gás e Limão, Mocktail de Frutas</p>
                </div>

                <div class="col-md-6 mb-3 d-flex justify-content-center">
                    <button class="btn w-50" onclick="mostrarBebidaCompleto('bebidas')">
                        <div class="card text-center">
                            <img src="./src/assets/images/image 12.png" class="card-img-top mx-auto" alt="Bebida Completo">
                            <div class="card-body">
                                <h5 class="card-title">Completo</h5>
                            </div>
                        </div>
                    </button>
                    <p class="text-center">Alcoólicas: Espumante ou Vinho Branco Seco, Coquetel de Frutas com Vodka</p>
                </div>
            </div>
        </section>

        <!-- Flores e Decorações Section -->
        <section class="mb-4">
            <div class="d-flex justify-content-between align-items-center">
                <h3 class="mb-3">Flores e Decorações</h3>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3 d-flex justify-content-center">
                    <button class="btn w-50" onclick="mostrarFloresSimples('flores')">
                        <div class="card text-center">
                            <img src="./src/assets/images/image 15.png" class="card-img-top mx-auto" alt="Flores Simples">
                            <div class="card-body">
                                <h5 class="card-title">Simples</h5>
                            </div>
                        </div>
                    </button>
                    <p class="text-center">Buquê destaca-se pela elegância com flores da estação.</p>
                </div>

                <div class="col-md-6 mb-3 d-flex justify-content-center">
                    <button class="btn w-50" onclick="mostrarFloresCompleto('flores')">
                        <div class="card text-center">
                            <img src="./src/assets/images/image 16.png" class="card-img-top mx-auto" alt="Flores Completo">
                            <div class="card-body">
                                <h5 class="card-title">Completo</h5>
                            </div>
                        </div>
                    </button>
                    <p class="text-center">Buquê exclusivo de flores exóticas e decorativas.</p>
                </div>
            </div>
        </section>
    </div>

    <%@ include file="/componente/footer.jsp" %>
</body>

</html>
