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
	(1,'jos.vanreenen@hu.nl','Jos van Reenen',2,2,NULL),
	(2,'dick.pronk@hu.nl','Dick Pronk',3,2,NULL),
	(3,'annemarije.vandermeer@hu.nl','Annemarije van der Meer',4,2,NULL),
	(4,'martijn.jansen@hu.nl','Martijn Jansen',5,2,NULL),
	(5,'john.smeets@hu.nl','John Smeets',6,2,NULL),
	(6,'bart.kuipers@hu.nl','Bart Kuipers',7,2,NULL),
	(7,'bart.vaneijkelenburg@hu.nl','Bart van Eijkelenburg',8,2,NULL),
	(8,'peter.schuler@hu.nl','Peter Schuler',9,2,NULL),
	(9,'dietske.obbink@hu.nl','Dietske Obbink',10,2,NULL),
	(10,'peter.vanrooijen@hu.nl','Peter van Rooijen',11,2,NULL),
	(1595603,'pascalmennings@student.hu.nl','Pascal Mennings',123,1,'V1F'),
	(1610525,'sammorssinkhof@student.hu.nl','Sam Morssinkhof',83,1,'V1D'),
	(1611115,'dani?lreus@student.hu.nl','Dani?l Reus',125,1,'V1F'),
	(1621699,'yannickkorringa@student.hu.nl','Yannick Korringa',43,1,'V1B'),
	(1630766,'jottesmit@student.hu.nl','Jotte Smit',84,1,'V1D'),
	(1636604,'kevinbalk@student.hu.nl','Kevin Balk',113,1,'V1F'),
	(1640545,'lennartadriaansen@student.hu.nl','Lennart Adriaansen',51,1,'V1C'),
	(1656824,'dani?lveldkamp@student.hu.nl','Dani?l Veldkamp',128,1,'V1F'),
	(1657627,'rubenholslag@student.hu.nl','Ruben Holslag',95,1,'V1E'),
	(1658341,'barthiemstra@student.hu.nl','Bart Hiemstra',37,1,'V1B'),
	(1658950,'marklanser@student.hu.nl','Mark Lanser',100,1,'V1E'),
	(1660019,'westerfrenkel@student.hu.nl','Wester Frenkel',57,1,'V1C'),
	(1662367,'diesmerhensbergen@student.hu.nl','Diesmer Hensbergen',16,1,'V1A'),
	(1664007,'sijmenjaarsma@student.hu.nl','Sijmen Jaarsma',40,1,'V1B'),
	(1665013,'guyliansmithjes@student.hu.nl','Guylian Smithjes',105,1,'V1E'),
	(1668229,'michielmooy@student.hu.nl','Michiel Mooy',102,1,'V1E'),
	(1674604,'dahirwarsame@student.hu.nl','Dahir Warsame',86,1,'V1D'),
	(1676955,'owenashby@student.hu.nl','Owen Ashby',74,1,'V1D'),
	(1679241,'vincentdaal@student.hu.nl','Vincent Daal',35,1,'V1B'),
	(1679641,'devinminnaard@student.hu.nl','Devin Minnaard',124,1,'V1F'),
	(1679959,'soufiantichattibin@student.hu.nl','Soufian Tichattibin',127,1,'V1F'),
	(1682045,'robinaalten@student.hu.nl','Robin Aalten',12,1,'V1A'),
	(1682362,'matthijsosterhaus@student.hu.nl','Matthijs Osterhaus',21,1,'V1A'),
	(1682488,'karimstekelenburg@student.hu.nl','Karim Stekelenburg',85,1,'V1D'),
	(1683065,'bramstoker@student.hu.nl','Bram Stoker',49,1,'V1B'),
	(1683203,'monishawielkens@student.hu.nl','Monisha Wielkens',87,1,'V1D'),
	(1684011,'borisblom@student.hu.nl','Boris Blom',30,1,'V1B'),
	(1684145,'doekeroos@student.hu.nl','Doeke Roos',23,1,'V1A'),
	(1684742,'rubensikkens@student.hu.nl','Ruben Sikkens',68,1,'V1C'),
	(1684994,'jeroenverkerk@student.hu.nl','Jeroen Verkerk',107,1,'V1E'),
	(1686664,'timoglastra@student.hu.nl','Timo Glastra',76,1,'V1D'),
	(1693444,'mashasteinmann@student.hu.nl','Masha Steinmann',24,1,'V1A'),
	(1693749,'xalanddurrani@student.hu.nl','Xaland Durrani',56,1,'V1C'),
	(1694018,'fransirgolitsch@student.hu.nl','Frans Irgolitsch',39,1,'V1B'),
	(1694069,'stenterwan@student.hu.nl','Sten Terwan',26,1,'V1A'),
	(1694570,'igormertens@student.hu.nl','Igor Mertens',46,1,'V1B'),
	(1694680,'patrickkottman@student.hu.nl','Patrick Kottman',61,1,'V1C'),
	(1694921,'danysluijk@student.hu.nl','Dany Sluijk',69,1,'V1C'),
	(1695070,'lisevoorburg@student.hu.nl','Lise Voorburg',29,1,'V1A'),
	(1696191,'khalilikhalili@student.hu.nl','Khalili Khalili',122,1,'V1F'),
	(1696388,'michelwijkstra@student.hu.nl','Michel Wijkstra',50,1,'V1B'),
	(1696399,'pimsmits@student.hu.nl','Pim Smits',48,1,'V1B'),
	(1696546,'samvruggink@student.hu.nl','Sam Vruggink',109,1,'V1E'),
	(1696604,'justinjamanika@student.hu.nl','Justin Jamanika',120,1,'V1F'),
	(1696814,'yasinkasap@student.hu.nl','Yasin Kasap',98,1,'V1E'),
	(1696961,'matthiaskrijgsman@student.hu.nl','Matthias Krijgsman',44,1,'V1B'),
	(1697304,'jandekkers@student.hu.nl','Jan Dekkers',75,1,'V1D'),
	(1697992,'dannymostert@student.hu.nl','Danny Mostert',63,1,'V1C'),
	(1698194,'nielsdaalhuisen@student.hu.nl','Niels Daalhuisen',92,1,'V1E'),
	(1698199,'robintempert@student.hu.nl','Robin Tempert',126,1,'V1F'),
	(1698311,'wesselhenkes@student.hu.nl','Wessel Henkes',94,1,'V1E'),
	(1698454,'davidhendrikse@student.hu.nl','David Hendrikse',59,1,'V1C'),
	(1698603,'robertarissen@student.hu.nl','Robert Arissen',112,1,'V1F'),
	(1698848,'donaldhioe@student.hu.nl','Donald Hioe',38,1,'V1B'),
	(1698919,'stefkonijn@student.hu.nl','Stef Konijn',17,1,'V1A'),
	(1699137,'justinwilkes@student.hu.nl','Justin Wilkes',73,1,'V1C'),
	(1699291,'meifenghouweling@student.hu.nl','Meifeng Houweling',97,1,'V1E'),
	(1699599,'thomasmocellin@student.hu.nl','Thomas Mocellin',82,1,'V1D'),
	(1699627,'koenfischer@student.hu.nl','Koen Fischer',15,1,'V1A'),
	(1699882,'luccahuijgens@student.hu.nl','Lucca Huijgens',80,1,'V1D'),
	(1700011,'pasoonmohammadpasoonpopal@student.hu.nl','Pasoon Mohammad Pasoon Popal',20,1,'V1A'),
	(1701957,'ezrimudde@student.hu.nl','Ezri Mudde',103,1,'V1E'),
	(1702039,'kamalkamal@student.hu.nl','Kamal Kamal',60,1,'V1C'),
	(1702059,'patrickdijkwel@student.hu.nl','Patrick Dijkwel',36,1,'V1B'),
	(1702165,'fabioboer@student.hu.nl','Fabio Boer',54,1,'V1C'),
	(1702167,'wenfriehu@student.hu.nl','Wenfrie Hu',119,1,'V1F'),
	(1702255,'janachterberg@student.hu.nl','Jan Achterberg',111,1,'V1F'),
	(1702265,'shafieabdoel@student.hu.nl','Shafie Abdoel',90,1,'V1E'),
	(1702410,'marcbosman@student.hu.nl','Marc Bosman',31,1,'V1B'),
	(1702431,'kinyuengcheung@student.hu.nl','Kin Yueng Cheung',14,1,'V1A'),
	(1702471,'redouanbouzid@student.hu.nl','Redouan Bouzid',55,1,'V1C'),
	(1702563,'chanwailok@student.hu.nl','Chanwai Lok',45,1,'V1B'),
	(1702623,'stevensteenbrink@student.hu.nl','Steven Steenbrink',106,1,'V1E'),
	(1702657,'tiesbrouwer@student.hu.nl','Ties Brouwer',116,1,'V1F'),
	(1702709,'sjorswijsman@student.hu.nl','Sjors Wijsman',72,1,'V1C'),
	(1702730,'bashenstra-hill@student.hu.nl','Bas Henstra-Hill',79,1,'V1D'),
	(1702834,'thomaskorevaar@student.hu.nl','Thomas Korevaar',18,1,'V1A'),
	(1702987,'hilbrandmeijer@student.hu.nl','Hilbrand Meijer',19,1,'V1A'),
	(1703001,'tieshartog@student.hu.nl','Ties Hartog',117,1,'V1F'),
	(1703015,'robbertritsema@student.hu.nl','Robbert Ritsema',67,1,'V1C'),
	(1703198,'luukschoenmakers@student.hu.nl','Luuk Schoenmakers',47,1,'V1B'),
	(1703351,'marwanbellazghari@student.hu.nl','Marwan Bellazghari',53,1,'V1C'),
	(1703385,'timhoogeland@student.hu.nl','Tim Hoogeland',96,1,'V1E'),
	(1703444,'alexbrasser@student.hu.nl','Alex Brasser',13,1,'V1A'),
	(1703506,'anagoessens@student.hu.nl','Ana Goessens',77,1,'V1D'),
	(1703511,'lourenskos@student.hu.nl','Lourens Kos',99,1,'V1E'),
	(1703679,'nickwindt@student.hu.nl','Nick Windt',88,1,'V1D'),
	(1704102,'martijnbakker@student.hu.nl','Martijn Bakker',91,1,'V1E'),
	(1704271,'jerrylooman@student.hu.nl','Jerry Looman',101,1,'V1E'),
	(1704319,'larssevink@student.hu.nl','Larsse Vink',28,1,'V1A'),
	(1704365,'atillabosma@student.hu.nl','Atilla Bosma',115,1,'V1F'),
	(1704662,'yosefm\'jati@student.hu.nl','Yosef M\'jati',62,1,'V1C'),
	(1704916,'chungwong@student.hu.nl','Chung Wong',89,1,'V1D'),
	(1705246,'sanderwiggers@student.hu.nl','Sander Wiggers',71,1,'V1C'),
	(1705290,'stangerritsen@student.hu.nl','Stan Gerritsen',58,1,'V1C'),
	(1705632,'michieldiederen@student.hu.nl','Michiel Diederen',93,1,'V1E'),
	(1705923,'rickblanksma@student.hu.nl','Rick Blanksma',114,1,'V1F'),
	(1705943,'douweschepers@student.hu.nl','Douwe Schepers',104,1,'V1E'),
	(1706021,'fransholwerda@student.hu.nl','Frans Holwerda',118,1,'V1F'),
	(1706363,'fazalpopkema@student.hu.nl','Fazal Popkema',65,1,'V1C'),
	(1706382,'cedricvoncken@student.hu.nl','Cedric Voncken',108,1,'V1E'),
	(1706387,'pimrheiter@student.hu.nl','Pim Rheiter',66,1,'V1C'),
	(1706971,'jorritstrikwerda@student.hu.nl','Jorrit Strikwerda',25,1,'V1A'),
	(1707132,'renskezandberg@student.hu.nl','Renske Zandberg',110,1,'V1E'),
	(1707233,'danielbusse@student.hu.nl','Daniel Busse',33,1,'V1B'),
	(1707245,'jasonposner@student.hu.nl','Jason Posner',22,1,'V1A'),
	(1707366,'nathanhaseth@student.hu.nl','Nathan Haseth',78,1,'V1D'),
	(1708687,'yorinouwerkerk@student.hu.nl','Yorin Ouwerkerk',64,1,'V1C'),
	(1709020,'jopcorver@student.hu.nl','Jop Corver',34,1,'V1B'),
	(1710273,'rubenjansen@student.hu.nl','Ruben Jansen',41,1,'V1B'),
	(1710334,'davidkok@student.hu.nl','David Kok',42,1,'V1B'),
	(1710457,'semvasiljan@student.hu.nl','Sem Vasiljan',70,1,'V1C'),
	(1710791,'azzeddineagrida@student.hu.nl','Azzeddine Agrida',52,1,'V1C'),
	(1710907,'robinklok@student.hu.nl','Robin Klok',81,1,'V1D'),
	(1710986,'chikintsang@student.hu.nl','Chi kin Tsang',27,1,'V1A'),
	(1711403,'shantkalaidjian@student.hu.nl','Shant Kalaidjian',121,1,'V1F'),
	(1711412,'jordibottema@student.hu.nl','Jordi Bottema',32,1,'V1B');

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


# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL DEFAULT '',
  `password` varchar(11) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `username`, `password`)
VALUES
	(1,'AlexJongman','geheim'),
	(2,'JosvanReenen','geheim'),
	(3,'DickPronk','geheim'),
	(4,'Annemarijevan derMeer','geheim'),
	(5,'MartijnJansen','geheim'),
	(6,'JohnSmeets','geheim'),
	(7,'BartKuipers','geheim'),
	(8,'BartvanEijkelenburg','geheim'),
	(9,'PeterSchuler','geheim'),
	(10,'DietskeObbink','geheim'),
	(11,'PetervanRooijen','geheim'),
	(12,'AaltenRobin','geheim'),
	(13,'BrasserAlex','geheim'),
	(14,'CheungKinYueng','geheim'),
	(15,'FischerKoen','geheim'),
	(16,'HensbergenDiesmer','geheim'),
	(17,'KonijnStef','geheim'),
	(18,'KorevaarThomas','geheim'),
	(19,'MeijerHilbrand','geheim'),
	(20,'MohammadPasoonPopalPasoon','geheim'),
	(21,'OsterhausMatthijs','geheim'),
	(22,'PosnerJason','geheim'),
	(23,'RoosDoeke','geheim'),
	(24,'SteinmannMasha','geheim'),
	(25,'StrikwerdaJorrit','geheim'),
	(26,'TerwanSten','geheim'),
	(27,'TsangChikin','geheim'),
	(28,'VinkLarsse','geheim'),
	(29,'VoorburgLise','geheim'),
	(30,'BlomBoris','geheim'),
	(31,'BosmanMarc','geheim'),
	(32,'BottemaJordi','geheim'),
	(33,'BusseDaniel','geheim'),
	(34,'CorverJop','geheim'),
	(35,'DaalVincent','geheim'),
	(36,'DijkwelPatrick','geheim'),
	(37,'HiemstraBart','geheim'),
	(38,'HioeDonald','geheim'),
	(39,'IrgolitschFrans','geheim'),
	(40,'JaarsmaSijmen','geheim'),
	(41,'JansenRuben','geheim'),
	(42,'KokDavid','geheim'),
	(43,'KorringaYannick','geheim'),
	(44,'KrijgsmanMatthias','geheim'),
	(45,'LokChanwai','geheim'),
	(46,'MertensIgor','geheim'),
	(47,'SchoenmakersLuuk','geheim'),
	(48,'SmitsPim','geheim'),
	(49,'StokerBram','geheim'),
	(50,'WijkstraMichel','geheim'),
	(51,'AdriaansenLennart','geheim'),
	(52,'AgridaAzzeddine','geheim'),
	(53,'BellazghariMarwan','geheim'),
	(54,'BoerFabio','geheim'),
	(55,'BouzidRedouan','geheim'),
	(56,'DurraniXaland','geheim'),
	(57,'FrenkelWester','geheim'),
	(58,'GerritsenStan','geheim'),
	(59,'HendrikseDavid','geheim'),
	(60,'KamalKamal','geheim'),
	(61,'KottmanPatrick','geheim'),
	(62,'M\'jatiYosef','geheim'),
	(63,'MostertDanny','geheim'),
	(64,'OuwerkerkYorin','geheim'),
	(65,'PopkemaFazal','geheim'),
	(66,'RheiterPim','geheim'),
	(67,'RitsemaRobbert','geheim'),
	(68,'SikkensRuben','geheim'),
	(69,'SluijkDany','geheim'),
	(70,'VasiljanSem','geheim'),
	(71,'WiggersSander','geheim'),
	(72,'WijsmanSjors','geheim'),
	(73,'WilkesJustin','geheim'),
	(74,'AshbyOwen','geheim'),
	(75,'DekkersJan','geheim'),
	(76,'GlastraTimo','geheim'),
	(77,'GoessensAna','geheim'),
	(78,'HasethNathan','geheim'),
	(79,'Henstra-HillBas','geheim'),
	(80,'HuijgensLucca','geheim'),
	(81,'KlokRobin','geheim'),
	(82,'MocellinThomas','geheim'),
	(83,'MorssinkhofSam','geheim'),
	(84,'SmitJotte','geheim'),
	(85,'StekelenburgKarim','geheim'),
	(86,'WarsameDahir','geheim'),
	(87,'WielkensMonisha','geheim'),
	(88,'WindtNick','geheim'),
	(89,'WongChung','geheim'),
	(90,'AbdoelShafie','geheim'),
	(91,'BakkerMartijn','geheim'),
	(92,'DaalhuisenNiels','geheim'),
	(93,'DiederenMichiel','geheim'),
	(94,'HenkesWessel','geheim'),
	(95,'HolslagRuben','geheim'),
	(96,'HoogelandTim','geheim'),
	(97,'HouwelingMeifeng','geheim'),
	(98,'KasapYasin','geheim'),
	(99,'KosLourens','geheim'),
	(100,'LanserMark','geheim'),
	(101,'LoomanJerry','geheim'),
	(102,'MooyMichiel','geheim'),
	(103,'MuddeEzri','geheim'),
	(104,'SchepersDouwe','geheim'),
	(105,'SmithjesGuylian','geheim'),
	(106,'SteenbrinkSteven','geheim'),
	(107,'VerkerkJeroen','geheim'),
	(108,'VonckenCedric','geheim'),
	(109,'VrugginkSam','geheim'),
	(110,'ZandbergRenske','geheim'),
	(111,'AchterbergJan','geheim'),
	(112,'ArissenRobert','geheim'),
	(113,'BalkKevin','geheim'),
	(114,'BlanksmaRick','geheim'),
	(115,'BosmaAtilla','geheim'),
	(116,'BrouwerTies','geheim'),
	(117,'HartogTies','geheim'),
	(118,'HolwerdaFrans','geheim'),
	(119,'HuWenfrie','geheim'),
	(120,'JamanikaJustin','geheim'),
	(121,'KalaidjianShant','geheim'),
	(122,'KhaliliKhalili','geheim'),
	(123,'MenningsPascal','geheim'),
	(124,'MinnaardDevin','geheim'),
	(125,'ReusDani?l','geheim'),
	(126,'TempertRobin','geheim'),
	(127,'TichattibinSoufian','geheim'),
	(128,'VeldkampDani?l','geheim');

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
