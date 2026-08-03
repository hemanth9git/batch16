package com.tejait.batch16.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.exceptions.CsvValidationException;
import com.tejait.batch16.model.TransactionHistory;
import com.tejait.batch16.service.TransactionsService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("sales")
public class TransactionsController {
	
	TransactionsService service;
	
	@PostMapping("/readTransactionsCsv")
	public ResponseEntity<List<TransactionHistory>> readTransactionsCsv(@RequestParam("file") MultipartFile file)throws IOException, CsvValidationException{
		List<TransactionHistory> readedList=service.readTransactionsCSV(file);
		return new ResponseEntity<>(readedList,HttpStatus.OK);
	}
	
	
	
	@PostMapping("/saveTxnsData/{appId}")
	public ResponseEntity<List<TransactionHistory>> saveTxnsData(@PathVariable Integer appId,@RequestBody List<TransactionHistory> saveList){
		List<TransactionHistory> list=service.saveTxnsData(appId,saveList);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
