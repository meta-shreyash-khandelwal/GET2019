create database employee;
use employee;
/*drop table employeedetail;
drop database employee;
*/

create table employeedetail
(
name varchar(30) ,
gender varchar(10),
email varchar(30),
password varchar(30),
contact int,
organisation varchar(30),
employeeid int,
primary key(email)
);



create table vehicle
(
vid int auto_increment,
type varchar(20),
vehicleName varchar(30),
vehicleNumber varchar(30),
eid int,
identification varchar(50),
email varchar(30),
primary key(vid),
foreign key(email) references employeedetail(email)
);

create table pass
(
passid int auto_increment,
subscriptiontype varchar(20),
vid int,
amount varchar(10),
primary key(passid),
foreign key (vid) references vehicle(vid));







