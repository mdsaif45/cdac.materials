<%-- 
    Document   : Welcome
    Created on : 27-Jul-2022, 4:13:08 PM
    Author     : CDAC
--%>

<%@page import="com.lms.pojo.User"%>
<%@page import="com.lms.db.DBOperations"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
  String email = (String)session.getAttribute("emailID");
  DBOperations dop = new DBOperations();
  User user1 = dop.getSelectedUserDetails(email);
  //String[] details = value.split("\\$");   
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu/MenuPage.jsp" %>
        <div>
            <center>
                <h3>User Profile Form</h3>
                <form method="post" action="">
                    <input type="text" id="username" name="name" value="<%=user1.getName()%>" placeholder="Enter Your Name"/> <br>
                    <input type="email" id="emailID" name="email" value="<%=email%>" readonly="" placeholder="Enter Your Email"/> <br>
                    <input type="text" id="mobilenumber" name="mobile" value="<%=user1.getMobile()%>" placeholder="Enter Your Mobile Number"/> <br>
                    <textarea id="address" name="address"><%=user1.getAddress()%></textarea> <br>                    
                    <button type="submit" id="updBtn" value="update">Update</button> 
               </form>
            </center>          
        </div>
    </body>
</html>
