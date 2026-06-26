package com.tejait.batch16.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tejait.batch16.dto.OrdersDto;
import com.tejait.batch16.exceptions.IdNotFoundException;
import com.tejait.batch16.model.Orders;
import com.tejait.batch16.model.Person;
import com.tejait.batch16.repository.OrdersRepository;
import com.tejait.batch16.repository.PersonRepository;
import com.tejait.batch16.service.OrdersService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrdersServiceImpl implements OrdersService{

	PersonRepository perRepository;
	
	OrdersRepository repository;
	@Override
	public List<Orders> saveOrders(OrdersDto dto) {
		//here we have to write logic
		
	Person person=perRepository.findById(dto.getPersonId()).orElseThrow(IdNotFoundException::new);
	List<Orders> ordList=dto.getOrdList();
	
	for(Orders ord:ordList) {
		ord.setOrdPer(person);
	}
		return repository.saveAll(ordList);
		
	}

}
