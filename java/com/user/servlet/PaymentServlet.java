package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.ServiceUserDAOImpl;
import com.DAO.UserDAOImpl;
import com.DB.DBConnect;
import com.entity.FeedbackDtls;
import com.entity.Payment;


@WebServlet("/payment")
public class PaymentServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try { 
			 
			 
			 String cno = req.getParameter("cno");
			 String cname = req.getParameter("cname");
			 String expirem = req.getParameter("expirem");
			 String expirey = req.getParameter("expirey");
			 String cvv = req.getParameter("cvv");
			 String amount = req.getParameter("amount");
			  
			  Payment p = new Payment();
			 
			 p.setCno(cno);
			 p.setCname(cname);
			 p.setExpirem(expirem);
			 p.setExpirey(expirey);
			 p.setCvv(cvv);
			 p.setAmount(amount);
			 
			 UserDAOImpl dao = new  UserDAOImpl();
		   
			 boolean f = dao.addPayment(p);
			HttpSession session = req.getSession();
				
				if(f) { 
					resp.sendRedirect("thanks.html");
				}else {
					resp.sendRedirect("error.html");
				} 
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}
}
 


