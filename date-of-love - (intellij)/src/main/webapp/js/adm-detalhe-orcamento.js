
$(document).ready(function(){
    function formatInitialValue(value) {
        var number = parseFloat(value.replace(',', '.'));
        return number.toLocaleString('pt-BR', { minimumFractionDigits: 2, maximumFractionDigits: 2 }).replace('.', ',');
    }

    function calculateMinValue() {
        let minValue = 0;
        $('.vl_preco').each(function() {
            let val = parseFloat($(this).val().replace(/\./g, '').replace(',', '.'));
            if (!isNaN(val)) {
                minValue += val;
            }
        });
        return minValue.toLocaleString('pt-BR', { minimumFractionDigits: 2, maximumFractionDigits: 2 }).replace('.', ',');
    }

    // Formata valores ao carregar a página
    $('.vl_preco').each(function() {
        var precoElement = $(this);
        var initialValue = precoElement.val();

        if (initialValue) {
            var formattedValue = formatInitialValue(initialValue);
            precoElement.val(formattedValue);
        }

        precoElement.mask('000.000.000,00', { reverse: true });
    });

    // Limita o valor máximo a 500.000,00
    $('.vl_preco').on('input', function() {
        if (val > maxVal) {
            $(this).val(formatInitialValue(maxVal.toString().replace('.', ',')));
        }
    });

    $('.vl_preco1').each(function() {
        var precoElement = $(this);
        var initialValue = precoElement.val();

        if (initialValue) {
            var formattedValue = formatInitialValue(initialValue);
            precoElement.val(formattedValue);
        }

        precoElement.mask('000.000.000,00', { reverse: true });
    });

    // Limita o valor máximo a 500.000,00
    $('.vl_preco1').on('input', function() {
        if (val > maxVal) {
            $(this).val(formatInitialValue(maxVal.toString().replace('.', ',')));
        }
    });

    // Atualiza o valor mínimo ao lado do campo
    window.updateMinExample = function() {
        const minValue = calculateMinValue();
        $('#valorMinimoExemplo').val(`R$ ${minValue}`);
    }
});
