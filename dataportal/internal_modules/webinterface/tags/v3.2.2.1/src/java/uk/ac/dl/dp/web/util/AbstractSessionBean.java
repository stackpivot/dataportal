/*
 * AbstractSessionBean.java
 *
 * Created on 16 August 2006, 09:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package uk.ac.dl.dp.web.util;

/**
 *
 * @author djm76
 */

import java.io.Serializable;

/**
 * <p><strong>AbstractSessionBean</strong> is the abstract base class for
 * data bean(s) that are stored in session scope attributes.  It extends
 * {@link FacesBean}, so it inherits all of the default behavior
 * found there.  In addition, the following lifecycle methods are called
 * automatically when the corresponding events occur:</p>
 * <ul>
 * <li><code>init()</code> - Called when this bean is initially added
 *     as a session attribute (typically as the result of evaluating a
 *     value binding or method binding expression).</li>
 * <li><code>passivate()</code> - Called when the servlet container is about
 *     to serialize and remove this session from its current container.</li>
 * <li><code>activate()</code> - Called when the servlet container has
 *     finished deserializing this session and making it available in a
 *     (potentially different) container.</li>
 * <li><code>destroy()</code> - Called when the bean is removed from the
 *     session attributes (typically as a result of the session timing out
 *     or being terminated by the application).</li>
 * </ul>
 */
public abstract class AbstractSessionBean extends FacesBean implements Serializable {
    

    // ------------------------------------------------------------- Constructor


    /**
     * <p>Create a new session scope bean.</p>
     */
    public AbstractSessionBean() {      
    }
    

    // ------------------------------------------------------- Lifecycle Methods


    /**
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
     *
     * <p>You may customize this method to initialize and cache data values
     * or resources that are required for the lifetime of a particular
     * user session.</p>
     */
    public void init() {

        // The default implementation does nothing

    }


    /**
     * <p>This method is called when the session containing it is about to be
     * passivated.  Typically, this occurs in a distributed servlet container
     * when the session is about to be transferred to a different
     * container instance, after which the <code>activate()</code> method
     * will be called to indicate that the transfer is complete.</p>
     *
     * <p>You may customize this method to release references to session data
     * or resources that can not be serialized with the session itself.</p>
     */
    public void passivate() {

        // The default implementation does nothing

    }


    /**
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     * 
     * <p>You may customize this method to reacquire references to session
     * data or resources that could not be serialized with the
     * session itself.</p>
     */
    public void activate() {

        // The default implementation does nothing

    }


    /**
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     * the session timing out or being terminated by the application.</p>
     *
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    public void destroy() {

        // The default implementation does nothing

    }


}