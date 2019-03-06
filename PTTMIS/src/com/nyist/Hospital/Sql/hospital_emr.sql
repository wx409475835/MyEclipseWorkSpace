create table hospital_emr(
	hemr_id int(20) not null auto_increment primary key,
	hemr_patientid int(20) not null,
	foreign key(hemr_patientid) references hospital_patient(hp_id),
	hemr_doctorid int(20) default null,
	foreign key(hemr_doctorid) references hospital_doctor(hd_id),
	hemr_starttime varchar(50) default null,
	hemr_endtime varchar(50) default '暂未出院',
	hemr_treatisend varchar(8),
	hemr_diagnosis varchar(20),
	hemr_symptom varchar(256),
	hemr_method varchar(256)
);
