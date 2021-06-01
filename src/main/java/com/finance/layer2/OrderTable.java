package com.finance.layer2;

import java.io.Serializable;


import java.time.LocalDate;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the ORDER_TABLE database table.
 * 
 */
@Entity
@Table(name="ORDER_TABLE")
@NamedQuery(name="OrderTable.findAll", query="SELECT o FROM OrderTable o")
public class OrderTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORD_ID")
	private long ordId;

	@Column(name="DATE_ORDER", columnDefinition = "DATE")
    private LocalDate orderDate = LocalDate.now();

	@Column(name="EMI_MONTHS")
	private int emiMonths;

	@Column(name="EMI_PER_MONTH")
	private Double emiPerMonth;

	private int quantity;

	@Column(name="REMAINING_AMOUNT")
	private Double remainingAmount;

	@Column(name="TOTAL_COST")
	private Double totalCost;

	//bi-directional many-to-one association to CardTable
	//@ManyToOne( fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name="CARD_NO")
	private CardTable cardTable;

	//bi-directional many-to-one association to ProductTable
	//@ManyToOne( fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private ProductTable productTable;

	//bi-directional many-to-one association to TransactionTable
	@OneToMany(mappedBy="orderTable", fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<TransactionTable> transactionTables;

	public OrderTable() {
	}

	public long getOrdId() {
		return this.ordId;
	}

	public void setOrdId(long ordId) {
		this.ordId = ordId;
	}

	
//	public Date getDateOrder() {
//		return this.dateOrder;
//	}
//
//	public void setDateOrder(Date dateOrder) {
//		this.dateOrder = dateOrder;
//	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public int getEmiMonths() {
		return this.emiMonths;
	}

	public void setEmiMonths(int emiMonths) {
		this.emiMonths = emiMonths;
	}

	public Double getEmiPerMonth() {
		return this.emiPerMonth;
	}

	public void setEmiPerMonth(Double emiPerMonth) {
		this.emiPerMonth = emiPerMonth;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getRemainingAmount() {
		return this.remainingAmount;
	}

	public void setRemainingAmount(Double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public Double getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	@JsonIgnore
	@JsonProperty
	public CardTable getCardTable() {
		return this.cardTable;
	}

	public void setCardTable(CardTable cardTable) {
		this.cardTable = cardTable;
	}
	@JsonIgnore
	@JsonProperty
	public ProductTable getProductTable() {
		return this.productTable;
	}

	public void setProductTable(ProductTable productTable) {
		this.productTable = productTable;
	}

	public Set<TransactionTable> getTransactionTables() {
		return this.transactionTables;
	}

	public void setTransactionTables(Set<TransactionTable> transactionTables) {
		this.transactionTables = transactionTables;
	}

	public TransactionTable addTransactionTable(TransactionTable transactionTable) {
		getTransactionTables().add(transactionTable);
		transactionTable.setOrderTable(this);

		return transactionTable;
	}

	public TransactionTable removeTransactionTable(TransactionTable transactionTable) {
		getTransactionTables().remove(transactionTable);
		transactionTable.setOrderTable(null);

		return transactionTable;
	}

}