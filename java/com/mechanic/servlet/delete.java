package com.mechanic.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.MechanicDAOImpl;
import com.DB.DBConnect;

@WebServlet("/delete")
public class delete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 try {
			 
			 int id = Integer.parseInt(req.getParameter("id"));
			 
			 MechanicDAOImpl dao = new MechanicDAOImpl(DBConnect.getConn());
			 boolean f = dao.deleteMechanic(id);
			 HttpSession session = req.getSession();
			  
			  if(f) {
				
				//  session.setAttribute(name, session);
				resp.sendRedirect("edit_dtls_mech.jsp");
				  
			  }else{
				  resp.sendRedirect("error.jsp");
			  }
			  
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}
   
	
}
