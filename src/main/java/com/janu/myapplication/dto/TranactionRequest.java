package com.janu.myapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TranactionRequest {

	private Double amount;
	private String comment;
	private String beneficiaryAccount;
	private String ifscCode;
	private String bankName;
	private String fromAccount;
	private String benName;
	private boolean flag;
	
}
