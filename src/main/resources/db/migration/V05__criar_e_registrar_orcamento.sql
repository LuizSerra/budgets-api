CREATE TABLE `budget_bd`.`orcamento` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ativo` bit(1) NOT NULL,
  `data_abertura` date NOT NULL,
  `data_fechamento` date DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `observacao` varchar(255) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `valor_final` decimal(19,2) DEFAULT NULL,
  `id_usuario` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfqds0qdii5bascik7pajbxwxd` (`id_usuario`),
  CONSTRAINT `FKfqds0qdii5bascik7pajbxwxd` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `budget_bd`.`orcamento` (`data_abertura`,`data_fechamento`, `nome`, `observacao`, `status`, `valor_final`, `id_usuario`, ativo)
VALUES ('2021-01-10', '2021-01-12','Projeto CASA SOL','Projeto particular','REJEITADO','4500', 4, true);


INSERT INTO `budget_bd`.`orcamento` (`data_abertura`,`data_fechamento`, `nome`, `observacao`, `status`, `valor_final`, `id_usuario`, ativo)
VALUES ('2021-01-10', NULL,'Jardim Suspenso', NULL,'SUSPENSO','15000', 5, true);


INSERT INTO `budget_bd`.`orcamento` (`data_abertura`,`data_fechamento`, `nome`, `observacao`, `status`, `valor_final`, `id_usuario`, ativo)
VALUES ('2021-01-10', '2021-01-20','Aqua club','Piscina publica','APROVADO','40500', 7, true);
