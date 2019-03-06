create table login_readperson(
       username varchar2(50) primary key,
       pw varchar2(50),
       person_id varchar2(50) not null references bookperson(person_id),
       ident varchar2(2)
);