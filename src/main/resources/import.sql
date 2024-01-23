INSERT INTO alumnos (modalidad_id,nombre, apellido, email, sexo, dni,telefono) VALUES(1,'walter', 'matos', 'waltermatos@gmail.com', 'Masculino', '76177519','994237455');
INSERT INTO alumnos (modalidad_id,nombre, apellido, email, sexo, dni,telefono) VALUES(2,'kevin', 'matos', 'kevin@gmail.com', 'Masculino', '76177520','994222745');
INSERT INTO alumnos (modalidad_id,nombre, apellido, email, sexo, dni,telefono) VALUES(1,'juan', 'matos', 'juan@gmail.com', 'Masculino', '76177525','994237422');
INSERT INTO alumnos (modalidad_id,nombre, apellido, email, sexo, dni,telefono) VALUES(2,'carlos', 'vera', 'carlos@gmail.com', 'Masculino', '76177525','994237492');

INSERT INTO modalidad(id,descripcion) values(1,'virtual');
INSERT INTO modalidad(id,descripcion) values(2,'presencial');
INSERT INTO modalidad(id,descripcion) values(3,'semi presencial');


/*Creamos algunos usuarios con sus roles*/

INSERT INTO usuarios (username, password,enabled) VALUES('walter','$2a$10$553eSHKpSvi0F.7kbR/xh.MGjytGxS8gRO5DqcCM8uN4W.BthrB6a',1);
INSERT INTO usuarios (username, password,enabled) VALUES('admin','$2a$10$Vn0zJnmO/iYXZM3XZ61LlO9LcyD4/LTQKOQDFZY8ns2/GkJ5wcP8u',1);

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (user_id,role_id) VALUES (1,1);
INSERT INTO usuarios_roles (user_id,role_id) VALUES (2,2);
INSERT INTO usuarios_roles (user_id,role_id) VALUES (2,1);