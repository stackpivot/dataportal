/*
 * TimerService.java
 *
 * Created on 22 June 2006, 16:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package uk.ac.dl.dp.core.sessionbeans.session;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.ejb.EJB;
import javax.ejb.TimerService;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.apache.log4j.*;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

import uk.ac.dl.dp.core.sessionbeans.SessionEJBObject;
import uk.ac.dl.dp.coreutil.entity.ModuleLookup;

import uk.ac.dl.dp.coreutil.exceptions.DataPortalException;
import uk.ac.dl.dp.coreutil.interfaces.LookupLocal;
import uk.ac.dl.dp.coreutil.interfaces.TimerServiceLocal;
import uk.ac.dl.dp.coreutil.interfaces.TimerServiceRemote;
import uk.ac.dl.dp.core.message.query.QueryManager;
import uk.ac.dl.dp.coreutil.entity.Session;
import uk.ac.dl.dp.coreutil.exceptions.QueryException;
import uk.ac.dl.dp.coreutil.util.DPFacilityType;
import uk.ac.dl.dp.coreutil.util.QueryRecord;
import uk.ac.dl.dp.coreutil.util.SessionUtil;
import uk.ac.dl.dp.coreutil.util.DataPortalConstants;


@Stateless(mappedName=DataPortalConstants.TIMER)
//@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class TimerServiceBean extends SessionEJBObject implements TimerServiceLocal ,TimerServiceRemote {
    
    @Resource
    TimerService timerService;
    
    @EJB()
    LookupLocal lookup;
    
    @PersistenceUnit(unitName="dataportal")
    EntityManagerFactory emf;
    
    @Resource(mappedName=DataPortalConstants.CONNECTION_FACTORY)
    private  ConnectionFactory connectionFactory;
    
    @Resource(mappedName=DataPortalConstants.KEYWORD_MDB)
    private  Queue queue;
    
    static Logger log = Logger.getLogger(TimerServiceBean.class);
    
    static boolean timerCreated  = false;
    
    /*@PostConstruct
    public void postConstructCreateTimer() {
        log.debug("postConstructCreateTimer()");
        if(!timerCreated){
            log.debug("Creating timer.");
            createTimer(1000*10L, 1000*60*30L); //10s , 30 mins
            timerCreated = true;
        }TimerServiceBean.java:89
    }*/
    
    public void createTimer(long starttime,long intervalDuration) {
        log.debug("createTimer()");
        if(!timerCreated){
            log.debug("Creating timer.");
            Timer timer = timerService.createTimer(starttime,intervalDuration, "Session clean up timer");
            timerCreated = true;
        }
    }
    
    @Timeout
    public void startTimeouts(Timer timer){
        log.debug("startTimeouts()");
        try {
            timeoutSession(timer);
        } finally {
        }
        try {
            timeoutQueryManager(timer);
        } finally {
        }
        try {
            try {
                timeoutKeyword(timer);
            } catch (Exception ex) {
                log.error("Error with keywords: ",ex);
            }
        } finally {
        }
    }
    
    
    public void timeoutSession(Timer timer) {
        log.debug("Timeout occurred: timeoutSession()");
        Collection<Session> sessions =  null;
        try {
            sessions = (Collection<Session>) em.createNamedQuery("Session.findAll").getResultList();
        } catch(Exception e){
            log.warn("Error with query in Timer",e);
            return ;
        }
        log.debug("Number sessions returned is "+sessions.size());
        Calendar now = GregorianCalendar.getInstance();
        
        for(Session ses  : sessions){
            
            Date date =ses.getExpireDateTime();
            GregorianCalendar expire = new GregorianCalendar();
            expire.setTime(date);
            
            if(now.after(expire)){
                em.remove(ses);
                log.info("Remove old session: "+ses.getUserSessionId()+" for user "+ses.getUserId().getDn());
            }
        }
    }
    
    
    public void timeoutQueryManager(Timer timer) {
        log.info("Timeout occurred: timeoutQueryManager()");
        Collection<Collection<QueryRecord>> ccqr = QueryManager.getAll();
        
        for(Collection<QueryRecord> cqr : ccqr){
            QueryRecord qr = cqr.iterator().next();
            //get Sid
            String sid  = qr.getSid();
            //gte query id
            String queryId = qr.getQueryid();
            try {
                
                new SessionUtil(sid,em);
            } catch (DataPortalException ex) {
                log.info("Remove old query from cache: "+queryId);
                QueryManager.removeRecord(queryId);
            }
        }
    }
    
    //@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void downloadKeywords() throws Exception{
        log.info("downloadKeywords");
        
        Collection<ModuleLookup> facilities = lookup.getFacilityInfo(DPFacilityType.WRAPPER);
        
        Connection connection = null;
        javax.jms.Session session = null;
        MessageProducer messageProducer = null;
        
        try {
            
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
            messageProducer = session.createProducer(queue);
            log.debug("Created connections to MDBs OK");
        } catch (JMSException ex) {
            log.error("JMSExcption on connection to meesage: ",ex);
            try {
                //close connections
                if(session != null) session.close();
                if(connection != null)   connection.close();
            } catch (JMSException e) {}
            throw new QueryException("Unexpected error, JSMException with connecting to message queue",ex);
        }
        
        
        for(ModuleLookup mod : facilities){
            try {
                ObjectMessage message = session.createObjectMessage();
                
                message.setObject(mod.getFacility());
                
                messageProducer.send(message);
                log.debug("sent download keyword message for facility: "+mod.getFacility());
                
            } catch (Exception e) {
                log.error("Unable to send download keyword message to fac "+mod.getFacility(),e);
            }
        }
        //close the connections to the queue        
        try {
            if(session != null) session.close();
            if(connection != null)   connection.close();
        } catch (JMSException ex) {
            
        }
        
    }
    
    public void timeoutKeyword(Timer timer) throws Exception{
        downloadKeywords();
    }
    
    
    public void removeSessionFromQueryCache(String sid){
        Collection<String> qr_ids = QueryManager.getUserQueryIds(sid,em);
        
        for(String ids : qr_ids){
            
            log.info("Remove old query from cache: "+ids);
            QueryManager.removeRecord(ids);
            
        }
    }
}

