create table ISM_ISM (
	ismId LONG not null primary key,
	webContentId LONG,
	moderatorId LONG,
	companyId LONG,
	groupId LONG,
	mbCategoryId LONG,
	assetCategoryId LONG
);

create table ISM_ISMApplication (
	uuid_ VARCHAR(75) null,
	ismApplicationId LONG not null primary key,
	country VARCHAR(75) null,
	ismId LONG,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	companyId LONG,
	groupId LONG,
	userId LONG,
	applicationReason VARCHAR(75) null,
	applicationAdditional VARCHAR(75) null
);