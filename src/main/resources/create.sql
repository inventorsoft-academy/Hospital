CREATE TABLE doctor(
  id SERIAL PRIMARY KEY,
  last_name VARCHAR (100) NOT NULL,
  first_name VARCHAR (100) NOT NULL,
  gendeer VARCHAR (6),
  specialisation VARCHAR (100)
);

CREATE TABLE patient(
  id SERIAL PRIMARY KEY,
  doctor_id INT NOT NULL,
  last_name VARCHAR (100) NOT NULL,
  first_name VARCHAR (100) NOT NULL,
  gendeer VARCHAR (6),
  dob VARCHAR (500) NOT NULL,
  blood_type VARCHAR (5),

  FOREIGN KEY (doctor_id)
  REFERENCES doctor (id)
);

CREATE TABLE diagnoses(
  id SERIAL PRIMARY KEY,
  patient_id INT NOT NULL,
  description VARCHAR (500) NOT NULL,
  date VARCHAR (100) NOT NULL,

  FOREIGN KEY (patient_id)
  REFERENCES patient (id)
);

INSERT INTO doctor VALUES (1,'ssc','bnn','vvc','tyjj');
INSERT INTO doctor VALUES (2,'fdsv','tutr','dfvgn','fgg');
INSERT INTO doctor VALUES (3,'yju','sdfe','ghhj','gfnbn');

INSERT INTO patient VALUES (1,1,'dfg','ghhj','gfnbn','ddfv','I_P');
INSERT INTO patient VALUES (2,1,'vdfv','rwef','dfbfb','ddfv','I_N');
INSERT INTO patient VALUES (3,2,'jhmj','qeqw','sdfdv','ddfv','II_P');
INSERT INTO patient VALUES (4,2,'hjk','nhgm','fgbfgb','ddfv','II_N');
INSERT INTO patient VALUES (5,3,'bnbn','m,k','bfgbfg','ddfv','III_P');
INSERT INTO patient VALUES (6,3,'ery','gfn','dfbb','ddfv','III_N');
INSERT INTO patient VALUES (7,2,'wr','gnhm','fdb','ddfv','IV_P');
INSERT INTO patient VALUES (8,1,'kiuku','hb','fbgb','ddfv','IV_N');

INSERT INTO diagnoses VALUES (1,1,'gdsg','2017-08-21 14:21');
INSERT INTO diagnoses VALUES (2,2,'dfvb','2017-08-21 14:21');
INSERT INTO diagnoses VALUES (3,3,'gngn','2017-08-21 14:21');
INSERT INTO diagnoses VALUES (4,4,'vbngn','2017-08-21 14:21');
INSERT INTO diagnoses VALUES (5,5,'gngn','2017-08-21 14:21');
INSERT INTO diagnoses VALUES (6,6,'nhgn','2017-08-21 14:21');
INSERT INTO diagnoses VALUES (7,7,'ghnmgh','2017-08-21 14:21');
INSERT INTO diagnoses VALUES (8,8,'hgmh','2017-08-21 14:21');
INSERT INTO diagnoses VALUES (9,1,'ghmghm','2017-08-21 14:21');