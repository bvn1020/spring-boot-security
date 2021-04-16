package com.bvn.springsecurity.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bvn.springsecurity.models.Role;
import com.bvn.springsecurity.payload.request.AddRoleRequest;
import com.bvn.springsecurity.payload.response.MessageResponse;
import com.bvn.springsecurity.services.RoleService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	RoleService roleService;

	@PostMapping("/add")
	public ResponseEntity<?> registerUser(@Valid @RequestBody AddRoleRequest addRoleRequest) {
		Role role = new Role(addRoleRequest.getRoleName());
		roleService.addRole(role);
		return ResponseEntity.ok(new MessageResponse("Add new Role successfully!"));
	}
}
