/**************************************************************************
Copyright Notice
All Rights Reserved
Please refer to files in COPYRIGHT directory under the SRB software directory 
for copyright, usage, liability and license information.
Please read these files before using,modifying or distributing SRB software.
**************************************************************************/
 


/* Sbunload.c - unload a container 
 */

#include "scommands.h"
#ifdef _WIN32
#include "SrbNtUtil.h"
#include "nt_extra.h"
#endif

#define MAX_ROW_OUT     500
#define MAX_NUM_BL_THR 1024
#define MAX_NUM_CONT   100000
#define COMMON_DIR_FILE  "commondir"

#ifdef PARA_OPR
pthread_t Tid[MAX_NUM_BL_THR];
int *Tstatus[MAX_NUM_BL_THR];
int Tactive[MAX_NUM_BL_THR];
int ThrInx = 0;
#endif
 
extern char srbAuth[];
extern char srbHost[];
extern char srbUser[];
extern char defaultResource[];
extern char mdasCollectionName[];
extern char mdasCollectionHome[];
extern char inCondition[];

int
queryContainerByColl (srbConn *conn, char *collection,
mdasC_sql_result_struct *myresult);

int
genIncontList (srbConn *conn, char *fullContName, char *targetDir, 
char *outPrefix, char **commonPath, char *srcCollection, char **outInxFile);
int
genContainerCont (srbConn *conn, char *contColl, char *contName,
                 char *targetDir, char *outPrefix, int flagval);
int
printInxResult (FILE *out_fd, mdasC_sql_result_struct *myresult,
char **commonPath, char *srcCollection);
int
openAndProcLocalPath (char *srbPath, char *localRootDir, char *commonPath,
char *localPath);
int
unfoldContainer (srbConn *conn, char *contColl, char *contName,
char *targetDir, char *commonPath, int flagval, char *outInxFile);
int
getLine(FILE *fp, char *buf, int bufsz);
int
unfoldBulkUnload (char *inpColl, char *targetDir, int srb_fd,
mdasC_sql_result_struct *myresult, int flagval);
int
parseInx (FILE *in_fd, char *srbPath, srb_long_t *offset, srb_long_t *size,
char *chksum);

srb_long_t
getTotalSzByResult (mdasC_sql_result_struct *myresult);

int
clGenIncontListInColl (srbConn *conn, int catType, char *collection,
char *container, mdasC_sql_result_struct *myresult);

int
queryAndUnfoldCont (srbConn *conn, char *fullContName, char *targetDir,
char *srbCollection);

int 
unloadContMain (srbConn *conn, int catType, int nArgv, 
srbPathName nameArray[],int flagval, char *localdir, 
srbPathName collNameArray[])
{
    int i, row;
    int status;
    /* mdasC_sql_result_struct dataResult[MAX_TOKEN]; */
    mdasC_sql_result_struct *dataResult;
    int dataCnt = 0;
    char srcPar[MAX_TOKEN], srcCh[MAX_TOKEN]; 
    char targetDir[MAX_TOKEN];
    char *contColl, *contName, *prevContColl, *prevContName;
    char fullContName[MAX_TOKEN];
    char *commonPath = NULL;
    struct stat statbuf;

    srandom(time(0));
    dataResult = malloc (nArgv * sizeof (mdasC_sql_result_struct));
    if (dataResult == NULL)
	return (CLI_ERR_MALLOC);

    status = stat (localdir, &statbuf);

    if (status < 0) {
        strcpy (targetDir, localdir);
	status = mkdir(targetDir, 0750);
    } else if ((statbuf.st_mode & S_IFREG) != 0) {     /* A file */
        fprintf (stderr, "local dir %s is a file\n", localdir);
	free (dataResult);
        return (-1);
    } else if ((statbuf.st_mode & S_IFDIR) != 0) {      /* A directory */
        splitpath (collNameArray[0].outArgv, srcPar, srcCh);
        sprintf (targetDir, "%s/%s", localdir, srcCh);
	status = mkdir(targetDir, 0750);
    } else {
	strcpy (targetDir, localdir);
	status = mkdir(targetDir, 0750);
    }

    /* check the input collection */
    
    if (checkCollection (conn, MDAS_CATALOG, collNameArray[0].outArgv) != 0) {
        fprintf(stderr, "collection %s not found\n",collNameArray[0].outArgv);
	free (dataResult);
        return (COLLECTION_NOT_IN_CAT);
    }
    if (flagval & c_FLAG) {
        for (i = 0; i < nArgv; i++) {
            /* set flagval to 0 first for non-recursive check */
            status = queryData (conn, catType, nameArray[i].outArgv, 0,
             MAX_GET_RESULTS, &dataResult[i]);
            if (status < 0) {
                continue;
            }

            dataCnt += dataResult[i].row_count;
        }
    } else {
	/* fill in dataResult */
        for (i = 0; i < nArgv; i++) {
	    if (nameArray[i].outArgv != NULL && 
	     strlen (nameArray[i].outArgv) > 0) {
	        dataResult[i].row_count = 1;
	        dataResult[i].result_count = 2;
                dataResult[i].sqlresult[0].tab_name = 
		 strdup (dcs_tname[DATA_NAME]);
                dataResult[i].sqlresult[0].att_name = 
		 strdup (dcs_aname[DATA_NAME]);
                dataResult[i].sqlresult[1].tab_name = 
	         strdup (dcs_tname[DATA_GRP_NAME]);
                dataResult[i].sqlresult[1].att_name = 
	         strdup (dcs_aname[DATA_GRP_NAME]);
	        dataResult[i].sqlresult[0].values = malloc (MAX_TOKEN);
	        dataResult[i].sqlresult[1].values = malloc (MAX_TOKEN);
	        splitpath (nameArray[i].outArgv, 
		 dataResult[i].sqlresult[1].values,
	          dataResult[i].sqlresult[0].values);
                dataCnt += dataResult[i].row_count;
	    } else {
	        dataResult[i].row_count = 0;
	        dataResult[i].result_count = 0;
		dataCnt++;	
	    }
	}
    }

    if (dataCnt == 0) {
        fprintf (stderr, "No file was found in %s\n",
          nameArray[0].inpArgv);
	free (dataResult);
        return (CLI_ERR_COLLNAME);
    }

    status = 0;
    for (i = 0; i < nArgv; i++) {
        contColl = (char *) getFromResultStruct(&dataResult[i],
          dcs_tname[DATA_GRP_NAME], dcs_aname[DATA_GRP_NAME]);
        contName = (char *) getFromResultStruct(&dataResult[i],
          dcs_tname[DATA_NAME], dcs_aname[DATA_NAME]);

 	prevContColl = prevContName = NULL;

	if (status >= 0) {
          for (row = 0; row < dataResult[i].row_count; row++) {
	    /* Could get more that 1 result with the same container */
	    if (prevContColl == NULL || strcmp (contColl, prevContColl) != 0 ||
	     strcmp (contName, prevContName) != 0) {
                sprintf (fullContName, "%s/%s", contColl, contName);
                status = queryAndUnfoldCont (conn, fullContName, targetDir,
                 collNameArray[0].outArgv);

	        if (status < 0) {
		    if (status == MCAT_INQUIRE_ERROR) {
			status = 0;
            		contColl += MAX_DATA_SIZE;
            		contName += MAX_DATA_SIZE;
			continue;
		    }
	            fprintf(stderr,
		     "unloadContMain: queryAndUnfoldCont container %s error, status=%i\n",
	               fullContName, status);
	            srb_perror (2, status, "", SRB_RCMD_ACTION|SRB_LONG_MSG);
		    break;
	        }
	    }
	    prevContColl = contColl;
	    prevContName = contName;
            contColl += MAX_DATA_SIZE;
            contName += MAX_DATA_SIZE;
	  }
        }
    }

    for (i = 0; i < nArgv; i++) {
	if (status >= 0) {
	    if (dataResult[i].row_count == 0) {
	        /* we have non-container files */
	        mdasC_sql_result_struct *nonContResult;
		int src_fd;

		/* New call - do a srbBulkUnloadC instead srbBulkUnload */
		src_fd = srbBulkUnloadC (conn, MDAS_CATALOG, 0, 
		 collNameArray[0].outArgv, &nonContResult);
                if (src_fd == SYS_ERR_NO_SUPPORT || 
                  src_fd == CLI_FUNC_NOT_SUPPORTED)
                    src_fd = srbBulkUnload (conn, MDAS_CATALOG, 0,
                     collNameArray[0].outArgv, &nonContResult);
                if (src_fd < 0) {
		    if (src_fd == DATA_NOT_IN_CAT) { 
			/* Reminder - need to make the collection */
		    } else {
		        status = src_fd;
                        fprintf(stderr,
                         "unloadContMain:Err srbBulkUnload for %s,stat=%i\n",
                           collNameArray[0].outArgv, src_fd);
                        srb_perror (2, src_fd, "",
                         SRB_RCMD_ACTION|SRB_LONG_MSG);
		    }
                    break;
		}
                status = unfoldBulkUnload (collNameArray[0].outArgv, 
                         targetDir, src_fd, nonContResult, flagval);

		/* freeSqlResult (nonContResult); done in unfoldBulkUnload */
	    }
        }
	clearSqlResult (&dataResult[i]);
    }

    free (dataResult);
    return (status);
}

