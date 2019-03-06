create table hospital_doctor_authority(
	hda_id int(20) not null auto_increment primary key,
	hda_aid int(20) not null,
	foreign key(hda_aid) references hospital_administrator(ha_id),
	hda_authorityid int(20) not null,
	foreign key(hda_authorityid) references hospital_authority(hau_id
));
