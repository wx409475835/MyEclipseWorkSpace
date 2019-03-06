create table hospital_patient(
	hp_id int(20) not null auto_increment primary key,
	hp_doctorid int(20) default null,
	hp_name varchar(20),
	hp_sex varchar(6),
	hp_birthday varchar(50),
	hp_tath varchar(50),
	hp_tsd varchar(256),
	hp_mrid int(20),
	hp_stat varchar(256),
	hp_marry varchar(12)
);
