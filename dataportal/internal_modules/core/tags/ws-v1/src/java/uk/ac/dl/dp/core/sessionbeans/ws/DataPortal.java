/*
 * DataPortal.java
 *
 * Created on 11 June 2007, 15:43
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package uk.ac.dl.dp.core.sessionbeans.ws;


import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.apache.log4j.Logger;
import uk.ac.cclrc.dpal.beans.DataFile;
import uk.ac.cclrc.dpal.beans.DataSet;
import uk.ac.cclrc.dpal.beans.Investigation;
import uk.ac.cclrc.dpal.enums.LogicalOperator;
import uk.ac.dl.dp.core.sessionbeans.SessionEJBObject;
import uk.ac.dl.dp.coreutil.clients.dto.SessionDTO;
import uk.ac.dl.dp.coreutil.clients.dto.UserPreferencesDTO;
import uk.ac.dl.dp.coreutil.entity.Bookmark;
import uk.ac.dl.dp.coreutil.entity.DataReference;
import uk.ac.dl.dp.coreutil.exceptions.DataCenterException;
import uk.ac.dl.dp.coreutil.exceptions.LoginMyProxyException;
import uk.ac.dl.dp.coreutil.exceptions.QueryException;
import uk.ac.dl.dp.coreutil.exceptions.SessionException;
import uk.ac.dl.dp.coreutil.interfaces.DataCenterLocal;
import uk.ac.dl.dp.coreutil.interfaces.QueryLocal;
import uk.ac.dl.dp.coreutil.interfaces.SessionLocal;
import uk.ac.dl.dp.coreutil.util.DPQueryType;
import uk.ac.dl.dp.coreutil.util.QueryRequest;
import uk.ac.dl.dp.coreutil.util.SessionUtil;

/**
 *
 * @author gjd37
 */

