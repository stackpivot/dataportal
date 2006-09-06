/*
 * InvestigationBean.java
 *
 * Created on 16 August 2006, 14:37
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package uk.ac.dl.dp.web.backingbeans;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.*;
import org.apache.myfaces.component.html.ext.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import uk.ac.cclrc.dpal.beans.DataFile;
import uk.ac.cclrc.dpal.beans.DataSet;
import uk.ac.cclrc.dpal.beans.Investigation;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.component.*;
import org.apache.log4j.*;
import uk.ac.dl.dp.coreutil.delegates.DataCenterAuthDelegate;
import uk.ac.dl.dp.coreutil.delegates.DataCenterDelegate;
import uk.ac.dl.dp.coreutil.delegates.QueryDelegate;
import uk.ac.dl.dp.coreutil.entity.DataRefAuthorisation;
import uk.ac.dl.dp.coreutil.entity.DataReference;
import uk.ac.dl.dp.coreutil.exceptions.DataPortalException;
import uk.ac.dl.dp.coreutil.exceptions.NoAccessToDataCenterException;
import uk.ac.dl.dp.coreutil.exceptions.QueryException;
import uk.ac.dl.dp.coreutil.exceptions.SessionNotFoundException;
import uk.ac.dl.dp.coreutil.exceptions.SessionTimedOutException;
import uk.ac.dl.dp.coreutil.exceptions.UserNotFoundException;
import uk.ac.dl.dp.coreutil.util.DPAuthType;
import uk.ac.dl.dp.coreutil.util.QueryRequest;
import uk.ac.dl.dp.web.navigation.SortableList;
import javax.faces.context.FacesContext;
import javax.faces.application.*;
import javax.faces.FacesException;

/**
 *
 * @author gjd37
 */
public class ViewDataReceivedAuthorisationBean extends SortableList {
    
    private static Logger log = Logger.getLogger(ViewDataReceivedAuthorisationBean.class);
    
    private DataModel model;
    private HtmlDataTable table;
    private List<DataRefAuthorisation> receivedDataRefs;
    
    private Visit visit;
    
    public ViewDataReceivedAuthorisationBean(){
        super("name");
    }
    
    public  HtmlDataTable getTable() {
        return table;
    }
    
    public  void setTable(HtmlDataTable aTable) {
        table = aTable;
    }
    
    protected boolean isDefaultAscending(String sortColumn) {
        return true;
    }
    
    public List<DataRefAuthorisation> getReceivedDataRefs() {
        
        
        //TODO having trouble with this, was always thinking it was not null even though i was setting it as null
        if(receivedDataRefs == null){
            
            try {
                log.trace("Getting data auth..");
                receivedDataRefs = (List<DataRefAuthorisation>) DataCenterAuthDelegate.getInstance().getRecievedAuthorisedList(getVisit().getSid(), DPAuthType.BOOKMARK);
                if(getVisit().getCurrentUserAuthDN() != null){
                    for(DataRefAuthorisation auth : receivedDataRefs){
                        if(auth.getSource_user().getDn().equals(getVisit().getCurrentUserAuthDN())){
                            
                            auth.setSelected(true);
                            break;
                        }
                        
                    }
                }
                getVisit().setCurrentReceivedAuthorisations(receivedDataRefs);
            } catch (Exception ex) {
                log.error("Unable to get bookmarks",ex);
            }
            sort(getSort(), isAscending());
            return (List<DataRefAuthorisation>)getVisit().getCurrentReceivedAuthorisations();
        } else{
            return (List<DataRefAuthorisation>)receivedDataRefs;
        }
        
    }
    
    public void setReceivedDataRefs(List<DataRefAuthorisation> receivedDataRefs) {
        // update the cars from the provided list
       /* log.trace("Setting list");
        for(DataReference dataref:  dataRefs){
            log.trace(dataref.isSelected());
        }
        this.dataRefs. = dataRefs;*/
        
    }
    
    protected void sort(final String column, final boolean ascending) {
        Comparator comparator = new Comparator() {
            public int compare(Object o1, Object o2) {
                DataRefAuthorisation c1 = (DataRefAuthorisation) o1;
                DataRefAuthorisation c2 = (DataRefAuthorisation) o2;
                if (column == null) {
                    return 0;
                }
                if (column.equals("startDate")) {
                    return ascending ? c1.getAuthStartDate().compareTo(c2.getAuthStartDate()) : c2.getAuthStartDate()
                    .compareTo(c1.getAuthStartDate());
                } else if (column.equals("endDate")) {
                    return ascending ? c1.getAuthEndDate().compareTo(c2.getAuthEndDate()) : c2.getAuthEndDate()
                    .compareTo(c1.getAuthEndDate());
                } else if (column.equals("givenToUser")) {
                    return ascending ? c1.getUser().getDn().compareTo(c2.getUser().getDn()) : c2.getUser().getDn()
                    .compareTo(c1.getUser().getDn());
                } else if (column.equals("type")) {
                    return ascending ? c1.getAuthType().compareTo(c2.getAuthType()) : c2.getAuthType()
                    .compareTo(c1.getAuthType());
                } else
                    return 0;
            }
        };
        if(receivedDataRefs == null){
            log.trace("Is givsnData is null ");
        }
        Collections.sort( (List<DataRefAuthorisation>)getVisit().getCurrentReceivedAuthorisations(), comparator);
        
    }
    
    
    public String viewData(){
        log.trace("view data");
        DataRefAuthorisation dfa =   (DataRefAuthorisation) table.getRowData();
        log.trace("set other users: "+dfa.getSource_user().getDn());
        getVisit().setCurrentUserAuthDN(dfa.getSource_user().getDn());
        
        return null;
        
    }
    
    public String unviewData(){
        log.trace("unview data");
        DataRefAuthorisation dfa =   (DataRefAuthorisation) table.getRowData();
        log.trace("unset other users: "+dfa.getSource_user().getDn());
        getVisit().setCurrentUserAuthDN(null);
        
        return null;
        
    }
    
    public void sortColumn(ActionEvent event){
        log.trace("Sorting column");
        List children  = event.getComponent().getChildren();
        int i = 0;
        for(Object ob : children){
            if(ob instanceof UIParameter){
                UIParameter current = (UIParameter)children.get(i);
                log.trace("Param name "+current.getName());
                if(current.getName().equals("column") && current.getValue() != null){
                    String param = current.getValue().toString();
                    log.trace("Sorting by: "+param);
                    sort(param);
                    break;
                }
            }
            i++;
        }
    }
    
//Faces objects
    public FacesContext getFacesContext(){
        return FacesContext.getCurrentInstance();
    }
    
    public Application getApplication(){
        return getFacesContext().getApplication();
    }
    
//application objects
    public Visit getVisit(){
        return visit;
    }
    
    public void setVisit(Visit visit) {
        this.visit = visit;
    }
    
    
    
}
