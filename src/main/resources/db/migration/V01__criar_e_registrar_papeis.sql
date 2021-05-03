CREATE TABLE IF NOT EXISTS papel (
	id BIGINT(20) PRIMARY KEY,
    	descricao VARCHAR(200) NOT NULL
);

-- papel
INSERT INTO papel (id, descricao) VALUES (1, 'ADM');
INSERT INTO papel (id, descricao) VALUES (2, 'CLIENTE');
INSERT INTO papel (id, descricao) VALUES (3, 'GERENTE');
