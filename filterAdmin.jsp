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
<title>Search Result</title>

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

   
    <!--font-family-->
		<link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
 <link rel="stylesheet" href="css_files/search.css">
 
 <style>
 .card {
  box-shadow: 0 6px 10px 0 rgba(0,0,0,0.4);
  transition: 0.3s;
   border-radius: 20px;
  
}
 	.card  {
	margin-top:2%;
	}
	.button-filter {
  align-self: center;
  height: 25px; width: 100px;
  background-color: #fff;
  background-image: none;
  background-position: 0 80%;
  background-repeat: repeat no-repeat;
  background-size: 4px 3px;
  border-radius: 15px 225px 255px 15px 15px 255px 225px 15px;
  border-style: solid;
  border-width: 2px;
  box-shadow: rgba(0, 0, 0, .2) 15px 28px 25px -18px;
  box-sizing: border-box;
  color: #41403e;
  cursor: pointer;
  display: inline-block;
  font-family: Neucha, sans-serif;
  font-size: 1rem;
  line-height: 23px;
  outline: none;
  padding: .12rem;
  text-decoration: none;
  transition: all 235ms ease-in-out;
  border-bottom-left-radius: 15px 255px;
  border-bottom-right-radius: 225px 15px;
  border-top-left-radius: 255px 15px;
  border-top-right-radius: 15px 225px;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  margin-left:1%;
}

.button-filter:hover {
  box-shadow: rgba(0, 0, 0, .3) 2px 8px 8px -5px;
  transform: translate3d(0, 2px, 0);
}

.button-filter:focus {
  box-shadow: rgba(0, 0, 0, .3) 2px 8px 4px -6px;
}

.custom-btn {
  width: 130px;
  height: 40px;
  color: black;
  border-radius: 5px;
  padding: 10px 25px;
  font-family: 'Lato', sans-serif;
  font-weight: 500;
  background: transparent;
  cursor: pointer;
  transition: all 0.3s ease;
  position: relative;
  display: inline-block;
   box-shadow:inset 2px 2px 2px 0px rgba(236, 29, 29, 0.5),
   7px 7px 20px 0px rgba(0,0,0,.1),
   4px 4px 5px 0px rgba(0,0,0,.1);
  outline: none;
}
/* 3 */
.btn-3 {
  background: red;
background: linear-gradient(0deg, white 0%, white 100%);
  width: 130px;
  height: 40px;
  line-height: 42px;
  padding: 0;
  border: none;
  
}
.btn-3 span {
  position: relative;
  display: block;
  width: 100%;
  height: 100%;
}
.btn-3:before,
.btn-3:after {
  position: absolute;
  content: "";
  right: 0;
  top: 0;
   background:rgb(220, 114, 114);
  transition: all 0.3s ease;
}
.btn-3:before {
  height: 0%;
  width: 2px;
}
.btn-3:after {
  width: 0%;
  height: 2px;
}
.btn-3:hover{
   background: transparent;
  box-shadow: none;
}
.btn-3:hover:before {
  height: 100%;
}
.btn-3:hover:after {
  width: 100%;
}
.btn-3 span:hover{
   color: rgb(220, 114, 114);
}
.btn-3 span:before,
.btn-3 span:after {
  position: absolute;
  content: "";
  left: 0;
  bottom: 0;
   background: rgb(220, 114, 114);
  transition: all 0.3s ease;
}
.btn-3 span:before {
  width: 2px;
  height: 0%;
}
.btn-3 span:after {
  width: 0%;
  height: 2px;
}
.btn-3 span:hover:before {
  height: 100%;
}
.btn-3 span:hover:after {
  width: 100%;
}


    .filter{
      display: flex;
      padding: 20px;
    }
    #one{
      float: left;
      display: flex;
    }

    #two{
      float: left;
      display: flex;
    }
 </style>
</head>
<body>
    <div class="navbar">
        <div class="label">Highway Fix it <span style="color:red;"> & Connect</span></div>
        <div class="attributes">
            <a href="admin_index.html">HOME</a>
            <a href="#">SERVICES</a>
            <a href="#">FEEDBACK</a>
            <a href="#">CONTACT</a>
            <a href="adminHome.jsp">ACCOUNT</a>
        </div>
    </div>
   <div>
 <div class="filter">
        
      <!--previous page of search result by area-->
      <form action="MechanicSearchAdmin.jsp" method="post" id="one">
        <input type="hidden" name="ch" value="<%=request.getParameter("ch")%>">  
        <button class="custom-btn btn-3" role="button" role="button" style="margin-right: 10px"><span>All</span></button>
      </form>
      
      <!-- Filter for specific brand -->
     <form action="filterAdmin.jsp" method="post" id="two">
        <input type="hidden" name="ch" value="indore">  <!--<%=request.getParameter("ch")%>-->
        <button class="custom-btn btn-3" role="button" role="button" name="specialist" value="Sedan" style="margin-right: 10px"><span>Sedan</span></button>
        <button class="custom-btn btn-3" role="button" role="button" name="specialist" value="Maruti" style="margin-right: 10px"><span>Maruti</span></button>
        <button class="custom-btn btn-3" role="button" role="button" name="specialist" value="Tata" style="margin-right: 10px"><span>Tata</span></button>
        <button class="custom-btn btn-3" role="button" role="button" name="specialist" value="Honda" style="margin-right: 10px"><span>Honda</span></button>
        <button class="custom-btn btn-3" role="button" role="button" name="specialist" value="Toyota" style="margin-right: 10px"><span>Toyota</span></button>
        <button class="custom-btn btn-3" role="button" role="button" name="specialist" value="Hyundai" style="margin-right: 10px"><span>Hyundai</span></button>
      </form>
    </div>
   
   </div>
    <div class = "row section-title text-center mb-4">
        <div class = "col-12">
            <h2 class = "text-grey fs-4 my-3 mx-auto animate-charcter">Experienced Automotive Mechanics</h2>
        </div>
    </div>

<div class="container-fluid">
<div class="row">
<%
String ch = request.getParameter("ch");
String specialist = request.getParameter("specialist");
MechanicDAOImpl dao2 = new MechanicDAOImpl(DBConnect.getConn());
List<MechanicDtls> list2 = dao2. getMechanicByFilter(ch,specialist);
for(MechanicDtls m : list2){
%> 
<div class="col-md-3">
<div class="card   crd-ho"> 
<div class="card-body text-center">
<img alt="" src="img/<%=m.getProfile()%>"  style="width:150px; height:180px" class="img-thumblin">
<div>
<pre>
</pre>
</div>
<strong><p><%=m.getName() %></p> </strong>
<p><%=m.getArea() %></p>
<p><%=m.getSpecialist() %></p>
 
<a href="profile.jsp?id=<%=m.getId() %>"><button class="button-89" role="button">View Profile</button></a> 
</div>
</div>
<div>
</div>
</div>
<%
}
%> 
</div>
</div>
</body>
</html>