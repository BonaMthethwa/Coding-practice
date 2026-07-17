<%-- 
    Document   : start
    Created on : 26 Feb 2024, 1:06:51 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start Page</title>
    </head>
    <body>
        <h1>Start</h1>
        
        <%
            String playerName=pageContext.getServletContext().getInitParameter("player_name");
            String computerName=pageContext.getServletContext().getInitParameter("computer_name");
        %>
        
        <p>
            Hi! <%=playerName%>, My name is <%=computerName%>, your playmate. Let's start the game.
        </p>
        
        <form action="RSPServlet.do" method="POST">
            <table>
                <tr>
                    <td>Make a choice :</td>
                    <td>
                        <select name="Choce" required="">
                            <option value="R">Rock</option>
                            <option value="P">Paper</option>
                            <option value="S">Scissor</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="PLAY"</td>
                </tr>
            </table>
        </form>
    </body>
</html>
