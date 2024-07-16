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