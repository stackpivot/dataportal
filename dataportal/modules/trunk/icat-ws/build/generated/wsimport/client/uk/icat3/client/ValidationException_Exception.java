
package uk.icat3.client;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.2-b05-RC1
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "ValidationException", targetNamespace = "client.icat3.uk")
public class ValidationException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ValidationException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public ValidationException_Exception(String message, ValidationException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public ValidationException_Exception(String message, ValidationException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: uk.icat3.client.ValidationException
     */
    public ValidationException getFaultInfo() {
        return faultInfo;
    }

}