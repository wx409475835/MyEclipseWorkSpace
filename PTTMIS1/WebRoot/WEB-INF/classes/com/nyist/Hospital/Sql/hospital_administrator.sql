create table hospital_administrator(
	ha_id int(20) not null auto_increment,
	ha_username varchar(20) not null,
	ha_account bigint(50) not null,
	ha_password varchar(18),
	primary key(ha_id,ha_username,ha_account)
);

