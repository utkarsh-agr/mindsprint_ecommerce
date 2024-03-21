package com.ganga.payloads;

//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
public class RoleDto {
	
	int roleId;
	
	String roleName;

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

	public RoleDto(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public RoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
