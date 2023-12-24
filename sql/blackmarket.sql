-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 17, 2023 at 03:52 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+07:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `blackmarket`
--

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `deptId` int(11) NOT NULL,
  `deptName` varchar(16) NOT NULL,
  `deptEmpId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`deptId`, `deptName`, `deptEmpId`) VALUES
(1, 'finance', 0),
(2, 'operations manag', 0),
(3, 'human resources', 0),
(4, 'information tech', 0);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `empId` int(11) NOT NULL,
  `superEmpID` int(11) NOT NULL,
  `empBirthday` datetime NOT NULL,
  `empSex` char(1) NOT NULL,
  `empEmail` varchar(16) NOT NULL,
  `empTel` int(11) NOT NULL,
  `empSalary` int(11) NOT NULL,
  `empName` varchar(32) NOT NULL,
  `empRole` varchar(16) NOT NULL,
  `empStartDate` datetime NOT NULL,
  `empAge` int(11) NOT NULL,
  `deptId` int(11) NOT NULL,
  `whId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `employee` (`empId`, `superEmpID`, `empBirthday`, `empSex`, `empEmail`, `empTel`, `empTel`, `empSalary`, `empName`, `empRole`, `empStartDate`, `empAge`, `deptId`, `whId`) VALUES
  ()
-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `username` varchar(32) NOT NULL,
  `mId` int(11) NOT NULL,
  `startDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`username`, `mId`, `startDate`) VALUES
('tomandjerry', 01, '0000-00-00 00:00:00'),
('bananamilkshake', 02, '0000-00-00 00:00:00'),
('corndogwithsaucecheese', 03, '0000-00-00 00:00:00'),
('superRookieJR', 04, '0000-00-00 00:00:00'),
('commedyscience', 05, '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `paymenttype`
--

CREATE TABLE `paymentType` (
  `paymentName` varchar(12) NOT NULL,
  `pId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `paymentType` (`paymentName`, `pid`) VALUES
