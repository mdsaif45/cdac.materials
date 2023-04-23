<%-- 
    Document   : Register
    Created on : 27-Jul-2022, 1:00:54 PM
    Author     : CDAC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="common/Header.jsp" %>
        <div>
            <center>
                <h3>User Registration Form</h3>
                <form method="post" action="../Registration">
                    <input type="text" id="username" name="name" placeholder="Enter Your Name"/> <br>
                    <input type="email" id="emailID" name="email" placeholder="Enter Your Email"/> <br>
                    <input type="text" id="mobilenumber" name="mobile" placeholder="Enter Your Mobile Number"/> <br>
                    <textarea id="address" name="address"> </textarea> <br>
                    <input type="password" id="userpwd" name="password" placeholder="Enter Your Password"/> <br>
                    <input type="password" id="confruserpwd" name="confpassword" placeholder="Enter Your confirm Password"/> <br><br>
                    <button type="submit" id="regBtn" value="Register">Register</button> 
               </form>
            </center>          
        </div>
        <%@include file="common/Footer.jsp" %>
    </body>
</html>
