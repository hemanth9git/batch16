package com.tejait.batch16.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch16.model.Payment;
import com.tejait.batch16.service.Paymentservice;

@RestController
@RequestMapping(value="payment")
public class PaymentController {
public static final	Logger logger=LogManager.getLogger(PaymentController.class);

@Autowired
Paymentservice service;

	@GetMapping("savePayment")
	public ResponseEntity<Payment> savePayment(@RequestBody Payment payment){
		logger.debug("Entered into payment controller make Payment method");
		logger.info("Payment data : {}",payment);
		Payment savedPayment=service.savePayment(payment);
		logger.info("Saved payment data : {}",savedPayment);
		return new ResponseEntity<Payment>(savedPayment, HttpStatus.OK);
	}
}
