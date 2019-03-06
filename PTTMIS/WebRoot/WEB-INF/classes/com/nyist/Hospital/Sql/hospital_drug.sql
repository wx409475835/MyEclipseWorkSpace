create table hospital_drug(
	hdrug_id int(20) not null auto_increment primary key,
	hdrug_name varchar(100),
	hdrug_price varchar(20),
	hdrug_birthday date,
	hdrug_type varchar(20),
	hdrug_introduce varchar(256)
);
