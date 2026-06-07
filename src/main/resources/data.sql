INSERT INTO users (name, nick, email, password_hashed, create_at, update_at)
VALUES ('Antonio', 'tony', 'tony@blog.es', '123', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


INSERT INTO posts (body,user_id, create_at, update_at)
VALUES ('cuerpo', 1 , CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);