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
import com.entity.MechanicDtls;



@WebServlet("/UpdateMechanic")
public class UpdateMechanic  extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  try {
			  int id = Integer.parseInt(req.getParameter("id"));
			  String name = req.getParameter("name");
			  String email = req.getParameter("email");
			  String mobile1 = req.getParameter("mobile1"); 
			  String password = req.getParameter("password");
			  String area = req.getParameter("area");
			  String exprience = req.getParameter("exprience");
			  String specialist = req.getParameter("specialist");
			  String status = req.getParameter("status");
			  String map = req.getParameter("map");
			  String mobile2 = req.getParameter("mobile2");
			  
			  MechanicDtls m = new MechanicDtls();
			  m.setId(id);
			  m.setName(name);
			  m.setEmail(email);
			  m.setMobile1(mobile1); 
			  m.setPassword(password);
			  m.setArea(area);
			  m.setExprience(exprience);
			  m.setSpecialist(specialist);
			  m.setStatus(status);
			  m.setMap(map);
			  m.setMobile2(mobile2);
			
			  MechanicDAOImpl dao = new MechanicDAOImpl(DBConnect.getConn());
			  boolean f =dao.updateEditMechanic(m);
			  HttpSession session = req.getSession();
			  
			  if(f) {
				
				//  session.setAttribute(name, session);
				resp.sendRedirect("edit_dtls_mech.jsp");
				  
			  }else{
				  resp.sendRedirect("error.jsp");
			  }
			  
		  }catch(Exception e) {
			  
		  }
	}

}
