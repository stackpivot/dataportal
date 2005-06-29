alter table  MDAS_TD_DATA_GRP alter column  
       data_grp_name       set data type varchar(1000);

alter table  MDAS_TD_DATA_GRP alter column  
       parent_grp_name     set data type  varchar(1000) ;

create synonym MDAS_AD_2ACCS       for MDAS_AD_ACCS;
 
create table MDAS_TD_DEL_DATA_GRP
      (data_grp_id     varchar(250),
       data_grp_name      varchar(1000),
       parent_grp_name      varchar(1000) ,
       coll_owner integer,
       coll_cr_timestamp varchar(32),
       coll_comments varchar(700),
       coll_lock       integer,
       coll_lockowner      integer DEFAULT  0,
       coll_lockexpiry varchar(32),
       coll_link       integer ,
       coll_mod_timestamp varchar(32)
      ) ;

create table MDAS_AD_DEL_REPL
        (data_id integer  not null,
       repl_enum integer  not null,
       data_name  varchar(250)  not null,
         data_typ_id varchar(250)   not null,
       path_name varchar(699),
       rsrc_id integer  not null,
       repl_timestamp VARCHAR(32)  not null ,
       data_grp_id varchar(250)  not null ,
       data_size integer,
         is_deleted integer not null,
       data_owner integer  not null,
       is_dirty   integer,
       offset     integer,
       container_id integer,
       modify_timestamp varchar(32),
         last_accs_time varchar(32),
       datalock       integer DEFAULT 0,
       lockowner      integer DEFAULT  0,
         version_num    varchar(250) DEFAULT '0',
       container_td_id integer,
         d_comment varchar(250),
       dlockexpiry varchar(32) DEFAULT '0',
       dchecksum varchar(400) DEFAULT '0',
       dhide    integer  DEFAULT 0,
       auditflag   integer DEFAULT 0,
       seg_num integer DEFAULT -1
        ) ;

create table MDAS_AD_GUID
      (data_id integer  not null,
       guid    varchar(400),
       guid_flag integer,
       guid_time_stamp varchar(32)
        );

exit;
