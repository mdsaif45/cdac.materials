<%-- 
    Document   : Login
    Created on : 27-Jul-2022, 3:19:48 PM
    Author     : CDAC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function verifyEmail(){
                var emailID = document.getElementById("emailID").value;
                if(emailID === "" || emailID === " "){
                    alert("Please enter your email");
                    return false;
                }
               return true;
            }
            function verifyPassword(){
                var pwd = document.getElementById("userpwd").value;
                if(pwd === "" || pwd === " "){
                    alert("Please enter the password");
                    return false;
                } else if(pwd.length < 6){
                    alert("Please enter the password with minimum 6 chars");
                    return false;
                }
               return true;
            }
            function verifyALL(){
                if(verifyEmail() && verifyPassword()){
                    document.getElementById("loginForm").submit();
                }
                return false;
            }
        </script>
    </head>
    <body>
        <%@include file="common/Header.jsp" %>
        <div>
            <center>
                <h3>User Login Form</h3>
                <form id="loginForm" method="post" action="../Authentication">                    
                    <input type="email" id="emailID" name="email" placeholder="Enter Your Email"/> <br>                    
                    <input type="password" id="userpwd" name="password" placeholder="Enter Your Password"/> <br>                    
                    <button type="button" id="logBtn" onclick="verifyALL()" value="Register">Login</button> 
               </form>
            </center>          
        </div>
        <%@include file="common/Footer.jsp" %>
    </body>
</html>
