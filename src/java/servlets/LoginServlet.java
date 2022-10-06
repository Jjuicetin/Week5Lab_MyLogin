
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             HttpSession session = request.getSession(); 
          getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //validate textboxes
        if(username == null || username.equals("") || password == null || password.equals("") ){
            
              request.setAttribute("username", username);
              request.setAttribute("password", password);
             request.setAttribute("invalid", true);
             
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
        }
    }
}
