package uk.ac.cclrc.xmlwrapper ;

import java.sql.* ;

interface CsmdMapper
{
   String getKeys(String query) ;

   void buildMetadataRecord(String key, StringBuffer result) throws SQLException ;

}
