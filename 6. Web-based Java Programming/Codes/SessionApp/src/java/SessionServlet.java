
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/SessionServlet"})
public class SessionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
           
        HttpSession ses = request.getSession();
        Date createdTime = new Date(ses.getCreationTime());
        Date lastAccessed = new Date(ses.getLastAccessedTime());
        
        String user = request.getParameter("t1");
        
        Integer visitCount = 0;
        String title = "";
        
        if(ses.isNew()){
            title = "Welcome to the site!";
            out.println(title+"<br>");
            ses.setAttribute("userID", user); // 
        }
        else{
            user =(String)ses.getAttribute("userID");
            out.println("Welcome Back "+user+"<br> ");
            visitCount =(Integer) ses.getAttribute("count");
            visitCount += 1;
            out.println("No of visists "+visitCount+"<br>");
        }
        
        ses.setAttribute("count", visitCount);
        
        RequestDispatcher rd = request.getRequestDispatcher("./WelcomeServlet");
        rd.forward(request, response);
        
        out.println("Session ID "+ses.getId()+"<br>");
        out.println("Session Creation time "+ createdTime+"<br>");
        out.println("Last Accessed time "+ lastAccessed+"<br>");
        }
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
