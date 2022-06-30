SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP DATABASE IF EXISTS `emrdb`;
CREATE DATABASE `emrdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `emrdb`;

DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age` int NOT NULL,
  `last_visit_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `patient` (`id`, `age`, `last_visit_date`, `name`) VALUES
(1,	22,	'1996-02-01 02:32:43',	'Melodi Collins PhD'),
(2,	77,	'1989-07-22 14:29:31',	'Jarrod Treutel'),
(3,	82,	'1964-12-22 04:51:10',	'Mr. Bonnie Koch'),
(4,	53,	'1959-04-23 14:05:23',	'Adriana Stroman DDS'),
(5,	9,	'1990-06-21 15:09:19',	'Noreen Weissnat IV'),
(6,	64,	'1985-11-22 15:25:50',	'Kyle Mills IV'),
(7,	38,	'1986-12-24 08:13:21',	'Mr. German Ullrich'),
(8,	14,	'1995-05-30 10:47:24',	'Santos Wilderman Sr.'),
(9,	73,	'1974-01-28 05:47:22',	'Romaine Carroll IV'),
(10,	82,	'1983-05-16 12:19:18',	'Eura Haag'),
(11,	34,	'1964-04-21 08:43:22',	'Naomi Reilly'),
(12,	30,	'1996-06-12 16:13:24',	'Belen Kovacek'),
(13,	78,	'1999-05-11 02:41:18',	'Curt Jaskolski'),
(14,	69,	'1978-01-12 22:00:19',	'Dr. Ahmad Kreiger'),
(15,	45,	'1984-05-29 03:35:08',	'Percy Kuhn'),
(16,	60,	'1966-07-18 11:06:38',	'Mr. Reyes Dickinson'),
(17,	20,	'1993-12-06 07:07:46',	'Ezequiel Sanford'),
(18,	28,	'1983-08-06 20:23:27',	'Brigida Brown'),
(19,	26,	'1966-05-08 15:27:19',	'Manie Reichel'),
(20,	37,	'1989-03-20 04:55:52',	'Carmelo Abshire I'),
(21,	34,	'1983-10-23 13:47:51',	'Lanelle Considine'),
(22,	50,	'1961-03-19 22:56:20',	'Charmain Hayes'),
(23,	64,	'1994-05-06 17:16:31',	'Miss Olinda Considine'),
(24,	47,	'2003-08-14 14:50:49',	'Chantelle Runte'),
(25,	81,	'1958-07-25 17:58:50',	'Ms. Clint Krajcik'),
(26,	5,	'1964-09-15 19:32:40',	'Denise Donnelly'),
(27,	32,	'1974-06-10 03:47:03',	'Adina Langworth Sr.'),
(28,	76,	'1971-03-04 12:55:50',	'Coleen Homenick'),
(29,	46,	'2001-12-07 12:33:08',	'Exie Hane'),
(30,	80,	'1965-11-16 22:43:27',	'Mr. Jose Reinger'),
(31,	3,	'1983-08-02 20:17:58',	'Anna Johns'),
(32,	10,	'1977-10-26 23:06:34',	'Alfredo Sipes'),
(33,	67,	'1957-10-21 08:04:24',	'Leonel Wolf'),
(34,	49,	'1993-08-03 22:12:19',	'Miss Ronna Tromp'),
(35,	58,	'1993-01-07 20:24:04',	'Eduardo Conn'),
(36,	30,	'1957-12-22 00:04:21',	'Tinisha McLaughlin'),
(37,	72,	'1962-03-31 14:23:03',	'Tennille Greenholt'),
(38,	58,	'1975-03-06 14:44:02',	'Ramon Heidenreich'),
(39,	24,	'1974-05-01 12:48:08',	'Mrs. Valeria Kunde'),
(40,	44,	'1970-09-10 11:45:27',	'Antony Rutherford'),
(41,	51,	'1982-04-22 10:28:11',	'Delpha Swift'),
(42,	40,	'1988-12-28 10:48:52',	'Mammie Howell'),
(43,	52,	'1970-10-19 00:04:41',	'Blair Jones Sr.'),
(44,	70,	'1969-01-05 12:55:18',	'Olive Lynch'),
(45,	36,	'1968-06-05 01:51:02',	'Audria Cruickshank'),
(46,	44,	'1998-08-15 12:10:41',	'Marita Wiegand MD'),
(47,	39,	'1972-08-16 08:40:33',	'Moises Ernser'),
(48,	27,	'1971-11-13 01:49:57',	'Mrs. Houston Schamberger'),
(49,	9,	'1961-07-25 21:16:02',	'Alla Gutmann III'),
(50,	21,	'1992-10-04 04:12:12',	'Theresa Aufderhar'),
(51,	58,	'1963-03-08 08:46:59',	'Rob Kemmer'),
(52,	83,	'1970-04-10 04:46:58',	'Jacob Reilly'),
(53,	29,	'1987-09-10 17:14:11',	'Deedra Weimann'),
(54,	40,	'1974-11-17 20:47:38',	'Eliz Pacocha'),
(55,	22,	'1977-02-26 21:17:56',	'Ardith Wiza'),
(56,	42,	'2001-10-12 14:42:02',	'Wes Hamill PhD'),
(57,	3,	'1986-10-25 07:00:38',	'Kendrick Wunsch'),
(58,	58,	'1988-12-25 09:18:25',	'Jenny Abernathy'),
(59,	30,	'1970-09-14 03:27:32',	'Mr. Michel Howell'),
(60,	22,	'1973-02-03 13:55:40',	'Kayleigh Johnson'),
(61,	18,	'1966-11-27 23:33:19',	'Dale Batz Sr.'),
(62,	83,	'1970-09-13 08:33:23',	'Rea Donnelly Jr.'),
(63,	40,	'2003-10-18 23:11:01',	'Dewitt Adams'),
(64,	17,	'1990-05-18 02:03:36',	'Meda Hoppe'),
(65,	73,	'1986-04-02 10:13:32',	'Jude Borer'),
(66,	39,	'1967-01-01 00:31:51',	'Deedee Schmeler Sr.'),
(67,	80,	'1966-01-23 13:02:41',	'Tyrell Daniel'),
(68,	17,	'1957-11-10 05:23:53',	'Shalonda Feeney'),
(69,	55,	'1959-01-11 14:53:43',	'Kareen Langosh'),
(70,	41,	'1991-01-21 06:30:50',	'Larry McLaughlin'),
(71,	37,	'1998-08-23 19:19:53',	'Dr. Birdie Steuber'),
(72,	79,	'1958-10-23 08:06:05',	'Miss Brittni Konopelski'),
(73,	34,	'1995-12-11 23:41:10',	'Eldon Okuneva IV'),
(74,	65,	'1981-10-09 06:32:09',	'Darrick Johns'),
(75,	62,	'1998-04-17 02:41:43',	'Karole Hilpert'),
(76,	34,	'1990-06-01 02:55:19',	'Stewart Spinka'),
(77,	12,	'1986-11-14 04:02:47',	'Quentin Upton'),
(78,	75,	'1998-02-12 02:14:16',	'Corrine Runolfsdottir MD'),
(79,	79,	'1983-10-04 18:42:57',	'Ross Gulgowski'),
(80,	48,	'1986-05-30 03:49:58',	'Caryn Shanahan'),
(81,	72,	'1989-01-31 14:58:19',	'Ruby Ankunding'),
(82,	28,	'1995-05-07 11:59:42',	'Frederic Monahan'),
(83,	38,	'1990-11-02 12:09:48',	'Nona Spencer'),
(84,	33,	'1998-10-25 00:34:34',	'Brett Hartmann'),
(85,	13,	'1970-05-25 01:48:04',	'Hermila Goodwin'),
(86,	57,	'1974-12-16 10:50:58',	'Nathanial Wiegand'),
(87,	1,	'1990-06-18 20:06:32',	'Matt Hilpert'),
(88,	73,	'1994-09-15 07:32:44',	'Gary Walker'),
(89,	40,	'1993-07-26 12:41:23',	'Alan Medhurst'),
(90,	85,	'1976-02-12 14:10:45',	'Enoch Cremin IV'),
(91,	55,	'1965-11-03 00:53:50',	'Denisse Heller'),
(92,	21,	'1996-04-12 00:10:04',	'Miss Stamm'),
(93,	80,	'1963-04-15 13:29:27',	'Norma Runolfsdottir'),
(94,	49,	'1969-04-30 20:14:51',	'Reinaldo Kozey'),
(95,	54,	'1986-03-18 09:06:52',	'Berniece Rath'),
(96,	48,	'1980-11-12 06:44:16',	'Catarina Torp'),
(97,	29,	'2001-04-22 07:39:14',	'Juliette Schinner'),
(98,	79,	'1998-05-16 21:52:18',	'Ivory McClure I'),
(99,	43,	'1986-09-18 06:18:57',	'Xavier Auer'),
(100,	17,	'1973-03-14 06:10:35',	'Lakisha Marks');

DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `registration_date` date DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_oqjpmd6vmaeisopewtdsxq630` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `staff` (`id`, `name`, `registration_date`, `uuid`) VALUES
(1,	'Hane Doe',	'2022-06-29',	'b1586c92-26fe-4aaa-91dc-86780bb1a224');

-- 2022-06-30 12:37:07