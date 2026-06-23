package com.tejait.batch16.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch16.dto.CustomerRequestDto;
import com.tejait.batch16.dto.CustomerResponseDto;
import com.tejait.batch16.service.CustomerServiceDto;

@RestController
public class CustomerController{

	@Autowired
	CustomerServiceDto service;
	
	public ResponseEntity<CustomerResponseDto> saveCustomerCardData(@RequestBody CustomerRequestDto request){
		CustomerResponseDto cust=service.saveCustomerCardData(request);
		return new ResponseEntity<CustomerResponseDto>(cust,HttpStatus.OK);
	}
}
