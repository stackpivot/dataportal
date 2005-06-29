/**************************************************************************
Copyright Notice
All Rights Reserved
Please refer to files in COPYRIGHT directory under the SRB software directory 
for copyright, usage, liability and license information.
Please read these files before using,modifying or distributing SRB software.
**************************************************************************/
 


/* srb.h - Contains info that are used by both the client and server
 * codes.
 */

#ifndef SRB_H
#define SRB_H

#ifdef _WIN32
#include <windows.h> 
#include <winsock.h>
#endif   /* WIN32 */

#include "c.h"
#include "srbType.h"
#include "mdasPrototypes.h"
#include "srbErrno.h"
#include <sys/types.h>
#include <signal.h>
#ifndef _WIN32
#include <netinet/in.h>
#include <unistd.h>
#endif /* WIN32 */
#if defined(PORTNAME_linux)
#include <sys/timex.h>
#endif /* PORTNAME_linux */

#if defined(PORTNAME_aix)
typedef struct mydirent {
        ino_t           d_ino;          /* "inode number" of entry */
        off_t           d_off;          /* offset of disk directory entry */
        unsigned short  d_reclen;       /* length of this record */
        char            d_name[1];      /* name of file */
} dirent_t;

typedef struct mydirent64 {
/*      ino64_t         d_ino; */ 
        srb_long_t      d_ino;          /* "inode number" of entry */
        off64_t         d_off;          /* offset of disk directory entry */
        unsigned short  d_reclen;       /* length of this record */
        char            d_name[1];      /* name of file */
} dirent64_t;
#endif   /* PORTNAME_aix */

#ifdef FED_MCAT
#define SRB_VERSION	"SRB-3.2.1&F"  /* The format is SRB-Version&APIVersion */
#else
#define SRB_VERSION	"SRB-3.2.1&D"  /* The format is SRB-Version&APIVersion */
#endif

#define MAXEXFPATH       256
#ifndef true
#define true        ((char) 1)
#endif
#ifndef false
#define false        ((char) 0)
#endif

#ifdef DEBUGON
#define ERROR_MSG_LENGTH 4096
#else
#define ERROR_MSG_LENGTH 4096
#endif

#define NAMEDATALEN 32

#define MAX_PARSE_BUFFER 8192
#define SQL_RESULT_LEN    2200000       /* don't know how long the result
                                         * will be. Allocate a large one
                                         * just in case.
                                         */

#define CHALLENGE_MESSAGE_SIZE 64       /* for encrypted SRB authoriaztion,
					 * has to be divisible by 4 !  
					 */

#define PRIVILEGED_USER	10		/* uid less than or equal to
					 * PRIVILEGED_USER are considered
					 * to be privileged users.
					 */

#define DEFAULT_USER	999999		/* if it is not in the passwd file */

/* container home collection */
#define CONTAINER_HOME          "/container"

/* The portal env name */
#define PORTAL_ENV	"PortalNum"

/* The portalFlag definition */
#define PORTAL_OFF		0x00000000
#define PORTAL_ON		0x00000001	/* create a portal and put it
						 * in env PORTAL_ENV */
#define PORTAL_STD_IN_OUT 	0x00000002

/* definition for the syncFlag of srbSyncContainer call */
#define PURGE_FLAG    0x00000001      /* purge container after sync */
#define PRIMARY_FLAG  0x00000002      /* sync to primary arch only. Otherwise,
				       * to all arch */
/* The 64 bit flag - defines whether the struct is 64 or 32 bits */
#define IS_64_BIT               1
#define IS_32_BIT               0

/* a bit that indicate the object being opened is a collection */
#define IS_COLL_FD 	0x800

/* user class definition for UserClass */
#define CLASS_CLI       0
#define CLASS_MAS       1
#define CLASS_SER       2

/* define some standford stage values */
#define STANDF_NOREG    0       /* do not register the copy */
#define STANDF_REG      1       /* register the copy */

#define COMMAND_DIR     "bin/commands"  /* The directroy with the proxy
                                         * command executables located */

