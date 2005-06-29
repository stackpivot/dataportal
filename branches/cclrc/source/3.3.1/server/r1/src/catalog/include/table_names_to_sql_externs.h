/**************************************************************************
Copyright Notice
All Rights Reserved
Please refer to files in COPYRIGHT directory under the SRB software directory 
for copyright, usage, liability and license information.
Please read these files before using,modifying or distributing SRB software.
**************************************************************************/

/****************************************************************************
** Source File Name = table_names_to_sql_externs.h
**
** Copyright (c) 1996
**   General Atomics (GA) and San Diego Supercomputer Center (SDSC)
**   San Diego, California, USA
**
** PURPOSE: 
**     Contains definitions for callable functions in
**     table_names_to_sql.c
****************************************************************************/
/***************************************************************************
  NAME   : initialize_graph
  PURPOSE: Initialize the mdas metadata graph structure from a file that
           contains the foreign key relationships among tables
  INPUT  :  file_name  - file name containing the foreign key relationship
            data for metadata schema
  OUTPUT : (none)
  RETURN :  0 for SUCESS  and  negatives for error
****************************************************************************/
 
#ifndef TABLE_TO_SQL_EXTERNS_H
#define TABLE_TO_SQL_EXTERNS_H

int initialize_graph(char *file_name);

/***************************************************************************
  NAME   : initialize_flags_in_graph
  PURPOSE: Initialize the flags in the mdas metadata graph structure.
           Called by convert_to_sql() before processing input
  INPUT  : (none)
  OUTPUT : (none)
  RETURN : (none)
****************************************************************************/

void initialize_flags_in_graph();

/***************************************************************************
  NAME   : print_graph
  PURPOSE: Print the  mdas metadata graph into given file descriptor.
  INPUT  : fd  - file descriptor for printing the graph
  OUTPUT : (none)
  RETURN : (none)
****************************************************************************/

void print_graph(FILE *fd);

/***************************************************************************
  NAME   : print_sql
  PURPOSE: Print the recent SQL query string generated
  INPUT  :  fd  - file descriptor for printing the SQL query
  OUTPUT : (none)
  RETURN : (none)
****************************************************************************/

int print_sql(FILE *fd);


/***************************************************************************
  NAME   : make_sql
  PURPOSE: Convert the path found by convert_to_sql() into ANSI SQL query
  INPUT  :  qs               - pointer to string that returns the SQL
                               query built by the call
            other_conditions - pointer to string that contains other WHERE
	                       conditions apart from those generated by
			       the routines in this file. If no other 
			       conditions are there use NULL or ""
	    select_clause    - pointer to string that contains SELECT
	                       conditions explicitly. If no other 
			       conditions are there use NULL or "". In this
			       case '*' is used in the select clause.
  OUTPUT :  qs                - is assigned the SQL query.
  RETURN : (none)
****************************************************************************/

void make_sql(char *qs, char *other_conditions, char *select_clause);

/***************************************************************************
  NAME   : find_steiner_tree_in_graph
  PURPOSE: Find a steiner path that connects a given node (table_name) in
           the metadata graph structure to other nodes already known.
	   This forms a steiner tree in steps. Called by convert_to_sql()
  INPUT  :  key - table-name that has to form a node in the steiner tree
                 being built. 
  OUTPUT : (none) marks the metadata graph structure with steiner nodes.
  RETURN : 1 for successfully finding a path and 0 for not finding a path
           to other already known nodes in the steiner tree.
****************************************************************************/

int find_steiner_tree_in_graph(char *key);

/***************************************************************************
  NAME   : transfer_in_nodes_to_out
  PURPOSE: Marks any steiner nodes found in previous path by
           find_steiner_tree_in_graph() if they belong to input set.
	   Called by convert_to_sql()
  INPUT  :  k  -  the output list sequence number to search for existence
                 of input nodes.
  OUTPUT : (none) 
  RETURN : (none)
****************************************************************************/

void transfer_in_nodes_to_out(int k);

/***************************************************************************
  NAME   : convert_to_sql
  PURPOSE: Converts a list of table names into an ANSI SQL query
  INPUT  :  count             - number of elements in the table_names list.
            table_names[][100] - list of table_names that are to be 
	                        connected by a steiner tree in the 
				metadata graph and converted into ANSI
				SQL query                                
            other_conditions  - pointer to string that contains other WHERE
	                        conditions apart from those generated by
			        the routines in this file. If no other 
			        conditions are there use NULL or ""
	    select_clause     - pointer to string that contains SELECT
	                        conditions explicitly. If no other 
			        conditions are there use NULL or "". In this
			        case '*' is used in the select clause.
            query_string      - pointer to string that returns the SQL
                                query built by the call
  OUTPUT :  query_string      - is assigned the SQL query.
  RETURN : (none)
****************************************************************************/

void convert_to_sql(int count, char table_names[][MAX_TOKEN], 
char *other_conditions, char *select_clause, char *query_string);

#endif	/* TABLE_TO_SQL_EXTERNS_H */
