

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/SessionServlet"})
public class SessionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
           
        HttpSession ses = request.getSession();
        
        Date createdTime = new Date(ses.getCreationTime());
        Date lastAccessTime = new Date(ses.getLastAccessedTime());
        
        String user ="cdac";
        String title="";
        Integer visitCount = 0;
       

        if(ses.isNew()){
         title = "Welcome to site";
         out.println(title+"<br>");
         ses.setAttribute("userID", user);
        }
        else{
         user = (String)ses.getAttribute("userID");
         out.println("Welcome Back: "+user+"<br>");
         
         visitCount = (Integer)ses.getAttribute("count");
         visitCount += 1;
         out.println("Visits: "+visitCount+"<br>");
        }
        
        ses.setAttribute("count", visitCount);
        
        RequestDispatcher rd = request.getRequestDispatcher("./WelcomeServlet");
        rd.forward(request, response);
        
        //response.sendRedirect("./WelcomeServlet");
        
        out.println(createdTime+"<br>");
        out.println(lastAccessTime+"<br>");
        out.println(ses.getId());
  
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
