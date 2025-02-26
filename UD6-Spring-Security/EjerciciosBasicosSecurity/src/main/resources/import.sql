INSERT INTO user_entity (creaccion_usuario, password, username) VALUE (date(now()), '$2a$12$BXQcbIfFexg0APDNW5T6x.bqmIKeqcZ22tEzPGGSR4mJhldbTuhXi', 'predolars');

insert into user_entity_roles (user_entity_id, roles) value (1, 'ADMIN');