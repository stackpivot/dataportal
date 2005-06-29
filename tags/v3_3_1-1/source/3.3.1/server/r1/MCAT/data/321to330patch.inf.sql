create table MDAS_TD_EXTAB_INFO
      (ext_schema_name  varchar(250),
       ext_table_name  varchar(250),
         ext_attr_name   varchar(250),
         ext_attr_out_name   varchar(250),
         ext_attr_comments   varchar(250)
      );

insert into MDAS_TD_USER_TYP values ('0002','domainadmin');
insert into MDAS_CD_RSRC values (0,'pnull','0000');
update mdas_ad_repl set container_td_id = 0 where container_td_id is null;

insert into mdas_audit_desc (actionDesc,actionid) values ('R_INSERT_FREE_SPACE',201 );
insert into mdas_audit_desc (actionDesc,actionid) values ('R_ADJUST_RSRC_COMMENT',202 );
insert into mdas_audit_desc (actionDesc,actionid) values ('U_CHANGE_INFO',203 );
insert into mdas_audit_desc (actionDesc,actionid) values ('U_ADD_GROUP_OWNER',204);
insert into mdas_audit_desc (actionDesc,actionid) values ('U_REMOVE_GROUP_OWNER',205);
insert into mdas_audit_desc (actionDesc,actionid) values ('U_UPDATE_EMAIL',206);
insert into mdas_audit_desc (actionDesc,actionid) values ('U_UPDATE_PHONE',207);
insert into mdas_audit_desc (actionDesc,actionid) values ('U_UPDATE_ADDRESS',208);
insert into mdas_audit_desc (actionDesc,actionid) values ('BULK_PHY_MOVE',209);
insert into mdas_audit_desc (actionDesc,actionid) values ('BULK_PHY_MOVE_INTO_CONTAINER',210);
insert into mdas_audit_desc (actionDesc,actionid) values ('BULK_REGISTER_REPLICATE',211);
insert into mdas_audit_desc (actionDesc,actionid) values ('D_INSERT_ACCS_BY_CURATOR',3008 );
insert into mdas_audit_desc (actionDesc,actionid) values ('D_DELETE_ACCS_BY_CURATOR',3009 );
insert into mdas_audit_desc (actionDesc,actionid) values ('D_CHANGE_OWNER_BY_CURATOR',3015 );
insert into mdas_audit_desc (actionDesc,actionid) values ('D_INSERT_COLL_ACCS_BY_CURATOR',3027 );
insert into mdas_audit_desc (actionDesc,actionid) values ('D_DELETE_COLL_ACCS_BY_CURATOR',3028 );
insert into mdas_audit_desc (actionDesc,actionid) values ('D_INSERT_INCOLL_ACCS_BY_CURATOR',3127 );
insert into mdas_audit_desc (actionDesc,actionid) values ('D_INSERT_INCOLL_ACCS_RECUR_BY_CURATOR',3128 );
insert into mdas_audit_desc (actionDesc,actionid) values ('D_DELETE_INCOLL_ACCS_BY_CURATOR',3129 );
insert into mdas_audit_desc (actionDesc,actionid) values ('D_DELETE_INCOLL_ACCS_RECUR_BY_CURATOR',3130 );
insert into mdas_audit_desc (actionDesc,actionid) values ('C_CHANGE_COLL_OWNER_BY_CURATOR',3167);
insert into mdas_audit_desc (actionDesc,actionid) values ('D_CHANGE_INCOLL_OWNER_BY_CURATOR',3177);
insert into mdas_audit_desc (actionDesc,actionid) values ('D_CHANGE_INCOLL_OWNER_RECUR_BY_CURATOR',3178 );

insert into MDAS_TD_DATA_TYP values ('0001.0001.0001.0001.000b.0002.0004','PNG-Portable Network Graphics');
insert into MDAS_TD_DATA_TYP values ('0001.0001.0001.0001.000b.0002.0005','MP3 - MPEG Audio');
insert into MDAS_TD_DATA_TYP values ('0001.0001.0001.0001.000b.0002.0006','WMV-Windows Media Video');
insert into MDAS_TD_DATA_TYP values ('0001.0001.0001.0001.000b.0002.0007','BMP -Bit Map');
insert into MDAS_TD_DATA_TYP values ('0001.0001.0001.0001.000r','CSS-Cascading Style Sheet');


insert into MDAS_AT_DATA_TYP_EXT values ('0001.0001.0001.0001.000b.0002.0004','image/png','.png');
insert into MDAS_AT_DATA_TYP_EXT values ('0001.0001.0001.0001.000b.0002.0005','audio/x-mpeg','.mp3,.mpa');
insert into MDAS_AT_DATA_TYP_EXT values ('0001.0001.0001.0001.000b.0002.0006','video/x-wmv','.wmv');
insert into MDAS_AT_DATA_TYP_EXT values ('0001.0001.0001.0001.000b.0002.0007','image/bmp','.bmp');
insert into MDAS_AT_DATA_TYP_EXT values ('0001.0001.0001.0001.000r',' ' ,' ');

update MDAS_AT_DATA_TYP_EXT  set DATA_TYP_MIME = 'audio/x-wav', DATA_TYP_EXT='.wav'
where  DATA_TYP_ID='0001.0001.0001.0001.0007';

exit;

