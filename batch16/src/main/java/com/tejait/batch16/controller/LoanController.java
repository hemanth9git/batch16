package com.tejait.batch16.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.opencsv.exceptions.CsvValidationException;
import com.tejait.batch16.Batch16Application;
import com.tejait.batch16.dto.Overview;
import com.tejait.batch16.model.BusinessProduct;
import com.tejait.batch16.model.CompanyAddress;
import com.tejait.batch16.model.CompanyDetails;
import com.tejait.batch16.model.LoanApplication;
import com.tejait.batch16.model.PersonDetails;
import com.tejait.batch16.model.SalesReport;
import com.tejait.batch16.model.TransactionHistory;
import com.tejait.batch16.service.LoanService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RestController
@RequestMapping("loans")
public class LoanController {
	
	LoanService service;
	public static final Logger logger=LogManager.getLogger(Batch16Application.class);
	
	@GetMapping("/getOverviewDetails/{appId}")
	public ResponseEntity<Overview> getOverviewDetails(@PathVariable Integer appId) {
		Overview savedOverview=service.getOverviewDetails(appId);
		return new ResponseEntity<>(savedOverview, HttpStatus.OK);
	}
	
	@PostMapping("/applyLoan")
	public ResponseEntity<LoanApplication> applyLoan(@RequestBody LoanApplication loan){
		LoanApplication savedLoan=service.applyLoan(loan);
		return new ResponseEntity<>(savedLoan, HttpStatus.CREATED);
	}
	
	@GetMapping("/getLoanDetails/{appId}")
	public ResponseEntity<LoanApplication> getLoanDetails(@PathVariable Integer appId){
		LoanApplication getLoan=service.getLoanDetails(appId);
		return new ResponseEntity<>(getLoan, HttpStatus.OK);
	}

	@GetMapping("loanTaskboard")
	public ResponseEntity<List<LoanApplication>> loanTaskboard(){
		List<LoanApplication> loansList=service.LoansList();
		return new ResponseEntity<>(loansList, HttpStatus.OK);
	}
	
	
	@PostMapping("/saveProductDetails/{appId}")
	public ResponseEntity<BusinessProduct> saveBusinessProductDetails(@PathVariable Integer appId,@RequestBody BusinessProduct product){
		product.setAppid(appId);
		BusinessProduct savedProduct=service.saveBusinessProductDetails(product);
		return new ResponseEntity<>(savedProduct, HttpStatus.OK);
	}
	
	@GetMapping("/getProductDetails/{appId}")
	public ResponseEntity<BusinessProduct> getProductDetails(@PathVariable Integer appId){
		BusinessProduct getProduct=service.getProductDetails(appId);
		return new ResponseEntity<>(getProduct, HttpStatus.OK);
	}
	
	@PostMapping("/saveCompanyDetails/{appId}")
	public ResponseEntity<CompanyDetails> saveCompanyDetails(@RequestBody CompanyDetails companyDetails,@PathVariable Integer appId){
		companyDetails.setAppId(appId);
		CompanyDetails savedDetails=service.saveCompanyDetails(companyDetails);
		return new ResponseEntity<>(savedDetails, HttpStatus.OK);
	}
	
	@GetMapping("/getCompanyDetails/{appId}")
	public ResponseEntity<CompanyDetails> getCompanyDetails(@PathVariable Integer appId){
		CompanyDetails getDetails=service.getCompanyDetails(appId);
		return new ResponseEntity<>(getDetails, HttpStatus.OK);
	}
	
	
	@PostMapping("/saveCompanyAddress/{appId}")
	public ResponseEntity<CompanyAddress> saveCompanyAddress(@PathVariable Integer appId,@RequestBody CompanyAddress address){
		address.setAppId(appId);
		CompanyAddress savedAddress=service.saveCompanyAddress(address);
		return new ResponseEntity<>(savedAddress, HttpStatus.OK);
		
	}
	
