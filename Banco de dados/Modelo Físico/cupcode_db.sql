-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema cupcode_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cupcode_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cupcode_db` DEFAULT CHARACTER SET utf8 ;
USE `cupcode_db` ;

-- -----------------------------------------------------
-- Table `cupcode_db`.`Estudante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcode_db`.`Estudante` (
  `matricula` VARCHAR(14) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `sobrenome` VARCHAR(100) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `senha` VARCHAR(100) NOT NULL,
  `data_cadastro` DATETIME NOT NULL,
  `ultimo_acesso` DATETIME NOT NULL,
  `pontuacao` INT NULL DEFAULT 0,
  `foto` INT NOT NULL,
  PRIMARY KEY (`matricula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcode_db`.`Conquista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcode_db`.`Conquista` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `descricao` TEXT NOT NULL,
  `icon` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcode_db`.`Assunto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcode_db`.`Assunto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcode_db`.`Quiz`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcode_db`.`Quiz` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NOT NULL,
  `Assunto_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Quiz_Assunto1_idx` (`Assunto_id` ASC) VISIBLE,
  CONSTRAINT `fk_Quiz_Assunto1`
    FOREIGN KEY (`Assunto_id`)
    REFERENCES `cupcode_db`.`Assunto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcode_db`.`Dificuldade_Questao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcode_db`.`Dificuldade_Questao` (
  `id_dificuldade` INT NOT NULL AUTO_INCREMENT,
  `nivel` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_dificuldade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcode_db`.`Modo_Questao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcode_db`.`Modo_Questao` (
  `id_modo` INT NOT NULL AUTO_INCREMENT,
  `modo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_modo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcode_db`.`Questao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcode_db`.`Questao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `enunciado` TEXT NOT NULL,
  `pontuacao` INT NOT NULL,
  `Quiz_id` INT NOT NULL,
  `Dificuldade_id` INT NOT NULL,
  `Modo_Questao_id_modo` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Questao_Quiz1_idx` (`Quiz_id` ASC) VISIBLE,
  INDEX `fk_Questao_Dificuldade1_idx` (`Dificuldade_id` ASC) VISIBLE,
  INDEX `fk_Questao_Modo_Questao1_idx` (`Modo_Questao_id_modo` ASC) VISIBLE,
  CONSTRAINT `fk_Questao_Quiz1`
    FOREIGN KEY (`Quiz_id`)
    REFERENCES `cupcode_db`.`Quiz` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Questao_Dificuldade1`
    FOREIGN KEY (`Dificuldade_id`)
    REFERENCES `cupcode_db`.`Dificuldade_Questao` (`id_dificuldade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Questao_Modo_Questao1`
    FOREIGN KEY (`Modo_Questao_id_modo`)
    REFERENCES `cupcode_db`.`Modo_Questao` (`id_modo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcode_db`.`Conteudo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcode_db`.`Conteudo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `texto` TEXT NOT NULL,
  `imagem` BLOB NULL,
  `Assunto_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Conteudo_Assunto1_idx` (`Assunto_id` ASC) VISIBLE,
  CONSTRAINT `fk_Conteudo_Assunto1`
    FOREIGN KEY (`Assunto_id`)
    REFERENCES `cupcode_db`.`Assunto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcode_db`.`progresso_conquista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcode_db`.`progresso_conquista` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `desbloqueio` TINYINT NOT NULL,
  `Conquista_id` INT NOT NULL,
  `Estudante_matricula` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_progresso_conquista_Conquista1_idx` (`Conquista_id` ASC) VISIBLE,
  INDEX `fk_progresso_conquista_Estudante1_idx` (`Estudante_matricula` ASC) VISIBLE,
  CONSTRAINT `fk_progresso_conquista_Conquista1`
    FOREIGN KEY (`Conquista_id`)
    REFERENCES `cupcode_db`.`Conquista` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_progresso_conquista_Estudante1`
    FOREIGN KEY (`Estudante_matricula`)
    REFERENCES `cupcode_db`.`Estudante` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcode_db`.`estudante_assunto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcode_db`.`estudante_assunto` (
  `concluido` TINYINT NOT NULL,
  `Estudante_matricula` VARCHAR(14) NOT NULL,
  `Assunto_id` INT NOT NULL,
  INDEX `fk_estudante_assunto_Estudante1_idx` (`Estudante_matricula` ASC) VISIBLE,
  INDEX `fk_estudante_assunto_Assunto1_idx` (`Assunto_id` ASC) VISIBLE,
  CONSTRAINT `fk_estudante_assunto_Estudante1`
    FOREIGN KEY (`Estudante_matricula`)
    REFERENCES `cupcode_db`.`Estudante` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_estudante_assunto_Assunto1`
    FOREIGN KEY (`Assunto_id`)
    REFERENCES `cupcode_db`.`Assunto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcode_db`.`Alternativa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcode_db`.`Alternativa` (
  `id_alternativa` INT NOT NULL AUTO_INCREMENT,
  `texto` VARCHAR(255) NOT NULL,
  `resposta_certa` TINYINT NOT NULL,
  `Questao_id` INT NOT NULL,
  PRIMARY KEY (`id_alternativa`),
  INDEX `fk_Alternativa_Questao1_idx` (`Questao_id` ASC) VISIBLE,
  CONSTRAINT `fk_Alternativa_Questao1`
    FOREIGN KEY (`Questao_id`)
    REFERENCES `cupcode_db`.`Questao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcode_db`.`Estudante_Quiz`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcode_db`.`Estudante_Quiz` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `inicio_quiz` DATETIME NOT NULL,
  `fim_quiz` DATETIME NULL,
  `pontuacao_total` INT NULL,
  `Estudante_matricula` VARCHAR(14) NOT NULL,
  `Quiz_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Estudante_Quiz_Estudante1_idx` (`Estudante_matricula` ASC) VISIBLE,
  INDEX `fk_Estudante_Quiz_Quiz1_idx` (`Quiz_id` ASC) VISIBLE,
  CONSTRAINT `fk_Estudante_Quiz_Estudante1`
    FOREIGN KEY (`Estudante_matricula`)
    REFERENCES `cupcode_db`.`Estudante` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Estudante_Quiz_Quiz1`
    FOREIGN KEY (`Quiz_id`)
    REFERENCES `cupcode_db`.`Quiz` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcode_db`.`Resposta_Quiz`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcode_db`.`Resposta_Quiz` (
  `id` INT NOT NULL,
  `id_questao` INT NOT NULL,
  `alternativa_escolhida` INT NOT NULL,
  `Quiz_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Respostas_Quiz1_idx` (`Quiz_id` ASC) VISIBLE,
  CONSTRAINT `fk_Respostas_Quiz1`
    FOREIGN KEY (`Quiz_id`)
    REFERENCES `cupcode_db`.`Quiz` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
