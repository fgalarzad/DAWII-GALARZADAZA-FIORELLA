DROP DATABASE IF EXISTS daw_galarza_fiorella;
CREATE DATABASE daw_galarza_fiorella;

-- USE DATABASE
USE daw_galarza_fiorella;

-- CREATE TABLE users
CREATE TABLE users (
	id INT auto_increment NOT null PRIMARY KEY,
	nombres VARCHAR(100) NULL,
	apellidos VARCHAR(100) NULL,
	dni VARCHAR(8) NULL,
	nacimiento Date NULL
	
)
INSERT INTO users(nombres, apellidos, dni, nacimiento) VALUES('Juan Carlos', 'Ramírez Torres', '48125690', '1988-07-22')
INSERT INTO users(nombres, apellidos, dni, nacimiento) VALUES('Ana Lucia', 'Castillo Vega', '73652014', '2000-11-09')
INSERT INTO users(nombres, apellidos, dni, nacimiento) VALUES('Luis Ricardo', 'Pérez Huamán', '65478219', '1992-01-05')
INSERT INTO users(nombres, apellidos, dni, nacimiento) VALUES('Fiorella', 'Galarza Ramos', '71325487', '1998-09-30')
INSERT INTO users(nombres, apellidos, dni, nacimiento) VALUES('Maicol', 'Mendoza Ríos', '70589632', '1990-05-18')
INSERT INTO users(nombres, apellidos, dni, nacimiento) VALUES('Valeria Luna', 'Cruz Salazar', '72896541', '2002-02-25')
