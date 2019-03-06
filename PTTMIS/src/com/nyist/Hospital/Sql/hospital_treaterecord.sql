create table hospital_treaterecord(
	htr_id int(20) not null auto_increment primary key,
	htr_doctorid int(20) not null,
	foreign key(htr_doctorid) references hospital_doctor(hd_id),
	htr_patientid int(20) not null,
	foreign key(htr_patientid) references hospital_patient(hp_id),
	htr_treatecase varchar(256),
	htr_aotoid int(20) not null,
	foreign key(htr_aotoid) references hospital_aoto(haoto_id),
	htr_treatetimes int(8) default 0,
	htr_treatetime varchar(50)
);
