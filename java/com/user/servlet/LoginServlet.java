/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAOImpl;
import com.entity.User;
import com.utils.SystemConstants;
 
/**
 *
 * @author Priya Yadav
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  
    {
         PrintWriter pw = response.getWriter();
         try
         {
           String email = request.getParameter("email");
           String password = request.getParameter("password");
           HttpSession session = request.getSession();
         
           
           System.out.println(email+" : "+password);
           UserDAOImpl uc = new UserDAOImpl();
           User u = uc.loginUser(email, password);
           if(u != null)
           {
            
               
               if(u.getRole().equals(SystemConstants.ADMIN))
              {
                  
                   response.sendRedirect("admin_index.html"); 
                   session.setAttribute("name", u.getName()); 
                 
                }
              if(u.getRole().equals(SystemConstants.USER))
              {
                
                response.sendRedirect("user_index.html");    
                session.setAttribute("name", u.getName());
                session.setAttribute("mobile", u.getMobile());
                session.setAttribute("id", u.getId());
               
              }
          }
          else
          {
             response.sendRedirect("error.html");
          }
           
         }
         catch(Exception ex)
         {
             System.out.println("Login Servlet Called..."+ex.toString());
         }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
