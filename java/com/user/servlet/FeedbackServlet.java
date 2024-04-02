package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.ServiceUserDAOImpl;
import com.DB.DBConnect;
import com.entity.FeedbackDtls;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 try { 
			 
		 
			 String name = req.getParameter("name");
			 String email = req.getParameter("email");
			 String subject = req.getParameter("subject");
			 String message = req.getParameter("message");
			  
			 FeedbackDtls fb = new FeedbackDtls();
			 
			 
			 fb.setName(name);
			 fb.setEmail(email); 
			 fb.setSubject(subject);
			 fb.setMessage(message);
			 
			 ServiceUserDAOImpl dao = new ServiceUserDAOImpl(DBConnect.getConn());
		   
			 boolean f = dao.addFeedback(fb);
			HttpSession session = req.getSession();
				
				if(f) {
					resp.sendRedirect("feedback.html");
				}else {
					resp.sendRedirect("error.jsp");
				} 
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}
 
	}
  

