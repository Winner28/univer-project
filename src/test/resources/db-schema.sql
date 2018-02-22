SET MODE POSTGRESQL;

CREATE TABLE IF NOT EXISTS users (
  ID int auto_increment
		primary key,
  email varchar(100) not null,
  firstName varchar(100) not null,
  lastName varchar(100) not null,
  passwordHash varchar(100) not null,
);