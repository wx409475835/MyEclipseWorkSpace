create table book(
     book_id integer primary key,
     book_name varchar2(50),
     book_type varchar2(50),
     book_price number(9,2),
     book_count Integer,
     book_add varchar2(50)
);
create sequence book_seq start with 1;
