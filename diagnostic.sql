-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema diagnostic
--

CREATE DATABASE IF NOT EXISTS diagnostic;
USE diagnostic;

--
-- Definition of table `accountant`
--

DROP TABLE IF EXISTS `accountant`;
CREATE TABLE `accountant` (
  `aid` int(10) unsigned NOT NULL auto_increment,
  `emailid` varchar(45) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  PRIMARY KEY  (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accountant`
--

/*!40000 ALTER TABLE `accountant` DISABLE KEYS */;
INSERT INTO `accountant` (`aid`,`emailid`,`fname`,`lname`,`gender`,`address`) VALUES 
 (1,'sr@gmail.com','sss','rrr','Male','Dhaka');
/*!40000 ALTER TABLE `accountant` ENABLE KEYS */;


--
-- Definition of table `addmission`
--

DROP TABLE IF EXISTS `addmission`;
CREATE TABLE `addmission` (
  `addid` int(10) unsigned NOT NULL auto_increment,
  `roomid` int(10) unsigned default NULL,
  `pid` int(10) unsigned default NULL,
  `addmissiondate` date default NULL,
  `numberofday` int(10) unsigned default NULL,
  `description` varchar(255) default NULL,
  `cost` double default NULL,
  `pname` varchar(45) default NULL,
  `roomtype` varchar(45) default NULL,
  `status` varchar(45) default NULL,
  `totalcost` double default NULL,
  `billstatus` varchar(45) default NULL,
  PRIMARY KEY  (`addid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `addmission`
--

/*!40000 ALTER TABLE `addmission` DISABLE KEYS */;
INSERT INTO `addmission` (`addid`,`roomid`,`pid`,`addmissiondate`,`numberofday`,`description`,`cost`,`pname`,`roomtype`,`status`,`totalcost`,`billstatus`) VALUES 
 (1,1,1,'2018-12-13',4,'asdfasdfasdfasdfasdfasdf',50000,NULL,'Non-AC,sakibul','Available',0,NULL),
 (2,1,2,'2018-12-13',5,'asfd',50000,'sakibul','Non-AC','Available',250000,'True'),
 (3,1,5,'2018-12-15',5,'asdfasdfasdfasdfasdfasdf',50000,'sakibul','Non-AC','Available',250000,'True');
/*!40000 ALTER TABLE `addmission` ENABLE KEYS */;


--
-- Definition of table `appointments`
--

DROP TABLE IF EXISTS `appointments`;
CREATE TABLE `appointments` (
  `appointid` int(10) unsigned NOT NULL auto_increment,
  `pid` int(10) unsigned default NULL,
  `doctorid` int(10) unsigned default NULL,
  `appointdate` date default NULL,
  `appointstatus` varchar(45) default NULL,
  `problem` varchar(45) default NULL,
  `deptname` varchar(45) default NULL,
  `fees` double NOT NULL,
  `billstatus` varchar(45) NOT NULL,
  PRIMARY KEY  (`appointid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointments`
--

/*!40000 ALTER TABLE `appointments` DISABLE KEYS */;
INSERT INTO `appointments` (`appointid`,`pid`,`doctorid`,`appointdate`,`appointstatus`,`problem`,`deptname`,`fees`,`billstatus`) VALUES 
 (1,5,1,'2018-12-22','Ok','dasd','Neorology',600,'False'),
 (2,12,2,'2018-12-29','Pending','asdfa','Neorology',300,'False'),
 (3,12,2,'2018-12-29','Pending','kjhjh','Neorology',300,'False'),
 (4,5,1,'2018-12-28','Ok','adadfd','Neorology',600,'True'),
 (5,5,1,'2018-12-27','Pending','afdaf','Neorology',600,'True'),
 (6,5,1,'2018-12-28','Pending','asdfa','Neorology',600,'True');
/*!40000 ALTER TABLE `appointments` ENABLE KEYS */;


--
-- Definition of table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `deptid` int(10) unsigned NOT NULL auto_increment,
  `deptname` varchar(45) default NULL,
  `doctorid` int(10) unsigned default NULL,
  `description` varchar(100) default NULL,
  `status` varchar(45) default NULL,
  PRIMARY KEY  (`deptid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`deptid`,`deptname`,`doctorid`,`description`,`status`) VALUES 
 (5,'Neorology',0,'as;fdlkjsdslkf','Active'),
 (6,'assdf',0,'adfsdfass','1'),
 (7,'Cardiac',0,'Cardiology','Active');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;


--
-- Definition of table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `doctorid` int(10) unsigned NOT NULL auto_increment,
  `emailid` varchar(45) default NULL,
  `deptname` varchar(45) default NULL,
  `fname` varchar(45) default NULL,
  `lname` varchar(45) default NULL,
  `gender` varchar(45) default NULL,
  `age` varchar(45) default NULL,
  `address` varchar(45) default NULL,
  `experience` varchar(45) default NULL,
  `fee` double default NULL,
  PRIMARY KEY  (`doctorid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` (`doctorid`,`emailid`,`deptname`,`fname`,`lname`,`gender`,`age`,`address`,`experience`,`fee`) VALUES 
 (1,'rasel@gmail.com','Neorology','sakibul','haque','Male','25','Dhaka','5 years',600),
 (2,'sayeed@gmail.com','Neorology','tuhin','sayeed','Male','30','Dhaka','5 years',300),
 (3,'abc@abc.com','laj','skdfassk','kadfk','kas','12','kdf','4',500);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;


--
-- Definition of table `medecinegroup`
--

DROP TABLE IF EXISTS `medecinegroup`;
CREATE TABLE `medecinegroup` (
  `groupid` int(10) unsigned NOT NULL auto_increment,
  `groupname` varchar(45) NOT NULL,
  `groupdescription` varchar(100) NOT NULL,
  PRIMARY KEY  (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medecinegroup`
--

/*!40000 ALTER TABLE `medecinegroup` DISABLE KEYS */;
INSERT INTO `medecinegroup` (`groupid`,`groupname`,`groupdescription`) VALUES 
 (2,'abcde','adfa'),
 (3,'sdgf','sffsd');
/*!40000 ALTER TABLE `medecinegroup` ENABLE KEYS */;


--
-- Definition of table `medecinelist`
--

DROP TABLE IF EXISTS `medecinelist`;
CREATE TABLE `medecinelist` (
  `listid` int(10) unsigned NOT NULL auto_increment,
  `groupid` int(10) unsigned NOT NULL,
  `typeid` int(10) unsigned NOT NULL,
  `medecinename` varchar(100) default NULL,
  PRIMARY KEY  (`listid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medecinelist`
--

/*!40000 ALTER TABLE `medecinelist` DISABLE KEYS */;
INSERT INTO `medecinelist` (`listid`,`groupid`,`typeid`,`medecinename`) VALUES 
 (1,2,2,'Napaq'),
 (2,3,3,'sdfgsfd');
/*!40000 ALTER TABLE `medecinelist` ENABLE KEYS */;


--
-- Definition of table `medecinetype`
--

DROP TABLE IF EXISTS `medecinetype`;
CREATE TABLE `medecinetype` (
  `typeid` int(10) unsigned NOT NULL auto_increment,
  `typename` varchar(45) NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY  (`typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medecinetype`
--

/*!40000 ALTER TABLE `medecinetype` DISABLE KEYS */;
INSERT INTO `medecinetype` (`typeid`,`typename`,`description`) VALUES 
 (2,'abc','asdfasdff'),
 (3,'sdfss','sdfgsf');
/*!40000 ALTER TABLE `medecinetype` ENABLE KEYS */;


--
-- Definition of table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `pid` int(10) unsigned NOT NULL auto_increment,
  `emailid` varchar(45) NOT NULL,
  `fname` varchar(45) default NULL,
  `lname` varchar(45) default NULL,
  `age` varchar(45) default NULL,
  `bloodgroup` varchar(45) default NULL,
  `gender` varchar(45) default NULL,
  `maritualstatus` varchar(45) default NULL,
  `mobile` varchar(45) default NULL,
  `address` varchar(45) default NULL,
  PRIMARY KEY  (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` (`pid`,`emailid`,`fname`,`lname`,`age`,`bloodgroup`,`gender`,`maritualstatus`,`mobile`,`address`) VALUES 
 (1,'abc@abc.com','sakibul','haque',NULL,NULL,NULL,NULL,'+8801959430070',NULL),
 (2,'abc@abc.com','sakibul','haque',NULL,NULL,NULL,NULL,'+8801959430070',NULL),
 (3,'test@gmail.com','sakibul','haque','30','O+','Male','Unmarried','+8801959430070','Dhaka'),
 (5,'test1@gmail.com','sakibul','haque','30','O+','Male','Unmarried','+88','Dhaka'),
 (6,'tuhin@gmail.com','tuhin','sayeed','25','B+','Male','Unmarried','+8801911247663','Dhaka'),
 (7,'rs@gmail.com','sakibul','haque','28','O+','Male','Unmarried','01738363303','Dhaka'),
 (8,'sdf@gmacl.com','sakibul','haque','45','AB+','Male','Unmarried','askf','asf'),
 (10,'sss@gmail.com','sss','adf','23','O+','Male','Unmarried','01738363303','Dhaka'),
 (11,'patient@gmail.com','sakibul','haque','28','O+','Male','Unmarried','01738363303','Dhaka'),
 (12,'patient@pa.com','sakibul','haque','28','O+','Male','Unmarried','01738363303','Dhaka');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;


--
-- Definition of table `paymentinfo`
--

DROP TABLE IF EXISTS `paymentinfo`;
CREATE TABLE `paymentinfo` (
  `payid` int(10) unsigned NOT NULL auto_increment,
  `pid` int(10) unsigned default NULL,
  `appointid` int(10) unsigned default NULL,
  `addid` int(10) unsigned default NULL,
  `appointfees` double NOT NULL default '0',
  `paymentdate` date default NULL,
  `status` varchar(45) default NULL,
  `admissionfees` double NOT NULL default '0',
  `testcost` double NOT NULL default '0',
  `total` double NOT NULL default '0',
  `testid` int(10) unsigned default NULL,
  PRIMARY KEY  (`payid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paymentinfo`
--

/*!40000 ALTER TABLE `paymentinfo` DISABLE KEYS */;
INSERT INTO `paymentinfo` (`payid`,`pid`,`appointid`,`addid`,`appointfees`,`paymentdate`,`status`,`admissionfees`,`testcost`,`total`,`testid`) VALUES 
 (1,5,1,1,500,'2018-12-12','Pending',700,800,2000,1),
 (2,5,1,3,600,'2018-12-28','Paid',50000,5000,55600,2),
 (3,5,1,3,600,'2018-12-22','Paid',50000,5000,55600,2),
 (4,12,2,0,300,'2018-12-26','Paid',0,0,300,0),
 (5,12,3,0,300,'2018-12-26','Unpaid',0,0,300,0);
/*!40000 ALTER TABLE `paymentinfo` ENABLE KEYS */;


--
-- Definition of table `pharmacist`
--

DROP TABLE IF EXISTS `pharmacist`;
CREATE TABLE `pharmacist` (
  `phid` int(10) unsigned NOT NULL auto_increment,
  `emailid` varchar(45) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  PRIMARY KEY  (`phid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pharmacist`
--

/*!40000 ALTER TABLE `pharmacist` DISABLE KEYS */;
INSERT INTO `pharmacist` (`phid`,`emailid`,`fname`,`lname`,`gender`,`address`) VALUES 
 (1,'rasel@haque.com','Rasel','Haque','Male','Dhaka');
/*!40000 ALTER TABLE `pharmacist` ENABLE KEYS */;


--
-- Definition of table `prescription`
--

DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription` (
  `presid` int(10) unsigned NOT NULL auto_increment,
  `doctorid` int(10) unsigned default NULL,
  `pid` int(10) unsigned default NULL,
  `presdate` date default NULL,
  `nextconsultdate` date default NULL,
  `remarks` varchar(225) default NULL,
  `appointid` int(10) unsigned default NULL,
  `reportstatus` varchar(45) default NULL,
  PRIMARY KEY  (`presid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prescription`
--

/*!40000 ALTER TABLE `prescription` DISABLE KEYS */;
INSERT INTO `prescription` (`presid`,`doctorid`,`pid`,`presdate`,`nextconsultdate`,`remarks`,`appointid`,`reportstatus`) VALUES 
 (2,1,5,'2018-12-15','2018-12-22','adsfasdf',1,'False'),
 (3,1,1,'2018-12-15','2018-12-22','asdfadf',1,NULL),
 (4,1,1,'2018-12-13','2018-12-29','asd',1,NULL),
 (5,1,1,'2018-12-05','2018-12-28','adf',1,NULL),
 (6,1,1,'2018-12-13','2018-12-08','asdfadf',1,NULL),
 (7,1,5,'2018-12-28','2019-01-04','adsfasdf',4,'False');
/*!40000 ALTER TABLE `prescription` ENABLE KEYS */;


--
-- Definition of table `prescriptiondrug`
--

DROP TABLE IF EXISTS `prescriptiondrug`;
CREATE TABLE `prescriptiondrug` (
  `drugid` int(10) unsigned NOT NULL auto_increment,
  `presid` int(10) unsigned default NULL,
  `listid` int(10) unsigned default NULL,
  `dose` varchar(45) default NULL,
  `doseschedule` varchar(45) default NULL,
  `doseadvice` varchar(255) default NULL,
  `groupid` int(10) unsigned default NULL,
  `typeid` int(10) unsigned default NULL,
  `appointid` int(10) unsigned default NULL,
  `doctorid` int(10) unsigned default NULL,
  `pid` int(10) unsigned default NULL,
  PRIMARY KEY  (`drugid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prescriptiondrug`
--

/*!40000 ALTER TABLE `prescriptiondrug` DISABLE KEYS */;
INSERT INTO `prescriptiondrug` (`drugid`,`presid`,`listid`,`dose`,`doseschedule`,`doseadvice`,`groupid`,`typeid`,`appointid`,`doctorid`,`pid`) VALUES 
 (1,1,1,'3','Morning, evening, Night','laksfa',2,2,1,1,5),
 (2,2,1,'3','Morning, evening, Night','asf',2,2,1,1,5),
 (3,3,1,'3','Morning, evening, Night','laksfa',2,2,1,1,1),
 (4,0,0,NULL,NULL,NULL,0,0,1,1,1),
 (5,0,0,NULL,NULL,NULL,0,0,1,1,1),
 (6,0,1,'3','Morning, evening, Night','laksfa',2,2,1,1,1),
 (7,0,2,'3','Morning, evening, Night','laksfa',3,2,1,1,1),
 (8,6,1,'3','Morning, evening, Night','laksfa',2,2,1,1,1),
 (9,6,2,'3','Morning, evening, Night','laksfa',3,2,1,1,1),
 (10,7,1,'3','Morning, evening, Night','laksfa',2,2,4,1,5);
/*!40000 ALTER TABLE `prescriptiondrug` ENABLE KEYS */;


--
-- Definition of table `qualification`
--

DROP TABLE IF EXISTS `qualification`;
CREATE TABLE `qualification` (
  `qid` int(10) unsigned NOT NULL auto_increment,
  `doctorid` int(10) unsigned default NULL,
  `degreetitle` varchar(45) default NULL,
  `subject` varchar(45) default NULL,
  `board` varchar(45) default NULL,
  `institute` varchar(45) default NULL,
  `passingyear` date default NULL,
  `result` varchar(45) default NULL,
  `courseduration` varchar(45) default NULL,
  PRIMARY KEY  (`qid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `qualification`
--

/*!40000 ALTER TABLE `qualification` DISABLE KEYS */;
INSERT INTO `qualification` (`qid`,`doctorid`,`degreetitle`,`subject`,`board`,`institute`,`passingyear`,`result`,`courseduration`) VALUES 
 (1,1,'SSC','Business Studies','Dhaka','Savar Cantonment Board High School','2006-04-15','4.50','2'),
 (2,1,'SSC','Business Studies','Dhaka','Savar Cantonment Board High School','2006-04-15','4.50','2');
/*!40000 ALTER TABLE `qualification` ENABLE KEYS */;


--
-- Definition of table `receptionist`
--

DROP TABLE IF EXISTS `receptionist`;
CREATE TABLE `receptionist` (
  `rid` int(10) unsigned NOT NULL auto_increment,
  `emailid` varchar(45) default NULL,
  `fname` varchar(45) default NULL,
  `lname` varchar(45) default NULL,
  `address` varchar(45) default NULL,
  `gender` varchar(45) default NULL,
  PRIMARY KEY  (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receptionist`
--

/*!40000 ALTER TABLE `receptionist` DISABLE KEYS */;
INSERT INTO `receptionist` (`rid`,`emailid`,`fname`,`lname`,`address`,`gender`) VALUES 
 (1,'rasel@rasel.com','sakibul','haque','Dhaka','Male');
/*!40000 ALTER TABLE `receptionist` ENABLE KEYS */;


--
-- Definition of table `room`
--

DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `roomid` int(10) unsigned NOT NULL auto_increment,
  `roomnumber` varchar(45) default NULL,
  `roomtype` varchar(45) default NULL,
  `roomcost` double default NULL,
  `status` varchar(45) default NULL,
  PRIMARY KEY  (`roomid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` (`roomid`,`roomnumber`,`roomtype`,`roomcost`,`status`) VALUES 
 (1,'1002','Non-AC',50000,'Unavailable'),
 (2,'1001','AC',4345,'Available');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;


--
-- Definition of table `test`
--

DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `testid` int(10) unsigned NOT NULL auto_increment,
  `typeid` int(10) unsigned NOT NULL,
  `testname` varchar(45) NOT NULL,
  `testcost` double NOT NULL,
  PRIMARY KEY  (`testid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`
--

/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` (`testid`,`typeid`,`testname`,`testcost`) VALUES 
 (1,2,'asfs',5000);
/*!40000 ALTER TABLE `test` ENABLE KEYS */;


--
-- Definition of table `testprescription`
--

DROP TABLE IF EXISTS `testprescription`;
CREATE TABLE `testprescription` (
  `presid` int(10) unsigned NOT NULL auto_increment,
  `testid` int(10) unsigned default NULL,
  `typeid` int(10) unsigned default NULL,
  `description` varchar(255) default NULL,
  `status` varchar(45) default NULL,
  `pid` int(10) unsigned default NULL,
  `amount` double NOT NULL default '0',
  PRIMARY KEY  (`presid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `testprescription`
--

/*!40000 ALTER TABLE `testprescription` DISABLE KEYS */;
INSERT INTO `testprescription` (`presid`,`testid`,`typeid`,`description`,`status`,`pid`,`amount`) VALUES 
 (1,1,1,'sgsdfg','Ok',1,5000),
 (2,1,2,'asdfasfd','Pending',5,5000),
 (3,1,1,'zzvzxv','Pending',10,5000),
 (4,1,1,'af','Pending',2,5000);
/*!40000 ALTER TABLE `testprescription` ENABLE KEYS */;


--
-- Definition of table `testreport`
--

DROP TABLE IF EXISTS `testreport`;
CREATE TABLE `testreport` (
  `reportid` int(10) unsigned NOT NULL auto_increment,
  `presid` int(10) unsigned default NULL,
  `testid` int(10) unsigned default NULL,
  `testdate` date default NULL,
  `reportdate` date default NULL,
  `report` varchar(255) default NULL,
  `pid` int(10) unsigned default NULL,
  PRIMARY KEY  (`reportid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `testreport`
--

/*!40000 ALTER TABLE `testreport` DISABLE KEYS */;
INSERT INTO `testreport` (`reportid`,`presid`,`testid`,`testdate`,`reportdate`,`report`,`pid`) VALUES 
 (5,2,1,'2018-12-11','2018-12-12','asdf',1),
 (7,2,1,'2018-12-11','2018-12-12','asdfasdf',5),
 (8,1,1,'2018-12-26','2018-12-05','vasdfaf',2);
/*!40000 ALTER TABLE `testreport` ENABLE KEYS */;


--
-- Definition of table `testtype`
--

DROP TABLE IF EXISTS `testtype`;
CREATE TABLE `testtype` (
  `typeid` int(10) unsigned NOT NULL auto_increment,
  `typename` varchar(45) NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY  (`typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `testtype`
--

/*!40000 ALTER TABLE `testtype` DISABLE KEYS */;
INSERT INTO `testtype` (`typeid`,`typename`,`description`) VALUES 
 (1,'fh','yguy'),
 (2,'asdfasdfasdf','234234');
/*!40000 ALTER TABLE `testtype` ENABLE KEYS */;


--
-- Definition of table `timeschedule`
--

DROP TABLE IF EXISTS `timeschedule`;
CREATE TABLE `timeschedule` (
  `tid` int(10) unsigned NOT NULL auto_increment,
  `starttime` varchar(45) default NULL,
  `doctorid` int(10) unsigned default NULL,
  `patientlimit` int(10) unsigned default NULL,
  `dayoff` varchar(45) default NULL,
  `endtime` varchar(45) default NULL,
  PRIMARY KEY  (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `timeschedule`
--

/*!40000 ALTER TABLE `timeschedule` DISABLE KEYS */;
INSERT INTO `timeschedule` (`tid`,`starttime`,`doctorid`,`patientlimit`,`dayoff`,`endtime`) VALUES 
 (1,'8.00 am',1,40,'Saturday','4.00 pm'),
 (2,'9.00 am',2,40,'Sunday','5.00 pm');
/*!40000 ALTER TABLE `timeschedule` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `emailid` varchar(255) NOT NULL,
  `phone` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  PRIMARY KEY  (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`emailid`,`phone`,`username`) VALUES 
 ('patient@gmail.com','01738363303','sakibul'),
 ('patient@pa.com','01738363303','sakibul'),
 ('rasel@gmail.com','+8801676340793','sakibul'),
 ('rasel@haque.com','+8801676340793','Rasel'),
 ('rasel@rasel.com','01738363303','sakibul'),
 ('raselsakibul@gmail.com','01738363303','sakibul'),
 ('rs@gmail.com','01738363303','sakibul'),
 ('sakibulrasel@gmail.com','01738363303','sakibul'),
 ('sayeed@gmail.com','01676340793','tuhin'),
 ('sdf@gmacl.com','askf','sakibul'),
 ('sr@gmail.com','01738363303','sss'),
 ('sss@gmail.com','01738363303','sss'),
 ('test1@gmail.com','+88','sakibul');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `userrole`
--

DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `emailid` varchar(255) NOT NULL,
  `password` varchar(255) default NULL,
  `role` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  PRIMARY KEY  (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userrole`
--

/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
INSERT INTO `userrole` (`emailid`,`password`,`role`,`status`) VALUES 
 ('patient@gmail.com','123','ROLE_PATIENT','True'),
 ('patient@pa.com','123','ROLE_PATIENT','True'),
 ('rasel@gmail.com','123','ROLE_DOCTOR','True'),
 ('rasel@haque.com','123','ROLE_PHARMACIST','True'),
 ('rasel@rasel.com','123','ROLE_RECEPTIONIST','True'),
 ('raselsakibul@gmail.com','123','ROLE_USER','True'),
 ('rs@gmail.com','123','ROLE_PATIENT','True'),
 ('sakibulrasel@gmail.com','1991','ROLE_USER','True'),
 ('sayeed@gmail.com','123','ROLE_DOCTOR','True'),
 ('sdf@gmacl.com','232','ROLE_PATIENT','True'),
 ('sr@gmail.com','123','ROLE_ACCOUNTANT','True'),
 ('sss@gmail.com','123','ROLE_PATIENT','True'),
 ('test1@gmail.com','12345','ROLE_PATIENT','True');
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
