SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `scotchdb` ;
CREATE SCHEMA IF NOT EXISTS `scotchdb` DEFAULT CHARACTER SET utf8 ;
USE `scotchdb` ;

-- -----------------------------------------------------
-- Table `scotchdb`.`rel_link`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scotchdb`.`rel_link` ;

CREATE  TABLE IF NOT EXISTS `scotchdb`.`rel_link` (
  `id_rel_link` INT NOT NULL AUTO_INCREMENT ,
  `link_name` VARCHAR(100) NOT NULL ,
  `link` VARCHAR(400) NOT NULL ,
  `keywords` VARCHAR(200) NULL ,
  PRIMARY KEY (`id_rel_link`) )
ENGINE = InnoDB
COMMENT = 'Related links to important data entities';

CREATE UNIQUE INDEX `id_rel_link_UNIQUE` ON `scotchdb`.`rel_link` (`id_rel_link` ASC) ;


-- -----------------------------------------------------
-- Table `scotchdb`.`location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scotchdb`.`location` ;

CREATE  TABLE IF NOT EXISTS `scotchdb`.`location` (
  `id_location` INT NOT NULL AUTO_INCREMENT ,
  `location_cd` VARCHAR(20) NULL ,
  `location_name` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`id_location`) )
ENGINE = InnoDB
COMMENT = 'All location information related other entities';

CREATE UNIQUE INDEX `id_location_UNIQUE` ON `scotchdb`.`location` (`id_location` ASC) ;


-- -----------------------------------------------------
-- Table `scotchdb`.`owner`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scotchdb`.`owner` ;

