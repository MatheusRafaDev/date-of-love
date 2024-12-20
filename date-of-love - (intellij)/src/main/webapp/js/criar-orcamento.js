$(document).ready(function () {
    // Máscara para o campo de data
    $('#dataCasamento').mask('00/00/0000');

   $('#orcamentoMedio').mask('#.##0,00', {reverse: true}); // Para formatação de número com vírgula como separador decimal

   // Validação do valor estimado
   $('#orcamentoMedio').on('input', function () {
       const valor = parseFloat(this.value.replace(/\./g, '').replace(',', '.')); // Converte para número
       const feedback = document.getElementById('valorEstimadoFeedback');

       if (feedback) {
           if (valor >= 10000) {
               feedback.style.display = 'none';
               this.style.borderColor = 'green';
           } else {
               feedback.style.display = 'block';
               feedback.textContent = 'O valor estimado deve ser acima de R$ 10.000,00.';
               this.style.borderColor = 'red';
           }
       }
   });


    // Definir a data sugerida como 9 meses à frente
    function calcularDataSugerida() {
        const hoje = new Date();
        hoje.setMonth(hoje.getMonth() + 9); // Adiciona 9 meses
        const dia = String(hoje.getDate()).padStart(2, '0');
        const mes = String(hoje.getMonth() + 1).padStart(2, '0');
        const ano = hoje.getFullYear();
        return `${dia}/${mes}/${ano}`; // Formato dd/mm/yyyy
    }

    // Preencher o campo de data com a data sugerida
    $('#dataCasamento').val(calcularDataSugerida());

    // Validação da quantidade de convidados
    $('#quantidadePessoas').on('input', function () {
        const quantidade = parseInt(this.value, 10);
        const feedback = document.getElementById('quantidadeFeedback');

        if (feedback) {
            if (quantidade >= 100 && quantidade <= 700) {
                feedback.style.display = 'none';
                this.style.borderColor = 'green';
            } else {
                feedback.style.display = 'block';
                this.style.borderColor = 'red';
            }
        }
    });

    // Validação do valor estimado
    $('#valorEstimado').on('input', function () {
        const valor = parseFloat(this.value.replace(/\./g, '').replace(',', '.')); // Converte para número
        const feedback = document.getElementById('valorEstimadoFeedback');

        if (feedback) {
            if (valor >= 10000) {
                feedback.style.display = 'none';
                this.style.borderColor = 'green';
            } else {
                feedback.style.display = 'block';
                feedback.textContent = 'O valor estimado deve ser acima de R$ 10.000,00.';
                this.style.borderColor = 'red';
            }
        }
    });

    // Validação da data de casamento
    $('#dataCasamento').on('input', function () {
        const dataInput = this.value;
        const feedback = document.getElementById('dataFeedback');

        if (feedback) {
            const partes = dataInput.split('/');
            if (partes.length !== 3) {
                feedback.style.display = 'block';
                this.style.borderColor = 'red';
                return;
            }

            const dataCasamento = new Date(`${partes[2]}-${partes[1]}-${partes[0]}`);
            const hoje = new Date();

            // Verifique se a data é válida
            if (isNaN(dataCasamento.getTime())) {
                feedback.style.display = 'block';
                this.style.borderColor = 'red';
                return;
            }

            // Calcular a data limite (9 meses a partir de hoje)
            const dataLimite = new Date(hoje);
            dataLimite.setMonth(hoje.getMonth() + 9); // Adiciona 9 meses

            // Calcular a data de hoje sem hora (para a comparação correta)
            hoje.setHours(0, 0, 0, 0); // Zera as horas da data de hoje

            // Formatar a data limite para exibição
            const dia = String(dataLimite.getDate()).padStart(2, '0');
            const mes = String(dataLimite.getMonth() + 1).padStart(2, '0');
            const ano = dataLimite.getFullYear();
            const dataLimiteFormatada = `${dia}/${mes}/${ano}`;

            // Verificar se a data é no futuro
            if (dataCasamento < hoje) {
                feedback.style.display = 'block';
                feedback.textContent = 'A data de casamento deve ser no futuro.';
                this.style.borderColor = 'red';
            } else if (dataCasamento > dataLimite) {
                // Se a data for maior que o limite de 9 meses, aceita e limpa a mensagem de erro
                feedback.style.display = 'none';
                this.style.borderColor = 'green';
            } else {
                // Se a data estiver dentro do limite de 9 meses, exibe a mensagem de limite com a data limite
                feedback.style.display = 'block';
                feedback.textContent = `A data deve ser no máximo 9 meses a partir de hoje. Exemplo: ${dataLimiteFormatada}`;
                this.style.borderColor = 'red';
            }
        }
    });
});
