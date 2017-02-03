CREATE TABLE Gender (
  code VARCHAR(32) NOT NULL PRIMARY KEY
);

CREATE TABLE Person (
  id NUMBER AUTO_INCREMENT PRIMARY KEY,
  full_name VARCHAR(255) NOT NULL,
  date_of_birth DATE NULL,
  gender_code VARCHAR(32),

  FOREIGN KEY (gender_code) REFERENCES Gender (code)
);

INSERT INTO Gender (code)
  SELECT 'Male' AS code
  UNION ALL SELECT 'Female'
  UNION ALL SELECT 'Unknown';
-- INSERT INTO Gender (code)  ('Female');



INSERT INTO Person (full_name, gender_code)
VALUES ('Иванов Иван Иванович', 'Male');