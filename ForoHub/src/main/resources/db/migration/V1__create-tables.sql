CREATE TABLE Perfil (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE Usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    correoElectronico VARCHAR(255) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    idPerfil BIGINT,
    FOREIGN KEY (idPerfil) REFERENCES Perfil(id)
);

CREATE TABLE Curso (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL
);

CREATE TABLE Topico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fechaCreacion TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    idAutor BIGINT,
    idCurso BIGINT,
    FOREIGN KEY (idAutor) REFERENCES Usuario(id),
    FOREIGN KEY (idCurso) REFERENCES Curso(id)
);

CREATE TABLE Respuesta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    idTopico BIGINT,
    fechaCreacion TIMESTAMP NOT NULL,
    idAutor BIGINT,
    solucion BOOLEAN NOT NULL,
    FOREIGN KEY (idTopico) REFERENCES Topico(id),
    FOREIGN KEY (idAutor) REFERENCES Usuario(id)
);
