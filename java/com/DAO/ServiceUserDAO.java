package com.DAO;

import java.util.List;

import com.entity.FeedbackDtls;
import com.entity.ServiceUserDtls;
import com.entity.User;

public interface ServiceUserDAO {
	  public boolean addServiceUser(ServiceUserDtls sud);
	  public List<ServiceUserDtls>  getAllUsers(int mid);
	  
	  public List<ServiceUserDtls> getAllMechanics(String mobile);
	  
	  public boolean addFeedback(FeedbackDtls fb);
	  public List<FeedbackDtls> getAllFeedback();
}
