create table hospital_fee_settlement(
	hfs_id int(20) not null auto_increment primary key,
	hfs_bedid int(20) not null unique,
	hfs_register int(8) not null unique,
	hfs_patientid int(20) not null unique,
	hfs_ispay varchar(20),
	hfs_allmoney int(20) not null

);
alter table hospital_fee_settlement add constraint hfs foreign key(hfs_bedid) references hospital_beinhospital(hbi_bedid);
