package com.tejait.batch16.serviceImpl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.tejait.batch16.service.CustomerService;
//@Primary this bean will be injected automatically if we use the primary bean
// To implement the qualifier bean we have to mention a name for the service bean like below
		//Bean name 
@Service("business")
//Do the samne in the RetailerCustomer class ,mention a name in the service bean
public class BusinessCustomer implements CustomerService{

	@Override
	public String getCustomer() {
		return "Business Customer";
	}

	
	
}
