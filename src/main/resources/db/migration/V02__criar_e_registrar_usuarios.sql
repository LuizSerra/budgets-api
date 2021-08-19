CREATE TABLE `budget_bd`.`usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ativo` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




INSERT INTO `budget_bd`.`usuario` (nome, email, senha, ativo) VALUES ('ADMINISTRADOR', 'admin@softplan.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO `budget_bd`.`usuario` (nome, email, senha, ativo) VALUES ('GERENTE', 'gerente@softplan.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO `budget_bd`.`usuario` (nome, email, senha, ativo) VALUES ('CLIENTE', 'cliente@softplan.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO `budget_bd`.`usuario` (nome, email, senha, ativo) VALUES ('Tony Stark', 'tony.stark@shield.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO `budget_bd`.`usuario` (nome, email, senha, ativo) VALUES ('Steve Rogers', 'cap@shield.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO `budget_bd`.`usuario` (nome, email, senha, ativo) VALUES ('Peter Parker', 'peter@shield.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO `budget_bd`.`usuario` (nome, email, senha, ativo) VALUES ('Nathasha Romanov', 'nath@shield.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO `budget_bd`.`usuario` (nome, email, senha, ativo) VALUES ('Bruce Banner', 'bruce@shield.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO `budget_bd`.`usuario` (nome, email, senha, ativo) VALUES ('Bucky Barnes', 'bucky@shield.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO `budget_bd`.`usuario` (nome, email, senha, ativo) VALUES ('Sam Wilson', 'sam@shield.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO `budget_bd`.`usuario` (nome, email, senha, ativo) VALUES ('Thor', 'thor.odinson@shield.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO `budget_bd`.`usuario` (nome, email, senha, ativo) VALUES ('Wanda Maximoff', 'wanda@shield.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
