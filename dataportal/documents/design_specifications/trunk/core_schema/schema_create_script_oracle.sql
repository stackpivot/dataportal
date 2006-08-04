CREATE TABLE DP_BOOKMARK
(
ID NUMBER NOT NULL,
USER_ID NUMBER NOT NULL,
STUDY_ID NUMBER NOT NULL,
NAME VARCHAR2(4000) NOT NULL,
QUERY VARCHAR2(4000) NOT NULL,
FACILITY VARCHAR2(4000) NOT NULL,
NOTE VARCHAR2(4000),
MOD_TIME TIMESTAMP(1) NOT NULL
)
;

CREATE TABLE DP_CREDENTIAL_TYPE
(
ID NUMBER NOT NULL,
NAME VARCHAR2(256) NOT NULL,
INFO_URL VARCHAR2(256),
MOD_TIME TIMESTAMP(1) NOT NULL
)
;

CREATE TABLE DP_DATA_REFERENCE
(
ID NUMBER NOT NULL,
USER_ID NUMBER NOT NULL,
NAME VARCHAR2(4000) NOT NULL,
NOTE VARCHAR2(4000),
FACILITY VARCHAR2(4000),
QUERY VARCHAR2(4000),
TYPE_OF_REFERENCE VARCHAR2(4000),
TYPE_OF_OBJECT VARCHAR2(4000),
MOD_TIME TIMESTAMP(1)
)
;

CREATE TABLE DP_DATA_REF_AUTHORISATION
(
SOURCE_USER_ID NUMBER NOT NULL,
AUTHORISED_USER_ID NUMBER NOT NULL,
AUTH_START_DATE TIMESTAMP(0) NOT NULL,
AUTH_END_DATE TIMESTAMP(0),
AUTH_TYPE VARCHAR2(100),
MOD_TIME TIMESTAMP(1)
)
;

CREATE TABLE DP_DATA_REF_URL
(
DATA_REF_ID NUMBER NOT NULL,
URL_ID NUMBER NOT NULL,
COMMENTS VARCHAR2(4000),
MOD_TIME TIMESTAMP(1)
)
;

CREATE TABLE DP_EVENT
(
ID NUMBER NOT NULL,
EVENT_NAME VARCHAR2(512),
EVENT_DETAILS VARCHAR2(4000),
MOD_TIME TIMESTAMP(1) NOT NULL
)
;

CREATE TABLE DP_EVENT_LOG
(
ID NUMBER NOT NULL,
USER_ID NUMBER,
EVENT VARCHAR2(512) NOT NULL,
DETAILS VARCHAR2(4000),
MOD_TIME TIMESTAMP(1) NOT NULL
)
;

CREATE TABLE DP_FACILITY
(
ID NUMBER NOT NULL,
SHORT_NAME VARCHAR2(256) NOT NULL,
LONG_NAME VARCHAR2(512),
INFO_URL VARCHAR2(256) NOT NULL,
MOD_TIME TIMESTAMP(1) NOT NULL
)
;

CREATE TABLE DP_MODULE_LOOKUP
(
ID NUMBER NOT NULL,
CONNECTION VARCHAR2(4000) NOT NULL,
USERNAME VARCHAR2(256),
PASSWORD VARCHAR2(512),
PLATFORM VARCHAR2(4000),
MODULE_TYPE VARCHAR2(256) NOT NULL,
FACILITY VARCHAR2(256) NOT NULL,
ACTIVE VARCHAR2(1),
MOD_TIME TIMESTAMP(1) NOT NULL
)
;

CREATE TABLE DP_PROXY_SERVERS
(
ID NUMBER NOT NULL,
PROXY_SERVER_ADDRESS VARCHAR2(4000) NOT NULL,
PORT_NUMBER NUMBER NOT NULL,
CA_ROOT_CERTIFICATE VARCHAR2(4000) NOT NULL,
MOD_TIME TIMESTAMP(1) NOT NULL
)
;

CREATE TABLE DP_ROLE
(
ID NUMBER NOT NULL,
NAME VARCHAR2(256) NOT NULL,
MOD_TIME TIMESTAMP(1) NOT NULL
)
;

