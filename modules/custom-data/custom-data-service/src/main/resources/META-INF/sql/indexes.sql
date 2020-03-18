create index IX_45161A5B on CustomData_CustomData (customString[$COLUMN_LENGTH:75$]);
create index IX_97C1979 on CustomData_CustomData (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_47FEAA3B on CustomData_CustomData (uuid_[$COLUMN_LENGTH:75$], groupId);