('Bitcoin', 01),
('Dodgecoin', 02),
('Ethereum', 03);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `pId` int(11) NOT NULL,
  `pType` varchar(16) NOT NULL,
  `pDescription` longtext NOT NULL,
  `pName` varchar(16) NOT NULL,
  `pPrice` int(11) NOT NULL,
  `pCost` int(11) NOT NULL,
  `whId` int(11) NOT NULL,
  `stdPriceId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `product` (`pId`, `pType`, `pDescription`, `pName`, `pPrice`, `pCost`, `whId`, `stdPriceId`) VALUES
(00000001, 'GUN', "M4A1 that's can shoot you in to her heart", "M4A1", 300, 240, 0001, 01),
(00000002, 'DRUG', "Just smell it and you can fly to the moon", "Cocaine", 300, 240, 0001, 03);

-- --------------------------------------------------------

--
-- Table structure for table `warehouse`
--

CREATE TABLE `warehouse` (
  `whId` int(11) NOT NULL,
  `whName` varchar(16) NOT NULL,
  `empId` int(11) NOT NULL,
  `superEmpId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `cId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `warehouse` (`whId`, `whName`, `empId`, `superEmpId`, `productId`, `cId`,) VALUES
(0001, 'Warehouse A', 02, 01, 10000, 01),
(0002, 'Warehouse B', 01, 01, 10000, 01),
(0003, 'Warehouse C', 04, 01, 10000, 01),
(0004, 'Warehouse D', 05, 01, 10000, 01),
(0005, 'Warehouse E', 06, 01, 10000, 01),
(0006, 'Warehouse F', 03, 01, 10000, 01);

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE `country` (
  `cId` int(11) NOT NULL,
  `cName` varchar(16) NOT NULL,
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `country` VALUES 
  (1, `Thailand`),
  (2, ` England`),
  (3, `United States`);

-- --------------------------------------------------------

--
-- Table structure for table `province`
--

CREATE TABLE `province` (
  'cId' int(2) NOT NULL,
  `pvId` int(8) NOT NULL,
  `pvName` varchar(16) NOT NULL,
  `totalWarehouse` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `province` (`cId`, `pvId`, `pvName`, `totalWarehouse`) VALUES
(1, 1, "Bangkok", 0),
(1, 2, "Pattaya", 0),
(2, 1, "London", 0),
(2, 2, "Liverpool", 0)
(3, 1, "Los Ángeles", 0),
(3, 2, "Seattle", 0);

-- --------------------------------------------------------

--
-- Table structure for table `shipment`
--

CREATE TABLE `shipment` (
  `shpmId` int(11) NOT NULL,
  `shpmDestination` longtext NOT NULL,
  `shpmDate` datetime NOT NULL,
  `shpmEmp` int(11) NOT NULL,
  `shpmStatus` bit NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `shipment` (`shpmId`, `shpmDestination`, `shpmDate`, `shpmStatus`) VALUES 
  (1, "Google Map Service Data#1", GETDATE(), 0),
  (2, "Google Map Service Data#2", GETDATE(), 1),
  (3, "Google Map Service Data#3", GETDATE(), 1);

-- --------------------------------------------------------

--
-- Table structure for table `buytransaction`
--

CREATE TABLE `buyTransaction` (
  `mId` int(11) NOT NULL,
  `pId` int(11) NOT NULL,
  `shpmId` int(11) NOT NULL,
  `empId` int(11) NOT NULL,
  `btPrice` int(11) NOT NULL,
  `btCost` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `buytransaction` (`mId`, `pId`, `shpmId`, `empId`, "btPrice", "btCost") VALUES 
  (1, 1, 1, 1, 200, 100),
  (1, 2, 2, 3, 150, 100),
  (2, 1, 3, 1, 200, 100);

-- --------------------------------------------------------

--
-- Table structure for table `selltransaction`
--

CREATE TABLE `sellTransaction` (
  `pid` int(11) NOT NULL,
  `mid` int(11) NOT NULL,
  `empId` int(11) NOT NULL,
  `stdPriceId` int(11) NOT NULL,
  `stIsVerify` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `standardprice`
--

CREATE TABLE `standardPrice` (
  `stdPriceId` int(11) NOT NULL,
  `stdProductName` varchar(16) NOT NULL,
  `stdCost` int(11) NOT NULL,
  `stdLastUpdateAt` datetime NOT NULL,
  `stdLastUpdateByEmpId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `wallet`
--

