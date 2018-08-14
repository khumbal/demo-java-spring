# demo-java-spring
* Spring 3.0.7.RELEAS
* MySQL 5.1.9
* Hibernate 3.3.2
* JSTL



### App Server
> Run on tomcat 7


### Create Database
```sql
CREATE DATABASE IF NOT EXISTS `demoproject` DEFAULT CHARACTER SET utf8;

USE `demoproject`;

/*Table structure for table `country` */
CREATE TABLE `country` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*Data for the table `country` */
INSERT  INTO `country`(`id`,`name`) VALUES 
(1,'Thai'),
(2,'Eng');

/*Table structure for table `user` */
CREATE TABLE `user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) DEFAULT NULL,
  `country` INT(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```
