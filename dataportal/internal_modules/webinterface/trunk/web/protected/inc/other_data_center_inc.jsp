<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h:form>
    <table width="95%">
        <td width="20">&nbsp;</td>
        <td>
            <table width="95%" border="0">
                <tr> <h:messages globalOnly="true" errorClass="error" infoClass="info" />
                </tr>                 
      
       
                <tr height="10"><br />&nbsp;</tr>
             
            </table>



    

            <t:dataTable id="datatable" width="95%"
                styleClass="scrollerTable"
                headerClass="standardTable_Header"
                footerClass="standardTable_Header"
                rowClasses="standardTable_Row1,standardTable_Row2"
                columnClasses="standardTable_Column,standardTable_ColumnCentered,standardTable_Column"
                var="data"
                value="#{otherdatacenterBean.dataRefs}"
                preserveDataModel="true"
                rows="#{visit.userPreferences.resultsPerPage}"
                rowId="#{data.id}"
                binding="#{otherdatacenterBean.table}"
                sortColumn="#{otherdatacenterBean.sort}"
                sortAscending="#{otherdatacenterBean.ascending}"
                preserveSort="true" 
                varDetailToggler="detailToggler">                                
                                
                <f:facet name="header">
                    <h:outputText value="#{visit.currentUserAuthDN}'s Data References" />
                </f:facet>

                <%--<h:column>
                <f:facet name="header"></f:facet>            
                <h:outputText value="#{data.id}" />              
                </h:column>--%>
                <h:column>
                    <f:facet name="header">
                        <h:commandLink style="table-header" id="name" actionListener="#{otherdatacenterBean.sortColumn}">
                            <h:outputText value="Name" />
                            <f:param name="column" value="name"/>
                        </h:commandLink>
                    </f:facet>
                    <h:commandLink onclick="download('#{data.facility}-#{data.id}','#{data.typeOfReference}','DATA_CENTER'); return false;" style="color:black" id="downloadname" actionListener="#{datacenterBean.download}">
                        <h:outputText  value="#{data.name}" />
                        <f:param name="id" value="#{data.id}"/>               
                    </h:commandLink>
                    &nbsp; <h:commandLink rendered="#{data.dataset}" action="#{detailToggler.toggleDetail}">
                        <t:graphicImage id="down" value="../../images/descending-arrow.gif" rendered="#{!detailToggler.currentDetailExpanded}" border="0"/>
                        <t:graphicImage id="up" value="../../images/ascending-arrow.gif" rendered="#{detailToggler.currentDetailExpanded}" border="0"/>
                    
                    </h:commandLink>
           
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:commandLink style="table-header" id="type" actionListener="#{otherdatacenterBean.sortColumn}">
                            <h:outputText value="Type" />
                            <f:param name="column" value="type"/>
               
                        </h:commandLink>
                    </f:facet>
              

                    <t:popup rendered="#{data.dataset}" styleClass="popup" style="font-size: 14px" closePopupOnExitingElement="true"
                        closePopupOnExitingPopup="true"
                        displayAtDistanceX="20"
                        displayAtDistanceY="-40" >
                        <h:outputText  value="#{data.typeOfObject}" />
               
                        <f:facet name="popup">
                            <h:panelGroup>
                                <h:panelGrid columns="1" >
                                    <h:outputText value="List of files: (#{data.numberOfFiles})"/> 
                             
                                    <h:outputText escape="false" value="#{data.printURLS}" />                                
                                </h:panelGrid>
                            </h:panelGroup>
                        </f:facet>
                    </t:popup>
                    <%-- <h:outputText rendered="#{!data.dataset}" value="#{data.typeOfReference}" />--%>
            
                </h:column>
       
                <h:column>
                    <f:facet name="header">
                        <h:commandLink style="table-header" id="facility" actionListener="#{otherdatacenterBean.sortColumn}">
                            <h:outputText value="Facility" />
                            <f:param name="column" value="facility"/>              
                        </h:commandLink>
                    </f:facet>
                    <h:outputText value="#{data.facility}" />
                </h:column>        
         
                <h:column>
                    <f:facet name="header">
                        <h:commandLink style="table-header" id="notes" actionListener="#{otherdatacenterBean.sortColumn}">
                            <h:outputText value="Notes" />
                            <f:param name="column" value="notes"/>               
                        </h:commandLink>
                    </f:facet>
                       
                    &nbsp;&nbsp;
             
                    <t:popup styleClass="popup" style="font-size: 14px" closePopupOnExitingElement="true"
                        closePopupOnExitingPopup="true"
                        displayAtDistanceX="5"
                        displayAtDistanceY="-40" rendered="#{data.hasNote}">

                        <h:outputText  rendered="#{data.hasNote}" style="table-header; color : blue; font-size: 10px" value="view"/>
                        <f:facet name="popup">
                            <h:panelGroup>
                                <h:panelGrid columns="1" >
                                    <table width="150" >
                                        <td nowrap="false" width="150">
                                            <h:outputText value="#{data.note}" />
                                        </td>
                                    </table>
                                </h:panelGrid>
                            </h:panelGroup>
                        </f:facet>
                    </t:popup>
           
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:commandLink style="table-header" id="time" actionListener="#{otherdatacenterBean.sortColumn}">
                            <h:outputText value="Time" />
                            <f:param name="column" value="time"/>              
                        </h:commandLink>
                    </f:facet>
                    <h:outputText value="#{data.modTime}" >
                        <f:convertDateTime pattern="HH:mm  dd.MM.yyyy "/>
                    </h:outputText>
                </h:column>       
                <h:column>
            
                    <f:facet name="header">
                        <h:outputText value="" />
                    </f:facet>          

                    <h:commandLink style="table-header" id="view" action="#{otherdatacenterBean.viewData}" rendered="#{data.dataset}">
                        <h:outputText value=" goto " />                                
                    </h:commandLink>           
                </h:column>
               
                <f:facet name="detailStamp">
                    <t:dataTable preserveSort="true"  width="95%" id="cities" styleClass="standardTable_Column" var="url" value="#{data.urls}">
                                                     
                        <h:column>
                            &nbsp; <h:commandLink onclick="download('#{data.facility}-#{data.id}-#{url.id}','DATA_CENTER_FILE','DATA_CENTER'); return false;" style="color:black" id="downloadname" >
                                <h:outputText  value="#{url.name}" style="font-size: 10px"/>
                         
                            </h:commandLink>
                        </h:column>               
                    </t:dataTable>
                </f:facet>
            </t:dataTable>

            <h:panelGrid columns="1" styleClass="scrollerTable2" columnClasses="standardTable_ColumnCentered" >
                <t:dataScroller id="scroll_11"
                    for="datatable"
                    fastStep="10"
                    pageCountVar="pageCount"
                    pageIndexVar="pageIndex"
                    styleClass="scroller"
                    paginator="true"
                    paginatorMaxPages="9"
                    paginatorTableClass="paginator"
                    paginatorActiveColumnStyle="font-weight:bold;">
                    <f:actionListener type="uk.ac.dl.dp.web.navigation.DataScrollerActionListener"/>
                    <f:facet name="first" >
                        <t:graphicImage url="../../images/arrow-first.gif" border="1" />
                    </f:facet>
                    <f:facet name="last">
                        <t:graphicImage url="../../images/arrow-last.gif" border="1" />
                    </f:facet>
                    <f:facet name="previous">
                        <t:graphicImage url="../../images/arrow-previous.gif" border="1" />
                    </f:facet>
                    <f:facet name="next">
                        <t:graphicImage url="../../images/arrow-next.gif" border="1" />
                    </f:facet>
                    <f:facet name="fastforward">
                        <t:graphicImage url="../../images/arrow-ff.gif" border="1" />
                    </f:facet>
                    <f:facet name="fastrewind">
                        <t:graphicImage url="../../images/arrow-fr.gif" border="1" />
                    </f:facet>
                </t:dataScroller>
            </h:panelGrid>
            <br />

   
        </td>
    </table>
</h:form>