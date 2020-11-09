package com.janu.myapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.janu.myapplication.dto.BeneficiaryListResponse;
import com.janu.myapplication.dto.BeneficiaryRequest;
import com.janu.myapplication.dto.BeneficiaryResponse;
import com.janu.myapplication.exception.BeneficiaryNotFoundException;
import com.janu.myapplication.service.BeneficiaryService;

@RestController
public class BeneficiaryController {
	
	@Autowired
	BeneficiaryService beneficiaryService;
	
	@PostMapping("/beneficiaries/{userId}")
	public ResponseEntity<BeneficiaryResponse> saveBeneficiary(@PathVariable("userId")Integer userId,@RequestBody BeneficiaryRequest request) {
		BeneficiaryResponse response = beneficiaryService.saveBeneficiary(request,userId);
		if (response.getMessage().equals("Beneficiary added")) {
			return new ResponseEntity<>(response, HttpStatus.CREATED);

		} else {
			return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
		}
		
	}
	
	 @GetMapping("/beneficiaries/{userId}")
	 public ResponseEntity<BeneficiaryListResponse> ListAllBeneficiaries(@PathVariable (name = "userId") Integer userId){
		 BeneficiaryListResponse response = beneficiaryService.listAllBeneficiaries(userId);
		 if(response.getBeneficiaries().size()<1) {
			 throw new BeneficiaryNotFoundException("you dont have any Beneficiary added" );
		 }
		 return new ResponseEntity<BeneficiaryListResponse>(response,HttpStatus.OK);
		 	 
	 }
	
      
 
}
