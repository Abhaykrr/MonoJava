CREATE DATABASE student;
USE student;
CREATE TABLE students (
  roll_no INT PRIMARY KEY,
  name VARCHAR(100)
);

INSERT INTO students (roll_no, name) VALUES
  (1, 'John Doe'),
  (2, 'Jane Smith'),
  (3, 'Michael Johnson'),
  (4, 'Emily Brown'),
  (5, 'David Lee');
