# ************************************************************
# AbsentieSysteem database initializer
# Version 0.1 (beta)
# https://github.com/GP2017-Absentie/Java_back-end
#
# Database: AbsentieSys
# ************************************************************


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
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



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
  `klas_FK` int(11) unsigned NOT NULL,
  `docent_FK` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `les_klas_FK` (`klas_FK`),
  KEY `les_persoon_FK` (`docent_FK`),
  KEY `les_lokaal_FK` (`lokaal_FK`),
  KEY `les_vak_FK` (`vak_FK`),
  CONSTRAINT `les_klas_FK` FOREIGN KEY (`klas_FK`) REFERENCES `klas` (`id`),
  CONSTRAINT `les_lokaal_FK` FOREIGN KEY (`lokaal_FK`) REFERENCES `lokaal` (`id`),
  CONSTRAINT `les_persoon_FK` FOREIGN KEY (`docent_FK`) REFERENCES `persoon` (`id`),
  CONSTRAINT `les_vak_FK` FOREIGN KEY (`vak_FK`) REFERENCES `vak` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table lokaal
# ------------------------------------------------------------

DROP TABLE IF EXISTS `lokaal`;

CREATE TABLE `lokaal` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `gebouw` varchar(10) DEFAULT NULL,
  `nummer` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table persoon
# ------------------------------------------------------------

DROP TABLE IF EXISTS `persoon`;

CREATE TABLE `persoon` (
  `id` int(11) unsigned NOT NULL,
  `email` varchar(25) NOT NULL DEFAULT '',
  `naam` varchar(30) DEFAULT NULL,
  `user_FK` int(11) unsigned NOT NULL,
  `rol_FK` int(11) unsigned NOT NULL,
  `klas_FK` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `persoon_klas_FK` FOREIGN KEY (`id`) REFERENCES `klas` (`id`),
  CONSTRAINT `persoon_rol_FK` FOREIGN KEY (`id`) REFERENCES `rol` (`id`),
  CONSTRAINT `persoon_user_FK` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table rol
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rol`;

CREATE TABLE `rol` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `naam` enum('student','docent') NOT NULL DEFAULT 'student',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(15) NOT NULL DEFAULT '',
  `password` varchar(11) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table vak
# ------------------------------------------------------------

DROP TABLE IF EXISTS `vak`;

CREATE TABLE `vak` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(15) DEFAULT NULL,
  `naam` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;