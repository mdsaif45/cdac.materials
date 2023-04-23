<%-- 
    Document   : Books
    Created on : 27-Jul-2022, 4:59:50 PM
    Author     : CDAC
--%>

<%@page import="com.lms.pojo.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.lms.db.DBOperations"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    DBOperations dop = new DBOperations();
    List<Book> books = dop.getBookDetails();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu/MenuPage.jsp" %>
    <center>
        <table style="border-style: dashed">
            <thead>
                <tr>
                    <th>SNo</th>
                    <th>Book Name</th>
                    <th>Author</th>
                    <th>Publisher</th>
                </tr>
                <%
                    if (books.size() > 0) {
                        for (Book bk1 : books) {
                %>
                <tr>
                    <td><%=bk1.getId()%></td>
                    <td><%=bk1.getName()%></td>
                    <td><%=bk1.getAuthor()%></td>
                    <td><%=bk1.getPublisher()%></td>             
                </tr>                
                <% }
         } else {%>
                No books were available.
                <% }%>
        </table>
    </center>


</body>
</html>
