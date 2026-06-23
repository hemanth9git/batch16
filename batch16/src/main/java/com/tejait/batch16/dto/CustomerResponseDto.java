package com.tejait.batch16.dto;

public class CustomerResponseDto {
	//customer
	private String name;
	private String address;
	//cardDtls
	private int cdid;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCdid() {
		return cdid;
	}
	public void setCdid(int cdid) {
		this.cdid = cdid;
	}
	public long getCardNum() {
		return cardNum;
	}
	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}
	private long cardNum;
	//private int cvv;
	//private int pin;
}
