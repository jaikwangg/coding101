

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */
/*!40101 SET NAMES utf8mb4 */

--
-- Database: blackmarket
--

-- --------------------------------------------------------

--
-- Table structure for table buytransaction
--

CREATE TABLE buytransaction (
  mId int NOT NULL,
  pId int NOT NULL,
  shpmID int NOT NULL,
  btPrice int NOT NULL,
  btCost int NOT NULL
)

-- --------------------------------------------------------

--
-- Table structure for table country
--

CREATE TABLE country(
  cId int NOT NULL,
  cName varchar(16) NOT NULL,
  pvId int NOT NULL
)

-- --------------------------------------------------------

--
-- Table structure for table department
--

CREATE TABLE department (
  deptId int NOT NULL,
  deptName varchar(16) NOT NULL,
  deptEmpId int NOT NULL
)

-- --------------------------------------------------------

--
-- Table structure for table employee
--

CREATE TABLE employee (
  empId int NOT NULL,
  superEmpID int NOT NULL,
  empBirthday timestamp NOT NULL,
  empSex char(1) NOT NULL,
  empEmail varchar(16) NOT NULL,
  empTel int NOT NULL,
  empSalary int NOT NULL,
  empName varchar(32) NOT NULL,
  empRole varchar(16) NOT NULL,
  empStartDate timestamp NOT NULL,
  empAge int NOT NULL,
  deptId int NOT NULL,
  whId int NOT NULL
)

-- --------------------------------------------------------

--
-- Table structure for table member
--

CREATE TABLE member (
  username varchar(32) NOT NULL,
  mId int NOT NULL,
  startDate timestamp NOT NULL
)

-- --------------------------------------------------------

--
-- Table structure for table paymenttype
--

CREATE TABLE paymenttype (
  paymentName varchar(32) NOT NULL,
  pId int NOT NULL
)

-- --------------------------------------------------------

--
-- Table structure for table product
--

CREATE TABLE product (
  pId int NOT NULL,
  pType varchar(16) NOT NULL,
  pDescription varchar(255) NOT NULL,
  pName varchar(16) NOT NULL,
  pPrice int NOT NULL,
  pCost int NOT NULL,
  whId int NOT NULL,
  stdPriceId int NOT NULL
)

-- --------------------------------------------------------

--
-- Table structure for table province
--

CREATE TABLE province (
  pvId int NOT NULL,
  pvName varchar(16) NOT NULL,
  totalWarehouse int NOT NULL
)

-- --------------------------------------------------------

--
-- Table structure for table selltransaction
--

CREATE TABLE selltransaction (
  pid int NOT NULL,
  mid int NOT NULL,
  empId int NOT NULL,
  stdPriceId int NOT NULL,
  stIsVerify smaillint NOT NULL DEFAULT 0
) -- CREATED

-- --------------------------------------------------------

--
-- Table structure for table shipment
--

CREATE TABLE shipment (
  shpmId int NOT NULL,
  shpmDestination varchar(255) NOT NULL,
  shpmDate timestamp NOT NULL,
  shpmEmp int NOT NULL,
  shpmStatus varchar(16) NOT NULL
) -- CREATED

-- --------------------------------------------------------

--
-- Table structure for table standardprice
--

CREATE TABLE standardprice (
  stdPriceId int NOT NULL,
  stdProductName varchar(16) NOT NULL,
  stdCost int NOT NULL,
  stdLastUpdateAt timestamp NOT NULL,
  stdLastUpdateByEmpId int NOT NULL
) -- CREATED

-- --------------------------------------------------------

--
-- Table structure for table wallet
--

CREATE TABLE walletMarket (
  wId int NOT NULL,
  mId int NOT NULL,
  wBalance int NOT NULL
) -- CREATE

-- --------------------------------------------------------

--
-- Table structure for table wallettransaction
--

CREATE TABLE wallettransaction (
  wId int NOT NULL,
  pId int NOT NULL,
  wtDate timestamp NOT NULL,
  wtPrice int NOT NULL,
  wtId int NOT NULL
) -- CREATE

-- --------------------------------------------------------

--
-- Table structure for table warehouse
--

CREATE TABLE warehouseMarket (
  whId int NOT NULL,
  whName varchar(16) NOT NULL,
  empId int NOT NULL,
  superEmpId int NOT NULL,
  productId int NOT NULL,
  cId int NOT NULL
)

--
-- Indexes for dumped tables

INSERT INTO buytransaction (mId, pId, shpmID, btPrice, btCost) VALUES
 (1, 101, 201, 50, 40),
 (2, 102, 202, 70, 60),
 (3, 103, 203, 90, 80),
 (4, 104, 204, 110, 100)

