# ************************************************************
# AbsentieSysteem database initializer
# Version 0.1 (beta)
# https://github.com/GP2017-Absentie/Java_back-end
#
# Database: AbsentieSys
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table absentie
# ------------------------------------------------------------

DROP TABLE IF EXISTS `absentie`;

CREATE TABLE `absentie` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `reden` enum('ziekte','doctor','tandarts','overig') NOT NULL DEFAULT 'ziekte',
  `toelichting` text,
  `persoon_FK` int(11) unsigned NOT NULL,
  `les_FK` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `absentie_persoon_FK` (`persoon_FK`),
  KEY `absentie_les_FK` (`les_FK`),
  CONSTRAINT `absentie_les_FK` FOREIGN KEY (`les_FK`) REFERENCES `les` (`id`),
  CONSTRAINT `absentie_persoon_FK` FOREIGN KEY (`persoon_FK`) REFERENCES `persoon` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table klas
# ------------------------------------------------------------

DROP TABLE IF EXISTS `klas`;

CREATE TABLE `klas` (
  `code` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `klas` WRITE;
/*!40000 ALTER TABLE `klas` DISABLE KEYS */;

INSERT INTO `klas` (`code`)
VALUES
	('V1A'),
	('V1B'),
	('V1C'),
	('V1D'),
	('V1E'),
	('V1F');

/*!40000 ALTER TABLE `klas` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table les
# ------------------------------------------------------------

DROP TABLE IF EXISTS `les`;

CREATE TABLE `les` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `datum` date NOT NULL,
  `starttijd` time NOT NULL,
  `eindtijd` time NOT NULL,
  `vak_FK` int(11) unsigned NOT NULL,
  `lokaal_FK` int(11) unsigned NOT NULL,
  `docent_FK` int(11) unsigned NOT NULL,
  `klas_FK` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `les_persoon_FK` (`docent_FK`),
  KEY `les_lokaal_FK` (`lokaal_FK`),
  KEY `les_vak_FK` (`vak_FK`),
  KEY `les_klas_FK` (`klas_FK`),
  CONSTRAINT `les_klas_FK` FOREIGN KEY (`klas_FK`) REFERENCES `klas` (`code`),
  CONSTRAINT `les_lokaal_FK` FOREIGN KEY (`lokaal_FK`) REFERENCES `lokaal` (`id`),
  CONSTRAINT `les_persoon_FK` FOREIGN KEY (`docent_FK`) REFERENCES `persoon` (`id`),
  CONSTRAINT `les_vak_FK` FOREIGN KEY (`vak_FK`) REFERENCES `vak` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `les` WRITE;
/*!40000 ALTER TABLE `les` DISABLE KEYS */;

INSERT INTO `les` (`id`, `datum`, `starttijd`, `eindtijd`, `vak_FK`, `lokaal_FK`, `docent_FK`, `klas_FK`)
VALUES
	(1,'2017-02-06','10:00:00','12:30:00',1,1,8,'V1D'),
	(2,'2017-02-06','11:30:00','14:00:00',1,2,7,'V1B'),
	(3,'2017-02-06','12:00:00','14:30:00',2,3,0,'V1A'),
	(4,'2017-02-06','12:00:00','14:30:00',1,4,6,'V1C'),
	(5,'2017-02-07','09:00:00','11:00:00',3,5,5,'V1C'),
	(6,'2017-02-07','09:30:00','12:00:00',1,6,6,'V1E'),
	(7,'2017-02-07','10:00:00','12:30:00',2,1,2,'V1F'),
	(8,'2017-02-07','11:30:00','14:00:00',2,7,4,'V1D'),
	(9,'2017-02-07','14:30:00','17:00:00',2,2,5,'V1B'),
	(10,'2017-02-07','15:00:00','17:30:00',2,8,4,'V1E'),
	(11,'2017-02-07','15:00:00','17:30:00',2,9,0,'V1A'),
	(12,'2017-02-07','15:30:00','18:00:00',1,6,6,'V1C'),
	(13,'2017-02-08','08:30:00','11:00:00',1,8,6,'V1E'),
	(14,'2017-02-08','09:00:00','11:00:00',3,9,10,'V1D'),
	(15,'2017-02-08','10:00:00','12:30:00',1,10,3,'V1A'),
	(16,'2017-02-08','11:00:00','13:30:00',2,11,2,'V1F'),
	(17,'2017-02-08','11:30:00','14:00:00',1,8,7,'V1B'),
	(18,'2017-02-08','13:00:00','15:00:00',3,2,10,'V1A'),
	(19,'2017-02-08','13:30:00','16:00:00',2,11,1,'V1C'),
	(20,'2017-02-09','08:30:00','11:00:00',2,12,4,'V1D'),
	(21,'2017-02-09','09:00:00','11:00:00',3,8,8,'V1B'),
	(22,'2017-02-09','09:00:00','11:00:00',3,7,1,'V1E'),
	(23,'2017-02-09','11:00:00','13:30:00',1,7,8,'V1D'),
	(24,'2017-02-09','12:30:00','15:00:00',1,13,1,'V1F'),
	(25,'2017-02-09','15:30:00','18:00:00',2,8,1,'V1C'),
	(26,'2017-02-10','09:00:00','11:00:00',3,8,9,'V1F'),
	(27,'2017-02-10','12:00:00','14:30:00',2,6,5,'V1B'),
	(28,'2017-02-10','12:00:00','14:30:00',1,12,1,'V1F'),
	(29,'2017-02-10','12:30:00','15:00:00',2,14,4,'V1E'),
	(30,'2017-02-10','13:00:00','15:30:00',1,10,3,'V1A'),
	(31,'2017-02-13','10:00:00','12:30:00',1,1,8,'V1D'),
	(32,'2017-02-13','11:30:00','14:00:00',1,2,7,'V1B'),
	(33,'2017-02-13','12:00:00','14:30:00',2,3,0,'V1A'),
	(34,'2017-02-13','12:00:00','14:30:00',1,4,6,'V1C'),
	(35,'2017-02-14','10:00:00','12:30:00',2,1,2,'V1F'),
	(36,'2017-02-14','10:00:00','12:30:00',1,11,6,'V1E'),
	(37,'2017-02-14','11:30:00','14:00:00',2,7,4,'V1D'),
	(38,'2017-02-14','14:30:00','17:00:00',2,2,5,'V1B'),
	(39,'2017-02-14','15:00:00','17:30:00',2,8,4,'V1E'),
	(40,'2017-02-14','15:00:00','17:30:00',2,9,0,'V1A'),
	(41,'2017-02-14','15:30:00','18:00:00',1,6,6,'V1C'),
	(42,'2017-02-15','08:30:00','11:00:00',1,8,6,'V1E'),
	(43,'2017-02-15','10:00:00','12:30:00',1,10,3,'V1A'),
	(44,'2017-02-15','11:00:00','13:30:00',2,11,2,'V1F'),
	(45,'2017-02-15','11:30:00','14:00:00',1,8,7,'V1B'),
	(46,'2017-02-15','13:30:00','16:00:00',2,11,1,'V1C'),
	(47,'2017-02-16','08:30:00','11:00:00',2,12,4,'V1D'),
	(48,'2017-02-16','11:00:00','13:30:00',1,7,8,'V1D'),
	(49,'2017-02-16','12:30:00','15:00:00',1,13,1,'V1F'),
	(50,'2017-02-16','15:30:00','18:00:00',2,8,1,'V1C'),
	(51,'2017-02-17','12:00:00','14:30:00',2,6,5,'V1B'),
	(52,'2017-02-17','12:00:00','14:30:00',1,12,1,'V1F'),
	(53,'2017-02-17','12:30:00','15:00:00',2,14,4,'V1E'),
	(54,'2017-02-17','13:00:00','15:30:00',1,10,3,'V1A'),
	(55,'2017-02-20','10:00:00','12:30:00',1,1,8,'V1D'),
	(56,'2017-02-20','11:30:00','14:00:00',1,2,7,'V1B'),
	(57,'2017-02-20','12:00:00','14:30:00',2,3,0,'V1A'),
	(58,'2017-02-20','12:00:00','14:30:00',1,4,6,'V1C'),
	(59,'2017-02-21','10:00:00','12:30:00',2,1,2,'V1F'),
	(60,'2017-02-21','10:00:00','12:30:00',1,11,6,'V1E'),
	(61,'2017-02-21','11:30:00','14:00:00',2,7,4,'V1D'),
	(62,'2017-02-21','12:30:00','14:30:00',3,15,10,'V1A'),
	(63,'2017-02-21','14:30:00','17:00:00',2,2,5,'V1B'),
	(64,'2017-02-21','15:00:00','17:30:00',2,8,4,'V1E'),
	(65,'2017-02-21','15:00:00','17:30:00',2,9,0,'V1A'),
	(66,'2017-02-21','15:30:00','18:00:00',1,6,6,'V1C'),
	(67,'2017-02-22','08:30:00','11:00:00',1,8,6,'V1E'),
	(68,'2017-02-22','09:30:00','11:30:00',3,13,10,'V1D'),
	(69,'2017-02-22','10:00:00','12:30:00',1,10,3,'V1A'),
	(70,'2017-02-22','11:00:00','13:30:00',2,11,2,'V1F'),
	(71,'2017-02-22','11:30:00','14:00:00',1,8,7,'V1B'),
	(72,'2017-02-22','13:30:00','16:00:00',2,11,1,'V1C'),
	(73,'2017-02-23','08:30:00','11:00:00',2,12,4,'V1D'),
	(74,'2017-02-23','09:00:00','11:00:00',3,8,1,'V1E'),
	(75,'2017-02-23','09:00:00','11:00:00',3,16,9,'V1F'),
	(76,'2017-02-23','11:00:00','13:30:00',1,7,8,'V1D'),
	(77,'2017-02-23','12:30:00','15:00:00',1,13,1,'V1F'),
	(78,'2017-02-23','15:30:00','18:00:00',2,8,1,'V1C'),
	(79,'2017-02-24','09:00:00','11:00:00',3,16,8,'V1B'),
	(80,'2017-02-24','09:30:00','11:30:00',3,6,5,'V1C'),
	(81,'2017-02-24','12:00:00','14:30:00',2,6,5,'V1B'),
	(82,'2017-02-24','12:00:00','14:30:00',1,12,1,'V1F'),
	(83,'2017-02-24','12:30:00','15:00:00',2,14,4,'V1E'),
	(84,'2017-02-24','13:00:00','15:30:00',1,10,3,'V1A'),
	(85,'2017-03-06','10:00:00','12:30:00',1,1,8,'V1D'),
	(86,'2017-03-06','11:30:00','14:00:00',1,2,7,'V1B'),
	(87,'2017-03-06','12:00:00','14:30:00',2,3,0,'V1A'),
	(88,'2017-03-06','12:00:00','14:30:00',1,4,6,'V1C'),
	(89,'2017-03-07','10:00:00','12:30:00',2,1,2,'V1F'),
	(90,'2017-03-07','10:00:00','12:30:00',1,11,6,'V1E'),
	(91,'2017-03-07','11:30:00','14:00:00',2,7,4,'V1D'),
	(92,'2017-03-07','14:30:00','17:00:00',2,2,5,'V1B'),
	(93,'2017-03-07','15:00:00','17:30:00',2,8,4,'V1E'),
	(94,'2017-03-07','15:00:00','17:30:00',2,9,0,'V1A'),
	(95,'2017-03-07','15:30:00','18:00:00',1,6,6,'V1C'),
	(96,'2017-03-08','08:30:00','11:00:00',1,8,6,'V1E'),
	(97,'2017-03-08','10:00:00','12:30:00',1,10,3,'V1A'),
	(98,'2017-03-08','11:00:00','13:30:00',2,11,2,'V1F'),
	(99,'2017-03-08','11:30:00','14:00:00',1,8,7,'V1B'),
	(100,'2017-03-08','13:30:00','16:00:00',2,11,1,'V1C'),
	(101,'2017-03-09','08:30:00','11:00:00',2,12,4,'V1D'),
	(102,'2017-03-09','11:00:00','13:30:00',1,7,8,'V1D'),
	(103,'2017-03-09','12:30:00','15:00:00',1,13,1,'V1F'),
	(104,'2017-03-09','15:30:00','18:00:00',2,8,1,'V1C'),
	(105,'2017-03-10','12:00:00','14:30:00',2,6,5,'V1B'),
	(106,'2017-03-10','12:00:00','14:30:00',1,12,1,'V1F'),
	(107,'2017-03-10','12:30:00','15:00:00',2,14,4,'V1E'),
	(108,'2017-03-10','13:00:00','15:30:00',1,10,3,'V1A'),
	(109,'2017-03-13','10:00:00','12:30:00',1,1,8,'V1D'),
	(110,'2017-03-13','11:30:00','14:00:00',1,2,7,'V1B'),
	(111,'2017-03-13','12:00:00','14:30:00',2,3,0,'V1A'),
	(112,'2017-03-13','12:00:00','14:30:00',1,4,6,'V1C'),
	(113,'2017-03-14','10:00:00','12:30:00',2,1,2,'V1F'),
	(114,'2017-03-14','10:00:00','12:30:00',1,11,6,'V1E'),
	(115,'2017-03-14','11:30:00','14:00:00',2,7,4,'V1D'),
	(116,'2017-03-14','12:30:00','14:30:00',3,15,10,'V1A'),
	(117,'2017-03-14','14:30:00','17:00:00',2,2,5,'V1B'),
	(118,'2017-03-14','15:00:00','17:30:00',2,8,4,'V1E'),
	(119,'2017-03-14','15:00:00','17:30:00',2,9,0,'V1A'),
	(120,'2017-03-14','15:30:00','18:00:00',1,6,6,'V1C'),
	(121,'2017-03-15','08:30:00','11:00:00',1,8,6,'V1E'),
	(122,'2017-03-15','09:30:00','11:30:00',3,13,10,'V1D'),
	(123,'2017-03-15','10:00:00','12:30:00',1,10,3,'V1A'),
	(124,'2017-03-15','11:00:00','13:30:00',2,11,2,'V1F'),
	(125,'2017-03-15','11:30:00','14:00:00',1,8,7,'V1B'),
	(126,'2017-03-15','13:30:00','16:00:00',2,11,1,'V1C'),
	(127,'2017-03-16','08:30:00','11:00:00',2,12,4,'V1D'),
	(128,'2017-03-16','09:00:00','11:00:00',3,8,1,'V1E'),
	(129,'2017-03-16','09:00:00','11:00:00',3,16,9,'V1F'),
	(130,'2017-03-16','11:00:00','13:30:00',1,7,8,'V1D'),
	(131,'2017-03-16','12:30:00','15:00:00',1,13,1,'V1F'),
	(132,'2017-03-16','15:30:00','18:00:00',2,8,1,'V1C'),
	(133,'2017-03-17','09:00:00','11:00:00',3,16,8,'V1B'),
	(134,'2017-03-17','09:30:00','11:30:00',3,6,5,'V1C'),
	(135,'2017-03-17','12:00:00','14:30:00',2,6,5,'V1B'),
	(136,'2017-03-17','12:00:00','14:30:00',1,12,1,'V1F'),
	(137,'2017-03-17','12:30:00','15:00:00',2,14,4,'V1E'),
	(138,'2017-03-17','13:00:00','15:30:00',1,10,3,'V1A'),
	(139,'2017-03-20','10:00:00','12:30:00',1,1,8,'V1D'),
	(140,'2017-03-20','11:30:00','14:00:00',1,2,7,'V1B'),
	(141,'2017-03-20','12:00:00','14:30:00',2,3,0,'V1A'),
	(142,'2017-03-20','12:00:00','14:30:00',1,4,6,'V1C'),
	(143,'2017-03-21','10:00:00','12:30:00',1,11,6,'V1E'),
	(144,'2017-03-21','11:30:00','14:00:00',2,7,4,'V1D'),
	(145,'2017-03-21','14:30:00','17:00:00',2,2,5,'V1B'),
	(146,'2017-03-21','15:00:00','17:30:00',2,8,4,'V1E'),
	(147,'2017-03-22','10:00:00','12:30:00',1,10,3,'V1A'),
	(148,'2017-03-22','11:00:00','13:30:00',2,11,2,'V1F'),
	(149,'2017-03-22','13:30:00','16:00:00',2,11,1,'V1C'),
	(150,'2017-03-23','12:30:00','15:00:00',1,13,1,'V1F'),
	(151,'2017-04-17','11:30:00','14:00:00',4,17,0,'V1A');

/*!40000 ALTER TABLE `les` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table lokaal
# ------------------------------------------------------------

DROP TABLE IF EXISTS `lokaal`;

CREATE TABLE `lokaal` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `gebouw` varchar(10) DEFAULT NULL,
  `nummer` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `lokaal` WRITE;
/*!40000 ALTER TABLE `lokaal` DISABLE KEYS */;

INSERT INTO `lokaal` (`id`, `gebouw`, `nummer`)
VALUES
	(1,'DL200','3.91'),
	(2,'DL200','6.84'),
	(3,'DL200','3.83'),
	(4,'DL200','4.86'),
	(5,'DL200','4.82'),
	(6,'DL200','6.85'),
	(7,'DL200','4.87'),
	(8,'DL200','6.83'),
	(9,'DL200','5.82'),
	(10,'DL200','4.83'),
	(11,'DL200','4.89'),
	(12,'DL200','3.85'),
	(13,'DL200','4.84'),
	(14,'DL200','5.84'),
	(15,'DL200','4.88'),
	(16,'DL200','0.83'),
	(17,'DL200','5.83');

/*!40000 ALTER TABLE `lokaal` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table persoon
# ------------------------------------------------------------

DROP TABLE IF EXISTS `persoon`;

CREATE TABLE `persoon` (
  `id` int(11) unsigned NOT NULL,
  `naam` varchar(30) NOT NULL DEFAULT '',
  `email` varchar(40) NOT NULL,
  `wachtwoord` varchar(30) NOT NULL,
  `rol_FK` int(11) unsigned DEFAULT NULL,
  `klas_FK` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `persoon_rol_FK` (`rol_FK`),
  KEY `persoon_klas_FK` (`klas_FK`),
  CONSTRAINT `persoon_klas_FK` FOREIGN KEY (`klas_FK`) REFERENCES `klas` (`code`),
  CONSTRAINT `persoon_rol_FK` FOREIGN KEY (`rol_FK`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `persoon` WRITE;
/*!40000 ALTER TABLE `persoon` DISABLE KEYS */;

INSERT INTO `persoon` (`id`, `naam`, `email`, `wachtwoord`, `rol_FK`, `klas_FK`)
VALUES
	(0,'Alex Jongman','alex.jongman@hu.nl','geheim',2,NULL),
	(1,'Jos van Reenen','jos.vanreenen@hu.nl','geheim',2,NULL),
	(2,'Dick Pronk','dick.pronk@hu.nl','geheim',2,NULL),
	(3,'Annemarije van der Meer','annemarije.vandermeer@hu.nl','geheim',2,NULL),
	(4,'Martijn Jansen','martijn.jansen@hu.nl','geheim',2,NULL),
	(5,'John Smeets','john.smeets@hu.nl','geheim',2,NULL),
	(6,'Bart Kuipers','bart.kuipers@hu.nl','geheim',2,NULL),
	(7,'Bart van Eijkelenburg','bart.vaneijkelenburg@hu.nl','geheim',2,NULL),
	(8,'Peter Schuler','peter.schuler@hu.nl','geheim',2,NULL),
	(9,'Dietske Obbink','dietske.obbink@hu.nl','geheim',2,NULL),
	(10,'Peter van Rooijen','peter.vanrooijen@hu.nl','geheim',2,NULL),
	(1595603,'Pascal Mennings','pascal.mennings@student.hu.nl','geheim',1,'V1F'),
	(1600491,'Manolito van Brouwershaven','manolito.van.brouwershaven@student.hu.nl','geheim',1,'V1C'),
	(1610525,'Sam Morssinkhof','sam.morssinkhof@student.hu.nl','geheim',1,'V1D'),
	(1611115,'Dani?l Reus','dani?l.reus@student.hu.nl','geheim',1,'V1F'),
	(1621699,'Yannick Korringa','yannick.korringa@student.hu.nl','geheim',1,'V1B'),
	(1630766,'Jotte Smit','jotte.smit@student.hu.nl','geheim',1,'V1D'),
	(1636604,'Kevin Balk','kevin.balk@student.hu.nl','geheim',1,'V1F'),
	(1638001,'Maarten van Dijk','maarten.van.dijk@student.hu.nl','geheim',1,'V1B'),
	(1640545,'Lennart Adriaansen','lennart.adriaansen@student.hu.nl','geheim',1,'V1C'),
	(1649269,'Pim van Hespen','pim.van.hespen@student.hu.nl','geheim',1,'V1F'),
	(1656824,'Dani?l Veldkamp','dani?l.veldkamp@student.hu.nl','geheim',1,'V1F'),
	(1657627,'Ruben Holslag','ruben.holslag@student.hu.nl','geheim',1,'V1E'),
	(1658341,'Bart Hiemstra','bart.hiemstra@student.hu.nl','geheim',1,'V1B'),
	(1658950,'Mark Lanser','mark.lanser@student.hu.nl','geheim',1,'V1E'),
	(1660019,'Wester Frenkel','wester.frenkel@student.hu.nl','geheim',1,'V1C'),
	(1662367,'Diesmer Hensbergen','diesmer.hensbergen@student.hu.nl','geheim',1,'V1A'),
	(1664007,'Sijmen Jaarsma','sijmen.jaarsma@student.hu.nl','geheim',1,'V1B'),
	(1664891,'Olivier van der Sijs','olivier.vander.sijs@student.hu.nl','geheim',1,'V1F'),
	(1665013,'Guylian Smithjes','guylian.smithjes@student.hu.nl','geheim',1,'V1E'),
	(1668229,'Michiel Mooy','michiel.mooy@student.hu.nl','geheim',1,'V1E'),
	(1674604,'Dahir Warsame','dahir.warsame@student.hu.nl','geheim',1,'V1D'),
	(1676955,'Owen Ashby','owen.ashby@student.hu.nl','geheim',1,'V1D'),
	(1679008,'Sebastiaan van Rijn','sebastiaan.van.rijn@student.hu.nl','geheim',1,'V1D'),
	(1679241,'Vincent Daal','vincent.daal@student.hu.nl','geheim',1,'V1B'),
	(1679641,'Devin Minnaard','devin.minnaard@student.hu.nl','geheim',1,'V1F'),
	(1679959,'Soufian Tichattibin','soufian.tichattibin@student.hu.nl','geheim',1,'V1F'),
	(1682045,'Robin Aalten','robin.aalten@student.hu.nl','geheim',1,'V1A'),
	(1682362,'Matthijs Osterhaus','matthijs.osterhaus@student.hu.nl','geheim',1,'V1A'),
	(1682488,'Karim Stekelenburg','karim.stekelenburg@student.hu.nl','geheim',1,'V1D'),
	(1683065,'Bram Stoker','bram.stoker@student.hu.nl','geheim',1,'V1B'),
	(1683113,'Damien van den Bosch','damien.vanden.bosch@student.hu.nl','geheim',1,'V1A'),
	(1683203,'Monisha Wielkens','monisha.wielkens@student.hu.nl','geheim',1,'V1D'),
	(1684011,'Boris Blom','boris.blom@student.hu.nl','geheim',1,'V1B'),
	(1684145,'Doeke Roos','doeke.roos@student.hu.nl','geheim',1,'V1A'),
	(1684742,'Ruben Sikkens','ruben.sikkens@student.hu.nl','geheim',1,'V1C'),
	(1684994,'Jeroen Verkerk','jeroen.verkerk@student.hu.nl','geheim',1,'V1E'),
	(1686664,'Timo Glastra','timo.glastra@student.hu.nl','geheim',1,'V1D'),
	(1688823,'Roxanne van der Pol','roxanne.vander.pol@student.hu.nl','geheim',1,'V1F'),
	(1693444,'Masha Steinmann','masha.steinmann@student.hu.nl','geheim',1,'V1A'),
	(1693749,'Xaland Durrani','xaland.durrani@student.hu.nl','geheim',1,'V1C'),
	(1694018,'Frans Irgolitsch','frans.irgolitsch@student.hu.nl','geheim',1,'V1B'),
	(1694069,'Sten Terwan','sten.terwan@student.hu.nl','geheim',1,'V1A'),
	(1694547,'Falco de Beer','falco.de.beer@student.hu.nl','geheim',1,'V1B'),
	(1694570,'Igor Mertens','igor.mertens@student.hu.nl','geheim',1,'V1B'),
	(1694584,'Christian van Dijk','christian.van.dijk@student.hu.nl','geheim',1,'V1A'),
	(1694680,'Patrick Kottman','patrick.kottman@student.hu.nl','geheim',1,'V1C'),
	(1694811,'Jo?l ten Voorde','jo?l.ten.voorde@student.hu.nl','geheim',1,'V1C'),
	(1694921,'Dany Sluijk','dany.sluijk@student.hu.nl','geheim',1,'V1C'),
	(1694982,'Bart van Straaten','bart.van.straaten@student.hu.nl','geheim',1,'V1D'),
	(1695070,'Lise Voorburg','lise.voorburg@student.hu.nl','geheim',1,'V1A'),
	(1695598,'Jeroen van Hoeven','jeroen.van.hoeven@student.hu.nl','geheim',1,'V1F'),
	(1696136,'Robin van Vlijmen','robin.van.vlijmen@student.hu.nl','geheim',1,'V1B'),
	(1696191,'Khalili Khalili','khalili.khalili@student.hu.nl','geheim',1,'V1F'),
	(1696206,'Florent op ten Noort','florent.opten.noort@student.hu.nl','geheim',1,'V1A'),
	(1696388,'Michel Wijkstra','michel.wijkstra@student.hu.nl','geheim',1,'V1B'),
	(1696399,'Pim Smits','pim.smits@student.hu.nl','geheim',1,'V1B'),
	(1696546,'Sam Vruggink','sam.vruggink@student.hu.nl','geheim',1,'V1E'),
	(1696604,'Justin Jamanika','justin.jamanika@student.hu.nl','geheim',1,'V1F'),
	(1696654,'Stefan de Raadt','stefan.de.raadt@student.hu.nl','geheim',1,'V1D'),
	(1696814,'Yasin Kasap','yasin.kasap@student.hu.nl','geheim',1,'V1E'),
	(1696880,'Yoram van de Kamp','yoram.vande.kamp@student.hu.nl','geheim',1,'V1D'),
	(1696961,'Matthias Krijgsman','matthias.krijgsman@student.hu.nl','geheim',1,'V1B'),
	(1697126,'Koen van Tuil','koen.van.tuil@student.hu.nl','geheim',1,'V1C'),
	(1697304,'Jan Dekkers','jan.dekkers@student.hu.nl','geheim',1,'V1D'),
	(1697336,'Lars van Kleef','lars.van.kleef@student.hu.nl','geheim',1,'V1A'),
	(1697992,'Danny Mostert','danny.mostert@student.hu.nl','geheim',1,'V1C'),
	(1698194,'Niels Daalhuisen','niels.daalhuisen@student.hu.nl','geheim',1,'V1E'),
	(1698199,'Robin Tempert','robin.tempert@student.hu.nl','geheim',1,'V1F'),
	(1698311,'Wessel Henkes','wessel.henkes@student.hu.nl','geheim',1,'V1E'),
	(1698454,'David Hendrikse','david.hendrikse@student.hu.nl','geheim',1,'V1C'),
	(1698563,'Marick van Tuil','marick.van.tuil@student.hu.nl','geheim',1,'V1A'),
	(1698603,'Robert Arissen','robert.arissen@student.hu.nl','geheim',1,'V1F'),
	(1698848,'Donald Hioe','donald.hioe@student.hu.nl','geheim',1,'V1B'),
	(1698919,'Stef Konijn','stef.konijn@student.hu.nl','geheim',1,'V1A'),
	(1699001,'Wouter te Dorsthorst','wouter.te.dorsthorst@student.hu.nl','geheim',1,'V1F'),
	(1699137,'Justin Wilkes','justin.wilkes@student.hu.nl','geheim',1,'V1C'),
	(1699291,'Meifeng Houweling','meifeng.houweling@student.hu.nl','geheim',1,'V1E'),
	(1699599,'Thomas Mocellin','thomas.mocellin@student.hu.nl','geheim',1,'V1D'),
	(1699627,'Koen Fischer','koen.fischer@student.hu.nl','geheim',1,'V1A'),
	(1699882,'Lucca Huijgens','lucca.huijgens@student.hu.nl','geheim',1,'V1D'),
	(1700011,'Pasoon Mohammad Pasoon Popal','pasoon.mohammadpasoonpopal@student.hu.nl','geheim',1,'V1A'),
	(1700311,'Lex den Otter','lex.den.otter@student.hu.nl','geheim',1,'V1D'),
	(1701957,'Ezri Mudde','ezri.mudde@student.hu.nl','geheim',1,'V1E'),
	(1702039,'Kamal Kamal','kamal.kamal@student.hu.nl','geheim',1,'V1C'),
	(1702059,'Patrick Dijkwel','patrick.dijkwel@student.hu.nl','geheim',1,'V1B'),
	(1702165,'Fabio Boer','fabio.boer@student.hu.nl','geheim',1,'V1C'),
	(1702167,'Wenfrie Hu','wenfrie.hu@student.hu.nl','geheim',1,'V1F'),
	(1702255,'Jan Achterberg','jan.achterberg@student.hu.nl','geheim',1,'V1F'),
	(1702265,'Shafie Abdoel','shafie.abdoel@student.hu.nl','geheim',1,'V1E'),
	(1702410,'Marc Bosman','marc.bosman@student.hu.nl','geheim',1,'V1B'),
	(1702431,'Kin Yueng Cheung','kinyueng.cheung@student.hu.nl','geheim',1,'V1A'),
	(1702471,'Redouan Bouzid','redouan.bouzid@student.hu.nl','geheim',1,'V1C'),
	(1702504,'Joris van Heijningen','joris.van.heijningen@student.hu.nl','geheim',1,'V1D'),
	(1702563,'Chanwai Lok','chanwai.lok@student.hu.nl','geheim',1,'V1B'),
	(1702623,'Steven Steenbrink','steven.steenbrink@student.hu.nl','geheim',1,'V1E'),
	(1702624,'Rick de Leeuw','rick.de.leeuw@student.hu.nl','geheim',1,'V1C'),
	(1702657,'Ties Brouwer','ties.brouwer@student.hu.nl','geheim',1,'V1F'),
	(1702709,'Sjors Wijsman','sjors.wijsman@student.hu.nl','geheim',1,'V1C'),
	(1702730,'Bas Henstra-Hill','bas.henstra-hill@student.hu.nl','geheim',1,'V1D'),
	(1702834,'Thomas Korevaar','thomas.korevaar@student.hu.nl','geheim',1,'V1A'),
	(1702943,'Brigitte Le Blanc','brigitte.le.blanc@student.hu.nl','geheim',1,'V1F'),
	(1702987,'Hilbrand Meijer','hilbrand.meijer@student.hu.nl','geheim',1,'V1A'),
	(1703001,'Ties Hartog','ties.hartog@student.hu.nl','geheim',1,'V1F'),
	(1703015,'Robbert Ritsema','robbert.ritsema@student.hu.nl','geheim',1,'V1C'),
	(1703046,'Ronald de Rooij','ronald.de.rooij@student.hu.nl','geheim',1,'V1F'),
	(1703198,'Luuk Schoenmakers','luuk.schoenmakers@student.hu.nl','geheim',1,'V1B'),
	(1703351,'Marwan Bellazghari','marwan.bellazghari@student.hu.nl','geheim',1,'V1C'),
	(1703385,'Tim Hoogeland','tim.hoogeland@student.hu.nl','geheim',1,'V1E'),
	(1703444,'Alex Brasser','alex.brasser@student.hu.nl','geheim',1,'V1A'),
	(1703506,'Ana Goessens','ana.goessens@student.hu.nl','geheim',1,'V1D'),
	(1703511,'Lourens Kos','lourens.kos@student.hu.nl','geheim',1,'V1E'),
	(1703679,'Nick Windt','nick.windt@student.hu.nl','geheim',1,'V1D'),
	(1703684,'Mats de Waard','mats.de.waard@student.hu.nl','geheim',1,'V1E'),
	(1704102,'Martijn Bakker','martijn.bakker@student.hu.nl','geheim',1,'V1E'),
	(1704271,'Jerry Looman','jerry.looman@student.hu.nl','geheim',1,'V1E'),
	(1704319,'Larsse Vink','larsse.vink@student.hu.nl','geheim',1,'V1A'),
	(1704365,'Atilla Bosma','atilla.bosma@student.hu.nl','geheim',1,'V1F'),
	(1704412,'Tjibbe van der Ende','tjibbe.vander.ende@student.hu.nl','geheim',1,'V1E'),
	(1704662,'Yosef M\'jati','yosef.m\'jati@student.hu.nl','geheim',1,'V1C'),
	(1704879,'Martin de Jongh','martin.de.jongh@student.hu.nl','geheim',1,'V1D'),
	(1704916,'Chung Wong','chung.wong@student.hu.nl','geheim',1,'V1D'),
	(1705246,'Sander Wiggers','sander.wiggers@student.hu.nl','geheim',1,'V1C'),
	(1705290,'Stan Gerritsen','stan.gerritsen@student.hu.nl','geheim',1,'V1C'),
	(1705490,'Nico van den Brink','nico.vanden.brink@student.hu.nl','geheim',1,'V1B'),
	(1705632,'Michiel Diederen','michiel.diederen@student.hu.nl','geheim',1,'V1E'),
	(1705923,'Rick Blanksma','rick.blanksma@student.hu.nl','geheim',1,'V1F'),
	(1705943,'Douwe Schepers','douwe.schepers@student.hu.nl','geheim',1,'V1E'),
	(1706021,'Frans Holwerda','frans.holwerda@student.hu.nl','geheim',1,'V1F'),
	(1706363,'Fazal Popkema','fazal.popkema@student.hu.nl','geheim',1,'V1C'),
	(1706382,'Cedric Voncken','cedric.voncken@student.hu.nl','geheim',1,'V1E'),
	(1706387,'Pim Rheiter','pim.rheiter@student.hu.nl','geheim',1,'V1C'),
	(1706428,'Sebastiaan de Bruin','sebastiaan.de.bruin@student.hu.nl','geheim',1,'V1B'),
	(1706750,'Edo van Draanen','edo.van.draanen@student.hu.nl','geheim',1,'V1A'),
	(1706971,'Jorrit Strikwerda','jorrit.strikwerda@student.hu.nl','geheim',1,'V1A'),
	(1707132,'Renske Zandberg','renske.zandberg@student.hu.nl','geheim',1,'V1E'),
	(1707233,'Daniel Busse','daniel.busse@student.hu.nl','geheim',1,'V1B'),
	(1707245,'Jason Posner','jason.posner@student.hu.nl','geheim',1,'V1A'),
	(1707366,'Nathan Haseth','nathan.haseth@student.hu.nl','geheim',1,'V1D'),
	(1708449,'Noor van Ewijk','noor.van.ewijk@student.hu.nl','geheim',1,'V1A'),
	(1708687,'Yorin Ouwerkerk','yorin.ouwerkerk@student.hu.nl','geheim',1,'V1C'),
	(1709020,'Jop Corver','jop.corver@student.hu.nl','geheim',1,'V1B'),
	(1709739,'Jan de Waal','jan.de.waal@student.hu.nl','geheim',1,'V1F'),
	(1710273,'Ruben Jansen','ruben.jansen@student.hu.nl','geheim',1,'V1B'),
	(1710314,'Niels van Brakel','niels.van.brakel@student.hu.nl','geheim',1,'V1E'),
	(1710334,'David Kok','david.kok@student.hu.nl','geheim',1,'V1B'),
	(1710457,'Sem Vasiljan','sem.vasiljan@student.hu.nl','geheim',1,'V1C'),
	(1710479,'Nynke van Koningsveld','nynke.van.koningsveld@student.hu.nl','geheim',1,'V1E'),
	(1710581,'Tim van de Looy','tim.vande.looy@student.hu.nl','geheim',1,'V1C'),
	(1710676,'Gijs van Gorp','gijs.van.gorp@student.hu.nl','geheim',1,'V1D'),
	(1710791,'Azzeddine Agrida','azzeddine.agrida@student.hu.nl','geheim',1,'V1C'),
	(1710907,'Robin Klok','robin.klok@student.hu.nl','geheim',1,'V1D'),
	(1710986,'Chi kin Tsang','chikin.tsang@student.hu.nl','geheim',1,'V1A'),
	(1711403,'Shant Kalaidjian','shant.kalaidjian@student.hu.nl','geheim',1,'V1F'),
	(1711412,'Jordi Bottema','jordi.bottema@student.hu.nl','geheim',1,'V1B');

/*!40000 ALTER TABLE `persoon` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table rol
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rol`;

CREATE TABLE `rol` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `naam` enum('student','docent') NOT NULL DEFAULT 'student',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;

INSERT INTO `rol` (`id`, `naam`)
VALUES
	(1,'student'),
	(2,'docent');

/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table vak
# ------------------------------------------------------------

DROP TABLE IF EXISTS `vak`;

CREATE TABLE `vak` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(15) DEFAULT NULL,
  `naam` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `vak` WRITE;
/*!40000 ALTER TABLE `vak` DISABLE KEYS */;

INSERT INTO `vak` (`id`, `code`, `naam`)
VALUES
	(1,'TICT-V1OODC','TICT-V1OODC-15_2016'),
	(2,'TCIF-V1AUI','TCIF-V1AUI-15_2016'),
	(3,'TICT-V1GP','TICT-V1GP-15_2016'),
	(4,'TICT-V1WAC','TICT-V1WAC-15_2016');

/*!40000 ALTER TABLE `vak` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
