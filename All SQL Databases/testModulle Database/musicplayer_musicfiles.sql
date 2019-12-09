CREATE DATABASE  IF NOT EXISTS `musicplayer` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `musicplayer`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: musicplayer
-- ------------------------------------------------------
-- Server version	5.7.28-log

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
-- Table structure for table `musicfiles`
--

DROP TABLE IF EXISTS `musicfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musicfiles` (
  `song_id` int(10) NOT NULL AUTO_INCREMENT,
  `song_title` varchar(50) DEFAULT NULL,
  `artist_name` varchar(50) DEFAULT NULL,
  `album_name` varchar(50) DEFAULT NULL,
  `song_location` varchar(50) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`song_id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musicfiles`
--

LOCK TABLES `musicfiles` WRITE;
/*!40000 ALTER TABLE `musicfiles` DISABLE KEYS */;
INSERT INTO `musicfiles` VALUES (1,'Tere Naam','Udit Narayan','Tere Naam song','Aagra','This is a sad sond'),(2,'Tu Hi Aana','Arjit Singh','Marjawa song','Mumbai','This is a romantic song'),(3,'Ye Kalank Nahi','Mohit','Kalank song','Hyderabad','This is a melodi and romantic song'),(4,'Tere Bin','Atif Aslam','Tere Bin song','Jammu','This is a romantic song'),(5,'Uri Title Track','Shankar','Uri song','Kashmir','This is a thriller song'),(101,'',' fjoigf',' gnjklgmk',' oityuy','jkdsfgsdhfsdhuifsd'),(102,'dsjkfh','jfkbdj','mcvn','xcjdsh','jkfh'),(104,'','qwieu oeityoerti','sadjhs erweiu','xzkjhsd optyiryi','weyrhieuw eropitui'),(105,'sdjf iorgtur','wg erotiu','sdfjh trop','sdfj eroti','dweih ertiop');
/*!40000 ALTER TABLE `musicfiles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-09 16:06:32