char *
getContainerByObj (srbConn *conn, char *inContainerObj)
{
    int status, i;
    char qval[MAX_DCS_NUM][MAX_TOKEN];
    int  selval[MAX_DCS_NUM];
    srbPathName objPath;
    char collname[MAX_TOKEN];
    char dataname[MAX_TOKEN];
    mdasC_sql_result_struct myresult;
    char *container, *outContainer;

    objPath.inpArgv = inContainerObj;

    if (parseName (&objPath, mdasCollectionName) < 0) 
	return (NULL);

    splitpath (objPath.outArgv, collname, dataname);

    /* Setup the query */

    for (i = 0; i < MAX_DCS_NUM; i++) {
        sprintf(qval[i],"");
        selval[i] = 0;
    }

    selval[CONTAINER_NAME] = 1;
    sprintf(qval[DATA_NAME], " = '%s'", dataname);
    sprintf(qval[DATA_GRP_NAME], " = '%s'", collname);

    status = srbGetDataDirInfo(conn, MDAS_CATALOG, qval, selval,
                                      &myresult, MAX_GET_RESULTS );

    if (status < 0)
	return (NULL);

    container = (char *) getFromResultStruct(
                           (mdasC_sql_result_struct *) &myresult,
                           dcs_tname[CONTAINER_NAME],
                           dcs_aname[CONTAINER_NAME]);

    if (container != NULL) {
	outContainer = strdup (container);
	clearSqlResult (&myresult);
	return (outContainer);
    } else {
	return (NULL);
    }
}
   
int
queryContainerByColl (srbConn *conn, char *collection, 
mdasC_sql_result_struct *myresult)
{
    int status, i;
    char qval[MAX_DCS_NUM][MAX_TOKEN];
    int  selval[MAX_DCS_NUM];

    /* Setup the query */

    for (i = 0; i < MAX_DCS_NUM; i++) {
        sprintf(qval[i],"");
        selval[i] = 0;
    }

    selval[CONTAINER_NAME] = 1;
#ifdef foo
    /* genDataLikeSQL ("%", qval[DATA_NAME]); */
    strcpy (collName, collection);
    collLike = make_like_for_mdas (collName); /***MLFM CHECK ****/
    if (collLike > 0)
        genCollLikeSQL (collName, qval[DATA_GRP_NAME], 1);
    else {
        escapeWildCards(collName);
        genCollLikeSQL (collName, qval[DATA_GRP_NAME], 1);
    }
#endif
    sprintf (qval[DATA_GRP_NAME],
     " like '%s' ESCAPE '\\' || like '%s/%%' ESCAPE '\\'",
            collection, collection);

    status = srbGetDataDirInfo(conn, MDAS_CATALOG, qval, selval,
                                      myresult, MAX_GET_RESULTS );

    if (status < 0)
	return (status);
    else
	return (myresult->row_count);
}
   
int 
setContainerAsRoot (char *container)
{
    int len;
    char *tmpPtr;
    int c;
    int haveDigit = 0;

    len = strlen (container) - 1;
    tmpPtr = container + len;

    while ((c = *tmpPtr) != '/') {
        if (c == '.') {
	    if (haveDigit > 0) {
		*tmpPtr = '\0';
		return 1;
	    } else {
		return 0;
	    }
	}
	if (isdigit (c)) {
	    haveDigit ++;
	} else {
	    return 0;
	}
	tmpPtr --;
    }
    return 0;
}