INSERT INTO country (cId, cName, pvId) VALUES
 (1, 'CountryA', 101),
 (2, 'CountryB', 102),
 (3, 'CountryC', 103)

INSERT INTO department (deptId, deptName, deptEmpId) VALUES
 (1, 'DeptA', 201),
 (2, 'DeptB', 202),
 (3, 'DeptC', 203)

 INSERT INTO employee (empId, superEmpID, empBirthday, empSex, empEmail, empTel, empSalary, empName, empRole, empStartDate, empAge, deptId, whId) VALUES
(1, 101, '1990-05-15', 'M', 'emp1@example.com', 1234567890, 60000, 'John Doe', 'Manager', '2020-01-01', 33, 201, 301),
(2, 102, '1995-08-20', 'F', 'emp2@example.com', 9876543210, 50000, 'Jane Smith', 'Supervisor', '2021-03-15', 28, 202, 302),
(3, 103, '1988-12-10', 'M', 'emp3@example.com', 1357924680, 70000, 'Michael Johnson', 'Assistant', '2019-11-10', 35, 203, 303)

INSERT INTO member (username, mId, startDate) VALUES
('user1', 1, '2022-01-05'),
('user2', 2, '2022-02-10'),
('user3', 3, '2022-03-15')

INSERT INTO member (username, mId, startDate) VALUES
('user1', 1, '2022-01-05'),
('user2', 2, '2022-02-10'),
('user3', 3, '2022-03-15')

INSERT INTO paymenttype (paymentName, pId) VALUES
('Credit Card', 1),
('PayPal', 2),
('Bitcoin', 3)

INSERT INTO paymenttype (paymentName, pId) VALUES
('Bitcoin', 1),
('Dodgecoin', 2),
('Etheruem', 3)

INSERT INTO product (pId, pType, pDescription, pName, pPrice, pCost, whId, stdPriceId) VALUES
(101, 'Electronics', 'Description of product 1', 'Product 1', 500, 400, 301, 401),
(102, 'Clothing', 'Description of product 2', 'Product 2', 700, 600, 302, 402),
(103, 'Groceries', 'Description of product 3', 'Product 3', 900, 800, 303, 403)

INSERT INTO province (pvId, pvName, totalWarehouse) VALUES
(101, 'ProvinceA', 3),
(102, 'ProvinceB', 2),
(103, 'ProvinceC', 4)

INSERT INTO selltransaction (pid, mid, empId, stdPriceId, stIsVerify) VALUES
(101, 1, 1, 401, 1),
(102, 2, 2, 402, 0),
(103, 3, 3, 403, 1)

INSERT INTO shipment (shpmId, shpmDestination, shpmDate, shpmEmp, shpmStatus) VALUES
(201, 'Destination A', '2023-01-10', 1, 'Shipped'),
(202, 'Destination B', '2023-02-15', 2, 'In Transit'),
(203, 'Destination C', '2023-03-20', 3, 'Delivered')

INSERT INTO standardprice (stdPriceId, stdProductName, stdCost, stdLastUpdateAt, stdLastUpdateByEmpId) VALUES
(401, 'Product 1', 400, '2022-01-01', 101),
(402, 'Product 2', 600, '2022-02-01', 102),
(403, 'Product 3', 800, '2022-03-01', 103)

INSERT INTO wallet (wId, mId, wBalance) VALUES
(301, 1, 1000),
(302, 2, 2000),
(303, 3, 3000)

INSERT INTO wallettransaction (wId, pId, wtDate, wtPrice, wtId) VALUES
(301, 1, '2023-01-05', 100, 501),
(302, 2, '2023-02-10', 200, 502),
(303, 3, '2023-03-15', 300, 503)

INSERT INTO warehouse (whId, whName, empId, superEmpId, productId, cId) VALUES
(301, 'Warehouse A', 1, 101, 101, 1),
(302, 'Warehouse B', 2, 102, 102, 2),
(303, 'Warehouse C', 3, 103, 103, 3)

--
-- Indexes for table buytransaction
--
ALTER TABLE buytransaction
  ADD KEY mId (mId),
  ADD KEY pId (pId),
  ADD KEY shpmID (shpmID)

--
-- Indexes for table country
--
ALTER TABLE country
  ADD UNIQUE KEY cId (cId),
  ADD KEY pId (pvId)

--
-- Indexes for table department
--
ALTER TABLE department
  ADD UNIQUE KEY deptId (deptId)

--
-- Indexes for table employee
--
ALTER TABLE employee
  ADD UNIQUE KEY empId (empId),
  ADD UNIQUE KEY superEmpID (superEmpID),
  ADD KEY deptId (deptId),
  ADD KEY whId (whId)

