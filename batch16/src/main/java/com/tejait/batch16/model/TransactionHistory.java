package com.tejait.batch16.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "transactions")
public class TransactionHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trid;
	private int appid;
	private Date transactionDate;
	private String activity;
	private String source;
	private long txnId;
	private String comment;
	private double debtAmt;
	private double creditAmt;
	private String transactionBreakup;
	private String transactionStatus;
	private String instrument;

}