CREATE TABLE `wallet` (
  `wId` int(11) NOT NULL,
  `mId` int(11) NOT NULL,
  `wBalance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `wallet` (`wId`, `mId`, `walance`,) VALUES
(70654862, 01, 20),
(05103215, 02, 2),
(98405230, 03, 0),
(45631244, 04, 3),
(10865310, 05, 12);
-- --------------------------------------------------------

--
-- Table structure for table `wallettransaction`
--

CREATE TABLE `walletTransaction` (
  `wId` int(11) NOT NULL,
  `pId` int(11) NOT NULL,
  `wtDate` datetime NOT NULL,
  `wtPrice` int(11) NOT NULL,
  `wtId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buytransaction`
--
ALTER TABLE `buytransaction`
  ADD KEY `mId` (`mId`),
  ADD KEY `pId` (`pId`),
  ADD UNIQUE KEY `shpmID` (`shpmID`);

--
-- Indexes for table `country`
--
ALTER TABLE `country`
  ADD UNIQUE KEY `cId` (`cId`),
  ADD KEY `pId` (`pvId`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD UNIQUE KEY `deptId` (`deptId`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD UNIQUE KEY `empId` (`empId`),
  ADD UNIQUE KEY `superEmpID` (`superEmpID`),
  ADD KEY `deptId` (`deptId`),
  ADD KEY `whId` (`whId`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD UNIQUE KEY `mId` (`mId`);

--
-- Indexes for table `paymenttype`
--
ALTER TABLE `paymenttype`
  ADD UNIQUE KEY `pId` (`pId`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD UNIQUE KEY `pId` (`pId`),
  ADD KEY `whId` (`whId`),
  ADD KEY `stdPrice` (`stdPriceId`);

--
-- Indexes for table `province`
--
ALTER TABLE `province`
  ADD UNIQUE KEY `pvId` (`pvId`);

--
-- Indexes for table `selltransaction`
--
ALTER TABLE `selltransaction`
  ADD KEY `empId` (`empId`),
  ADD KEY `mid` (`mid`),
  ADD KEY `pid` (`pid`),
  ADD KEY `stPrice` (`stdPriceId`);

--
-- Indexes for table `shipment`
--
ALTER TABLE `shipment`
  ADD UNIQUE KEY `shpmId` (`shpmId`);

--
-- Indexes for table `standardprice`
--
ALTER TABLE `standardprice`
  ADD UNIQUE KEY `stdPriceId` (`stdPriceId`);

--
-- Indexes for table `wallet`
--
ALTER TABLE `wallet`
  ADD UNIQUE KEY `wId` (`wId`),
  ADD KEY `mId` (`mId`);

--
-- Indexes for table `wallettransaction`
--
ALTER TABLE `wallettransaction`
  ADD KEY `pId` (`pId`),
  ADD KEY `wallettransaction_ibfk_2` (`wId`);

--
-- Indexes for table `warehouse`
--
ALTER TABLE `warehouse`
  ADD UNIQUE KEY `whId` (`whId`),
  ADD KEY `cId` (`cId`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `buytransaction`
--
ALTER TABLE `buytransaction`
  ADD CONSTRAINT `buytransaction_ibfk_1` FOREIGN KEY (`mId`) REFERENCES `member` (`mId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `buytransaction_ibfk_2` FOREIGN KEY (`pId`) REFERENCES `product` (`pId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `buytransaction_ibfk_3` FOREIGN KEY (`shpmID`) REFERENCES `shipment` (`shpmId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `country`
--
ALTER TABLE `country`
  ADD CONSTRAINT `country_ibfk_1` FOREIGN KEY (`pvId`) REFERENCES `province` (`pvId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`deptId`) REFERENCES `department` (`deptId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`superEmpID`) REFERENCES `employee` (`empId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `employee_ibfk_3` FOREIGN KEY (`whId`) REFERENCES `warehouse` (`whId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`whId`) REFERENCES `warehouse` (`whId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `product_ibfk_2` FOREIGN KEY (`stdPriceId`) REFERENCES `standardprice` (`stdPriceId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `selltransaction`
--
ALTER TABLE `selltransaction`
  ADD CONSTRAINT `selltransaction_ibfk_1` FOREIGN KEY (`empId`) REFERENCES `employee` (`empId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `selltransaction_ibfk_2` FOREIGN KEY (`mid`) REFERENCES `member` (`mId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `selltransaction_ibfk_3` FOREIGN KEY (`pid`) REFERENCES `product` (`pId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `selltransaction_ibfk_4` FOREIGN KEY (`stdPriceId`) REFERENCES `standardprice` (`stdPriceId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `wallet`
--
ALTER TABLE `wallet`
  ADD CONSTRAINT `wallet_ibfk_1` FOREIGN KEY (`mId`) REFERENCES `member` (`mId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `wallettransaction`
--
ALTER TABLE `wallettransaction`
  ADD CONSTRAINT `wallettransaction_ibfk_1` FOREIGN KEY (`pId`) REFERENCES `paymenttype` (`pId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `wallettransaction_ibfk_2` FOREIGN KEY (`wId`) REFERENCES `wallet` (`wId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `warehouse`
--
ALTER TABLE `warehouse`
  ADD CONSTRAINT `warehouse_ibfk_1` FOREIGN KEY (`cId`) REFERENCES `country` (`cId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
