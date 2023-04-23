<%-- 
    Document   : Welcome
    Created on : 27-Jul-2022, 4:13:08 PM
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
        <%@include file="menu/MenuPage.jsp" %>
        
        <center>
            Welcome <%=session.getAttribute("emailID")%> to LMS
        </center>
</body>
</html>
