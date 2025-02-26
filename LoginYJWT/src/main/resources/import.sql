INSERT INTO user_entity (username, password, created_at) VALUES ('user', '$2a$12$.ZxxuJzxx.BUS7Bm7mDzTO.1aAMSUuJT/YeXIS2VpcRQzXR3u7b6m', '2023-01-01 00:00:00');
INSERT INTO user_entity (username, password, created_at) VALUES ('admin','$2a$12$.ZxxuJzxx.BUS7Bm7mDzTO.1aAMSUuJT/YeXIS2VpcRQzXR3u7b6m', '2023-01-01 00:00:00');

INSERT INTO user_entity_roles (user_entity_id, roles) VALUES (1, 'USER');
INSERT INTO user_entity_roles (user_entity_id, roles) VALUES (2, 'ADMIN');