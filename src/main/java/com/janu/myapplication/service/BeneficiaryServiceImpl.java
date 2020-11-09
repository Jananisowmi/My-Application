package com.janu.myapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janu.myapplication.dto.BeneficiaryListResponse;
import com.janu.myapplication.dto.BeneficiaryRequest;
import com.janu.myapplication.dto.BeneficiaryResponse;
import com.janu.myapplication.entity.Beneficiary;
import com.janu.myapplication.entity.User;
import com.janu.myapplication.repository.BeneficiaryRepository;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

	@Autowired
	BeneficiaryRepository beneficiaryRepository;

	@Override
	public void save(Beneficiary beneficiary) {
		beneficiaryRepository.save(beneficiary);

	}

	@Override
	public BeneficiaryResponse saveBeneficiary(BeneficiaryRequest request,Integer userId) {
		Beneficiary beneficiary = new Beneficiary();
		User user = new User();
		user.setUserId(userId);
		BeanUtils.copyProperties(request, beneficiary);
		beneficiary.setUser(user);
		beneficiaryRepository.save(beneficiary);
		BeneficiaryResponse response = new BeneficiaryResponse();
		response.setMessage("Beneficiary added");
		response.setStatusCode("201");
		return response;
	}

	@Override
	public BeneficiaryListResponse listAllBeneficiaries(Integer userId) {
		BeneficiaryListResponse response = new BeneficiaryListResponse();
		List<Beneficiary> beneficiaries = beneficiaryRepository.getBeneficiariesByUserId(userId);
		if (Optional.ofNullable(beneficiaries).isPresent()) {
			response.setBeneficiaries(beneficiaries);

		} else {
			response.setMessage("User do not have any beneficiares");
			response.setStatusCode("204");
		}

		return response; }} 
 

