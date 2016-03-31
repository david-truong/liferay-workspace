create table FOO_Foo (
	uuid_ VARCHAR(75) null,
	fooId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	field1 VARCHAR(75) null,
	field2 BOOLEAN,
	field3 INTEGER,
	field4 DATE null,
	field5 VARCHAR(75) null
);

create table ROSTER_Club (
	uuid_ VARCHAR(75) null,
	clubId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null
);

create table ROSTER_Roster (
	uuid_ VARCHAR(75) null,
	rosterId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	clubId LONG,
	name VARCHAR(75) null
);

create table ROSTER_RosterMember (
	uuid_ VARCHAR(75) null,
	rosterMemberId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	rosterId LONG,
	contactId LONG
);