create table LDCJargon_LDCJargon (
	ldcJargonId LONG not null primary key,
	name VARCHAR(255) null,
	definition STRING null,
	companyId LONG,
	groupId LONG
);