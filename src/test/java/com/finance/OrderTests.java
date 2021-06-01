package com.finance;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.finance.layer2.CardTable;
import com.finance.layer2.OrderTable;
import com.finance.layer2.ProductTable;
import com.finance.layer2.TransactionTable;
import com.finance.layer3.CardRepository;
import com.finance.layer3.OrderRepository;
import com.finance.layer3.ProductRepository;
import com.finance.layer3.RegistrationRepository;

@ContextConfiguration
@SpringBootTest
class OrderTests {						//Successful
	@Autowired
	OrderRepository ordRepo;
	@Autowired
	ProductRepository prodRepo;
	@Autowired
	CardRepository cardRepo;
	@Autowired
	RegistrationRepository regRepo;
	
	@Test
	void addOrderTest() {  								//Successful
	OrderTable ordadd= new OrderTable();
	CardTable crd = new CardTable();
	ProductTable prod= new ProductTable();
	crd=cardRepo.findCard(regRepo.findRegistration(104).getApprovalTable().getCardTable().getCardNo());
	//System.out.println(crd);
    prod =prodRepo.findProduct(115);
    //System.out.println(crd);
	ordadd.setCardTable(crd);
	ordadd.setProductTable(prod);
	ordadd.setOrderDate(LocalDate.of(2021, 05, 23));
	ordadd.setEmiMonths(6);
	ordadd.setTotalCost(36000.0);
	ordadd.setQuantity(1);
	ordadd.setEmiPerMonth(6000.0);
	ordadd.setRemainingAmount(4000.0);
	ordRepo.addOrder(ordadd);
	}
	
	@Test
	void findOrderTest() {				//Successful
		OrderTable ord =ordRepo.findOrder(1);
		CardTable crd = ord.getCardTable();
		ProductTable prod = ord.getProductTable();
		System.out.println("........");
		
		 System.out.println("Order Id: "+ord.getOrdId());
		 System.out.println("Card Number: "+crd.getCardNo());
		 System.out.println("Product Id: " +prod.getProductId());
		 System.out.println("Order Date: " +ord.getOrderDate());
		 System.out.println("EMI Months: " +ord.getEmiMonths());
		 System.out.println("Total Cost: " +ord.getTotalCost());
		 System.out.println("Quantity :    " +ord.getQuantity());
		 System.out.println("EMI Per Month: " +ord.getEmiPerMonth());
		 System.out.println("Remaining Amount: " +ord.getRemainingAmount());
		 System.out.println("-----------------");
	}
	@Test
	void findAllOrdersTest() {						//Successful
		 Set<OrderTable> ordSet =ordRepo.findAllOrders();
			for (OrderTable o: ordSet) {
				 System.out.println("Order Id: " +o.getOrdId());
				 System.out.println("Card Number: "+o.getCardTable().getCardNo());
				 System.out.println("Product Id: " +o.getProductTable().getProductId());
				 System.out.println("Order Date: " +o.getOrderDate());
				 System.out.println("EMI Months: " +o.getEmiMonths());
				 System.out.println("Total Cost: " +o.getTotalCost());
				 System.out.println("Quantity :    " +o.getQuantity());
				 System.out.println("EMI Per Month: " +o.getEmiPerMonth());
				 System.out.println("Remaining Amount: "+o.getRemainingAmount());
				 System.out.println("-----------------");
			}
	}
	
	@Test
	void modifyOrderTest() {				//Successful
		System.out.println("-----------");
		OrderTable order =ordRepo.findOrder(4);
		order.setEmiMonths(6);
		order.setEmiPerMonth(1000.0);
		order.setOrderDate(LocalDate.of(2021,05,22));

		ordRepo.modifyOrder(order);
			}
	
	
	@Test
	void deleteOrderTest() {		//Successful
		OrderTable ord = ordRepo.findOrder(93);
		ordRepo.removeOrder(93);
	}
	
	@Test
	void findOrdersByCardNo() {
		System.out.println("..........................");
		Set<OrderTable> orderSet = new HashSet<>();
		orderSet=ordRepo.findOrdersByCardNo(987654321);
		for(OrderTable order:orderSet) {
			 System.out.println("Order Id: "+order.getOrdId()); 
			 System.out.println("Product Id: "+order.getProductTable().getProductId()); 
			 System.out.println("Order Date: "+order.getOrderDate());
			 System.out.println("EmiMonths: "+order.getEmiMonths());
			 System.out.println("TotalCost: "+order.getTotalCost());
			 System.out.println("Quantity : "+order.getQuantity());
			 System.out.println("EmiPerMonth : "+order.getEmiPerMonth());
			 System.out.println("Remaining Amount: "+order.getRemainingAmount());
			 System.out.println("..........................");
		 }
	}
	
	
}