-- MariaDB dump 10.19  Distrib 10.10.2-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: test_bsvw
-- ------------------------------------------------------
-- Server version	10.10.2-MariaDB-1:10.10.2+maria~ubu2204

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `test_bsvw`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `test_bsvw` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `test_bsvw`;

--
-- Table structure for table `usb_stick`
--

DROP TABLE IF EXISTS `usb_stick`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usb_stick` (
  `Inventarnummer` varchar(255) NOT NULL,
  `Typ` varchar(50) NOT NULL,
  `Speicherkapazitaet` varchar(50) DEFAULT NULL,
  `Hersteller` varchar(100) DEFAULT NULL,
  `Modell` varchar(100) DEFAULT NULL,
  `Seriennummer` varchar(100) DEFAULT NULL,
  `Verfuegbarkeit` varchar(50) DEFAULT NULL,
  `Zustand` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Inventarnummer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usb_stick`
--

LOCK TABLES `usb_stick` WRITE;
/*!40000 ALTER TABLE `usb_stick` DISABLE KEYS */;
INSERT INTO `usb_stick` VALUES
('USB124','Datenstick','32GB','SanDisk','Ultra Flair','SN789101','reserviert','gebraucht'),
('USB125','Bootstick','64GB','Corsair','Voyager','SN111213','ausgeliehen','gebraucht'),
('USB126','Datenstick','128GB','Samsung','Bar Plus','SN456789','in Wartung','defekt');
/*!40000 ALTER TABLE `usb_stick` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usbstick`
--

DROP TABLE IF EXISTS `usbstick`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usbstick` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `inventarnummer` varchar(255) DEFAULT NULL,
  `speicherkapazitaet` varchar(255) DEFAULT NULL,
  `typ` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usbstick`
--

LOCK TABLES `usbstick` WRITE;
/*!40000 ALTER TABLE `usbstick` DISABLE KEYS */;
/*!40000 ALTER TABLE `usbstick` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-07 11:35:15
