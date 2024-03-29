<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="1">
        <link rel="stylesheet" type="text/css" href="../css/basic.css" />
        <script language="javascript" src="../css/download.js"></script>
        <title>Downloading... </title>
        
        <script>
     
            
            function close(){
               window.location.href-"close.html";
            }
            
            function nothing(){
               //do nothing
               //alert("nothing");
            }
            
            function Func1Delay()
            {
          // alert("setTimeout");
                //sleep two seconds
                setTimeout("remove()", 1500);
            }
            
            function Func1DelayClose()
            {
           
                //sleep two seconds
                setTimeout(window.close(), 500);
            }
            
            function remove(){
           
                if(BrowserDetect.browser == "Firefox"){
                //firefox
                    if(BrowserDetect.OS == "Windows"){
                        //windows shuts the save/download diolog box aswell

                        document.getElementById('button').value = "Close";
                        document.getElementById('progressBar_percentageText').style.display = "none";             
                        document.getElementById('progressBar_FinishedText').style.display = "block";

                        document.getElementById('downloading').style.display = "none";
                        document.getElementById('downloaded').style.display = "block";

                        document.getElementById('progressBar_portionComplete').style.background = "#00FF00";                        
                        document.getElementById('progressBar_portionRemaining').style.background = "#00FF00";
                        
                        document.getElementById('progressBar_portionComplete').width = "100";
                        document.getElementById('progressBar_portionRemaining').width = "0";

                    }

                    else {
                         window.location.href="../protected/close.html";
                    }
                }

                else {    
                    window.location.href="../protected/close.html";
                }        
            }
            
        </script>
        
        <style>
            .bpui_progressbar_barAreaContainer {
            border-style: groove !important;
            border-width: medium !important;
            }
            
            .bpui_progressbar_portionComplete {
            background: #FF0000 !important;
            }
            
            .bpui_progressbar_portionRemaining {
            background: #C8C8C8 !important;
            }    
            .bpui_progressbar_barAreaContainer {
            }
            
            .bpui_progressbar_barArea {
            height: 18px;
            }
            
            .bpui_progressbar_portionComplete {
            background: #00FF00;
            }
            
            .bpui_progressbar_portionRemaining {
            background: #D9E6EC;
            }
            
            .bpui_progressbar_percentageText {
            text-align: center;
            }
            
            body {
            background: #E8E8E8 !important;
            }
            
        </style>        
    </head>
    <body onload="Func1Delay()" >
        <br />  
      
        <table align="center" id="progressBar_barAreaContainer" width="90%"><tbody>
                
                <tr>
                    <td align="center">
                        <div id="downloading"> <font size="2">Downloading:</font> <%= request.getParameter("name") %></div>
                        <div id="downloaded" style="display:none"> <font size="2">Downloaded:</font>   <%= request.getParameter("name") %></div>
                    </td>  
                </tr>
            </tbody>     
        </table>
        <br />
        <%
        String percent = request.getParameter("percentage") ;
        String ID = request.getParameter("url") ;
        
        if(percent == null){
            percent = "0";
        }
        %>  
        
        
        <table align="center" id="progressBar_barAreaContainer" class="bpui_progressbar_barAreaContainer" border="0" cellspacing="0" cellpadding="0" width="90%">
            <tr id="progressBar_barArea" class="bpui_progressbar_barArea">
                <td id="progressBar_portionIndeterminate" class="bpui_progressbar_portionRemaining" width="0%"></td>
                <td id="progressBar_portionComplete" class="bpui_progressbar_portionComplete" width="<%= percent %>%"></td>
                <td id="progressBar_portionRemaining" class="bpui_progressbar_portionRemaining" width="<%= (100-Integer.valueOf(percent)) %>%"></td>
            </tr>
        </table><div id="progressBar_percentageText" class="bpui_progressbar_percentageText"><%= percent %>%</div><div style="display:none" id="progressBar_FinishedText" class="bpui_progressbar_percentageText">100%</div>
        <br />
        <table align="center">
            <tr>
                <td align="right"> 
                    <form method="post" action="../servlet/DownloadRemoveServlet?ID=<%=ID %>">
                        <input id="button" type="Submit"  value="Cancel" onclick="submit();  "/>
                    </form>
                </td>
            </tr>
        </table>
        <%-- <TABLE border=0 width='<%= percent %>%' bgcolor='red'>
        <TR><TD width='100%'> </TD></TR>
        </TABLE>--%>
    </body>
</html>
