﻿drop database webtblget;
create database webtblget;
use webtblget;
create table table1(
	term varchar(50),
	lessonNum varchar(50),
	lessonName varchar(50),
	techerName varchar(50),
	kind varchar(50),
	grade varchar(50),
	time varchar(50),
	myPoint varchar(50),
	gradeKind varchar(50),
	remark varchar(50)
);
create table table2(
	numItem varchar(50),
	shops varchar(100),
	baobeiNames varchar(100),
	Specs varchar(100),
	prices varchar(10),
	qutys varchar(10)
);
create table table3(
	csmBNos varchar(50),
	times varchar(50),
	infos varchar(50),
	incomes varchar(50),
	outlays varchar(50),
	balances varchar(50),
	froms varchar(50)
);
create table table4(
	num varchar(20),
	from_phone varchar(20),
	city_code varchar(20),
	to_phone varchar(20),
	time_length varchar(20),
	price varchar(20),
	way varchar(20),
	extend_price varchar(20)
);
create table table5(
	topic varchar(100),
	author varchar(20),
	response varchar(20),
	last_re varchar(20)
);
create table table6(
	Metal varchar(20),
	MelPoint_C varchar(20),
	MelPoint_F varchar(20)
);
create table table7(
	cur_week varchar(20),
	last_week varchar(20),
	num_week varchar(20),
	album varchar(20),
	song varchar(20),
	singer varchar(20),
	company varchar(20),
	top_his varchar(20)
);
create table table8(
	grade varchar(20),
	stuNum varchar(20)
);
create table table9(
	name varchar(30),
	actor varchar(100),
	place varchar(20),
	type varchar(100),
	grade varchar(20)
);
create table table10(
	title varchar(100),
	day varchar(20),
	actor varchar(50),
	type varchar(50),
	scan_num varchar(20)
);