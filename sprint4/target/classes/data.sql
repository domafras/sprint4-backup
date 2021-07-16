INSERT INTO PESSOA(nome, cpf, salario, sexo) VALUES('Fulaninho de Tal', '01898745028', '1500.00', 'M')
INSERT INTO PESSOA(nome, cpf, salario, sexo) VALUES('Beltrão', '22222222222', '2200.00', 'M')
INSERT INTO PESSOA(nome, cpf, salario, sexo) VALUES('Casimiro', '33333333333', '3300.00', 'M')

INSERT INTO ENDERECO(pais, estado, cidade, cep, rua) VALUES ('Brasil', 'Rio Grande do Sul', 'Pelotas', '96075230', 'Visconde de Abaete')
INSERT INTO ENDERECO(pais, estado, cidade, cep, rua) VALUES ('Brasil', 'Paraná', 'Curitiba', '80250160', 'Brigadeiro Franco')
INSERT INTO ENDERECO(pais, estado, cidade, cep, rua) VALUES ('Brasil', 'Santa Catarina', 'Itajaí', '75075210', 'General Carneiro')

INSERT INTO PESSOA_ENDERECOS(pessoa_id, enderecos_cep) VALUES ('1', '96075230')
INSERT INTO PESSOA_ENDERECOS(pessoa_id, enderecos_cep) VALUES ('2', '80250160')
INSERT INTO PESSOA_ENDERECOS(pessoa_id, enderecos_cep) VALUES ('3', '75075210')

INSERT INTO PRODUTO(id, descricao, preco_unitario, status) VALUES (1, 'Arroz', '10.00', TRUE)
INSERT INTO PRODUTO(id, descricao, preco_unitario, status) VALUES (2, 'Feijão', '5.00', TRUE)
INSERT INTO PRODUTO(id, descricao, preco_unitario, status) VALUES (3, 'Açucar', '3.50', TRUE)
INSERT INTO PRODUTO(id, descricao, preco_unitario, status) VALUES (4, 'Lentilha', '4.00', TRUE)