package com.bvn.springsecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bvn.springsecurity.models.Role;
import com.bvn.springsecurity.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role addRole(Role role) {
		roleRepository.save(role);
		return role;
	}

}
