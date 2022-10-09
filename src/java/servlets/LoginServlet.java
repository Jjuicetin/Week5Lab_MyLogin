
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.AccountService;
import service.User;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             HttpSession session = request.getSession();
             String logout = request.getParameter("logout");
             User user = (User) session.getAttribute("user");
             
             //if we press the link 
             if (logout != null) {
                 session.invalidate();
                 request.setAttribute("message", "logout successful.");
                 getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                 
             } 
             //if user is already in session
             else if (user != null) {
                 response.sendRedirect("home");
             } 
             //toss the user back if he is null (ugh xenophobic)
             else {
                 getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);        
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //cookie
        HttpSession session = request.getSession();
       
        
        //textbox entries
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
        
        //login verification accountservice to access login method
        AccountService as = new AccountService();
        
        User user = as.login(username, password);
        session = request.getSession(); //new cookie
        
           //user passes the login check. 
        if(user != null){
            session.setAttribute("user", user);
            response.sendRedirect("home");
        }
    }
}
