-- Insertar clientes
INSERT INTO cliente (nombre, email, telefono) VALUES ('Juan Pérez', 'juan.perez@example.com', '123456789');
INSERT INTO cliente (nombre, email, telefono) VALUES ('María López', 'maria.lopez@example.com', '987654321');
INSERT INTO cliente (nombre, email, telefono) VALUES ('Carlos García', 'carlos.garcia@example.com', NULL);

-- Insertar platos
INSERT INTO plato (nombre, precio) VALUES ('Pizza Margarita', 8.50);
INSERT INTO plato (nombre, precio) VALUES ('Ensalada César', 6.75);
INSERT INTO plato (nombre, precio) VALUES ('Hamburguesa Clásica', 9.99);
INSERT INTO plato (nombre, precio) VALUES ('Espaguetis Carbonara', 7.99);
INSERT INTO plato (nombre, precio) VALUES ('Tarta de Queso', 4.50);

-- Insertar pedidos
INSERT INTO pedido (fecha, cliente_id) VALUES ('2024-12-10 12:30:00', 1);
INSERT INTO pedido (fecha, cliente_id) VALUES ('2024-12-11 14:00:00', 2);
INSERT INTO pedido (fecha, cliente_id) VALUES ('2024-12-11 19:00:00', 3);

INSERT INTO pedido (fecha, cliente_id) VALUES ('2024-12-12 12:00:00', 1);
INSERT INTO pedido (fecha, cliente_id) VALUES ('2024-12-12 18:00:00', 2);

INSERT INTO pedido (fecha, cliente_id) VALUES ('2024-12-13 20:30:00', 3);
INSERT INTO pedido (fecha, cliente_id) VALUES ('2024-12-13 21:30:00', 3);

-- Insertar platos por pedido (relación muchos a muchos)
INSERT INTO pedido_plato (pedido_id, plato_id) VALUES (1, 1);
INSERT INTO pedido_plato (pedido_id, plato_id) VALUES (1, 2);
INSERT INTO pedido_plato (pedido_id, plato_id) VALUES (2, 2);
INSERT INTO pedido_plato (pedido_id, plato_id) VALUES (3, 4);
INSERT INTO pedido_plato (pedido_id, plato_id) VALUES (3, 5);
INSERT INTO pedido_plato (pedido_id, plato_id) VALUES (4, 3);
INSERT INTO pedido_plato (pedido_id, plato_id) VALUES (5, 4);
INSERT INTO pedido_plato (pedido_id, plato_id) VALUES (6, 1);
INSERT INTO pedido_plato (pedido_id, plato_id) VALUES (6, 5);
