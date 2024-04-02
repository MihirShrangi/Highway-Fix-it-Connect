<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@ page import="com.DAO.MechanicDAOImpl "%>
    <%@ page import="com.DB.DBConnect"%>
     <%@ page import="com.entity.MechanicDtls"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mechanic Details</title>

<link rel="icon" href="https://cdn-icons-png.flaticon.com/512/6823/6823491.png" sizes="100*100">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" /> 
	<style>
 /* Style the navbar */
     .navbar {
            overflow: hidden;
            background-color: #ffffff;
            margin-top: 20px ;
            font-family: 'Poppins', sans-serif;
        }

        /* Left-aligned label */
        .label {
            float: left;
            font-size: 20px;
            color: rgb(0, 0, 0);
            padding: 4px 86px;
            font-weight: bolder;
             margin-left: 5%;
        }
       

        /* Right-aligned attributes */
        .attributes {
            float: right;
            margin-right: 10%;
        }

        /* Style for attribute links */
        .attributes a {
            font-size: 14px;
            color: #859098;
            font-weight: 500;
            text-align: center;
              padding: 35px 10px;
            text-decoration: none;
            margin-right: 30px;
        }
        
         .table  {
            margin-left: 1.5%;
            margin-right: 10%;
            max-width: 97%;
        }

.table th {
    padding: 0.5rem;
    vertical-align: top;
    border-top: 1px solid #dee2e6;
}

.table td {
    padding: 0.4rem;
    vertical-align: top;
    border-top: 1px solid #dee2e6;
}
        #request{
            display: flex;
            margin-left: 6%;
        }
        #rej{
            float: right; 
        }
        #acp{
            float: left; 
        }
        
         img:hover{
            transform: scale(1.1);
        }
        
        .button {
  background-color: #04AA6D;
  border: none;
  color: white;
  padding: 10px 30px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  margin-left:3%;
  cursor: pointer;
}
</style>
	 
