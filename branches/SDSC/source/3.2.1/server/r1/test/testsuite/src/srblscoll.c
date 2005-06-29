/**************************************************************************
Copyright Notice
All Rights Reserved
Please refer to files in COPYRIGHT directory under the SRB software directory 
for copyright, usage, liability and license information.
Please read these files before using,modifying or distributing SRB software.
**************************************************************************/
 
/*-------------------------------------------------------------------------
 *
 * srblscoll.c--
 *
 * See README file or execute with -help flag.
 *
 *-------------------------------------------------------------------------
 */

#include "srbUserArgs.h"
#include "srbClient.h"

int
main(int argc, char **argv)
{
	srbConn *conn;
	const char* progname = "srblscoll" ;
	int srbargc[SRB_USER_ARGS] ;
	void *srbargv[SRB_USER_ARGS][SRB_USERARG_MAXC] ;
	int k ;
	int ncolls ;
	int n ;
	char *host ;
	char *port ;
	char *auth ;
	int status ;
	int catType ;
	char *collectionName;
	char *flag = "C" ;
	/* It takes two values:
        C  - for listing datasets and sub-collections in given collection
        R  - for recursively listing  datasets and sub-collections in
                given collection
	*/
	mdasC_sql_result_struct listResult;
	char *lptr ;

	for (k=0; k<SRB_USER_ARGS; k++)
		srbargc[k] = SRB_ARG_ILLEGAL ;
	srbargc[SRB_USER_ARG_HOST] = 1 ;
	srbargc[SRB_USER_ARG_PORT] = 1 ;
	srbargc[SRB_USER_ARG_AUTH] = 1 ;
	srbargc[SRB_USER_ARG_CATT] = 1 ;
	srbargc[SRB_USER_ARG_VERB] = SRB_ARG_OPTIONAL ;
	srbargc[SRB_USER_ARG_COLL] = SRB_ARG_REQUIRED ;
	srbUserArgs(progname, argc, argv, srbargc, srbargv) ;
	if (srbargc[SRB_USER_ARG_HELP] != 0)
		exit(0) ;
	if (srbargc[SRB_USER_ARG_ERR] != 0)
	{
		fprintf(stderr, "srblscoll: aborting on srbUserArgs error\n");
		exit(42) ;
	}
	host = (char *) srbargv[SRB_USER_ARG_HOST][0] ;
	port = (char *) srbargv[SRB_USER_ARG_PORT][0] ;
	auth = (char *) srbargv[SRB_USER_ARG_AUTH][0] ;
	catType = *((int*) srbargv[SRB_USER_ARG_CATT][0]) ;


	/* set up the connection */
	if (srbargc[SRB_USER_ARG_VERB] != 0)
		fprintf(stderr, "srblscoll : trying clConnect with\n\t host = %s\n\t port = %s\n\t auth = %s\n", host, port, auth) ;
	conn = clConnect (host, port, auth);

	/* check to see that the backend connection was successfully made */
	if (clStatus(conn) != CLI_CONNECTION_OK)
	{
		fprintf(stderr,"srblscoll: Connection to srbMaster failed.\n");
		fprintf(stderr,"%s",clErrorMessage(conn));
		clFinish(conn);
		exit(1);
	}
	if (srbargc[SRB_USER_ARG_VERB] != 0)
		fprintf(stderr, "srblscoll: connected.\n\n") ;


	/* list collections */

	ncolls = srbargc[SRB_USER_ARG_COLL] ;

	for (n=0 ; n<ncolls ; n++)
	{
		collectionName = (char*) srbargv[SRB_USER_ARG_COLL][n] ;

		if (srbargc[SRB_USER_ARG_VERB] != 0)
			fprintf(stderr,"srblscoll: Attempting srbListCollect with\n\t catType = %d\n\t flag = %s\n\t collectionName = %s\n", catType, flag, collectionName) ;

		status = srbListCollect(conn, catType, collectionName, flag, &listResult, 200) ;
		if (status == MCAT_INQUIRE_ERROR) {
			fprintf(stderr,"srblscoll: empty collection\n");
		} else if (status < 0) {
			fprintf(stderr,"srblscoll: srbListCollect failed (status = %d)\n", status) ;
			fprintf(stderr,"%s",clErrorMessage(conn));
			exit(1) ;
	        } else {

		    printSqlResult (&listResult);
		    clearSqlResult (&listResult);  /* clear the content */
		}
	}


	/* close the connection */
	if (srbargc[SRB_USER_ARG_VERB] != 0)
		fprintf(stderr, "srblscoll: closing connection ...\n") ;
	clFinish(conn);
	if (srbargc[SRB_USER_ARG_VERB] != 0)
		fprintf(stderr, "srblscoll: finished.\n\n") ;

	srbFreeArgs(srbargc, srbargv) ;

	exit(0);
}
