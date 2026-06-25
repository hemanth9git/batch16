package com.tejait.batch16.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice//Spring boot will rcognize this is global Exception handler
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class) //Used to handle the custom exception named IdNotFoundException
	public ResponseEntity<ErrorDtls> IdNotFoundException(HttpServletRequest request){
		ErrorDtls errorDtls=new ErrorDtls(new Date(), 410, "Id Not Found", "The Given Id Not Found", request.getRequestURI());
		return new ResponseEntity<>(errorDtls, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DetailsAlreadyExists.class)
	public ResponseEntity<ErrorDtls> deatilsAlreayExists(HttpServletRequest request){
		ErrorDtls errorDtls=new ErrorDtls(new Date(), 412, "Details not Found", "There is no record of given ID", request.getRequestURI());
		return new ResponseEntity<>(errorDtls, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class) //Used to handle all the exceptions in the springBoot
	public ResponseEntity<ErrorDtls> globalExceptionHandler(HttpServletRequest request){
		ErrorDtls errorDtls=new ErrorDtls(new Date(), 1280, "Exception Occured", "Something Went Wrong", request.getRequestURI());
		return new ResponseEntity<>(errorDtls, HttpStatus.BAD_REQUEST);
	}
	
	

}
