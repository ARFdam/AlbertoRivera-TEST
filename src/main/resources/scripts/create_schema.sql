CREATE DATABASE `albertoriveratest` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

DROP TABLE `clientes`;

CREATE TABLE `clientes` (
  `id_cliente` int NOT NULL,
  `codigo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
);

INSERT INTO `albertoriveratest`.`clientes` (`id_cliente`,`codigo`) VALUES (5,"005");
INSERT INTO `albertoriveratest`.`clientes` (`id_cliente`,`codigo`) VALUES (6,"006");
INSERT INTO `albertoriveratest`.`clientes` (`id_cliente`,`codigo`) VALUES (7,"007");
INSERT INTO `albertoriveratest`.`clientes` (`id_cliente`,`codigo`) VALUES (8,"008");

DROP TABLE `proveedores`;

CREATE TABLE `proveedores` (
  `id_proveedor` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `fecha_alta` date DEFAULT NULL,
  `id_cliente` int NOT NULL,
  PRIMARY KEY (`id_proveedor`),
  KEY `id_cliente_idx` (`id_cliente`),
  CONSTRAINT `id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO `albertoriveratest`.`proveedores` (`id_proveedor`,`nombre`,`fecha_alta`,`id_cliente`) VALUES (1,"Coca-cola",2023-06-18,5);
INSERT INTO `albertoriveratest`.`proveedores` (`id_proveedor`,`nombre`,`fecha_alta`,`id_cliente`) VALUES (2,"Pepsi",2023-06-18,5);
INSERT INTO `albertoriveratest`.`proveedores` (`id_proveedor`,`nombre`,`fecha_alta`,`id_cliente`) VALUES (3,"Redbull",2023-06-18,6);
INSERT INTO `albertoriveratest`.`proveedores` (`id_proveedor`,`nombre`,`fecha_alta`,`id_cliente`) VALUES (4,"Fanta",2023-06-18,7);
INSERT INTO `albertoriveratest`.`proveedores` (`id_proveedor`,`nombre`,`fecha_alta`,`id_cliente`) VALUES (5,"Casera",2023-06-18,8);
INSERT INTO `albertoriveratest`.`proveedores` (`id_proveedor`,`nombre`,`fecha_alta`,`id_cliente`) VALUES (6,"Trina",2023-06-18,6);