CREATE  TABLE IF NOT EXISTS `scotchdb`.`owner` (
  `id_owner` INT NOT NULL AUTO_INCREMENT ,
  `owner_short_name` VARCHAR(45) NOT NULL ,
  `owner_name` VARCHAR(100) NOT NULL ,
  `registered_office` VARCHAR(100) NULL ,
  `location_id_location` INT NULL ,
  `rel_link_id_rel_link` INT NULL ,
  PRIMARY KEY (`id_owner`) ,
  CONSTRAINT `fk_owner_rel_link1`
    FOREIGN KEY (`rel_link_id_rel_link` )
    REFERENCES `scotchdb`.`rel_link` (`id_rel_link` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_owner_location1`
    FOREIGN KEY (`location_id_location` )
    REFERENCES `scotchdb`.`location` (`id_location` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Table to store Distillery and Independent Bottler owners';

CREATE UNIQUE INDEX `id_owner_UNIQUE` ON `scotchdb`.`owner` (`id_owner` ASC) ;

CREATE INDEX `fk_owner_rel_link1` ON `scotchdb`.`owner` (`rel_link_id_rel_link` ASC) ;

CREATE INDEX `fk_owner_location1` ON `scotchdb`.`owner` (`location_id_location` ASC) ;


-- -----------------------------------------------------
-- Table `scotchdb`.`ref_distillery_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scotchdb`.`ref_distillery_status` ;

CREATE  TABLE IF NOT EXISTS `scotchdb`.`ref_distillery_status` (
  `id_ref_distillery_status` INT NOT NULL AUTO_INCREMENT ,
  `status_name` VARCHAR(45) NOT NULL ,
  `status_description` VARCHAR(200) NULL ,
  PRIMARY KEY (`id_ref_distillery_status`) )
ENGINE = InnoDB
COMMENT = 'Open, Closed, Mothballed, Dismantled';

CREATE UNIQUE INDEX `id_ref_distillery_status_UNIQUE` ON `scotchdb`.`ref_distillery_status` (`id_ref_distillery_status` ASC) ;


-- -----------------------------------------------------
-- Table `scotchdb`.`distillery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scotchdb`.`distillery` ;

CREATE  TABLE IF NOT EXISTS `scotchdb`.`distillery` (
  `id_distillery` INT NOT NULL AUTO_INCREMENT ,
  `distillery_name` VARCHAR(45) NOT NULL ,
  `water_source` VARCHAR(45) NULL ,
  `capacity` INT NULL ,
  `stills` VARCHAR(100) NULL ,
  `owner_id_owner` INT NOT NULL ,
  `ref_distillery_status_id_ref_distillery_status` INT NOT NULL ,
  `location_id_location` INT NULL ,
  `rel_link_id_rel_link` INT NULL ,
  PRIMARY KEY (`id_distillery`) ,
  CONSTRAINT `fk_distillery_owner1`
    FOREIGN KEY (`owner_id_owner` )
    REFERENCES `scotchdb`.`owner` (`id_owner` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_distillery_location1`
    FOREIGN KEY (`location_id_location` )
    REFERENCES `scotchdb`.`location` (`id_location` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_distillery_ref_distillery_status1`
    FOREIGN KEY (`ref_distillery_status_id_ref_distillery_status` )
    REFERENCES `scotchdb`.`ref_distillery_status` (`id_ref_distillery_status` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_distillery_rel_link1`
    FOREIGN KEY (`rel_link_id_rel_link` )
    REFERENCES `scotchdb`.`rel_link` (`id_rel_link` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Distillery information';

CREATE UNIQUE INDEX `id_distillery_UNIQUE` ON `scotchdb`.`distillery` (`id_distillery` ASC) ;

CREATE INDEX `fk_distillery_owner1` ON `scotchdb`.`distillery` (`owner_id_owner` ASC) ;

CREATE INDEX `fk_distillery_location1` ON `scotchdb`.`distillery` (`location_id_location` ASC) ;

CREATE INDEX `fk_distillery_ref_distillery_status1` ON `scotchdb`.`distillery` (`ref_distillery_status_id_ref_distillery_status` ASC) ;

CREATE INDEX `fk_distillery_rel_link1` ON `scotchdb`.`distillery` (`rel_link_id_rel_link` ASC) ;


-- -----------------------------------------------------
-- Table `scotchdb`.`ref_region`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scotchdb`.`ref_region` ;

CREATE  TABLE IF NOT EXISTS `scotchdb`.`ref_region` (
  `id_ref_region` INT NOT NULL AUTO_INCREMENT ,
  `region_name` VARCHAR(45) NOT NULL ,
  `region_description` VARCHAR(200) NULL ,
  PRIMARY KEY (`id_ref_region`) )
ENGINE = InnoDB
COMMENT = 'Traditional Scottish Distillery Regions (or other for foreign malts)';

CREATE UNIQUE INDEX `id_ref_region_UNIQUE` ON `scotchdb`.`ref_region` (`id_ref_region` ASC) ;


-- -----------------------------------------------------
-- Table `scotchdb`.`ref_style`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scotchdb`.`ref_style` ;

CREATE  TABLE IF NOT EXISTS `scotchdb`.`ref_style` (
  `id_ref_style` INT NOT NULL AUTO_INCREMENT ,
  `style_name` VARCHAR(45) NOT NULL ,
  `style_description` VARCHAR(200) NULL ,
  PRIMARY KEY (`id_ref_style`) )
ENGINE = InnoDB
COMMENT = 'Styles for Malts';

CREATE UNIQUE INDEX `id_ref_style_UNIQUE` ON `scotchdb`.`ref_style` (`id_ref_style` ASC) ;


-- -----------------------------------------------------
-- Table `scotchdb`.`malt`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scotchdb`.`malt` ;

CREATE  TABLE IF NOT EXISTS `scotchdb`.`malt` (
  `id_malt` INT NOT NULL AUTO_INCREMENT ,
  `malt_name` VARCHAR(45) NOT NULL ,
  `malt_source` VARCHAR(100) NULL ,
  `malt_notes` VARCHAR(200) NULL ,
  `distillery_id_distillery` INT NOT NULL ,
  `ref_style_id_ref_style` INT NOT NULL ,
  `ref_region_id_ref_region` INT NOT NULL ,
  PRIMARY KEY (`id_malt`) ,
  CONSTRAINT `fk_malt_ref_style1`
    FOREIGN KEY (`ref_style_id_ref_style` )
    REFERENCES `scotchdb`.`ref_style` (`id_ref_style` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_malt_distillery1`
    FOREIGN KEY (`distillery_id_distillery` )
    REFERENCES `scotchdb`.`distillery` (`id_distillery` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_malt_ref_region1`
    FOREIGN KEY (`ref_region_id_ref_region` )
    REFERENCES `scotchdb`.`ref_region` (`id_ref_region` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_malt_UNIQUE` ON `scotchdb`.`malt` (`id_malt` ASC) ;

CREATE INDEX `fk_malt_ref_style1` ON `scotchdb`.`malt` (`ref_style_id_ref_style` ASC) ;

CREATE INDEX `fk_malt_distillery1` ON `scotchdb`.`malt` (`distillery_id_distillery` ASC) ;

CREATE INDEX `fk_malt_ref_region1` ON `scotchdb`.`malt` (`ref_region_id_ref_region` ASC) ;


-- -----------------------------------------------------
-- Table `scotchdb`.`independent_bottler`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scotchdb`.`independent_bottler` ;

CREATE  TABLE IF NOT EXISTS `scotchdb`.`independent_bottler` (
  `id_independent_bottler` INT NOT NULL ,
  `bottler_name` VARCHAR(45) NOT NULL ,
  `location_id_location` INT NULL ,
  `rel_link_id_rel_link` INT NULL ,
  `malt_id_malt` INT NOT NULL ,
  PRIMARY KEY (`id_independent_bottler`) ,
  CONSTRAINT `fk_independent_bottler_rel_link1`
    FOREIGN KEY (`rel_link_id_rel_link` )
    REFERENCES `scotchdb`.`rel_link` (`id_rel_link` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_independent_bottler_location1`
    FOREIGN KEY (`location_id_location` )
    REFERENCES `scotchdb`.`location` (`id_location` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_independent_bottler_malt1`
    FOREIGN KEY (`malt_id_malt` )
    REFERENCES `scotchdb`.`malt` (`id_malt` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_independent_bottler_rel_link1` ON `scotchdb`.`independent_bottler` (`rel_link_id_rel_link` ASC) ;

CREATE INDEX `fk_independent_bottler_location1` ON `scotchdb`.`independent_bottler` (`location_id_location` ASC) ;

CREATE INDEX `fk_independent_bottler_malt1` ON `scotchdb`.`independent_bottler` (`malt_id_malt` ASC) ;


-- -----------------------------------------------------
-- Table `scotchdb`.`finish`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scotchdb`.`finish` ;

CREATE  TABLE IF NOT EXISTS `scotchdb`.`finish` (
  `id_finish` INT NOT NULL AUTO_INCREMENT ,
  `finish_type` VARCHAR(45) NOT NULL ,
  `finish_length` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_finish`) )
ENGINE = InnoDB;

CREATE INDEX `finish_type_INDEX` ON `scotchdb`.`finish` () ;


-- -----------------------------------------------------
-- Table `scotchdb`.`bottling`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scotchdb`.`bottling` ;

CREATE  TABLE IF NOT EXISTS `scotchdb`.`bottling` (
  `id_bottling` BIGINT NOT NULL AUTO_INCREMENT ,
  `bottling_name` VARCHAR(45) NOT NULL ,
  `abv` INT NOT NULL ,
  `cask_strength` ENUM('T','F') NOT NULL DEFAULT 'F' ,
  `bottling_special_name` VARCHAR(100) NULL ,
  `nas` ENUM('T','F') NOT NULL DEFAULT 'F' ,
  `age` INT NULL ,
  `vintage` YEAR NULL ,
  `finish_id_finish` INT NOT NULL ,
  `malt_id_malt` INT NOT NULL ,
  PRIMARY KEY (`id_bottling`) ,
  CONSTRAINT `fk_bottling_finish1`
    FOREIGN KEY (`finish_id_finish` )
    REFERENCES `scotchdb`.`finish` (`id_finish` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bottling_malt1`
    FOREIGN KEY (`malt_id_malt` )
    REFERENCES `scotchdb`.`malt` (`id_malt` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_bottling_finish1` ON `scotchdb`.`bottling` (`finish_id_finish` ASC) ;

CREATE INDEX `fk_bottling_malt1` ON `scotchdb`.`bottling` (`malt_id_malt` ASC) ;


-- -----------------------------------------------------
-- Table `scotchdb`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scotchdb`.`address` ;

CREATE  TABLE IF NOT EXISTS `scotchdb`.`address` (
  `id_address` INT NOT NULL AUTO_INCREMENT ,
  `address` VARCHAR(100) NULL ,
  `address2` VARCHAR(100) NULL ,
  `city` VARCHAR(45) NULL ,
  `region` VARCHAR(100) NULL ,
  `country` VARCHAR(100) NULL ,
  `postal_address` VARCHAR(20) NULL ,
  `location_id_location` INT NOT NULL ,
  PRIMARY KEY (`id_address`, `location_id_location`) ,
  CONSTRAINT `fk_address_location1`
    FOREIGN KEY (`location_id_location` )
    REFERENCES `scotchdb`.`location` (`id_location` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'All location information related to Distilleries, Purchases, and Tasting notes';

CREATE UNIQUE INDEX `id_location_UNIQUE` ON `scotchdb`.`address` (`id_address` ASC) ;

CREATE INDEX `fk_address_location1` ON `scotchdb`.`address` (`location_id_location` ASC) ;


-- -----------------------------------------------------
-- Table `scotchdb`.`latlong`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scotchdb`.`latlong` ;

CREATE  TABLE IF NOT EXISTS `scotchdb`.`latlong` (
  `id_latlong` INT NOT NULL AUTO_INCREMENT ,
  `location` POINT NOT NULL COMMENT 'lat/long data' ,
  `location_id_location` INT NOT NULL ,
  PRIMARY KEY (`id_latlong`, `location_id_location`) ,
  CONSTRAINT `fk_latlong_location1`
    FOREIGN KEY (`location_id_location` )
    REFERENCES `scotchdb`.`location` (`id_location` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'All location information related to Distilleries, Purchases, and Tasting notes';

CREATE UNIQUE INDEX `id_location_UNIQUE` ON `scotchdb`.`latlong` (`id_latlong` ASC) ;

CREATE INDEX `fk_latlong_location1` ON `scotchdb`.`latlong` (`location_id_location` ASC) ;


-- -----------------------------------------------------
-- Table `scotchdb`.`purchase`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scotchdb`.`purchase` ;

CREATE  TABLE IF NOT EXISTS `scotchdb`.`purchase` (
  `id_purchase` INT NOT NULL AUTO_INCREMENT ,
  `purchase_date` DATE NOT NULL ,
  `price` DECIMAL(10,2) UNSIGNED NULL ,
  `quantity_bought` INT NOT NULL DEFAULT '1' ,
  `quantity_consumed` INT NOT NULL DEFAULT '0' ,
  `bottling_year` YEAR NOT NULL ,
  `is_year_approximate` ENUM('Y','N') NOT NULL DEFAULT 'Y' ,
  `bottling_id_bottling` INT NOT NULL ,
  `rel_link_id_rel_link` INT NULL ,
  `location_id_location` INT NULL ,
  PRIMARY KEY (`id_purchase`) ,
  CONSTRAINT `fk_purchase_rel_link1`
    FOREIGN KEY (`rel_link_id_rel_link` )
    REFERENCES `scotchdb`.`rel_link` (`id_rel_link` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_location1`
    FOREIGN KEY (`location_id_location` )
    REFERENCES `scotchdb`.`location` (`id_location` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_bottling1`
    FOREIGN KEY (`bottling_id_bottling` )
    REFERENCES `scotchdb`.`bottling` (`id_bottling` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_purchase_UNIQUE` ON `scotchdb`.`purchase` (`id_purchase` ASC) ;

CREATE INDEX `fk_purchase_rel_link1` ON `scotchdb`.`purchase` (`rel_link_id_rel_link` ASC) ;

CREATE INDEX `fk_purchase_location1` ON `scotchdb`.`purchase` (`location_id_location` ASC) ;

CREATE INDEX `fk_purchase_bottling1` ON `scotchdb`.`purchase` (`bottling_id_bottling` ASC) ;


-- -----------------------------------------------------
-- Table `scotchdb`.`tasting_tags`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scotchdb`.`tasting_tags` ;

CREATE  TABLE IF NOT EXISTS `scotchdb`.`tasting_tags` (
  `id_tasting_tags` INT NOT NULL AUTO_INCREMENT ,
  `nose` VARCHAR(100) NOT NULL ,
  `palate` VARCHAR(100) NOT NULL ,
  `body` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`id_tasting_tags`) )
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_tasting_tags_UNIQUE` ON `scotchdb`.`tasting_tags` (`id_tasting_tags` ASC) ;


-- -----------------------------------------------------
-- Table `scotchdb`.`tasting`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scotchdb`.`tasting` ;

CREATE  TABLE IF NOT EXISTS `scotchdb`.`tasting` (
  `id_tasting` BIGINT NOT NULL AUTO_INCREMENT ,
  `tasting_date` DATE NOT NULL ,
  `colour` VARCHAR(45) NULL ,
  `review` VARCHAR(2000) NULL ,
  `purchase_id_purchase` INT NOT NULL ,
  `tasting_tags_id_tasting_tags` INT NOT NULL ,
  `location_id_location` INT NULL ,
  PRIMARY KEY (`id_tasting`) ,
  CONSTRAINT `fk_tasting_tasting_tags1`
    FOREIGN KEY (`tasting_tags_id_tasting_tags` )
    REFERENCES `scotchdb`.`tasting_tags` (`id_tasting_tags` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tasting_location1`
    FOREIGN KEY (`location_id_location` )
    REFERENCES `scotchdb`.`location` (`id_location` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tasting_purchase1`
    FOREIGN KEY (`purchase_id_purchase` )
    REFERENCES `scotchdb`.`purchase` (`id_purchase` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_tasting_UNIQUE` ON `scotchdb`.`tasting` (`id_tasting` ASC) ;

CREATE INDEX `fk_tasting_tasting_tags1` ON `scotchdb`.`tasting` (`tasting_tags_id_tasting_tags` ASC) ;

CREATE INDEX `fk_tasting_location1` ON `scotchdb`.`tasting` (`location_id_location` ASC) ;

CREATE INDEX `fk_tasting_purchase1` ON `scotchdb`.`tasting` (`purchase_id_purchase` ASC) ;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
