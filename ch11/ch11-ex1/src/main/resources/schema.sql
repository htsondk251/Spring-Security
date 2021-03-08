CREATE TABLE IF NOT EXISTS `spring`.`user` (
    -- `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
    `password` TEXT NULL,
    PRIMARY KEY(`username`)
);

CREATE TABLE IF NOT EXISTS `spring`.`otp` (
    -- `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
    `code` VARCHAR(45) NULL,
    PRIMARY KEY(`username`)
);