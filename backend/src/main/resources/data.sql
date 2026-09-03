-- USUARIOS
INSERT INTO users (name, nick, email, password_hashed, create_at, update_at)
VALUES ('Antonio', 'tony', 'tony@blog.es', '123', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO users (name, nick, email, password_hashed, create_at, update_at)
VALUES ('María', 'mary', 'mary@blog.es', '123', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO users (name, nick, email, password_hashed, create_at, update_at)
VALUES ('Carlos', 'carl', 'carl@blog.es', '123', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO users (name, nick, email, password_hashed, create_at, update_at)
VALUES ('Laura', 'lau', 'lau@blog.es', '123', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO users (name, nick, email, password_hashed, create_at, update_at)
VALUES ('Pedro', 'pete', 'pete@blog.es', '123', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- POSTS ANTONIO (user_id = 1)
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('Buenos días a todos!', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('Hoy hace un día genial', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('Acabo de ver una peli increíble', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('Alguien recomienda un buen libro?', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('El café de la mañana es sagrado', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- POSTS MARÍA (user_id = 2)
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('Hoy empiezo dieta... otra vez', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('El gym a las 7am no es para todos', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('Receta de pasta boloñesa exitosa!', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('Fin de semana de senderismo', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('No soporto los lunes', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- POSTS CARLOS (user_id = 3)
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('Nuevo proyecto en Spring Boot en marcha', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('Java 21 tiene cosas muy interesantes', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('Alguien usa Docker en local?', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('Los tests unitarios son aburridos pero necesarios', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('Commit a las 2am, todo funciona', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- POSTS LAURA (user_id = 4)
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('Viaje a Lisboa el próximo mes!', 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('El arte callejero de esta ciudad es increíble', 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('Fotos nuevas en mi perfil', 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('Atardecer desde la terraza', 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('Mercadillo de antigüedades hoy', 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- POSTS PEDRO (user_id = 5)
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('Real Madrid campeon!!', 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('La final de anoche fue increíble', 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('Paella del domingo lista', 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('Quien sale esta noche?', 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO posts (body, user_id, create_at, update_at) VALUES ('Lunes de vuelta al trabajo :(', 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


-- FOLLOWS (seguidor_id, seguido_id)
INSERT INTO follows (seguidor_id, seguido_id) VALUES (1, 2); -- tony sigue a mary
INSERT INTO follows (seguidor_id, seguido_id) VALUES (1, 3); -- tony sigue a carl
INSERT INTO follows (seguidor_id, seguido_id) VALUES (2, 1); -- mary sigue a tony
INSERT INTO follows (seguidor_id, seguido_id) VALUES (3, 1); -- carl sigue a tony
INSERT INTO follows (seguidor_id, seguido_id) VALUES (4, 1); -- lau sigue a tony
INSERT INTO follows (seguidor_id, seguido_id) VALUES (5, 3); -- pete sigue a carl