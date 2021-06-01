package com.finance.layer2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the PRODUCT_TABLE database table.
 * 
 */
@Entity
@Table(name="PRODUCT_TABLE")
@NamedQuery(name="ProductTable.findAll", query="SELECT p FROM ProductTable p")
public class ProductTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCT_ID")
	private long productId;

	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="PRODUCT_PRICE")
	private Double productPrice;
	
	@Column(name="IMAGE_URL")
	private String imageUrl;

	//bi-directional many-to-one association to OrderTable
	@OneToMany(mappedBy="productTable", fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	//@OneToMany(mappedBy="productTable")
	private Set<OrderTable> orderTables;

	public ProductTable() {
	}

	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Set<OrderTable> getOrderTables() {
		return this.orderTables;
	}

	public void setOrderTables(Set<OrderTable> orderTables) {
		this.orderTables = orderTables;
	}

	public OrderTable addOrderTable(OrderTable orderTable) {
		getOrderTables().add(orderTable);
		orderTable.setProductTable(this);

		return orderTable;
	}

	public OrderTable removeOrderTable(OrderTable orderTable) {
		getOrderTables().remove(orderTable);
		orderTable.setProductTable(null);

		return orderTable;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}