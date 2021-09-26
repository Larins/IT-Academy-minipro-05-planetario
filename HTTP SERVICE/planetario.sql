SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

DROP DATABASE IF EXISTS planetario;
CREATE DATABASE planetario CHARACTER SET utf8mb4;
USE planetario;

CREATE TABLE planetas (
  id int(11) NOT NULL,
  nombre varchar(50) NOT NULL,
  masa numeric(65,1) NOT NULL,
  radio numeric(65,2) NOT NULL,
  orbitradio numeric(65,2) NOT NULL,
  gravedad numeric(65,2) NOT NULL,
  rotacion numeric(65,10) NOT NULL,
  orbita numeric(65,10) NOT NULL,
  creacion TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO planetas (id, nombre, masa, radio, orbitradio, gravedad, rotacion, orbita) VALUES

(1, 'MERCURIO', 2439.7, 0.06, 0.39, 3.7, 58.646225, 0.2408467),
(2, 'VENUS', 0.82, 6051.8, 0.72, 8.9, -243.0187, 0.61519726),
(3, 'LA TIERRA', 6371, 1.00, 1.00, 9.81, 0.99726968, 1.0000174),
(4, 'MARTE', 3389.5, 0.11, 1.52, 3.71, 1.02595675, 1.8808476),
(5, 'JUPITER', 69911, 318.00, 5.20, 24.79, 0.41354, 11.862615),
(6, 'SATURNO', 58232, 95.00, 9.54, 9.1, 0.44401, 29.447498),
(7, 'URANO', 25362, 14.06, 19.19, 7.8, -0.71833, 84.016846),
(8, 'NEPTUNO', 24622, 17.02, 30.06, 11.00, 0.67125, 164.79132);

CREATE TABLE usuarios (
  id int(11) NOT NULL,
  usuario varchar(30) NOT NULL,
  password varchar(30) NOT NULL,
  creacion TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE KEY (usuario)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO usuarios (id, usuario, password) VALUES
(1, 'admin', '456'),
(2, 'lara', 'lara');

ALTER TABLE planetas
  MODIFY id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

ALTER TABLE usuarios
  MODIFY id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;


/*UPDATE PLANETARIO PARA PROBAR EL CRUD WEB*/
/*

NOMBRE: PLUTON TB ES UN PLANETA!!
MASA: 0.2
RADIO: 1.185
RADIO ORBITAL: 153.0
GRAVEDAD: 0.6
ROTACION: 0.0
ORBITA: 366.7

*/