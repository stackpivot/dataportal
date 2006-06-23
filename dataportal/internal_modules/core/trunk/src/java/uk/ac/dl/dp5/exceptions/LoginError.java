/*
 * LoginError.java
 *
 * Created on 23 June 2006, 15:03
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package uk.ac.dl.dp5.exceptions;

/**
 *
 * @author gjd37
 */
/**
 *
 * @author gjd37
 */
public enum LoginError {        
    
    UNKNOWN("UNKNOWN_CAUSE"),
    CREDENTIALS_EXPIRED("CREDENTIALS_EXPIRED"),
    MYPROXY_CREDENTIAL_EXPIRED_EXCEPTION("Credentials have expired on MyProxy server. Upload a new proxy and try again"),
    MYPROXY_LOGIN_EXCEPTION("MYPROXY_LOGIN_EXCEPTION"),
    INVALID_PASSPHASE("Invalid Passphrase Please Try Again"),
    NO_MYPROXY_CREDENTIAL("No credentials on MyProxy server. Upload a proxy and try again");
        
    
    LoginError(String value) {
        this.value = value;
    }
    
    private final String value;
        
    public String toString() {
        return value;
    }
    
    
}

