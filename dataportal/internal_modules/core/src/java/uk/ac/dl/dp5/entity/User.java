/*
 * User.java
 *
 * Created on 19 June 2006, 15:50
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package uk.ac.dl.dp5.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gjd37
 */
@Entity
@Table(name = "DP_USER")
@NamedQueries( {@NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"), @NamedQuery(name = "User.findByDn", query = "SELECT u FROM User u WHERE u.dn = :dn"), @NamedQuery(name = "User.findByModTime", query = "SELECT u FROM User u WHERE u.modTime = :modTime")})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private BigDecimal id;

    @Column(name = "DN", nullable = false)
    private String dn;

    @Column(name = "MOD_TIME", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date modTime;

    @OneToMany(mappedBy = "userId")
    private java.util.Collection <uk.ac.dl.dp5.entity.EventLog> eventLog;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private java.util.Collection <uk.ac.dl.dp5.entity.Bookmark> bookmark;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private java.util.Collection <uk.ac.dl.dp5.entity.Session> session;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private java.util.Collection <uk.ac.dl.dp5.entity.DataReference> dataReference;

    @OneToOne(mappedBy = "userId")
    private uk.ac.dl.dp5.entity.DpUserPreference dpUserPreference;
    
    /** Creates a new instance of User */
    public User() {
    }

    public User(BigDecimal id) {
        this.id = id;
    }

    public User(BigDecimal id, String dn, Date modTime) {
        this.id = id;
        this.dn = dn;
        this.modTime = modTime;
    }

    public BigDecimal getId() {
        return this.id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDn() {
        return this.dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public Date getModTime() {
        return this.modTime;
    }

    public void setModTime(Date modTime) {
        this.modTime = modTime;
    }

    public java.util.Collection <uk.ac.dl.dp5.entity.EventLog> getEventLog() {
        return this.eventLog;
    }

    public void setEventLog(java.util.Collection <uk.ac.dl.dp5.entity.EventLog> eventLog) {
        this.eventLog = eventLog;
    }

    public java.util.Collection <uk.ac.dl.dp5.entity.Bookmark> getBookmark() {
        return this.bookmark;
    }

    public void setBookmark(java.util.Collection <uk.ac.dl.dp5.entity.Bookmark> bookmark) {
        this.bookmark = bookmark;
    }

    public java.util.Collection <uk.ac.dl.dp5.entity.Session> getSession() {
        return this.session;
    }

    public void setSession(java.util.Collection <uk.ac.dl.dp5.entity.Session> session) {
        this.session = session;
    }

    public java.util.Collection <uk.ac.dl.dp5.entity.DataReference> getDataReference() {
        return this.dataReference;
    }

    public void setDataReference(java.util.Collection <uk.ac.dl.dp5.entity.DataReference> dataReference) {
        this.dataReference = dataReference;
    }

    public uk.ac.dl.dp5.entity.DpUserPreference getDpUserPreference() {
        return this.dpUserPreference;
    }

    public void setDpUserPreference(uk.ac.dl.dp5.entity.DpUserPreference dpUserPreference) {
        this.dpUserPreference = dpUserPreference;
    }

    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (object == null || !this.getClass().equals(object.getClass())) {
            return false;
        }
        User other = (User)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    public String toString() {
        //TODO change toString() implementation to return a better display name
        return "" + this.id;
    }
    
}