#if defined(PORTNAME_sgi) || defined(PORTNAME_aix)
/* IRIX 5 does not have vfork() */
#define FORK() fork()
#else
#define FORK() vfork()
#endif

/* ----------------
 *      struct varlena
 * ----------------
 */

#if defined(PORTNAME_c90)
struct varlena {
	INT32   vl_len:32;
	INT32   status:32;
	char    data[1];
};

struct varlena0 {
        INT32   vl_len:32;
        char    vl_dat[1];
};

#define VARSIZE(PTR)    (((struct varlena *)(PTR))->vl_len)
#define VARDATA(PTR)	(char *) (((struct varlena0 *)(PTR))->vl_dat)
#define VAROUTSTAT(PTR) (((struct varlena *)(PTR))->status)
#define VAROUTDATA(PTR) (char *) (((struct varlena *)(PTR))->data)
#else
struct varOut {
        INT32   status;
        char    data[1];
};

struct varlena {
        INT32   vl_len;
        union {
            struct varOut       varOut;
            char    vl_dat[1];
        } data;
};

#define VARSIZE(PTR)    (((struct varlena *)(PTR))->vl_len)
#define VARDATA(PTR)    (((struct varlena *)(PTR))->data.vl_dat)
#define VAROUTSTAT(PTR) (((struct varlena *)(PTR))->data.varOut.status)
#define VAROUTDATA(PTR) (((struct varlena *)(PTR))->data.varOut.data)
#endif

#if defined(PORTNAME_c90)
#define SIZEOF32	4
#define VARHDRSZ        4
#define VAROUTHDRSZ	8  /* The out header size: vl_len + status */
#else
#define SIZEOF32        sizeof(INT32)
#define VARHDRSZ        sizeof(INT32)
#define VAROUTHDRSZ	sizeof(INT32) + sizeof(INT32)  /* The out header 
						       size: vl_len + status */
#endif
 
#if defined(PORTNAME_c90)
struct int32Array {
	INT32	myInt0:32;
	INT32   myInt1:32;
};

/* ARRYAY32 is used to access 32 bit int indexed by INX in a 64 bit world */
#define ARRYAY32(PTR,INX) ((INX) - (INX/2) * 2) ? 		\
	(PTR[(INX/2)].myInt1) :	\
	(PTR[(INX/2)].myInt0)
#endif

/* Additional flag for the for the srbObjOpen call */

#define O_WR_REPL	0x10000000	/* sync all replica during write */
#define O_CRE_CONT	0x20000000	/* create a new container when
					   the curently container is full */

/* The following defines the file type of the extended file storage system */

#define UNIX_FT         0       /* The local Unix file type */
#define UNITREE_FT      1       /* The Unix file type */
#define HPSS_FT         2       /* The HPSS file type */
#define FTP_FT          3       /* The FTP file type */
#define HTTP_FT         4       /* The HTTP file type */
#define NULL_FT         5       /* The NULL file type */
#define DPSS_FT         6       /* The DPSS file type */
#define NTFS_FT         7       /* The Windows NTFS file type */
#define ADS_FT          8       /* The ADS (UK) file type */
#define CMSTORE_FT      9       /* The CM file type */
#define DCACHE_FT       10      /* The fnal/DESY dCache file type */

/* The following defines the TAPE_TYPE supported by the SRB */

#define TAPE_SYS	0	/* tape file type */

/* The following defines the COMPOUND_TYPE supported by the SRB */

#define SRB_ARCH	0	/* the SRB arch file type */

/* The following defines the DB_LOBJ_TYPE supported by the SRB */

#define DB2_LOBJ        0       /* DB2 LOBJ */
#define ILLUSTRA_LOBJ   1       /* Illustra LOBJ */
#define OBJSTORE_LOBJ   2       /* Object Store LOBJ */

#ifndef ORA_LOBJ
#define ORA_LOBJ   5       /* ORACLE LARGE OBJECT */
#endif

#ifndef IFMX_LOBJ
#define IFMX_LOBJ     6       /* Informix LOBJ - Not supported */
#endif
#ifndef SYB_LOBJ
#define SYB_LOBJ     7       /*  Sybase LOBJ - Not supported */
#endif
#ifndef PSG_LOBJ
#define PSG_LOBJ     8       /*  Postgres LOBJ - Not supported */
#endif
#ifndef MYS_LOBJ
#define MYS_LOBJ     9       /*  My SQL LOBJ - Not supported */
#endif

