package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

import com.utils.SystemConstants;

public class DBConnect {

	
	private static Connection conn;
	
	public static Connection getConn() {
		
		try {
			
			  Class.forName(SystemConstants.DRIVER);
		      conn = DriverManager.getConnection(SystemConstants.URL,SystemConstants.DBUSERNAME,SystemConstants.DBPASSWORD);  
 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