</head>
<body> 
<div class="navbar">
        <div class="label">Highway Fix it <span style="color:red;"> & Connect</span></div>
        <div class="attributes">
          <a href="admin_index.html">HOME</a>
        <a href="service_admin.html">SERVICES</a>
        <a href="feedback.html">FEEDBACK</a>
        <a href="contact.html">CONTACT</a>
        <a href="adminHome.jsp">ACCOUNT</a>
        </div>
    </div>
   
    <form action="edit_dtls_mech.jsp" class="text-center">
        <input type="text" placeholder="Search by name" name="name" required>
        <button type="submit"><i class="fa fa-search"></i></button>
      </form>
      <br>
   
 <table class="table table-striped text-center">
  <thead class="bg-primary">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Govt id</th>
       <th scope="col">Profile</th>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">Mobile1</th>
       <th scope="col">Mobile2</th>
      <th scope="col">Area</th>
      <th scope="col">Exprience</th>
       <th scope="col">Specialist</th>
        <th scope="col">Status</th>
         <th scope="col">Map</th>
      <th scope="col">Action</th>
       <th scope="col">Request</th>
    </tr>
  </thead>
  <tbody>
   <tbody>
 
  <% 
  if(request.getParameter("name")!=null){
  String name = request.getParameter("name");
  MechanicDAOImpl dao = new MechanicDAOImpl(DBConnect.getConn());
   List<MechanicDtls> list = dao.getAllMechanicsByName(name);
   for(MechanicDtls m : list){
 %>
 <tr>
      <td><%=m.getId() %></td>
      <td> <img src="./gov.id/<%=m.getGovt_id() %>" style="width:50px; height:50px;"> </td>
      <td> <img src="./img/<%=m.getProfile() %>" style="width:50px; height:50px;"> </td>
      <td><%=m.getName() %></td>
      <td><%=m.getEmail() %></td>
       <td><%=m.getMobile1() %></td> 
         <td><%=m.getMobile2() %></td> 
      <td><%=m.getArea() %></td>
       <td><%=m.getExprience() %></td>
       <td><%=m.getSpecialist() %></td>
       <td><%=m.getStatus() %></td>
      <td><a href="<%=m.getMap()%>" target="_blank">Map</a></td>  
      <td>
      <a href="update.jsp?id=<%= m.getId()%>" class="btn btn-sm btn-info"><i class="fa-sharp fa-solid fa-pen-to-square"></i>Edit</a>
      
      <a href="delete?id=<%= m.getId()%>" class="btn btn-sm btn-secondary"><i class="fa-solid fa-trash"></i> Delete</a>
      </td>
      <td id="request">
    <form action="AcceptRequest" method="post">
  	<input type="hidden"  name="email" value="<%= m.getEmail()%>" class="form-control" placeholder="Mechanic Email" >
   	<button type="submit" class="btn btn-sm btn-success" id="acp"><i class="fa-solid fa-check"></i> Accept</button> 
	</form>
	<pre></pre>
    <form action="RejectRequest" method="post"> 
   <input type="hidden"  name="email" value="<%= m.getEmail()%>"  class="form-control" placeholder="Mechanic Email" > 
   <button type="submit" class="btn btn-sm btn-danger" id="rej"><i class="fa-solid fa-xmark"></i> Reject</button> 
	</form>
    </td>
    </tr> 
 <%
   }
  %>
  
 </tbody>
 
  <%
  }else{ 
  MechanicDAOImpl dao1 = new MechanicDAOImpl(DBConnect.getConn());
   List<MechanicDtls> list1 = dao1.getAllMechanics();
   for(MechanicDtls m : list1){
 %>
 <tr>
      <td><%=m.getId() %></td>
      <td><img src="./gov.id/<%=m.getGovt_id() %>" style="width:50px; height:50px;"></td>
       <td> <img src="./img/<%=m.getProfile() %>" style="width:50px; height:50px;"> </td>
      <td><%=m.getName() %></td>
      <td><%=m.getEmail() %></td>
       <td><%=m.getMobile1() %></td> 
         <td><%=m.getMobile2() %></td> 
      <td><%=m.getArea() %></td>
       <td><%=m.getExprience() %></td>
       <td><%=m.getSpecialist() %></td>
       <td><%=m.getStatus() %></td>
      <td><a href="<%=m.getMap()%>" target="_blank">Map</a></td>  
      <td>
      <a href="update.jsp?id=<%= m.getId()%>" class="btn btn-sm btn-info"><i class="fa-sharp fa-solid fa-pen-to-square"></i>Edit</a>
      <a href="delete?id=<%= m.getId()%>" class="btn btn-sm btn-secondary"><i class="fa-solid fa-trash"></i> Delete</a>
      </td>
      <td id="request">
    <form action="AcceptRequest" method="post">
  	<input type="hidden"  name="email" value="<%= m.getEmail()%>" class="form-control" placeholder="Mechanic Email" >
   	<button type="submit" class="btn btn-sm btn-success" id="acp"><i class="fa-solid fa-check"></i> Accept</button> 
	</form>
	<pre> </pre>
    <form action="RejectRequest" method="post"> 
   <input type="hidden"  name="email" value="<%= m.getEmail()%>"  class="form-control" placeholder="Mechanic Email" > 
   <button type="submit" class="btn btn-sm btn-danger" id="rej"><i class="fa-solid fa-xmark"></i> Reject</button> 
	</form>
    </td>
    </tr> 
 <%
   }
  }
  %>
 
 </tbody>
  
 
</table>
 
 
 <!-- 
<div class="container">
 <div class="row">
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <form action="AcceptRequest" method="post">
<div class="input-group mb-2">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">@</span>
  </div>
  <input type="email"  name="email" class="form-control" placeholder="Mechanic Email" >
</div>
   <button type="submit" class="btn btn-success"><i class="fa-solid fa-check"></i> Accept</button> 
</form>
 
      </div>
    </div>
  </div>
 <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <form action="RejectRequest" method="post">
	<div class="input-group mb-2">
  	<div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">@</span>
 	 </div>
 	 <input type="email"  name="email" class="form-control" placeholder="Mechanic Email" >
	</div>
   <button type="submit" class="btn btn-danger"><i class="fa-solid fa-xmark"></i> Reject</button> 
	</form>
      </div>
    </div> 
  </div>
</div>
</div>
 --->
</body>
</html>