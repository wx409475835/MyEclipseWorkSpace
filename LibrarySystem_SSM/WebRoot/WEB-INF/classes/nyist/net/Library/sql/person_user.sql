create table person_user(
     person_id varchar2(50),
     username varchar2(50),
     ident varchar2(2),
     book_id integer,
     book_name varchar2(50),
     book_type varchar2(50),
     book_price number(9,2),
     book_count Integer,
     book_add varchar2(50),
     constraint pk primary key(person_id,book_id)
);
