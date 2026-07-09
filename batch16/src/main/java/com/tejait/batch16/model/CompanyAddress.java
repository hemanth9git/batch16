package com.tejait.batch16.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "company_address")
public class CompanyAddress {

	private int id;
	private int appId;
	private String flatNum;
	private String building;
	private String line;
	private String state;
	private String city;
	private Long pincode;
	private String landmark;
	private String area;
}
