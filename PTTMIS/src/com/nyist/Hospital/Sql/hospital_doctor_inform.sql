create table hospital_inform1(
	hi_id int(20) not null auto_increment primary key,
	hi_personid int(20) not null,
	hi_tet varchar(50),
	hi_content varchar(256)
);
