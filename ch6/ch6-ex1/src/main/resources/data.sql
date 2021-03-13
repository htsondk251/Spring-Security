INSERT IGNORE INTO `SSchap6`.`user` (`id`, `username`, `password`, `algorithm`) VALUES ('1', 'son', '$2a$10$yupnMs7j2bKBGRTlr9LcfuZdNZHkCWyyS3zl1QIU90qigHJo9ueF6', 'BCRYPT');

INSERT IGNORE INTO `SSchap6`.`user` (`id`, `username`, `password`, `algorithm`) VALUES ('2', 'john', '$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG', 'BCRYPT');

INSERT IGNORE INTO `SSchap6`.`authority` (`id`, `name`, `user`) VALUES ('1', 'READ', '1');
INSERT IGNORE INTO `SSchap6`.`authority` (`id`, `name`, `user`) VALUES ('2', 'WRITE', '1');
INSERT IGNORE INTO `SSchap6`.`authority` (`id`, `name`, `user`) VALUES ('1', 'READ', '2');
INSERT IGNORE INTO `SSchap6`.`authority` (`id`, `name`, `user`) VALUES ('2', 'WRITE', '2');

INSERT IGNORE INTO `SSchap6`.`product` (`id`, `name`, `price`, `currency`) VALUES ('1', 'Chocolate', '10', 'USD');