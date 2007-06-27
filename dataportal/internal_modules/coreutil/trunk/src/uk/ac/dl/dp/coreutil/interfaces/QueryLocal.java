
package uk.ac.dl.dp.coreutil.interfaces;

import java.util.Collection;
import java.util.HashMap;
import javax.ejb.Local;
import uk.ac.dl.dp.coreutil.clients.dto.QueryRecordDTO;
import uk.ac.dl.dp.coreutil.exceptions.QueryException;
import uk.ac.dl.dp.coreutil.util.QueryRequest;
import uk.ac.dl.dp.coreutil.exceptions.SessionException;
import uk.ac.dl.dp.coreutil.util.KeywordQueryRequest;
import uk.ac.dp.icatws.Investigation;

/**
 * This is the business interface for QuerySlaveMaster enterprise bean.
 */
@Local
public interface QueryLocal {
     public QueryRequest queryKeyword(String sid, KeywordQueryRequest kqr) throws QueryException, SessionException;
    
     public QueryRequest queryMydata(String sid, Collection<String> facilities) throws SessionException, QueryException;
  
    public boolean isFinished(QueryRequest request);
    
    public Collection<Investigation> getQueryResults(String sid, String queryId);
    
    public Collection<Investigation> getQueryResults(QueryRequest request);
    
    public Collection<String> getCompleted(QueryRequest request);
          
    public Investigation getInvestigationById(String sid, String facility, String investigationId) throws SessionException,QueryException;
       
    public Collection<QueryRecordDTO> getCurrentResults(String sid);
    
    public Collection<Investigation> getPastQueryResults(String sid, String queryid);
    
    public Collection<Investigation> getPastQueryResults(String sid, QueryRecordDTO dto);
    
    public HashMap<String, Collection<String>> getKeywords(String sid, boolean redownload) throws QueryException ;
  
}
