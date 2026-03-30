DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE IF NOT EXISTS GENEROS (
   genero_id INT(5) unsigned NOT NULL auto_increment PRIMARY KEY,
   nombre VARCHAR(20) NOT NULL
);
CREATE TABLE IF NOT EXISTS LIBROSDIG (
   id_lib INT(5) UNSIGNED NOT NULL auto_increment PRIMARY KEY,
   titulo VARCHAR(50) NOT NULL,
   autor VARCHAR(30) NOT NULL,
   editorial VARCHAR(30) NOT NULL,
   año_edicion int(4) NOT NULL,
   genero_id INT (5) unsigned NOT NULL,
   FOREIGN KEY (genero_id) REFERENCES GENEROS(genero_id) on delete RESTRICT on update CASCADE
);

INSERT INTO generos (genero_id, nombre) VALUES (NULL, 'Ciencia Ficción');
INSERT INTO generos (genero_id, nombre) VALUES (NULL, 'Fantasía');
INSERT INTO generos (genero_id, nombre) VALUES (NULL, 'Novela');
INSERT INTO generos (genero_id, nombre) VALUES (NULL, 'Misterio');
INSERT INTO generos (genero_id, nombre) VALUES (NULL, 'Terror');
INSERT INTO generos (genero_id, nombre) VALUES (NULL, 'Historia');
INSERT INTO generos (genero_id, nombre) VALUES (NULL, 'Romance');
INSERT INTO generos (genero_id, nombre) VALUES (NULL, 'Aventura');
INSERT INTO generos (genero_id, nombre) VALUES (NULL, 'Ensayo');
INSERT INTO generos (genero_id, nombre) VALUES (NULL, 'Policial');

INSERT INTO librosdig (id_lib, titulo, autor, editorial, año_edicion, genero_id) VALUES
(NULL, 'Dune', 'Frank Herbert', 'Chilton Books', 1965, 1),
(NULL, 'Fundación', 'Isaac Asimov', 'Gnome Press', 1951, 1),
(NULL, 'El Señor de los Anillos', 'J.R.R. Tolkien', 'Allen & Unwin', 1954, 2),
(NULL, 'Harry Potter y la piedra filosofal', 'J.K. Rowling', 'Bloomsbury', 1997, 2),
(NULL, 'Cien años de soledad', 'Gabriel García Márquez', 'Sudamericana', 1967, 3),
(NULL, 'El código Da Vinci', 'Dan Brown', 'Doubleday', 2003, 4),
(NULL, 'Drácula', 'Bram Stoker', 'Archibald Constable', 1897, 5),
(NULL, 'It', 'Stephen King', 'Viking Press', 1986, 5),
(NULL, 'Sapiens', 'Yuval Noah Harari', 'Harvill Secker', 2011, 9),
(NULL, 'Orgullo y prejuicio', 'Jane Austen', 'T. Egerton', 1813, 7),
(NULL, 'Sherlock Holmes: Estudio en escarlata', 'Arthur Conan Doyle', 'Ward Lock', 1887, 10),
(NULL, 'Los juegos del hambre', 'Suzanne Collins', 'Scholastic', 2008, 8),
(NULL, '1984', 'George Orwell', 'Secker & Warburg', 1949, 1),
(NULL, 'El Hobbit', 'J.R.R. Tolkien', 'Allen & Unwin', 1937, 2),
(NULL, 'La sombra del viento', 'Carlos Ruiz Zafón', 'Planeta', 2001, 4);
