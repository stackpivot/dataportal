/**************************************************************************
Copyright Notice
All Rights Reserved
Please refer to files in COPYRIGHT directory under the SRB software directory 
for copyright, usage, liability and license information.
Please read these files before using,modifying or distributing SRB software.
**************************************************************************/

#include "mdasC_db2_externs.h"
#include "mdasGlobalsExtern.h"
#include "mdasPrototypes.h"
#include "mcatAdmin.h"


extern char *clGetUserName(), *clGetDomainName(), *clGetAuth();

main(int argc,
        char* argv[])
{  
  int i;
  char *userName, *domainName, *userAuth;
  char clErrorMsg[MAX_TOKEN];

  if (argc != 6)
    {
      printf("Usage: ingestLocation  <LocationName> <NetPrefix> <ParentLocation> <serverUser> <serverUserDomain>\n");
      exit(0);
    }

    userName = clGetUserName(NULL,clErrorMsg);
    if (userName == NULL) {
        fprintf (stderr,
         "Unable to get the registrar's userName. Please configure the .MdasEnv file\n");
        exit(-1);
    }

    domainName = clGetDomainName(NULL,clErrorMsg);
    if (domainName == NULL) {
        fprintf (stderr,
         "Unable to get the registrar's domainName. Please configure the .MdasEnv file\n");
        exit(-1);
    }

    userAuth = clGetAuth(clErrorMsg);
    if (userAuth == NULL) {
        fprintf (stderr,
         "Unable to get the registrar's userAuth. Please configure the .MdasEnv file\n");
        exit(-1);
    }

    i = open_db2_interaction(MDAS_CATALOG);
    if (i != 0) {
      printf("Opening Error:%i\n",i);
      exit(-1);
    }
    
    
    ClientUser = (userInfo *) malloc (sizeof (userInfo));
    ClientUser->privUserFlag = 1;
    i = registerLocationInfo(argv[1],argv[2],argv[3],argv[4],argv[5],
			     userName, domainName, userAuth);
    if (i != 0)
      {
	printf("ingestLocation Error: %i\n",i);
	close_db2_interaction(MDAS_CAT_ROLLBACK);
	exit(-1);
      }
    close_db2_interaction(MDAS_CAT_COMMIT);
    return(0);
}

  
      
        
     

