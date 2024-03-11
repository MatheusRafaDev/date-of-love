# Date Of Love

## Requesitos principais

- [ ] Carrinho
- [ ] Cadastro e login
- [ ] Catálogo
- [ ] Escolha de Serviços (Quantidade de pessoas e espaço)


 ### Outras funcionalidade a parte

- [ ] Disparo de emails com avisos
- [ ]  Chat de contato e envio de orçamento via chat
- [ ]  
![Texto Alternativo](der.jpg)

## Tabela de Usuários (`tb_usuarios`)

| Coluna                | Tipo         | Descrição                                      |
|-----------------------|--------------|------------------------------------------------|
| id_usuario            | INT          | Chave primária autoincrementável               |
| nm_noivo              | VARCHAR(100) | Nome do noivo                                  |
| nm_noiva              | VARCHAR(100) | Nome da noiva                                  |
| ds_email              | VARCHAR(100) | Endereço de e-mail do usuário                  |
| ds_senha              | VARCHAR(100) | Senha do usuário (criptografada)               |
| dt_cadastro           | DATE         | Data de cadastro do usuário                    |
| nm_noivos_concatenado| VARCHAR(200) | Nomes dos noivos concatenados                   |

## Tabela de Informações do Casamento (`tb_info_casamento`)

| Coluna          | Tipo         | Descrição                                        |
|-----------------|--------------|--------------------------------------------------|
| id_casamento    | INT          | Chave primária autoincrementável                 |
| id_usuario      | INT          | Chave estrangeira referenciando tb_usuarios       |
| dt_casamento    | DATE         | Data do casamento                                |
| ds_localidade   | VARCHAR(100) | Localidade do casamento                          |
| nr_convidados   | INT          | Número de convidados para o casamento            |

## Tabela de Serviços (`tb_servicos`)

| Coluna        | Tipo         | Descrição                                      |
|---------------|--------------|------------------------------------------------|
| id_servico    | INT          | Chave primária autoincrementável               |
| nm_servico    | VARCHAR(100) | Nome do serviço                                |
| ds_servico    | TEXT         | Descrição do serviço                           |
| vl_preco      | DECIMAL(10,2)| Preço do serviço                               |

## Tabela de Orçamentos (`tb_orcamentos`)

| Coluna         | Tipo         | Descrição                                          |
|----------------|--------------|----------------------------------------------------|
| id_orcamento   | INT          | Chave primária autoincrementável                   |
| id_usuario     | INT          | Chave estrangeira referenciando tb_usuarios        |
| id_casamento   | INT          | Chave estrangeira referenciando tb_info_casamento  |
| dt_orcamento   | DATE         | Data do orçamento                                  |
| ds_status      | VARCHAR(20)  | Status do orçamento (por exemplo, pendente, aceito, rejeitado) |

## Tabela de Detalhes do Orçamento (`tb_detalhes_orcamento`)

| Coluna               | Tipo         | Descrição                                       |
|----------------------|--------------|-------------------------------------------------|
| id_detalhe_orcamento| INT          | Chave primária autoincrementável                |
| id_orcamento         | INT          | Chave estrangeira referenciando tb_orcamentos    |
| id_servico           | INT          | Chave estrangeira referenciando tb_servicos      |
| nr_quantidade        | INT          | Quantidade do serviço incluída no orçamento     |
| vl_preco             | DECIMAL(10,2)| Preço do serviço no momento do orçamento        |
