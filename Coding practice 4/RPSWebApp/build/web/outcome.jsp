
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RSP OUTCOME</title>
    </head>
    <body>
        <h1>RSP OUTCOME</h1>
        <%
            String playerName=pageContext.getServletContext().getInitParameter("player_name");
            String computerName=pageContext.getServletContext().getInitParameter("computer_name");
            Character playerChoice=(Character)request.getAttribute("player_choice");
            Character computerChoice=(Character)request.getAttribute("computer_choice");
            
        %>
        
        <p>
            below is the game outcome
        </p>
        <table>
            <tr>
                <td><b><%=playerName%></b></td>
                <td><%=playerChoice%></td>
            </tr>
             <tr>
                <td><b><%=computerName%></b></td>
                <td><%=computerChoice%></td>
            </tr>
            <p>
                Please click <a href="index.html">here</a> to go back to main page or
                <a href="start.jsp">here </a> to continue playing
            </p>
        </table>
    </body>
</html>
