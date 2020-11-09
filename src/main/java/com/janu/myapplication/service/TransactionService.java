package com.janu.myapplication.service;

import java.text.ParseException;
import java.util.Date;

import com.janu.myapplication.dto.TranactionRequest;
import com.janu.myapplication.dto.TransactionList;
import com.janu.myapplication.dto.TransactionResponse;

public interface TransactionService {

	TransactionResponse transfer(TranactionRequest request);

	TransactionList transactionList(Integer userId);

	TransactionList getTransfersBydate(Integer userId, String fromDate, String toDate) throws ParseException;

}
