-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema initDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema initDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `initDB` DEFAULT CHARACTER SET utf8 ;
USE `initDB` ;

-- -----------------------------------------------------
-- Table `initDB`.`developers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `initDB`.`developers` (
  `idDevelopers` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDevelopers`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `initDB`.`skills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `initDB`.`skills` (
  `idSkills` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSkills`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `initDB`.`projects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `initDB`.`projects` (
  `idProjects` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProjects`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `initDB`.`companies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `initDB`.`companies` (
  `idCompanies` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCompanies`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `initDB`.`customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `initDB`.`customers` (
  `idCustomers` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCustomers`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `initDB`.`developers-skills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `initDB`.`developers_skills` (
  `idDevelopers_skills` INT NOT NULL AUTO_INCREMENT,
  `idDevelopers` INT NOT NULL,
  `idSkills` INT NOT NULL,
  PRIMARY KEY (`idDevelopers-skills`),
  INDEX `skill-devDevFK_idx` (`idDevelopers` ASC),
  INDEX `skill-devSkillFK_idx` (`idSkills` ASC),
  CONSTRAINT `skill-devDevFK`
    FOREIGN KEY (`idDevelopers`)
    REFERENCES `initDB`.`developers` (`idDevelopers`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `skill-devSkillFK`
    FOREIGN KEY (`idSkills`)
    REFERENCES `initDB`.`skills` (`idSkills`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `initDB`.`developers_projects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `initDB`.`developers_projects` (
  `idDevelopers_projects` INT NOT NULL AUTO_INCREMENT,
  `idDevelopers` INT NOT NULL,
  `idProjects` INT NOT NULL,
  PRIMARY KEY (`idDevelopers_projects`),
  INDEX `dev-projDevFK_idx` (`idDevelopers` ASC),
  INDEX `dev-projProjFK_idx` (`idProjects` ASC),
  CONSTRAINT `dev-projDevFK`
    FOREIGN KEY (`idDevelopers`)
    REFERENCES `initDB`.`developers` (`idDevelopers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `dev-projProjFK`
    FOREIGN KEY (`idProjects`)
    REFERENCES `initDB`.`projects` (`idProjects`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `initDB`.`companys-projects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `initDB`.`companys-projects` (
  `idcompanys_projects` INT NOT NULL AUTO_INCREMENT,
  `idCompanys` INT NOT NULL,
  `idProjects` INT NOT NULL,
  PRIMARY KEY (`idcompanys_projects`),
  INDEX `comp-projCompFK_idx` (`idCompanys` ASC),
  INDEX `comp-projProjFK_idx` (`idProjects` ASC),
  CONSTRAINT `comp-projCompFK`
    FOREIGN KEY (`idCompanys`)
    REFERENCES `initDB`.`companies` (`idCompanies`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `comp-projProjFK`
    FOREIGN KEY (`idProjects`)
    REFERENCES `initDB`.`projects` (`idProjects`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `initDB`.`customers_projects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `initDB`.`customers_projects` (
  `idcustomers_projects` INT NOT NULL AUTO_INCREMENT,
  `idCustomers` INT NOT NULL,
  `idProjects` INT NOT NULL,
  PRIMARY KEY (`idcustomers_projects`),
  INDEX `cust-projCustFK_idx` (`idCustomers` ASC),
  INDEX `cust-projProjFK_idx` (`idProjects` ASC),
  CONSTRAINT `cust-projCustFK`
    FOREIGN KEY (`idCustomers`)
    REFERENCES `initDB`.`customers` (`idCustomers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cust-projProjFK`
    FOREIGN KEY (`idProjects`)
    REFERENCES `initDB`.`projects` (`idProjects`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
