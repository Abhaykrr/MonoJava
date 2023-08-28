CREATE DATABASE BANK;

USE BANK;

CREATE TABLE customer (
    customerid INT PRIMARY KEY AUTO_INCREMENT,
    firstname VARCHAR(20) UNIQUE NOT NULL,
    lastname VARCHAR(20) NOT NULL,
    password_ VARCHAR(20) NOT NULL
);

CREATE TABLE admin_ (
  adminid INT PRIMARY KEY,
  firstname VARCHAR(50),
  password_ VARCHAR(50)
);

CREATE TABLE account (
  accountno INT AUTO_INCREMENT PRIMARY KEY,
  balance DECIMAL(10,2),
  customerid INT,
  UNIQUE (accountno)
);











