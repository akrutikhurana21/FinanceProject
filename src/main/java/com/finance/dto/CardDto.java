package com.finance.dto;

import java.time.LocalDate;

public class CardDto {

	public CardDto() {
		System.out.println("CardDto ctor()....");
	}
	private long cardNo;
	private Double cardLimit;
	private String custName;
	private LocalDate endDate = LocalDate.now();
	private LocalDate startDate = LocalDate.now();
	public long getCardNo() {
		return cardNo;
	}
	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	public Double getCardLimit() {
		return cardLimit;
	}
	public void setCardLimit(Double cardLimit) {
		this.cardLimit = cardLimit;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	private String cardType;
	
}
