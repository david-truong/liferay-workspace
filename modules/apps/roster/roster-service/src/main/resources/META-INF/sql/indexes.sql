create index IX_CFFD06FF on FOO_Foo (field2);
create index IX_B2FCA947 on FOO_Foo (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_905CD589 on FOO_Foo (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_C897C98A on ROSTER_Roster (clubId);
create index IX_B496332F on ROSTER_Roster (uuid_[$COLUMN_LENGTH:75$]);