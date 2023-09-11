insert into cozinha (id, nome) values (1, 'Tailandesa')
insert into cozinha (id, nome) values (2, 'Indiana')
insert into cozinha (id, nome) values (3, 'Brasileira')

insert into forma_pagamento (id, descricao) values (1, "Dinheiro")
insert into forma_pagamento (id, descricao) values (2, "Crédito")
insert into forma_pagamento (id, descricao) values (3, "Débito")
insert into forma_pagamento (id, descricao) values (4, "Vale refeição")

insert into estado (id, nome) values (1, "São Paulo")
insert into estado (id, nome) values (2, "Rio de Janeiro")
insert into estado (id, nome) values (3, "Minas Gerais")
insert into estado (id, nome) values (4, "Bahia")

insert into cidade (id, nome, estado_id) values (1, "Osasco", 1)
insert into cidade (id, nome, estado_id) values (2, "Niterói", 2)
insert into cidade (id, nome, estado_id) values (3, "Salvador", 4)
insert into cidade (id, nome, estado_id) values (4, "Belo Horizonte", 3)

insert into restaurante (nome, taxa_frete, cozinha_id, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_complemento, endereco_numero, endereco_bairro, data_cadastro, data_atualizacao) values ('Rancho da vovó', 0, 3, 1, '06267-070', 'Rua Zezinho', 'fundos', '108', 'Itaqua', utc_timestamp, utc_timestamp)
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Cantinho da pamonha', 0, 3, utc_timestamp, utc_timestamp)
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Thai Gourmet', 10, 1, utc_timestamp, utc_timestamp)
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Thai Delivery', 9.50, 1, utc_timestamp, utc_timestamp)
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Tuk Tuk Comida Indiana', 15, 2, utc_timestamp, utc_timestamp)

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 3), (2, 1), (2, 2), (2, 4), (3, 1), (3, 3), (3, 4), (4, 1), (4, 2), (4, 3), (5, 1), (5, 2), (5, 4)

insert into permissao (id, nome, descricao) values (1, "Cadastro Produtos", "Permite cadastrar produtos")
insert into permissao (id, nome, descricao) values (2, "Cadastro Restaurantes", "Permite cadastrar restaurantes")
insert into permissao (id, nome, descricao) values (3, "Cadastro Forma de Pagamento", "Permite cadastrar fornas de pagamento")

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ("Lasanha", "prato italiano", 37.65, true, 1)
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ("Kibe", "prato árabe", 27.87, true, 2)
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ("Acarajé", "prato brasileiro", 67.44, true, 2)
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ("Feijoada", "prato clássico", 47.38, true, 1)

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, 1, 3);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Camarão tailandês', '16 camarões grandes ao molho picante', 110, 1, 4);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, 1, 2);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, 1, 5);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, 1, 3);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, 1, 1);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('T-Bone', 'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon', 89, 1, 2);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Sanduíche X-Tudo', 'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese', 19, 1, 1);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Espetinho de Cupim', 'Acompanha farinha, mandioca e vinagrete', 8, 1, 1);