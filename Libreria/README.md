# Consultor de libros con Gutendex!

Bienvenido, en este challenge del curso de Oracle ONE se realizo un programa en **Java** se practica la permanencia de
datos usando una base de Datos PostgreSQL, el contexto del programa es poder realizar busquedas sobre libros y poder
guardar
la información.

Los datos son obtenidos gracias a la API de Gutendex, el cual nos proporciona todos los datos necesarios para almacenar.
Con base a como regresa la informacion la API se estructuraron las clases en **Libros y Autores**.

## Caracteristicas:

- Busqueda de libros en la API y guardado en la DB.
- Enseñar los datos guardados en la DB (Tanto **libros** como **autores**)
- Filtrar libros por idioma, vivencia del autor.

## Funcionamiento:

Se uso la estructuracion de MVC siendo que la organizacion del proyecto esta repatida en **modelos, servicios y
repositorios**
buscando una estructura fuerte y comprensible para los demas. La utilización de la API unicamente se usa en la primera
caracteristica
previamente mencionada, las demás operaciones se manejan a nivel de base de datos.

La relación entre entidades se aplico de la siguiente forma:

- Varios libros pueden tener un autor, siendo una relacion de ```ManyToOne```.
- Se utilizo de esta forma para simplificar la relación, debido a que en la realidad un autor puede tener muchos libros
  asi como viceversa teniendo una relación de
  ``ManyToMany``.

## Clases implementadas:

- `Autor`: *Clase* representativa del autor de un libro.
- `DTOAutor`: *Record* encargada de transformar la información recibida a una clase `Autor`.
- `Libro`: *Clase* representativa de un libro, apartir de la información recibida del API.
- `DTOLibro`: *Record* encargada de transformar la información recibida a una clase `Libro`.
- `Idioma`: *Enumerable* lista con los posibles idiomas de un libro.

## Demo:
### Menu:
![imagen](https://github.com/user-attachments/assets/d528dc6d-c605-4a3d-82aa-10e9f2c09b2a)
![imagen](https://github.com/user-attachments/assets/da559245-1dd1-4533-a444-dc796f4b6588)

### Listados:
![imagen](https://github.com/user-attachments/assets/7240970d-80b2-4b8e-befc-c9f11ebada94)
![imagen](https://github.com/user-attachments/assets/e61a833e-c137-4108-8f9e-091d57e99911)

### Filtro:
![imagen](https://github.com/user-attachments/assets/2717216d-9500-4bc5-8c05-c284a641f9a6)
![imagen](https://github.com/user-attachments/assets/623893f5-6f7c-4566-9e68-f7df2957c45a)

