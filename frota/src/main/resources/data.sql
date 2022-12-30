INSERT INTO COMBUSTIVEL(descricao, preco) VALUES( 'Gasolina', 5.99);
INSERT INTO COMBUSTIVEL(descricao, preco) VALUES( 'Diesel', 6.99);

INSERT INTO FABRICANTE(name, fipe_name) VALUES('Fiat', 'Fiat');
INSERT INTO FABRICANTE(name, fipe_name) VALUES('Chevrolet','GM');

INSERT INTO SETOR(nome) VALUES('Secretaria de Educação');
INSERT INTO SETOR(nome) VALUES('Secretaria de Saúde');

INSERT INTO MOTORISTA(nome, matricula) VALUES('Pedro', '5489');
INSERT INTO MOTORISTA(nome, matricula) VALUES('João', '2378');

INSERT INTO VEICULO(combustivel_id, fabricante_id, motorista_id, placa) VALUES (1, 1, 1, 'nob-8888');

INSERT INTO ABASTECIMENTO(local_date, valor, combustivel_id, veiculo_id) VALUES ('2022-12-01', 100.00, 1, 1);

