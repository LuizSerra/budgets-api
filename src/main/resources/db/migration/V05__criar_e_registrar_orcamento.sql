CREATE TABLE Orcamento (
 id BIGINT (20) PRIMARY KEY AUTO_INCREMENT,
 nome VARCHAR(50) NOT NULL,
 cliente VARCHAR (50),
 unidade VARCHAR (10) NOT NULL,
 valor_unitario double (10,2) NOT NULL
 ) ENGINE=InnoDB CHARSET=utf8;

INSERT INTO servico (nome, descricao, unidade, valor_unitario) VALUES ('Arquitetura de interiores', 'Projeto de reestruturação e decoração interna', 'H', 100);
INSERT INTO servico (nome, descricao, unidade, valor_unitario) VALUES ('Projeto de Arquitetura', 'Projeto', 'H', 100);
