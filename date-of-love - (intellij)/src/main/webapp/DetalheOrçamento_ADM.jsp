<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;500;700&display=swap">
    <link rel="icon" type="image/x-icon" href="/src/assets/images/favicon.ico">
    <link rel="stylesheet" href="/DetalheOrçamento_ADM..css">

    <title>Visualizar Orçamento ADM </title>
</head>
<body>
    <div class="budget-container">
        <h3>Orçamento</h3>
        <h3>Serviços</h3>
        <table>
            <tr>
                <th>Serviço</th>
                <th>Pacote Simples</th>
                <th>Pacote Completo</th>
                <th>Observações</th>
                <th>Valor</th>
            </tr>
            
            <tr>
                <td>Cardápio Completo</td>
                <td><input type="radio" name="servico1" value="simples"></td>
                <td><input type="radio" name="servico1" value="completo"></td>
                <td><input type="text" value=""></td>
                <td>R$ 800</td>
            </tr>
            <tr>
                <td>Flores e Decoração</td>
                <td><input type="radio" name="servico1" value="simples"></td>
                <td><input type="radio" name="servico1" value="completo"></td>
                <td><input type="text" value=""></td>
                <td>R$ 800</td>
            </tr>
            <tr>
                <td>Bebidas</td>
                <td><input type="radio" name="servico1" value="simples"></td>
                <td><input type="radio" name="servico1" value="completo"></td>
                <td><input type="text" value=""></td>
                <td>R$ 800</td>
            </tr>
            <tr>
                <td>Doces e Bem Casados</td>
                <td><input type="radio" name="servico1" value="simples"></td>
                <td><input type="radio" name="servico1" value="completo"></td>
                <td><input type="text" value=""></td>
                <td>R$ 800</td>
            </tr>
            <tr>
                <td>Bolos</td>
                <td><input type="radio" name="servico1" value="simples"></td>
                <td><input type="radio" name="servico1" value="completo"></td>
                <td><input type="text" value=""></td>
                <td>R$ 800</td>
            </tr>

          
            
        </table>

        <h3>Outros Serviços Já Inclusos</h3>
        <table>
            <tr>
                <th>Serviço</th>
                <th>Observações</th>
                <th>Valor</th>
            </tr>
            <tr>
                <td>DJ</td>
                <td><input type="text" value=""></td>
                <td>R$ 2000</td>
            </tr>
            <tr>
                <td>Coordenação do Dia</td>
                <td><input type="text" value=""></td>
                <td>R$ 1500</td>
            </tr>
            <tr>
                <td>Espaço</td>
                <td><input type="text" value=""></td>
                <td>R$ 3000</td>
            </tr>
           
        </table>
        
      
        <div class="container">
            <label for="convidados">Nº Convidados:</label>
            <input type="number" id="convidados" name="convidados">
          
            <label for="valorTotal">Valor total:</label>
            <input type="text" id="valorTotal" name="valorTotal" placeholder="" required>
          
            <label for="responsavel">Nome do responsável pelo orçamento:</label>
            <input type="text" id="responsavel" name="responsavel" value="Fabricio">

          </div>
          
   
        



        <h3>Observações Gerais</h3>
        <textarea rows="7" cols="50"></textarea>
        <button id="verDetalhesBtn1">Salvar</button>
    </div>

</body>
</html>
