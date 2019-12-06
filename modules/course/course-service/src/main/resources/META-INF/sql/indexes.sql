create index IX_898C5D85 on Course_Course (groupId);
create index IX_298C5F79 on Course_Course (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9B68703B on Course_Course (uuid_[$COLUMN_LENGTH:75$], groupId);