int
genIncontList (srbConn *conn, char *fullContName, char *targetDir, 
char *outPrefix, char **commonPath, char *srcCollection, char **outInxFile)
{
    mdasC_sql_result_struct myresult;
    int i, status;
    char qval[MAX_DCS_NUM][MAX_TOKEN];
    int  selval[MAX_DCS_NUM];
    FILE *out_fd;
    int continuation_index, result_count;

    *outInxFile = NULL;

    for (i = 0; i < MAX_DCS_NUM; i++) {
        sprintf(qval[i],"");
        selval[i] = 0;
    }

    selval[DATA_NAME] = 1;
    selval[DATA_GRP_NAME] = 1;
    selval[SIZE] = 1;
    selval[OFFSET] = 1;
    selval[DATA_CHECKSUM] = 1;
    sprintf(qval[DATA_ID] ," <> %s%s",
     MDASSCHEMENAME,"MDAS_AD_REPL.container_id");
    genEqualSQL (qval[CONTAINER_NAME], fullContName);

    sprintf (qval[DATA_GRP_NAME],
     " like '%s' ESCAPE '\\' || like '%s/%%' ESCAPE '\\'",
            srcCollection, srcCollection);

    status = srbGetDataDirInfo(conn, MDAS_CATALOG, qval, selval,
                                      &myresult, MAX_GET_RESULTS );

    if (status < 0) {
        if (status != CLI_NO_ANSWER && status != MCAT_INQUIRE_ERROR) {
            srb_perror (2, status, "", SRB_RCMD_ACTION|SRB_LONG_MSG);
        }
        return (status);
    }

    *outInxFile = malloc (strlen (outPrefix) + strlen (targetDir) + 20);
    sprintf (*outInxFile, "%s/%s.%-d.inx", targetDir, outPrefix, random());

#ifdef _WIN32
    out_fd = SrbNt_fopen(*outInxFile, "w");
#else
    out_fd = fopen (*outInxFile, "w");
#endif
    if (out_fd == NULL) {
        fprintf(stderr,
         "can't open local file %s, errno = %d\n",
           *outInxFile, errno);
	free (*outInxFile);
	return (-1);
    }

    printInxResult (out_fd, &myresult, commonPath, srcCollection);

    continuation_index = myresult.continuation_index;
    result_count = myresult.result_count;
    clearSqlResult (&myresult);
    while (continuation_index >= 0 && result_count > 0) {
       status = srbGetMoreRows(conn, MDAS_CATALOG,
         continuation_index, &myresult, MAX_GET_RESULTS);
        if (status == 0) {
            result_count = myresult.result_count;
            if (result_count <= 0)
                break;
    	    printInxResult (out_fd, &myresult, commonPath, srcCollection);
            clearSqlResult (&myresult);
            continuation_index = myresult.continuation_index;
        } else
            break;
    }

    fclose (out_fd);
    
    return (0);
}

int
printInxResult (FILE *out_fd, mdasC_sql_result_struct *myresult,
char **commonPath, char *srcCollection)
{
    char *dataName, *collection, *size, *offset, *chksum;
    int i;

    dataName = (char *) getFromResultStruct(myresult,
      dcs_tname[DATA_NAME], dcs_aname[DATA_NAME]);
    collection = (char *) getFromResultStruct(myresult,
      dcs_tname[DATA_GRP_NAME], dcs_aname[DATA_GRP_NAME]);
    size = (char *) getFromResultStruct(myresult,
      dcs_tname[SIZE], dcs_aname[SIZE]);
    offset = (char *) getFromResultStruct(myresult,
      dcs_tname[OFFSET], dcs_aname[OFFSET]);
    chksum = (char *) getFromResultStruct(myresult,
      dcs_tname[DATA_CHECKSUM], dcs_aname[DATA_CHECKSUM]);

    if (srcCollection != NULL && *commonPath == NULL) {
	*commonPath = strdup (srcCollection);
    }
	
    for (i = 0; i < myresult->row_count; i++) {
	if (srcCollection != NULL) {
	    /* do nothing */
	} else if (*commonPath == NULL) {
	    *commonPath = strdup (collection);
	} else {
	    char *tmpstr1, *tmpstr2, *lastslash = NULL;
	    int c1, c2;
	    int len = 0;

	    tmpstr1 = *commonPath;
	    tmpstr2 = collection;
	    while ((c1 = *tmpstr1) == (c2 = *tmpstr2)) {
		if (c1 == '\0')
		    break;
		if (c1 == '/') {
		    lastslash = tmpstr1;
		}
		len ++;
		tmpstr1++;
		tmpstr2++;
		continue;
	    }
	    if (c1 != c2) {
		if (c2 == '\0') {	/* c2 is short */
		    if (c1 == '/') {
			*tmpstr1 = '\0';
		    } else {
			if (lastslash == *commonPath) /* root */
			    lastslash ++;
			*lastslash = '\0';
		    }
		} else if (c1 != '\0' || c2 != '/') {
                    if (lastslash == *commonPath) /* root */
                        lastslash ++;
                    *lastslash = '\0';
		}
	    }
	}
        fprintf (out_fd, "%s/%s %s %s %d\n", 
	  collection, dataName, offset, size, atoi (chksum));
        dataName += MAX_DATA_SIZE;
        collection += MAX_DATA_SIZE;
        offset += MAX_DATA_SIZE;
        size += MAX_DATA_SIZE;
        chksum += MAX_DATA_SIZE;
    }

    return (0);
}

int
genContainerCont (srbConn *conn, char *contColl, char *contName,
                 char *targetDir, char *outPrefix, int flagval)
{
    int status;
    mdasC_sql_result_struct myresult;
    char *outContFile;


    myresult.result_count = 3;
    myresult.row_count = 1;
    myresult.sqlresult[0].tab_name = dcs_tname[DATA_GRP_NAME];
    myresult.sqlresult[0].att_name = dcs_aname[DATA_GRP_NAME];
    myresult.sqlresult[0].values = (mdasC_handle)  contColl;
    myresult.sqlresult[1].tab_name = dcs_tname[DATA_NAME];
    myresult.sqlresult[1].att_name = dcs_aname[DATA_NAME];
    myresult.sqlresult[1].values = (mdasC_handle)  contName;
    myresult.sqlresult[2].tab_name = dcs_tname[SIZE];
    myresult.sqlresult[2].att_name = dcs_aname[SIZE];
    myresult.sqlresult[2].values = (mdasC_handle)  "1";

    outContFile = malloc (strlen (outPrefix) + strlen (targetDir) + 10);
    sprintf (outContFile, "%s/%s.dat", targetDir, outPrefix);

    status = dataToFileCopy (conn, MDAS_CATALOG, flagval, DATANAME_T,
     &myresult, -1, outContFile, "");

    free (outContFile);
    if (status < 0) {
	fprintf (stderr, "dataToFileCopy of %s/%s error, stat = %d\n",
	 contColl, contName, status); 
        srb_perror (2, status, "", SRB_RCMD_ACTION|SRB_LONG_MSG);
        return (status);
    }
    return (status);
}

