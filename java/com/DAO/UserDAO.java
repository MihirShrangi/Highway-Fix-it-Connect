package com.DAO;

import java.util.List;

 
import com.entity.Payment;
import com.entity.User;

public interface UserDAO {
	
	public boolean insertUser(User user);
 
	public User loginUser(String email, String password) ;
	
	 public List<User> getAllUsers();
	 
	 public boolean addPayment(Payment p);
 
}
