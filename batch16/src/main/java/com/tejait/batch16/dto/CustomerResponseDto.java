package com.tejait.batch16.dto;

public class CustomerResponseDto {
	//customer
	private Integer customerId;
	private String name;
	private String address;
	//cardDtls
	private Integer cardId;
	//private int cdid;
	private long cardNum;
	private String cardType;
	//private int cvv;
	//private int pin;
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getCardId() {
		return cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
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
//	public int getCdid() {
//		return cdid;
//	}
//	public void setCdid(int cdid) {
//		this.cdid = cdid;
//	}
	public long getCardNum() {
		return cardNum;
	}
	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}
	
}
