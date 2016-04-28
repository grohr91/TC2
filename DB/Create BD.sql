SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `tc2` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `tc2` ;

-- -----------------------------------------------------
-- Table `tc2`.`grupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tc2`.`grupo` (
  `id_grupo` INT NOT NULL AUTO_INCREMENT,
  `id_grupo_sg` INT(11) NULL,
  `nm_grupo` VARCHAR(255) NOT NULL,
  `xp_atual` INT(11) NULL,
  `qt_desafios_concluidos` INT(11) NULL,
  `qt_metas_contluidas` INT(11) NULL,
  `qt_emblemas` INT(11) NULL,
  `qt_itens` INT(11) NULL,
  `vl_dinheiro` DOUBLE NULL,
  PRIMARY KEY (`id_grupo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tc2`.`individuo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tc2`.`individuo` (
  `id_individuo` INT NOT NULL AUTO_INCREMENT,
  `id_grupo` INT NOT NULL,
  `id_individuo_sg` INT(11) NULL,
  `nm_individuo` VARCHAR(45) NOT NULL,
  `dt_nascimento` DATE NULL,
  `xp_atual` INT(11) NULL,
  `qt_desafios_concluidos` INT(11) NULL,
  `qt_metas_concluidas` INT(11) NULL,
  `qt_emblemas` INT(11) NULL,
  `qt_itens` INT(11) NULL,
  `qt_vida` INT(11) NULL,
  PRIMARY KEY (`id_individuo`),
  UNIQUE INDEX `id_individuo_UNIQUE` (`id_individuo` ASC),
  INDEX `fk_individuo_grupo1_idx` (`id_grupo` ASC),
  CONSTRAINT `fk_individuo_grupo1`
    FOREIGN KEY (`id_grupo`)
    REFERENCES `tc2`.`grupo` (`id_grupo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tc2`.`equipe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tc2`.`equipe` (
  `id_equipe` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_equipe`))
ENGINE = InnoDB;


-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `tc2`.`desafio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tc2`.`desafio` (
  `id_desafio` INT NOT NULL AUTO_INCREMENT,
  `id_desafio_sg` INT(11) NULL,
  `nm_desafio` VARCHAR(255) NULL,
  `nr_nivel_necessario` INT(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_desafio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tc2`.`meta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tc2`.`meta` (
  `id_meta` INT NOT NULL AUTO_INCREMENT,
  `id_desafio` INT NOT NULL,
  `id_meta_sg` INT(11) NULL,
  `nm_meta` VARCHAR(255) NOT NULL,
  `sg_tipo` CHAR(1) NOT NULL,
  `fg_obrigatorio` Boolean ,
  `dt_deadline` DATETIME NULL,
  `vl_atingir` DOUBLE NULL,
  `sg_situacao_atingir` CHAR(1) NULL,
  `xp_reconpensa` DOUBLE NULL,
  PRIMARY KEY (`id_meta`),
  INDEX `fk_reconpensa_desafio1_idx` (`id_desafio` ASC),
  CONSTRAINT `fk_reconpensa_desafio1`
    FOREIGN KEY (`id_desafio`)
    REFERENCES `tc2`.`desafio` (`id_desafio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tc2`.`individuo_desafio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tc2`.`individuo_desafio` (
  `id_individuo_desafio` INT NOT NULL AUTO_INCREMENT,
  `id_individuo` INT NOT NULL,
  `id_desafio` INT NOT NULL,
  `sg_status` CHAR(1) NULL,
  `dt_inicio` DATETIME NULL,
  `dt_fim` DATETIME NULL,
  `xp_total_ganho` DOUBLE NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_individuo_desafio`),
  INDEX `fk_individuo_desafio_individuo1_idx` (`id_individuo` ASC),
  INDEX `fk_individuo_desafio_desafio1_idx` (`id_desafio` ASC),
  CONSTRAINT `fk_individuo_desafio_individuo1`
    FOREIGN KEY (`id_individuo`)
    REFERENCES `tc2`.`individuo` (`id_individuo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_individuo_desafio_desafio1`
    FOREIGN KEY (`id_desafio`)
    REFERENCES `tc2`.`desafio` (`id_desafio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tc2`.`parametro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tc2`.`parametro` (
  `id_parametro` VARCHAR(20) NOT NULL COMMENT 'A tabela parametro ira contrer informeções de:\n   Dados da conexão da origem\n   Nr dias de atualização\n   Nome da empresa',
  `vl_parametro` VARCHAR(255) NULL,
  PRIMARY KEY (`id_parametro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tc2`.`grupo_desafio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tc2`.`grupo_desafio` (
  `id_grupo_desafio` INT NOT NULL AUTO_INCREMENT,
  `id_grupo` INT NOT NULL,
  `id_desafio` INT NOT NULL,
  `sg_status` CHAR(1) NULL,
  `dt_inicio` DATETIME NULL,
  `dt_fim` DATETIME NULL,
  `xp_total_ganho` INT(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_grupo_desafio`),
  INDEX `fk_grupo_desafio_grupo1_idx` (`id_grupo` ASC),
  INDEX `fk_grupo_desafio_desafio1_idx` (`id_desafio` ASC),
  CONSTRAINT `fk_grupo_desafio_grupo1`
    FOREIGN KEY (`id_grupo`)
    REFERENCES `tc2`.`grupo` (`id_grupo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_grupo_desafio_desafio1`
    FOREIGN KEY (`id_desafio`)
    REFERENCES `tc2`.`desafio` (`id_desafio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tc2`.`individuo_desafio_meta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tc2`.`individuo_desafio_meta` (
  `idindividuo_desafio_meta` INT NOT NULL AUTO_INCREMENT,
  `individuo_desafio_id_individuo_desafio` INT NOT NULL,
  `meta_id_meta` INT NOT NULL,
  PRIMARY KEY (`idindividuo_desafio_meta`),
  INDEX `fk_individuo_desafio_meta_individuo_desafio1_idx` (`individuo_desafio_id_individuo_desafio` ASC),
  INDEX `fk_individuo_desafio_meta_meta1_idx` (`meta_id_meta` ASC),
  CONSTRAINT `fk_individuo_desafio_meta_individuo_desafio1`
    FOREIGN KEY (`individuo_desafio_id_individuo_desafio`)
    REFERENCES `tc2`.`individuo_desafio` (`id_individuo_desafio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_individuo_desafio_meta_meta1`
    FOREIGN KEY (`meta_id_meta`)
    REFERENCES `tc2`.`meta` (`id_meta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Todas as netas atingidas por um individum';


-- -----------------------------------------------------
-- Table `tc2`.`grupo_desafio_meta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tc2`.`grupo_desafio_meta` (
  `id_grupo_desafio_meta` INT NOT NULL AUTO_INCREMENT,
  `grupo_desafio_id_grupo_desafio` INT NOT NULL,
  `meta_id_meta` INT NOT NULL,
  PRIMARY KEY (`id_grupo_desafio_meta`),
  INDEX `fk_table1_grupo_desafio1_idx` (`grupo_desafio_id_grupo_desafio` ASC),
  INDEX `fk_table1_meta1_idx` (`meta_id_meta` ASC),
  CONSTRAINT `fk_table1_grupo_desafio1`
    FOREIGN KEY (`grupo_desafio_id_grupo_desafio`)
    REFERENCES `tc2`.`grupo_desafio` (`id_grupo_desafio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_meta1`
    FOREIGN KEY (`meta_id_meta`)
    REFERENCES `tc2`.`meta` (`id_meta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Todas as metas atingidas por um grupo';


-- -----------------------------------------------------
-- Table `tc2`.`conf_map`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tc2`.`conf_map` (
  `id_map` INT NOT NULL AUTO_INCREMENT,
  `nm_map` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_map`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `tc2`.`conf_mapping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tc2`.`conf_mapping` (
  `id_mapping` INT NOT NULL AUTO_INCREMENT,
  `id_map` INT NOT NULL,
  `nm_table_source` VARCHAR(255) NOT NULL,
  `nm_field_source` VARCHAR(255) NOT NULL,
  `nm_field_dest` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_mapping`),
  CONSTRAINT `fk_mapping_id_map`
    FOREIGN KEY (`id_map`)
    REFERENCES `tc2`.`conf_map` (`id_map`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


