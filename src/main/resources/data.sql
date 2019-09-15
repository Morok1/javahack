  DROP TABLE IF EXISTS BUSINESS;
CREATE TABLE BUSINESS(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  INN INTEGER DEFAULT NULL
);
INSERT INTO BUSINESS(first_name, last_name, INN) VALUES
  ('Lokesh', 'Gupta', 1322),
  ('DejaVu', 'xyz@email.com', 22233),
  ('Caption', 'America', 3223232);
