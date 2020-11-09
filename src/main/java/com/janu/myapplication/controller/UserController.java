package com.janu.myapplication.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.janu.myapplication.dto.LoginRequest;
import com.janu.myapplication.dto.LoginResponse;
import com.janu.myapplication.dto.RegistrationRequest;
import com.janu.myapplication.dto.RegistrationResponse;
import com.janu.myapplication.exception.UserNotFoundException;
import com.janu.myapplication.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/sign-up")
	public ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest request) {
		System.out.println("Inside method");
		RegistrationResponse response = userService.addUser(request);
		System.out.println("executed");
		if (response.getMessage().equals("User Registered")) {
			return new ResponseEntity<>(response, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
		}

	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> loginUser (@Valid @RequestBody LoginRequest request) throws UserNotFoundException  {
		LoginResponse response = userService.loginCheck(request);
		if (response.getMessage().equals("Login success")) {
			return new ResponseEntity<>(response, HttpStatus.OK);
			 
	   } else {
		   throw new UserNotFoundException("User not exists");
			

		}

	}
}
	
	
