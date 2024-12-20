document.addEventListener('DOMContentLoaded', function() {
    const quantidadePessoasInput = document.getElementById('quantidadePessoas');
    const quantidadeFeedback = document.getElementById('quantidadeFeedback');
    const dataCasamentoInput = document.getElementById('dataCasamento');
    const dataFeedback = document.getElementById('dataFeedback');


    document.querySelector('form').addEventListener('submit', function(event) {
        const selectedValue = document.querySelector('input[name="localCasamento"]:checked');

        if (selectedValue) {
            console.log('Local selecionado: ', selectedValue.value);
        } else {
            console.log('Nenhum local selecionado.');
        }
    });

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
      const noveMesesDepois = new Date(dataAtual.setMonth(dataAtual.getMonth() + 9));

      if (dataCasamento < noveMesesDepois) {
        dataFeedback.style.display = 'inline';
      } else {
        dataFeedback.style.display = 'none';
      }

    });
});

