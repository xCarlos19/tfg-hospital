INSERT INTO usuario(id_usuario, nombre_usuario, password) VALUES 
(1, "JuPe", "$2a$10$wyonF2LXALgjbRjvLAG82urkRfWbAUJZVyk8gTfGz.ZCSD0Gvr0ym"),
(2, "RaqMar", "$2a$10$wyonF2LXALgjbRjvLAG82urkRfWbAUJZVyk8gTfGz.ZCSD0Gvr0ym");

INSERT INTO sanitario(id_sanitario, edad, nombre) VALUES
(1, 40, "Juan Perez" ),
(2, 45, "Raquel Martinez");

INSERT INTO paciente(id_paciente, nombre, edad) VALUES
(1, "Paciente 1",18),
(2, "Paciente 2",18),
(3, "Paciente 3",18);

INSERT INTO medicamento(id_medicamento, nombre, descripcion, fabricante) VALUES
(1, "Ibuprofeno 600mg", "Para inflamación", "Laboratorios Cinfa");

INSERT INTO receta(id_receta,descripcion, id_paciente, id_sanitario, fecha_creacion) VALUES
(1, "Mal estar general" , 1 , 2, "2022-05-08 19:56:00");

INSERT INTO receta_medicamentos(id_receta, id_medicamento) VALUES
(1,1);

INSERT INTO rol(id_rol, descripcion, nombre_rol) VALUES
(1, "Crear recetas", "MEDICINA"),
(2, "Manipular medicamentos", "ENFERMERIA");

INSERT INTO usuario_rol(id_usuario, id_rol) VALUES
(1,1),
(2,2);

INSERT INTO usuario_sanitario(id_usuario, id_sanitario) VALUES
(1,1),
(2,2);