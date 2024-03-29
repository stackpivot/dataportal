//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2003.06.06 at 12:17:03 BST 
//


package edu.sdsc.matrix.srb.parser;


/**
 * Java content class for GridTicketInfo complex type.
 *  <p>The following schema fragment specifies the expected content contained within this java content object.
 * <p>
 * <pre>
 * &lt;complexType name="GridTicketInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ticketID" type="{http://www.teragrid.org/schemas/datagrid}TicketID"/>
 *         &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="endTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="recursiveDistribution" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ticketParent" type="{http://www.teragrid.org/schemas/datagrid}UserInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface GridTicketInfo {


    edu.sdsc.matrix.srb.parser.UserInfo getTicketParent();

    void setTicketParent(edu.sdsc.matrix.srb.parser.UserInfo value);

    java.util.Calendar getEndTime();

    void setEndTime(java.util.Calendar value);

    java.util.Calendar getStartTime();

    void setStartTime(java.util.Calendar value);

    boolean isRecursiveDistribution();

    void setRecursiveDistribution(boolean value);

    edu.sdsc.matrix.srb.parser.TicketID getTicketID();

    void setTicketID(edu.sdsc.matrix.srb.parser.TicketID value);

}
