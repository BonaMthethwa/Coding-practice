
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SubjectDetailsServlet")
public class SubjectDetailsServlet extends HttpServlet {

   
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String subjectName=(String)getServletContext().getAttribute("subject_name");
        String subjectCode=(String)getServletContext().getAttribute("subject_code");
        String subjectHeadName=(String)getServletContext().getAttribute("subject_head_name");
        String subjectHeadEmail=(String)getServletContext().getAttribute("subject_head_email");
        Integer numClassTests=(Integer)getServletContext().getAttribute("num_class_tests");
        Integer numSemesterTests=(Integer)getServletContext().getAttribute("num_semester_tests");
        Integer numQuizzes=(Integer)getServletContext().getAttribute("num_quizzes");
        Integer numProjects=(Integer)getServletContext().getAttribute("num_projects");
        
        System.out.println("Subject detail \n ----------------");
        System.out.println("Subject name :"+ subjectName);
        System.out.println("Subject code: "+ subjectCode);
        System.out.println("Subject head name: "+ subjectHeadName);
        System.out.println("Subject head email: "+ subjectHeadEmail);
        System.out.println("Class test: "+ numClassTests);
        System.out.println("Semester tests: "+numSemesterTests);
        System.out.println("Quizzes : "+ numQuizzes);
        System.out.println("Projrcts: "+ numProjects);
        
        
        RequestDispatcher disp=request.getRequestDispatcher("subject_details.jsp");
        disp.forward(request, response);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
}
