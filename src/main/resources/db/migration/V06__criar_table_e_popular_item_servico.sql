CREATE TABLE IF NOT EXISTS usuario_papel (
    id_usuario BIGINT(20) NOT NULL,
    id_permissao BIGINT(20) NOT NULL,
    PRIMARY KEY (id_usuario, id_papel),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_papel) REFERENCES papel(id)
    ON DELETE CASCADE
	 ON UPDATE CASCADE
)ENGINE=InnoDB CHARSET=utf8;


-- admin
INSERT INTO usuario_papel (id_usuario, id_permissao) VALUES (1, 1);
INSERT INTO usuario_papel (id_usuario, id_permissao) VALUES (4, 1);
INSERT INTO usuario_papel (id_usuario, id_permissao) VALUES (5, 1);

--triador
INSERT INTO usuario_papel (id_usuario, id_permissao) VALUES (2, 2);
INSERT INTO usuario_papel (id_usuario, id_permissao) VALUES (6, 2);
INSERT INTO usuario_papel (id_usuario, id_permissao) VALUES (7, 2);

--finalizador
INSERT INTO usuario_papel (id_usuario, id_permissao) VALUES (3, 3);
INSERT INTO usuario_papel (id_usuario, id_permissao) VALUES (8, 3);
INSERT INTO usuario_papel (id_usuario, id_permissao) VALUES (9, 3);
INSERT INTO usuario_papel (id_usuario, id_permissao) VALUES (10, 3);
INSERT INTO usuario_papel (id_usuario, id_permissao) VALUES (11, 3);
INSERT INTO usuario_papel (id_usuario, id_permissao) VALUES (12, 3);
