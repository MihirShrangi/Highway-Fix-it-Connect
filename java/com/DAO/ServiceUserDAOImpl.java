package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.FeedbackDtls;
 
import com.entity.ServiceUserDtls;
import com.entity.User;
 
public class ServiceUserDAOImpl implements ServiceUserDAO{
 
private Connection conn; 
	
	public ServiceUserDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	
	@Override
	public boolean addServiceUser(ServiceUserDtls sud) {
		  boolean f = false;
		  
		  try {
			  String sql = "insert into service_user(mid,mname,name,mobile,service,location,status) values(?,?,?,?,?,?,?)";
			   PreparedStatement ps = conn.prepareStatement(sql);
			 
			   ps.setInt(1,sud.getMid());
			   ps.setString(2, sud.getMname());
			   ps.setString(3, sud.getName());
			   ps.setString(4, sud.getMobile());
			   ps.setString(5, sud.getService());
			   ps.setString(6, sud.getLocation());
			   ps.setString(7, sud.getStatus());
			   
			   int i=ps.executeUpdate();
				
				if(i==1) {
					f=true;
				}
					
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		return f;
	}


	@Override
	public List<ServiceUserDtls> getAllUsers(int mid) {
		List<ServiceUserDtls> list = new ArrayList<ServiceUserDtls>();
		ServiceUserDtls s= null; 
		try {
			 
			 String sql = "select * from service_user where mid=? ";
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setInt(1, mid);
			 ResultSet rs = ps.executeQuery();
			 
			 while(rs.next()) {
				s = new ServiceUserDtls();
				s.setName(rs.getString(4));
				s.setMname(rs.getString(3));
				s.setMobile(rs.getString(5));
				s.setService(rs.getString(6));
				s.setLocation(rs.getString(7));
				s.setStatus(rs.getString(8));
				
				list.add(s);
			 }
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return  list;
	}


	@Override
	public boolean addFeedback(FeedbackDtls fb) {
		 boolean f = false;
		 
		 try {
		 String sql = "insert into feedback(name,email,subject,message) values(?,?,?,?)";
		  PreparedStatement ps = conn.prepareStatement(sql);
		  
		  ps.setString(1, fb.getName());
		  ps.setString(2, fb.getEmail());
		  ps.setString(3, fb.getSubject());
		  ps.setString(4, fb.getMessage());
		  
		  int i=ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			 
		  
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return f;
	}


	@Override
	public List<FeedbackDtls> getAllFeedback() {
		
	List<FeedbackDtls> list = new ArrayList<FeedbackDtls>();
		
	FeedbackDtls fb= null;
		
		 try {
			 
			 String sql = "select * from feedback";
			 PreparedStatement ps = conn.prepareStatement(sql);
			 
			 ResultSet rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 
				 fb = new FeedbackDtls(); 
				 
			     fb.setName(rs.getString(2));
			     fb.setEmail(rs.getString(3));
			     fb.setSubject(rs.getString(4));
			     fb.setMessage(rs.getString(5));
				list.add(fb);
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return list;
	 
	}


	@Override
	public List<ServiceUserDtls> getAllMechanics(String mobile) {
		List<ServiceUserDtls> list = new ArrayList<ServiceUserDtls>();
		ServiceUserDtls s= null; 
		
		try {
			 
			 String sql = "select * from service_user where mobile=? ";
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setString(1, mobile);
			 ResultSet rs = ps.executeQuery();
			 
			 while(rs.next()) {
				s = new ServiceUserDtls();
				s.setName(rs.getString(4));
				s.setMname(rs.getString(3));
				s.setMobile(rs.getString(5));
				s.setService(rs.getString(6));
				s.setLocation(rs.getString(7));
				s.setStatus(rs.getString(8));
				
				
				list.add(s);
			 }
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return  list;
	} 
	
	
	
	
}
