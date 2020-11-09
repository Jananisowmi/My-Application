package com.janu.myapplication.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeneficiaryRequest {
	
	private int bid;
	private String accNo;
	private String benName;
	private String ifscCode;
	private String bankName;

}
