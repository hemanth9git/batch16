package com.tejait.batch16.serviceImpl;

import org.springframework.stereotype.Service;

import com.tejait.batch16.service.CustomerService;
//Here the another service bean name is retailer
//Use qualifier for injecting the other bean
@Service("retailer")
public class RetailCustomer implements CustomerService{

	@Override
	public String getCustomer() {
		return "Retailer Customer";
	}

}
