CREATE DATABASE funeraria;
USE funeraria;
CREATE TABLE funcionario(
nome varchar(20),
cod_funcionario int(10),
PRIMARY KEY (cod_funcionario)
);

CREATE TABLE atendente(
nivelAcesso int(3),
cod_funcionario int(10),
FOREIGN KEY (cod_funcionario) REFERENCES funcionario (cod_funcionario)
);

CREATE TABLE administrador(
areaVisualização varchar(10),
cod_funcionario int(10),
FOREIGN KEY (cod_funcionario) REFERENCES funcionario (cod_funcionario)
);

CREATE TABLE agendamento(
dataAgendamento date,
hora int(4),
cod_agendamento int(10),
cod_funcionario int(10),
PRIMARY KEY (cod_agendamento),
FOREIGN KEY (cod_funcionario) REFERENCES funcionario (cod_funcionario)
);

CREATE TABLE endereco(
bairro varchar(20),
estado varchar(20),
cep varchar(20),
rua varchar(20),
numero varchar(20),
cidade varchar(20),
PRIMARY KEY (cep)
);


CREATE TABLE cliente(
cod_cliente int NOT NULL AUTO_INCREMENT,
CPF varchar(20),
nome varchar(20),
cep varchar(20),
telefone varchar(11),
PRIMARY KEY (cod_cliente)
-- FOREIGN KEY (cep) REFERENCES endereco (cep)
);

CREATE TABLE produto(
nome varchar(20),
cod_produto int(10),
PRIMARY KEY (cod_produto)
);

CREATE TABLE falecido(
nome varchar(20),
dataFalecimento date,
cod_cliente int(10),
FOREIGN KEY (cod_cliente) REFERENCES cliente (cod_cliente)
);
ALTER TABLE produto
ADD preco DECIMAL (10,2);
ALTER TABLE falecido
ADD cod_falecido INT PRIMARY KEY;