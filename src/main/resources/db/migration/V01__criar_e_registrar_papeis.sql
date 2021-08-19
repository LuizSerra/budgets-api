CREATE TABLE `budget_bd`.`papel` (
  `id` bigint NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- papel
INSERT INTO `budget_bd`.`papel` (id, nome) VALUES (1, 'ADM');
INSERT INTO `budget_bd`.`papel` (id, nome) VALUES (2, 'GERENTE');
INSERT INTO `budget_bd`.`papel` (id, nome) VALUES (3, 'CLIENTE');
