package com.te.blogmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.te.blogmanagement.security.JwtUtil;
import com.te.blogmanagement.security.UserRequest;
import com.te.blogmanagement.security.UserResponse;

@RestController
@RequestMapping("/log")
public class LoginController {

	@Autowired
	private JwtUtil jwtUtil;
	

	@PostMapping("/loginUser")
	public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest userRequest) {
		// TODO : validate username with password
		String token = jwtUtil.generateToken(userRequest.getEmail());
		 return  ResponseEntity.ok(new UserResponse(token, "Token Generated"));

	}
	
}
	