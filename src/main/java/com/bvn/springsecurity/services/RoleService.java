package com.bvn.springsecurity.services;

import java.util.List;

import com.bvn.springsecurity.models.Role;

public interface RoleService {

	Role addRole(Role role);

	List<Role> getAllRole();

	Boolean checkRoleNameExisted(String roleName);

}
