-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: pepole_employment_centre
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `gmps_details`
--

DROP TABLE IF EXISTS `gmps_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gmps_details` (
  `GId` int NOT NULL AUTO_INCREMENT,
  `GMP_Id` varchar(4) NOT NULL,
  `adhar_Number` varchar(12) NOT NULL,
  `name` varchar(50) NOT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(5) DEFAULT NULL,
  `panchayat_Name` varchar(50) NOT NULL,
  `district` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `project_Id` int NOT NULL,
  PRIMARY KEY (`GId`),
  UNIQUE KEY `GMP_Id` (`GMP_Id`),
  UNIQUE KEY `adhar_Number` (`adhar_Number`),
  UNIQUE KEY `panchayat_Name` (`panchayat_Name`),
  KEY `project_Id` (`project_Id`),
  CONSTRAINT `gmps_details_ibfk_1` FOREIGN KEY (`project_Id`) REFERENCES `project_details` (`PId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gmps_details`
--

LOCK TABLES `gmps_details` WRITE;
/*!40000 ALTER TABLE `gmps_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `gmps_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_details`
--

DROP TABLE IF EXISTS `project_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_details` (
  `PId` int NOT NULL AUTO_INCREMENT,
  `project_Id` varchar(4) NOT NULL,
  `project_Name` varchar(50) NOT NULL,
  `start_Date` date NOT NULL,
  `end_Date` date NOT NULL,
  `no_of_workers` int NOT NULL,
  `per_day_wages` double NOT NULL,
  PRIMARY KEY (`PId`),
  UNIQUE KEY `project_Id` (`project_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_details`
--

LOCK TABLES `project_details` WRITE;
/*!40000 ALTER TABLE `project_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker_details`
--

DROP TABLE IF EXISTS `worker_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `worker_details` (
  `WId` int NOT NULL AUTO_INCREMENT,
  `worker_Id` varchar(4) NOT NULL,
  `adhar_Number` varchar(12) NOT NULL,
  `name` varchar(50) NOT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(5) DEFAULT NULL,
  `panchayat_Name` varchar(50) NOT NULL,
  `district` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `is_occupied` int DEFAULT '0',
  `is_delete` int DEFAULT '0',
  `project_Id` int NOT NULL,
  PRIMARY KEY (`WId`),
  UNIQUE KEY `worker_Id` (`worker_Id`),
  UNIQUE KEY `adhar_Number` (`adhar_Number`),
  UNIQUE KEY `panchayat_Name` (`panchayat_Name`),
  KEY `project_Id` (`project_Id`),
  CONSTRAINT `worker_details_ibfk_1` FOREIGN KEY (`project_Id`) REFERENCES `project_details` (`PId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker_details`
--

LOCK TABLES `worker_details` WRITE;
/*!40000 ALTER TABLE `worker_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `worker_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-29 18:51:59
