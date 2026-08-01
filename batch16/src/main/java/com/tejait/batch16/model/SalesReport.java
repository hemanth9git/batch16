package com.tejait.batch16.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "salesreport")
@Data 
public class SalesReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int slid;
	private int appid;
 
	//@CreationTimestamp
	@DateTimeFormat(pattern="dd-mm-yyyy")
	@Temporal(TemporalType.DATE)
	private Date date;
	private int orderno;
	private String invoiceno;	
	private String partyName;
	private Long partyPhoneNum;
	private int totalAmount;
	private int recievedOrPaidAmount;
	private int balanceAmount;
	

}
