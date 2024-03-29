/*
 * SessionTimedOutException.java
 *
 * Created on 27 June 2006, 11:04
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package uk.ac.dl.dp.coreutil.exceptions;

/**
 *
 * @author gjd37
 */
public class SessionTimedOutException extends SessionException {
    
    /**
     * Creates a new instance of <code>SessionTimedOutException</code> without detail message.
     */
    public SessionTimedOutException() {
    }
    
    
    /**
     * Constructs an instance of <code>SessionTimedOutException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public SessionTimedOutException(String sid) {
        super("sid: "+sid+" has expired.");
    }
}