CREATE TABLE DP_SESSION
(
ID NUMBER NOT NULL,
USER_SESSION_ID VARCHAR2(4000) NOT NULL,
USER_ID NUMBER NOT NULL,
CREDENTIAL CLOB NOT NULL,
CREDENTIAL_TYPE VARCHAR2(256),
EXPIRE_DATE_TIME TIMESTAMP(0) NOT NULL,
MOD_TIME TIMESTAMP(1) NOT NULL
)
;

CREATE TABLE DP_SRB_SERVER
(
ID NUMBER NOT NULL,
HOSTNAME VARCHAR2(2000) NOT NULL,
PORT_NUMBER NUMBER NOT NULL,
FACILITY_ID NUMBER,
SERVICE_NAME VARCHAR2(4000),
MOD_TIME TIMESTAMP(1) NOT NULL
)
;

CREATE TABLE DP_TOKENS
(
ID NUMBER NOT NULL,
SESSION_ID NUMBER NOT NULL,
TOKEN VARCHAR2(4000),
FACILITY_CERT VARCHAR2(4000),
MOD_TIME TIMESTAMP(1) NOT NULL
)
;

CREATE TABLE DP_URL
(
ID NUMBER NOT NULL,
URL VARCHAR2(4000) NOT NULL,
MOD_TIME TIMESTAMP(1) NOT NULL
)
;

CREATE TABLE DP_USER
(
ID NUMBER NOT NULL,
DN VARCHAR2(4000) NOT NULL,
MOD_TIME TIMESTAMP(1) NOT NULL
)
;

CREATE TABLE DP_USER_PREFERENCE
(
ID NUMBER NOT NULL,
USER_ID NUMBER,
RESULTS_PER_PAGE NUMBER,
DEFAULT_FACILITY VARCHAR2(4000),
PROXY_SERVER_ID NUMBER,
RESOLUTION VARCHAR2(256),
MOD_TIME TIMESTAMP(1)
)
;

CREATE TABLE DP_USER_ROLE
(
USER_ID NUMBER NOT NULL,
ROLE_ID NUMBER NOT NULL,
COMMENTS VARCHAR2(4000),
MOD_TIME TIMESTAMP(1)
)
;

ALTER TABLE DP_BOOKMARK
ADD CONSTRAINT DP_BOOKMARK_PK PRIMARY KEY
(
ID
)
 ENABLE
;

ALTER TABLE DP_BOOKMARK
ADD CONSTRAINT DP_BOOKMARK_UK1 UNIQUE
(
STUDY_ID,
FACILITY,
USER_ID
)
 ENABLE
;

ALTER TABLE DP_CREDENTIAL_TYPE
ADD CONSTRAINT DP_CREDENTIAL_TYPE_PK PRIMARY KEY
(
ID
)
 ENABLE
;

ALTER TABLE DP_CREDENTIAL_TYPE
ADD CONSTRAINT DP_CREDENTIAL_TYPE_UK1 UNIQUE
(
NAME
)
 ENABLE
;

ALTER TABLE DP_DATA_REFERENCE
ADD CONSTRAINT DP_DATA_REFERENCE_PK PRIMARY KEY
(
ID
)
 ENABLE
;

ALTER TABLE DP_DATA_REF_AUTHORISATION
ADD CONSTRAINT DP_DATA_REF_AUTHORISATION_PK PRIMARY KEY
(
SOURCE_USER_ID,
AUTHORISED_USER_ID
)
 ENABLE
;

ALTER TABLE DP_DATA_REF_URL
ADD CONSTRAINT DP_DATA_REF_URL_PK PRIMARY KEY
(
DATA_REF_ID,
URL_ID
)
 ENABLE
;

ALTER TABLE DP_EVENT
ADD CONSTRAINT DP_EVENT_PK PRIMARY KEY
(
ID
)
 ENABLE
;

ALTER TABLE DP_EVENT
ADD CONSTRAINT DP_EVENT_UK1 UNIQUE
(
EVENT_NAME
)
 ENABLE
;

ALTER TABLE DP_EVENT_LOG
ADD CONSTRAINT DP_EVENT_LOG_PK PRIMARY KEY
(
ID
)
 ENABLE
;

ALTER TABLE DP_FACILITY
ADD CONSTRAINT DP_FACILITY_PK PRIMARY KEY
(
ID
)
 ENABLE
;

