<%-- 
    Document   : stats
    Created on : 13 Jun 2024, 7:38:42 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stats  Page</title>
    </head>
    <body>
        <h1>Stats</h1>
        <%
            Long numF=(Long)request.getAttribute("numF");
            Long numM=(Long)request.getAttribute("numM");
        %>
        <p>
            F: <%=numF%>
            <br>
            M:<%=numM%>
        </p>
    </body>
</html>