--
-- Indexes for table member
--
ALTER TABLE member
  ADD UNIQUE KEY mId (mId)

--
-- Indexes for table paymenttype
--
ALTER TABLE paymenttype
  ADD UNIQUE KEY pId (pId)

--
-- Indexes for table product
--
ALTER TABLE product
  ADD UNIQUE KEY pId (pId),
  ADD KEY whId (whId),
  ADD KEY stdPrice (stdPriceId)

--
-- Indexes for table province
--
ALTER TABLE province
  ADD UNIQUE KEY pvId (pvId)

--
-- Indexes for table selltransaction
--
ALTER TABLE selltransaction
  ADD KEY empId (empId),
  ADD KEY mid (mid),
  ADD KEY pid (pid),
  ADD KEY stPrice (stdPriceId)

--
-- Indexes for table shipment
--
ALTER TABLE shipment
  ADD UNIQUE KEY shpmId (shpmId)

--
-- Indexes for table standardprice
--
ALTER TABLE standardprice
  ADD UNIQUE KEY stdPriceId (stdPriceId)

--
-- Indexes for table wallet
--
ALTER TABLE wallet
  ADD UNIQUE KEY wId (wId),
  ADD KEY mId (mId)

--
-- Indexes for table wallettransaction
--
ALTER TABLE wallettransaction
  ADD KEY pId (pId),
  ADD KEY wallettransaction_ibfk_2 (wId)

--
-- Indexes for table warehouse
--
ALTER TABLE warehouse
  ADD UNIQUE KEY whId (whId),
  ADD KEY cId (cId)

--
-- Constraints for dumped tables
--

--
-- Constraints for table buytransaction
--
ALTER TABLE buytransaction
  ADD CONSTRAINT buytransaction_ibfk_1 FOREIGN KEY (mId) REFERENCES member (mId) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT buytransaction_ibfk_2 FOREIGN KEY (pId) REFERENCES product (pId) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT buytransaction_ibfk_3 FOREIGN KEY (shpmID) REFERENCES shipment (shpmId) ON DELETE CASCADE ON UPDATE CASCADE

--
-- Constraints for table country
--
ALTER TABLE country
  ADD CONSTRAINT country_ibfk_1 FOREIGN KEY (pvId) REFERENCES province (pvId) ON DELETE CASCADE ON UPDATE CASCADE

--
-- Constraints for table employee
--
ALTER TABLE employee
  ADD CONSTRAINT employee_ibfk_1 FOREIGN KEY (deptId) REFERENCES department (deptId) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT employee_ibfk_2 FOREIGN KEY (superEmpID) REFERENCES employee (empId) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT employee_ibfk_3 FOREIGN KEY (whId) REFERENCES warehouse (whId) ON DELETE CASCADE ON UPDATE CASCADE

--
-- Constraints for table product
--
ALTER TABLE product
  ADD CONSTRAINT product_ibfk_1 FOREIGN KEY (whId) REFERENCES warehouse (whId) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT product_ibfk_2 FOREIGN KEY (stdPriceId) REFERENCES standardprice (stdPriceId) ON DELETE CASCADE ON UPDATE CASCADE

--
-- Constraints for table selltransaction
--
ALTER TABLE selltransaction
  ADD CONSTRAINT selltransaction_ibfk_1 FOREIGN KEY (empId) REFERENCES employee (empId) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT selltransaction_ibfk_2 FOREIGN KEY (mid) REFERENCES member (mId) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT selltransaction_ibfk_3 FOREIGN KEY (pid) REFERENCES product (pId) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT selltransaction_ibfk_4 FOREIGN KEY (stdPriceId) REFERENCES standardprice (stdPriceId) ON DELETE CASCADE ON UPDATE CASCADE

--
-- Constraints for table wallet
--
ALTER TABLE wallet
  ADD CONSTRAINT wallet_ibfk_1 FOREIGN KEY (mId) REFERENCES member (mId) ON DELETE CASCADE ON UPDATE CASCADE

--
-- Constraints for table wallettransaction
--
ALTER TABLE wallettransaction
  ADD CONSTRAINT wallettransaction_ibfk_1 FOREIGN KEY (pId) REFERENCES paymenttype (pId) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT wallettransaction_ibfk_2 FOREIGN KEY (wId) REFERENCES wallet (wId) ON DELETE CASCADE ON UPDATE CASCADE

--
-- Constraints for table warehouse
--
ALTER TABLE warehouse
  ADD CONSTRAINT warehouse_ibfk_1 FOREIGN KEY (cId) REFERENCES country (cId) ON DELETE CASCADE ON UPDATE CASCADE
COMMIT

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */
