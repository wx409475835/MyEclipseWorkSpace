create table bookperson(
       person_id varchar2(50) primary key,
       person_name varchar2(50),
       person_age integer,
       person_sex varchar2(6),
       person_we varchar2(30),
       person_com varchar2(50),
       person_mobile varchar2(30),
       person_add varchar2(100)
);

create sequence person_seq start with 1;