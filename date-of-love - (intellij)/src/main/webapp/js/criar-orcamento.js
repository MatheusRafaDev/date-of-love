$(document).ready(function() {
    const quantidadePessoasInput = document.getElementById('quantidadePessoas');
    const quantidadeFeedback = document.getElementById('quantidadeFeedback');
    const dataCasamentoInput = document.getElementById('dataCasamento');
    const dataFeedback = document.getElementById('dataFeedback');
    const maxVal = 500000.00;

    function formatInitialValue(value) {
        var valueStr = value ? value.toString() : '';

        if (valueStr) {
            var number = parseFloat(valueStr.replace(',', '.'));
            return number.toLocaleString('pt-BR', { minimumFractionDigits: 2, maximumFractionDigits: 2 }).replace('.', ',');
        } else {
            return '0,00';
        }
    }

    function formatAndLimitValue(selector) {
        $(selector).each(function() {
            var precoElement = $(this);
            var initialValue = precoElement.val();
            if (initialValue) {
                var formattedValue = formatInitialValue(initialValue);
                precoElement.val(formattedValue);
            }
            precoElement.mask('000.000.000,00', { reverse: true });
        });

        $(selector).on('input', function() {
            var val = parseFloat($(this).val().replace(/\./g, '').replace(',', '.'));
            if (val > maxVal) {
                $(this).val(formatInitialValue(maxVal));
            }
        });
     }

    formatAndLimitValue('input[name="orcamentoMedio"]');
    formatAndLimitValue('.vl_total');

    quantidadePessoasInput.addEventListener('input', function() {
        const quantidade = parseInt(quantidadePessoasInput.value);

        if (quantidade < 100 || quantidade > 700) {
            quantidadeFeedback.style.display = 'inline';
        } else {
            quantidadeFeedback.style.display = 'none';
        }
    });


    dataCasamentoInput.addEventListener('input', function() {
        const dataCasamento = new Date(dataCasamentoInput.value);
        const dataAtual = new Date();
        const noveMesesDepois = new Date(dataAtual.getFullYear(), dataAtual.getMonth() + 9, dataAtual.getDate());

        if (dataCasamento < noveMesesDepois) {
            dataFeedback.style.display = 'inline';
        } else {
            dataFeedback.style.display = 'none';
        }
    });

    document.querySelector('form').addEventListener('submit', function(event) {
        const selectedValue = document.querySelector('input[name="localCasamento"]:checked');

        if (selectedValue) {
            console.log('Local selecionado: ', selectedValue.value);
        } else {
            console.log('Nenhum local selecionado.');
        }
    });
});