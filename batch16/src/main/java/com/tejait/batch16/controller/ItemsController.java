package com.tejait.batch16.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch16.model.Items;
import com.tejait.batch16.service.ItemsService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("items")
public class ItemsController {
	
	ItemsService service;
	
	@PostMapping("saveItems")
	public ResponseEntity<Items> saveItems(@RequestBody Items item){
		Items savedItem=service.saveItems(item);
		return new ResponseEntity<Items>(savedItem, HttpStatus.OK);
	}

}
