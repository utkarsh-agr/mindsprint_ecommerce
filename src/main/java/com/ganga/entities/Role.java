package com.ganga.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

@Entity
//@NoArgsConstructor
public class Role {


	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleId;
	
	private String roleName;
	
	public Role() {
		super();
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
	
}
