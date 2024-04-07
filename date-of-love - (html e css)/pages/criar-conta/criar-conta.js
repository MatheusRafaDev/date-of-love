function cadastrar() {
    var nomeNoivo = document.getElementById('nome_noivo').value;
    var nomeNoiva = document.getElementById('nome_noiva').value;
    var email = document.getElementById('email').value;
    var dataCasamento = document.getElementById('data_casamento').value;
    var estiloFesta = document.getElementById('estilo_festa').value;
    var localizacao = document.getElementById('localizacao').value;
    var numConvidados = document.getElementById('num_convidados').value;
    var senha = document.getElementById('senha').value;
    var confirmarSenha = document.getElementById('confirmar_senha').value;

    if (senha !== confirmarSenha) {
        alert('As senhas não coincidem');
        return;
    }

    var dados = {
        nm_noivo: nomeNoivo,
        nm_noiva: nomeNoiva,
        ds_email: email,
        dt_cadastro: dataCasamento,
        nm_noivos_concatenado: nomeNoivo + ' e ' + nomeNoiva,
        ds_senha: senha
    };

    fetch('http://localhost:3000/criar-conta', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dados)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao criar conta');
        }
        return response.json();
    })
    .then(data => {
        alert('Conta criada com sucesso');
        window.location.href = '/login.html'; 
    })
    .catch(error => {
        console.error('Erro:', error);
        alert('Erro ao criar conta');
    });
}