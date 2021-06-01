package com.finance.layer2;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


/**
 * The persistent class for the TRANSACTION_TABLE database table.
 * 
 */
@Entity
@Table(name="TRANSACTION_TABLE")
@NamedQuery(name="TransactionTable.findAll", query="SELECT t FROM TransactionTable t")
public class TransactionTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TRANS_ID")
	private long transId;

	@Column(name="DUE_AMT")
	private Double dueAmt;

	private Double installment;

	@Column(name="MONTH_NO")
	private int monthNo;
	
	@Column(name="TRANS_DATE", columnDefinition = "DATE")
    private LocalDate transDate = LocalDate.now();

	//bi-directional many-to-one association to OrderTable
	//@ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name="ORD_ID")
	private OrderTable orderTable;

	public TransactionTable() {
	}

	public long getTransId() {
		return this.transId;
	}

	public void setTransId(long transId) {
		this.transId = transId;
	}

	public Double getDueAmt() {
		return this.dueAmt;
	}

	public void setDueAmt(Double dueAmt) {
		this.dueAmt = dueAmt;
	}

	public Double getInstallment() {
		return this.installment;
	}

	public void setInstallment(Double installment) {
		this.installment = installment;
	}

	public int getMonthNo() {
		return this.monthNo;
	}

	public void setMonthNo(int monthNo) {
		this.monthNo = monthNo;
	}

	public LocalDate getTransDate() {
		return this.transDate;
	}

	public void setTransDate(LocalDate transDate) {
		this.transDate = transDate;
	}
	
	@JsonIgnore
	@JsonProperty
	public OrderTable getOrderTable() {
		return this.orderTable;
	}

	public void setOrderTable(OrderTable orderTable) {
		this.orderTable = orderTable;
	}

}