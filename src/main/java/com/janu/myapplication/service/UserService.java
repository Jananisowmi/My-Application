package com.janu.myapplication.service;

import com.janu.myapplication.dto.LoginRequest;
import com.janu.myapplication.dto.LoginResponse;
import com.janu.myapplication.dto.RegistrationRequest;
import com.janu.myapplication.dto.RegistrationResponse;
import com.janu.myapplication.entity.Account;
import com.janu.myapplication.entity.User;

public interface UserService {

	public RegistrationResponse addUser(RegistrationRequest request);

	public LoginResponse loginCheck(LoginRequest request);

	public User findUser(Account account);

	

}
                      