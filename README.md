# Projeto: Date Of Love - Organização de Festas de Casamento

## Descrição:

Date Of Love é uma plataforma online especializada na organização de festas de casamento, que visa simplificar o processo de planejamento e tornar cada momento memorável. Os requisitos principais do projeto incluem:

### Requisitos Principais:

- [ ] **Cadastro e Login:** Desenvolver sistemas de cadastro e login para os usuários acessarem suas informações e histórico de pedidos.
- [ ] **Catálogo:** Criar um catálogo abrangente de serviços e produtos relacionados a festas de casamento para os usuários explorarem.
- [ ] **Escolha de Serviços:** Permitir que os usuários selecionem serviços específicos, como decoração, buffet e música, além de personalizarem o número de convidados e o local do evento.
- [ ] **Gerar Orçamentos:** Implementar um sistema que gere orçamentos detalhados com base nas seleções dos usuários.

### Funcionalidades Adicionais:

- [ ] **Disparo de Emails com Avisos:** Configurar um sistema para enviar automaticamente emails com lembretes e avisos importantes aos usuários sobre seus eventos agendados.
- [ ] **Chat de Contato:** Integrar um chat de contato para que os usuários possam se comunicar diretamente com a equipe de suporte, esclarecer dúvidas e solicitar assistência personalizada durante o processo de planejamento do casamento.

## Telas e Funcionalidades:

### Público (Usuário):
1. **Home:** Página inicial com informações sobre o serviço, depoimentos de clientes etc.
2. **Serviços:** Página mostrando todos os serviços oferecidos pela plataforma.
3. **Login/Criar Conta:** Telas para login e registro de novos usuários.
4. **Catálogo/Listagem de Serviços:** Página mostrando todos os serviços disponíveis para seleção.
5. **Selecionar Serviços para Orçamento:** Página onde os usuários podem selecionar os serviços desejados.
6. **Histórico de Orçamento:** Lista de todos os orçamentos solicitados pelo usuário.
7. **Visualizar Orçamento:** Página para visualizar detalhes de um orçamento específico.
8. **Perfil do Casal:** Página para gerenciar informações do perfil do casal, como nome, data de casamento, etc.
9. **Suporte/Dúvidas:** Página com opção para enviar e-mail para o suporte técnico.

### Administrador (ADM):
1. **Orçamentos:** Página para visualizar todos os orçamentos solicitados pelos usuários e possibilidade de alterá-los.
2. **Visualizar Orçamentos e Alterar:** Detalhes de um orçamento específico e opção para fazer alterações se necessário.


## Diagrama DER

![Diagrama DER](diagramas/der2.jpg)

## Tabelas do DateOfLove

### Tabela de Usuários (`tb_usuarios`)

| Coluna         | Tipo         | Descrição                                     |
|----------------|--------------|-----------------------------------------------|
| id_usuario     | INT          | Chave primária autoincrementável              |
| nm_noivo       | VARCHAR(100) | Nome do noivo                                 |
| nm_noiva       | VARCHAR(100) | Nome da noiva                                 |
| ds_email       | VARCHAR(100) | Endereço de e-mail do usuário                 |
| ds_senha       | VARCHAR(100) | Senha do usuário (criptografada)              |
| dt_cadastro    | DATE         | Data de cadastro do usuário                   |
| nm_casal       | VARCHAR(200) | Nomes dos noivos concatenados                  |

### Tabela de Informações do Casamento (`tb_casamento`)

| Coluna          | Tipo         | Descrição                                      |
|-----------------|--------------|------------------------------------------------|
| id_casamento    | INT          | Chave primária autoincrementável               |
| id_usuario      | INT          | Chave estrangeira referenciando tb_usuarios    |
| dt_casamento    | DATE         | Data do casamento                              |
| ds_localidade   | VARCHAR(100) | Localidade do casamento                        |
| nr_convidados   | INT          | Número de convidados para o casamento          |

### Tabela de Serviços (`tb_servicos`)

| Coluna        | Tipo         | Descrição                                      |
|---------------|--------------|------------------------------------------------|
| id_servico    | INT          | Chave primária autoincrementável               |
| nm_servico    | VARCHAR(100) | Nome do serviço                                |
| ds_servico    | TEXT         | Descrição do serviço                           |
| vl_preco      | DECIMAL(10,2)| Preço do serviço                               |

### Tabela de Orçamentos (`tb_orcamentos`)

| Coluna         | Tipo         | Descrição                                         |
|----------------|--------------|---------------------------------------------------|
| id_orcamento   | INT          | Chave primária autoincrementável                  |
| id_usuario     | INT          | Chave estrangeira referenciando tb_usuarios       |
| id_casamento   | INT          | Chave estrangeira referenciando tb_info_casamento |
| dt_orcamento   | DATE         | Data do orçamento                                 |
| ds_status      | VARCHAR(20)  | Status do orçamento (por exemplo, pendente, aceito, rejeitado) |
| ds_observacao_geral | TEXT   | Observação geral do orçamento                     |
| nm_orcador     | VARCHAR(100) | Nome do responsável pelo orçamento               |

### Tabela de Detalhes do Orçamento (`tb_detalhes_orcamento`)

| Coluna               | Tipo         | Descrição                                       |
|----------------------|--------------|-------------------------------------------------|
| id_detalhe_orcamento| INT           | Chave primária autoincrementável                |
| id_orcamento         | INT          | Chave estrangeira referenciando tb_orcamentos    |
| id_servico           | INT          | Chave estrangeira referenciando tb_servicos      |
| nr_quantidade        | INT          | Quantidade do serviço incluída no orçamento     |
| vl_preco_editavel    | DECIMAL(10,2)| Preço editável do serviço no orçamento          |
| ds_observacao_servico| TEXT         | Observação específica do serviço no orçamento   |

## Figma

![Figma]<https://www.figma.com/file/y73G9AIo4N6H5Y49imq0oc/Date-of-Love?type=design&node-id=219%3A5&mode=design&t=QFt8muZruoZMN9vT-1>


## Tela prototipação

### Telas de Interface do Usuário:
1. ![Página Inicial](telas/Home.png)
2. ![Login](telas/Login.png)
3. ![Criar Conta](telas/Criar%20conta.png)
4. ![Perfil](telas/Perfil.png)
5. ![Ajuda](telas/Ajuda%20Suporte.png)
6. ![Serviços](telas/Serviços.png)
7. ![Seleção de Serviços](telas/Seleção%20de%20serviços.png)
8. ![Orçamento](telas/Orçamento.png)
9. ![Visualizar Orçamento](telas/Visualizar%20Orçamento.png)
10. ![Sobre Nós](telas/Sobre%20nós.png)

### Telas de Administração (ADM):
1. ![Orçamento - ADM](telas/Orçamento%20-%20ADM.png)
2. ![Visualizar Orçamento - ADM](telas/Visualizar%20Orçamento%20-%20ADM.png)


