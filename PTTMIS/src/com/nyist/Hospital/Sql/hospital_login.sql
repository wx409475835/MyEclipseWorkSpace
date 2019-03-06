create table hospital_login(
	hl_username varchar(16) not null,
	hl_password varchar(16),
	hl_doctorid int(20) not null,
	primary key(hl_doctorid,hl_username)
);

