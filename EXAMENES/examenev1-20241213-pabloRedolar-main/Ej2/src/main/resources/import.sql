INSERT INTO representante (nombre, email) VALUES ('Juan Pérez', 'juan.perez@example.com');
INSERT INTO representante (nombre, email) VALUES ('María Gómez', 'maria.gomez@example.com');
INSERT INTO representante (nombre, email) VALUES ('Carlos López', 'carlos.lopez@example.com');

INSERT INTO raqueta (marca, precio, representante_id) VALUES ('Wilson', 199.99, 1);
INSERT INTO raqueta (marca, precio, representante_id) VALUES ('Babolat', 249.99, 2);
INSERT INTO raqueta (marca, precio, representante_id) VALUES ('Head', 219.99, 3);

INSERT INTO tenista (nombre, ranking, fecha_nacimiento, anno_profesional, altura, peso, mano_dominante, tipo_reves, puntos, pais, raquetaid) VALUES ('Roger Federer', 1, '1981-08-08', 1998, 1.85, 85.0, 'DIESTRO', 'UNA_MANO', 9870, 'Suiza', 1);
INSERT INTO tenista (nombre, ranking, fecha_nacimiento, anno_profesional, altura, peso, mano_dominante, tipo_reves, puntos, pais, raquetaid) VALUES ('Rafael Nadal', 2, '1986-06-03', 2001, 1.85, 85.0, 'ZURDO', 'DOS_MANOS', 9215, 'España', 2);
INSERT INTO tenista (nombre, ranking, fecha_nacimiento, anno_profesional, altura, peso, mano_dominante, tipo_reves, puntos, pais, raquetaid) VALUES ('Novak Djokovic', 3, '1987-05-22', 2003, 1.88, 80.0, 'DIESTRO', 'DOS_MANOS', 8650, 'Serbia', 3);