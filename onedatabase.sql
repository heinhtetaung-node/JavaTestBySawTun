/*
SQLyog Ultimate v12.09 (32 bit)
MySQL - 5.7.12-log : Database - myfirst
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`myfirst` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `myfirst`;

/*Table structure for table `academic_year` */

DROP TABLE IF EXISTS `academic_year`;

CREATE TABLE `academic_year` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `academic_year` */

insert  into `academic_year`(`id`,`name`) values (1,'saw tun'),(2,'2013'),(3,'fggfd');

/*Table structure for table `invoice` */

DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `total` int(15) DEFAULT NULL,
  `ofitem` int(15) DEFAULT NULL,
  `invoicename` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `invoice` */

insert  into `invoice`(`id`,`total`,`ofitem`,`invoicename`) values (14,13510,450,'sss'),(15,995,33,'ss'),(16,784,34,'ss');

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `join_Date` datetime DEFAULT NULL,
  `job` varchar(20) DEFAULT NULL,
  `salary` int(20) DEFAULT NULL,
  `experience` varchar(20) DEFAULT NULL,
  `degree` varchar(20) DEFAULT NULL,
  `diploma` varchar(20) DEFAULT NULL,
  `age` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `member` */

insert  into `member`(`id`,`name`,`join_Date`,`job`,`salary`,`experience`,`degree`,`diploma`,`age`,`phone`,`address`) values (1,'ss',NULL,'p',33,'3','gghg','gd','55','76','ygn');

/*Table structure for table `record` */

DROP TABLE IF EXISTS `record`;

CREATE TABLE `record` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `degree` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `job` varchar(20) DEFAULT NULL,
  `salary` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `record` */

insert  into `record`(`id`,`name`,`degree`,`address`,`phone`,`job`,`salary`) values (1,'ss','philosophy','ygn','09420020198','programmer',22222),(2,'saw','English','ygn','098','programmer',987),(3,'fdd','zzc','fsf','afasf','ZFZ',33435);

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `test` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
