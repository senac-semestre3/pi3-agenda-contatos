CREATE DATABASE agenda_contatos;
USE agenda_contatos;

CREATE TABLE `agenda_contatos`.`contatos` (
  `id_contato` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `data_nasc` DATE NOT NULL,
  `telefone` VARCHAR(11) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `sexo` CHAR(1) NULL,
  PRIMARY KEY (`id_contato`));
  
CREATE TABLE `agenda_contatos`.`dataEHora` (
  `data_hora` DATETIME NOT NULL,
  `id_contato` INT NOT NULL,
  PRIMARY KEY (`data_hora`));
  
ALTER TABLE `agenda_contatos`.`dataEHora` 
ADD INDEX `fk_id_contato` (`id_contato` ASC);
ALTER TABLE `agenda_contatos`.`dataEHora` 
ADD CONSTRAINT `id_contato`
  FOREIGN KEY (`id_contato`)
  REFERENCES `agenda_contatos`.`contatos` (`id_contato`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;