-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-07-2022 a las 05:40:55
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdfarmacia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compraproducto`
--

CREATE TABLE `compraproducto` (
  `IDCOMPRAPRODUCTO` int(11) NOT NULL,
  `CANTIDAD` int(11) NOT NULL,
  `TOTALMONETARIO` float NOT NULL,
  `FECHA` date NOT NULL,
  `IDPRODUCTO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `compraproducto`
--

INSERT INTO `compraproducto` (`IDCOMPRAPRODUCTO`, `CANTIDAD`, `TOTALMONETARIO`, `FECHA`, `IDPRODUCTO`) VALUES
(1, 22, 0, '2022-07-25', 50),
(2, 100, 100, '2022-07-25', 49);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `IDPRODUCTO` int(11) NOT NULL,
  `NOMBRE` varchar(45) NOT NULL,
  `CANTIDAD` int(11) NOT NULL,
  `PRECIO_VENTA` float NOT NULL,
  `PRECIO_COMPRA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`IDPRODUCTO`, `NOMBRE`, `CANTIDAD`, `PRECIO_VENTA`, `PRECIO_COMPRA`) VALUES
(33, 'Ibuprofeno', 5002, 6.5, 5),
(35, 'Panadol', 699, 2.5, 1.5),
(37, 'Feranin', 489, 10.4, 8),
(38, 'Ketorolaco', 900, 1.6, 1),
(39, 'Clindamicina', 150, 6.7, 5),
(41, 'Terbinafina', 200, 12.2, 10),
(47, 'Azitromicina', 200, 1.2, 3),
(49, 'Paracetamol', 100, 1.5, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rango`
--

CREATE TABLE `rango` (
  `IDRANGO` int(11) NOT NULL,
  `RANGO` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `rango`
--

INSERT INTO `rango` (`IDRANGO`, `RANGO`) VALUES
(1, 'CLIENTE'),
(2, 'ADMINISTRADOR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `IDUSUARIO` int(11) NOT NULL,
  `NOMBRE` varchar(45) NOT NULL,
  `APEPATERNO` varchar(45) NOT NULL,
  `APEMATERNO` varchar(45) NOT NULL,
  `USUARIO` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `GMAIL` varchar(80) NOT NULL,
  `IDRANGO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`IDUSUARIO`, `NOMBRE`, `APEPATERNO`, `APEMATERNO`, `USUARIO`, `PASSWORD`, `GMAIL`, `IDRANGO`) VALUES
(1, 'ARMANDO', 'MURALES', 'FERNANDEZ', 'ARMANDO', '123', 'MURITOS_ALTOS@GMAIL.COM', 2),
(2, 'Elberth', 'Armando', 'Casas', 'usuario', '123', 'elberth.armando@gmail.com', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventaproducto`
--

CREATE TABLE `ventaproducto` (
  `IDVENTAPRODUCTO` int(11) NOT NULL,
  `IDPRODUCTO` int(11) NOT NULL,
  `CANTIDAD` int(11) NOT NULL,
  `TOTALMONETARIO` float NOT NULL,
  `IDUSUARIO` int(11) NOT NULL,
  `FECHA` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ventaproducto`
--

INSERT INTO `ventaproducto` (`IDVENTAPRODUCTO`, `IDPRODUCTO`, `CANTIDAD`, `TOTALMONETARIO`, `IDUSUARIO`, `FECHA`) VALUES
(2, 33, 50, 325, 2, '2022-07-22'),
(6, 33, 212, 212, 2, '2022-07-23'),
(18, 35, 1, 2.5, 2, '2022-07-24'),
(19, 37, 10, 104, 2, '2022-07-24'),
(20, 37, 1, 10.4, 2, '2022-07-24');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `compraproducto`
--
ALTER TABLE `compraproducto`
  ADD PRIMARY KEY (`IDCOMPRAPRODUCTO`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`IDPRODUCTO`);

--
-- Indices de la tabla `rango`
--
ALTER TABLE `rango`
  ADD PRIMARY KEY (`IDRANGO`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`IDUSUARIO`),
  ADD KEY `cfk_usuario_rango` (`IDRANGO`);

--
-- Indices de la tabla `ventaproducto`
--
ALTER TABLE `ventaproducto`
  ADD PRIMARY KEY (`IDVENTAPRODUCTO`),
  ADD KEY `cfk_ventap_pro` (`IDPRODUCTO`),
  ADD KEY `cfk_ventap_usu` (`IDUSUARIO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `compraproducto`
--
ALTER TABLE `compraproducto`
  MODIFY `IDCOMPRAPRODUCTO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `IDPRODUCTO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT de la tabla `rango`
--
ALTER TABLE `rango`
  MODIFY `IDRANGO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `IDUSUARIO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `ventaproducto`
--
ALTER TABLE `ventaproducto`
  MODIFY `IDVENTAPRODUCTO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `cfk_usuario_rango` FOREIGN KEY (`IDRANGO`) REFERENCES `rango` (`IDRANGO`);

--
-- Filtros para la tabla `ventaproducto`
--
ALTER TABLE `ventaproducto`
  ADD CONSTRAINT `cfk_ventap_pro` FOREIGN KEY (`IDPRODUCTO`) REFERENCES `producto` (`IDPRODUCTO`),
  ADD CONSTRAINT `cfk_ventap_usu` FOREIGN KEY (`IDUSUARIO`) REFERENCES `usuario` (`IDUSUARIO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
