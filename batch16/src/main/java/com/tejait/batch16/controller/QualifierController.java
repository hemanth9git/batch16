package com.tejait.batch16.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch16.service.CustomerService;

@RestController
@RequestMapping("customer")
public class QualifierController {

	@Qualifier("retailer") //Retailer bean will be injected now 
	//If we do like @Qualifier("business") then the business bean will be injected
	@Autowired
	CustomerService service;
	
	@GetMapping("customerType")
	public String CustomerType() {
		return service.getCustomer();
		
	}
}
