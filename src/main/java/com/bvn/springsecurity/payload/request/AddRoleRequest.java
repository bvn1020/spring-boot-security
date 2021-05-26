package com.bvn.springsecurity.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
 
public class AddRoleRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    @JsonProperty(value = "role_name")
    private String roleName;

	public AddRoleRequest() {
		super();
	}

	public AddRoleRequest(@NotBlank @Size(min = 3, max = 20) String roleName) {
		super();
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
