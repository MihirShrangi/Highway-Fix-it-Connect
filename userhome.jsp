 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 //response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
%> 
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>

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
 .container .row  .col-md-3 a{ 
    text-decoration: none;
    color:black;
}

.row {
 margin-left: 150px;
 }

 .background{
        background-image: url('https://media.tenor.com/jSVAGGvntNkAAAAC/road-sunset.gif');
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
        
.button-viewUser {
  background-color: white;
  border-width: 0;  
  border: none; 
}
.card{
max-height:90%;
}

 </style>
</head>
<body > 
    <div class="navbar">
        <div class="label">Highway Fix it <span style="color:red;"> & Connect</span></div>
        <div class="attributes">
            <a href="user_index.html">HOME</a>
            <a href="services.html">SERVICES</a>
            <a href="feedback_user.html">FEEDBACK</a> 
            <a href="contact.html">CONTACT</a>
            <a href="userhome.jsp">ACCOUNT</a>
        </div>
    </div>
    <div class="background">
        <br><br>
        <h1 class=" text-center">Welcome</h1>
    <h2 class=" text-center" >User:<%=session.getAttribute("name")%></h2>
    <h2 class=" text-center" >Mobile:<%=session.getAttribute("mobile")%></h2>
    <div>
        <div class="container">
            <div class="row p-5"> 
              <div class="col-md-3">
             
                    <div class="card">
                        <div class="card-body text-center">
                        <i class="fa-solid fa-users-viewfinder fa-3x text-warning"></i>
                        <form action="mechanic_view_history.jsp" Method="POST">
                        <input type="hidden" name="mobile"  value="<%=session.getAttribute("mobile")%>">
                    	<button class="button-viewUser" ><h4>History</h4></button>
                		</form>
                        <h4></h4>
                        </div>
                    </div>
                </a>
              </div> 
              
               <div class="col-md-3">
                <a href="https://buy.stripe.com/test_9AQ2bB2ty0OXcTu5kI">
                    <div class="card">
                        <div class="card-body text-center">
                          <i class="fa-solid fa-money-check  fa-3x text-success"></i>
                        <h4>Payment</h4>
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
</body>
</html>