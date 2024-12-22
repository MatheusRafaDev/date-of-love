<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.dateoflove.model.Usuario" %>

<% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Serviços</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/servicos.css">
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</head>

<body>
    <%@ include file="/componente/header.jsp" %>

    <div class="container py-4">
        <h2 class="titulo">Serviços</h2>

        <!-- Cardápio Section -->
        <section class="mb-4">
            <h6 class="mb-4">Cardápio</h6>
            <div class="row justify-content-center">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <img src="./src/assets/images/image 3.png" class="card-img-top" alt="Cardápio">
                        <div class="card-body">
                            <h5 class="card-title">Cardápio</h5>
                            <p class="card-text">Entradas, Pratos principais e Sobremesas variadas para os seus convidados. Temos opções para todos os gostos, desde pratos tradicionais até as opções mais inovadoras. Deixe a sua festa ainda mais especial com o nosso cardápio exclusivo e cheio de sabor.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Bolos de Casamento Section -->
        <section class="mb-4">
            <h6 class="mb-3">Bolos de Casamento</h6>
            <div class="row justify-content-center">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <img src="./src/assets/images/image 7.png" class="card-img-top" alt="Bolos">
                        <div class="card-body">
                            <h5 class="card-title">Bolos de Casamento</h5>
                            <p class="card-text">Sabores variados e designs personalizados para o seu grande dia. Desde bolos clássicos até criações mais modernas, podemos fazer o bolo dos seus sonhos. Escolha entre uma variedade de sabores deliciosos e surpreenda seus convidados com um bolo inesquecível.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Doces e Salgados Section -->
        <section class="mb-4">
            <h6 class="mb-3">Doces e Salgados</h6>
            <div class="row justify-content-center">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <img src="./src/assets/images/image 9.png" class="card-img-top" alt="Doces e Salgados">
                        <div class="card-body">
                            <h5 class="card-title">Doces e Salgados</h5>
                            <p class="card-text">Variedade de doces e salgados para todos os gostos, preparados com muito carinho para o seu evento. Oferecemos uma gama de opções, incluindo mini doces, salgadinhos e pratos principais. Todo o sabor que você precisa para deixar o seu evento delicioso e inesquecível.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Bebidas Section -->
        <section class="mb-4">
            <h6 class="mb-3">Bebidas</h6>
            <div class="row justify-content-center">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <img src="./src/assets/images/image 11.png" class="card-img-top" alt="Bebidas">
                        <div class="card-body">
                            <h5 class="card-title">Bebidas</h5>
                            <p class="card-text">Seleção de coquetéis, sucos e bebidas especiais para o seu evento. Desde drinks sofisticados até opções mais leves, temos bebidas para agradar todos os gostos. Complemente a sua festa com uma carta de bebidas pensada especialmente para o seu evento.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Flores e Decorações Section -->
        <section class="mb-4">
            <h6 class="mb-3">Flores e Decorações</h6>
            <div class="row justify-content-center">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <img src="./src/assets/images/image 15.png" class="card-img-top" alt="Flores e Decorações">
                        <div class="card-body">
                            <h5 class="card-title">Flores e Decorações</h5>
                            <p class="card-text">Decorações personalizadas com flores frescas e arranjos florais delicados para o seu evento. Transforme o ambiente com as nossas opções de flores, arranjos e detalhes decorativos, tornando o seu casamento ainda mais mágico e inesquecível.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <%@ include file="/componente/footer.jsp" %>
</body>

</html>
