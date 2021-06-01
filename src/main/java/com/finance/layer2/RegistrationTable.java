package com.finance.layer2;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the REGISTRATION_TABLE database table.
 * 
 */
@Entity
@Table(name="REGISTRATION_TABLE")
@NamedQuery(name="RegistrationTable.findAll", query="SELECT r FROM RegistrationTable r")
public class RegistrationTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REG_ID")
	private long regId;

	private String address;

	@Column(name="ADHAR_CARD")
	private long adharCard;

	@Column(name="CARD_TYPE")
	private String cardType;

	@Column(name="DOB", columnDefinition = "DATE")
    private LocalDate dob = LocalDate.now();

	@Column(name="EMAIL_ID")
	private String emailId;

	private String name;

	private String password;

	@Column(name="PHONE_NO")
	private long phoneNo;

	@Column(name="REGISTRATION_DATE", columnDefinition = "DATE")
    private LocalDate registrationDate = LocalDate.now();
	
	private String username;
//
//	//bi-directional many-to-one association to ApprovalTable
//	@OneToMany(mappedBy="registrationTable1", fetch=FetchType.EAGER)
//	private Set<ApprovalTable> approvalTables;

	//bi-directional many-to-one association to BankTable
	//@OneToMany(mappedBy="registrationTable", fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@OneToMany(mappedBy="registrationTable")
	private Set<BankTable> bankTable;

	//bi-directional one-to-one association to ApprovalTable
	//@OneToOne(cascade = CascadeType.ALL)
	//@OneToOne
	//@JoinColumn(name="REG_ID", referencedColumnName="REG_ID")
	//private ApprovalTable approvalTable;
	@OneToOne(mappedBy ="registrationTable",cascade = CascadeType.ALL)
	private ApprovalTable approvalTable;

	public RegistrationTable() {
	}

	public long getRegId() {
		return this.regId;
	}

	public void setRegId(long regId) {
		this.regId = regId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getAdharCard() {
		return this.adharCard;
	}

	public void setAdharCard(long adharCard) {
		this.adharCard = adharCard;
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public LocalDate getDob() {
		return this.dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public LocalDate getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//	public Set<ApprovalTable> getApprovalTables() {
//		return this.approvalTables;
//	}
//
//	public void setApprovalTables(Set<ApprovalTable> approvalTables) {
//		this.approvalTables = approvalTables;
//	}

//	public ApprovalTable addApprovalTable(ApprovalTable approvalTable) {
//		getApprovalTables().add(approvalTable);
//		approvalTable.setRegistrationTable1(this);
//
//		return approvalTable;
//	}
//
//	public ApprovalTable removeApprovalTable(ApprovalTable approvalTable) {
//		getApprovalTables().remove(approvalTable);
//		approvalTable.setRegistrationTable1(null);
//
//		return approvalTable;
//	}

	public Set<BankTable> getBankTable() {
		return this.bankTable;
	}

	public void setBankTable(Set<BankTable> bankTable) {
		this.bankTable = bankTable;
	}

	public BankTable addBankTable(BankTable bankTable) {
		getBankTable().add(bankTable);
		bankTable.setRegistrationTable(this);

		return bankTable;
	}

	public BankTable removeBankTable(BankTable bankTable) {
		getBankTable().remove(bankTable);
		bankTable.setRegistrationTable(null);

		return bankTable;
	}

	public ApprovalTable getApprovalTable() {
		return this.approvalTable;
	}

	public void setApprovalTable(ApprovalTable approvalTable) {
		this.approvalTable = approvalTable;
	}

}