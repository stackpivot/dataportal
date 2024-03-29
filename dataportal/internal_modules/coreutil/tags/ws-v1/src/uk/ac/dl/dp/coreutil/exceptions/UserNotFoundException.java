/*
 * UserNotFoundException.java
 *
 * Created on 20 June 2006, 08:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package uk.ac.dl.dp.coreutil.exceptions;

/**
 *
 * @author gjd37
 */
public class UserNotFoundException extends SessionException {
    
    /**
     * Creates a new instance of <code>UserNotFoundException</code> without detail message.
     */
    public UserNotFoundException() {
    }
    
    
    /**
     * Constructs an instance of <code>UserNotFoundException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public UserNotFoundException(String msg) {
        super(msg);
    }
}