int
unfoldContainer (srbConn *conn, char *contColl, char *contName,
char *targetDir, char *commonPath, int flagval, char *inxFile)
{
    FILE *in_fd;
    int srb_fd;
    char *buf;
    int cnt;
    int i;
    char srbPath[MAX_TOKEN], localRootDir[MAX_TOKEN];
    char localPath[MAX_TOKEN * 2];
    srb_long_t offset, size;
    srb_long_t tmpOffset, curOffset = 0;
    int local_fd;
    int status;
    int commonPathLen;
    struct stat statbuf;
    int targType;
    char strChksum[CHKSUM_STR_LEN + 1];

    commonPathLen = strlen (commonPath);

    status = stat (targetDir, &statbuf);

    if (status < 0) {
	targType = -1;	/* does not exist */
    } else if ((statbuf.st_mode & S_IFREG) != 0) {     /* A file */
	targType = DATANAME_T;
    } else if ((statbuf.st_mode & S_IFDIR) != 0) {      /* A directory */
        targType = COLLECTION_T;
    } else {
	targType = -1;  /* does not exist */
    }
    
    if (targType >= DATANAME_T) {
	fprintf (stderr, "target dir %s is a file\n", targetDir);
	return (-1);
    }

    strcpy (localRootDir, targetDir);
#ifdef foo
    /* get localRootDir */
    if (strcmp (commonPath, mdasCollectionHome) == 0) {
	strcpy (localRootDir, targetDir);
    } else {
        splitpath (commonPath, par, child);
	if (targType == COLLECTION_T) {
	        sprintf (localRootDir, "%s/%s", targetDir, child);
	} else {
	        strcpy (localRootDir, targetDir);
	}
        len = strlen (targetDir) - strlen (child);
        if (len > 0) {
            tmpptr = targetDir + len;
	    if (*(tmpptr - 1) == '/' && strcmp (tmpptr, child) == 0 ||
	     targType == -1) {
	        strcpy (localRootDir, targetDir);
	    } else {
	        sprintf (localRootDir, "%s/%s", targetDir, child);
	    }
        } else if (len == 0) {
	    if (strcmp (targetDir, child) == 0) {
                strcpy (localRootDir, targetDir);
            } else {
                sprintf (localRootDir, "%s/%s", targetDir, child);
            }
        } else {
	    sprintf (localRootDir, "%s/%s", targetDir, child);
        }
    }

    inxFile = malloc (strlen (contName) + strlen (targetDir) + 10);
    sprintf (inxFile, "%s/%s.inx", targetDir, contName);
#endif

#ifdef _WIN32
    in_fd = SrbNt_fopen(inxFile, "r");
#else
    in_fd = fopen (inxFile, "r");
#endif
    if (in_fd == NULL) {
        fprintf(stderr,
         "can't open local file %s, errno = %d\n",
           inxFile, errno);
        free (inxFile);
        return (-1);
    }

    srb_fd = srbObjOpen (conn, contName, O_RDONLY, contColl);
    if (srb_fd < 0) {
        fprintf(stderr,
         "Unable to open object '%s/%s', status = %d.\n",
          contColl, contName, srb_fd);
        srb_perror (2, srb_fd, "", SRB_RCMD_ACTION|SRB_LONG_MSG);
	fclose (in_fd);
	free (inxFile);
        return(srb_fd);
    }

    while (1) {
        i = parseInx (in_fd, srbPath, &offset, &size, strChksum);

        if (i < 0) {
    	    fprintf (stderr, "No file to unload\n"); 
	    srbObjClose (conn, srb_fd);
	    if (i == EOF)
                return (0);
	    else
                return (-1);
        }

        if (flagval & t_FLAG) 
	    break;

	if (strncmp (commonPath, srbPath, commonPathLen) != 0)
	    continue;
	else
	    break;
    }

    if (offset != curOffset) {
	if ((tmpOffset = srbObjSeek (conn, srb_fd, offset, SEEK_SET)) != 
	 offset) {
            fprintf(stderr, "srbObjSeek loc %lld != input %lld\n",
             tmpOffset, offset);
            srb_perror (2, tmpOffset, "", SRB_RCMD_ACTION|SRB_LONG_MSG);
            fclose (in_fd);
            free (inxFile);
	    srbObjClose (conn, srb_fd);
	    return ((int) tmpOffset);
	}
	curOffset = offset;
    }
    local_fd = openAndProcLocalPath (srbPath, localRootDir, commonPath, 
     localPath); 
    if (local_fd < 0) {
        fclose (in_fd);
        free (inxFile);
	srbObjClose (conn, srb_fd);
        return (local_fd);
    }

    buf = malloc (BL_BUFSIZE + 1);
    if (buf == NULL) {
        fprintf (stderr, "unfoldContainer: Unable to malloc buf\n");
        fclose (in_fd);
        free (inxFile);
	close (local_fd);
	srbObjClose (conn, srb_fd);
        return (CLI_ERR_MALLOC);
    }

    status = 0;
    while ((cnt =  srbObjRead (conn, srb_fd, buf, BL_BUFSIZE)) > 0) {
	char *bufptr;

	if (status < 0)
	    break;

	bufptr = buf;
	while (cnt > 0) {
	    int diffOffset;

	    if (cnt >= size) {
	        status = write (local_fd, bufptr, size);
	        if (status < size) {
                    fprintf(stderr,
                     "unfoldContainer: Read %lld bytes, Wrote %d bytes.\n ",
                     size, status);
		    status = -1;
		    break;
	        }
		cnt -= size;
		curOffset += size;
		bufptr += size;
		close (local_fd);

                /* do chksum */
                if (flagval & k_FLAG) {     /* chksum */
                    unsigned long ulCheckSum, ulChecksumFromSrb;

                    ulChecksumFromSrb =
                      (unsigned long) strtol (strChksum,
                      (char **) NULL, 10);

                    if (ulChecksumFromSrb == 0) {
                        fprintf (stderr,
                         "unfoldBulkUnload, %s has no checksum.\n",
                          srbPath);
                    } else {
                        if (clFileSum (localPath, &ulCheckSum) < 0) {
                            fprintf (stderr,
                             "unfoldBulkUnload: clFileSum failed for %s\n",
                             srbPath);
                            status = -1;
                            break;
                        }
                        if (ulCheckSum != ulChecksumFromSrb) {
                            fprintf (stderr,
                              "unfoldBulkUnload, local file checksum (%ld) differs from SRB stored checksum (%ld)\n", ulCheckSum, ulChecksumFromSrb);
                            status = OBJ_ERR_BAD_CHKSUM;
                            break;
                        }
                    }
                }


		while (1) {
		    /* read in the next index */
    		    i = parseInx (in_fd, srbPath, &offset, &size, strChksum);
    		    if (i < 0) {
			status = i;
		        break;
		    }
        	    if (flagval & t_FLAG) 
            		break;

        	    if (strncmp (commonPath, srbPath, commonPathLen) != 0) {
            		continue;
		    } else {
			break;
		    }
		}
                if (status < 0)
                    break;
    		local_fd = openAndProcLocalPath (srbPath, localRootDir, 
		 commonPath, localPath);
    		if (local_fd < 0) {
        	    status = local_fd;
		    break;
    		}
		diffOffset = offset - curOffset;
                if (diffOffset > 0 && diffOffset >= cnt) {
                    if ((tmpOffset =
                     srbObjSeek (conn, srb_fd, offset, SEEK_SET)) != offset) {
                        fprintf(stderr, "srbObjSeek loc %lld != input %lld\n",
                         tmpOffset, offset);
                        srb_perror (2, tmpOffset, "",
                         SRB_RCMD_ACTION|SRB_LONG_MSG);
			if (tmpOffset < 0)
                            status = (int) tmpOffset;
			else 
			    status = -1;
			break;
                    }
		    curOffset = offset;
		    cnt = 0;
		    continue;
		} else {
                    curOffset = offset;
		    bufptr += diffOffset;	    
		    cnt -= diffOffset;
		}
	    } else {	/* cnt < size */
                status = write (local_fd, bufptr, cnt);
                if (status < cnt) {
                    fprintf(stderr,
                     "unfoldContainer: Read %d bytes, Wrote %d bytes.\n ",
                     cnt, status);
                    status = -1;
                    break;
                }
		size -= cnt;
                curOffset += cnt;
		cnt = 0;
	    }
        }
    }
    free (buf);
    fclose (in_fd);
    unlink (inxFile);
    free (inxFile);
    srbObjClose (conn, srb_fd);
    return (0);
}

