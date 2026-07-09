package com.tejait.batch16.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "business_product")
public class BusinessProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int appid;
	private String purposeOfLoan;
	private String natureOfBusiness;
	private int tenure;
	private long loanAmount;

}
