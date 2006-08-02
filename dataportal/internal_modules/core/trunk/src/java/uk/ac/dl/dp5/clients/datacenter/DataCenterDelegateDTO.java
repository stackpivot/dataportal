package uk.ac.dl.dp5.clients.datacenter;
/*
 * SessionDelegate.java
 *
 * Created on 22 June 2006, 08:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import java.util.Collection;
import javax.naming.NamingException;
import uk.ac.dl.dp5.clients.dto.BookmarkDTO;
import uk.ac.dl.dp5.clients.dto.DataUrlDTO;
import uk.ac.dl.dp5.exceptions.SessionTimedOutException;
import uk.ac.dl.dp5.sessionbeans.datacenter.DataCenterRemote;
import uk.ac.dl.dp5.util.CachingServiceLocator;

import uk.ac.dl.dp5.exceptions.SessionNotFoundException;
import uk.ac.dl.dp5.exceptions.UserNotFoundException;
import uk.ac.dl.dp5.sessionbeans.datacenter.DataCenterRemoteDTO;
import uk.ac.dl.dp5.util.DataPortalConstants;

/**
 *
 * @author gjd37
 */
public class DataCenterDelegateDTO {
    
    private static DataCenterDelegateDTO dcd;
    private static DataCenterRemoteDTO dcr ;
    
    public static DataCenterDelegateDTO getInstance(){
        synchronized(DataCenterDelegateDTO.class){
            if(dcd == null){
                try {
                    dcd = new DataCenterDelegateDTO();
                } catch(Exception se) {
                    throw new RuntimeException(se);
                }
            }
            return dcd;
        }
    }
    
    
    /** Creates a new instance of SessionDelegate */
    private  DataCenterDelegateDTO() throws NamingException {
        CachingServiceLocator csl =  CachingServiceLocator.getInstance();
        dcr  = (DataCenterRemoteDTO)csl.lookup(DataPortalConstants.DATA_CENTER+"DTO");
    }
    
    /*All DataCenterBean methods here*/
    
    
    public Collection<BookmarkDTO> addBookmark(String sid, BookmarkDTO dto) throws  UserNotFoundException,SessionTimedOutException, SessionNotFoundException{
        return dcr.addBookmark(sid,dto);
    }
    
     public Collection<BookmarkDTO> addBookmark(String sid, Collection<BookmarkDTO> dto) throws  UserNotFoundException,SessionTimedOutException, SessionNotFoundException{
        return dcr.addBookmark(sid,dto);
    }
    
    public Collection<BookmarkDTO> getBookmarks(String sid) throws SessionNotFoundException, UserNotFoundException, SessionTimedOutException{
        return dcr.getBookmarks(sid);
    }
    
    void addDataUrl(String sid, DataUrlDTO dto) throws SessionNotFoundException, UserNotFoundException, SessionTimedOutException{
        dcr.addDataUrl(sid,dto);
    }
    
    public Collection<DataUrlDTO> getUrls(String sid) throws SessionNotFoundException, UserNotFoundException, SessionTimedOutException{
        return dcr.getUrls(sid);
    }
    
    
}