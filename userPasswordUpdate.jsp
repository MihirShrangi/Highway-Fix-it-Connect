<%-- 
    Document   : changepassword
    Created on : Oct 27, 2022, 4:41:25 PM
    Author     : Priya Yadav
--%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
<link rel="icon" href="https://cdn-icons-png.flaticon.com/512/6823/6823491.png" sizes="100*100">
    </head>
    <body>
        <% 
         String email=request.getParameter("email");
         String password=request.getParameter("password");
         
try{
	Class.forName("com.mysql.jdbc.Driver");
 	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/highway-breakdown","root","MySQL@priya123");
 	PreparedStatement ps = con.prepareStatement("update user set password=? where  email=?");
 	ps.setString(2,email);
 	ps.setString(1,password);
 	
 	int i=ps.executeUpdate();
 	if(i>0){
 	response.sendRedirect("user_login.html");
      }
      else{
            response.sendRedirect("error.html");
            }
   }
   catch(Exception ex){
            }
        %>
    </body>
</html>
