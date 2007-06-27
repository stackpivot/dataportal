/*
 * EventMessageBean.java
 *
 * Created on 22 June 2006, 13:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package uk.ac.dl.dp.core.message.query;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import org.apache.log4j.Logger;
import uk.ac.dl.dp.coreutil.util.DataPortalConstants;
import uk.ac.dl.dp.coreutil.interfaces.LookupLocal;
import uk.ac.dl.dp.core.message.MessageEJBObject;
import uk.ac.dl.dp.coreutil.entity.FacilitySession;
import uk.ac.dl.dp.coreutil.entity.ModuleLookup;
import uk.ac.dl.dp.coreutil.entity.Session;
import uk.ac.dl.dp.coreutil.util.LoginICATMessage;
import uk.ac.dl.dp.coreutil.util.SessionUtil;
import uk.ac.dp.icatws.ICATSingleton;

/**
 *
 * @author gjd37
 */
@MessageDriven(mappedName=DataPortalConstants.LOGIN_ICAT_MDB, activationConfig =
{
    @ActivationConfigProperty(propertyName="destinationType",
    propertyValue="javax.jms.Queue"),
    @ActivationConfigProperty(propertyName="destination",
    propertyValue=DataPortalConstants.LOGIN_ICAT_MDB)
})
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class LoginICATMessageBean extends MessageEJBObject implements MessageListener {
    
    static Logger log = Logger.getLogger(LoginICATMessageBean.class);
    
    @EJB
    private LookupLocal lookupLocal;
    
    public void onMessage(Message message) {
        
        log.debug("onMessage();  Login ICAT received");
        ObjectMessage msg = null;
        LoginICATMessage loginICATMessage = null;
        ModuleLookup facilityDownload = null;
        FacilitySession facSession = new FacilitySession();
        Session session = null;
        
        if (message instanceof ObjectMessage) {
            msg = (ObjectMessage) message;
            
            try {
                loginICATMessage = (LoginICATMessage) msg.getObject();
                log.debug("onMessage();  Login ICAT received for "+loginICATMessage.getFacility());
            } catch (JMSException jmsex) {
                log.debug("Object not correct",jmsex);
                return ;
            }
            try{
                session = new SessionUtil(loginICATMessage.getSessionId(),em).getSession();
                ModuleLookup facility = lookupLocal.getFacility(loginICATMessage.getFacility());
                
                if(facility == null){
                    log.error("Unable to locate facility from lookup with name: "+loginICATMessage.getFacility());
                    return ;
                }
                
                //now log in
                String sessionId = ICATSingleton.getInstance(loginICATMessage.getFacility()).loginLifetime(
                        loginICATMessage.getUsername(),
                        loginICATMessage.getPassword(),
                        loginICATMessage.getLifetime());
                facSession.setFacilitySessionId(sessionId);
                log.debug("Logged into "+loginICATMessage.getFacility()+" with sessionid "+sessionId);
                
            } catch (Exception ex) {
                log.error("Unable to login to facility: "+facilityDownload.getFacility(),ex);
                facSession.setFacilitySessionError(ex.getMessage());
            }
            //save info to DB
            facSession.setFacilityName(loginICATMessage.getFacility());           
            facSession.setSessionId(session);
            
            //em.persist(facSession);            
            //persist it this way
            session.addFacilitySession(facSession);
        }
        
        log.debug("Message login ICAT finished");        
    }
}