@Stateless()
@WebService(/*targetNamespace="client.dataportal.uk"*/)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class DataPortal extends SessionEJBObject {
    
    static Logger log = Logger.getLogger(DataPortal.class);
    
    ///////////////////////  Inject all the EJBs   //////////////////////////
    @EJB
    protected SessionLocal sessionBeanLocal;
    
    @EJB
    protected QueryLocal queryLocal;
    
    @EJB
    protected DataCenterLocal dataCenterLocal;
    //////////////////////////////////////////////////////////////////////////
    
    @WebMethod()
    public String login(@WebParam(name="username") String username, @WebParam(name="password") String password, @WebParam(name="lifetime") int lifetime) throws SessionException, LoginMyProxyException  {
        try {
            return sessionBeanLocal.login(username, password, lifetime);
        } catch (LoginMyProxyException ex) {
            throw ex;
        } catch (SessionException ex) {
            throw new SessionException(ex.getMessage());
        }
    }
    
    @WebMethod()
    public boolean isValid(@WebParam(name="sessionId") String sessionId) throws SessionException  {
        try {
            return sessionBeanLocal.isValid(sessionId);
        } catch (SessionException ex) {
            throw new SessionException(ex.getMessage());
        }
        
    }
    
    @WebMethod()
    public SessionDTO getSession(@WebParam(name="sessionId") String sessionId) throws SessionException  {
        try {
            return sessionBeanLocal.getSession(sessionId);
        } catch (SessionException ex) {
            throw new SessionException(ex.getMessage());
        }
    }
    
    @WebMethod()
    public boolean logout(@WebParam(name="sessionId") String sessionId) throws SessionException{
        try {
            return sessionBeanLocal.logout(sessionId);
        } catch (SessionException ex) {
            throw new SessionException(ex.getMessage());
        }
    }
    
    @WebMethod()
    public String[] getKeywords(@WebParam(name="sessionId") String sessionId, @WebParam(name="facility") String facility) throws QueryException , SessionException {
        try {
            //check session
            new SessionUtil(sessionId, em);
            return queryLocal.getKeywords(facility);
        } catch (QueryException ex) {
            throw ex;
        } catch (SessionException ex) {
            throw new SessionException(ex.getMessage());
        }
    }
    
    @WebMethod()
    public QueryRequest query(@WebParam(name="sessionId") String sessionId, @WebParam(name="facilities")  Collection<String> facilities, @WebParam(name="keywords") String[] keywords, @WebParam(name="logicaloperator") LogicalOperator logicaloperator, @WebParam(name="fuzzy") boolean fuzzy) throws QueryException, SessionException {
        try {
            return queryLocal.query(sessionId, facilities, keywords, logicaloperator, fuzzy, DPQueryType.KEYWORD);
        } catch (QueryException ex) {
            throw ex;
        } catch (SessionException ex) {
            throw new SessionException(ex.getMessage());
        }
    }
    
    @WebMethod()
    public Collection<Investigation> queryAndWait(@WebParam(name="sessionId") String sessionId, @WebParam(name="facilities") Collection<String> facilities, @WebParam(name="keywords") String[] keywords, @WebParam(name="logicaloperator") LogicalOperator logicaloperator, @WebParam(name="fuzzy") boolean fuzzy) throws QueryException, SessionException {
        try {
            QueryRequest request = queryLocal.query(sessionId, facilities, keywords, logicaloperator, fuzzy, DPQueryType.KEYWORD);
            
            while(!queryLocal.isFinished(request)){
                try {
                    Thread.sleep(1000); //sleep one second
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } //sleep one second
            }
            
            return queryLocal.getQueryResults(request);
        } catch (QueryException ex) {
            throw ex;
        } catch (SessionException ex) {
            throw new SessionException(ex.getMessage());
        }
    }
    
    @WebMethod()
    public boolean isFinished(@WebParam(name="username") QueryRequest q_request){
        return queryLocal.isFinished(q_request);
    }
    
    @WebMethod()
    public Collection<DataSet> getDataSets(@WebParam(name="sessionId") String sessionId, @WebParam(name="investigations") Collection<Investigation> investigations) throws SessionException, QueryException {
        try {
            return queryLocal.getDataSets(sessionId, investigations);
        } catch (QueryException ex) {
            throw ex;
        } catch (SessionException ex) {
            throw new SessionException(ex.getMessage());
        }
    }
    
    @WebMethod()
    public Collection<DataFile> getDataFiles(@WebParam(name="sessionId") String sessionId, @WebParam(name="datasets") Collection<DataSet> datasets) throws SessionException, QueryException {
        try {
            return queryLocal.getDataFiles(sessionId, datasets);
        } catch (QueryException ex) {
            throw ex;
        } catch (SessionException ex) {
            throw new SessionException(ex.getMessage());
        }
    }
    
    @WebMethod()
    public Collection<Investigation> getQueryResults(@WebParam(name="q_request") QueryRequest q_request){
        return queryLocal.getQueryResults(q_request);
    }
    
    @WebMethod()
    public Collection<Investigation> getQueryResultsPagination(@WebParam(name="q_request") QueryRequest q_request,@WebParam(name="startIndex") int startIndex, @WebParam(name="numberResults") int numberResults){
        Collection<Investigation> investigations = queryLocal.getQueryResults(q_request);
        
        Collection<Investigation> investigationsToReturn = new ArrayList<Investigation>();
        Investigation[] array = investigations.toArray(new Investigation[investigations.size()]);
        for (int i = startIndex; i < startIndex+numberResults; i++) {
            if(i >= investigations.size()) break;
            investigationsToReturn.add(array[i]);
        }
        
        return investigationsToReturn;
    }
    
    @WebMethod()
    public Collection<DataReference> getDataReferences(@WebParam(name="sessionId") String sessionId) throws DataCenterException, SessionException{
        try {
            return dataCenterLocal.getDataReferences(sessionId);
        } catch (SessionException ex) {
            throw new SessionException(ex.getMessage());
        }
    }
    
    @WebMethod()
    public Collection<Bookmark> getBookmarks(@WebParam(name="sessionId") String sessionId) throws SessionException{
        try {
            return dataCenterLocal.getBookmarks(sessionId);
        } catch (SessionException ex) {
            throw new SessionException(ex.getMessage());
        }
    }
    
    @WebMethod()
    public void removeBookmark(@WebParam(name="sessionId") String sessionId, @WebParam(name="bookmark") Bookmark bookmark) throws DataCenterException, SessionException{
        try {
            dataCenterLocal.removeBookmark(sessionId, bookmark);
        } catch (DataCenterException ex) {
            throw ex;
        } catch (SessionException ex) {
            throw new SessionException(ex.getMessage());
        }
    }
    
    @WebMethod()
    public void removeDataReference(@WebParam(name="sessionId") String sessionId, @WebParam(name="dataReference") DataReference dataReference) throws DataCenterException, SessionException{
        try {
            dataCenterLocal.removeDataReference(sessionId, dataReference);
        } catch (DataCenterException ex) {
            throw ex;
        } catch (SessionException ex) {
            throw new SessionException(ex.getMessage());
        }
    }
    
    @WebMethod()
    public void modifyDataReference(@WebParam(name="sessionId") String sessionId, @WebParam(name="dataReference") DataReference dataReference) throws DataCenterException, SessionException{
        try {
            dataCenterLocal.modifyDataReference(sessionId, dataReference);
        } catch (DataCenterException ex) {
            throw ex;
        } catch (SessionException ex) {
            throw new SessionException(ex.getMessage());
        }
    }
    
    @WebMethod()
    public void modifyBookmark(@WebParam(name="sessionId") String sessionId, @WebParam(name="bookmark") Bookmark bookmark) throws DataCenterException, SessionException{
        try {
            dataCenterLocal.modifyBookmark(sessionId, bookmark);
        } catch (DataCenterException ex) {
            throw ex;
        } catch (SessionException ex) {
            throw new SessionException(ex.getMessage());
        }
    }
    
    @WebMethod()
    public void addDataReference(@WebParam(name="sessionId") String sessionId, @WebParam(name="dataReference") DataReference dataReference) throws DataCenterException, SessionException{
        try {
            dataCenterLocal.addDataReference(sessionId, dataReference);
        } catch (DataCenterException ex) {
            throw ex;
        } catch (SessionException ex) {
            throw new SessionException(ex.getMessage());
        }
    }
    
    @WebMethod()
    public void addBookmark(@WebParam(name="sessionId") String sessionId, @WebParam(name="bookmark") Bookmark bookmark) throws DataCenterException, SessionException{
        try {
            dataCenterLocal.addBookmark(sessionId, bookmark);
        } catch (DataCenterException ex) {
            throw ex;
        } catch (SessionException ex) {
            throw new SessionException(ex.getMessage());
        }
    }
    
    @WebMethod()
    public UserPreferencesDTO getUserPreferences(@WebParam(name="sessionId") String sessionId) throws SessionException{
        try {
            return sessionBeanLocal.getUserPrefs(sessionId);
        }catch (SessionException ex) {
            throw new SessionException(ex.getMessage());
        }
    }
    
    @WebMethod()
    public void setUserPreferences(@WebParam(name="sessionId") String sessionId, @WebParam(name="userPreferencesDTO") UserPreferencesDTO userPreferencesDTO) throws SessionException{
        try {
            sessionBeanLocal.setUserPrefs(sessionId, userPreferencesDTO);
        }catch (SessionException ex) {
            throw new SessionException(ex.getMessage());
        }
    }
}
