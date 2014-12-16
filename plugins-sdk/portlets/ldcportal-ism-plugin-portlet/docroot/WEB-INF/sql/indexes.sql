create index IX_E2C746BD on ISM_ISM (groupId);
create index IX_89B2154B on ISM_ISM (groupId, companyId);
create unique index IX_D121D871 on ISM_ISM (groupId, webContentId);
create index IX_19811701 on ISM_ISM (ismId);
create index IX_3797AEC9 on ISM_ISM (ismId, groupId);
create index IX_1D44A6F on ISM_ISM (mbCategoryId);
create index IX_95BC771B on ISM_ISM (mbCategoryId, groupId);
create unique index IX_BB0D2241 on ISM_ISM (webContentId);

create index IX_4ACA62F9 on ISM_ISMApplication (companyId);
create index IX_135153BB on ISM_ISMApplication (groupId);
create index IX_3889A7A1 on ISM_ISMApplication (groupId, status);
create index IX_F48E9905 on ISM_ISMApplication (uuid_);
create unique index IX_97C23145 on ISM_ISMApplication (uuid_, groupId);