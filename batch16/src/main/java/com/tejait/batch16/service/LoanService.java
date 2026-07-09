package com.tejait.batch16.service;

import java.util.List;

import com.tejait.batch16.model.LoanApplication;

public interface LoanService {


	LoanApplication applyLoan(LoanApplication loan);

	List<LoanApplication> LoansList();

}
