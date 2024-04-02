<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@page import="java.util.List"%>
    <%@ page import="com.DAO.MechanicDAOImpl "%>
    <%@ page import="com.DB.DBConnect"%>
     <%@ page import="com.entity.MechanicDtls"%>
 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
     <link rel="stylesheet" href="css_files/update.css">
     <link rel="icon" href="https://cdn-icons-png.flaticon.com/512/6823/6823491.png" sizes="100*100">
     <style>
        #select{
            width: 300px;
            height: 30px;
        }
     </style>
</head>
<body class="background">
 
    <%
       int id = Integer.parseInt(request.getParameter("id"));
       MechanicDAOImpl dao = new MechanicDAOImpl(DBConnect.getConn());
       MechanicDtls m = dao.getMechanicId(id);
       %> 
       
    <form method="Post" action="UpdateMechanic" id="login-form" class="login-form" autocomplete="off" role="main" >
        <input type="hidden" name="id" value="<%= m.getId()%>">
        <h1 class="a11y-hidden">Login Form</h1>
        <div>
          <img src="./img/<%=m.getProfile() %>" width="300" height="200">
          <label class="label-email">
            <input type="text" class="text" name="name"  value="<%= m.getName()%>"  tabindex="1" required/>
            <span class="required">Name</span>
          </label>
        </div>
      
        <div>
          <label class="label-password">
            <input type="email" class="text" name="email"   value="<%= m.getEmail()%>" tabindex="2" required />
            <span class="required">Email</span>
          </label>
        </div>
        <input type="hidden" name="mobile1" required value="<%=m.getMobile1()%>">
           
           
        <input type="hidden" name="password" required value="<%=m.getPassword()%>">
          
     
        <input type="hidden" name="area" required value="<%= m.getArea()%>">
    
    
        <input type="hidden" name="exprience" required value="<%= m.getExprience()%>">
      
 
        <input type="hidden" name="specialist" required value="<%=m.getSpecialist()%>">

        <div>
            <label class="label-password">
                  <span class="required">Status</span>
            </label>
            <select class="form-select text" name="status" id="select" aria-label="Default select example"> 
                <option value="<%= m.getStatus()%>"><%= m.getStatus()%></option>
                <%if(m.getStatus().equals("active")){ %> 
                 <option value="inactive">inactive</option>  
                <%	
                }else{%> 
                  <option value="active">active</option> 
                <%	
                }%> 
              </select>
       </div>
       
       
       <input type="hidden" name="map" required value="<%= m.getMap()%>">
             
       <input type="hidden" name="mobile2" required value="<%=m.getMobile2()%>">

    <input type="submit" value="Update" />
        
      </form>
</body>
</html>