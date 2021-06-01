package com.finance.layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The persistent class for the BANK_TABLE database table.
 * 
 */
@Entity
@Table(name="BANK_TABLE")
@NamedQuery(name="BankTable.findAll", query="SELECT b FROM BankTable b")
public class BankTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ACCOUNT_NO")
	private long accountNo;

	@Column(name="BANK_TYPE")
	private String bankType;

	@Column(name="IFSC_CODE")
	private String ifscCode;

	//bi-directional many-to-one association to RegistrationTable
	//@ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name="REG_ID")
	private RegistrationTable registrationTable;

	public BankTable() {
	}

	public long getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getBankType() {
		return this.bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public String getIfscCode() {
		return this.ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
    @JsonIgnore
    @JsonProperty
	public RegistrationTable getRegistrationTable() {
		return this.registrationTable;
	}

	public void setRegistrationTable(RegistrationTable registrationTable) {
		this.registrationTable = registrationTable;
	}

}