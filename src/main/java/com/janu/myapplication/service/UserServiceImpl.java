package com.janu.myapplication.service;


import java.util.Base64;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janu.myapplication.dto.LoginRequest;
import com.janu.myapplication.dto.LoginResponse;
import com.janu.myapplication.dto.RegistrationRequest;
import com.janu.myapplication.dto.RegistrationResponse;
import com.janu.myapplication.entity.Account;
import com.janu.myapplication.entity.User;
import com.janu.myapplication.repository.UserRepository;
import com.janu.myapplication.utils.MailService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	AccountService accountService;
	
	

	@Override
	@Transactional
	public RegistrationResponse addUser(RegistrationRequest request) {
		RegistrationResponse response=new RegistrationResponse();
		System.out.println("Inside add user");
		User user = new User();
		BeanUtils.copyProperties(request, user);
		user.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
		System.out.println("username " + user.getUserName() + " " + "password" + user.getPassword());
		User created =userRepository.save(user);
		if(Optional.ofNullable(created).isPresent()) {
			Account account= accountService.saveAccount(created,request.getAmount());
			userRepository.updateAccountId(account.getAId(),created.getUserId());
		}
		
		mailService.sendEmail(user);
		System.out.println("user saved");
		response.setMessage("User Registered");
		response.setStatusCode("201");
		return response;

	}

	@Override
	public LoginResponse loginCheck(LoginRequest request) {
		LoginResponse response =new LoginResponse();
		String passwd =Base64.getEncoder().encodeToString(request.getPassword().getBytes());
		User user= userRepository.findUserByUserNameAndPasswordAndEmailId(request.getUserName(), passwd,request.getEmailId());
		if(Optional.ofNullable(user).isPresent()) {
			response.setMessage("Login success");
			response.setStatusCode("201");
		}
		else {
			response.setMessage("User not found");
			response.setStatusCode("404");
			
		}
		 return response;
	}

	@Override
	public User findUser(Account account) {
		
		return userRepository.findUserByAccount(account.getAId());
	}



}


