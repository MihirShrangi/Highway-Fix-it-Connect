  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
%> 
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mechanic Dashboard</title>

<link rel="icon" href="https://cdn-icons-png.flaticon.com/512/6823/6823491.png" sizes="100*100">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
 
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
 .container .row  .col-md-3 a{ 
    text-decoration: none;
    color:black;
}

.row {
 margin-left: 150px;
 }

   .background{
        background-image: url('https://64.media.tumblr.com/522a4d28f8e713bad2888b5a4affb527/7f57226e37b18bb3-4d/s400x600/a1482148fb3a1de2ed74dbd9f034a163a046bfaf.gifv');
        background-repeat: no-repeat;
        height: 100vh;
      width: 100%;
   background-attachment: fixed;
    background-size: 100% 100%;
    }
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
 </style>
</head>
<body >
    <div class="navbar">
        <div class="label">Highway Fix it <span style="color:red;"> & Connect</span></div>
        <div class="attributes">
            <a href="mechanic_index.html">HOME</a>
           <a href="feedback_mechanic.html">FEEDBACK</a>
            <a href="FAQ.html">FAQ</a>
            <a href="contact.html">CONTACT</a>
            <a href="mechanic.jsp">ACCOUNT</a>
        </div>
    </div> 
    <div class="background">
        <br> <br>  
    <h1 class=" text-center">Welcome</h1>
    <h2 class=" text-center" >Mechanic: <%=session.getAttribute("name")%></h2> 
<div>
 <div class="container">
    <div class="row p-5">
      <div class="col-md-3">
        <a href="service_user.jsp">
            <div class="card">
                <div class="card-body text-center">
                <i class="fa-solid fa-user-plus fa-3x text-primary"></i>
                <h4>Add User</h4>
                </div>
            </div>
        </a>
      </div>

      <div class="col-md-3">
        <a href="user_view_history.jsp?id=<%=session.getAttribute("id")%>">
            <div class="card">
                <div class="card-body text-center">
                <i class="fa-solid fa-users-viewfinder fa-3x text-warning"></i>
                <h4>View history</h4>
                </div>
            </div>
        </a>
      </div> 
      
      <div class="col-md-3">
        <a href="./Logout">
            <div class="card">
                <div class="card-body text-center">
                <i class="fa-solid fa-arrow-right-from-bracket fa-3x text-primary"></i>
                <h4>Logout</h4>
                </div>
            </div>
        </a>
      </div>
    </div>
 </div>
 </div>
 </div>
</body>
</html>