	@GetMapping("/getCompanyAddress/{appId}")
	public ResponseEntity<CompanyAddress> getCompanyAddress(@PathVariable Integer appId){
		CompanyAddress getAddress=service.getCompanyAddress(appId);
		return new ResponseEntity<>(getAddress, HttpStatus.OK);
	}
	
	@PostMapping("/saveJsonfileData/{appId}")
	public ResponseEntity<List<PersonDetails>> saveJsonData(@RequestBody List<PersonDetails> persons, @PathVariable Integer appId) {
	    List<PersonDetails> savedList = service.savePersonDataList(persons, appId);
	    return new ResponseEntity<>(savedList, HttpStatus.OK);
	}
	
	@PostMapping("/readJson")
	public ResponseEntity<List<PersonDetails>> readJson(@RequestParam("file") MultipartFile file) throws StreamReadException, DatabindException, IOException{
		List<PersonDetails> readList=service.readJson(file);
		return  new ResponseEntity<>(readList, HttpStatus.OK);
	}
	
	@GetMapping("/getPersonDetails/{appId}")
	public ResponseEntity<List<PersonDetails>> getPersonDetails(@PathVariable Integer appId){
		List<PersonDetails> person=service.getPersonDetails(appId);
		return new ResponseEntity<>(person, HttpStatus.OK);
	}
	
	@PostMapping("readExcel")
	public ResponseEntity<List<SalesReport>> readExcel(@RequestParam("file") MultipartFile file) throws IOException{
		List<SalesReport> readList=service.readExcel(file);
		return new ResponseEntity<>(readList, HttpStatus.OK);
	}
	
	@GetMapping("/getSalesReportDetails/{appid}")
	public ResponseEntity<List<SalesReport>> getSalesReport(@PathVariable Integer appid){
		List<SalesReport> savedList=service.getSalesReport(appid);
		return new ResponseEntity<>(savedList, HttpStatus.OK);
	}
	
	@PostMapping("/saveSalesReport/{appId}")
	public ResponseEntity<List<SalesReport>> saveSalesReport(
	        @PathVariable Integer appId,
	        @RequestBody List<SalesReport> salesReport) {

	    List<SalesReport> savedList = service.saveSalesReport(appId, salesReport);

	    return new ResponseEntity<List<SalesReport>>(savedList, HttpStatus.OK);
	}
	
	@GetMapping("/getTxnsData/{appId}")
	public ResponseEntity<List<TransactionHistory>> getTxnsData(@PathVariable Integer appId){
		List<TransactionHistory> getTransaction=service.getTxnsData(appId);
		return new ResponseEntity<>(getTransaction, HttpStatus.OK);
	}
	
	@GetMapping("/filtertransactions/{appId}")
	public ResponseEntity<List<TransactionHistory>> getTransactionsFilter(@PathVariable Integer appId,@RequestParam String statusOrInstrument,@RequestParam List<String> statusOrInstrumentTypesList){
		List<TransactionHistory> filterList=service.getTransactionsFilter(appId,statusOrInstrument,statusOrInstrumentTypesList);
		return new ResponseEntity<>(filterList, HttpStatus.OK);
	}
	
	@GetMapping("/fetchtransactions/{appId}")
	public ResponseEntity<List<TransactionHistory>> fetchTransactions(@PathVariable Integer appId,
					@RequestParam(required = false) String duration,
					
					@RequestParam(required = false)
					@DateTimeFormat(pattern = "dd-mm-yyyy")
					LocalDate startDate,
					
					@RequestParam(required = false)
					@DateTimeFormat(pattern = "dd-MM-yyyy")
    					LocalDate endDate
					
				){
		List<TransactionHistory> fetchedRecords=service.fetchTransactions(appId,duration,startDate,endDate);
		return new ResponseEntity<List<TransactionHistory>>(fetchedRecords, HttpStatus.OK);
	}

}
