package com.janu.myapplication.dto;

import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
	
	
	private String userName; 
	@Pattern(regexp = "^[-_,A-Za-z0-9@]$")
    private String password;
    private String emailId;

}
