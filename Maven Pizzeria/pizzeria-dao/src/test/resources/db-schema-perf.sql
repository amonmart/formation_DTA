DROP TABLE IF EXISTS `performance`;
CREATE TABLE IF NOT EXISTS `performance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `service` varchar(255) DEFAULT NULL,
  `tempsExec` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
)