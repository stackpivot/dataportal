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
import uk.ac.dl.dp.coreutil.clients.dto.QueryRecordDTO;
import uk.ac.dl.dp.coreutil.delegates.DataCenterDelegate;
import uk.ac.dl.dp.coreutil.delegates.QueryDelegate;
import uk.ac.dl.dp.coreutil.entity.Bookmark;
import uk.ac.dl.dp.coreutil.entity.DataReference;
import uk.ac.dl.dp.coreutil.exceptions.DataPortalException;
import uk.ac.dl.dp.coreutil.exceptions.SessionNotFoundException;
import uk.ac.dl.dp.coreutil.exceptions.SessionTimedOutException;
import uk.ac.dl.dp.coreutil.exceptions.UserNotFoundException;
import uk.ac.dl.dp.coreutil.util.QueryRequest;
import uk.ac.dl.dp.web.navigation.SortableList;
import javax.faces.context.FacesContext;
import javax.faces.application.*;

/**
 *
 * @author gjd37
 */
public class HistoryBean extends SortableList {
    
    private static Logger log = Logger.getLogger(HistoryBean.class);
    
    private DataModel model;
    private HtmlDataTable table;
    private List<QueryRecordDTO> history;
    private Visit visit;
    
    public HistoryBean(){
        super("finished");
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
    
    public List<QueryRecordDTO> getHistory() {
        
        if(history == null){
            
            try {
                log.trace("Getting bookmarks..");
                history = (List<QueryRecordDTO>) QueryDelegate.getInstance().getCurrentResults(getVisit().getSid());
            } catch (Exception ex) {
                log.error("Unable to get bookmarks",ex);
            }
            sort(getSort(), isAscending());
        }
        
        return (List<QueryRecordDTO>) history;
        
    }
    
    public void setHistory(List<QueryRecordDTO> dataRefs) {
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
                QueryRecordDTO c1 = (QueryRecordDTO) o1;
                QueryRecordDTO c2 = (QueryRecordDTO) o2;
                if (column == null) {
                    return 0;
                }
                if (column.equals("facilities")) {
                    return ascending ? c1.getFacilities().iterator().next().compareTo(c2.getFacilities().iterator().next()) : c2.getFacilities().iterator().next()
                    .compareTo(c1.getFacilities().iterator().next());
                } else if (column.equals("sent")) {
                    
                    return ascending ? c1.getSent().compareTo(c2.getSent()) : c2.getSent()
                    .compareTo(c1.getSent());
                } else if (column.equals("finished")) {
                    return ascending ? c1.getProcessed().compareTo(c2.getProcessed()) : c2.getProcessed()
                    .compareTo(c1.getProcessed());
                } else
                    return 0;
            }
        };
        if(history == null){
            log.trace("Is history is null ");
        }
        Collections.sort( history, comparator);
        
    }
    
   /* public void listen(ValueChangeEvent e){
        log.debug("value change event");
        Collection<Investigation> investigations = getVisit().getSearchedInvestigations();
    
        Investigation d = (Investigation)table.getRowData();
        if(e.getNewValue().equals(new Boolean(true)) ){
            log.trace("true selected boolean");
            for(Investigation invest : investigations){
                if(invest.getId().equals(d.getId())) {
                    invest.setSelected(true);
                    log.trace(invest.isSelected()+" for "+invest.getId());
    
                }
            }
        }
        if(e.getNewValue().equals(new Boolean(false)) ){
            log.trace("false selected boolean");
            for(Investigation invest : investigations){
                if(invest.getId().equals(d.getId())) {
                    log.trace("setting false");
                    invest.setSelected(false);
                    log.trace(invest.isSelected()+" for "+invest.getId());
                }
            }
        }
    }*/
    
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
    
    
    
  /*  public String selectall(){
        for(DataReference ref :  dataRefs){
            //ref.setSelected(true);
        }
        return null;
    }
   
    public String selectnone(){
        for(DataReference ref :  dataRefs){
            //ref.setSelected(false);
        }
        return null;
    }*/
    
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
