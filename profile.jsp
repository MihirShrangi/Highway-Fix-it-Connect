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
    <title>Profile</title>
    
    
<link rel="icon" href="https://cdn-icons-png.flaticon.com/512/6823/6823491.png" sizes="100*100">
    <link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous"> 
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" /> 
    
    <style> 
        .background { 
            position: absolute; 
            height: 100%; 
            width: 100%; 
            background-image: url('https://images.ctfassets.net/3prze68gbwl1/asset-17suaysk1qa1i6d/1e3ba5e88bb9307b1039e4193edfca12/687474703a2f2f692e696d6775722e636f6d2f32355a673559422e676966.gif'); 
            background-size: cover;  
            background-position: center;
            background-repeat: no-repeat;
   
            filter: blur(2px); 
            /* filter: blur(2px);
           -webkit-filter: blur(2px); */
            z-index: -1; 
        }  
        
       
        img {
            max-width: 100%;
            height: auto; 
            border-radius: 5px; 
        }  
        
  p {
    margin-top: 0;
    margin-bottom: 0rem;
    
} 
 </style>
</head>
<body  >
<%
int id = Integer.parseInt(request.getParameter("id"));
MechanicDAOImpl dao = new MechanicDAOImpl(DBConnect.getConn());
List<MechanicDtls> list = dao.getAllMechanicsProfile(id);
for(MechanicDtls m : list){
%>

<div class="background"></div>
<div>
    <pre>



    </pre>
</div>
     <div class="container">
        <div class="row p-5" id="profile">
            <div class="col-md-5 p-5 border bg-white">
               <img alt="" src="img/<%=m.getProfile()%>"style="width:300px; height:270px" class="img-thumblin">
            </div>
            <div class="col-md-6 p-4 text-center border bg-white">
            <h1><strong>Name:</strong><%=m.getName() %></h1> 
            <br>
            <div class="row">  
             <div class="col-md-4 text-danger text-center p-2">
               <a href="<%=m.getMap() %>" target="_blank"><i class="fa-solid fa-map-location-dot fa-3x"></i></a> 
                <p>Map loaction</p>
            </div> 
                 <div class="col-md-4 text-danger text-center p-2">
                <i class="fa-solid fa-mobile-screen fa-3x"></i>
                <p id="mob"><a href="tel:<%=m.getMobile1() %>" style="color:red;"><%=m.getMobile1() %></a> 
                <%
                if(!(m.getMobile1().equals(m.getMobile2()))){
                %> 
                <a href="tel:<%=m.getMobile2() %>" style="color:red;"><%=m.getMobile2() %></a></p>
                <%
                }
                %>
            </div>
            
            <div class="col-md-4 text-danger text-center p-2">
                <i class="fa-solid fa-shop fa-3x"></i>
                <p>Area:<%=m.getArea() %></p>
            </div>
              <div class="col-md-4 text-danger text-center p-2">
                <i class="fa-solid fa-envelope fa-3x"></i>
               <p><a href="mailto:<%=m.getEmail() %>" style="color:red;"><%=m.getEmail() %></a> </p>
            </div> 
            
            <div class="col-md-4 text-danger text-center p-2">
                <i class="fa-solid fa-car fa-3x"></i>
                <p>Specialist:<%=m.getSpecialist() %></p>
            </div> 
         
            <div class="col-md-4 text-danger text-center p-2">
                <i class="fa-solid fa-user-nurse fa-3x"></i>
                <p>Experience:<%=m.getExprience() %></p>
            </div>
          </div> 
           <div>
           <pre></pre>
          </div> 
            <div>
             <p>The mechanic's travel cost is Rs. 150 per kilometer.</p>
        </div>
         </div> 
         
        </div>
               <%
}
        %>
        
       
      
    </div>
 
 
</body>
</html>