/* The following defines the DB_TABLE supported by the SRB */

#define DB2_TABLE        0       /* DB2 TABLE */
#define ILLUSTRA_TABLE   1       /* Illustra TABLE */
#define OBJSTORE_TABLE   2       /* Object Store TABLE */

#ifndef ORA_TABLE
#define ORA_TABLE   5       /* ORACLE TABLE */
#endif

#ifndef IFMX_TABLE
#define IFMX_TABLE     6       /* Informix TABLE */
#endif
#ifndef SYB_TABLE
#define SYB_TABLE     7       /*  Sybase TABLE */
#endif
#ifndef PSG_TABLE
#define PSG_TABLE     8       /*  Postgres TABLE */
#endif
#ifndef MYS_TABLE
#define MYS_TABLE     9       /*  My SQL TABLE */
#endif

/* define the user and domain ID of ticket only user */

#define TICKET_USER	"ticketuser"
#define TICKET_USER_DOMAIN	"sdsc"

typedef struct varlena bytea;
#ifndef ORACLE_DRIVER		/* text is defined in a oracle include file */
typedef struct varlena text;
#endif
 
/* The byteStream type */
typedef struct {
    int len;
    char *bytes;
} byteStream;

#define DEF_NUM_ROWS	100	/* The default number of rows to be returned */

#define DEF_CONTAINER_SIZE 200*1024*1024 /* default container size */
#define MAX_CONTAINER_SIZE 2000*1024*1024 /* max container size */
#define SOCK_WIN_SIZE 800*1024 /* default socket window size */

typedef enum {
    None,               /* results are discarded */
    Debug,              /* results go to debugging output */
    Local,              /* results go in local portal buffer */
    Remote,             /* results sent to frontend process */
    CopyBegin,          /* results sent to frontend process but are strings */
    CopyEnd,            /* results sent to frontend process but are strings */
    RemoteInternal      /* results sent to frontend process in internal
                           (binary) form */
} CommandDest;

/* Common declaration for communication */
#ifdef _SRB_WIN_SERVICE 
/* Windows service will try to get default one from a file first */
#define ntDefaultPort "7620"
extern char *DefaultPort;  
#else
#define DefaultPort     "7620" 
#endif

#define STARTUP_HEADER	"START SRB"	/* The first connection msg */
typedef enum _MsgType {
    ACK_MSG = 0,                /* acknowledge a message */
    ERROR_MSG=1,                /* error response to client from server */
    RESET_MSG=2,                /* client must reset connection */
    PRINT_MSG=3,                /* tuples for client from server */
    NET_ERROR=4,                /* error in net system call */
    FUNCTION_MSG=5,             /* fastpath call (unused) */
    QUERY_MSG=6,                /* client query to server */
    STARTUP_MSG=7,              /* initialize a connection with a backend */
    DUPLICATE_MSG=8,            /* duplicate msg arrived (errors msg only) */
    INVALID_MSG=9,              /* for some control functions */
    STARTUP_D_AUTH_MSG=10       /* use the default authentication (host based) */
} MsgType;

/*
 * startup msg parameters: path length, argument string length
 */
#define PATH_SIZE       64
#define ARGV_SIZE       64
 
