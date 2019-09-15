DROP TABLE IF EXISTS BUSINESS;
DROP TABLE IF EXISTS PRODUCERS;
DROP TABLE IF EXISTS CONSUMERS;

CREATE TABLE BUSINESS(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  INN INTEGER DEFAULT NULL,
  okved INTEGER DEFAULT NULL,
);


CREATE TABLE PRODUCERS(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  business_id int NOT NULL,
  producer_id int NOT NULL,
  CONSTRAINT PRODUCERS_info UNIQUE(business_id,producer_id)
);

CREATE TABLE CONSUMERS(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  business_id int NOT NULL,
  consumer_id int NOT NULL,

  CONSTRAINT CONSUMERS_info UNIQUE(business_id,consumer_id)
);


INSERT INTO BUSINESS(first_name, last_name, INN, okved) VALUES
  ('Lokesh', 'Gupta', 1322,3),
  ('DejaVu', 'xyz@email.com', 22233, 3),
  ('Caption', 'America', 3223232,4);

INSERT INTO PRODUCERS (business_id, producer_id) values
  (12, 1322),
  (13, 1321),
  (14, 1322)
;

INSERT INTO CONSUMERS  (business_id, consumer_id) values
  (15, 1322),
  (16, 1321),
  (17, 1322)
;
