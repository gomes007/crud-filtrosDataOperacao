-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db_dashboard
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_dashboard
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_dashboard` DEFAULT CHARACTER SET utf8 ;
USE `db_dashboard` ;

-- -----------------------------------------------------
-- Table `db_dashboard`.`tb_gestores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_dashboard`.`tb_gestores` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `COD_FUNC_GESTOR` VARCHAR(45) NOT NULL,
  `NOME_GESTOR` VARCHAR(45) NULL,
  `CARGO_GESTOR` VARCHAR(45) NULL,
  `DATA_INICIO` DATE NULL,
  `DATA_FIM` DATE NULL,
  PRIMARY KEY (`COD_FUNC_GESTOR`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_dashboard`.`tb_funcionarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_dashboard`.`tb_funcionarios` (
  `ID` INT NULL AUTO_INCREMENT,
  `COD_FUNC` VARCHAR(45) NOT NULL,
  `NOME` VARCHAR(45) NULL,
  `CARGO` ENUM('Gerente', 'Coordenador', 'Supervisor', 'Operador') NULL,
  `EMAIL` VARCHAR(45) NULL,
  `STATUS` ENUM('Ativo', 'Ferias', 'Desligado') NULL,
  `tb_gestores_COD_FUNC_GESTOR` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`COD_FUNC`),
  INDEX `fk_tb_funcionarios_tb_gestores_idx` (`tb_gestores_COD_FUNC_GESTOR` ASC) VISIBLE,
  CONSTRAINT `fk_tb_funcionarios_tb_gestores`
    FOREIGN KEY (`tb_gestores_COD_FUNC_GESTOR`)
    REFERENCES `db_dashboard`.`tb_gestores` (`COD_FUNC_GESTOR`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_dashboard`.`tb_atendidas_servicos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_dashboard`.`tb_atendidas_servicos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `COD_SERVICO` INT NOT NULL,
  PRIMARY KEY (`COD_SERVICO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_dashboard`.`tb_atendidas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_dashboard`.`tb_atendidas` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `COD_FUNC` VARCHAR(45) NOT NULL,
  `QDE_ATENDIDAS` INT NULL,
  `TMA` INT NULL,
  `SHORT_CALL` INT NULL,
  `DATA_ATENDIMENTO` DATE NOT NULL,
  `COD_SERVICO_ATENDIDO` INT NOT NULL,
  `tb_funcionarios_COD_FUNC` VARCHAR(45) NOT NULL,
  `tb_atendidas_servicos_COD_SERVICO` INT NOT NULL,
  PRIMARY KEY (`COD_FUNC`),
  INDEX `fk_tb_atendidas_tb_funcionarios1_idx` (`tb_funcionarios_COD_FUNC` ASC) VISIBLE,
  INDEX `fk_tb_atendidas_tb_atendidas_servicos1_idx` (`tb_atendidas_servicos_COD_SERVICO` ASC) VISIBLE,
  CONSTRAINT `fk_tb_atendidas_tb_funcionarios1`
    FOREIGN KEY (`tb_funcionarios_COD_FUNC`)
    REFERENCES `db_dashboard`.`tb_funcionarios` (`COD_FUNC`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_atendidas_tb_atendidas_servicos1`
    FOREIGN KEY (`tb_atendidas_servicos_COD_SERVICO`)
    REFERENCES `db_dashboard`.`tb_atendidas_servicos` (`COD_SERVICO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_dashboard`.`tb_servicos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_dashboard`.`tb_servicos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `COD_SERVICO` INT NOT NULL,
  `NOME_SERVICO` VARCHAR(45) NULL,
  `VALOR_SERVICO` DOUBLE NULL,
  `tb_atendidas_servicos_COD_SERVICO` INT NOT NULL,
  PRIMARY KEY (`COD_SERVICO`),
  INDEX `fk_tb_servicos_tb_atendidas_servicos1_idx` (`tb_atendidas_servicos_COD_SERVICO` ASC) VISIBLE,
  CONSTRAINT `fk_tb_servicos_tb_atendidas_servicos1`
    FOREIGN KEY (`tb_atendidas_servicos_COD_SERVICO`)
    REFERENCES `db_dashboard`.`tb_atendidas_servicos` (`COD_SERVICO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_dashboard`.`tb_faturamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_dashboard`.`tb_faturamento` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `QDE_CHAMADAS_FATURADAS` INT NULL,
  `VALOR_FATURADO` DOUBLE NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
