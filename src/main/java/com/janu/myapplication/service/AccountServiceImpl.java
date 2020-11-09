package com.janu.myapplication.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janu.myapplication.entity.Account;
import com.janu.myapplication.entity.User;
import com.janu.myapplication.repository.AccountRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;

	private static final String CONSTANT_ACCNO = "JA103111090";
	private static final String BANK_NAME = "VBSJ";
	private static final String IFSC_CODE ="VBSJ0001031";
	
	@Override
	public Account saveAccount(User created,Double balance) {
		Account account =new Account();
		account.setAccountNumber(CONSTANT_ACCNO.concat(String.valueOf(created.getUserId())));
		account.setBranch(created.getTown());
		account.setBankName(BANK_NAME);	
		account.setIfscCode(IFSC_CODE);
		account.setBalance(balance);
		account.setUser(created);
		return accountRepository.save(account);
	}

}
