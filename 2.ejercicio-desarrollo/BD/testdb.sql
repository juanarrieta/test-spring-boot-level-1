-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-06-2019 a las 04:18:26
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.2.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `testdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta_corriente`
--

CREATE TABLE `cuenta_corriente` (
  `num_cuenta` int(11) NOT NULL,
  `moneda` varchar(255) DEFAULT NULL,
  `saldo` double DEFAULT NULL,
  `id_titular_fis` int(11) DEFAULT NULL,
  `id_titular_jur` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cuenta_corriente`
--

INSERT INTO `cuenta_corriente` (`num_cuenta`, `moneda`, `saldo`, `id_titular_fis`, `id_titular_jur`) VALUES
(1212, 'euro', 10000, 12345, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento`
--

CREATE TABLE `movimiento` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `importe` float DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `num_cuenta` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `movimiento`
--

INSERT INTO `movimiento` (`id`, `descripcion`, `fecha`, `importe`, `tipo`, `num_cuenta`) VALUES
(1, 'Consignacion', '2019-06-20 00:00:00', 2000, 'credito', 1212),
(2, 'Retiro', '2019-06-21 00:00:00', 2000, 'debito', 1212);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `titular_fisico`
--

CREATE TABLE `titular_fisico` (
  `rut` int(11) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `cc` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `titular_fisico`
--

INSERT INTO `titular_fisico` (`rut`, `apellido`, `cc`, `nombre`) VALUES
(12345, 'Pausinni', 109034, 'Laura');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `titular_juridico`
--

CREATE TABLE `titular_juridico` (
  `rut` int(11) NOT NULL,
  `anio_fund` datetime DEFAULT NULL,
  `razon_social` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `titular_juridico`
--

INSERT INTO `titular_juridico` (`rut`, `anio_fund`, `razon_social`) VALUES
(111, '2015-01-01 00:00:00', 'Luttor S.A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `pwd`, `user`) VALUES
(1, '1234', 'tecso');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cuenta_corriente`
--
ALTER TABLE `cuenta_corriente`
  ADD PRIMARY KEY (`num_cuenta`),
  ADD KEY `FKadukto8yf8aq7emw2wm1hhmd3` (`id_titular_fis`),
  ADD KEY `FK293q76m4mluix7n0a3k2b3xu8` (`id_titular_jur`);

--
-- Indices de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhlvv4tjatjlc9893ooprefq1` (`num_cuenta`);

--
-- Indices de la tabla `titular_fisico`
--
ALTER TABLE `titular_fisico`
  ADD PRIMARY KEY (`rut`);

--
-- Indices de la tabla `titular_juridico`
--
ALTER TABLE `titular_juridico`
  ADD PRIMARY KEY (`rut`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cuenta_corriente`
--
ALTER TABLE `cuenta_corriente`
  ADD CONSTRAINT `FK293q76m4mluix7n0a3k2b3xu8` FOREIGN KEY (`id_titular_jur`) REFERENCES `titular_juridico` (`rut`),
  ADD CONSTRAINT `FKadukto8yf8aq7emw2wm1hhmd3` FOREIGN KEY (`id_titular_fis`) REFERENCES `titular_fisico` (`rut`);

--
-- Filtros para la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD CONSTRAINT `FKhlvv4tjatjlc9893ooprefq1` FOREIGN KEY (`num_cuenta`) REFERENCES `cuenta_corriente` (`num_cuenta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
