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
-- Table structure for table `gmp_project`
--

DROP TABLE IF EXISTS `gmp_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gmp_project` (
  `GMP_name` varchar(50) NOT NULL,
  `adhar` varchar(12) NOT NULL,
  `project_name` varchar(100) NOT NULL,
  UNIQUE KEY `adhar` (`adhar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gmp_project`
--

LOCK TABLES `gmp_project` WRITE;
/*!40000 ALTER TABLE `gmp_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `gmp_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gmp_user_credentials`
--

DROP TABLE IF EXISTS `gmp_user_credentials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gmp_user_credentials` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `is_delete` int DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gmp_user_credentials`
--

LOCK TABLES `gmp_user_credentials` WRITE;
/*!40000 ALTER TABLE `gmp_user_credentials` DISABLE KEYS */;
INSERT INTO `gmp_user_credentials` VALUES (1,'Rahul Kumar','rahul123','r1234',0),(2,'Vikki Kumar','vikki123','v1234',0),(3,'Vishnu Kumar','vishnu123','v1234',0),(4,'Nikki Kumari','nikki123','n1234',0),(5,'Vishal Thakur','vishal123','v1234',0),(6,'Nishant chaurisiya','nishant123','n1234',0),(7,'Avinash','avinash123','a1234',0);
/*!40000 ALTER TABLE `gmp_user_credentials` ENABLE KEYS */;
UNLOCK TABLES;

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
  `project_Id` int DEFAULT NULL,
  PRIMARY KEY (`GId`),
  UNIQUE KEY `GMP_Id` (`GMP_Id`),
  UNIQUE KEY `adhar_Number` (`adhar_Number`),
  UNIQUE KEY `panchayat_Name` (`panchayat_Name`),
  KEY `project_Id` (`project_Id`),
  CONSTRAINT `gmps_details_ibfk_1` FOREIGN KEY (`project_Id`) REFERENCES `project_details` (`PId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gmps_details`
--

LOCK TABLES `gmps_details` WRITE;
/*!40000 ALTER TABLE `gmps_details` DISABLE KEYS */;
INSERT INTO `gmps_details` VALUES (1,'GM01','123412341234','Rahul singh','2000-02-02','Male','Bishanpur','Katihar','Bihar',1),(2,'GM02','123423453456','Vikki Kumar','2001-04-02','Male','Bathnaha','Forbesganj','Bihar',NULL),(3,'GM03','123612347234','Avinash','2000-02-02','Male','Banmankhi','Purnea','Bihar',NULL);
/*!40000 ALTER TABLE `gmps_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gram_project`
--

DROP TABLE IF EXISTS `gram_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gram_project` (
  `gmp_id` int DEFAULT NULL,
  `project_id` int DEFAULT NULL,
  KEY `gmp_id` (`gmp_id`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `gram_project_ibfk_1` FOREIGN KEY (`gmp_id`) REFERENCES `gmps_details` (`GId`),
  CONSTRAINT `gram_project_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `project_details` (`PId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gram_project`
--

LOCK TABLES `gram_project` WRITE;
/*!40000 ALTER TABLE `gram_project` DISABLE KEYS */;
INSERT INTO `gram_project` VALUES (1,3),(1,1),(2,1),(2,7),(1,3),(1,6),(3,6),(3,8);
/*!40000 ALTER TABLE `gram_project` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_details`
--

LOCK TABLES `project_details` WRITE;
/*!40000 ALTER TABLE `project_details` DISABLE KEYS */;
INSERT INTO `project_details` VALUES (1,'P001','Lining of the feeder canal','2023-01-01','2023-07-07',30,300),(3,'P002','Lining of the Water Courses','2023-02-02','2023-07-07',35,320),(4,'P003','Construction Of Flood','2023-03-03','2023-06-06',20,330),(5,'P004','Repair and Maintaince of Flood','2023-04-01','2023-11-07',40,400),(6,'P005','Construction of feeder Canal','2023-01-01','2023-04-07',20,500),(7,'P006','Development of Chahur land','2023-03-01','2023-09-07',10,330),(8,'P007','Rennovation of Flood','2023-01-01','2023-04-07',10,400),(9,'P008','Developement of Grassland','2023-03-01','2023-06-06',15,500),(10,'P009','Maintaince of Drains','2023-02-11','2023-05-17',10,600),(12,'P010','Construction of Road','2023-07-07','2023-09-09',20,250);
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
  `project_Id` int DEFAULT NULL,
  PRIMARY KEY (`WId`),
  UNIQUE KEY `worker_Id` (`worker_Id`),
  UNIQUE KEY `adhar_Number` (`adhar_Number`),
  UNIQUE KEY `panchayat_Name` (`panchayat_Name`),
  KEY `project_Id` (`project_Id`),
  CONSTRAINT `worker_details_ibfk_1` FOREIGN KEY (`project_Id`) REFERENCES `project_details` (`PId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker_details`
--

LOCK TABLES `worker_details` WRITE;
/*!40000 ALTER TABLE `worker_details` DISABLE KEYS */;
INSERT INTO `worker_details` VALUES (1,'W001','765487652345','Sumit Jha','2001-11-21','Male','Narpatganj','Purnia','Bihar',0,0,NULL),(2,'W002','763487652345','Mohit Raj','2001-10-21','Male','Pratapganj','Ara','Bihar',0,0,NULL),(3,'W003','765487652346','Shyam Yadav','2001-07-22','Male','Shivpur','Khunti','Jharkhand',0,0,NULL),(4,'W004','432543254325','Rajiv Kumar','2000-07-19','Male','Rajpur','DehraDun','Uttrakhand',0,0,NULL),(7,'W005','245987348989','Shivam Saklani','1998-02-02','Male','Gorakhpur','Gorakhpur','Uttarpradesh',0,1,NULL);
/*!40000 ALTER TABLE `worker_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker_project`
--

DROP TABLE IF EXISTS `worker_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `worker_project` (
  `worker_name` varchar(50) NOT NULL,
  `adhar` varchar(12) NOT NULL,
  `project_name` varchar(100) NOT NULL,
  UNIQUE KEY `adhar` (`adhar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker_project`
--

LOCK TABLES `worker_project` WRITE;
/*!40000 ALTER TABLE `worker_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `worker_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker_projects`
--

DROP TABLE IF EXISTS `worker_projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `worker_projects` (
  `worker_id` int DEFAULT NULL,
  `project_id` int DEFAULT NULL,
  KEY `worker_id` (`worker_id`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `worker_projects_ibfk_1` FOREIGN KEY (`worker_id`) REFERENCES `worker_details` (`WId`),
  CONSTRAINT `worker_projects_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `project_details` (`PId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker_projects`
--

LOCK TABLES `worker_projects` WRITE;
/*!40000 ALTER TABLE `worker_projects` DISABLE KEYS */;
INSERT INTO `worker_projects` VALUES (1,1),(1,3),(2,5),(3,5);
/*!40000 ALTER TABLE `worker_projects` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-02 14:30:19
