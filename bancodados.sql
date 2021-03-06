-- MySQL Script generated by MySQL Workbench
-- 05/12/20 10:52:37
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema manu_milena
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `manu_milena` ;

-- -----------------------------------------------------
-- Schema manu_milena
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `manu_milena` DEFAULT CHARACTER SET utf8 ;
USE `manu_milena` ;

-- -----------------------------------------------------
-- Table `manu_milena`.`parmoeda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `manu_milena`.`parmoeda` ;

CREATE TABLE IF NOT EXISTS `manu_milena`.`parmoeda` (
  `idparmoeda` INT NOT NULL,
  `descricao` VARCHAR(50) NULL,
  PRIMARY KEY (`idparmoeda`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `manu_milena`.`investimentodiario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `manu_milena`.`investimentodiario` ;

CREATE TABLE IF NOT EXISTS `manu_milena`.`investimentodiario` (
  `idinvestimentodiario` INT NOT NULL AUTO_INCREMENT,
  `datahora` DATETIME NULL,
  `operacao` INT NULL,
  `abertura` DOUBLE NULL,
  `fechamento` DOUBLE NULL,
  `payout` INT NULL,
  `valorentrada` DOUBLE NULL,
  `ganhoperca` DOUBLE NULL,
  `parmoeda_id` INT NOT NULL,
  PRIMARY KEY (`idinvestimentodiario`))
ENGINE = InnoDB;

CREATE INDEX `fk_investimentodiario_parmoeda_idx` ON `manu_milena`.`investimentodiario` (`parmoeda_id` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
