CREATE TABLE `test`.`persons` (
  `ID` INT(8) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(25) NULL,
  `isAdmin` BIT(64) NULL,
  `createdDate` TIMESTAMP(2) NULL,
  `Age` INT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
