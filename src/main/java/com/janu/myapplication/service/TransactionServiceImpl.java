package com.janu.myapplication.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janu.myapplication.dto.TranactionRequest;
import com.janu.myapplication.dto.TransactionList;
import com.janu.myapplication.dto.TransactionResponse;
import com.janu.myapplication.entity.Account;
import com.janu.myapplication.entity.Beneficiary;
import com.janu.myapplication.entity.Transaction;
import com.janu.myapplication.entity.User;
import com.janu.myapplication.repository.AccountRepository;
import com.janu.myapplication.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	BeneficiaryService beneficiaryService;
	
	@Autowired
	UserService userService;

	@Override
	@Transactional
	public TransactionResponse transfer(TranactionRequest request) {
		Transaction transaction = new Transaction();
		BeanUtils.copyProperties(request, transaction);
		transaction.setTimeStamp(new Date());
		transaction.setType("debit");
		Account account = accountRepository.findAccountByAccountNumber(request.getFromAccount());
		User user = userService.findUser(account);
		System.out.println("Balance"+account.getBalance());
		System.out.println("User "+user.getUserId()+" "+user.getUserName());
		transaction.setUser(user);
		if (account.getBalance() > 1000) {
			transactionRepository.save(transaction);
			Double balance = account.getBalance() - transaction.getAmount();
			accountRepository.updateBalance(transaction.getFromAccount(), balance);
			if (request.isFlag()) {
				Beneficiary beneficiary = new Beneficiary();
				beneficiary.setAccNo(request.getBeneficiaryAccount());
				beneficiary.setIfscCode(request.getIfscCode());
				beneficiary.setBankName(request.getBankName());
				beneficiary.setBenName(request.getBenName());
				//beneficiary.setAccount(account);
				beneficiaryService.save(beneficiary);
			}
			return new TransactionResponse("Transaction successfull", "201");
		} else {
			return new TransactionResponse("Insufficient balance", "409");
		}

	}

	@Override
	public TransactionList transactionList(Integer userId) {
		List<Transaction> list = transactionRepository.findTransactionByUser(userId);
		TransactionList transactionList = new TransactionList(list);
		return transactionList;
	}

	@Override
	public TransactionList getTransfersBydate(Integer userId, String fromDate, String toDate) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date from = formatter.parse(fromDate);
		Date to = formatter.parse(toDate);
		List<Transaction> transactionList = transactionRepository.findTransactionByDate(userId,from,to);
		return new TransactionList(transactionList);
	}

}
