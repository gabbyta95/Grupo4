-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 27-09-2019 a las 15:30:34
-- Versión del servidor: 5.7.17-log
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_gestion_motos`
--
CREATE DATABASE IF NOT EXISTS `bd_gestion_motos` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `bd_gestion_motos`;

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarConcesionario` (IN `id` VARCHAR(25))  BEGIN
SELECT * FROM concesionario WHERE id_concesionario = id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarDetallePedido` (IN `id` VARCHAR(25))  BEGIN
SELECT * FROM detalle_pedido WHERE cod_pedido = id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarDetalleProforma` (IN `id1` VARCHAR(25))  BEGIN
SELECT * FROM detalle_proforma WHERE id_proforma = id1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarMoto` (IN `idmoto` VARCHAR(25))  BEGIN
SELECT * FROM moto WHERE id_moto = idmoto;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarPedido` (IN `idproforma` VARCHAR(25))  BEGIN
SELECT * FROM pedido WHERE cod_pedido = idproforma;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarProforma` (IN `idproforma` VARCHAR(25))  BEGIN
SELECT * FROM proforma WHERE id_proforma = idproforma;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarConcesionario` (IN `id1` VARCHAR(25))  BEGIN
DELETE FROM concesionario  WHERE id_concesionario = id1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarDetallePedido` (IN `id1` VARCHAR(25))  BEGIN
DELETE FROM detalle_pedido WHERE cod_pedido = id1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarMoto` (IN `id1` VARCHAR(25))  BEGIN
DELETE FROM moto  WHERE id_moto = id1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarPedido` (IN `id1` VARCHAR(25))  BEGIN
DELETE FROM pedido WHERE cod_pedido = id1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarProforma` (IN `id1` VARCHAR(25))  BEGIN
DELETE FROM proforma WHERE id_proforma = id1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarConcesionario` (IN `id` VARCHAR(25), IN `nomb` VARCHAR(25), IN `direc` VARCHAR(25), IN `telf` VARCHAR(25))  BEGIN
insert into concesionario(id_concesionario, nombre_concesionario,direccion, telefono ) values (id, nomb, direc, telf);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarDetallePedido` (IN `id` VARCHAR(25), IN `idproforma` VARCHAR(25), IN `idmoto` VARCHAR(25), IN `cantidad` INT, IN `color` VARCHAR(25))  BEGIN
insert into detalle_pedido(id_detalle, cod_pedido, id_moto,cantidad,color) values (id, idproforma, idmoto,cantidad, color);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarDetalleProforma` (IN `id` VARCHAR(25), IN `idproforma` VARCHAR(25), IN `idmoto` VARCHAR(25), IN `cantidad` INT, IN `color` VARCHAR(25))  BEGIN
insert into detalle_proforma(id_detalle_proforma, id_proforma, id_moto,cantidad,color) values (id, idproforma, idmoto,cantidad, color);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarMoto` (IN `id` VARCHAR(25), IN `modelo` VARCHAR(30), IN `cilindraje` VARCHAR(25), IN `precio` FLOAT)  BEGIN
insert into moto (id_moto, modelo,cilindraje,precio) values (id, modelo,cilindraje,precio);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarPedido` (IN `id` VARCHAR(25), IN `fecha` DATE, IN `estado` VARCHAR(25), IN `idconcesionario` VARCHAR(25))  BEGIN
insert into pedido (cod_pedido, fecha_recepcion, estado, id_concesionario) values (id, fecha,estado,idconcesionario);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarProforma` (IN `id` VARCHAR(25), IN `fecha` DATE, IN `estado` VARCHAR(15), IN `idconcesionario` VARCHAR(8))  BEGIN
insert into proforma(id_proforma, fecha_recepcion, estado,id_concesionario) values (id, fecha, estado, idconcesionario );
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarConcesionario` (IN `id1` VARCHAR(25), IN `nombre` VARCHAR(25), IN `direc` VARCHAR(25), IN `tele` VARCHAR(25))  BEGIN
UPDATE concesionario SET  nombre_concesionario = nombre, direccion = direc, telefono = tele  WHERE id_concesionario = id1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarDetalleProforma` (IN `id` VARCHAR(25), IN `idproforma` VARCHAR(25), IN `idmoto` VARCHAR(25), IN `cantidad` INT, IN `color` VARCHAR(25))  BEGIN
UPDATE detalle_proforma SET id_detalle_proforma= id , id_proforma = idproforma, id_moto = idmoto, cantidad = cantidad, color = color   WHERE id_proforma= idproforma;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarMoto` (IN `id1` VARCHAR(25), IN `modelo1` VARCHAR(25), IN `cilindraje1` VARCHAR(5), IN `precio` FLOAT)  BEGIN
UPDATE moto SET   modelo = modelo1, cilindraje = cilindraje1,moto.precio=precio  WHERE id_moto = id1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarpedido` (IN `id` VARCHAR(25), IN `fecha` DATE, IN `estado` VARCHAR(25), IN `idconcesionario` VARCHAR(25))  BEGIN
UPDATE pedido SET  fecha_recepcion= fecha, estado = estado, id_concesionario = idconcesionario  WHERE cod_pedido = id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarProforma` (IN `id1` VARCHAR(25), IN `fecha` DATE, IN `estado1` VARCHAR(8), IN `idconcesionario` VARCHAR(25))  BEGIN
UPDATE proforma SET  id_proforma= id1, fecha_recepcion = fecha, estado = estado1, id_concesionario = idconcesionario  WHERE id_proforma = id1;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concesionario`
--

