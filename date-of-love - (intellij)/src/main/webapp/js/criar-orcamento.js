document.addEventListener('DOMContentLoaded', function () {
    var dataCasamento = document.getElementById('dataCasamento');

    // Função para formatar a data de dd/mm/yyyy para yyyy-mm-dd
    function formatarData() {
        var dataInput = dataCasamento.value;

        // Verifica se a data está no formato dd/mm/yyyy
        var regex = /^(\d{2})\/(\d{2})\/(\d{4})$/;
        if (regex.test(dataInput)) {
            var partes = dataInput.split('/');
            var novaData = partes[2] + '-' + partes[1] + '-' + partes[0]; // yyyy-mm-dd
            dataCasamento.value = novaData; // Atualiza o campo com a nova data
        }
    }

    // Chama a função de formatação ao mudar o valor do campo de data
    dataCasamento.addEventListener('blur', formatarData);

    // Definir a data sugerida como 9 meses à frente
    function calcularDataSugerida() {
        const hoje = new Date();
        hoje.setMonth(hoje.getMonth() + 9); // Adiciona 9 meses
        const dia = String(hoje.getDate()).padStart(2, '0');
        const mes = String(hoje.getMonth() + 1).padStart(2, '0');
        const ano = hoje.getFullYear();
        return `${ano}-${mes}-${dia}`; // Formato yyyy-mm-dd
    }

    // Preencher o campo de data com a data sugerida
    dataCasamento.value = calcularDataSugerida();

    // Validação do campo de data (para garantir que esteja no futuro)
    dataCasamento.addEventListener('input', function () {
        const dataInput = this.value;
        const feedback = document.getElementById('dataFeedback');

        if (feedback) {
            // Verifica se o formato da data é válido (yyyy-mm-dd)
            const partes = dataInput.split('-');
            if (partes.length !== 3) {
                feedback.style.display = 'block';
                this.style.borderColor = 'red';
                return;
            }

            // Converte a data para o formato correto (yyyy-mm-dd) para criar um objeto Date
            const dataCasamento = new Date(`${partes[0]}-${partes[1]}-${partes[2]}`);
            const hoje = new Date();

            // Ajusta a data de hoje para não levar em consideração a hora (somente data)
            hoje.setHours(0, 0, 0, 0);

            // Verifica se a data de casamento é no futuro
            if (dataCasamento < hoje) {
                feedback.style.display = 'block';
                feedback.textContent = 'A data de casamento deve ser no futuro.';
                this.style.borderColor = 'red';
            } else {
                feedback.style.display = 'none';
                this.style.borderColor = 'green';
            }
        }
    });
});
