SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+07:00";

CREATE TABLE Employee {
    fname VARCHAR(255) NOT NULL
    lname VARCHAR(255) NOT NULL
    empId INTEGER NOT NULL
    birthDay 
    age
    isBusy 
}

CREATE TABLE Client {
    id INTEGER NOT NULL
    username VARCHAR(255) NOT NULL
}

CREATE TABLE OrderBill{
    
}

CREATE TABLE CarModel{
    cm_id INTEGER NOT NULL
    color
    carModel
}

CREATE TABLE CarType{
    ct_id INTEGER NOT NULL
    typeName VARCHAR(255) NOT NULL
}

CREATE TABLE Inventory{
    carColor VARCHAR(255) NOT NULL
    registerDate VARCHAR(255) NOT NULL
    src
    licensePlate INTEGER NOT NULL
    carModelID INTEGER NOT NULL
}

CREATE TABLE DrivingLog{
    
}