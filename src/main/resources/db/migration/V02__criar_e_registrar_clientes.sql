CREATE TABLE cliente (
 id BIGINT (20) PRIMARY KEY AUTO_INCREMENT,
 nome VARCHAR(100) NOT NULL,
 cpf VARCHAR (15)NOT NULL,
 telefone VARCHAR (15) NOT NULL,
 email VARCHAR (50) NOT NULL
 ) ENGINE=InnoDB CHARSET=utf8;

INSERT INTO cliente (nome, cpf, telefone, email) VALUES ('Luiz Serra', '08456825623', '71-985632147', 'email@budget.com');
