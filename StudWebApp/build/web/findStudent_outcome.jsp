<%-- 
    Document   : findStudent_outcome
    Created on : 12 Jun 2024, 11:47:09 PM
    Author     : User
--%>

<%@page import="java.util.Base64"%>
<%@page import="za.ac.tut.model.entities.Image"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entities.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Student Outcome Page</title>
    </head>
    <body>
        <h1>Search Student</h1>
        <%
            Student stud=(Student)request.getAttribute("student");
            List<Image> images=stud.getImages();
        %>
        <p>
            Student searched is :
            <br>
            Student name:<b><%=stud.getName()%></b>
            <br>
            Student surname:<b><%=stud.getSurname()%></b>
            <br>
            Student DOB:<b><%=stud.getDob()%></b>
            <br>
            Student gender: <b><%=stud.getGender()%></b>
            <br>
            
            <%
                for(int x=0;x<images.size();x++){
                  
                  String imgName=images.get(x).getName();
                  String img_src="data:image/jpg;64,"+Base64.getEncoder().encodeToString(images.get(x).getImage());
                  %>
                 Student image:
                 <br>
                 <img src=<%=img_src%> alt="<%=imgName%>" width="200px" height="200px">
                  <%
                }
            %>
        </p>
    </body>
</html>
