package com.bvn.springsecurity.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bvn.springsecurity.models.Role;
import com.bvn.springsecurity.payload.request.AddRoleRequest;
import com.bvn.springsecurity.payload.response.DataResponse;
import com.bvn.springsecurity.payload.response.MessageResponse;
import com.bvn.springsecurity.services.RoleService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	RoleService roleService;
	
	@GetMapping
	public List<Role> getAllRole(){
		return roleService.getAllRole();
	}

	@PostMapping("/add")
	public ResponseEntity<?> registerUser(@Valid @RequestBody AddRoleRequest addRoleRequest) {
		Boolean isExistedRoleName = roleService.checkRoleNameExisted(addRoleRequest.getRoleName());
		if (isExistedRoleName) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Role already exists!"));
		}
		Role role = new Role(addRoleRequest.getRoleName());
		roleService.addRole(role);
		return ResponseEntity.ok(new DataResponse("Add new Role successfully!", role));
	}
}
