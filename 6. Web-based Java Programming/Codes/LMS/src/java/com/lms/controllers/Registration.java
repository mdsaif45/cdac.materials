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

/**
 *
 * @author CDAC
 */
@WebServlet(name = "Registration", urlPatterns = {"/Registration"})
public class Registration extends HttpServlet {
    String name = null;
    String email = null;
    String mobile = null;
    String address = null;
    String password = null;
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          PrintWriter out = response.getWriter();
          String validationStatus = null;
          boolean insertionStatus = false;
          DBOperations dob = null;
          
          fetchRequestParameters(request);
          validationStatus = validateFormFields();
          if(validationStatus == null)
          {
              dob = new DBOperations();
              insertionStatus = dob.saveUserDetails(name, email, mobile, address, password);
              if(insertionStatus){
                  out.println("Registration is successfull");
              }else{
                  out.println("Registration is not successfull. Please contact your admin");
              }
              
          } else{
              out.print(validationStatus);
          }
    }
    
    
    private void fetchRequestParameters(HttpServletRequest request){
        name = request.getParameter("name");
        email = request.getParameter("email");
        mobile = request.getParameter("mobile");
        address = request.getParameter("address");
        password = request.getParameter("password");
    }
    
    
    private String validateFormFields(){
        if(name == null || name.isEmpty()){
            return "User Name cannot be empty";
        } else if(email == null || email.isEmpty()){
             return "Email cannot be empty";
        } else if(mobile == null || mobile.isEmpty()){
            return "Mobile number cannot be empty";
        } else if (password == null || password.isEmpty()){
            return "Password cannot be empty";
        } else if(address != null && address.length() > 250){
            return "Address exceeded the allowed limit";
        }
        return null;
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
