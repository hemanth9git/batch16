package com.tejait.batch16.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tejait.batch16.exceptions.DetailsAlreadyExists;
import com.tejait.batch16.model.LoanApplication;
import com.tejait.batch16.repository.LoanRepository;
import com.tejait.batch16.service.LoanService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements LoanService{

	LoanRepository repository;

	@Override
	public LoanApplication applyLoan(LoanApplication loan) {
		loan.setCustomerName(loan.getFname().concat(" "+loan.getLname()));
		
		String mail=loan.getMailId();
		long mobileNumber=loan.getMobile();
		
		LoanApplication findByEmail=repository.findByMailId(mail);
		if(findByEmail!=null) {
			throw new DetailsAlreadyExists("Mail Id already exists try with other mailId");
		}
		
		LoanApplication findByMobile=repository.findByMobile(mobileNumber);
		if(findByMobile!=null) {
			throw new DetailsAlreadyExists("Mobile number already exists try with other mobile..");
		}
		
		
		return repository.save(loan);
	}

	@Override
	public List<LoanApplication> LoansList() {
		
		return repository.findAll();
	}

	
	
	
}
