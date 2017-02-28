
/*Cria a base de dados agenda_contatos*/
CREATE DATABASE agenda_contatos;
/*seleciona a base agenda_contatos*/
USE agenda_contatos;
/*Cria a tablema contato*/
CREATE TABLE contato (
  /*criando os campos*/
  id_contato int NOT NULL AUTO_INCREMENT, 
  nome varchar(100),
  data_nasc date,
  telefone varchar(11),
  email varchar(60),
  sexo char(1),
  data_Ehora timestamp default current_timestamp,
  favorito BOOLEAN,
  tipo_telefone INT,
  PRIMARY KEY(id_contato) /*Configura o campo "id_contato" sendo a chave primária */
);
/*insert de teste*/
/*CURRENT_TIMESTAMP ==  pega" a data e hora do momento do insert */
INSERT INTO contato (nome, data_nasc, telefone, email, sexo, data_Ehora)
VALUES ("Nome", "2017-02-01", "1199999999", "email@email.com", "m", CURRENT_TIMESTAMP);

