 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@page import="java.util.List"%>
    <%@ page import="com.DAO.MechanicDAOImpl "%>
    <%@ page import="com.DB.DBConnect"%>
     <%@ page import="com.entity.MechanicDtls"%>
 
  <!DOCTYPE html>
 
  <html lang="en" dir="ltr">
    <head>
      <meta charset="utf-8">
      <title>Service user</title>
        <link rel="stylesheet" href="css_files/suforms.css">
    </head> 
    <body>
  <div class="wave"></div>
      <div class="center">
        <h1>Service</h1>
        <form action="ServiceUserAdd" method="post"> 
         <input type="hidden" name="mid" value=<%=session.getAttribute("id")%>>  
         <input type="hidden" name="mname" value=<%=session.getAttribute("name") %>>   
          <div class="txt_field">
              <input type="text" name="name" autocomplete="off" required>
            <span></span>
            <label>Enter user name</label>
          </div>
  
          <div class="txt_field">
            <input type="text" name="mobile" autocomplete="off" required>
          <span></span>
          <label>User mobile</label>
        </div>
        <div class="txt_field">
            <input type="text" name="service" autocomplete="off" required>
          <span></span>
          <label>Service</label>
        </div>
     
        <div class="txt_field">
            <input type="text" name="location" autocomplete="off" required>
          <span></span>
          <label>Enter  location</label>
        </div>
        
         <div class="txt_field">
            <input type="text" name="status" autocomplete="off" required>
          <span></span>
          <label>Service status</label>
        </div>
          <div class="pass"></div>
          <input type="submit" value="Add">
          <div class="pass"></div>
        </form>
      </div>
  
    </body>
  </html>