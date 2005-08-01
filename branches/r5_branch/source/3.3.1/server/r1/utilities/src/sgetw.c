/**************************************************************************
Copyright Notice
All Rights Reserved
Please refer to files in COPYRIGHT directory under the SRB software directory 
for copyright, usage, liability and license information.
Please read these files before using,modifying or distributing SRB software.
**************************************************************************/
 


#include <stdio.h>
#include <sys/file.h>
#include <sys/stat.h>
#include "srbClient.h"
#include "srb_client_errno.h"
 
 
#ifdef PORTNAME_c90
#include <sys/fcntl.h>  /* For C-90 - define O_RDONLY */
#endif

  
#define LF 10
#define CR 13

#define srbAuth         "NOBODY"
#define HOSTADDR       "mda-18"


#define MAX_ENTRIES 10000
 
typedef struct {
   char name[MAX_TOKEN];
   char val[HUGE_STRING];
} entry;
 
entry entries[MAX_ENTRIES];


  char qval[MAX_DCS_NUM][MAX_TOKEN], cfile[300];
  char *rval[MAX_DCS_NUM];
  int i, j, alive;

  char stquery[2048];
   srbConn *conn;
    int  nbytes,  in_fd, out_fd;
    char buf[BUFSIZE];
    char user[MAX_TOKEN];
    char passwd[MAX_TOKEN];
    char domain[MAX_TOKEN];
    char hostname[MAX_TOKEN];
    char tempstr[MAX_TOKEN], tempstr2[MAX_TOKEN];
  int selval[MAX_DCS_NUM];

/************************************************************************/
 

 int
  mybgets(char inbuf[], char buffer[], int j)
  {
    char ch;
    int i = 0;
    ch = inbuf[j];
    j++;
    if (ch == '\0')
      {
	return -1;
      }
    while (ch != '\n')
      {
	buffer[i] = ch;
	++i;
	ch = inbuf[j];
	j++;
    if (ch == '\0')
      {
	return -1;
      }
     }
     buffer[i] = '\0';
     return j;
 }


 char 
 myfgets(FILE *infile, char buffer[])
 {
   char ch;
   int i = 0;
   ch = getc(infile);
   if (ch == EOF)
     {
       return ch;
     }
   while (ch != '\n')
     {
       buffer[i] = ch;
       ++i;
       ch = getc(infile);
     }
     buffer[i] = '\0';

     return '1';
 }


		       



 void getword(char *word, char *line, char stop) {
     int x = 0,y;

     for(x=0;((line[x]) && (line[x] != stop));x++)
	 word[x] = line[x];

     word[x] = '\0';
     if(line[x]) ++x;
     y=0;

     while(line[y++] = line[x++]);
 }

 char *makeword(char *line, char stop) {
     int x = 0,y;
     char *word = (char *) malloc(sizeof(char) * (strlen(line) + 1));

     for(x=0;((line[x]) && (line[x] != stop));x++)
	 word[x] = line[x];

     word[x] = '\0';
     if(line[x]) ++x;
     y=0;

     while(line[y++] = line[x++]);
     return word;
 }

 char *fmakeword(FILE *f, char stop, int *cl) {
     int wsize;
     char *word;
     int ll;

     wsize = 102400;
     ll=0;
     word = (char *) malloc(sizeof(char) * (wsize + 1));

     while(1) {
	 word[ll] = (char)fgetc(f); printf("%c",word[ll]);
	 if(ll==wsize) {
	     word[ll+1] = '\0';
	     wsize+=102400;
	     word = (char *)realloc(word,sizeof(char)*(wsize+1));
	 }
	 --(*cl);
	 if((word[ll] == stop) || (feof(f)) || (!(*cl))) {
	     if(word[ll] != stop) ll++;
	     word[ll] = '\0';
	     return word;
	 }
	 ++ll;
     }
 }

 char x2c(char *what) {
     register char digit;

     digit = (what[0] >= 'A' ? ((what[0] & 0xdf) - 'A')+10 : (what[0] - '0'));
     digit *= 16;
     digit += (what[1] >= 'A' ? ((what[1] & 0xdf) - 'A')+10 : (what[1] - '0'));
     return(digit);
 }

 void unescape_url(char *url) {
     register int x,y;

     for(x=0,y=0;url[y];++x,++y) {
	 if((url[x] = url[y]) == '%') {
	     url[x] = x2c(&url[y+1]);
	     y+=2;
	 }
     }
     url[x] = '\0';
 }

 void plustospace(char *str) {
     register int x;

     for(x=0;str[x];x++) if(str[x] == '+') str[x] = ' ';
 }

 int rind(char *s, char c) {
     register int x;
     for(x=strlen(s) - 1;x != -1; x--)
	 if(s[x] == c) return x;
     return -1;
 }

 int getline(char *s, int n, FILE *f) {
     register int i=0;

     while(1) {
	 s[i] = (char)fgetc(f);

	 if(s[i] == CR)
	     s[i] = fgetc(f);

	 if((s[i] == 0x4) || (s[i] == LF) || (i == (n-1))) {
	     s[i] = '\0';
	     return (feof(f) ? 1 : 0);
	 }
	 ++i;
     }
 }

 void send_fd(FILE *f, FILE *fd)
 {
     int num_chars=0;
     char c;

     while (1) {
	 c = fgetc(f);
	 if(feof(f))
	     return;
	 fputc(c,fd);
     }
 }


