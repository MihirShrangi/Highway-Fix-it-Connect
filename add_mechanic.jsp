<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
 <!DOCTYPE html>
 
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Registration form</title>
      <link rel="stylesheet" href="css_files/addmechanic.css">
      
<link rel="icon" href="https://cdn-icons-png.flaticon.com/512/6823/6823491.png" sizes="100*100">
<style >
 body{
  margin: 0;
  padding: 0;
  /* background: linear-gradient(to bottom right, #ff545a 50%, white 50%);  */
  height: 100vh; 
  overflow: hidden;
  background-image: url('images/mechnic.jpg');
  background-repeat: no-repeat; 
background-attachment: fixed; 
} 
  
</style>
  </head>
  <body>
    <div class="center"> 
      <form action="MechanicAddByAdmin" method="post" enctype="multipart/form-data">

        <div class="txt_field">
            <input type="text" name="name" required>
         
          <label>Enter full Name</label>
        </div>

        <div class="txt_field">
            <input type="email" name="email" required>
         
          <label>Email</label>
        </div>
 		<div class="txt_field">
            <input type="text" name="mobile1" required>
              <span></span>
              <label>Mobile 1</label>
            </div>
            
            <div class="txt_field">
            <input type="text" name="mobile2" required>
              <span></span>
              <label>Mobile 2</label>
            </div>
       
        <div class="txt_field">
            <input type="password" name="password" required>
          <span></span>
          <label>Password</label>
        </div>
     
        <div class="txt_field">
            <input type="text" name="area" required>
          <span></span>
          <label>Enter area</label>
        </div>
        
         <div class="txt_field">
            <input type="text" name="exprience" required>
          <span></span>
          <label>Enter Experience</label>
        </div>
        
          <div class="txt_field">
            <input type="text" name="specialist" required>
          <span></span>
          <label>Specialist</label>
        </div>
        
         <div class="txt_field">
            <input type="text" name="map" autocomplete="off" required>
          <span></span>
          <label>Enter map location</label>
        </div>
         
         <input type="hidden" name="status" value="inactive">
          
         <label>Govt ID</label>
         
           <input type="file" name="govt_id" required>
          <span></span>
         
          <label>Profile</label>
         
           <input type="file" name="profile" required>
          <span></span>
         
      
        <div class="pass"></div>
        <input type="submit" value="Registration">
        <div class="pass"></div>
      </form>
    </div>

  </body>
</html>
 