typedef char *Addr;
typedef int PacketLen;  /* packet length */
 
 
#ifdef FED_MCAT
typedef struct StartupInfo {
/*     PacketHdr        hdr; */
    char                proxyUserName[NAMEDATALEN]; /* proxy User Name */
    char                proxyDomainName[NAMEDATALEN];   
    char                proxyMcatZone[NAMEDATALEN];   
    char                proxyAuth[NAMEDATALEN];   
    char                clientUserName[NAMEDATALEN]; /* proxy User Name */
    char                clientDomainName[NAMEDATALEN];   
    char                clientMcatZone[NAMEDATALEN];   
    char                clientAuth[NAMEDATALEN];   
    char                version[PATH_SIZE];  /* The version number */
    char                options[ARGV_SIZE];  /* possible additional args */
    char                execFile[ARGV_SIZE]; /* possible backend to use */
} StartupInfo;
#else
typedef struct StartupInfo {
/*     PacketHdr        hdr; */
    char                proxyUserName[NAMEDATALEN]; /* proxy User Name */
    char                proxyDomainName[NAMEDATALEN];
    char                proxyAuth[NAMEDATALEN];
    char                clientUserName[NAMEDATALEN]; /* proxy User Name */
    char                clientDomainName[NAMEDATALEN];
    char                clientAuth[NAMEDATALEN];
    char                options[ARGV_SIZE];  /* possible additional args */
    char                execFile[ARGV_SIZE]; /* possible backend to use */
    char                version[PATH_SIZE];  /* The version number */
} StartupInfo;
#endif


#define MESSAGE_SIZE    sizeof(StartupInfo) + 5
 
/* I/O can be blocking or non-blocking */

#define BLOCKING        (FALSE)
#define NON_BLOCKING    (TRUE)
 
typedef struct PacketBuf {
#if defined(PORTNAME_c90)
    int len:32;
    MsgType msgtype:32;
#else
    int len;
    MsgType msgtype;
#endif
    char data[MESSAGE_SIZE];
} PacketBuf;
 
/* invalid socket descriptor */

#define INVALID_SOCK    (-1)
 
 
/*
 * socket descriptor port of both client and server.
 */
struct portStrut {
    int                 sock;   /* file descriptor */
    int			srbPort; /* The port number of the srbServer */
    int			pipeFd1;   /* the pipe fd to reply to srbServer */
    int                 nBytes; /* nBytes read in so far */
    int			preSpawn; /* preSpawn srbServer ? */
    struct sockaddr_in  laddr;  /* local addr (us) */
    struct sockaddr_in  raddr;  /* remote addr (them) */
    PacketBuf           buf;    /* stream implementation (curr pack buf) */
    struct portStrut *next;
};

typedef struct portStrut Port;

/* The proxy operation types */

typedef enum {
    OPR_COPY,
    OPR_COMMAND,
    SFO_CREATE_INDEX,
    SFO_DELETE_INDEX,
    SFO_SEARCH_INDEX,
    SFO_GET_MORE_SEARCH_RESULT,
    SFO_APPLY_FILTER,
    SFO_GET_MORE_FILTER_RESULT,
    OPR_FUNCTION
} ProxyOprId;

#define ENV_LEN         32

/* struct to keep data read in from .MdasEnv file */
struct mdasEnvData {
    char user[ENV_LEN*3];
    char domain[ENV_LEN*3];
    char defColl[ENV_LEN*8];
    char defRes[ENV_LEN*3];
    char host[ENV_LEN*3];
    char port[ENV_LEN];
    char mcatZone[ENV_LEN];
    char authScheme[ENV_LEN];
    char authServer[ENV_LEN*3];
    char authServerDn[ENV_LEN*10];
    int retVal;
};

#define COMM_BUF_SIZE 512

typedef struct svrComm {
    int commFd;
    int inpInx1;
    int inpInx2;
    int outInx;
    int delegateCertInx;
    unsigned char inBuf[COMM_BUF_SIZE];    /* use of unsigned is important.
					    * If not, can trigger EOF in
					    * commGetc when reading -ive int
					    */
    char outBuf[COMM_BUF_SIZE];
} svrComm_t;

/* Client user info */

typedef struct userInfo {
  char *userName;       /* the user ID */
  char *domainName;     /* The user domain */
  char *mcatZone;       /* The user mcat zone */
  char *userAuth;       /* Authentication string (mdas/sea passwd) */
  int   userId;         /* the numeric user id */
  int   privUserFlag;   /* Indicate whether the user is privileged,
                         * 0-no, 1-yes */
  int authSchemeInx;
  svrComm_t *myComm;	/* set this to NULL if multithread. Used by elog()
			 * to set client msg 
			 */
  int session;
  void *sessionBuf;
} userInfo;

#endif	/* SRB_H */