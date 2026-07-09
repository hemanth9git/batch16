package com.tejait.batch16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejait.batch16.model.LoanApplication;

@Repository
public interface LoanRepository extends JpaRepository<LoanApplication, Integer>{
	
	public LoanApplication findByMailId(String name);
	public LoanApplication findByMobile(long number);
	

}
