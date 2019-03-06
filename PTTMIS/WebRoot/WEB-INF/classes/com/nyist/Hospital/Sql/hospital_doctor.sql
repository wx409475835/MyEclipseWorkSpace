create table hospital_doctor(
	hd_id int(20) not null auto_increment primary key,
	hd_name varchar(16),
	hd_age int(3),
	hd_sex varchar(4),
	hd_speciality varchar(256),
	hd_pt varchar(50),
	hd_ri varchar(256),
	hd_haotoid int(20) not null,
	hd_mobile bigint(50)
);
