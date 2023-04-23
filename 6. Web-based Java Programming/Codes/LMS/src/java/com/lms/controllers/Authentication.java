/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.lms.controllers;

import com.lms.db.DBOperations;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CDAC
 */
@WebServlet(name = "Authentication", urlPatterns = {"/Authentication"})
public class Authentication extends HttpServlet {
    String email;
    String password;
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String validationStatus = null;
        boolean verificationStatus = false;        
        PrintWriter out = response.getWriter();
        DBOperations dob = null;
        HttpSession session = null;        
        fetchFormFields(request);
        
        validationStatus = validateFormFields();
        if(validationStatus == null){
            dob = new DBOperations();
            verificationStatus = dob.verifyUserLoginDetails(email, password);
            if(verificationStatus){
                // first time it will create the session and return                 
                session = request.getSession(true);
                session.setAttribute("emailID", email);
                response.sendRedirect("Welcome");
                //request.getRequestDispatcher("Welcome").forward(request, response);
            }
            else{
//                request.setAttribute("msg", "Invalid Login Details");
//                request.getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
                
                out.println("Invalid login details. Please <a hre='/jsp/Login.jsp'>click here</a> to login again");
            }
        }else{
            out.print(validationStatus);
        }        
    } 
    

    private void fetchFormFields(HttpServletRequest request){
        email = request.getParameter("email");
        password = request.getParameter("password");
    }
    
    private String validateFormFields()
    {
        if(email == null || email.isEmpty()){
             return "Email cannot be empty";
        }else if (password == null || password.isEmpty()){
            return "Password cannot be empty";
        } 
        return null;        
    }
    
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
