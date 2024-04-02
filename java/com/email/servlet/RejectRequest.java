package com.email.servlet;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/RejectRequest")

public class RejectRequest extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		RequestDispatcher dispatcher = null;
		int otpvalue = 0;
		//String content = "Request Rejected";
		 String message1="" +
				 "<div style='border:1px solid #e2e2e2; padding:20px'>"+ 
			       "<h3>"+
			       "<b style='color:red;'>"+"We appreciate your recent request however, after careful consideration, we regret to inform you that your request has been rejected &#10060;" 
			       		+ 
			       "</h3>"+ 
			       "<p>"+"If you have any questions or require further clarification regarding the rejection, please do not hesitate to reach out to us at fixit&connect@gmail.com. We value your understanding and appreciate your interest in Highway Fix it & Connect."+"</P>"+
			       "</div>";
		HttpSession mySession = request.getSession();
		
		if(email!=null || !email.equals("")) {
			 
			String to = email;// change accordingly
			// Get the session object
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("highwayfixitconnect@gmail.com", "yejfxuyyxkyuskvx"); 							// id and
																									// password here
				}
			});
			// compose message
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(email));// change accordingly
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject("Request status");
				message.setContent(message1,"text/html");
//				message.setText();
				// send message
				Transport.send(message);
				System.out.println("message sent successfully");
			}

			catch (MessagingException e) {
				throw new RuntimeException(e);
			}
	    
			dispatcher = request.getRequestDispatcher("edit_dtls_mech.jsp");
			request.setAttribute("message","OTP is sent to your email id");
			//request.setAttribute("connection", con);
		//	mySession.setAttribute("otp",otpvalue); 
			mySession.setAttribute("email",email); 
			dispatcher.forward(request, response);
			//request.setAttribute("status", "success");
		}
		
	}
}
