CREATE TABLE IF NOT EXISTS usuario_papel (
    id_usuario BIGINT(20) NOT NULL,
    id_papel BIGINT(20) NOT NULL,
    PRIMARY KEY (id_usuario, id_papel),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_papel) REFERENCES papel(id)
    ON DELETE CASCADE
	 ON UPDATE CASCADE
)ENGINE=InnoDB CHARSET=utf8;


-- admin
INSERT INTO usuario_papel (id_usuario, id_papel) VALUES (1, 1);
INSERT INTO usuario_papel (id_usuario, id_papel) VALUES (4, 1);
INSERT INTO usuario_papel (id_usuario, id_papel) VALUES (5, 1);

-- gerente
INSERT INTO usuario_papel (id_usuario, id_papel) VALUES (2, 2);
INSERT INTO usuario_papel (id_usuario, id_papel) VALUES (6, 2);
INSERT INTO usuario_papel (id_usuario, id_papel) VALUES (7, 2);

-- cliente
INSERT INTO usuario_papel (id_usuario, id_papel) VALUES (3, 3);
INSERT INTO usuario_papel (id_usuario, id_papel) VALUES (8, 3);
INSERT INTO usuario_papel (id_usuario, id_papel) VALUES (9, 3);
INSERT INTO usuario_papel (id_usuario, id_papel) VALUES (10, 3);
INSERT INTO usuario_papel (id_usuario, id_papel) VALUES (11, 3);
INSERT INTO usuario_papel (id_usuario, id_papel) VALUES (12, 3);
