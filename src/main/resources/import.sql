insert into cozinha (id, nome) values (1, 'Tailandesa')
insert into cozinha (id, nome) values (2, 'Indiana')
insert into cozinha (id, nome) values (3, 'Brasileira')

insert into forma_pagamento (id, descricao) values (1, "Dinheiro")
insert into forma_pagamento (id, descricao) values (2, "Crédito")
insert into forma_pagamento (id, descricao) values (3, "Débito")
insert into forma_pagamento (id, descricao) values (4, "Vale refeição")

insert into restaurante (nome, taxa_frete, cozinha_id, forma_pagamento_id) values ('Rancho da vovó', 15.20, 3, 1)
insert into restaurante (nome, taxa_frete, cozinha_id, forma_pagamento_id) values ('Cantinho da pamonha', 5.30, 3, 3)
insert into restaurante (nome, taxa_frete, cozinha_id, forma_pagamento_id) values ('Thai Gourmet', 10, 1, 4)
insert into restaurante (nome, taxa_frete, cozinha_id, forma_pagamento_id) values ('Thai Delivery', 9.50, 1, 2)
insert into restaurante (nome, taxa_frete, cozinha_id, forma_pagamento_id) values ('Tuk Tuk Comida Indiana', 15, 2, 1)

insert into permissao (id, nome, descricao) values (1, "Cadastro Produtos", "Permite cadastrar produtos")
insert into permissao (id, nome, descricao) values (2, "Cadastro Restaurantes", "Permite cadastrar restaurantes")
insert into permissao (id, nome, descricao) values (3, "Cadastro Forma de Pagamento", "Permite cadastrar fornas de pagamento")

insert into estado (id, nome) values (1, "São Paulo")
insert into estado (id, nome) values (2, "Rio de Janeiro")
insert into estado (id, nome) values (3, "Minas Gerais")
insert into estado (id, nome) values (4, "Bahia")

insert into cidade (id, nome, estado_id) values (1, "Osasco", 1)
insert into cidade (id, nome, estado_id) values (2, "Niterói", 2)
insert into cidade (id, nome, estado_id) values (3, "Salvador", 4)
insert into cidade (id, nome, estado_id) values (4, "Belo Horizonte", 3)
