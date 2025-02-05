insert into user_entity (username, password, creaccion_usuario) values ('user', '$2a$12$OOZ94zxf./GQocD9oZ/3ZOuRF9ahCZrWMsLOKIQSWQ4c6zwGdw7TO', '2024-01-26 00:00:00')
insert into user_entity (username, password, creaccion_usuario) values ('admin', '$2a$12$OOZ94zxf./GQocD9oZ/3ZOuRF9ahCZrWMsLOKIQSWQ4c6zwGdw7TO', '2024-01-26 00:00:00')

insert into user_entity_roles (user_entity_id, roles) values (1, 'USER');
insert into user_entity_roles (user_entity_id, roles) values (2, 'ADMIN');

-- Lo roles deben ser ROLE_XXXX para spring
