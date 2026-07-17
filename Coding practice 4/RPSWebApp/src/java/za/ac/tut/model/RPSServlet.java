
package za.ac.tut.model;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.web.RSPManager;


public class RPSServlet extends HttpServlet {

   
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        char userChoice=request.getParameter("choice").charAt(0);
        
        RSPManager rspm=new RSPManager();
        char computerChoice=rspm.generateSign();
        
        String outcome=rspm.determineOutcome(userChoice, computerChoice);
        request.setAttribute("outcome", outcome);
        
        RequestDispatcher disp= request.getRequestDispatcher("outcome.jsp");
        disp.forward(request, response);
     
    }

}
