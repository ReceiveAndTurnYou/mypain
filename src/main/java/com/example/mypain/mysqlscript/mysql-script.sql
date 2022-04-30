SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `logisticdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `logisticdb` ;

CREATE TABLE IF NOT EXISTS `logisticdb`.`delivery_company` (
   `iddelivery_company` INT NOT NULL AUTO_INCREMENT,
    `company_name` VARCHAR(45) NOT NULL,
    `trust_factor` VARCHAR(45) NOT NULL,
    `company_description` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`iddelivery_company`),
    UNIQUE INDEX `company_name_UNIQUE` (`company_name` ASC) VISIBLE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 6
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `logisticdb`.`users` (
    `idusers` INT NOT NULL AUTO_INCREMENT,
    `firstName` VARCHAR(45) NOT NULL,
    `surname` VARCHAR(45) NOT NULL,
    `login` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    `country` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`idusers`, `login`),
    UNIQUE INDEX `idusers_UNIQUE` (`idusers` ASC) VISIBLE,
    UNIQUE INDEX `surname_UNIQUE` (`surname` ASC) VISIBLE,
    INDEX `fk_login_idx` (`login` ASC) VISIBLE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 5
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `logisticdb`.`product_tp` (
    `idproduct_tp` INT NOT NULL AUTO_INCREMENT,
    `product_type` VARCHAR(45) NOT NULL,
    `description` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`idproduct_tp`),
    UNIQUE INDEX `product_type_UNIQUE` (`product_type` ASC) VISIBLE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 5
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `logisticdb`.`product_wh` (
    `idproduct_wh` INT NOT NULL AUTO_INCREMENT,
    `product_number` VARCHAR(45) NOT NULL,

    `product_type` VARCHAR(45) NOT NULL,
    `product_density` VARCHAR(45) NOT NULL,
    `product_conditions` VARCHAR(45) NOT NULL,
    `product_count` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`idproduct_wh`),
    UNIQUE INDEX `product_number_UNIQUE` (`product_number` ASC) VISIBLE,
    INDEX `fk_prType_idx` (`product_type` ASC) VISIBLE,
        CONSTRAINT `fk_prType`
            FOREIGN KEY (`product_type`)
                REFERENCES `logisticdb`.`product_tp` (`product_type`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 8
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `logisticdb`.`product_order` (
 `idproduct_order` INT NOT NULL AUTO_INCREMENT,
    `login` VARCHAR(45) NOT NULL,
        `product_count` VARCHAR(45) NOT NULL,
        `product_number` VARCHAR(45) NOT NULL,
        `company_name` VARCHAR(45) NOT NULL,
        `address` VARCHAR(45) NOT NULL,
        `email` VARCHAR(45) NOT NULL,
        `delivery_date` VARCHAR(45) NOT NULL,
        PRIMARY KEY (`idproduct_order`),
        UNIQUE INDEX `idproduct_order_UNIQUE` (`idproduct_order` ASC) VISIBLE,
        INDEX `fk_login_idx` (`login` ASC) VISIBLE,
        INDEX `fk_number_idx` (`product_number` ASC) VISIBLE,
        INDEX `fk_cmpName_idx` (`company_name` ASC) VISIBLE,
        CONSTRAINT `fk_cmpName`
        FOREIGN KEY (`company_name`)
        REFERENCES `logisticdb`.`delivery_company` (`company_name`)
        ON DELETE CASCADE    ON UPDATE CASCADE,
            CONSTRAINT `fk_login`
            FOREIGN KEY (`login`)
            REFERENCES `logisticdb`.`users` (`login`),
            CONSTRAINT `fk_number`
            FOREIGN KEY (`product_number`)
            REFERENCES `logisticdb`.`product_wh` (`product_number`)
            ON DELETE CASCADE
            ON UPDATE CASCADE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 9
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
