-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: direcciones
-- ------------------------------------------------------
-- Server version	9.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `estudiantes`
--

DROP TABLE IF EXISTS `estudiantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiantes` (
  `estu_cedula` int NOT NULL,
  `estu_nombres` varchar(100) DEFAULT NULL,
  `estu_apellidos` varchar(100) DEFAULT NULL,
  `estu_residencia` varchar(255) DEFAULT NULL,
  `estu_ubi_residencia` point DEFAULT NULL,
  `estu_trabajo` varchar(255) DEFAULT NULL,
  `estu_ubi_trabajo` point DEFAULT NULL,
  PRIMARY KEY (`estu_cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiantes`
--

LOCK TABLES `estudiantes` WRITE;
/*!40000 ALTER TABLE `estudiantes` DISABLE KEYS */;
INSERT INTO `estudiantes` VALUES (1023871441,'Fabian','Ruiz','Cra. 6 #13a30, Soacha, Cundinamarca, Colombia',_binary '\0\0\0\0\0\0\0\Z�lB�T@�\"1A��R�','Cra. 3 #8a-175, Mosquera, Cundinamarca, Colombia',_binary '\0\0\0\0\0\0\0|\�\\G\�@&x��z�R�'),(1023871443,'cristian','reyes ','V56W+M5 Qingshuiyixiang, Yuzhong County, Lanzhou, Gansu, China',_binary '\0\0\0\0\0\0\0�\"�\�J\�A@#/kb�Z@','Barrio panorama Anakaro, Calle 3 #1-1, Ansermanuevo, Soacha, Valle del Cauca, Colombia',_binary '\0\0\0\0\0\0\0\�T���H@a����R�'),(1023871444,'Steven','Reyes','Kilometro 5 vía, Bogotá, Colombia',_binary '\0\0\0\0\0\0\0t%\�?@t�\�K�R�','Cl. 80 #94-100, Bogotá, Colombia',_binary '\0\0\0\0\0\0\0\Z�\�;\�@\�&2s�R�'),(1023871445,'Nico','Duran','Cl. 80 #94-100, Bogotá, Colombia',_binary '\0\0\0\0\0\0\0\Z�\�;\�@\�&2s�R�','Cl. 72, Bogotá, Colombia',_binary '\0\0\0\0\0\0\0��\�懞@%�x���R�'),(1023871448,'santiago','garcia','Cl. 129, Bogotá, Colombia',_binary '\0\0\0\0\0\0\0�ːt\�@c���ȄR�','Cl. 31c Sur #3-70, Bogotá, Colombia',_binary '\0\0\0\0\0\0\02\�\�<@b.�څR�'),(1023947849,'Stella','Gutierrez','P6XW+HJ8, Provincia de Cartago, Paraíso, Costa Rica',_binary '\0\0\0\0\0\0\0<֌r#@�*8�T�','22 Jhaban Rd, Tambon Si Phum, Amphoe Mueang Chiang Mai, Chang Wat Chiang Mai 50200, Tailandia',_binary '\0\0\0\0\0\0\0H�\�\�\�\�2@?.+�X@');
/*!40000 ALTER TABLE `estudiantes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-06 21:57:46
