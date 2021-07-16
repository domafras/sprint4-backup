INSERT INTO PESSOA(nome, cpf, salario, sexo) VALUES('Fulaninho de Tal', '01898745028', '1500.00', 'M')
INSERT INTO PESSOA(nome, cpf, salario, sexo) VALUES('Beltraninho de Tal', '13898645027', '2500.00', 'M')
INSERT INTO PESSOA(nome, cpf, salario, sexo) VALUES('Ciclaninha de Tal', '24898545026', '3500.00', 'F')

INSERT INTO ENDERECO(pais, estado, cidade, cep, rua) VALUES ('Brasil', 'Rio Grande do Sul', 'Pelotas', '96075230', 'Visconde de Abaete')
INSERT INTO ENDERECO(pais, estado, cidade, cep, rua) VALUES ('Brasil', 'Paraná', 'Curitiba', '80250160', 'Brigadeiro Franco')
INSERT INTO ENDERECO(pais, estado, cidade, cep, rua) VALUES ('Brasil', 'Santa Catarina', 'Itajaí', '75075210', 'General Carneiro')

INSERT INTO PESSOA_ENDERECOS(pessoa_id, enderecos_cep) VALUES ('1', '96075230')
INSERT INTO PESSOA_ENDERECOS(pessoa_id, enderecos_cep) VALUES ('2', '80250160')
INSERT INTO PESSOA_ENDERECOS(pessoa_id, enderecos_cep) VALUES ('3', '75075210')