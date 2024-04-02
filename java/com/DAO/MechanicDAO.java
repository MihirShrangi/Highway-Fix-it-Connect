package com.DAO;

import java.util.List;

import com.entity.MechanicDtls;

public interface MechanicDAO {
	
    public boolean addMechanic(MechanicDtls b);
    
    public MechanicDtls login(String email,String password);
    
    public List<MechanicDtls> getAllMechanics();
    
    public MechanicDtls getMechanicId(int id);
    
    public boolean updateEditMechanic(MechanicDtls m);	
    
    public boolean deleteMechanic(int id);
    
    public List<MechanicDtls> getMechanicBySearch(String ch);
    
    public List<MechanicDtls> getAllMechanicsProfile(int id);
    
    public List<MechanicDtls> getMechanicByFilter(String ch,String specialist);
    
    public List<MechanicDtls> getAllMechanicsByName(String name);
    
    public List<MechanicDtls> getAllMechanicsInactive();
}
