$(document).ready(function() {
    const maxVal = 500000.00;
    const maxDiscountPercentage = 20;
    let originalTotalValue = Math.round(parseFloat($('#valorTotal2').val())) || 0;

    function formatInitialValue(value) {
        var valueStr = value ? value.toString() : '';
        if (valueStr) {
            var number = parseFloat(valueStr.replace(',', '.'));
            return number.toLocaleString('pt-BR', { minimumFractionDigits: 2, maximumFractionDigits: 2 }).replace('.', ',');
        } else {
            return '0,00';
        }
    }

    function calculateMinValue() {
        let minValue = 0;
        $('.vl_preco').each(function() {
            let val = parseFloat($(this).val().replace(/\./g, '').replace(',', '.'));
            if (!isNaN(val)) {
                minValue += val;
            }
        });
        return formatInitialValue(minValue);
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

    formatAndLimitValue('.vl_preco');
    formatAndLimitValue('.vl_preco1');
    formatAndLimitValue('.vl_preco2');
    formatAndLimitValue('.vl_preco3');


    function calculateDiscount(value, percentage) {
        return (value * (percentage / 100)).toFixed(2);
    }


    function formatValueInRealTime(element, value) {
        var formattedValue = parseFloat(value).toFixed(2);
        element.val(`R$ ${formatInitialValue(formattedValue)}`);
    }

    function AplicarDesconto() {
        const originalValue =  parseFloat(originalTotalValue);
        const discountPercentage = parseFloat($('.vl_desc').val().replace(/\./g, '').replace(',', '.'));



        if (!isNaN(originalValue) && !isNaN(discountPercentage)) {
            const discountValue = calculateDiscount(originalValue, discountPercentage);
            const finalValue = originalValue - discountValue;

          if (finalValue < 0) {
                finalValue = 0;
            }


            $('.vl_preco1').val(formatInitialValue(finalValue));
             $('.vl_preco2').val(formatInitialValue(finalValue));
            $('#valorDescontoInput').val(`R$ ${formatInitialValue(finalValue)}`);
        }
    }

    $('.vl_desc').on('input', function() {
        const originalValue =  parseFloat(originalTotalValue);

        let discountPercentage = parseFloat($(this).val().replace(/\./g, '').replace(',', '.'));

        if (discountPercentage > maxDiscountPercentage) {
            discountPercentage = maxDiscountPercentage;
            $(this).val(maxDiscountPercentage.toFixed(2).replace('.', ','));
        } else if (discountPercentage < 0 || isNaN(discountPercentage)) {
            discountPercentage = 0;
            $(this).val('0,00');
        }

        if (!isNaN(originalValue) && !isNaN(discountPercentage)) {
            const discountValue = calculateDiscount(originalValue, discountPercentage);
            formatValueInRealTime($('#valorDesconto'), discountValue);
            $('#valorDescontoLabel').text(`R$ ${formatInitialValue(discountValue)}`);
        } else {
            $('#valorDesconto').val('R$ 0,00');
        }
    });

    window.updateMinExample = function() {
        const minValue = calculateMinValue();
        $('#valorMinimoExemplo').val(`R$ ${minValue}`);
    }

    function calcularValorBase() {
        const camposPrecos = document.querySelectorAll('.vl_preco');
        let valorTotal = 0;

        camposPrecos.forEach(campo => {
            const valor = campo.value.replace(/[^\d,]/g, '').replace(',', '.');
            const numero = parseFloat(valor) || 0;
            valorTotal += numero;
        });

        document.getElementById('valorTotal').value = valorTotal.toFixed(2).replace('.', ',');
        document.getElementById('valorTotal2').value = valorTotal.toFixed(2).replace('.', ',');
        originalTotalValue = valorTotal.toFixed(2).replace('.', ',');
        formatAndLimitValue('.vl_preco1');
        formatAndLimitValue('.vl_preco2');
    }

    window.AplicarDesconto = AplicarDesconto;
    window.calcularValorBase = calcularValorBase;
});