/*
 * testServlet.java
 *
 * Created on 07 August 2001, 16:05
 */
 
package servercog;           

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/** 
 *
 * @author  builder
 * @version 
 */
public class testServlet extends HttpServlet {
   
    /** Initializes the servlet.
    */  
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }

    /** Destroys the servlet.
    */  
    public void destroy() {

    }

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        /* output your page here */
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet</title>");  
        out.println("</head>");
        out.println("<body>");

        String attrib;
        for ( Enumeration e=request.getAttributeNames(); e.hasMoreElements() ; ){
            attrib = e.nextElement().toString();
            out.println( "Name=<" + attrib + ">\t Value=<" + request.getAttribute(attrib).toString() + ">" );
        }
        out.println("</body>");
        out.println("</html>");
 
        out.close();
    } 

    /** Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    } 

    /** Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    }

    /** Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }

}