ALTER TABLE DP_FACILITY
ADD CONSTRAINT DP_FACILITY_UK1 UNIQUE
(
SHORT_NAME
)
 ENABLE
;

ALTER TABLE DP_FACILITY
ADD CONSTRAINT DP_FACILITY_UK2 UNIQUE
(
LONG_NAME
)
 ENABLE
;

ALTER TABLE DP_MODULE_LOOKUP
ADD CONSTRAINT DP_MODULE_LOOKUP_PK PRIMARY KEY
(
ID
)
 ENABLE
;

ALTER TABLE DP_MODULE_LOOKUP
ADD CONSTRAINT DP_MODULE_LOOKUP_UK1 UNIQUE
(
FACILITY
)
 ENABLE
;

ALTER TABLE DP_PROXY_SERVERS
ADD CONSTRAINT DP_PROXY_SERVERS_PK PRIMARY KEY
(
ID
)
 ENABLE
;

ALTER TABLE DP_ROLE
ADD CONSTRAINT DP_ROLE_PK PRIMARY KEY
(
ID
)
 ENABLE
;

ALTER TABLE DP_ROLE
ADD CONSTRAINT DP_ROLE_UK1 UNIQUE
(
NAME
)
 ENABLE
;

ALTER TABLE DP_SESSION
ADD CONSTRAINT DP_SESSION_PK PRIMARY KEY
(
ID
)
 ENABLE
;

ALTER TABLE DP_SESSION
ADD CONSTRAINT DP_SESSION_UK1 UNIQUE
(
USER_SESSION_ID
)
 ENABLE
;

ALTER TABLE DP_SRB_SERVER
ADD CONSTRAINT SRB_SERVERS_PK PRIMARY KEY
(
ID
)
 ENABLE
;

ALTER TABLE DP_TOKENS
ADD CONSTRAINT DP_TOKENS_PK PRIMARY KEY
(
ID
)
 ENABLE
;

ALTER TABLE DP_TOKENS
ADD CONSTRAINT DP_TOKENS_UK1 UNIQUE
(
TOKEN
)
 ENABLE
;

ALTER TABLE DP_URL
ADD CONSTRAINT DP_URL_PK PRIMARY KEY
(
ID
)
 ENABLE
;

ALTER TABLE DP_USER
ADD CONSTRAINT DP_USER_PK PRIMARY KEY
(
ID
)
 ENABLE
;

ALTER TABLE DP_USER
ADD CONSTRAINT DP_USER_UK1 UNIQUE
(
DN
)
 ENABLE
;

ALTER TABLE DP_USER_PREFERENCE
ADD CONSTRAINT DP_USER_PREFERENCE_PK PRIMARY KEY
(
ID
)
 ENABLE
;

ALTER TABLE DP_USER_PREFERENCE
ADD CONSTRAINT DP_USER_PREFERENCE_UK1 UNIQUE
(
USER_ID
)
 ENABLE
;

ALTER TABLE DP_USER_ROLE
ADD CONSTRAINT DP_USER_ROLE_PK PRIMARY KEY
(
USER_ID,
ROLE_ID
)
 ENABLE
;

ALTER TABLE DP_BOOKMARK
ADD CONSTRAINT DP_BOOKMARK_DP_FACILITY_FK1 FOREIGN KEY
(
FACILITY
)
REFERENCES DP_FACILITY
(
SHORT_NAME
) ENABLE
;

ALTER TABLE DP_BOOKMARK
ADD CONSTRAINT DP_BOOKMARK_DP_USER_FK1 FOREIGN KEY
(
USER_ID
)
REFERENCES DP_USER
(
ID
) ENABLE
;

ALTER TABLE DP_DATA_REFERENCE
ADD CONSTRAINT DP_DATA_REFERENCE_DP_FACI_FK1 FOREIGN KEY
(
FACILITY
)
REFERENCES DP_FACILITY
(
SHORT_NAME
) ENABLE
;

ALTER TABLE DP_DATA_REFERENCE
ADD CONSTRAINT DP_DATA_REFERENCE_DP_USER_FK1 FOREIGN KEY
(
USER_ID
)
REFERENCES DP_USER
(
ID
) ENABLE
;

