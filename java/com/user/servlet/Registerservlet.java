

package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UserDAOImpl;
import com.entity.User;
 

/**
 *
 * @author Priya Yadav
 */
@WebServlet("/Registerservlet")
public class Registerservlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException   {
    	Random rand = new Random();
		 
        PrintWriter pw = response.getWriter();
        try
        {
          String name = request.getParameter("name");
          String email = request.getParameter("email");
          String password = request.getParameter("password");
          String mobile = request.getParameter("mobile");
          String role = "User";    
         
          System.out.println(name+" : "+email+" : "+password+" : "+mobile+" : "+role);
          
          User user = new User(name, email,password,mobile,role);
          UserDAOImpl uc = new UserDAOImpl();
       boolean res = uc.insertUser(user);
       if(res)
       {
           System.out.println("Data Inserted...");
           response.sendRedirect("user_login.html");
       }
       else
       {
           System.out.println("Data Not Inserted...");
           response.sendRedirect("user_registration_error.html");
       }
        
        }
        catch(Exception ex)
        {
            System.out.println("Register Servlet : "+ex.toString());
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
