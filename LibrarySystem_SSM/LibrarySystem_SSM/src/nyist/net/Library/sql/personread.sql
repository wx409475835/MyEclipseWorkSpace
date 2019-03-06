create table personread(
       read_id integer primary key,
       person_id varchar2(50) references bookperson(person_id),
       book_id integer references book(book_id),
       book_name varchar2(50),
       book_type varchar2(50),
       book_count varchar2(50),
       book_add varchar2(50)
        
);

create sequence read_seq start with 1;