package com.tejait.batch16.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejait.batch16.dto.CustomerRequestDto;
import com.tejait.batch16.dto.CustomerResponseDto;
import com.tejait.batch16.model.CardDtls;
import com.tejait.batch16.model.Customer;
import com.tejait.batch16.repository.CardRepository;
import com.tejait.batch16.repository.CustomerRepository;
import com.tejait.batch16.service.CustomerServiceDto;
@Service
public class CustomerDtoServiceImpl implements CustomerServiceDto{

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CardRepository cardRepository;
	@Override
	public CustomerResponseDto saveCustomerCardData(CustomerRequestDto request) {
		
		Customer c1 = new Customer();
		c1.setName(request.getName());
		c1.setAddress(request.getAddress());
		
		CardDtls card = new CardDtls();
		card.setCardNum(request.getCardNum());
		card.setCardType(request.getCardType());
		card.setCvv(request.getCvv());
		card.setPin(request.getPin());
		
		Customer cust=customerRepository.save(c1);
		CardDtls cardDtls=cardRepository.save(card);
		
		CustomerResponseDto response=new CustomerResponseDto();
		response.setCustomerId(cust.getCid());
		response.setName(cust.getName());
		response.setAddress(cust.getAddress());
		
		response.setCardId(cardDtls.getCardId());
		response.setCardNum(card.getCardNum());
		response.setCardType(card.getCardType());
		
		
		return response;
	}

}
