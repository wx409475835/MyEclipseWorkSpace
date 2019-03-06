create table hospital_reservation(
	hr_id int(20) not null auto_increment primary key,
	hr_personid int(20) not null,
	foreign key(hr_personid) references hospital_patient(hp_id),
	hr_tet datetime,
	hr_title varchar(256),
	hr_content varchar(256)
);