ALTER TABLE DP_DATA_REF_AUTHORISATION
ADD CONSTRAINT DP_DATA_REF_AUTHORISATION_FK1 FOREIGN KEY
(
SOURCE_USER_ID
)
REFERENCES DP_USER
(
ID
) ENABLE
;

ALTER TABLE DP_DATA_REF_AUTHORISATION
ADD CONSTRAINT DP_DATA_REF_AUTHORISATION_FK2 FOREIGN KEY
(
AUTHORISED_USER_ID
)
REFERENCES DP_USER
(
ID
) ENABLE
;

ALTER TABLE DP_DATA_REF_URL
ADD CONSTRAINT DP_DATA_REF_URL_DP_DATA_R_FK1 FOREIGN KEY
(
DATA_REF_ID
)
REFERENCES DP_DATA_REFERENCE
(
ID
) ENABLE
;

ALTER TABLE DP_DATA_REF_URL
ADD CONSTRAINT DP_DATA_REF_URL_DP_URL_FK1 FOREIGN KEY
(
URL_ID
)
REFERENCES DP_URL
(
ID
) ENABLE
;

ALTER TABLE DP_EVENT_LOG
ADD CONSTRAINT DP_EVENT_LOG_DP_USER_FK1 FOREIGN KEY
(
USER_ID
)
REFERENCES DP_USER
(
ID
) ENABLE
;

ALTER TABLE DP_EVENT_LOG
ADD CONSTRAINT DP_EVENT_LOG_DP_EVENT_FK1 FOREIGN KEY
(
EVENT
)
REFERENCES DP_EVENT
(
EVENT_NAME
) ENABLE
;

ALTER TABLE DP_MODULE_LOOKUP
ADD CONSTRAINT DP_MODULE_LOOKUP_DP_FACIL_FK1 FOREIGN KEY
(
FACILITY
)
REFERENCES DP_FACILITY
(
SHORT_NAME
) ENABLE
;

ALTER TABLE DP_SESSION
ADD CONSTRAINT DP_SESSION_DP_CREDENTIAL__FK1 FOREIGN KEY
(
CREDENTIAL_TYPE
)
REFERENCES DP_CREDENTIAL_TYPE
(
NAME
) ENABLE
;

ALTER TABLE DP_SESSION
ADD CONSTRAINT DP_SESSION_DP_USER_FK1 FOREIGN KEY
(
USER_ID
)
REFERENCES DP_USER
(
ID
) ENABLE
;

ALTER TABLE DP_SRB_SERVER
ADD CONSTRAINT SRB_SERVERS_DP_FACILITY_FK1 FOREIGN KEY
(
FACILITY_ID
)
REFERENCES DP_FACILITY
(
ID
) ENABLE
;

ALTER TABLE DP_TOKENS
ADD CONSTRAINT DP_TOKENS_DP_SESSION_FK1 FOREIGN KEY
(
SESSION_ID
)
REFERENCES DP_SESSION
(
ID
) ENABLE
;

ALTER TABLE DP_USER_PREFERENCE
ADD CONSTRAINT DP_USER_PREFERENCE_DP_USE_FK1 FOREIGN KEY
(
USER_ID
)
REFERENCES DP_USER
(
ID
) ENABLE
;

ALTER TABLE DP_USER_PREFERENCE
ADD CONSTRAINT DP_USER_PREFERENCE_DP_PRO_FK1 FOREIGN KEY
(
PROXY_SERVER_ID
)
REFERENCES DP_PROXY_SERVERS
(
ID
) ENABLE
;

ALTER TABLE DP_USER_PREFERENCE
ADD CONSTRAINT DP_USER_PREFERENCE_DP_FAC_FK1 FOREIGN KEY
(
DEFAULT_FACILITY
)
REFERENCES DP_FACILITY
(
SHORT_NAME
) ENABLE
;

ALTER TABLE DP_USER_ROLE
ADD CONSTRAINT DP_USER_ROLE_DP_USER_FK1 FOREIGN KEY
(
USER_ID
)
REFERENCES DP_USER
(
ID
) ENABLE
;

ALTER TABLE DP_USER_ROLE
ADD CONSTRAINT DP_USER_ROLE_DP_ROLE_FK1 FOREIGN KEY
(
ROLE_ID
)
REFERENCES DP_ROLE
(
ID
) ENABLE
;

COMMENT ON TABLE DP_USER IS 'this identifies the user via their DN'
;

