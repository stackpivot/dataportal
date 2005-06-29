/**************************************************************************
Copyright Notice
All Rights Reserved
Please refer to files in COPYRIGHT directory under the SRB software directory 
for copyright, usage, liability and license information.
Please read these files before using,modifying or distributing SRB software.
**************************************************************************/

#ifndef MDASGLOBALS_H
#define MDASGLOBALS_H

#include "mdasC_db2_externs.h"
#include "srbC_mdas_externs.h"


char MDASDBTYPE[MAX_TOKEN];
char MDASSCHEMENAME[MAX_TOKEN];
char MDASDBNAME[MAX_TOKEN];
char MDASINSERTSFILE[MAX_TOKEN];
char MDASCATEXECTYPE[MAX_TOKEN];
char MDASCATRSRCIC[MAX_TOKEN];
char DB2INSTANCE[MAX_TOKEN];
char DB2PASSWORD[MAX_TOKEN];
char DB2USER[MAX_TOKEN];
char DB2LOGFILE[MAX_TOKEN];
char DBHOME[MAX_TOKEN];
char db2instancebuffer[MAX_TOKEN];
char metadatafkrelbuffer[MAX_TOKEN];

int TABLED_EXISTS_DATA_COUNTER;
int TABLED_SINGLE_DATA_COUNTER;
int TABLED_GETDATASETINFO_COUNTER;
char *tabledExistsDataQuery[MAX_TABLED_EXISTS_DATA_COUNTER];
char *tabledSingleDataQuery[MAX_TABLED_SINGLE_DATA_COUNTER];
char *tabledSingleDataResult[MAX_TABLED_SINGLE_DATA_COUNTER];
getDatasetInfoStruct tabledGetDatasetInfo[MAX_TABLED_GETDATASETINFO_COUNTER];
int tabledIsOkay = 0;
int ALLOW_NON_CHECKING_REGISTERY_OF_DATA = 0;
int showQuery = 0;

int distinct_flag = 1;
int best_response_flag = 0;
int outer_join_flag = 0;
char groupByList[HUGH_HUGE_STRING];
int   cur_pds_num;
FILE *INSMESSFILE;

int audit_flag  = 0;
int auditLevel  = 0;


char catser[MAX_TOKEN];
char cattype[MAX_TOKEN];
char user[MAX_TOKEN];
char pass[MAX_TOKEN];
char instance[MAX_TOKEN];
char exec_type[MAX_TOKEN];
char rsrc_id[SMALL_TOKEN];
  char   server[SMALL_TOKEN];
  char   uid[SMALL_TOKEN];
  char   pwd[SMALL_TOKEN];
char dbhome[MAX_TOKEN];
char GENERATEDSQL[HUGH_HUGE_STRING];
long int             henv = -1;
long int             hdbc;
mdasC_status         status;  

char atname[SMALL_TOKEN][MAX_TOKEN];
char atval[SMALL_TOKEN][MAX_DATA_SIZE];
char cval[SMALL_TOKEN][MAX_TOKEN];
char chval[MAX_TOKEN];
int  ival[SMALL_TOKEN];
int intval, intval2, intval3;
char timeval[SMALL_TOKEN];
char genGuidFlag[MAX_TOKEN];

char newglobalerror[HUGE_STRING]; 
char oldglobalerror[HUGE_STRING]; 

char query_string[HUGE_STRING];
char query_string2[HUGE_STRING];

int res;
int failure = 0;

    long int   hstmt;
    int i,j,k;
    char sqlq[HUGE_STRING];
    char spsqlq[HUGE_STRING];
    char errmess[HUGE_STRING];
    char tabname[MAX_TOKEN];
    short int            num_of_cols;
    unsigned char       *data[MAX_ROW];
    long int             data_size[MAX_ROW];


mdasC_servh  serverhndl[MAX_SERVERS];
mdasC_sql_continuation_struct queryCont[MAX_QUERY_LIMIT];


/**** needed by database drivers DAI ****/
char *Db2Home = NULL;
char *IllusHome = NULL;
char *OracleHome = NULL;
char *InformixHome = NULL;
char *PostgresHome = NULL;
char *SybaseHome = NULL;
char *MysqlHome = NULL;

char Db2HomeStr[200];
char IllusHomeStr[200];
char OracleHomeStr[200];
char InformixHomeStr[200];
char PostgresHomeStr[200];
char SybaseHomeStr[200];
char MysqlHomeStr[200];
/**** needed by database drivers DAI ****/

char reg_registrar_name[MAX_TOKEN];
int  reg_registrar_id;
char reg_obj_name[MAX_OBJ_NAME_LENGTH];
int  reg_obj_id;
int  reg_obj_repl_enum;
char reg_obj_code[MAX_TOKEN];
char reg_timeval[MAX_TOKEN];
char reg_action_name[MAX_TOKEN];

int accsIdList[SMALL_TOKEN] = {
  0,10,20,30,33,36,40,50,140,150,998,999,2998,2999,-1};
char accsNameList[SMALL_TOKEN][SMALL_TOKEN] = {
"null","execute","read audit","read","annotate audit","annotate","write audit",
"write","create audit","create","all audit","all","curate audit","curate","empty"};

int curUserId = -1;
int isUserDomainAdminFlag = 0;
int getDatasetQuery =  0;
int specialQueryFlag =  0;
char *specialQueryString = NULL;
char  specialOrderByClause[MAX_TOKEN * 2] = "";
char localZoneForMcat[MAX_TOKEN * 2] = "";
char *protectedDataTableList[] = {
"MDAS_AD_REPL",
"MDAS_AD_MDATA",
"null"
};
char *protectedCollTableList[] = {
"MDAS_TD_DATA_GRP",
"MDAS_AD_COLLMDATA",
"MDAS_TD_DATA_2GRP",
"null"
};
char protectedTableValue[10][MAX_TOKEN];
char  installSRBUser[SMALL_TOKEN][MAX_TOKEN] = {
"unknown",
"public",
"srb",
"npaci",
"sdsc",
"testuser",
"ticketuser",
"system",
""
};


