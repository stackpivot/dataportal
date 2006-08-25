/*
 * Visit.java
 *
 * Created on 08 August 2006, 09:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package uk.ac.dl.dp.web.backingbeans;

import java.io.Serializable;
import uk.ac.cclrc.dpal.beans.DataFile;
import uk.ac.cclrc.dpal.beans.DataSet;
import uk.ac.cclrc.dpal.beans.Investigation;
import uk.ac.cclrc.dpal.beans.Study;
import uk.ac.dl.dp.coreutil.clients.dto.FacilityDTO;
import uk.ac.dl.dp.coreutil.clients.dto.SessionDTO;
import uk.ac.dl.dp.coreutil.clients.dto.UserPreferencesDTO;
import uk.ac.dl.dp.coreutil.delegates.QueryDelegate;
import uk.ac.dl.dp.coreutil.delegates.QueryDelegateStateFul;
import uk.ac.dl.dp.coreutil.entity.User;
import uk.ac.dl.dp.coreutil.util.DPRole;
import java.util.*;
import javax.faces.model.SelectItem;
import org.apache.log4j.*;
import uk.ac.dl.dp.coreutil.util.QueryRequest;
/**
 *
 * @author gjd37
 */
public class Visit implements Serializable {
    
    private String dn;
    private Collection<DPRole> roles;
    private String sid;
    private boolean isAdmin = false;
    private AuthorisationBean authBean;
    private UserPreferencesDTO userPreferences;
    
    private SessionDTO session;
    
    //private Collection<Study> currentStudies;
    
    private Collection<Investigation> searchedInvestigations;
    
    private Collection<Investigation> currentInvestigations;
    
    private Collection<DataSet> currentDatasets;
    
    private Collection<DataFile> currentDatafiles;
    
    private List<SelectItem> facilities ;
    
    private String width ;
    
    private QueryRequest queryRequest;
    
    private Collection<String> completedFacilities  = new ArrayList<String>();
    
    private boolean finished;
    
    private static Logger log = Logger.getLogger(Visit.class);
    
    public Visit(){
    }
    
    public SessionDTO getSession() {
        return session;
    }
    
    public void setSession(SessionDTO session) {
        this.session = session;
        this.sid = session.getUserSessionId();
        this.dn = session.getDN();
        this.roles = session.getRoles();
        this.userPreferences = session.getUserPrefs();
        
        String res  = this.userPreferences.getResolution().toString();
        width = getWidth(res);
        log.trace("Width set to: "+width);
        
        for(DPRole role : roles){
            if(role.ADMIN == DPRole.ADMIN) {
                isAdmin = true;
                break;
            }
        }
        
        facilities = new ArrayList<SelectItem>();
        for(FacilityDTO facs : session.getFacilities()){
            facilities.add(new SelectItem(facs.getFacility(), facs.getFacility(), null));
        }
    }
    
    public boolean isAdmin(){
        return isIsAdmin();
    }
    
    public Collection<DPRole> getRoles(){
        return this.roles;
    }
    
    public AuthorisationBean getAuthorisationBean() {
        return getAuthBean();
    }
    
    public void setAuthorisationBean(AuthorisationBean authBean) {
        this.authBean = authBean;
    }
    
    public String getDn() {
        return dn;
    }
    
    public String getSid() {
        return sid;
    }
    
    public boolean isIsAdmin() {
        return isAdmin;
    }
    
    public AuthorisationBean getAuthBean() {
        return authBean;
    }
    
    /*public Collection<Study> getCurrentStudies() {
        return currentStudies;
    }
     
    public void setCurrentStudies(Collection<Study> currentStudies) {
        this.currentStudies = currentStudies;
    }*/
    
    public Collection<Investigation> getCurrentInvestigations() {
        return currentInvestigations;
    }
    
    public void setCurrentInvestigations(Collection<Investigation> currentInvestigations) {
        this.currentInvestigations = currentInvestigations;
        
        //construct tree data
    }
    
    public boolean isInvestigations(){
        if(currentInvestigations == null) return false;
        else return true;
    }
    
    public Collection<DataSet> getCurrentDatasets() {
        return currentDatasets;
    }
    
    public void setCurrentDatasets(Collection<DataSet> currentDatasets) {
        this.currentDatasets = currentDatasets;
    }
    
    public boolean isDatasets(){
        if(currentDatasets == null) return false;
        else return true;
    }
    
    
    public  List<SelectItem> getFacilities() {
        
        return facilities;
    }
    
    
    public void setFacilities(List<SelectItem> aFacilities) {
        facilities = aFacilities;
    }
    
    public UserPreferencesDTO getUserPreferences() {
        return userPreferences;
    }
    
    public void setUserPreferences(UserPreferencesDTO userPreferences) {
        this.userPreferences = userPreferences;
    }
    
    public String getWidth() {
        return width;
    }
    
    public void setWidth(String width) {
        this.width = width;
    }
    
    private String getWidth(String res) {
        int length = res.length();
        String split_res = res.substring(4, length);
        int width_int = new  Integer(split_res.split("x")[0]).intValue() - 70;
        
        return String.valueOf(width_int);
    }
    
    public Collection<DataFile> getCurrentDatafiles() {
        return currentDatafiles;
    }
    
    public void setCurrentDatafiles(Collection<DataFile> currentDatafiles) {
        this.currentDatafiles = currentDatafiles;
    }
    
    public Collection<Investigation> getSearchedInvestigations() {
        return searchedInvestigations;
    }
    
    public void setSearchedInvestigations(Collection<Investigation> searchedInvestigations) {
        this.searchedInvestigations = searchedInvestigations;
    }
    
    public QueryRequest getQueryRequest() {
        return queryRequest;
    }
    
    public void setQueryRequest(QueryRequest queryRequest) {
        this.queryRequest = queryRequest;
    }
    
    public Collection<String> getCompletedFacilities() {
        return completedFacilities;
    }
    
    public void setCompletedFacilities(Collection<String> completedFacilities) {
        this.completedFacilities = completedFacilities;
    }
    
    public boolean isFinished() {
        boolean isFinished;
        try {
            isFinished = QueryDelegate.getInstance().isFinished(getQueryRequest());
        } finally {
        }
        if(isFinished) return true;
        else {
            this.completedFacilities = QueryDelegate.getInstance().getCompleted(getQueryRequest());
            return false;
        }
        
    }
    
    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    
    
    
    
}
