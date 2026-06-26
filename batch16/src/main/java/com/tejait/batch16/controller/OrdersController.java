package com.tejait.batch16.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch16.dto.OrdersDto;
import com.tejait.batch16.model.Orders;
import com.tejait.batch16.service.OrdersService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("orders")
public class OrdersController {
	
	OrdersService service;

	@PostMapping("saveOrders")
	public ResponseEntity<List<Orders>> saveOrders(@RequestBody OrdersDto dto){
		List<Orders> ordList=service.saveOrders(dto);
		return new ResponseEntity<>(ordList, HttpStatus.OK);
	}
}