COMMENT ON COLUMN DP_BOOKMARK.STUDY_ID IS 'The study_id in the facility catalog - such that (facility, study_id) is unique'
;

COMMENT ON COLUMN DP_DATA_REFERENCE.TYPE_OF_REFERENCE IS 'is this a DC or DO'
;

COMMENT ON COLUMN DP_DATA_REFERENCE.TYPE_OF_OBJECT IS 'e.g. filetype'
;

COMMENT ON COLUMN DP_DATA_REF_AUTHORISATION.SOURCE_USER_ID IS 'the one giving authorisation'
;

COMMENT ON COLUMN DP_DATA_REF_AUTHORISATION.AUTHORISED_USER_ID IS 'the one receiving authorisation'
;

COMMENT ON COLUMN DP_DATA_REF_AUTHORISATION.AUTH_TYPE IS 'perhaps data references, bookmarks, both, other'
;

COMMENT ON COLUMN DP_DATA_REF_URL.MOD_TIME IS 'weak entity, many to many mapping table'
;

COMMENT ON COLUMN DP_MODULE_LOOKUP.CONNECTION IS 'e.g. for DPAL this would be a Database Connect String and for ACM this might be a Web Services End Point'
;

COMMENT ON COLUMN DP_MODULE_LOOKUP.MODULE_TYPE IS 'e.g. ACM/DPAL'
;

COMMENT ON COLUMN DP_MODULE_LOOKUP.ACTIVE IS 'e.g. if set to null, Y or y  then service is active else it is not'
;

COMMENT ON COLUMN DP_SESSION.CREDENTIAL_TYPE IS 'e.g. common use is delegated proxy'
;

COMMENT ON COLUMN DP_SESSION.EXPIRE_DATE_TIME IS 'holds a cache of the calculated time that the session expires'
;

COMMENT ON COLUMN DP_SRB_SERVER.SERVICE_NAME IS 'e.g. National Grid Service'
;

COMMENT ON COLUMN DP_TOKENS.TOKEN IS 'e.g XML signed role authority document'
;

COMMENT ON COLUMN DP_USER_PREFERENCE.PROXY_SERVER_ID IS 'in hours'
;

COMMENT ON COLUMN DP_USER_ROLE.USER_ID IS 'weak entity, many to many mapping table'
;


-- 
-- Initialisation values for DP core schema
--

-- set escape value 
set escape \

CREATE TABLE  "SEQUENCE" 
   (	"SEQ_NAME" VARCHAR2(50), 
	"SEQ_COUNT" NUMBER(15,0)
   );

INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0) ;

insert into DP_ROLE values (1, 'USER',systimestamp);
insert into DP_ROLE values (2, 'ADMIN',systimestamp);

insert into DP_PROXY_SERVERS values (1,'myproxy.grid-support.ac.uk', 7521, '/C=UK/O=eScience/OU=CLRC/L=DL/CN=host/myproxy.grid-support.ac.uk/E=a.j.richards@dl.ac.uk', systimestamp);

insert into DP_FACILITY values (1,'ISIS', 'ISIS Pulsed Neutron \& Muon Source','http://www.isis.rl.ac.uk/', systimestamp);

insert into DP_MODULE_LOOKUP values (1, '(DESCRIPTION=(ADDRESS=(HOST=elektra.dl.ac.uk)(PROTOCOL=tcp)(PORT=1521))(CONNECT_DATA=(SID=minerva2)))', 'user', 'password', 'oracle', 'dpal', 'ISIS', 'Y', systimestamp) ;

insert into DP_EVENT values (1,'LOG_OFF','User logging off event',systimestamp);
insert into DP_EVENT values (2,'LOG_ON','User logging on event',systimestamp);
insert into DP_EVENT values (3,'BASIC_SEARCH','User basic searching event',systimestamp);
insert into DP_EVENT values (4,'ADVANCED_SEARCH','User advanced searching event',systimestamp);
insert into DP_EVENT values (5,'TRANSFER','User transfering event',systimestamp);

insert into DP_CREDENTIAL_TYPE values (1,'PROXY','Normal proxy',systimestamp);
insert into DP_CREDENTIAL_TYPE values (2,'CERTIFICATE','Certificate only, no private key',systimestamp);

commit;


