package com.janu.myapplication.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class RegistrationRequest {
	
	private String userName;   
    private String password;
    private String phoneNumber;
    private String emailId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date dob;
    private String address;
    private String postalCode;
    private String state;
    private String Country;
    private String aadharNumber;
    private String panNumber;
    private String town;
    private Double amount;
	
	

}
