CREATE DATABASE IF NOT EXISTS BIBLIOTECA;
CREATE TABLE IF NOT EXISTS GENEROS (
   genero_id INT(5) unsigned NOT NULL auto_increment PRIMARY KEY,
   nombre VARCHAR(20) NOT NULL
);
CREATE TABLE IF NOT EXISTS LIBROSDIG (
   id_lib INT(5) UNSIGNED NOT NULL auto_increment PRIMARY KEY,
   titulo VARCHAR(50) NOT NULL,
   autor VARCHAR(30) NOT NULL,
   editorial VARCHAR(30) NOT NULL,
   anio_edicion int(4) NOT NULL,
   genero_id INT (5) unsigned NOT NULL,
   FOREIGN KEY (genero_id) REFERENCES GENEROS(genero_id) on delete RESTRICT on update CASCADE
);