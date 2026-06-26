package com.tejait.batch16.serviceImpl;

import org.springframework.stereotype.Service;

import com.tejait.batch16.model.Items;
import com.tejait.batch16.repository.ItemsRepository;
import com.tejait.batch16.service.ItemsService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class ItemsServiceImpl implements ItemsService{

	ItemsRepository repository;

	@Override
	public Items saveItems(Items item) {
		
		return repository.save(item);
	}
}
