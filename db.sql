
/*Cria a base de dados agenda_contatos*/
CREATE DATABASE agenda_contatos;
/*seleciona a base agenda_contatos*/
USE agenda_contatos;
/*Cria a tablema contato*/
CREATE TABLE contato (
  /*criando os campos*/
  id INT NOT NULL AUTO_INCREMENT, 
  nome VARCHAR(50),
  sobrenome VARCHAR(100),
  telefone VARCHAR(15),
  tipo_telefone INT,
  email VARCHAR(60),
  sexo INT(1),
  data_nasc DATE,
  favorito BOOLEAN,
  data_hora timestamp default current_timestamp,
  PRIMARY KEY(id) /*Configura o campo "id" sendo a chave primária */
);


