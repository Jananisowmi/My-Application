package com.janu.myapplication.dto;

import java.util.List;

import com.janu.myapplication.entity.Beneficiary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiaryListResponse {
	
	private String message;
	private String statusCode;
	
	private List<Beneficiary> beneficiaries;

}
