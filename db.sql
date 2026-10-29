-- sample database queries for mysql database

CREATE DATABASE Laundry_service;
use Laundry_service;

CREATE TABLE laundry (
id INT auto_increment PRIMARY KEY,
customer VARCHAR(40),
cloths INT,
service VARCHAR(12),
rate DOUBLE
);

select * from laundry;