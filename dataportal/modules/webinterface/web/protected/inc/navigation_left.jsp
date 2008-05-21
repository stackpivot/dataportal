<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>


        <f:loadBundle basename="uk.ac.dl.dp.web.messages.facility" var="facility_properties" />
        
        <h:form>
            
            <t:jscookMenu  layout="vbr" theme="ThemePanel" styleLocation="../css/jscookmenu">
                <%/* Availaible jscookMenu themes: ThemeIE, ThemeMiniBlack, ThemeOffice,ThemeOffice2003, ThemePanel
                Availaible jscookMenu layout: hbr, hbl, hur, hul, vbr, vbl, vur, vul
                respect to Heng Yuan http://www.cs.ucla.edu/~heng/JSCookMenu
                */%>
                <t:navigationMenuItem split="true"> </t:navigationMenuItem> 
                <t:navigationMenuItem id="nav_0"  itemLabel="Search        " itemValue="basicSearch">    
                
                
                <t:navigationMenuItem id="nav_0_1"  itemLabel="Keyword Search" itemValue="keywordSearch" action="GOTO_BASIC_SEARCH" />
                <t:navigationMenuItem id="nav_0_2"  itemLabel="Advanced Search" itemValue="advancedSearch" action="GOTO_ADVANCED_SEARCH" />     
                <t:navigationMenuItem id="nav_0_0_1" rendered="#{visit.customisation.facilitySearchPageVisible}" itemLabel="#{facility_properties['facility.name']} Search" itemValue="facilitySearch" action="#{searchBean.gotoFacilitySearchPage}" />              
                <t:navigationMenuItem id="nav_0_3"  itemLabel="My Data Search" itemValue="myDataSearch"  action="#{searchBean.searchOwnDataAll}" />
                </t:navigationMenuItem> 
                
                <t:navigationMenuItem split="true"> </t:navigationMenuItem> 
                
            <%--    <t:navigationMenuItem id="nav_4"  itemLabel="Data Links" >                  
                <t:navigationMenuItem id="nav_4_1"  itemLabel="Data References" action="GOTO_DATA_REFERENCES" />
                <t:navigationMenuItem id="nav_4_2"  itemLabel="Bookmarks" action="GOTO_BOOKMARKS" />
                </t:navigationMenuItem> 
                
                <t:navigationMenuItem split="true"> </t:navigationMenuItem> --%>
                
                <t:navigationMenuItem id="nav_5"  itemLabel="User Preferences &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;" action="GOTO_USER_PREFS" />
                
                <t:navigationMenuItem split="true"> </t:navigationMenuItem> 
                
                <t:navigationMenuItem id="nav_6"  itemLabel="Log out" action="#{authorisationBean.logout}"  />
                
                <t:navigationMenuItem split="true"> </t:navigationMenuItem> 
                
            </t:jscookMenu>       
            <input type="hidden" name="jscook_action" />
            
        </h:form> 
