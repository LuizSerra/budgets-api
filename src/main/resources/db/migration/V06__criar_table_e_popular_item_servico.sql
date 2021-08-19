CREATE TABLE `budget_bd`.`item_servico` (
  `id_orcamento` bigint NOT NULL,
  `id_servico` bigint NOT NULL,
  `quantidade` double NOT NULL,
 PRIMARY KEY (id_orcamento, id_servico),
 FOREIGN KEY (id_orcamento) REFERENCES `budget_bd`.`orcamento`(id),
 FOREIGN KEY (id_servico) REFERENCES `budget_bd`.`servico`(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `budget_bd`.`item_servico` (id_orcamento, id_servico, quantidade) VALUES (1, 1, 5);
INSERT INTO `budget_bd`.`item_servico` (id_orcamento, id_servico, quantidade) VALUES (1, 2, 2);
INSERT INTO `budget_bd`.`item_servico` (id_orcamento, id_servico, quantidade) VALUES (2, 1, 3);
INSERT INTO `budget_bd`.`item_servico` (id_orcamento, id_servico, quantidade) VALUES (2, 2, 4);
