DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

CREATE TABLE employee (
  empId VARCHAR(10) NOT NULL,
  empName VARCHAR(100) NOT NULL
);

create table users (
    username varchar(50) not null primary key,
    password varchar(120) not null,
    enabled boolean not null
);

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);

 insert into users(username, password, enabled)values('javainuse','javainuse',true);
 insert into authorities(username,authority)values('javainuse','ROLE_ADMIN');
 
  insert into users(username, password, enabled)values('employee','employee',true);
 insert into authorities(username,authority)values('javainuse','ROLE_USER');





use student;

create table users (
    username varchar(50) not null primary key,
    password varchar(120) not null,
    enabled boolean not null
);


create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);


set foreign_key_checks=0;

truncate table users;
truncate table authorities;


 insert into users(username, password, enabled)values('admin','123',true);
 insert into authorities(username,authority)values('admin','ROLE_ADMIN');
 
  insert into users(username, password, enabled)values('varun','1234',true);
 insert into authorities(username,authority)values('varun','ROLE_USER');

  insert into users(username, password, enabled)values('svk','12345',true);
 insert into authorities(username,authority)values('svk','ROLE_USER');