int
main(int argc, char **argv)
{
    FILE* outfile_fd;


/*
    register int x,m=0;
    strcpy(stquery,getenv("QUERY_STRING"));
       for(x=0;  stquery[0] != '\0';x++) {
           m=x; 
           getword(entries[x].val,stquery,'&');
           plustospace(entries[x].val);
           unescape_url(entries[x].val);
           sprintf(entries[x].name, makeword(entries[x].val,'='));
       }
*/

/*for (x=0; x <=m; x++) printf("Entry[%i]=%s<BR>\n",x,entries[x].val);*/

/* entries[1].val = user name */
/* entries[2].val = domain name */
/* entries[3].val = password */
/* entries[4].val = source filename */
/* entries[5].val = target (SRB) filename */
/* entries[6].val = file data type */
/* entries[7].val = resource name */
/* entries[8].val = collection name in SRB */
 
    if ( argc < 3 ) {
        fprintf(stderr,"usage: %s hpss-sourcefile localfile \n", argv[0] );
        exit(1);
    }

/* HUH ? */
    strcpy(entries[1].name,"esadruser");         /* user name */

    strcpy(entries[1].val,"esadruser");         /* user name */
    strcpy(entries[2].val,"esa");               /* domain name */
    strcpy(entries[3].val,"ESADRUSER");         /* password */

    /*
     * These get specified on the command line
     */
    strcpy(entries[4].val, argv[1] );       /* source (SRB) filename */
    strcpy(entries[5].val, argv[2] );       /* target filename */

    strcpy(entries[6].val,"generic");       /* file data type */
    strcpy(entries[7].val,"hpss-sdsc");     /* resource name */
    strcpy(entries[8].val,"/home/esadruser.esa");   /* collection name in SRB */

    putenv("srbPort=5553");
    sprintf(tempstr,"srbUser=%s",entries[1].val);
    putenv(tempstr);
    sprintf(tempstr2,"mdasDomainName=%s",entries[2].val);
    putenv(tempstr2);
 
    /*
     * Open a connection to the SRB
     */
    conn = srbConnect (srbHost, NULL, srbAuth, 
     NULL, NULL, NULL, NULL);
    if (clStatus(conn) != CLI_CONNECTION_OK) {
        printf("Connection to SRB server failed.\n");
        printf("%s",clErrorMessage(conn));
	srb_perror (2, clStatus(conn), "", SRB_RCMD_ACTION|SRB_LONG_MSG);
	clFinish(conn); exit(3);
    }

    /*
     * Open the SRB object
     */
    in_fd = srbObjOpen (conn, entries[4].val, O_RDONLY, entries[8].val);
    if (in_fd < 0)  {   /* error */
        printf("Content-type: text/html%c%c",10,10);fflush(stdout);
        printf("<html>");
        printf("<body bgcolor=#AAFFFFFA>");
        printf("<H1> %s </H1><HR>",entries[4].val);fflush(stdout);
        printf("can't open obj \"%s\" in collection \"%s\": Error=%i \n",
	     entries[4].val, entries[8].val,in_fd);
	srb_perror (2, in_fd, "", SRB_RCMD_ACTION|SRB_LONG_MSG);
        clFinish(conn); exit(4);
    }

    /*
     * Open the named local file
     */
    outfile_fd =  fopen(entries[5].val,"w");
    if (outfile_fd == NULL)  {  /* error */   
        printf("Content-type: text/html%c%c",10,10);fflush(stdout);
        printf("<html>");
        printf("<body bgcolor=#AAFFFFFA>");
        printf("Can't open local file \"%s\"<BR>\n",entries[5].val);
        printf("Exiting <BR>\n");
        clFinish(conn); exit(5);
     }

    /*
     * Read and write until done
     */
     while ((nbytes = srbObjRead (conn, in_fd, buf, BUFSIZE)) > 0) {
        fwrite(buf,1,nbytes,outfile_fd);
        /*printf ("%-*.*s", nbytes,nbytes,buf);*/
     }

    srbObjClose (conn, in_fd);
    fclose( outfile_fd );
    if (nbytes < 0 && nbytes != EOF) {
	srb_perror (2, nbytes, "", SRB_RCMD_ACTION|SRB_LONG_MSG);
	clFinish(conn); exit(6);
    } else {
       clFinish(conn);
       exit(0);
    }
}

