package com.tejait.batch16.serviceImpl;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejait.batch16.model.Payment;
import com.tejait.batch16.repository.PaymentRepository;
import com.tejait.batch16.service.Paymentservice;
@Service
public class PaymentServiceImpl implements Paymentservice{
	private static final Logger logger=LogManager.getLogger(PaymentServiceImpl.class);
	@Autowired
	PaymentRepository repository;
	
	@Override
	public Payment savePayment(Payment payment) {
		logger.debug("Entered into payment service save payment method");
		logger.info("Payment data : {}",payment);
		
		if(payment.getAmount()<=0) {
			logger.warn("Negative amount detected : {}",payment.getAmount());
			payment.setTransactionId(UUID.randomUUID().toString());
			payment.setStatus("Failed");
			logger.error("Negative amount detected and amount is : {}",payment.getAmount());
			return repository.save(payment);
		}
		
		if(payment.getAmount()>100000) {
			logger.warn("Fraud alert detected amount is : {}",payment.getAmount());
		}
		
		try {
			payment.setTransactionId(UUID.randomUUID().toString());
			payment.setStatus("Successfull");
			return repository.save(payment);
		}catch(Exception e) {
			logger.error("Error in saving payment data : {}",payment);
			payment.setStatus("Failed");
			return repository.save(payment);
		}
		
		
	}

}
