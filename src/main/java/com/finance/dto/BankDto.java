package com.finance.dto;

public class BankDto {
	private String bankType;
	private String ifscCode;
	private long regId;
	public String getBankType() {
		return bankType;
	}
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public long getRegId() {
		return regId;
	}
	public void setRegId(long regId) {
		this.regId = regId;
	}
	public BankDto() {
		
	}
	
}
