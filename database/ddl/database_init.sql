# ************************************************************
# AbsentieSysteem database initializer including it's data
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
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8;

LOCK TABLES `les` WRITE;
/*!40000 ALTER TABLE `les` DISABLE KEYS */;

INSERT INTO `les` (`id`, `datum`, `starttijd`, `eindtijd`, `vak_FK`, `lokaal_FK`, `docent_FK`, `klas_FK`)
VALUES
	(2,'2017-02-06','10:00:00','12:30:00',1,1,8,'V1D'),
	(3,'2017-02-06','11:30:00','14:00:00',1,2,7,'V1B'),
	(4,'2017-02-06','12:00:00','14:30:00',2,3,0,'V1A'),
	(5,'2017-02-06','12:00:00','14:30:00',1,4,6,'V1C'),
	(6,'2017-02-07','09:00:00','11:00:00',3,5,5,'V1C'),
	(7,'2017-02-07','09:30:00','12:00:00',1,6,6,'V1E'),
	(8,'2017-02-07','10:00:00','12:30:00',2,1,2,'V1F'),
	(9,'2017-02-07','11:30:00','14:00:00',2,7,4,'V1D'),
	(10,'2017-02-07','14:30:00','17:00:00',2,2,5,'V1B'),
	(11,'2017-02-07','15:00:00','17:30:00',2,8,4,'V1E'),
	(12,'2017-02-07','15:00:00','17:30:00',2,9,0,'V1A'),
	(13,'2017-02-07','15:30:00','18:00:00',1,6,6,'V1C'),
	(14,'2017-02-08','08:30:00','11:00:00',1,8,6,'V1E'),
	(15,'2017-02-08','09:00:00','11:00:00',3,9,10,'V1D'),
	(16,'2017-02-08','10:00:00','12:30:00',1,10,3,'V1A'),
	(17,'2017-02-08','11:00:00','13:30:00',2,11,2,'V1F'),
	(18,'2017-02-08','11:30:00','14:00:00',1,8,7,'V1B'),
	(19,'2017-02-08','13:00:00','15:00:00',3,2,10,'V1A'),
	(20,'2017-02-08','13:30:00','16:00:00',2,11,1,'V1C'),
	(21,'2017-02-09','08:30:00','11:00:00',2,12,4,'V1D'),
	(22,'2017-02-09','09:00:00','11:00:00',3,8,8,'V1B'),
	(23,'2017-02-09','09:00:00','11:00:00',3,7,1,'V1E'),
	(24,'2017-02-09','11:00:00','13:30:00',1,7,8,'V1D'),
	(25,'2017-02-09','12:30:00','15:00:00',1,13,1,'V1F'),
	(26,'2017-02-09','15:30:00','18:00:00',2,8,1,'V1C'),
	(27,'2017-02-10','09:00:00','11:00:00',3,8,9,'V1F'),
	(28,'2017-02-10','12:00:00','14:30:00',2,6,5,'V1B'),
	(29,'2017-02-10','12:00:00','14:30:00',1,12,1,'V1F'),
	(30,'2017-02-10','12:30:00','15:00:00',2,14,4,'V1E'),
	(31,'2017-02-10','13:00:00','15:30:00',1,10,3,'V1A'),
	(32,'2017-02-13','10:00:00','12:30:00',1,1,8,'V1D'),
	(33,'2017-02-13','11:30:00','14:00:00',1,2,7,'V1B'),
	(34,'2017-02-13','12:00:00','14:30:00',2,3,0,'V1A'),
	(35,'2017-02-13','12:00:00','14:30:00',1,4,6,'V1C'),
	(36,'2017-02-14','10:00:00','12:30:00',2,1,2,'V1F'),
	(37,'2017-02-14','10:00:00','12:30:00',1,11,6,'V1E'),
	(38,'2017-02-14','11:30:00','14:00:00',2,7,4,'V1D'),
	(39,'2017-02-14','14:30:00','17:00:00',2,2,5,'V1B'),
	(40,'2017-02-14','15:00:00','17:30:00',2,8,4,'V1E'),
	(41,'2017-02-14','15:00:00','17:30:00',2,9,0,'V1A'),
	(42,'2017-02-14','15:30:00','18:00:00',1,6,6,'V1C'),
	(43,'2017-02-15','08:30:00','11:00:00',1,8,6,'V1E'),
	(44,'2017-02-15','10:00:00','12:30:00',1,10,3,'V1A'),
	(45,'2017-02-15','11:00:00','13:30:00',2,11,2,'V1F'),
	(46,'2017-02-15','11:30:00','14:00:00',1,8,7,'V1B'),
	(47,'2017-02-15','13:30:00','16:00:00',2,11,1,'V1C'),
	(48,'2017-02-16','08:30:00','11:00:00',2,12,4,'V1D'),
	(49,'2017-02-16','11:00:00','13:30:00',1,7,8,'V1D'),
	(50,'2017-02-16','12:30:00','15:00:00',1,13,1,'V1F'),
	(51,'2017-02-16','15:30:00','18:00:00',2,8,1,'V1C'),
	(52,'2017-02-17','12:00:00','14:30:00',2,6,5,'V1B'),
	(53,'2017-02-17','12:00:00','14:30:00',1,12,1,'V1F'),
	(54,'2017-02-17','12:30:00','15:00:00',2,14,4,'V1E'),
	(55,'2017-02-17','13:00:00','15:30:00',1,10,3,'V1A'),
	(56,'2017-02-20','10:00:00','12:30:00',1,1,8,'V1D'),
	(57,'2017-02-20','11:30:00','14:00:00',1,2,7,'V1B'),
	(58,'2017-02-20','12:00:00','14:30:00',2,3,0,'V1A'),
	(59,'2017-02-20','12:00:00','14:30:00',1,4,6,'V1C'),
	(60,'2017-02-21','10:00:00','12:30:00',2,1,2,'V1F'),
	(61,'2017-02-21','10:00:00','12:30:00',1,11,6,'V1E'),
	(62,'2017-02-21','11:30:00','14:00:00',2,7,4,'V1D'),
	(63,'2017-02-21','12:30:00','14:30:00',3,15,10,'V1A'),
	(64,'2017-02-21','14:30:00','17:00:00',2,2,5,'V1B'),
	(65,'2017-02-21','15:00:00','17:30:00',2,8,4,'V1E'),
	(66,'2017-02-21','15:00:00','17:30:00',2,9,0,'V1A'),
	(67,'2017-02-21','15:30:00','18:00:00',1,6,6,'V1C'),
	(68,'2017-02-22','08:30:00','11:00:00',1,8,6,'V1E'),
	(69,'2017-02-22','09:30:00','11:30:00',3,13,10,'V1D'),
	(70,'2017-02-22','10:00:00','12:30:00',1,10,3,'V1A'),
	(71,'2017-02-22','11:00:00','13:30:00',2,11,2,'V1F'),
	(72,'2017-02-22','11:30:00','14:00:00',1,8,7,'V1B'),
	(73,'2017-02-22','13:30:00','16:00:00',2,11,1,'V1C'),
	(74,'2017-02-23','08:30:00','11:00:00',2,12,4,'V1D'),
	(75,'2017-02-23','09:00:00','11:00:00',3,8,1,'V1E'),
	(76,'2017-02-23','09:00:00','11:00:00',3,16,9,'V1F'),
	(77,'2017-02-23','11:00:00','13:30:00',1,7,8,'V1D'),
	(78,'2017-02-23','12:30:00','15:00:00',1,13,1,'V1F'),
	(79,'2017-02-23','15:30:00','18:00:00',2,8,1,'V1C'),
	(80,'2017-02-24','09:00:00','11:00:00',3,16,8,'V1B'),
	(81,'2017-02-24','09:30:00','11:30:00',3,6,5,'V1C'),
	(82,'2017-02-24','12:00:00','14:30:00',2,6,5,'V1B'),
	(83,'2017-02-24','12:00:00','14:30:00',1,12,1,'V1F'),
	(84,'2017-02-24','12:30:00','15:00:00',2,14,4,'V1E'),
	(85,'2017-02-24','13:00:00','15:30:00',1,10,3,'V1A'),
	(86,'2017-03-06','10:00:00','12:30:00',1,1,8,'V1D'),
	(87,'2017-03-06','11:30:00','14:00:00',1,2,7,'V1B'),
	(88,'2017-03-06','12:00:00','14:30:00',2,3,0,'V1A'),
	(89,'2017-03-06','12:00:00','14:30:00',1,4,6,'V1C'),
	(90,'2017-03-07','10:00:00','12:30:00',2,1,2,'V1F'),
	(91,'2017-03-07','10:00:00','12:30:00',1,11,6,'V1E'),
	(92,'2017-03-07','11:30:00','14:00:00',2,7,4,'V1D'),
	(93,'2017-03-07','14:30:00','17:00:00',2,2,5,'V1B'),
	(94,'2017-03-07','15:00:00','17:30:00',2,8,4,'V1E'),
	(95,'2017-03-07','15:00:00','17:30:00',2,9,0,'V1A'),
	(96,'2017-03-07','15:30:00','18:00:00',1,6,6,'V1C'),
	(97,'2017-03-08','08:30:00','11:00:00',1,8,6,'V1E'),
	(98,'2017-03-08','10:00:00','12:30:00',1,10,3,'V1A'),
	(99,'2017-03-08','11:00:00','13:30:00',2,11,2,'V1F'),
	(100,'2017-03-08','11:30:00','14:00:00',1,8,7,'V1B'),
	(101,'2017-03-08','13:30:00','16:00:00',2,11,1,'V1C'),
	(102,'2017-03-09','08:30:00','11:00:00',2,12,4,'V1D'),
	(103,'2017-03-09','11:00:00','13:30:00',1,7,8,'V1D'),
	(104,'2017-03-09','12:30:00','15:00:00',1,13,1,'V1F'),
	(105,'2017-03-09','15:30:00','18:00:00',2,8,1,'V1C'),
	(106,'2017-03-10','12:00:00','14:30:00',2,6,5,'V1B'),
	(107,'2017-03-10','12:00:00','14:30:00',1,12,1,'V1F'),
	(108,'2017-03-10','12:30:00','15:00:00',2,14,4,'V1E'),
	(109,'2017-03-10','13:00:00','15:30:00',1,10,3,'V1A'),
	(110,'2017-03-13','10:00:00','12:30:00',1,1,8,'V1D'),
	(111,'2017-03-13','11:30:00','14:00:00',1,2,7,'V1B'),
	(112,'2017-03-13','12:00:00','14:30:00',2,3,0,'V1A'),
	(113,'2017-03-13','12:00:00','14:30:00',1,4,6,'V1C'),
	(114,'2017-03-14','10:00:00','12:30:00',2,1,2,'V1F'),
	(115,'2017-03-14','10:00:00','12:30:00',1,11,6,'V1E'),
	(116,'2017-03-14','11:30:00','14:00:00',2,7,4,'V1D'),
	(117,'2017-03-14','12:30:00','14:30:00',3,15,10,'V1A'),
	(118,'2017-03-14','14:30:00','17:00:00',2,2,5,'V1B'),
	(119,'2017-03-14','15:00:00','17:30:00',2,8,4,'V1E'),
	(120,'2017-03-14','15:00:00','17:30:00',2,9,0,'V1A'),
	(121,'2017-03-14','15:30:00','18:00:00',1,6,6,'V1C'),
	(122,'2017-03-15','08:30:00','11:00:00',1,8,6,'V1E'),
	(123,'2017-03-15','09:30:00','11:30:00',3,13,10,'V1D'),
	(124,'2017-03-15','10:00:00','12:30:00',1,10,3,'V1A'),
	(125,'2017-03-15','11:00:00','13:30:00',2,11,2,'V1F'),
	(126,'2017-03-15','11:30:00','14:00:00',1,8,7,'V1B'),
	(127,'2017-03-15','13:30:00','16:00:00',2,11,1,'V1C'),
	(128,'2017-03-16','08:30:00','11:00:00',2,12,4,'V1D'),
	(129,'2017-03-16','09:00:00','11:00:00',3,8,1,'V1E'),
	(130,'2017-03-16','09:00:00','11:00:00',3,16,9,'V1F'),
	(131,'2017-03-16','11:00:00','13:30:00',1,7,8,'V1D'),
	(132,'2017-03-16','12:30:00','15:00:00',1,13,1,'V1F'),
	(133,'2017-03-16','15:30:00','18:00:00',2,8,1,'V1C'),
	(134,'2017-03-17','09:00:00','11:00:00',3,16,8,'V1B'),
	(135,'2017-03-17','09:30:00','11:30:00',3,6,5,'V1C'),
	(136,'2017-03-17','12:00:00','14:30:00',2,6,5,'V1B'),
	(137,'2017-03-17','12:00:00','14:30:00',1,12,1,'V1F'),
	(138,'2017-03-17','12:30:00','15:00:00',2,14,4,'V1E'),
	(139,'2017-03-17','13:00:00','15:30:00',1,10,3,'V1A'),
	(140,'2017-03-20','10:00:00','12:30:00',1,1,8,'V1D'),
	(141,'2017-03-20','11:30:00','14:00:00',1,2,7,'V1B'),
	(142,'2017-03-20','12:00:00','14:30:00',2,3,0,'V1A'),
	(143,'2017-03-20','12:00:00','14:30:00',1,4,6,'V1C'),
	(144,'2017-03-21','10:00:00','12:30:00',1,11,6,'V1E'),
	(145,'2017-03-21','11:30:00','14:00:00',2,7,4,'V1D'),
	(146,'2017-03-21','14:30:00','17:00:00',2,2,5,'V1B'),
	(147,'2017-03-21','15:00:00','17:30:00',2,8,4,'V1E'),
	(148,'2017-03-22','10:00:00','12:30:00',1,10,3,'V1A'),
	(149,'2017-03-22','11:00:00','13:30:00',2,11,2,'V1F'),
	(150,'2017-03-22','13:30:00','16:00:00',2,11,1,'V1C'),
	(151,'2017-03-23','12:30:00','15:00:00',1,13,1,'V1F'),
	(152,'2017-04-17','11:30:00','14:00:00',4,17,0,'V1A');

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

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
  `email` varchar(40) NOT NULL DEFAULT '',
  `naam` varchar(30) NOT NULL DEFAULT '',
  `user_FK` int(11) unsigned DEFAULT NULL,
  `rol_FK` int(11) unsigned DEFAULT NULL,
  `klas_FK` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `persoon_rol_FK` (`rol_FK`),
  KEY `persoon_user_FK` (`user_FK`),
  KEY `persoon_klas_FK` (`klas_FK`),
  CONSTRAINT `persoon_klas_FK` FOREIGN KEY (`klas_FK`) REFERENCES `klas` (`code`),
  CONSTRAINT `persoon_rol_FK` FOREIGN KEY (`rol_FK`) REFERENCES `rol` (`id`),
  CONSTRAINT `persoon_user_FK` FOREIGN KEY (`user_FK`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `persoon` WRITE;
/*!40000 ALTER TABLE `persoon` DISABLE KEYS */;

INSERT INTO `persoon` (`id`, `email`, `naam`, `user_FK`, `rol_FK`, `klas_FK`)
VALUES
	(0,'alex.jongman@hu.nl','Alex Jongman',1,2,NULL),
	(1,'jos.vanreenen@hu.nl','Jos van Reenen',3,2,NULL),
	(2,'dick.pronk@hu.nl','Dick Pronk',4,2,NULL),
	(3,'annemarije.vandermeer@hu.nl','Annemarije van der Meer',5,2,NULL),
	(4,'martijn.jansen@hu.nl','Martijn Jansen',6,2,NULL),
	(5,'john.smeets@hu.nl','John Smeets',7,2,NULL),
	(6,'bart.kuipers@hu.nl','Bart Kuipers',8,2,NULL),
	(7,'bart.vaneijkelenburg@hu.nl','Bart van Eijkelenburg',9,2,NULL),
	(8,'peter.schuler@hu.nl','Peter Schuler',10,2,NULL),
	(9,'dietske.obbink@hu.nl','Dietske Obbink',11,2,NULL),
	(10,'peter.vanrooijen@hu.nl','Peter van Rooijen',12,2,NULL),
	(1595603,'pascalmennings@student.hu.nl','Pascal Mennings',125,1,'V1F'),
	(1610525,'sammorssinkhof@student.hu.nl','Sam Morssinkhof',85,1,'V1D'),
	(1611115,'dani?lreus@student.hu.nl','Dani?l Reus',127,1,'V1F'),
	(1621699,'yannickkorringa@student.hu.nl','Yannick Korringa',27,1,'V1B'),
	(1630766,'jottesmit@student.hu.nl','Jotte Smit',86,1,'V1D'),
	(1636604,'kevinbalk@student.hu.nl','Kevin Balk',115,1,'V1F'),
	(1640545,'lennartadriaansen@student.hu.nl','Lennart Adriaansen',53,1,'V1C'),
	(1656824,'dani?lveldkamp@student.hu.nl','Dani?l Veldkamp',130,1,'V1F'),
	(1657627,'rubenholslag@student.hu.nl','Ruben Holslag',97,1,'V1E'),
	(1658341,'barthiemstra@student.hu.nl','Bart Hiemstra',21,1,'V1B'),
	(1658950,'marklanser@student.hu.nl','Mark Lanser',102,1,'V1E'),
	(1660019,'westerfrenkel@student.hu.nl','Wester Frenkel',59,1,'V1C'),
	(1662367,'diesmerhensbergen@student.hu.nl','Diesmer Hensbergen',39,1,'V1A'),
	(1664007,'sijmenjaarsma@student.hu.nl','Sijmen Jaarsma',24,1,'V1B'),
	(1665013,'guyliansmithjes@student.hu.nl','Guylian Smithjes',107,1,'V1E'),
	(1668229,'michielmooy@student.hu.nl','Michiel Mooy',104,1,'V1E'),
	(1674604,'dahirwarsame@student.hu.nl','Dahir Warsame',88,1,'V1D'),
	(1676955,'owenashby@student.hu.nl','Owen Ashby',76,1,'V1D'),
	(1679241,'vincentdaal@student.hu.nl','Vincent Daal',19,1,'V1B'),
	(1679641,'devinminnaard@student.hu.nl','Devin Minnaard',126,1,'V1F'),
	(1679959,'soufiantichattibin@student.hu.nl','Soufian Tichattibin',129,1,'V1F'),
	(1682045,'robinaalten@student.hu.nl','Robin Aalten',35,1,'V1A'),
	(1682362,'matthijsosterhaus@student.hu.nl','Matthijs Osterhaus',44,1,'V1A'),
	(1682488,'karimstekelenburg@student.hu.nl','Karim Stekelenburg',87,1,'V1D'),
	(1683065,'bramstoker@student.hu.nl','Bram Stoker',33,1,'V1B'),
	(1683203,'monishawielkens@student.hu.nl','Monisha Wielkens',89,1,'V1D'),
	(1684011,'borisblom@student.hu.nl','Boris Blom',13,1,'V1B'),
	(1684145,'doekeroos@student.hu.nl','Doeke Roos',46,1,'V1A'),
	(1684742,'rubensikkens@student.hu.nl','Ruben Sikkens',70,1,'V1C'),
	(1684994,'jeroenverkerk@student.hu.nl','Jeroen Verkerk',109,1,'V1E'),
	(1686664,'timoglastra@student.hu.nl','Timo Glastra',78,1,'V1D'),
	(1693444,'mashasteinmann@student.hu.nl','Masha Steinmann',47,1,'V1A'),
	(1693749,'xalanddurrani@student.hu.nl','Xaland Durrani',58,1,'V1C'),
	(1694018,'fransirgolitsch@student.hu.nl','Frans Irgolitsch',23,1,'V1B'),
	(1694069,'stenterwan@student.hu.nl','Sten Terwan',49,1,'V1A'),
	(1694570,'igormertens@student.hu.nl','Igor Mertens',30,1,'V1B'),
	(1694680,'patrickkottman@student.hu.nl','Patrick Kottman',63,1,'V1C'),
	(1694921,'danysluijk@student.hu.nl','Dany Sluijk',71,1,'V1C'),
	(1695070,'lisevoorburg@student.hu.nl','Lise Voorburg',52,1,'V1A'),
	(1696191,'khalilikhalili@student.hu.nl','Khalili Khalili',124,1,'V1F'),
	(1696388,'michelwijkstra@student.hu.nl','Michel Wijkstra',34,1,'V1B'),
	(1696399,'pimsmits@student.hu.nl','Pim Smits',32,1,'V1B'),
	(1696546,'samvruggink@student.hu.nl','Sam Vruggink',111,1,'V1E'),
	(1696604,'justinjamanika@student.hu.nl','Justin Jamanika',122,1,'V1F'),
	(1696814,'yasinkasap@student.hu.nl','Yasin Kasap',100,1,'V1E'),
	(1696961,'matthiaskrijgsman@student.hu.nl','Matthias Krijgsman',28,1,'V1B'),
	(1697304,'jandekkers@student.hu.nl','Jan Dekkers',77,1,'V1D'),
	(1697992,'dannymostert@student.hu.nl','Danny Mostert',65,1,'V1C'),
	(1698194,'nielsdaalhuisen@student.hu.nl','Niels Daalhuisen',94,1,'V1E'),
	(1698199,'robintempert@student.hu.nl','Robin Tempert',128,1,'V1F'),
	(1698311,'wesselhenkes@student.hu.nl','Wessel Henkes',96,1,'V1E'),
	(1698454,'davidhendrikse@student.hu.nl','David Hendrikse',61,1,'V1C'),
	(1698603,'robertarissen@student.hu.nl','Robert Arissen',114,1,'V1F'),
	(1698848,'donaldhioe@student.hu.nl','Donald Hioe',22,1,'V1B'),
	(1698919,'stefkonijn@student.hu.nl','Stef Konijn',40,1,'V1A'),
	(1699137,'justinwilkes@student.hu.nl','Justin Wilkes',75,1,'V1C'),
	(1699291,'meifenghouweling@student.hu.nl','Meifeng Houweling',99,1,'V1E'),
	(1699599,'thomasmocellin@student.hu.nl','Thomas Mocellin',84,1,'V1D'),
	(1699627,'koenfischer@student.hu.nl','Koen Fischer',38,1,'V1A'),
	(1699882,'luccahuijgens@student.hu.nl','Lucca Huijgens',82,1,'V1D'),
	(1700011,'pasoonmohammadpasoonpopal@student.hu.nl','Pasoon Mohammad Pasoon Popal',43,1,'V1A'),
	(1701957,'ezrimudde@student.hu.nl','Ezri Mudde',105,1,'V1E'),
	(1702039,'kamalkamal@student.hu.nl','Kamal Kamal',62,1,'V1C'),
	(1702059,'patrickdijkwel@student.hu.nl','Patrick Dijkwel',20,1,'V1B'),
	(1702165,'fabioboer@student.hu.nl','Fabio Boer',56,1,'V1C'),
	(1702167,'wenfriehu@student.hu.nl','Wenfrie Hu',121,1,'V1F'),
	(1702255,'janachterberg@student.hu.nl','Jan Achterberg',113,1,'V1F'),
	(1702265,'shafieabdoel@student.hu.nl','Shafie Abdoel',92,1,'V1E'),
	(1702410,'marcbosman@student.hu.nl','Marc Bosman',15,1,'V1B'),
	(1702431,'kinyuengcheung@student.hu.nl','Kin Yueng Cheung',37,1,'V1A'),
	(1702471,'redouanbouzid@student.hu.nl','Redouan Bouzid',57,1,'V1C'),
	(1702563,'chanwailok@student.hu.nl','Chanwai Lok',29,1,'V1B'),
	(1702623,'stevensteenbrink@student.hu.nl','Steven Steenbrink',108,1,'V1E'),
	(1702657,'tiesbrouwer@student.hu.nl','Ties Brouwer',118,1,'V1F'),
	(1702709,'sjorswijsman@student.hu.nl','Sjors Wijsman',74,1,'V1C'),
	(1702730,'bashenstra-hill@student.hu.nl','Bas Henstra-Hill',81,1,'V1D'),
	(1702834,'thomaskorevaar@student.hu.nl','Thomas Korevaar',41,1,'V1A'),
	(1702987,'hilbrandmeijer@student.hu.nl','Hilbrand Meijer',42,1,'V1A'),
	(1703001,'tieshartog@student.hu.nl','Ties Hartog',119,1,'V1F'),
	(1703015,'robbertritsema@student.hu.nl','Robbert Ritsema',69,1,'V1C'),
	(1703198,'luukschoenmakers@student.hu.nl','Luuk Schoenmakers',31,1,'V1B'),
	(1703351,'marwanbellazghari@student.hu.nl','Marwan Bellazghari',55,1,'V1C'),
	(1703385,'timhoogeland@student.hu.nl','Tim Hoogeland',98,1,'V1E'),
	(1703444,'alexbrasser@student.hu.nl','Alex Brasser',36,1,'V1A'),
	(1703506,'anagoessens@student.hu.nl','Ana Goessens',79,1,'V1D'),
	(1703511,'lourenskos@student.hu.nl','Lourens Kos',101,1,'V1E'),
	(1703679,'nickwindt@student.hu.nl','Nick Windt',90,1,'V1D'),
	(1704102,'martijnbakker@student.hu.nl','Martijn Bakker',93,1,'V1E'),
	(1704271,'jerrylooman@student.hu.nl','Jerry Looman',103,1,'V1E'),
	(1704319,'larssevink@student.hu.nl','Larsse Vink',51,1,'V1A'),
	(1704365,'atillabosma@student.hu.nl','Atilla Bosma',117,1,'V1F'),
	(1704662,'yosefm\'jati@student.hu.nl','Yosef M\'jati',64,1,'V1C'),
	(1704916,'chungwong@student.hu.nl','Chung Wong',91,1,'V1D'),
	(1705246,'sanderwiggers@student.hu.nl','Sander Wiggers',73,1,'V1C'),
	(1705290,'stangerritsen@student.hu.nl','Stan Gerritsen',60,1,'V1C'),
	(1705632,'michieldiederen@student.hu.nl','Michiel Diederen',95,1,'V1E'),
	(1705923,'rickblanksma@student.hu.nl','Rick Blanksma',116,1,'V1F'),
	(1705943,'douweschepers@student.hu.nl','Douwe Schepers',106,1,'V1E'),
	(1706021,'fransholwerda@student.hu.nl','Frans Holwerda',120,1,'V1F'),
	(1706363,'fazalpopkema@student.hu.nl','Fazal Popkema',67,1,'V1C'),
	(1706382,'cedricvoncken@student.hu.nl','Cedric Voncken',110,1,'V1E'),
	(1706387,'pimrheiter@student.hu.nl','Pim Rheiter',68,1,'V1C'),
	(1706971,'jorritstrikwerda@student.hu.nl','Jorrit Strikwerda',48,1,'V1A'),
	(1707132,'renskezandberg@student.hu.nl','Renske Zandberg',112,1,'V1E'),
	(1707233,'danielbusse@student.hu.nl','Daniel Busse',17,1,'V1B'),
	(1707245,'jasonposner@student.hu.nl','Jason Posner',45,1,'V1A'),
	(1707366,'nathanhaseth@student.hu.nl','Nathan Haseth',80,1,'V1D'),
	(1708687,'yorinouwerkerk@student.hu.nl','Yorin Ouwerkerk',66,1,'V1C'),
	(1709020,'jopcorver@student.hu.nl','Jop Corver',18,1,'V1B'),
	(1710273,'rubenjansen@student.hu.nl','Ruben Jansen',25,1,'V1B'),
	(1710334,'davidkok@student.hu.nl','David Kok',26,1,'V1B'),
	(1710457,'semvasiljan@student.hu.nl','Sem Vasiljan',72,1,'V1C'),
	(1710791,'azzeddineagrida@student.hu.nl','Azzeddine Agrida',54,1,'V1C'),
	(1710907,'robinklok@student.hu.nl','Robin Klok',83,1,'V1D'),
	(1710986,'chikintsang@student.hu.nl','Chi kin Tsang',50,1,'V1A'),
	(1711403,'shantkalaidjian@student.hu.nl','Shant Kalaidjian',123,1,'V1F'),
	(1711412,'jordibottema@student.hu.nl','Jordi Bottema',16,1,'V1B');

/*!40000 ALTER TABLE `persoon` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table rol
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rol`;

CREATE TABLE `rol` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `naam` enum('student','docent') NOT NULL DEFAULT 'student',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;

INSERT INTO `rol` (`id`, `naam`)
VALUES
	(1,'student'),
	(2,'docent');

/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL DEFAULT '',
  `password` varchar(11) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `username`, `password`)
VALUES
	(1,'AlexJongman','geheim'),
	(2,'AlexJongman','geheim'),
	(3,'JosvanReenen','geheim'),
	(4,'DickPronk','geheim'),
	(5,'Annemarijevan derMeer','geheim'),
	(6,'MartijnJansen','geheim'),
	(7,'JohnSmeets','geheim'),
	(8,'BartKuipers','geheim'),
	(9,'BartvanEijkelenburg','geheim'),
	(10,'PeterSchuler','geheim'),
	(11,'DietskeObbink','geheim'),
	(12,'PetervanRooijen','geheim'),
	(13,'BlomBoris','geheim'),
	(14,'BlomBoris','geheim'),
	(15,'BosmanMarc','geheim'),
	(16,'BottemaJordi','geheim'),
	(17,'BusseDaniel','geheim'),
	(18,'CorverJop','geheim'),
	(19,'DaalVincent','geheim'),
	(20,'DijkwelPatrick','geheim'),
	(21,'HiemstraBart','geheim'),
	(22,'HioeDonald','geheim'),
	(23,'IrgolitschFrans','geheim'),
	(24,'JaarsmaSijmen','geheim'),
	(25,'JansenRuben','geheim'),
	(26,'KokDavid','geheim'),
	(27,'KorringaYannick','geheim'),
	(28,'KrijgsmanMatthias','geheim'),
	(29,'LokChanwai','geheim'),
	(30,'MertensIgor','geheim'),
	(31,'SchoenmakersLuuk','geheim'),
	(32,'SmitsPim','geheim'),
	(33,'StokerBram','geheim'),
	(34,'WijkstraMichel','geheim'),
	(35,'AaltenRobin','geheim'),
	(36,'BrasserAlex','geheim'),
	(37,'CheungKinYueng','geheim'),
	(38,'FischerKoen','geheim'),
	(39,'HensbergenDiesmer','geheim'),
	(40,'KonijnStef','geheim'),
	(41,'KorevaarThomas','geheim'),
	(42,'MeijerHilbrand','geheim'),
	(43,'MohammadPasoonPopalPasoon','geheim'),
	(44,'OsterhausMatthijs','geheim'),
	(45,'PosnerJason','geheim'),
	(46,'RoosDoeke','geheim'),
	(47,'SteinmannMasha','geheim'),
	(48,'StrikwerdaJorrit','geheim'),
	(49,'TerwanSten','geheim'),
	(50,'TsangChikin','geheim'),
	(51,'VinkLarsse','geheim'),
	(52,'VoorburgLise','geheim'),
	(53,'AdriaansenLennart','geheim'),
	(54,'AgridaAzzeddine','geheim'),
	(55,'BellazghariMarwan','geheim'),
	(56,'BoerFabio','geheim'),
	(57,'BouzidRedouan','geheim'),
	(58,'DurraniXaland','geheim'),
	(59,'FrenkelWester','geheim'),
	(60,'GerritsenStan','geheim'),
	(61,'HendrikseDavid','geheim'),
	(62,'KamalKamal','geheim'),
	(63,'KottmanPatrick','geheim'),
	(64,'M\'jatiYosef','geheim'),
	(65,'MostertDanny','geheim'),
	(66,'OuwerkerkYorin','geheim'),
	(67,'PopkemaFazal','geheim'),
	(68,'RheiterPim','geheim'),
	(69,'RitsemaRobbert','geheim'),
	(70,'SikkensRuben','geheim'),
	(71,'SluijkDany','geheim'),
	(72,'VasiljanSem','geheim'),
	(73,'WiggersSander','geheim'),
	(74,'WijsmanSjors','geheim'),
	(75,'WilkesJustin','geheim'),
	(76,'AshbyOwen','geheim'),
	(77,'DekkersJan','geheim'),
	(78,'GlastraTimo','geheim'),
	(79,'GoessensAna','geheim'),
	(80,'HasethNathan','geheim'),
	(81,'Henstra-HillBas','geheim'),
	(82,'HuijgensLucca','geheim'),
	(83,'KlokRobin','geheim'),
	(84,'MocellinThomas','geheim'),
	(85,'MorssinkhofSam','geheim'),
	(86,'SmitJotte','geheim'),
	(87,'StekelenburgKarim','geheim'),
	(88,'WarsameDahir','geheim'),
	(89,'WielkensMonisha','geheim'),
	(90,'WindtNick','geheim'),
	(91,'WongChung','geheim'),
	(92,'AbdoelShafie','geheim'),
	(93,'BakkerMartijn','geheim'),
	(94,'DaalhuisenNiels','geheim'),
	(95,'DiederenMichiel','geheim'),
	(96,'HenkesWessel','geheim'),
	(97,'HolslagRuben','geheim'),
	(98,'HoogelandTim','geheim'),
	(99,'HouwelingMeifeng','geheim'),
	(100,'KasapYasin','geheim'),
	(101,'KosLourens','geheim'),
	(102,'LanserMark','geheim'),
	(103,'LoomanJerry','geheim'),
	(104,'MooyMichiel','geheim'),
	(105,'MuddeEzri','geheim'),
	(106,'SchepersDouwe','geheim'),
	(107,'SmithjesGuylian','geheim'),
	(108,'SteenbrinkSteven','geheim'),
	(109,'VerkerkJeroen','geheim'),
	(110,'VonckenCedric','geheim'),
	(111,'VrugginkSam','geheim'),
	(112,'ZandbergRenske','geheim'),
	(113,'AchterbergJan','geheim'),
	(114,'ArissenRobert','geheim'),
	(115,'BalkKevin','geheim'),
	(116,'BlanksmaRick','geheim'),
	(117,'BosmaAtilla','geheim'),
	(118,'BrouwerTies','geheim'),
	(119,'HartogTies','geheim'),
	(120,'HolwerdaFrans','geheim'),
	(121,'HuWenfrie','geheim'),
	(122,'JamanikaJustin','geheim'),
	(123,'KalaidjianShant','geheim'),
	(124,'KhaliliKhalili','geheim'),
	(125,'MenningsPascal','geheim'),
	(126,'MinnaardDevin','geheim'),
	(127,'ReusDani?l','geheim'),
	(128,'TempertRobin','geheim'),
	(129,'TichattibinSoufian','geheim'),
	(130,'VeldkampDani?l','geheim');

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table vak
# ------------------------------------------------------------

DROP TABLE IF EXISTS `vak`;

CREATE TABLE `vak` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(15) DEFAULT NULL,
  `naam` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

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
