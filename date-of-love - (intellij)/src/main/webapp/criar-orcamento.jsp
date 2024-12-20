<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.dateoflove.model.Usuario" %>
<%@ page import="br.com.dateoflove.model.Casamento" %>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("/login");
        return;
    }

    Casamento casamento = (Casamento) session.getAttribute("casamento");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/criar-orcamento2.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/criar-orcamento.js"></script>

    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/src/assets/images/favicon.ico">
    <title>Criar Orçamento</title>



</head>
<body>

   <%@ include file="/componente/header.jsp" %>

    <div class="card">
        <h3>Checklist</h3>
        <form action="${pageContext.request.contextPath}/criar-orcamento" method="POST">
            <table class="checklist-table">
                <tr>
                    <th>Serviço</th>
                    <th>Opções</th>
                </tr>
                <tr>
                    <td>Cardápio</td>
                    <td>
                        <select name="servico1" class="styled-select">
                            <option value="simples">Simples - Pratos básicos e tradicionais</option>
                            <option value="completo">Completo - Entrada, prato principal e sobremesa</option>
                            <option value="premium">Premium - Cardápio refinado com opções gourmet</option>
                            <option value="exclusivo">Exclusivo - Personalizado conforme sua preferência</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Flores e Decoração</td>
                    <td>
                        <select name="servico2" class="styled-select">
                            <option value="simples">Simples - Decoração com flores da estação</option>
                            <option value="completo">Completo - Arranjos florais para mesas e altar</option>
                            <option value="premium">Premium - Decoração temática e personalizada</option>
                            <option value="exclusivo">Exclusivo - Projeto exclusivo com paisagismo</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Bebidas</td>
                    <td>
                        <select name="servico3" class="styled-select">
                            <option value="simples">Simples - Bebidas não alcoólicas</option>
                            <option value="completo">Completo - Bebidas alcoólicas e não alcoólicas</option>
                            <option value="premium">Premium - Drinks personalizados e coquetéis</option>
                            <option value="exclusivo">Exclusivo - Serviço de bartender com carta exclusiva</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Doces e Bem-casados</td>
                    <td>
                        <select name="servico4" class="styled-select">
                            <option value="simples">Simples - Doces tradicionais e bem-casados básicos</option>
                            <option value="completo">Completo - Variedade maior com doces finos</option>
                            <option value="premium">Premium - Doces gourmet e personalizados</option>
                            <option value="exclusivo">Exclusivo - Doces exclusivos com embalagens personalizadas</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Bolo Cenográfico e Bolo de Corte</td>
                    <td>
                        <select name="servico5" class="styled-select">
                            <option value="simples">Simples - Bolo cenográfico básico e bolo de corte simples</option>
                            <option value="completo">Completo - Bolo cenográfico decorado e bolo de corte variado</option>
                            <option value="premium">Premium - Bolo cenográfico temático e recheios especiais</option>
                            <option value="exclusivo">Exclusivo - Design exclusivo com confeitaria artística</option>
                        </select>
                    </td>
                </tr>
            </table>

            <h3>Já incluso no Pacote</h3>
            <table class="checklist-table">
                <tr>
                    <th>Serviço</th>
                    <th>Descrição</th>
                    <th>Opções</th>
                </tr>
                <tr>
                    <td>DJ</td>
                    <td>DJ com seleção de músicas personalizada de acordo com o estilo desejado.</td>
                    <td>
                        <label>
                            <input type="checkbox" name="servico6" checked disabled>
                            Incluso no Pacote
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>Coordenação do Dia</td>
                    <td>Profissional para coordenar todos os detalhes no dia do evento.</td>
                    <td>
                        <label>
                            <input type="checkbox" name="servico7" checked disabled>
                            Incluso no Pacote
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>Espaço com Mobiliário</td>
                    <td>Espaço amplo e bem decorado para a realização da cerimônia e recepção.</td>
                    <td>
                        <label>
                            <input type="checkbox" name="servico8" checked disabled>
                            Incluso no Pacote
                        </label>
                    </td>
                </tr>
            </table>


            <div class="input-container">
              <label for="quantidadePessoas">Quantidade de Convidados (máx. 700):</label>
              <input type="number" name="quantidadePessoas" id="quantidadePessoas" min="100" max="700" placeholder="Digite o número de convidados" required />

              <small id="quantidadeFeedback" style="color: red; display: none;">A quantidade deve ser entre 100 e 700.</small>
            </div>

            <h3>Data do casamento</h3>
            <input type="date" id="dataCasamento" name="dataCasamento" />

            <div id="dataFeedback" style="display: none;">Data inválida!</div>

            <h3>Local do Casamento</h3>
            <div class="local-casamento">
                <label for="localFazenda">
                    <input type="radio" name="localCasamento" value="fazenda" id="localFazenda" required>
                    <img src="<%=request.getContextPath()%>/img/fazenda.jpeg" alt="fazenda" />
                    <span>Fazenda</span>
                </label>
                <label for="localPraia">
                    <input type="radio" name="localCasamento" value="praia" id="localPraia" required>
                    <img src="<%=request.getContextPath()%>/img/praia.png" alt="praia" />
                    <span>Praia</span>
                </label>
                <label for="localIgreja">
                    <input type="radio" name="localCasamento" value="igreja" id="localIgreja" required>
                    <img src="<%=request.getContextPath()%>/img/igreja.jpg" alt="igreja" />
                    <span>Igreja</span>
                </label>
            </div>


            <script>
                document.querySelector('form').addEventListener('submit', function(event) {
                    const selectedValue = document.querySelector('input[name="localCasamento"]:checked');

                    if (selectedValue) {
                        console.log('Local selecionado: ', selectedValue.value);  // Exibe o valor no console
                    } else {
                        console.log('Nenhum local selecionado.');
                    }
                });
            </script>




            <h3>Tipo de Cerimônia</h3>
            <select name="tipoCerimonia" required class="styled-select">
                <option value="civil">Civil</option>
                <option value="religiosa">Religiosa</option>
                <option value="ambas">Civil e Religiosa</option>
            </select>

            <h3>Forma de Pagamento</h3>
            <select name="formaPagamento" required class="styled-select">
                <option value="avista">À vista</option>
                <option value="parcelado">Parcelado</option>
                <option value="financiado">Financiado</option>
            </select>


            <h3>Valor Estimado</h3>
            <input type="text" name="orcamentoMedio" id="orcamentoMedio" placeholder="Informe o orçamento estimado">
            <div id="valorEstimadoFeedback" style="color: red; display: none;"></div>


            <h3>Observações Gerais</h3>
            <textarea rows="7" cols="50" name="observacao"></textarea>

            <h3>Comentários Adicionais</h3>
            <textarea rows="7" cols="50" name="comentarios"></textarea>

            <button type="submit" class="criar-button">Criar Orçamento</button>
        </form>
    </div>

</body>
</html>
