//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2003.06.06 at 12:17:03 BST 
//


package edu.sdsc.matrix.srb.parser;


/**
 * Java content class for SeekNReadResult complex type.
 *  <p>The following schema fragment specifies the expected content contained within this java content object.
 * <p>
 * <pre>
 * &lt;complexType name="SeekNReadResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="contentId" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *           &lt;element name="externalURl" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;/choice>
 *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface SeekNReadResult {


    edu.sdsc.matrix.srb.parser.AnyType getExternalURl();

    void setExternalURl(edu.sdsc.matrix.srb.parser.AnyType value);

    edu.sdsc.matrix.srb.parser.AnyType getComments();

    void setComments(edu.sdsc.matrix.srb.parser.AnyType value);

    edu.sdsc.matrix.srb.parser.AnyType getContentId();

    void setContentId(edu.sdsc.matrix.srb.parser.AnyType value);

}
