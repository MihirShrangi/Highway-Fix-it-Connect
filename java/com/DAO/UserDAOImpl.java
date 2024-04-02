/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnect;
import com.entity.MechanicDtls;
import com.entity.Payment;
import com.entity.User;
 

public class UserDAOImpl implements UserDAO{
     
   Connection con = null;
   int res;
   boolean result;
   ArrayList<User> alUser = null;
   User u = null;
   
   public UserDAOImpl() 
    {
       con = DBConnect.getConn();
    }
   
	@Override
   public boolean insertUser(User user)
   {
        
      if(con != null)
      {
        try
        {
         String sql = "insert into user(name,email,password,mobile,role) values(?,?,?,?,?)";
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1, user.getName());
         ps.setString(2, user.getEmail());
         ps.setString(3, user.getPassword());
         ps.setString(4, user.getMobile());
         ps.setString(5, user.getRole());
         
         res = ps.executeUpdate();  
         if(res>0)
         {
             result = true;
         }
         else
         {
             result = false;
         }
        }catch(Exception ex)
        {
            System.out.println("insert User Excep : "+ex.toString());
        }
      }
      else
      {
          System.out.println("Connection Problem...");
      }
      return result;
   }
    
	@Override
    public User loginUser(String email, String password) {
          if(con != null){
              try{
                  String sql = " select* from user where email = ? and password=?";
                  PreparedStatement ps = con.prepareStatement(sql);
                  ps.setString(1, email);
                  ps.setString(2, password);
                  
                   ResultSet rs = ps.executeQuery();
                   while(rs.next())
                   {
                       int id = rs.getInt("id");
                       String name = rs.getString("name");
                       String email_id = rs.getString("email");
                       String pass = rs.getString("password"); 
                       String mobile = rs.getString("mobile");
                       String role=rs.getString("role");
                      
                       u = new User(id,name,email_id,pass,mobile,role);
                       
                   }
              }
              catch(Exception ex){
                  System.out.println("Login Exception:" +ex.toString());
              }
  
          }else
          {
              System.out.println("Connection failed.....");
          }
          return u;
    }

	@Override
	public List<User> getAllUsers() {

		List<User> list = new ArrayList<User>();
		
		User u= null;
		
		 try {
			 
			 String sql = "select * from user";
			 PreparedStatement ps = con.prepareStatement(sql);
			 
			 ResultSet rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 
				u = new User();
				
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setMobile(rs.getString(5));
				 
				 
				list.add(u);
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return list;
	}

	@Override
	public boolean addPayment(Payment p) {
		 boolean f = false;
		 try {
				String sql = "insert into pay(cno,cname,expirem,expirey,cvv,amount) values(?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, p.getCno());
				ps.setString(2, p.getCname());
				ps.setString(3, p.getExpirem());
				ps.setString(4, p.getExpirey());
				ps.setString(5, p.getCvv());
				ps.setString(6,  p.getAmount());
				 
			int i=	ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
				
				
			}catch(Exception e) {
				e.printStackTrace();
			} 
		 return f;
	}
	
	

 
 }
