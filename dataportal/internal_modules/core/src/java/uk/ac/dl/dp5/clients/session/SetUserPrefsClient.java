/*
 * NewMain.java
 *
 * Created on 31 March 2006, 15:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package uk.ac.dl.dp5.clients.session;

import javax.naming.*;
import java.util.*;
import uk.ac.dl.dp5.dto.UserPreferencesDTO;
import uk.ac.dl.dp5.sessionbeans.session.SessionRemote;
import uk.ac.dl.dp5.util.Resolution;

/**
 *
 * @author gjd37
 */
public class SetUserPrefsClient {
    
    /** Creates a new instance of NewMain */
    public SetUserPrefsClient() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            
            InitialContext ic = new InitialContext();
            
            SessionRemote sless = (SessionRemote) ic.lookup("SessionEJB");
            
            UserPreferencesDTO dtp  =new UserPreferencesDTO();
            dtp.setDefaultFacility("ISIS");
            dtp.setResolution(Resolution.res_1600x1200);
            dtp.setResultsPerPage(20);
                    
             sless.setUserPrefs("7fb8cce3-9449-4333-a724-afa46c951d43",dtp);
            //System.out.println("Got session : "+session);
            //
        }catch(Exception e){
            
            e.printStackTrace();
            
        }
    }
    
    public static Context getContext() throws Exception{
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        env.put(Context.PROVIDER_URL, "localhost");
        env.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces" );
        Context ctx = new InitialContext(env);
        return ctx;
    }
    
}
