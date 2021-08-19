CREATE TABLE `budget_bd`.`servico` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ativo` bit(1) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `nome` varchar(50) NOT NULL,
  `unidade` varchar(255) NOT NULL,
  `valor_unitario` decimal(19,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `budget_bd`.`servico` (nome, descricao, unidade, valor_unitario, ativo) VALUES ('Arquitetura de interiores', 'Projeto de reestruturação e decoração interna', 'H', 100, true);
INSERT INTO `budget_bd`.`servico` (nome, descricao, unidade, valor_unitario, ativo) VALUES ('Projeto de Arquitetura', 'Projeto', 'H', 100, true);
