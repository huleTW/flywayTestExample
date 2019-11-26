CREATE TABLE BILLIONAIRES (
  id INT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);

INSERT INTO BILLIONAIRES (id, first_name, last_name, career) VALUES
  (1,'Aliko', 'Dangote', 'Billionaire Industrialist'),
  (2,'Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
  (3,'Folrunsho', 'Alakija', 'Billionaire Oil Magnate');