int
openAndProcLocalPath (char *srbPath, char *localRootDir, char *commonPath,
char *localPath)
{
    char dirName[MAX_TOKEN * 2];
    char *ptr;
    int fd;
    int tmpLen, pathlen, status;
    struct stat statbuf;
    int commonPathLen;

    commonPathLen = strlen (commonPath);

    if (strlen (srbPath) < commonPathLen + 2) {
	fprintf (stderr, 
	 "srbPath %s is too short comparing with collection %s\n",
	 srbPath, commonPath);
	return (-1);
    }
    ptr = srbPath + commonPathLen + 1;

    sprintf (localPath, "%s/%s", localRootDir, ptr);


#ifdef _WIN32
	fd = SrbNtFileBinaryOpen(localPath, O_RDWR|O_TRUNC);
#else
    fd = open (localPath, O_RDWR|O_TRUNC, 0640);
#endif

    if (fd >= 0)
	return fd;

    /* have to make directories */

    /* don't use splitpath because it assume SRB path for relative
     * path */

    pathlen = strlen (localPath);
    while (pathlen && localPath[pathlen] != '/')
        pathlen --;

    strncpy (dirName, localPath, pathlen);
    dirName[pathlen] = '\0';

    tmpLen = pathlen;
    while (tmpLen > 0) {
        if (stat (dirName, &statbuf) == 0)
            break;      /* The directory exist */

        /* Go backward */

        while (tmpLen && dirName[tmpLen] != '/')
            tmpLen --;
        dirName[tmpLen] = '\0';
    }

    /* Now we go forward and mk the required dir */
    while (tmpLen < pathlen) {
        /* Put back the '\' */
        dirName[tmpLen] = '/';
        status = mkdir (dirName, 0750);
        if (status != 0 && errno != EEXIST) {
            fprintf (stderr, "openAndProcLocalPath: Unable to make user dir %s",
              dirName);
            if (status > 0)
                return (-1);
            else
                return status;
        }
        while (tmpLen && dirName[tmpLen] != '\0')
            tmpLen ++;
    }

    /* Now try to create the file again */

#ifdef _WIN32
	fd = SrbNtFileBinaryOpen(localPath, O_RDWR|O_CREAT);
#else
    fd = open (localPath, O_RDWR|O_CREAT, 0640);
#endif


    if (fd < 0) {
	fprintf (stderr, 
	 "openAndProcLocalPath: create local file %s err, errno=%d\n", 
	  localPath, errno);
    }
    
    return (fd);
}

int 
parseInx (FILE *in_fd, char *srbPath, srb_long_t *offset, srb_long_t *size,
char *chksum)
{
    char buf[MAX_TOKEN * 2];
    char buf1[MAX_TOKEN * 2];
    char sizeStr[MAX_TOKEN];
    char offsetStr[MAX_TOKEN];
    int i;

    memset (buf, 0, sizeof (buf));
    memset (buf1, 0, sizeof (buf1));
    memset (sizeStr, 0, sizeof (sizeStr));
    memset (offsetStr, 0, sizeof (offsetStr));
    i = getLine(in_fd, buf, sizeof(buf));
    if (i == EOF)
	return (EOF);
    
    errno = 0;

    clSplitbychar (buf, buf1, chksum, ' ');

    clSplitbychar (buf1, buf, sizeStr, ' ');
    *size = strtoll (sizeStr, 0, 0);
    if (*size == 0 && errno == EINVAL) {
	fprintf (stderr, "Error parsing %s for size", buf);
	return (-2);
    }

    clSplitbychar (buf, srbPath, offsetStr, ' ');
    *offset = strtoll (offsetStr, 0, 0);
    if (*offset == 0 && errno == EINVAL) {
        fprintf (stderr, "Error parsing %s for offset", buf);
        return (-2);
    }

    return (0);
}

/* getLine - Read the next line. same as getNextLine without discarding
 * comment (start with '#'
 */

int
getLine(FILE *fp, char *buf, int bufsz)
{
    int c;
    int len = 0;
    char *cptr = buf;

    while ((c = getc(fp)) != EOF) {
        if (c == '\n')
            break;
        *cptr ++ = c;
        len ++;

        /* over flow buf ? */
        if (len >= bufsz - 1) {
            break;
        }

    }
    if (c == EOF && len == 0)
        return EOF;
    else {
        *cptr ++ = '\0';
        len ++;
        return len;
    }
}

int
listNoncontIncoll (srbConn *conn, char *collection,
mdasC_sql_result_struct *myresult)
{
    int i, status;
    char qval[MAX_DCS_NUM][MAX_TOKEN];
    int  selval[MAX_DCS_NUM];
    char collName[MAX_TOKEN];
    int collLike;

    for (i = 0; i < MAX_DCS_NUM; i++) {
        sprintf(qval[i],"");
        selval[i] = 0;
    }

    selval[DATA_NAME] = 1;
    selval[DATA_GRP_NAME] = 1;
    selval[SIZE] = 1;
    /* genEqualSQL (qval[CONTAINER_NAME], "null"); */
    sprintf(qval[CONTAINER_NAME], " not like  '/%%' ESCAPE '\\'");
    strcpy (collName, collection);
    collLike = make_like_for_mdas (collName); /***MLFM CHECK ****/
    if (collLike > 0)
        genCollLikeSQL (collName, qval[DATA_GRP_NAME], 1);
    else {
        escapeWildCards(collName);
        genCollLikeSQL (collName, qval[DATA_GRP_NAME], 1);
    }

    status = srbGetDataDirInfo(conn, MDAS_CATALOG, qval, selval,
                                      myresult, MAX_GET_RESULTS );

    if (status < 0) {
        if (status != CLI_NO_ANSWER && status != MCAT_INQUIRE_ERROR) {
            srb_perror (2, status, "", SRB_RCMD_ACTION|SRB_LONG_MSG);
        }
        return (status);
    }
printSqlResult (myresult);
#ifdef foo
    outInxFile = malloc (strlen (outPrefix) + strlen (targetDir) + 10);
    sprintf (outInxFile, "%s/%s.inx", targetDir, outPrefix);

#ifdef _WIN32
    out_fd = SrbNt_fopen(outInxFile, "w");
#else
    out_fd = fopen (outInxFile, "w");
#endif
    if (out_fd == NULL) {
        fprintf(stderr,
         "can't open local file %s, errno = %d\n",
           outInxFile, errno);
	free (outInxFile);
	return (-1);
    }

    printInxResult (out_fd, &myresult, commonPath, srcCollection);

    continuation_index = myresult.continuation_index;
    result_count = myresult.result_count;
    clearSqlResult (&myresult);
    while (continuation_index >= 0 && result_count > 0) {
       status = srbGetMoreRows(conn, MDAS_CATALOG,
         continuation_index, &myresult, MAX_GET_RESULTS);
        if (status == 0) {
            result_count = myresult.result_count;
            if (result_count <= 0)
                break;
    	    printInxResult (out_fd, &myresult, commonPath, srcCollection);
            clearSqlResult (&myresult);
            continuation_index = myresult.continuation_index;
        } else
            break;
    }

    fclose (out_fd);
    free (outInxFile);
#endif
    
    return (0);
}
 
