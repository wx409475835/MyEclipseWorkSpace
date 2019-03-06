create table hospital_treatemoney(
	htm_id int(20) not null auto_increment primary key,
	htm_patientid int(20) not null,
	foreign key(htm_patientid) references hospital_patient(hp_id),
	htm_name varchar(50),
	htm_ispaymoney varchar(10),
	htm_treatmoneytype varchar(20),
	htm_moneyconsum varchar(20),
	htm_consumtime varchar(50)
);
