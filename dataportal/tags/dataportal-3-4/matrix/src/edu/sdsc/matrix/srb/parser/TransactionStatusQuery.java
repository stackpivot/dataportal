//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2003.06.06 at 12:17:03 BST 
//


package edu.sdsc.matrix.srb.parser;


/**
 * Java content class for TransactionStatusQuery complex type.
 *  <p>The following schema fragment specifies the expected content contained within this java content object.
 * <p>
 * <pre>
 * &lt;complexType name="TransactionStatusQuery">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="FlowStatusQuery" type="{http://www.teragrid.org/schemas/datagrid}FlowStatusQuery"/>
 *       &lt;/sequence>
 *       &lt;attribute name="transactionID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface TransactionStatusQuery {


    java.lang.String getTransactionID();

    void setTransactionID(java.lang.String value);

    edu.sdsc.matrix.srb.parser.FlowStatusQuery getFlowStatusQuery();

    void setFlowStatusQuery(edu.sdsc.matrix.srb.parser.FlowStatusQuery value);

}