package com.janu.myapplication.dto;

import java.util.List;

import com.janu.myapplication.entity.Transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionList {
	
	private List<Transaction> transactionList;
	

}
