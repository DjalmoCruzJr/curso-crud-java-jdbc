DROP SCHEMA IF EXISTS `curso_crud_java_jdbc_db` ;
CREATE SCHEMA IF NOT EXISTS `curso_crud_java_jdbc_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `curso_crud_java_jdbc_db` ;

-- -----------------------------------------------------
-- Table `curso_crud_java_jdbc_db`.`tb_categories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `curso_crud_java_jdbc_db`.`tb_categories` ;

CREATE TABLE IF NOT EXISTS `curso_crud_java_jdbc_db`.`tb_categories` (
  `category_id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`category_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `curso_crud_java_jdbc_db`.`tb_products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `curso_crud_java_jdbc_db`.`tb_products` ;

CREATE TABLE IF NOT EXISTS `curso_crud_java_jdbc_db`.`tb_products` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(255) NOT NULL,
  `product_description` VARCHAR(255) NULL,
  `product_category_id` INT NOT NULL,
  PRIMARY KEY (`product_id`),
  INDEX `fk_tb_products_tb_categories_idx` (`product_category_id` ASC),
  CONSTRAINT `fk_tb_products_tb_categories`
    FOREIGN KEY (`product_category_id`)
    REFERENCES `curso_crud_java_jdbc_db`.`tb_categories` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;