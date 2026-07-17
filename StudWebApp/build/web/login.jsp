<%-- 
    Document   : login
    Created on : 13 Jun 2024, 12:14:56 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login </h1>
        <form action="j_security_check" method="POST">
        
        <table>
           
            
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="j_username"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="text" name="j_password"/></td>
                </tr>
                <tr>
                        <td></td>
                        <td><input type="submit" value="SEARCH STUDENT"/></td>
                    </tr>
           
        </table>
        </form>
    </body>
</html>
