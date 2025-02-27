insert into user_entity (username, password, creaccion_usuario) values ('user','$2a$12$vEkBSo01mgr65WzuZ4.6e.P9MNhFx5DS0T7QZEFoAv5lrA.sXA7Vy', '2024-01-26 00:00:00');
insert into user_entity (username, password, creaccion_usuario) values ('admin','$2a$12$vEkBSo01mgr65WzuZ4.6e.P9MNhFx5DS0T7QZEFoAv5lrA.sXA7Vy', '2024-01-26 00:00:00');

insert into user_entity_roles (user_entity_id, roles) values (1, 'USER');
insert into user_entity_roles (user_entity_id, roles) values (2, 'ADMIN');