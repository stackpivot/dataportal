//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2003.06.06 at 12:17:03 BST 
//


package edu.sdsc.matrix.srb.parser;


/**
 * Java content class for DataGridRequest element declaration.
 *  <p>The following schema fragment specifies the expected content contained within this java content object.
 * <p>
 * <pre>
 * &lt;element name="DataGridRequest">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element name="DocMeta" type="{http://www.teragrid.org/schemas/datagrid}DocMeta"/>
 *           &lt;element name="GridUser" type="{http://www.teragrid.org/schemas/datagrid}UserInfo"/>
 *           &lt;element name="VOInfo" type="{http://www.teragrid.org/schemas/datagrid}VirtualOrganizationInfo"/>
 *           &lt;choice>
 *             &lt;element name="Transaction" type="{http://www.teragrid.org/schemas/datagrid}Transaction"/>
 *             &lt;element name="TransactionStatusQuery" type="{http://www.teragrid.org/schemas/datagrid}TransactionStatusQuery"/>
 *           &lt;/choice>
 *           &lt;element name="FaultHandler" type="{http://www.teragrid.org/schemas/datagrid}FaultHandlers"/>
 *         &lt;/sequence>
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 */
public interface DataGridRequest
    extends javax.xml.bind.Element, edu.sdsc.matrix.srb.parser.DataGridRequestType
{


}