int
unfoldBulkUnload (char *inpColl, char *targetDir, int srb_fd, 
mdasC_sql_result_struct *myresult, int flagval)
{
    char *buf;
    int cnt;
    int inx;
    char srbPath[MAX_TOKEN], localRootDir[MAX_TOKEN], localPath[MAX_TOKEN * 2];
    srb_long_t offset, size;
    srb_long_t curOffset;
    int local_fd;
    int status;
    char *collection, *objID, *strSize, *strOffset, *strChksum;
    int continuation_index = 1;
    srb_long_t totalSz = 0;
    int toRead;

    strcpy (localRootDir, targetDir);
#ifdef foo
    /* get localRootDir */
    if (strcmp (inpColl, mdasCollectionHome) == 0) {
	strcpy (localRootDir, targetDir);
    } else {
        splitpath (inpColl, par, child);
        len = strlen (targetDir) - strlen (child);
        if (len > 0) {
            tmpptr = targetDir + len;
	    if (*(tmpptr - 1) == '/' && strcmp (tmpptr, child) == 0) {
	        strcpy (localRootDir, targetDir);
	    } else {
	        sprintf (localRootDir, "%s/%s", targetDir, child);
	    }
        } else if (len == 0) {
	    if (strcmp (targetDir, child) == 0) {
                strcpy (localRootDir, targetDir);
            } else {
                sprintf (localRootDir, "%s/%s", targetDir, child);
            }
        } else {
	    sprintf (localRootDir, "%s/%s", targetDir, child);
        }
    }
#endif

    buf = malloc (BL_BUFSIZE);
    if (buf == NULL) {
        fprintf (stderr, "unfoldBulkUnload: Unable to malloc buf\n");
        close (local_fd);
        close (srb_fd);
        return (CLI_ERR_MALLOC);
    }

    while (continuation_index >= 0) {
        collection = (char *) getFromResultStruct(
         (mdasC_sql_result_struct *) myresult,
            dcs_tname[DATA_GRP_NAME], dcs_aname[DATA_GRP_NAME]);

        objID = (char *)getFromResultStruct(
        (mdasC_sql_result_struct *) myresult, dcs_tname[DATA_NAME],
            dcs_aname[DATA_NAME]);
        strSize = (char *) getFromResultStruct(
        (mdasC_sql_result_struct *) myresult,
            dcs_tname[SIZE], dcs_aname[SIZE]);

        strOffset = (char *) getFromResultStruct(
        (mdasC_sql_result_struct *) myresult,
            dcs_tname[OFFSET], dcs_aname[OFFSET]);

        strChksum = (char *) getFromResultStruct(
        (mdasC_sql_result_struct *) myresult,
            dcs_tname[DATA_CHECKSUM], dcs_aname[DATA_CHECKSUM]);

        inx = 0;
	curOffset = 0;
        sprintf (srbPath, "%s/%s", &collection[inx*MAX_DATA_SIZE], 
         &objID[inx*MAX_DATA_SIZE]);
        local_fd = openAndProcLocalPath (srbPath, localRootDir, inpColl, 
	 localPath); 
        if (local_fd < 0) {
	    close (srb_fd);
            return (local_fd);
        }
        offset = strtoll (&strOffset[inx*MAX_DATA_SIZE], 0, 0);
        size = strtoll (&strSize[inx*MAX_DATA_SIZE], 0, 0);

        status = 0;
	totalSz = getTotalSzByResult (myresult);

        while (1) {
	    char *bufptr;

            if (status < 0)
                break;

            if (totalSz >= BL_BUFSIZE) {
                toRead = BL_BUFSIZE;
            } else {
                toRead = totalSz;
            }

	    if (toRead > 0) {
                cnt =  readDataFromPortal (srb_fd, buf, BL_BUFSIZE);
		if (cnt <= 0) 
		    break;
	    } else {
		cnt = 0;
	    }

	    totalSz -= cnt;

	    bufptr = buf;
	    while (cnt > 0 || totalSz == 0) {
	        if (cnt >= size) {
		    if (size > 0) {
	                status = write (local_fd, bufptr, size);
	                if (status < size) {
                            fprintf(stderr,
                             "unfoldBulkUnload: Read %lld bytes, Wrote %d bytes.\n ",
                             size, status);
		            status = -1;
		            break;
	                }
		        cnt -= size;
		        curOffset += size;
		        bufptr += size;
		    }
		    close (local_fd);

		    /* do chksum */
		    if (flagval & k_FLAG) {     /* chksum */
		        unsigned long ulCheckSum, ulChecksumFromSrb;

                        ulChecksumFromSrb =
                          (unsigned long) strtol (&strChksum[inx*MAX_DATA_SIZE],
                          (char **) NULL, 10);

                        if (ulChecksumFromSrb == 0) {
                            fprintf (stderr,
                             "unfoldBulkUnload, %s has no checksum.\n",
                              srbPath);
		        } else {
		            if (clFileSum (localPath, &ulCheckSum) < 0) {
            	                fprintf (stderr,
             	                 "unfoldBulkUnload: clFileSum failed for %s\n", 
		                 srbPath);
			        status = -1;
			        break;
        	            }
                            if (ulCheckSum != ulChecksumFromSrb) {
                                fprintf (stderr,
                                  "unfoldBulkUnload, local file checksum (%ld) differs from SRB stored checksum (%ld)\n", ulCheckSum, ulChecksumFromSrb);
			        status = OBJ_ERR_BAD_CHKSUM;
			        break;
			    }
		        }
                    }

                    inx ++;
		    if (inx >= myresult->row_count)
		        break;
                    sprintf (srbPath, "%s/%s", &collection[inx*MAX_DATA_SIZE], 
                     &objID[inx*MAX_DATA_SIZE]);
                    local_fd = openAndProcLocalPath (srbPath, localRootDir, 
		     inpColl, localPath);
                    if (local_fd < 0) {
                        status = local_fd;
		        break;
                    }
    		    offset = strtoll (&strOffset[inx*MAX_DATA_SIZE], 0, 0);
    		    size = strtoll (&strSize[inx*MAX_DATA_SIZE], 0, 0);

		    if (offset != curOffset) {
		        /* something is wrong */
                        fprintf(stderr,
                         "unfoldBulkUnload: offset mismatch at %s, %lld:%lld\n ",
                         srbPath, offset, curOffset);
		        status = -1;
		        break;
		    }
	        } else {	/* cnt < size */
                    status = write (local_fd, bufptr, cnt);
                    if (status < cnt) {
                        fprintf(stderr,
                         "unfoldBulkUnload: Read %d bytes, Wrote %d bytes.\n ",
                         cnt, status);
                        status = -1;
                        break;
                    }
		    size -= cnt;
                    curOffset += cnt;
		    cnt = 0;
	        }
            }
	    if (inx >= myresult->row_count)
		break;
        }
        if (inx < myresult->row_count) {
	    fprintf(stderr,
             "unfoldBulkUnload: Need to unload %d files but done only %d\n ",
	     myresult->row_count, inx);
	    status = -1;
	    break;
        } else { 
	    status = 0;
        }
	continuation_index = myresult->continuation_index;
	freeSqlResult (myresult);
	
	if (continuation_index >= 0) {
	    status = getResultForBunload (srb_fd, &myresult);
	    if (status < 0) {
		if (status != MCAT_INQUIRE_ERROR) {
                  fprintf(stderr,
                 "unfoldBulkUnload: getResultForBunload error. ststus = %d\n ",
                  status);
		} else {
		    status = 0;
		}
		break;
	    }
	} else {
	    break;
	}
    }

    free (buf);
    close (srb_fd);
    return (status);
}

