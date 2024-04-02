package com.mechanic.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.MechanicDAOImpl;
import com.DAO.ServiceUserDAOImpl;
import com.DB.DBConnect;
import com.entity.MechanicDtls;
import com.entity.ServiceUserDtls;


@WebServlet("/ServiceUserAdd")
public class ServiceUserAdd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 try { 
			 
			 
			 int mid = Integer.parseInt(req.getParameter("mid"));
			 String mname = req.getParameter("mname");
			 String  name = req.getParameter("name");
			 String  mobile = req.getParameter("mobile");
			 String service = req.getParameter("service");
			 String  location = req.getParameter("location");
			 String  status = req.getParameter("status");
			  
			 ServiceUserDtls sud = new ServiceUserDtls();
			 
			  
			 sud.setMid(mid);
			 sud.setMname(mname);
			 sud.setName(name);
			 sud.setMobile(mobile); 
			 sud.setService(service);
			 sud.setLocation(location);;
			 sud.setStatus(status);
			 
			 ServiceUserDAOImpl dao = new ServiceUserDAOImpl(DBConnect.getConn());
		   
			 boolean f = dao.addServiceUser(sud);
			HttpSession session = req.getSession();
				
				if(f) {
					resp.sendRedirect("mechanic.jsp");
				}else {
					resp.sendRedirect("error.jsp");
				} 
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}
 
}
