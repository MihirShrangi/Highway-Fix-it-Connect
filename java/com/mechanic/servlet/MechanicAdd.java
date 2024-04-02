package com.mechanic.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.MechanicDAOImpl;
import com.DB.DBConnect;
import com.entity.MechanicDtls;


@WebServlet("/MechanicAdd")
@MultipartConfig
public class MechanicAdd extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 try {
			 
			 String name = req.getParameter("name");
			 String email = req.getParameter("email");
			 String mobile1 = req.getParameter("mobile1");
			 String password = req.getParameter("password");
			 String area = req.getParameter("area");
			 String exprience = req.getParameter("exprience");
			 String specialist = req.getParameter("specialist");
			 String status = req.getParameter("status");
			 Part part = req.getPart("govt_id");
			 String fileName = part.getSubmittedFileName(); 
			 Part part1 = req.getPart("profile");
			 String fileName1 = part1.getSubmittedFileName();
		//	 MechanicDtls b = new MechanicDtls(name,email,mobile,password,area,exprience,fileName);
			 String map = req.getParameter("map");
			 String mobile2 = req.getParameter("mobile2");
			 MechanicDtls b = new MechanicDtls();
			 b.setName(name);
			 b.setEmail(email);
			 b.setMobile1(mobile1);
			 b.setPassword(password);
			 b.setArea(area);
			 b.setExprience(exprience);
			 b.setSpecialist(specialist);
			 b.setStatus(status);
			 b.setGovt_id(fileName);
			 b.setProfile(fileName1);
			 b.setMap(map);
			 b.setMobile2(mobile2);
			 MechanicDAOImpl dao = new MechanicDAOImpl(DBConnect.getConn());
		
			boolean f = dao.addMechanic(b);
			
			HttpSession session = req.getSession();
			
			if(f) { 
				
				 String path = getServletContext().getRealPath("")+"gov.id";  
			     System.out.println(path);
				 File file = new File(path);
				 part.write(path + File.separator + fileName);
				 
				 String path1 = getServletContext().getRealPath("")+"img";
				  System.out.println(path1);
				  File file1 = new File(path1);
				  part1.write(path1 + File.separator + fileName1);
				  
			resp.sendRedirect("mechanic_login.html");
		}else {
			 
			resp.sendRedirect("index.jsp");
		}
			
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}
	
	

}
