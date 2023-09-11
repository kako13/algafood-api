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