char  dcs_tname[MAX_DCS_STRUCTS][MAX_TOKEN] = {
"MDAS_AD_REPL",
"MDAS_ADC_REPL",
"MDAS_AD_REPL",
"MDAS_CD_PAR_USER",
"MDAS_TD_DATA_TYP",
"MDAS_TD_USER_TYP"  ,
"MDAS_AU_INFO",
"MDAS_CD_USER",
"MDAS_TD_DS_ACCS",
"MDAS_TD_DOMN",
"MDAS_ADC_REPL",               /* 10 */
"MDAS_AR_REPL",
"MDAS_TD_LOCN",
"MDAS_TD_RSRC_TYP",
"MDAS_AD_REPL",
"MDAS_TD_DATA_GRP",
"MDAS_AU_INFO",
"MDAS_AU_INFO",
"MDAS_AD_REPL",
"MDAS_AU_AUDIT" ,
"MDAS_AU_AUDIT",             /* 20 */
"MDAS_AD_REPL" ,
"MDAS_TD_ACTN"  ,
"MDAS_AD_AUDIT" ,
"MDAS_AD_AUDIT",
"MDAS_TD_GRP_ACCS",
"MDAS_TD_DATA_2GRP",
"MDAS_AR_REPL",
"MDAS_AR_PHYSICAL",
"MDAS_AR_PHYSICAL",
"MDAS_TD_RSRC_2TYP",         /* 30 */
"MDAS_AR_REPL",
"MDAS_TD_DS_ACCS",
"MDAS_TD_RSRC_ACCS",
"MDAS_AD_REPL",
"MDAS_CD_OWNER_USER",
"MDAS_AU_TCKT_DATA",
"MDAS_AU_TCKT_DATA",
"MDAS_AU_TCKT_DATA",
"MDAS_AU_TCKT_DATA",
"MDAS_TD_DSTKT_ACCS",        /* 40 */
"MDAS_CD_DTKTOWNER",
"MDAS_CD_DTKTUSER",
"MDAS_AU_TCKT_GRP",
"MDAS_AU_TCKT_GRP",
"MDAS_AU_TCKT_GRP",
"MDAS_AU_TCKT_GRP",
"MDAS_TD_GRTKT_ACCS",
"MDAS_CD_CTKTOWNER",
"MDAS_CD_CTKTUSER",
"MDAS_TD_CTKTU_DOMN",       /* 50 */
"MDAS_TD_DTKTU_DOMN",
"MDAS_TD_CTKTO_DOMN",
"MDAS_TD_DTKTO_DOMN",
"MDAS_TD_DATA_GRP",
"MDAS_TD_LOCN",
"MDAS_AD_REPL",
"MDAS_TD_CONTAINER",
"MDAS_TD_CONTAINER",
"MDAS_TD_RSRC_CLASS",
"MDAS_AR_PHYSICAL",            /* 60 */
"MDAS_AD_REPL",
"MDAS_AR_1PHYSICAL",
"MDAS_TD_1RSRC_CLASS",
/*"MDAS_ADCONT_REPL", */
"MDAS_ADC_REPL",
"MDAS_AR_1REPL",
"MDAS_TD_OWNER_DOMN",
"MDAS_AU_AUTH_MAP",
"MDAS_TD_AUTH_SCHM",
"MDAS_TD_SRVR_LOCN",
"MDAS_TD_SRVR_LOCN",       /*  70 */
"MDAS_AD_REPL",
"MDAS_CD_ANNO_USER",
"MDAS_TD_ANNO_DOMN",
"MDAS_AD_ANNOTATION",
"MDAS_AD_ANNOTATION",
"MDAS_AD_REPL",
"MDAS_AD_COMMENTS",
"MDAS_AD_ANNOTATION",
"MDAS_TD_DS_ACCS",
"MDAS_AR_INFO",            /*  80 */
"MDAS_AR_INFO",
"MDAS_AR_INFO",
"MDAS_AR_INFO",
"MDAS_AR_INFO",
"MDAS_AR_INFO",
"MDAS_AR_INFO",
"MDAS_AR_INFO",
"MDAS_AD_CLASS",
"MDAS_AD_CLASS",
"MDAS_AD_STRCT_BLOB",     /*   90   */
"MDAS_AD_STRCT_BLOB",
"MDAS_ADSTRUCT_REPL",
"MDAS_AD_STRCT_BLOB",
"MDAS_ADIXDS_REPL",
"MDAS_ADIXDTP_REPL",
"MDAS_ADIXCOLL_REPL",
"MDAS_ADMTHDS_REPL",
"MDAS_ADMTHDTP_REPL",
"MDAS_ADMTHCOL_REPL",
"MDAS_TD_DGRP_IXDS",     /*   100 */
"MDAS_TD_DGRP_IXDTP",
"MDAS_TD_DGRP_IXCOL",
"MDAS_TD_DGRP_MTHDS",
"MDAS_TD_DGRP_MTDTP",
"MDAS_TD_DGRP_MTCOL",
"MDAS_TD_DTYP_IXDS",
"MDAS_TD_DTYP_IXDTP",
"MDAS_TD_DTYP_IXCOL",
"MDAS_TD_DTYP_MTHDS",
"MDAS_TD_DTYP_MTDTP",   /*  110 */
"MDAS_TD_DTYP_MTCOL",
"MDAS_TD_DGRP_STRUC",
"MDAS_ADIXDS_REPL",
"MDAS_ADIXDTP_REPL",
"MDAS_ADIXCOLL_REPL",
"MDAS_AD_MDATA",
"MDAS_AD_MDATA",
"MDAS_AD_MDATA",
"MDAS_AD_MDATA",
"MDAS_AD_MDATA",        /* 120   */
"MDAS_AD_MDATA",
"MDAS_AD_MDATA",
"MDAS_AD_MDATA",
"MDAS_AD_MDATA",
"MDAS_AD_MDATA",
"MDAS_AD_MDATA",
"MDAS_AD_MDATA",
"MDAS_AD_MDATA",
"MDAS_AU_OWNER_INFO",
"MDAS_CD_DAUDT_USER",     /* 130 */
"MDAS_TD_DAUDT_DOMN",
"MDAS_TD_COLLCONT",
"MDAS_AD_COLLMDATA",
"MDAS_AD_COLLMDATA",
"MDAS_AD_COLLMDATA",
"MDAS_AD_COLLMDATA",
"MDAS_AD_COLLMDATA",
"MDAS_AD_COLLMDATA",
"MDAS_AD_COLLMDATA",
"MDAS_AD_COLLMDATA",     /* 140 */
"MDAS_AD_COLLMDATA",
"MDAS_AD_COLLMDATA",
"MDAS_AD_COLLMDATA",
"MDAS_AD_COLLMDATA",
"MDAS_AD_COLLMDATA",
"MDAS_TD_DS_ACCS",
"MDAS_CD_USER",
"MDAS_AD_REPL",
"MDAS_CD_COOWN_USER",
"MDAS_TD_DATA_GRP",           /* 150 */
"MDAS_TD_DATA_GRP",
"DC_DATA",
"DC_COLLECTION",
"DC_TD_CONTR_TYPE",
"DC_TD_SUBJ_CLASS",
"DC_TD_DESCR_TYPE",
"DC_TD_TYPE",
"DC_TD_SOURCE_TYPE",
"DC_TD_LANGUAGE",
"DC_TD_RELATION_TYP",    /* 160 */
"DC_TD_COVERAGE",
"DC_TD_RIGHTS",
"DC_TITLE",
"DC_AUTHCONTRIB",
"DC_SUBJECT",
"DC_DESCRIPTION",
"DC_PUBLISHER",
"DC_SOURCE",
"DC_RELATION",
"MDAS_AD_DCRELREPL",    /* 170 */
"MDAS_TD_DCRELGRP",
"DC_COVERAGE",
"DC_RIGHTS",
"DC_PUBLISHER",
"DC_AUTHCONTRIB",
"DC_AUTHCONTRIB",
"DC_AUTHCONTRIB",
"DC_AUTHCONTRIB",
"DC_AUTHCONTRIB",
"MDAS_AD_GRP_2ACCS",      /* 180 */
"MDAS_TD_IDGRPUSER2",
"MDAS_AD_2ACCS",
"MDAS_TD_IDGRPUSER1",
"MDAS_AD_1MDATA",
"MDAS_AD_2MDATA",
"MDAS_AD_3MDATA",
"MDAS_AD_4MDATA",
"MDAS_AD_1MDATA",
"MDAS_AD_2MDATA",
"MDAS_AD_3MDATA",         /* 190 */
"MDAS_AD_4MDATA",
"MDAS_AD_1COLLMDATA",
"MDAS_AD_2COLLMDATA",
"MDAS_AD_3COLLMDATA",
"MDAS_AD_4COLLMDATA",
"MDAS_AD_1COLLMDATA",
"MDAS_AD_2COLLMDATA",
"MDAS_AD_3COLLMDATA",
"MDAS_AD_4COLLMDATA",
"MDAS_AU_TCKT_GRP",                 /* 200 */
"MDAS_AR_1MDATA",
"MDAS_AR_2MDATA",
"MDAS_AR_3MDATA",
"MDAS_AR_1MDATA",
"MDAS_AR_2MDATA",
"MDAS_AR_3MDATA",
"MDAS_AU_1MDATA",
"MDAS_AU_2MDATA",
"MDAS_AU_3MDATA",
"MDAS_AU_1MDATA",       /* 210  */
"MDAS_AU_2MDATA",
"MDAS_AU_3MDATA",
"MDAS_AR_TAPE_INFO",
"MDAS_AR_TAPE_INFO",
"MDAS_AR_TAPE_INFO",
"MDAS_AR_TAPE_INFO",
"MDAS_AR_TAPE_INFO",
"MDAS_AR_TAPE_INFO",
"MDAS_AR_TAPE_INFO",
"MDAS_AR_TAPE_INFO",        /* 220 */
"MDAS_AD_REPL",
"MDAS_AD_REPL",
"MDAS_TD_LCK_ACCS",
"MDAS_CD_DLOWN_USER",
"MDAS_TD_DLOWN_DOMN",
"MDAS_TD_COOWN_DOMN",
"MDAS_TD_DATA_3GRP",
"MDAS_TD_DATA_3GRP",
"MDAS_TD_DATA_3GRP",   
"MDAS_CD_CANNO_USER",    /* 230 */
"MDAS_TD_CANNO_DOMN",
"MDAS_AC_ANNOTATION",
"MDAS_AC_ANNOTATION",
"MDAS_AC_ANNOTATION",
"MDAS_TD_DATA_GRP",
"MDAS_AD_REPL",
"MDAS_AD_REPL",
"MDAS_AD_REPL",
"MDAS_AD_REPL",
"MDAS_AD_MISC1",        /* 240 */
"MDAS_CD_PIN_USER",
"MDAS_TD_PIN_DOMN",
"MDAS_AD_MISC1",
"MDAS_AD_MISC1",
"MDAS_AD_MISC1",
"MDAS_AD_MISC1",
"MDAS_AD_MISC1",
"MDAS_AUDIT_DESC",
"MDAS_AUDIT",
"MDAS_AUDIT",        /* 250 */
"MDAS_AR_MDATA",
"MDAS_AR_MDATA",
"MDAS_AR_MDATA",
"MDAS_AR_MDATA",
"MDAS_AR_MDATA",
"MDAS_AR_MDATA",
"MDAS_AR_MDATA",
"MDAS_AR_MDATA",
"MDAS_AR_MDATA",
"MDAS_AR_MDATA",        /* 260 */
"MDAS_AR_MDATA",
"MDAS_AR_MDATA",
"MDAS_AU_MDATA",
"MDAS_AR_2PHYSICAL",
"MDAS_ADC_REPL",
"MDAS_AD_COMPOUND",
"MDAS_AD_COMPOUND",
"MDAS_AD_COMPOUND",
"MDAS_AR_3PHYSICAL",
"MDAS_TD_INT_LOCN",      /* 270 */
"MDAS_TD_RSRC_3TYP",
"MDAS_AD_COMPOUND",
"MDAS_TD_2RSRC_CLASS",
"MDAS_AD_COMPOUND",
"MDAS_AD_COMPOUND",
"MDAS_CD_CANNO_USER",
"MDAS_TD_CANNO_DOMN",
"MDAS_AD_1COMPOUND",
"MDAS_TD_DATA_GRP",
"USEREXTRA",     /* "MDAS_TD_DATA_4GRP",  280 */
"MDAS_ADC_REPL",
"MDAS_TD_DATA_5GRP",
"MDAS_AU_MDATA",
"MDAS_AU_MDATA",
"MDAS_AU_MDATA",
"MDAS_AU_MDATA",
"MDAS_AU_MDATA",
"MDAS_AU_MDATA",
"MDAS_AU_MDATA",
"MDAS_AU_MDATA",           /* 290 */
"MDAS_AU_MDATA",
"MDAS_AU_MDATA",
"MDAS_AU_MDATA",
"NONDISTINCT",
"MDAS_TD_UDF",
"MDAS_TD_UDF",
"MDAS_TD_UDF",
"MDAS_TD_UDF",
"MDAS_TD_UDF",
"MDAS_TD_ZONE",                 /* 300 */
"MDAS_TD_ZONE",
"MDAS_TD_ZN_LOCN",
"MDAS_TD_ZONE",
"MDAS_TD_ZN_ATHSCHM",
"MDAS_AU_ZN_ATHMAP",
"MDAS_TD_ZONE",
"MDAS_TD_ZONE",
"MDAS_TD_ZONE",
"MDAS_TD_ZONE",
"MDAS_TD_ZONE",                 /* 310 */
"MDAS_CD_ZN_USER",
"MDAS_TD_ZN_DOMN",
"MDAS_TD_RSRC_ACCS",
"MDAS_TD_RSRC_ACCS",
"MDAS_AU_MDATA",
"MDAS_AR_MDATA",
"MDAS_CD_PAR_USER",
"MDAS_CD_PAR_USER",
"MDAS_TD_PAR_DOMN",
"MDAS_AD_MDATA",                /* 320 */
"MDAS_AD_COLLMDATA",
"MDAS_AU_MDATA",
"MDAS_AR_MDATA",
"MDAS_AT_DATA_TYP_EXT",
"MDAS_AT_DATA_TYP_EXT",
"MDAS_AR_REPL",
"MDAS_AR_REPL",
"MDAS_AR_REPL",
"MDAS_CD_USER",
"MDAS_CD_USER",             /* 330 */
"MDAS_AR_REPL",
"MDAS_CD_RS_USER",
"MDAS_TD_RS_DOMN",
"MDAS_AR_INFO",
"MDAS_AR_INFO",
"MDAS_AR_INFO",
"MDAS_AR_INFO",   
"MDAS_AR_INFO",
"MDAS_AR_INFO",
"MDAS_AR_INFO",             /* 340 */
"MDAS_CD_RSAC_USER",
"MDAS_TD_RSAC_DOMN",
"MDAS_CD_RSAC_USER",
"MDAS_CD_RS_USER",
"MDAS_CD_OWNER_USER",
"MDAS_CD_DTKTOWNER",
"MDAS_CD_DTKTUSER",   
"MDAS_CD_CTKTOWNER",
"MDAS_CD_CTKTUSER",
"MDAS_CD_ANNO_USER",             /* 350 */
"MDAS_CD_DAUDT_USER",
"MDAS_CD_COOWN_USER",
"MDAS_CD_DLOWN_USER",
"MDAS_CD_CANNO_USER",
"MDAS_CD_PIN_USER",
"MDAS_CD_CANNO_USER",
"MDAS_TD_PAR_LOCN",   
"MDAS_TD_RSRC_ACCS",
"MDAS_TD_DTYP_PARENT",
"MDAS_TD_ZN_LOCN",             /* 360 */
"MDAS_TD_PARDOMN",
"MDAS_TD_UTYP_PARENT",
"MDAS_TD_RSRC_PARENT",
"MDAS_CD_RAGRP_USER",
"MDAS_TD_RAGRP_DOMN",
"MDAS_CD_RAGRP_USER",
"MDAS_TD_DATA_GRP",   
"MDAS_CD_DAGRP_USER",
"MDAS_TD_DAGRP_DOMN",
"MDAS_CD_DAGRP_USER",             /* 370 */
"MDAS_CD_CAGRP_USER",
"MDAS_TD_CAGRP_DOMN",
"MDAS_CD_CAGRP_USER",
"MDAS_TD_CADATA_GRP",
"MDAS_TD_CAGRP_ACCS",
"MDAS_TD_CCDATA_TYP",
"MDAS_AD_MDATA",     
"MDAS_AD_COLLMDATA",
"MDAS_AR_MDATA",
"MDAS_AU_MDATA",        /* 380 */
"MDAS_AD_REPL",
"MDAS_AD_GUID",
"MDAS_AD_GUID",
"MDAS_AD_GUID",
"MDAS_TD_ORDERBY",
"MDAS_AD_DEL_REPL",
"MDAS_AD_DEL_REPL",   
"MDAS_AD_DEL_REPL",
"MDAS_AD_DEL_REPL",
"MDAS_TD_DEL_DATA_GRP",       /* 390 */
"MDAS_AD_DEL_REPL",
"MDAS_AD_DEL_REPL",
"MDAS_AR_PHYSICAL",
"MDAS_AR_PHYSICAL",
"MDAS_TD_EXTAB_INFO",
"MDAS_TD_EXTAB_INFO",
"MDAS_TD_EXTAB_INFO",   
"MDAS_TD_EXTAB_INFO",
"MDAS_TD_EXTAB_INFO",
"USEREXTRA",             /* 400 */
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",   
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",             /* 410 */
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",   
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",             /* 420 */
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",   
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",             /* 430 */
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",   
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",             /* 440 */
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",   
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",             /* 450 */
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",   
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",             /* 460 */
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",   
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",             /* 470 */
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",   
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",             /* 480 */
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",   
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",             /* 490 */
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",
"USEREXTRA",   
"USEREXTRA",
"USEREXTRA"
};
char  dcs_aname[MAX_DCS_STRUCTS][MAX_TOKEN] = {
"data_id",
"repl_enum",
"data_name",
"user_name",
"data_typ_name",
"user_typ_name",
"user_address",
"user_name",
"access_constraint",
"domain_desc",
"path_name",              /* 10 */
"rsrc_name",
"netprefix",
"rsrc_typ_name",
"modify_timestamp",
"data_grp_name",
"user_phone",
"user_email",
"data_size",
"time_stamp" ,
"comments",               /* 20 */
"d_comment",
"action_desc",
"time_stamp",
"comments",
"access_constraint",
"data_grp_name",
"default_path",
"phy_default_path",
"phy_rsrc_name",
"rsrc_typ_name",        /* 30 */
"repl_enum",
"access_list",
"access_list",
"is_deleted",
"user_name",
"ticket_id",
"begin_time",
"end_time",
"access_count",
"access_constraint",      /* 40 */
"user_name",        
"user_name",
"ticket_id",
"begin_time",
"end_time",
"access_count",
"access_constraint",
"user_name",
"user_name",
"domain_desc",             /* 50 */
"domain_desc",
"domain_desc",
"domain_desc",
"parent_grp_name",
"locn_desc",
"is_dirty",
"container_max_size",
"container_name",
"rsrc_class_name",
"max_obj_size",  /*  60 */
"offset",
"phy_rsrc_name",
"rsrc_class_name",
"data_size",
"rsrc_name",
"domain_desc",
"distin_name",
"auth_scheme",
"locn_desc",
"netprefix",     /*  70 */
"repl_enum",
"user_name",
"domain_desc",
"annotations",
"anno_date",
"repl_timestamp",
"com_date",
"anno_position",
"access_privilege",
"mlsec_latency_max",   /*  80 */
"mlsec_latency_min",
"mbps_bandwidth",
"concurrency_max",
"num_of_hierarchies",
"num_of_stripes",
"megab_capacity",
"description",
"class_name",
"class_type",
"structure_type",         /*  90  */
"structure_comments",
"data_name",
"internal_structure",
"data_name",
"data_name",
"data_name",
"data_name",
"data_name",
"data_name",
"data_grp_name",        /* 100 */
"data_grp_name",
"data_grp_name",
"data_grp_name",
"data_grp_name",
"data_grp_name",
"data_typ_name",
"data_typ_name",
"data_typ_name",
"data_typ_name",
"data_typ_name",       /*  110  */
"data_typ_name",
"data_grp_name",
"path_name",
"path_name",
"path_name",
"metadatanum",
"userdef_metastr0",
"userdef_metastr1",
"userdef_metastr2",
"userdef_metastr3",    /*  120  */
"userdef_metastr4",
"userdef_metastr5",
"userdef_metastr6",
"userdef_metastr7",
"userdef_metastr8",
"userdef_metastr9",
"userdef_metaint0",
"userdef_metaint1",
"user_email",
"user_name",          /*  130  */
"domain_desc",
"container_name",
"metadatanum",
"userdef_metastr0",
"userdef_metastr1",
"userdef_metastr2",
"userdef_metastr3",
"userdef_metastr4",
"userdef_metastr5",
"userdef_metastr6",   /*  140  */
"userdef_metastr7",
"userdef_metastr8",
"userdef_metastr9",
"userdef_metaint0",
"userdef_metaint1",
"access_id",
"user_id",
"last_accs_time",
"user_name",
"coll_cr_timestamp",             /*  150  */
"coll_comments",
"data_name",
"data_grp_name",
"dc_contr_type_name",
"dc_subj_class_name",
"dc_desc_type_name",
"dc_type_name",
"source_type_name",
"language_name",
"relation_type_name",   /*  160  */
"coverage_type_name",
"rights_type_name",
"dc_title",
"dc_contr_name",
"dc_subject_name",
"dc_desc",
"dc_pub_name",
"source_desc",
"related_data_desc",
"data_name",              /*  170  */
"data_grp_name",
"coverage_desc",
"rights_data_desc",
"dc_pub_addr",
"dc_contr_address",
"dc_contr_email",
"dc_contr_phone",
"dc_contr_web",
"dc_contr_corp_name",
"access_id",           /*  180  */
"user_id",
"access_id",
"user_id",
"userdef_metastr0",
"userdef_metastr0",
"userdef_metastr0",
"userdef_metastr0",
"userdef_metastr1",
"userdef_metastr1",    
"userdef_metastr1",    /* 190 */
"userdef_metastr1",
"userdef_metastr0",
"userdef_metastr0",
"userdef_metastr0",
"userdef_metastr0",
"userdef_metastr1",
"userdef_metastr1",
"userdef_metastr1",
"userdef_metastr1",
"is_recursive",             /*  200  */
"userdef_metastr0",
"userdef_metastr0",
"userdef_metastr0",
"userdef_metastr1",
"userdef_metastr1",
"userdef_metastr1",
"userdef_metastr0",
"userdef_metastr0",
"userdef_metastr0",
"userdef_metastr1",        /* 210 */
"userdef_metastr1",
"userdef_metastr1",
"tapeNumber",
"tapeOwner",
"tapeType",
"tapeLibInx",
"fullFlag",
"currentFileSeqNum",
"currentAbsPosition",
"bytesWritten",             /*  220  */
"version_num",
"datalock",
"access_constraint",
"user_name",
"domain_desc",
"domain_desc",
"data_grp_name",
"coll_cr_timestamp",
"coll_comments",
"user_name",      /*  230  */
"domain_desc",
"annotations",
"anno_date",
"anno_type",
"data_grp_id",
"dhide",
"dchecksum",
"auditflag",
"dlockexpiry",
"dpin",             /*  240  */
"user_name",
"domain_desc",
"dpinexpiry",
"dexpire_date",
"dcompressed",
"dencrypted",
"dexpire_date_2",
"actionDesc",
"aud_timestamp",
"aud_comments",          /*  250  */
"userdef_metastr0",
"userdef_metastr1",
"userdef_metastr2",
"userdef_metastr3",
"userdef_metastr4",
"userdef_metastr5",
"userdef_metastr6",
"userdef_metastr7",
"userdef_metastr8",         
"userdef_metastr9",       /*  260  */
"userdef_metaint1",
"metadatanum",
"metadatanum",
"phy_rsrc_name",
"seg_num",
"int_repl_num",
"int_seg_num",
"cmpd_path_name",
"phy_rsrc_name",
"netprefix",             /* 270 */
"rsrc_typ_name",
"is_dirty",
"rsrc_class_name",
"offset",
"data_size",
"user_name",
"domain_desc",
"cmpd_path_name",
"coll_link",
"extra",     /* "data_grp_name", 280 */
"data_name",
"data_grp_name",
"userdef_metastr0",
"userdef_metastr1",
"userdef_metastr2",
"userdef_metastr3",
"userdef_metastr4",
"userdef_metastr5",
"userdef_metastr6",
"userdef_metastr7",         /* 290 */
"userdef_metastr8",
"userdef_metastr9",
"userdef_metaint0",
"nondistinct",
"udf",
"udf",
"udf",
"udf",
"udf",
"zone_id",                 /* 300 */
"local_zone_flag",
"netprefix",
"port_number",
"auth_scheme",
"distin_name",
"zone_status",
"zone_create_date",
"zone_modify_date",
"zone_comments",
"zone_contact",           /* 310 */
"user_name",
"domain_desc",
"access_privilege",
"access_constraint",
"userdef_metaint1",
"userdef_metaint1",
"user_modify_date",
"zone_id",
"domain_desc",
"userdef_modif_date",                 /* 320 */
"userdef_modif_date",
"userdef_modif_date",
"userdef_modif_date",
"data_typ_mime",
"data_typ_ext",
"rsrc_comments",
"rsrc_creation_date",
"rsrc_modify_date",
"user_creation_date",
"user_modify_date",                 /* 330 */
"max_obj_size",
"user_name",
"domain_desc",
"mlsec_latency_max",
"mlsec_latency_min",
"mbps_bandwidth",
"concurrency_max",
"num_of_hierarchies",
"num_of_stripes",
"megab_capacity",                 /* 340 */
"user_name",
"domain_desc",
"zone_id",
"zone_id",
"zone_id",
"zone_id",
"zone_id",
"zone_id",
"zone_id",
"zone_id",                 /* 350 */
"zone_id",
"zone_id",
"zone_id",
"zone_id",
"zone_id",
"zone_id",
"locn_desc",
"access_id",
"data_typ_name",
"locn_desc",                 /* 360 */
"domain_desc",
"user_typ_name",
"rsrc_typ_name",
"user_name",
"domain_desc",
"zone_id",
"coll_mod_timestamp",
"user_name",
"domain_desc",
"zone_id",                /* 370 */
"user_name",
"domain_desc",
"zone_id",  
"data_grp_name",
"access_constraint",
"data_typ_name",
"userdef_creat_date",
"userdef_creat_date",
"userdef_creat_date",
"userdef_creat_date",                 /* 380 */
"container_id",
"guid",
"guid_flag",
"guid_time_stamp",
"orderby",
"data_id",
"repl_enum",
"data_name",
"repl_timestamp",
"data_grp_name",                 /* 390 */
"data_grp_id",
"d_comment",
"free_space",
"fs_timestamp",
"ext_schema_name",
"ext_table_name",
"ext_attr_name",
"ext_attr_out_name",
"ext_attr_comments",
"extra",                 /* 400 */
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",                 /* 410 */
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",                 /* 420 */
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",                 /* 430 */
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",                 /* 440 */
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",                 /* 450 */
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",                 /* 460 */
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",                 /* 470 */
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",                 /* 480 */
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",                 /* 490 */
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra",
"extra"
};

