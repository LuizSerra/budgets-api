CREATE TABLE IF NOT EXISTS usuario (
    id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(150) NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT TRUE
 )ENGINE=InnoDB CHARSET=utf8;



INSERT INTO usuario (nome, email, senha, ativo) VALUES ('ADMINISTRADOR', 'admin@softplan.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO usuario (nome, email, senha, ativo) VALUES ('GERENTE', 'gerente@softplan.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO usuario (nome, email, senha, ativo) VALUES ('CLIENTE', 'cliente@softplan.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO usuario (nome, email, senha, ativo) VALUES ('Tony Stark', 'tony.stark@shield.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO usuario (nome, email, senha, ativo) VALUES ('Steve Rogers', 'cap@shield.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO usuario (nome, email, senha, ativo) VALUES ('Peter Parker', 'peter@shield.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO usuario (nome, email, senha, ativo) VALUES ('Nathasha Romanov', 'nath@shield.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO usuario (nome, email, senha, ativo) VALUES ('Bruce Banner', 'bruce@shield.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO usuario (nome, email, senha, ativo) VALUES ('Bucky Barnes', 'bucky@shield.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO usuario (nome, email, senha, ativo) VALUES ('Sam Wilson', 'sam@shield.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO usuario (nome, email, senha, ativo) VALUES ('Thor', 'thor.odinson@shield.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
INSERT INTO usuario (nome, email, senha, ativo) VALUES ('Wanda Maximoff', 'wanda@shield.com', '$2a$10$CBHOY7qH9eMAKQuxPycIu.9psD27tnyPKzJUgsEg3hkwC/As0OJSi', true );
