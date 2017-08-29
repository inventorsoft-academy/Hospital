-- CREATE DATABASE hospital
-- ON PRIMARY (NAME=s_v, FILENAME='src\\main\\resources\\\hospital.mdf', SIZE=10MB,MAXSIZE=200,FILEGROWTH=2)
-- LOG ON(NAME=Archlog1, FILENAME='src\\main\\resources\\\hospital.ldf', SIZE=10MB,MAXSIZE=200,FILEGROWTH=2)
-- GO
--
-- USE hospital

CREATE TABLE doctor(
  id INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  lastName VARCHAR (100) NOT NULL,
  firstName VARCHAR (100) NOT NULL,
  gendeer VARCHAR (6),
  specialisation VARCHAR (100)
)
  ENGINE=innoDB

  -- GO

CREATE TABLE patient(
  id INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  doctorId INT NOT NULL,
  lastName VARCHAR (100) NOT NULL,
  firstName VARCHAR (100) NOT NULL,
  gendeer VARCHAR (6),
  dob VARCHAR (500) NOT NULL,
  bloodType VARCHAR (3),

  FOREIGN KEY (doctorId) REFERENCES doctor (id)
)
  ENGINE=innoDB

  -- GO

CREATE TABLE diagnoses(
  id INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  patientId INT NOT NULL,
  description VARCHAR (500) NOT NULL,
  date VARCHAR (100) NOT NULL

  FOREIGN KEY (patientId) REFERENCES patient (id)
)
  ENGINE=innoDB

-- GO