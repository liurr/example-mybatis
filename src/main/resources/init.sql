create database mybatis;
use mybatis;
CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(20), SEX VARCHAR(20), AGE INT);
INSERT INTO users(NAME,SEX, AGE) VALUES('张三丰', '男' ,27);
INSERT INTO users(NAME,SEX, AGE) VALUES('梅长苏', '男', 27);
INSERT INTO users(NAME,SEX, AGE) VALUES('鲁智深', '男', 30);