char  dcs_cname[MAX_DCS_STRUCTS][MAX_TOKEN] = {
"DATA_ID",
"DATA_REPL_ENUM",
"DATA_NAME",
"USER_GROUP_NAME",
"DATA_TYP_NAME",
"USER_TYP_NAME",
"USER_ADDRESS",
"USER_NAME",
"ACCESS_CONSTRAINT",
"DOMAIN_DESC",
"PATH_NAME",
"RSRC_NAME",
"RSRC_ADDR_NETPREFIX",
"RSRC_TYP_NAME",
"REPL_TIMESTAMP",
"DATA_GRP_NAME",
"USER_PHONE",
"USER_EMAIL",
"SIZE",
"USER_AUDIT_TIME_STAMP",
"USER_AUDIT_COMMENTS",
"DATA_COMMENTS",
"AUDIT_ACTION_DESC",
"AUDIT_TIMESTAMP",
"AUDIT_COMMENTS",
"COLLECTION_ACCESS_CONSTRAINT",
"ACCESS_COLLECTION_NAME",
"RSRC_DEFAULT_PATH",
"PHY_RSRC_DEFAULT_PATH",
"PHY_RSRC_NAME",
"PHY_RSRC_TYP_NAME",
"RSRC_REPL_ENUM",
"DATA_ACCESS_LIST",
"RSRC_ACCESS_LIST",
"DATA_IS_DELETED",
"DATA_OWNER",
"TICKET_D",
"TICKET_BEGIN_TIME_D",
"TICKET_END_TIME_D",
"TICKET_ACC_COUNT_D",
"TICKET_ACC_LIST_D",
"TICKET_OWNER_D",
"TICKET_USER_D",
"TICKET_C",
"TICKET_BEGIN_TIME_C",
"TICKET_END_TIME_C",
"TICKET_ACC_COUNT_C",
"TICKET_ACC_LIST_C",
"TICKET_OWNER_C",
"TICKET_USER_C",
"TICKET_USER_DOMAIN_C",
"TICKET_USER_DOMAIN_D",
"TICKET_OWNER_DOMAIN_C",
"TICKET_OWNER_DOMAIN_D",
"PARENT_COLLECTION_NAME",
"LOCATION_NAME",
"IS_DIRTY",
"CONTAINER_MAX_SIZE",
"CONTAINER_NAME",
"RSRC_CLASS",
"MAX_OBJ_SIZE",
"OFFSET",
"CONTAINER_RSRC_NAME",
"CONTAINER_RSRC_CLASS",
"CONTAINER_SIZE",
"CONTAINER_LOG_RSRC_NAME",
"DATA_OWNER_DOMAIN",
"USER_DISTIN_NAME",
"USER_AUTH_SCHEME",
"SERVER_LOCATION",
"SERVER_NETPREFIX",
"CONTAINER_REPL_ENUM",
"DATA_ANNOTATION_USERNAME",
"DATA_ANNOTATION_USERDOMAIN",
"DATA_ANNOTATION",
"DATA_ANNOTATION_TIMESTAMP",
"DATA_CREATE_TIMESTAMP",
"DATA_COMMENTS_TIMESTAMP",
"DATA_ANNOTATION_POSITION",
"DATA_ACCESS_PRIVILEGE",
"RESOURCE_MAX_LATENCY",
"RESOURCE_MIN_LATENCY",
"RESOURCE_BANDWIDTH",
"RESOURCE_MAX_CONCURRENCY",
"RESOURCE_NUM_OF_HIERARCHIES",
"RESOURCE_NUM_OF_STRIPES",
"RESOURCE_CAPACITY",
"RESOURCE_DESCRIPTION",
"DATA_CLASS_NAME",
"DATA_CLASS_TYPE",
"STRUCTURED_METADATA_TYPE",
"STRUCTURED_METADATA_COMMENTS",
"STRUCTURED_METADATA_DATA_NAME",
"INTERNAL_STRUCTURED_METADATA",
"INDEX_NAME_FOR_DATASET",
"INDEX_NAME_FOR_DATATYPE",
"INDEX_NAME_FOR_COLLECTION",
"METHOD_NAME_FOR_DATASET",
"METHOD_NAME_FOR_DATATYPE",
"METHOD_NAME_FOR_COLLECTION",
"IX_COLL_NAME_FOR_DATASET",
"IX_COLLNAME_FOR_DATATYPE",
"IX_COLLNAME_FOR_COLLECTION",
"MTH_COLLNAME_FOR_DATASET",
"MTH_COLLNAME_FOR_DATATYPE",
"MTH_COLLNAME_FOR_COLLECTION",
"IX_DATATYPE_FOR_DATASET",
"IX_DATATYPE_FOR_DATATYPE",
"IX_DATATYPE_FOR_COLLECTION",
"MTH_DATATYPE_FOR_DATASET",
"MTH_DATATYPE_FOR_DATATYPE",
"MTH_DATATYPE_FOR_COLLECTION",
"STRUCTURED_METADATA_COLLNAME",
"IX_LOCATION_FOR_DATASET",
"IX_LOCATION_FOR_DATATYPE",
"IX_LOCATION_FOR_COLLECTION",
"METADATA_NUM",
"UDSMD0",
"UDSMD1",
"UDSMD2",
"UDSMD3",
"UDSMD4",
"UDSMD5",
"UDSMD6",
"UDSMD7",
"UDSMD8",
"UDSMD9",
"UDIMD0",
"UDIMD1",
"DATA_OWNER_EMAIL",
"AUDIT_USER",
"AUDIT_USER_DOMAIN",
"CONTAINER_FOR_COLLECTION",
"METADATA_NUM_COLL",
"UDSMD_COLL0",
"UDSMD_COLL1",
"UDSMD_COLL2",
"UDSMD_COLL3",
"UDSMD_COLL4",
"UDSMD_COLL5",
"UDSMD_COLL6",
"UDSMD_COLL7",
"UDSMD_COLL8",
"UDSMD_COLL9",
"UDIMD_COLL0",
"UDIMD_COLL1",
"DATA_ACCESS_ID",
"USER_ID",
"DATA_LAST_ACCESS_TIMESTAMP",
"COLL_OWNER_NAME",
"COLL_CREATE_TIMESTAMP",
"COLL_COMMENTS",
"DC_DATA_NAME",
"DC_COLLECTION",
"DC_CONTRIBUTOR_TYPE",
"DC_SUBJECT_CLASS",
"DC_DESCRIPTION_TYPE",
"DC_TYPE",
"DC_SOURCE_TYPE",
"DC_LANGUAGE",
"DC_RELATION_TYPE",
"DC_COVERAGE_TYPE",
"DC_RIGHTS_TYPE",
"DC_TITLE",
"DC_CONTRIBUTOR_NAME",
"DC_SUBJECT_NAME",
"DC_DESCRIPTION",
"DC_PUBLISHER",
"DC_SOURCE",
"DC_RELATED_DATA_DESCR",
"DC_RELATED_DATA",
"DC_RELATED_COLL",
"DC_COVERAGE",
"DC_RIGHTS",
"DC_PUBLISHER_ADDR",
"DC_CONTRIBUTOR_ADDR",
"DC_CONTRIBUTOR_EMAIL",
"DC_CONTRIBUTOR_PHONE",
"DC_CONTRIBUTOR_WEB",
"DC_CONTRIBUTOR_CORPNAME",
"COLL_ACCS_ID",
"COLL_ACCS_USER_ID",
"DATA_ACCS_ID",
"DATA_ACCS_USER_ID",
"UDSMD0_1",
"UDSMD0_2",
"UDSMD0_3",
"UDSMD0_4",
"UDSMD1_1",
"UDSMD1_2",
"UDSMD1_3",
"UDSMD1_4",
"UDSMD_COLL0_1",
"UDSMD_COLL0_2",
"UDSMD_COLL0_3",
"UDSMD_COLL0_4",
"UDSMD_COLL1_1",
"UDSMD_COLL1_2",
"UDSMD_COLL1_3",
"UDSMD_COLL1_4",
"C_TICKET_RECURSIVE",
"UDSMD_RSRC0_1",
"UDSMD_RSRC0_2",
"UDSMD_RSRC0_3",
"UDSMD_RSRC1_1",
"UDSMD_RSRC1_2",
"UDSMD_RSRC1_3",
"UDSMD_USER0_1",
"UDSMD_USER0_2",
"UDSMD_USER0_3",
"UDSMD_USER1_1",
"UDSMD_USER1_2",
"UDSMD_USER1_3",
"TAPE_NUMBER",
"TAPE_OWNER",
"TAPE_TYPE_VAL",
"TAPE_LIBINX",
"TAPE_FULLFLAG",
"TAPE_CURRENT_FILE_SEQNUM",
"TAPE_CURRENT_ABS_POSITION",
"TAPE_BYTES_WRITTEN",
"DATA_VER_NUM",
"DATA_LOCK_NUM",
"DATA_LOCK_DESC",
"DATA_LOCK_OWNER_NAME",
"DATA_LOCK_OWNER_DOMAIN",
"COLL_OWNER_DOMAIN",
"C_TICKET_COLL_NAME",
"C_TICKET_COLL_CREATE_TIMESTAMP",
"C_TICKET_COLL_COMMENTS",
"COLL_ANNOTATION_USERNAME",
"COLL_ANNOTATION_USERDOMAIN",
"COLL_ANNOTATION",
"COLL_ANNOTATION_TIMESTAMP",
"COLL_ANNOTATION_TYPE",
"DATA_GRP_ID",
"DATA_HIDE",
"DATA_CHECKSUM",
"DATA_AUDITFLAG",
"DATA_LOCK_EXPIRY",
"DATA_PIN_VAL",
"DATA_PIN_OWNER_NAME",
"DATA_PIN_OWNER_DOMAIN",
"DATA_PIN_EXPIRY",
"DATA_EXPIRY_DATE",
"DATA_IS_COMPRESSED",
"DATA_IS_ENCRYPTED",
"DATA_EXPIRE_DATE_2",
"NEW_AUDIT_ACTION_DESC",
"NEW_AUDIT_TIMESTAMP",
"NEW_AUDIT_COMMENTS",
"UDSMD_RSRC0",
"UDSMD_RSRC1",
"UDSMD_RSRC2",
"UDSMD_RSRC3",
"UDSMD_RSRC4",
"UDSMD_RSRC5",
"UDSMD_RSRC6",
"UDSMD_RSRC7",
"UDSMD_RSRC8",
"UDSMD_RSRC9",
"UDIMD_RSRC0",
"METADATA_NUM_RSRC",
"METADATA_NUM_USER",
"COMPOUND_RSRC_NAME",
"DATA_SEG_NUM",
"INT_REPL_ENUM",
"INT_SEG_NUM",
"INT_PATH_NAME",
"INT_RSRC_NAME",
"INT_RSRC_ADDR_NETPREFIX",
"INT_RSRC_TYP_NAME",
"INT_IS_DIRTY",
"INT_RSRC_CLASS",
"INT_OFFSET",
"INT_SIZE",
"COMP_OBJ_USER_NAME",
"COMP_OBJ_USER_DOMAIN",
"INT_PATH_NAME_FOR_REPL",
"ACL_INHERITANCE_BIT",
"REAL_COLLECTION_NAME",
"DATA_CONT_NAME",
"COLLECTION_CONT_NAME",
"UDSMD_USER0",
"UDSMD_USER1",
"UDSMD_USER2",
"UDSMD_USER3",
"UDSMD_USER4",
"UDSMD_USER5",
"UDSMD_USER6",
"UDSMD_USER7",
"UDSMD_USER8",
"UDSMD_USER9",
"UDIMD_USER0",
"NONDISTINCT",
"USERDEFFUNC01",
"USERDEFFUNC02",
"USERDEFFUNC03",
"USERDEFFUNC04",
"USERDEFFUNC05",
"ZONE_NAME",
"ZONE_LOCALITY",
"ZONE_NETPREFIX",
"ZONE_PORT_NUM",
"ZONE_ADMIN_AUTH_SCHEME_NAME",
"ZONE_ADMIN_DISTIN_NAME",
"ZONE_STATUS",
"ZONE_CREATE_DATE",
"ZONE_MODIFY_DATE",
"ZONE_COMMENTS",
"ZONE_CONTACT",
"ZONE_ADMIN_NAME",
"ZONE_ADMIN_DOMAIN_NAME",
"RSRC_ACCESS_PRIVILEGE",
"RSRC_ACCESS_CONSTRAINT",
"UDIMD_USER1",
"UDIMD_RSRC1",
"USER_GROUP_MODIFY_DATE",
"USER_GROUP_ZONE_NAME",
"USER_GROUP_DOMAIN_DESC",
"DATA_UDEF_MDATA_MODIFY_DATE",
"COLl_UDEF_MDATA_MODIFY_DATE",
"USER_UDEF_MDATA_MODIFY_DATE",
"RSRC_UDEF_MDATA_MODIFY_DATE",
"DATA_TYPE_MIME_STRING",
"DATA_TYPE_EXTENDERS",
"RSRC_COMMENTS",
"RSRC_CREATE_DATE",
"RSRC_MODIFY_DATE",
"USER_CREATE_DATE",
"USER_MODIFY_DATE",
"RSRC_MAX_OBJ_SIZE",
"RSRC_OWNER_NAME",
"RSRC_OWNER_DOMAIN",
"RSRC_MLSEC_LATENCY_MAX",
"RSRC_MLSEC_LATENCY_MIN",
"RSRC_MBPS_BANDWIDTH",
"RSRC_CONCURRENCY_MAX",
"RSRC_NUM_OF_HIERARCHIES",
"RSRC_NUM_OF_STRIPES",
"RSRC_MEGAB_CAPACITY",
"RSRC_ACCS_USER_NAME",
"RSRC_ACCS_USER_DOMAIN",
"RSRC_ACCS_USER_ZONE",
"RSRC_OWNER_ZONE",
"DATA_OWNER_ZONE",
"TICKET_OWNER_ZONE_D",
"TICKET_USER_ZONE_D",
"TICKET_OWNER_ZONE_C",
"TICKET_USER_ZONE_C",
"DATA_ANNOTATION_USER_ZONE",
"AUDIT_USER_ZONE",
"COLL_OWNER_ZONE",
"DATA_LOCK_OWNER_ZONE",
"COLL_ANNOTATION_USER_ZONE",
"DATA_PIN_OWNER_ZONE",
"COMP_OBJ_USER_ZONE",
"PARENT_SERVER_LOCATION",
"RSRC_ACCESS_ID",
"PARENT_DATA_TYPE",
"ZONE_LOCN_DESC",
"PARENT_DOMAIN_DESC",
"PARENT_USER_TYPE",
"PARENT_RSRC_TYPE",
"RSRC_ACCS_GRPUSER_NAME",
"RSRC_ACCS_GRPUSER_DOMAIN",
"RSRC_ACCS_GRPUSER_ZONE",
"COLL_MODIFY_TIMESTAMP",
"DATA_ACCS_GRPUSER_NAME",
"DATA_ACCS_GRPUSER_DOMAIN",
"DATA_ACCS_GRPUSER_ZONE",
"COLL_ACCS_GRPUSER_NAME",
"COLL_ACCS_GRPUSER_DOMAIN",
"COLL_ACCS_GRPUSER_ZONE",
"COLL_ACCS_COLLECTION_NAME",
"COLL_ACCS_ACCESS_CONSTRAINT",
"DATA_TYPE_FOR_CONTAINER_FOR_COLLECTION",
"DATA_UDEF_MDATA_CREATE_DATE",
"COLL_UDEF_MDATA_CREATE_DATE",
"RSRC_UDEF_MDATA_CREATE_DATE",
"USER_UDEF_MDATA_CREATE_DATE",
"CONTAINER_ID",
"GUID",
"GUID_FLAG",
"GUID_TIME_STAMP",
"ORDERBY",
"DEL_DATA_ID",
"DEL_DATA_REPL_ENUM",
"DEL_DATA_NAME",
"DEL_REPL_TIMESTAMP",
"DEL_COLLECTION_NAME",
"DEL_COLLECTION_ID",
"DEL_DATA_COMMENT",
"FREE_SPACE",
"FS_TIMESTAMP",
"EXTENSIBLE_SCHEMA_NAME",
"EXTENSIBLE_TABLE_NAME",
"EXTENSIBLE_ATTR_NAME",
"EXTENSIBLE_ATTR_OUTSIDE_NAME",
"EXTENSIBLE_ATTR_COMMENTS",
"USEREXTRA400",
"USEREXTRA401",
"USEREXTRA402",
"USEREXTRA403",
"USEREXTRA404",
"USEREXTRA405",
"USEREXTRA406",
"USEREXTRA407",
"USEREXTRA408",
"USEREXTRA409",
"USEREXTRA410",
"USEREXTRA411",
"USEREXTRA412",
"USEREXTRA413",
"USEREXTRA414",
"USEREXTRA415",
"USEREXTRA416",
"USEREXTRA417",
"USEREXTRA418",
"USEREXTRA419",
"USEREXTRA420",
"USEREXTRA421",
"USEREXTRA422",
"USEREXTRA423",
"USEREXTRA424",
"USEREXTRA425",
"USEREXTRA426",
"USEREXTRA427",
"USEREXTRA428",
"USEREXTRA429",
"USEREXTRA430",
"USEREXTRA431",
"USEREXTRA432",
"USEREXTRA433",
"USEREXTRA434",
"USEREXTRA435",
"USEREXTRA436",
"USEREXTRA437",
"USEREXTRA438",
"USEREXTRA439",
"USEREXTRA440",
"USEREXTRA441",
"USEREXTRA442",
"USEREXTRA443",
"USEREXTRA444",
"USEREXTRA445",
"USEREXTRA446",
"USEREXTRA447",
"USEREXTRA448",
"USEREXTRA449",
"USEREXTRA450",
"USEREXTRA451",
"USEREXTRA452",
"USEREXTRA453",
"USEREXTRA454",
"USEREXTRA455",
"USEREXTRA456",
"USEREXTRA457",
"USEREXTRA458",
"USEREXTRA459",
"USEREXTRA460",
"USEREXTRA461",
"USEREXTRA462",
"USEREXTRA463",
"USEREXTRA464",
"USEREXTRA465",
"USEREXTRA466",
"USEREXTRA467",
"USEREXTRA468",
"USEREXTRA469",
"USEREXTRA470",
"USEREXTRA471",
"USEREXTRA472",
"USEREXTRA473",
"USEREXTRA474",
"USEREXTRA475",
"USEREXTRA476",
"USEREXTRA477",
"USEREXTRA478",
"USEREXTRA479",
"USEREXTRA480",
"USEREXTRA481",
"USEREXTRA482",
"USEREXTRA483",
"USEREXTRA484",
"USEREXTRA485",
"USEREXTRA486",
"USEREXTRA487",
"USEREXTRA488",
"USEREXTRA489",
"USEREXTRA490",
"USEREXTRA491",
"USEREXTRA492",
"USEREXTRA493",
"USEREXTRA494",
"USEREXTRA495",
"USEREXTRA496",
"USEREXTRA497",
"USEREXTRA498",
"USEREXTRA499"
};
#endif	/* MDASGLOBALS_H */