CREATE TABLE `concesionario` (
  `id_concesionario` varchar(8) NOT NULL,
  `nombre_concesionario` varchar(100) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `concesionario`
--

INSERT INTO `concesionario` (`id_concesionario`, `nombre_concesionario`, `direccion`, `telefono`) VALUES
('CON78', 'Toyota', 'Quito', '2546611'),
('CON86', 'Toyota', 'Quito', '2546611');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pedido`
--

CREATE TABLE `detalle_pedido` (
  `id_detalle` varchar(6) NOT NULL,
  `cod_pedido` varchar(8) NOT NULL,
  `id_moto` varchar(8) NOT NULL,
  `cantidad` int(10) NOT NULL,
  `color` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_pedido`
--

INSERT INTO `detalle_pedido` (`id_detalle`, `cod_pedido`, `id_moto`, `cantidad`, `color`) VALUES
('1', 'PED7852', 'MOTO7852', 2, 'azul');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_proforma`
--

CREATE TABLE `detalle_proforma` (
  `id_detalle_proforma` varchar(8) NOT NULL,
  `id_proforma` varchar(8) NOT NULL,
  `id_moto` varchar(8) NOT NULL,
  `cantidad` int(10) DEFAULT NULL,
  `color` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_proforma`
--

INSERT INTO `detalle_proforma` (`id_detalle_proforma`, `id_proforma`, `id_moto`, `cantidad`, `color`) VALUES
('1', 'PRO75236', 'MOTO7852', 4, 'negro'),
('1', 'PRO7777', 'MOTO7852', 7, 'negro'),
('1', 'PRO7852', 'MOTO7852', 4, 'azul'),
('1', 'PRO96', 'MOTO7852', 4, 'azul'),
('1', 'PRO963', 'MOTO7852', 4, 'negro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `cod_factura` varchar(8) NOT NULL,
  `sub_total` float NOT NULL,
  `total` float NOT NULL,
  `impuestos` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `moto`
--

CREATE TABLE `moto` (
  `id_moto` varchar(8) NOT NULL,
  `modelo` varchar(30) NOT NULL,
  `cilindraje` varchar(5) NOT NULL,
  `precio` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `moto`
--

INSERT INTO `moto` (`id_moto`, `modelo`, `cilindraje`, `precio`) VALUES
('MOTO7852', 'gsz', '574cc', 5000),
('MOTO9632', 'gsya', '14cc', 5000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `cod_pedido` varchar(8) NOT NULL,
  `fecha_recepcion` date DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `id_concesionario` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`cod_pedido`, `fecha_recepcion`, `estado`, `id_concesionario`) VALUES
('PED7852', '2019-07-12', 'Activado', 'CON78');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proforma`
--

CREATE TABLE `proforma` (
  `id_proforma` varchar(8) NOT NULL,
  `fecha_recepcion` date NOT NULL,
  `estado` varchar(15) DEFAULT NULL,
  `id_concesionario` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proforma`
--

INSERT INTO `proforma` (`id_proforma`, `fecha_recepcion`, `estado`, `id_concesionario`) VALUES
('PRO75236', '2019-07-02', NULL, 'CON78'),
('PRO7777', '2019-07-01', NULL, 'CON78'),
('PRO7852', '2019-07-16', NULL, 'CON78'),
('PRO79', '2019-07-12', NULL, 'null'),
('PRO96', '2019-07-01', NULL, 'CON78'),
('PRO963', '2019-07-02', NULL, 'CON78');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `IdUsuario` varchar(8) NOT NULL,
  `NombreUsuario` varchar(30) NOT NULL,
  `ApellidoUsuario` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `permisos` varchar(15) NOT NULL,
  `estado` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`IdUsuario`, `NombreUsuario`, `ApellidoUsuario`, `password`, `permisos`, `estado`) VALUES
('12345', 'Stefanía', 'Casa', '12345', 'Administrador', 'Activado'),
('54321', 'Gaby', 'Rosero', '54321', 'Administrador', 'Desactivado'),
('USU1725', 'Gabriela', 'Rosero', '12345', 'Administrador', 'Desactivado'),
('USU75321', 'Carlos', ' Cando', '12345', 'Administrador', 'Activado'),
('USU9876', 'Stefania', 'Rosero', '12345', 'E.Ventas', 'Activado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id_venta` varchar(8) NOT NULL,
  `id_usuario` varchar(8) NOT NULL,
  `fecha` date NOT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `cod_pedido` varchar(8) NOT NULL,
  `cod_factura` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `concesionario`
--
ALTER TABLE `concesionario`
  ADD PRIMARY KEY (`id_concesionario`);

--
-- Indices de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD PRIMARY KEY (`id_detalle`,`cod_pedido`,`id_moto`);

--
-- Indices de la tabla `detalle_proforma`
--
ALTER TABLE `detalle_proforma`
  ADD PRIMARY KEY (`id_proforma`,`id_moto`,`id_detalle_proforma`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`cod_factura`);

--
-- Indices de la tabla `moto`
--
ALTER TABLE `moto`
  ADD PRIMARY KEY (`id_moto`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`cod_pedido`);

--
-- Indices de la tabla `proforma`
--
ALTER TABLE `proforma`
  ADD PRIMARY KEY (`id_proforma`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`IdUsuario`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id_venta`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
