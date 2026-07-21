package com.tejait.batch16.dto;

import lombok.Data;

@Data
public class Overview {
	
	private int appId;//LoanApplication
	private Long mobile;//LoanApplication
	private String CompanyPan;//CompanyDetails
	private String CompanyName;//Company Details
	private String mail;//LoanApplication
	private int tenure;//BusinessProduct
	private Long loanAmt;//BusinessProduct

}
