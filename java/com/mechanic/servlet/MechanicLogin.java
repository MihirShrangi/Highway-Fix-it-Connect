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


@WebServlet("/MechanicLogin")
public class MechanicLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 try {
			 
	    MechanicDAOImpl dao = new MechanicDAOImpl(DBConnect.getConn());
	    HttpSession session = req.getSession();
			 
		String email = req.getParameter("email");
		String password = req.getParameter("password");
	//		System.out.println(email + " "+password);
 
			MechanicDtls mds =	dao.login(email, password);
			
			if(mds!=null && mds.getStatus().equals("active")) {
			 
				resp.sendRedirect("mechanic_index.html");
				session.setAttribute("mechnicobj", mds);
				session.setAttribute("name", mds.getName());
				session.setAttribute("email", mds.getEmail());
				session.setAttribute("id", mds.getId());

			}else if(mds!=null && mds.getStatus().equals("inactive")){
			  
				resp.sendRedirect("process.jsp");
			}else {
				resp.sendRedirect("error.html");
			}
		 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}

}