#ifdef foo      /* moved to clMisc.c */
int
readDataFromPortal (int srb_fd, char *buf, int maxLen)
{
    int status;
    int toread, nbytes;
    struct relayHeader myHeader;
    char *bufptr;

    status = readHeader (srb_fd, &myHeader);
    if (status < 0) {
#ifdef _WIN32
        closesocket(srb_fd);
#else
        close (srb_fd);
#endif
        return (status);
    }

    if (myHeader.operation == DONE_OPR)
	return (0);

    toread = myHeader.length;

    if (toread > maxLen) {
	fprintf (stderr,
	 "readDataFromPortal: len from header %d is large than buf size %d\n",
	 toread, maxLen);
	return -1;
    } 

    bufptr = buf;
    do {
#ifdef _WIN32
        nbytes = recv(srb_fd, bufptr, toread, 0);
#else
        nbytes = read (srb_fd, bufptr, toread);
#endif
        if (nbytes > 0) {
            toread -= nbytes;
            bufptr += nbytes;
        }
    } while (toread > 0 && nbytes > 0);

    if (toread != 0)
	return -1;
    return (myHeader.length);
}
#endif	/* foo */

int 
getContainerByColl (srbConn *conn, srbPathName collNameArray[], 
srbPathName **outNameArray)
{

        mdasC_sql_result_struct myresult;
        char *prevCont;
        int inx;
	int status;
        char *container;
	srbPathName *nameArray;
        char tmpPrevCont[MAX_TOKEN];

	nameArray = malloc (MAX_NUM_CONT * sizeof (srbPathName));
	*outNameArray = nameArray;
	if (nameArray == NULL) {
            fprintf (stderr, "getContainerByColl: Unable to malloc nameArray\n");
            return (CLI_ERR_MALLOC);
        }

        /* no input - try to find it from the input collection */
        status = queryContainerByColl (conn, collNameArray[0].outArgv,
         &myresult);
        if (status < 0) {
#ifdef foo
            fprintf (stderr, 
             "The input collection contains no in-container file\n",
             collNameArray[0].outArgv);
#endif
	    free (nameArray);
            return (0);
        }
        container = (char *) getFromResultStruct(
                           (mdasC_sql_result_struct *) &myresult,
                           dcs_tname[CONTAINER_NAME],
                           dcs_aname[CONTAINER_NAME]);

        inx = 0;
        prevCont = NULL;
        for (i = 0; i < myresult.row_count; i++) {
            if (prevCont == NULL || strcmp (container, prevCont) != 0) {
                nameArray[inx].outArgv = strdup (container);
                inx++;
		if (inx > MAX_NUM_CONT) {
		    fprintf (stderr,
		     "The number of cont is larger than MAX value of %d\n",
		      MAX_NUM_CONT);
		    free (nameArray);
		    return (-1);
		}
            }
            prevCont = container;
            container += MAX_DATA_SIZE;
        }
        while (myresult.continuation_index >= 0) {
            strncpy (tmpPrevCont, prevCont, MAX_TOKEN -1);
            prevCont = tmpPrevCont;
            clearSqlResult (&myresult);
            status = srbGetMoreRows(conn, MDAS_CATALOG,
              myresult.continuation_index, &myresult, MAX_GET_RESULTS);
            if (status < 0)
                break;
            container = (char *) getFromResultStruct(
                           (mdasC_sql_result_struct *) &myresult,
                           dcs_tname[CONTAINER_NAME],
                           dcs_aname[CONTAINER_NAME]);
            for (i = 0; i < myresult.row_count; i++) {
                if (prevCont == NULL || strcmp (container, prevCont) != 0) {
                    nameArray[inx].inpArgv = strdup (container);
                    nameArray[inx].outArgv = strdup (container);
                    inx++;
                    if (inx > MAX_NUM_CONT) {
                        fprintf (stderr,
                         "The number of cont is larger than MAX value of %d\n",
                          MAX_NUM_CONT);
                        free (nameArray);
                        return (-1);
                    }
                }
                prevCont = container;
                container += MAX_DATA_SIZE;
            }
        }
        if (status >= 0)
            clearSqlResult (&myresult);

	return (inx);
}

srb_long_t
getTotalSzByResult (mdasC_sql_result_struct *myresult)
{
    char *strSize;
    srb_long_t size = 0;
    int i;

    if (myresult == NULL)
	return 0;

    strSize = (char *) getFromResultStruct(
    (mdasC_sql_result_struct *) myresult,
        dcs_tname[SIZE], dcs_aname[SIZE]);

    for (i = 0; i < myresult->row_count; i++) {
	size += strtoll (&strSize[i*MAX_DATA_SIZE], 0, 0);
    }

    return (size);
}
    
