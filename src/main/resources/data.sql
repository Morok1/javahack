DROP TABLE IF EXISTS BUSINESS;
DROP TABLE IF EXISTS PRODUCERS;
DROP TABLE IF EXISTS CONSUMERS;

CREATE TABLE BUSINESS(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  INN INTEGER DEFAULT NULL,
  okved INTEGER DEFAULT NULL,
  post VARCHAR(250) NOT NULL,
  full_with_opf VARCHAR(250) NOT NULL,
  short_with_opf VARCHAR(250) NOT NULL,
  adress VARCHAR(250) NOT NULL,
  );

CREATE TABLE PRODUCERS(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  business_id int NOT NULL ,
  producer_id int NOT NULL,
  CONSTRAINT PRODUCERS_info UNIQUE(business_id,producer_id),
  FOREIGN key (business_id) references BUSINESS(id)
);

CREATE TABLE CONSUMERS(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  business_id int NOT NULL,
  consumer_id int NOT NULL,
  CONSTRAINT CONSUMERS_info UNIQUE(business_id,consumer_id),
  FOREIGN key (business_id) references BUSINESS(id)
);


INSERT INTO BUSINESS(first_name, last_name, INN, okved,post, full_with_opf,
short_with_opf, adress) VALUES
  ('Lokesh', 'Gupta', 1322,3, 'ПРЕЗИДЕНТ, ПРЕДСЕДАТЕЛЬ ПРАВЛЕНИЯ',
  'ПУБЛИЧНОЕ АКЦИОНЕРНОЕ ОБЩЕСТВО \"СБЕРБАНК РОССИИ\',
  'ПАО СБЕРБАНК', 'г Москва, ул Вавилова, д 19"'),
  ('DejaVu', 'xyz@email.com', 22233, 3,'ПРЕЗИДЕНТ, ПРЕДСЕДАТЕЛЬ ПРАВЛЕНИЯ',
  'ПУБЛИЧНОЕ АКЦИОНЕРНОЕ ОБЩЕСТВО \"СБЕРБАНК РОССИИ\',
  'ПАО СБЕРБАНК', 'г Москва, ул Вавилова, д 19"'),
  ('Caption', 'America', 3223232,4, 'ПРЕЗИДЕНТ, ПРЕДСЕДАТЕЛЬ ПРАВЛЕНИЯ',
  'ПУБЛИЧНОЕ АКЦИОНЕРНОЕ ОБЩЕСТВО \"СБЕРБАНК РОССИИ\',
  'ПАО СБЕРБАНК', 'г Москва, ул Вавилова, д 19"');

INSERT INTO PRODUCERS (business_id, producer_id) values
  (1, 1),
  (2, 2),
  (3, 3)
;

INSERT INTO CONSUMERS  (business_id, consumer_id) values
  (1, 1),
  (2, 2),
  (3, 3)
;
