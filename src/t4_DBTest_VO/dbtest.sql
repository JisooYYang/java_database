show tables;

create table dbtest (
  idx    int not null auto_increment primary key,
  name   varchar(20) not null,
  age    int default 20,
  gender varchar(2) default '남',
  joinday datetime default now()
);

desc dbtest;

insert into dbtest values (default,'홍길동',25,default,default);
insert into dbtest values (default,'김남길',35,default,'2014-08-16');
insert into dbtest values (default,'양지수',23,'여',default);
insert into dbtest values (default,'김서진',5,default,default);
insert into dbtest values (default,'루피',18,'여','2004-04-01');
insert into dbtest values (default,'뽀로로',18,default,'2001-03-01');
insert into dbtest values (default,'크롱이',3,default,default);
insert into dbtest values (default,'김예원',9,'여',default);
insert into dbtest values (default,'굿모닝',68,'여','1995-10-11');
insert into dbtest values (default,'버킹',22,default,'2007-12-31');

select * from dbtest;