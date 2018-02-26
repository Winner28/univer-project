SET MODE MSSQLSERVER;

CREATE TABLE users (
  ID INT auto_increment
		primary key,
  email varchar(100) not null,
  passwordHash varchar(100) not null,
  firstName varchar(100) not null,
  lastName varchar(100) not null
);