package com.finance.dto;

public class LoginDto {

	public LoginDto() {
		System.out.println("LoginDto ctor()...");
	}
	private String username;
	private String password;
	private long cardNo;
	
	public long getCardNo() {
		return cardNo;
	}
	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
