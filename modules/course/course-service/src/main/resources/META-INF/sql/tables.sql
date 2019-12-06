create table Course_Course (
	uuid_ VARCHAR(75) null,
	courseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name STRING null,
	description VARCHAR(75) null,
	lecturer STRING null,
	duration INTEGER,
	status INTEGER
);