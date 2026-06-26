package com.tejait.batch16.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="payment_b16")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int paymentId;
private int amount;
private String transactionId;
private String status;
private String payerName;


@Override
public String toString() {
	return "Payment [paymentId=" + paymentId + ", amount=" + amount + ", transactionId=" + transactionId + ", status="
			+ status + ", payerName=" + payerName + "]";
}

public int getPaymentId() {
	return paymentId;
}
public void setPaymentId(int paymentId) {
	this.paymentId = paymentId;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}

public String getTransactionId() {
	return transactionId;
}
public void setTransactionId(String transactionId) {
	this.transactionId = transactionId;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getPayerName() {
	return payerName;
}
public void setPayerName(String payerName) {
	this.payerName = payerName;
}

}
