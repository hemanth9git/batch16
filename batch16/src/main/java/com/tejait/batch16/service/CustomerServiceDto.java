package com.tejait.batch16.service;

import com.tejait.batch16.dto.CustomerRequestDto;
import com.tejait.batch16.dto.CustomerResponseDto;

public interface CustomerServiceDto{

	CustomerResponseDto saveCustomerCardData(CustomerRequestDto request);

	
}
