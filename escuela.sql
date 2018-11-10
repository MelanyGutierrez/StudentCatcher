-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 10-11-2018 a las 02:59:47
-- Versión del servidor: 5.7.23
-- Versión de PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `escuela`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
CREATE TABLE IF NOT EXISTS `alumnos` (
  `idAlumnos` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `telefono` int(15) DEFAULT NULL,
  `direccion` varchar(20) DEFAULT NULL,
  `correo` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idAlumnos`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`idAlumnos`, `nombre`, `apellido`, `telefono`, `direccion`, `correo`) VALUES
(1, 'Mélany', 'Gutiérrez', 34291209, 'Zona 8', 'mel@hot.com'),
(2, 'Luis', 'Silvetre', 43892123, 'Zona 8', 'lui@hotmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignarcurso`
--

DROP TABLE IF EXISTS `asignarcurso`;
CREATE TABLE IF NOT EXISTS `asignarcurso` (
  `idAsignar` int(11) NOT NULL AUTO_INCREMENT,
  `idAlumno` int(11) DEFAULT NULL,
  `idCatedratico` int(11) DEFAULT NULL,
  `idCurso` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`idAsignar`),
  KEY `idAlumno` (`idAlumno`),
  KEY `idCatedratico` (`idCatedratico`),
  KEY `idCurso` (`idCurso`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `asignarcurso`
--

INSERT INTO `asignarcurso` (`idAsignar`, `idAlumno`, `idCatedratico`, `idCurso`, `fecha`) VALUES
(1, 1, 1, 1, '2018-11-09'),
(2, 2, 2, 2, '2018-11-09'),
(3, 2, 2, 3, '2018-11-09');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `catedratico`
--

DROP TABLE IF EXISTS `catedratico`;
CREATE TABLE IF NOT EXISTS `catedratico` (
  `idCatedratico` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `direccion` varchar(20) DEFAULT NULL,
  `correo` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idCatedratico`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `catedratico`
--

INSERT INTO `catedratico` (`idCatedratico`, `nombre`, `apellido`, `telefono`, `direccion`, `correo`) VALUES
(1, 'Pedro', 'Sosa', '563891212', 'zona 1', 'pe@hotmail.com'),
(2, 'Marta', 'Solís', '83429381', 'zona 1', 'sol@yahoo.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

DROP TABLE IF EXISTS `cursos`;
CREATE TABLE IF NOT EXISTS `cursos` (
  `idCursos` int(11) NOT NULL AUTO_INCREMENT,
  `CarreraCur` varchar(30) DEFAULT NULL,
  `NombreCur` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idCursos`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`idCursos`, `CarreraCur`, `NombreCur`) VALUES
(1, 'Administración', 'Finanzas'),
(2, 'Derecho', 'Historia jurídica'),
(3, 'Medicina', 'Biología');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(30) DEFAULT NULL,
  `pass` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `user`, `pass`) VALUES
(1, 'mel', '111'),
(2, 'betzy', '222'),
(3, 'luis', '333');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
