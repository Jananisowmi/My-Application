package com.janu.myapplication.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException ex,WebRequest request){
		ErrorDetails details =new ErrorDetails(new Date(), ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(TransactionNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleTransactionNotFoundException(TransactionNotFoundException ex,WebRequest request){
		ErrorDetails details =new ErrorDetails(new Date(), ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(BeneficiaryNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleBeneficiaryNotFoundException(BeneficiaryNotFoundException ex,WebRequest request){
		ErrorDetails details =new ErrorDetails(new Date(), ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
		
	}

}
