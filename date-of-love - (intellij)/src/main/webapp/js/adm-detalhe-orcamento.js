
$(document).ready(function () {
    const maxVal = 500000.00;
    const maxValService = 50000.00;
    const maxDiscountPercentage = 20;
    let originalTotalValue = Math.round(parseFloat($('#valorTotal2').val())) || 0;


    function formatInitialValue(value) {
        const valueStr = value ? value.toString() : '';
        if (valueStr) {
            const number = parseFloat(valueStr.replace(',', '.'));
            return number.toLocaleString('pt-BR', { minimumFractionDigits: 2, maximumFractionDigits: 2 }).replace('.', ',');
        } else {
            return '0,00';
        }
    }


    function formatAndLimitValue(selector, maxValue) {
        $(selector).each(function () {
            const precoElement = $(this);
            const initialValue = precoElement.val();
            if (initialValue) {
                precoElement.val(formatInitialValue(initialValue));
            }
            precoElement.mask('000.000.000,00', { reverse: true });
        });

        $(selector).on('input', function () {
            let val = parseFloat($(this).val().replace(/\./g, '').replace(',', '.'));
            if (val > maxValue) {
                $(this).val(formatInitialValue(maxValue));
            }
        });
    }

    formatAndLimitValue('.vl_preco', maxValService);
    formatAndLimitValue('.vl_preco1', maxVal);
    formatAndLimitValue('.vl_preco2', maxVal);
    formatAndLimitValue('.vl_preco3', maxValService);


    function calculateDiscount(value, percentage) {
        return (value * (percentage / 100)).toFixed(2);
    }


    function AplicarDesconto() {
        const originalValue = parseFloat(originalTotalValue);
        let discountPercentage = parseFloat($('.vl_desc').val().replace(/\./g, '').replace(',', '.'));

        if (discountPercentage > maxDiscountPercentage) {
            discountPercentage = maxDiscountPercentage;
            $('.vl_desc').val(formatInitialValue(discountPercentage));
        }

        if (!isNaN(originalValue) && !isNaN(discountPercentage)) {
            const discountValue = calculateDiscount(originalValue, discountPercentage);
            const finalValue = Math.max(0, originalValue - discountValue);

            $('.vl_preco1').val(formatInitialValue(finalValue));
            $('.vl_preco2').val(formatInitialValue(finalValue));
            $('#valorDescontoLabel').text(`R$ ${formatInitialValue(discountValue)}`);
        } else {
            $('#valorDescontoLabel').text('R$ 0,00');
        }
    }


    $('.vl_preco1').on('input', function () {
        atualizarValor();
        originalTotalValue = parseFloat($('#valorTotal2').val().replace(/\./g, '').replace(',', '.'));
    });

    function atualizarValor() {
        var valor = document.getElementById('valorTotal').value;
        document.getElementById('valorTotal2').value = valor;
    }


    function calcularValorBase() {
        let valorTotal = 0;
        $('.vl_preco').each(function () {
            const valor = $(this).val().replace(/\./g, '').replace(',', '.');
            valorTotal += parseFloat(valor) || 0;
        });

        $('#valorTotal').val(formatInitialValue(valorTotal));
        $('#valorTotal2').val(formatInitialValue(valorTotal));
        originalTotalValue = valorTotal.toFixed(2).replace('.', ',');
    }


    window.AplicarDesconto = AplicarDesconto;
    window.calcularValorBase = calcularValorBase;
});
