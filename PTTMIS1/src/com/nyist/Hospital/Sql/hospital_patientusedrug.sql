create table hospital_patientusedrug(
	hpt_id int(20) not null auto_increment primary key,
	hpt_patientid int(20) references hospital_patient(hp_id),
	hpt_drugid int(20) references hospital_drug(hdrug_id),
	hpt_count int(20) default 1
);