package com.janu.myapplication.service;

import com.janu.myapplication.dto.BeneficiaryListResponse;
import com.janu.myapplication.dto.BeneficiaryRequest;
import com.janu.myapplication.dto.BeneficiaryResponse;
import com.janu.myapplication.entity.Beneficiary;

public interface BeneficiaryService {

	void save(Beneficiary beneficiary);

	BeneficiaryResponse saveBeneficiary(BeneficiaryRequest request, Integer userId);

	BeneficiaryListResponse listAllBeneficiaries(Integer userId);


}
