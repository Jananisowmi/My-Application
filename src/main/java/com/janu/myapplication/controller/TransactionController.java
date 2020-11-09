package com.janu.myapplication.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.janu.myapplication.dto.TranactionRequest;
import com.janu.myapplication.dto.TransactionList;
import com.janu.myapplication.dto.TransactionResponse;
import com.janu.myapplication.exception.TransactionNotFoundException;
import com.janu.myapplication.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	
	@PostMapping("/transfer")
	public ResponseEntity<TransactionResponse> transfer(@RequestBody TranactionRequest request ) {
		TransactionResponse response= transactionService.transfer(request);
		if(response.getMessage().equals("Transaction successfull")) {
		return new ResponseEntity<TransactionResponse>(response,HttpStatus.CREATED);
			}
		else {
			return new ResponseEntity<TransactionResponse>(response,HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/transactions/{userId}")
	public ResponseEntity<TransactionList> transactionList(@PathVariable("userId")Integer userId ) {
		TransactionList transactionList = transactionService.transactionList(userId);
		if(transactionList.getTransactionList().size()<1) {
			throw new TransactionNotFoundException("no records found");
		
		}
		return new ResponseEntity<TransactionList>(transactionList,HttpStatus.OK);
		
	}
	
	@GetMapping("/transaction/{userId}")
	public ResponseEntity<TransactionList> getTransfersByDate(@PathVariable("userId")Integer userId,
			@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate)
					throws ParseException,TransactionNotFoundException{
		TransactionList response = transactionService.getTransfersBydate(userId,fromDate,toDate);
		if(response.getTransactionList().size()<1) {
			throw new TransactionNotFoundException("no records found");
		
		}
		return new ResponseEntity<TransactionList>(response,HttpStatus.OK);
		
	}
}