int
queryAndUnfoldCont (srbConn *conn, char *container, char *targetDir,
char *srcCollection)
{
    mdasC_sql_result_struct inresult;
    int status;
    int continuation_index = 1;
    int contInx;
    char *inCollection, *inObjID, *inSize, *inChksum, *inPath, *inDataType,
      *inOffset;
    srb_long_t offset, size;
    char *buf, *bufptr;
    srb_long_t tmpOffset, curOffset = 0, diffOffset;
    int local_fd;
    int cnt = 0;
    int toWrite = 0;


    status = clGenIncontListInColl (conn, MDAS_CATALOG, srcCollection, 
     container, &inresult);

    if (status < 0) {
        if (status == MCAT_INQUIRE_ERROR)
            return (0);
        else
            return (status);
    }

    contInx = srbContainerOpen (conn, MDAS_CATALOG, container, O_RDONLY);
    if (contInx < 0) {
	fprintf (stderr,
         "queryAndUnfoldCont:srbContainerOpen error for %s,status=%d\n",
          container, contInx);
        clearSqlResult (&inresult);
        return (contInx);
    }

    buf = malloc (BL_BUFSIZE);
    bufptr = buf;

    while (continuation_index >= 0) {
        inDataType = (char *) getFromResultStruct(
         (mdasC_sql_result_struct *) &inresult,
            dcs_tname[DATA_TYP_NAME], dcs_aname[DATA_TYP_NAME]);
        inCollection = (char *) getFromResultStruct(
         (mdasC_sql_result_struct *) &inresult,
            dcs_tname[DATA_GRP_NAME], dcs_aname[DATA_GRP_NAME]);
        inObjID = (char *)getFromResultStruct(
        (mdasC_sql_result_struct *) &inresult, dcs_tname[DATA_NAME],
            dcs_aname[DATA_NAME]);
        inSize = (char *) getFromResultStruct(
        (mdasC_sql_result_struct *) &inresult,
            dcs_tname[SIZE], dcs_aname[SIZE]);
        inOffset = (char *) getFromResultStruct(
        (mdasC_sql_result_struct *) &inresult,
            dcs_tname[OFFSET], dcs_aname[OFFSET]);
        inChksum = (char *) getFromResultStruct(
        (mdasC_sql_result_struct *) &inresult,
            dcs_tname[DATA_CHECKSUM], dcs_aname[DATA_CHECKSUM]);

        for (i = 0; i < inresult.row_count; i++) {
	    char srbPath[MAX_TOKEN];
	    char localPath[MAX_TOKEN * 2];

            offset = strtoll (&inOffset[i*MAX_DATA_SIZE], 0, 0);
            size = strtoll (&inSize[i*MAX_DATA_SIZE], 0, 0);

	    sprintf (srbPath, "%s/%s",  &inCollection[i*MAX_DATA_SIZE],
              &inObjID[i*MAX_DATA_SIZE]);

            local_fd = openAndProcLocalPath (srbPath, targetDir,
	      srcCollection, localPath);

            if (local_fd < 0) {
		fprintf (stderr,
                 "queryAndUnfoldCont: openAndProcLocalPath of %s failed, status = %d\n",
                  srbPath, local_fd);
                status = local_fd;
                break;
            }

            while (size > 0) {
                diffOffset = offset - curOffset;
                if (diffOffset < 0 || (diffOffset > 0 && diffOffset >= cnt)) {
                    tmpOffset = srbObjSeek (conn, contInx, offset, SEEK_SET);
                    if (tmpOffset< 0) {
                        status = tmpOffset;
		        fprintf (stderr,
                          "queryAndUnfoldCont: ObjSeek of %s %lld err.status=%d\n",
                          container, offset, status);
                        close (local_fd);
                        break;
                    }
		    bufptr = buf;
                    curOffset = offset;
                    cnt = 0;
                } else {
                    curOffset = offset;
                    bufptr += diffOffset;
                    cnt -= diffOffset;
                }
                if (cnt <= 0) {
                    cnt = srbObjRead (conn, contInx, buf, BL_BUFSIZE);
                    if (cnt <= 0) {
		        fprintf (stderr,
                          "queryAndUnfoldCont:srbObjRead of %s error. remaining size is %lld. status=%d\n",
                          container, size, cnt);
                        close (local_fd);
                        if (cnt < 0) {
                            status = cnt;
                        } else {
                            status = OBJ_ERR_COPY_LEN;
                        }
                        break;
                    }
                    bufptr = buf;
                }
                if (cnt >= size) {
                    toWrite = size;
                } else {
                    toWrite = cnt;
                }
                status = write (local_fd, bufptr, toWrite);
                if (status < toWrite) {
		    fprintf (stderr,
                     "queryAndUnfoldCont: %s To write %lld, Wrote %d bytes.\n",
                     container, toWrite, status);
                    close (local_fd);
                    status = OBJ_ERR_COPY_LEN;
                    break;
                }
                cnt -= toWrite;
                curOffset += toWrite;
                offset += toWrite;
                bufptr += toWrite;
                size -= toWrite;
            }   /* while size loop */
            close (local_fd);
            if (status < 0)
                break;
        }       /* for loop */
        if (status < 0) {
            srbContainerClose (conn, contInx);
            free (buf);
            return (status);
        }
        continuation_index = inresult.continuation_index;
        clearSqlResult (&inresult);
        if (continuation_index >= 0) {
            status = srbGetMoreRows (conn, MDAS_CATALOG, continuation_index,
	      &inresult, MAX_GET_RESULTS);

            if (status < 0) {
                if (status == MCAT_INQUIRE_ERROR) {
                    status = 0;
                } else {
		    fprintf (stderr,
                     "queryAndUnfoldCont: srbGetMoreRows error. status = %d",
                      status);
                }
                break;
            }
        } else {
            break;
        }
    }
    srbContainerClose (conn, contInx);
    free (buf);
    return (status);
}

int
clGenIncontListInColl (srbConn *conn, int catType, char *collection,
char *container, mdasC_sql_result_struct *myresult)
{
    int i, status;
    char qval[MAX_DCS_NUM][MAX_TOKEN];
    int  selval[MAX_DCS_NUM];

    memset (qval, 0, sizeof (qval));
    memset (selval, 0, sizeof (selval));

    selval[DATA_NAME] = 1;
    selval[DATA_GRP_NAME] = 1;
    selval[DATA_TYP_NAME] = 1;
    selval[SIZE] = 1;
    selval[OFFSET] = 1;
    selval[DATA_CHECKSUM] = 1;
    sprintf(qval[DATA_ID] ," <> %s%s",
     MDASSCHEMENAME,"MDAS_AD_REPL.container_id");
    sprintf (qval[CONTAINER_NAME], " = '%s'", container);

    sprintf (qval[DATA_GRP_NAME],
     " like '%s' ESCAPE '\\' || like '%s/%%' ESCAPE '\\'",
            collection, collection);

    status = srbGetDataDirInfo(conn, MDAS_CATALOG, qval, selval,
                                      myresult, MAX_GET_RESULTS );

    return (status);
}

