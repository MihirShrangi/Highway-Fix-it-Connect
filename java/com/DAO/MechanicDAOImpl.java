package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.MechanicDtls;



public class MechanicDAOImpl implements MechanicDAO {

	private Connection conn; 
	
	public MechanicDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}



	@Override
	public boolean addMechanic(MechanicDtls b) {
	    boolean f = false;
		try {
			String sql = "insert into mechanic(name,email,mobile1,password,area,exprience,Specialist,status,govt_id,profile,map,mobile2) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getName());
			ps.setString(2, b.getEmail());
			ps.setString(3, b.getMobile1());
			ps.setString(4, b.getPassword());
			ps.setString(5, b.getArea());
			ps.setString(6, b.getExprience());
			ps.setString(7, b.getSpecialist());
			ps.setString(8, b.getStatus());
			ps.setString(9, b.getGovt_id()); 
			ps.setString(10, b.getProfile());
			ps.setString(11, b.getMap());
			ps.setString(12, b.getMobile2());
			
		int i=	ps.executeUpdate();
		
		if(i==1) {
			f=true;
		}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		} 
		return f;
	}



	@Override
	public MechanicDtls login(String email, String password) {
		MechanicDtls mds =null;
		try {
			String sql = "Select * from mechanic where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				mds = new MechanicDtls();
				mds.setId(rs.getInt(1));
				mds.setName(rs.getString(2));
				mds.setEmail(rs.getString(3));
				mds.setMobile1(rs.getString(4));
				mds.setPassword(rs.getString(5));
				mds.setArea(rs.getString(6));
				mds.setExprience(rs.getString(7));
				mds.setGovt_id(rs.getString(8));
				mds.setSpecialist(rs.getString(9));
				mds.setStatus(rs.getString(10));
				mds.setProfile(rs.getString(11));
				mds.setMap(rs.getString(12));
				mds.setMobile2(rs.getString(13));
			} 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return mds;
	}



	@Override
	public List<MechanicDtls> getAllMechanics() {
		
		List<MechanicDtls> list = new ArrayList<MechanicDtls>();
		
		MechanicDtls m= null;
		
		 try {
			 
			 String sql = "select * from mechanic";
			 PreparedStatement ps = conn.prepareStatement(sql);
			 
			 ResultSet rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 
				m = new MechanicDtls();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setEmail(rs.getString(3));
				m.setMobile1(rs.getString(4));
				m.setPassword(rs.getString(5));
				m.setArea(rs.getString(6));
				m.setExprience(rs.getString(7)); 
				m.setGovt_id(rs.getString(8));
				m.setSpecialist(rs.getString(9));
				m.setStatus(rs.getString(10));
				m.setProfile(rs.getString(11));
				m.setMap(rs.getString(12));
				m.setMobile2(rs.getString(13));
				
				list.add(m);
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return list;
	}



	@Override
	public MechanicDtls getMechanicId(int id) {
		MechanicDtls m = null;
		try {
			String sql = "Select * from mechanic where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 
				m = new MechanicDtls();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setEmail(rs.getString(3));
				m.setMobile1(rs.getString(4));
				m.setPassword(rs.getString(5));
				m.setArea(rs.getString(6));
				m.setExprience(rs.getString(7));
				m.setGovt_id(rs.getString(8));
				m.setSpecialist(rs.getString(9));
				m.setStatus(rs.getString(10));
				m.setProfile(rs.getString(11));
				m.setMap(rs.getString(12));
				m.setMobile2(rs.getString(13));
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return m;
	}



	@Override
	public boolean updateEditMechanic(MechanicDtls m) {
		boolean f = false;
		try {
			
			String sql = "update mechanic set name=?,email=?,mobile1=?,password=?,area=?,exprience=?,specialist=?,status=?,map=?,mobile2=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, m.getName());
			ps.setString(2,m.getEmail());
			ps.setString(3, m.getMobile1() );
			ps.setString(4, m.getPassword());
			ps.setString(5, m.getArea());
			ps.setString(6, m.getExprience());
			ps.setString(7,m.getSpecialist());
			ps.setString(8,m.getStatus());
			ps.setString(9,m.getMap());
			ps.setString(10, m.getMobile2());
			ps.setInt(11,m.getId());
			
			 int i =ps.executeUpdate();
			 if(i==1) {
				 f=true;
			 }
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}



	@Override
	public boolean deleteMechanic(int id) {
		 
	    boolean f = false;
	    try {
	    	
	    	String sql = "delete from mechanic where id = ?";
	    	PreparedStatement ps = conn.prepareStatement(sql);
	    	ps.setInt(1, id);
	    	int i = ps.executeUpdate();
	    	if(i==1) {
	    		f=true;
	    	}
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		return f;
	}



	@Override
	public List<MechanicDtls> getMechanicBySearch(String ch) {
		 List<MechanicDtls> list = new ArrayList<MechanicDtls>();
		 MechanicDtls m = null;
		 try {
			 
	     String sql="select * from mechanic where area like ? and status=?";
	     PreparedStatement ps = conn.prepareStatement(sql);
	     ps.setString(1, "%"+ch+"%");
	     ps.setString(2, "active");
		
	     
	     ResultSet rs = ps.executeQuery();
	     
	     while(rs.next()) {
	    	 m = new MechanicDtls();
	    	 m.setId(rs.getInt(1));
			 m.setName(rs.getString(2));
			 m.setEmail(rs.getString(3));
			 m.setMobile1(rs.getString(4));
			 m.setPassword(rs.getString(5));
			 m.setArea(rs.getString(6));
			 m.setExprience(rs.getString(7));
			 m.setGovt_id(rs.getString(8));
			 m.setSpecialist(rs.getString(9));
			 m.setStatus(rs.getString(10));
			 m.setProfile(rs.getString(11));
			 m.setMap(rs.getString(12));
			 m.setMobile2(rs.getString(13));
			 
			 list.add(m);
	     }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return list;
	}



	@Override
	public List<MechanicDtls> getAllMechanicsProfile(int id) {
List<MechanicDtls> list = new ArrayList<MechanicDtls>();
		
		MechanicDtls m= null;
		
		 try {
			 
			 String sql = "select * from mechanic where id=?";
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setInt(1, id);
			 ResultSet rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 
				m = new MechanicDtls();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setEmail(rs.getString(3));
				m.setMobile1(rs.getString(4));
				m.setPassword(rs.getString(5));
				m.setArea(rs.getString(6));
				m.setExprience(rs.getString(7)); 
				m.setGovt_id(rs.getString(8));
				m.setSpecialist(rs.getString(9));
				m.setStatus(rs.getString(10)); 
				m.setProfile(rs.getString(11));
				m.setMap(rs.getString(12));
				m.setMobile2(rs.getString(13));
				
				list.add(m);
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return list;
	}



	@Override
	public List<MechanicDtls>  getMechanicByFilter(String ch, String specialist) {
		 List<MechanicDtls> list = new ArrayList<MechanicDtls>();
		 MechanicDtls m = null;
		 try {
			 
	     String sql="select * from mechanic where area like ? and status=? and specialist like ?";
	     PreparedStatement ps = conn.prepareStatement(sql);
	     ps.setString(1, "%"+ch+"%");
	     ps.setString(2, "active");
		 ps.setString(3, "%"+specialist+"%");
	     
	     ResultSet rs = ps.executeQuery();
	     
	     while(rs.next()) {
	    	 m = new MechanicDtls();
	    	 m.setId(rs.getInt(1));
			 m.setName(rs.getString(2));
			 m.setEmail(rs.getString(3));
			 m.setMobile1(rs.getString(4));
			 m.setPassword(rs.getString(5));
			 m.setArea(rs.getString(6));
			 m.setExprience(rs.getString(7));
			 m.setGovt_id(rs.getString(8));
			 m.setSpecialist(rs.getString(9));
			 m.setStatus(rs.getString(10));
			 m.setProfile(rs.getString(11));
			 m.setMap(rs.getString(12));
			 m.setMobile2(rs.getString(13));
			 
			 list.add(m);
	     }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return list; 
	}



	@Override
	public List<MechanicDtls> getAllMechanicsByName(String name) {
List<MechanicDtls> list = new ArrayList<MechanicDtls>();
		
		MechanicDtls m= null;
		
		 try {
			 
			 String sql = "select * from mechanic where name = ? ";
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setString(1, name);
			 
			 ResultSet rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 
				m = new MechanicDtls();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setEmail(rs.getString(3));
				m.setMobile1(rs.getString(4));
				m.setPassword(rs.getString(5));
				m.setArea(rs.getString(6));
				m.setExprience(rs.getString(7)); 
				m.setGovt_id(rs.getString(8));
				m.setSpecialist(rs.getString(9));
				m.setStatus(rs.getString(10));
				m.setProfile(rs.getString(11));
				m.setMap(rs.getString(12));
				m.setMobile2(rs.getString(13));
				
				list.add(m);
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return list;
	}



	@Override
	public List<MechanicDtls> getAllMechanicsInactive() {
List<MechanicDtls> list = new ArrayList<MechanicDtls>();
		
		MechanicDtls m= null;
		
		 try {
			 
			 String sql = "select * from mechanic where status=inactive";
			 PreparedStatement ps = conn.prepareStatement(sql);
			 
			 ResultSet rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 
				m = new MechanicDtls();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setEmail(rs.getString(3));
				m.setMobile1(rs.getString(4));
				m.setPassword(rs.getString(5));
				m.setArea(rs.getString(6));
				m.setExprience(rs.getString(7)); 
				m.setGovt_id(rs.getString(8));
				m.setSpecialist(rs.getString(9));
				m.setStatus(rs.getString(10));
				m.setProfile(rs.getString(11));
				m.setMap(rs.getString(12));
				m.setMobile2(rs.getString(13));
				
				list.add(m);
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return list;
	} 
	
	
}
