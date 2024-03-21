package com.ganga.services;

import com.ganga.entities.Role;
import com.ganga.payloads.RoleDto;
//import com.quogle.payloads.RoleDto;

public interface RoleServices {
	
	public RoleDto createRole(RoleDto RoleDto);
	
	public void deleteRole(int roleId);
	
	public Role getRole(int roleId);
	
	

}
