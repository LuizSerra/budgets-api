CREATE TABLE `budget_bd`.`usuario_papel` (
  `id_usuario` bigint NOT NULL,
  `id_papel` bigint NOT NULL,
  KEY `FK11mr9ml09y7vdnuucm5x0jw` (`id_papel`),
  KEY `FKq26gl900j38e97cp7rbhw1nqc` (`id_usuario`),
  CONSTRAINT `FK11mr9ml09y7vdnuucm5x0jw` FOREIGN KEY (`id_papel`) REFERENCES `papel` (`id`),
  CONSTRAINT `FKq26gl900j38e97cp7rbhw1nqc` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- admin
INSERT INTO `budget_bd`.`usuario_papel` (id_usuario, id_papel) VALUES (1, 1);
INSERT INTO `budget_bd`.`usuario_papel` (id_usuario, id_papel) VALUES (4, 1);
INSERT INTO `budget_bd`.`usuario_papel` (id_usuario, id_papel) VALUES (5, 1);

-- gerente
INSERT INTO `budget_bd`.`usuario_papel` (id_usuario, id_papel) VALUES (2, 2);
INSERT INTO `budget_bd`.`usuario_papel` (id_usuario, id_papel) VALUES (6, 2);
INSERT INTO `budget_bd`.`usuario_papel` (id_usuario, id_papel) VALUES (7, 2);

-- cliente
INSERT INTO `budget_bd`.`usuario_papel` (id_usuario, id_papel) VALUES (3, 3);
INSERT INTO `budget_bd`.`usuario_papel` (id_usuario, id_papel) VALUES (8, 3);
INSERT INTO `budget_bd`.`usuario_papel` (id_usuario, id_papel) VALUES (9, 3);
INSERT INTO `budget_bd`.`usuario_papel` (id_usuario, id_papel) VALUES (10, 3);
INSERT INTO `budget_bd`.`usuario_papel` (id_usuario, id_papel) VALUES (11, 3);
INSERT INTO `budget_bd`.`usuario_papel` (id_usuario, id_papel) VALUES (12, 3);
