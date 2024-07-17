-- Perfil
INSERT INTO Perfil (nombre)
VALUES ('Administrador');
INSERT INTO Perfil (nombre)
VALUES ('Profesor');
INSERT INTO Perfil (nombre)
VALUES ('Estudiante');

-- Usuario
INSERT INTO Usuario (nombre, correoElectronico, contrasena, idPerfil)
VALUES ('Juan Pérez', 'juan.perez@example.com', 'password123', 1);
INSERT INTO Usuario (nombre, correoElectronico, contrasena, idPerfil)
VALUES ('Ana Gómez', 'ana.gomez@example.com', 'password456', 2);
INSERT INTO Usuario (nombre, correoElectronico, contrasena, idPerfil)
VALUES ('Carlos López', 'carlos.lopez@example.com', 'password789', 3);

-- Curso
INSERT INTO Curso (nombre, categoria)
VALUES ('Matemáticas', 'Ciencias');
INSERT INTO Curso (nombre, categoria)
VALUES ('Historia', 'Humanidades');
INSERT INTO Curso (nombre, categoria)
VALUES ('Programación', 'Tecnología');
