create table CustomData_CustomData (
	uuid_ VARCHAR(75) null,
	customDataId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	customBoolean BOOLEAN,
	customData DATE null,
	customInt INTEGER,
	customLong LONG,
	customString VARCHAR(75) null
);