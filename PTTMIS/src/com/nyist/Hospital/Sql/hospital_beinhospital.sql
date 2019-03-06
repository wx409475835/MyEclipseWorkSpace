create table hospital_beinhospital(
	hbi_id int(20) not null auto_increment primary key,
	hbi_patientid int(20) not null,
	foreign key(hbi_patientid) references hospital_patient(hp_id),
	hbi_doctorid int(20) not null,
	foreign key(hbi_doctorid) references hospital_doctor(hd_id),
	hbi_register int(8) not null,
	hbi_bedid int(20) not null
);
