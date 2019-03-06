create table hospital_drugstore(
	hds_id int(20) not null auto_increment primary key,
	hds_patientid int(20) not null,
	foreign key(hds_patientid) references hospital_patient(hp_id),
	hds_drugid int(20) not null,
	foreign key(hds_drugid) references hospital_drug(hdrug_id)
);
