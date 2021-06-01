package com.finance;

import java.time.LocalDate;


import java.util.Set;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.finance.layer2.ApprovalTable;
import com.finance.layer2.CardTable;
import com.finance.layer2.OrderTable;
import com.finance.layer2.ProductTable;
import com.finance.layer2.RegistrationTable;
import com.finance.layer2.TransactionTable;
import com.finance.layer3.ApprovalRepository;
import com.finance.layer3.CardRepository;
import com.finance.layer3.OrderRepository;
import com.finance.layer3.ProductRepository;
import com.finance.layer3.RegistrationRepository;
import com.finance.layer3.TransactionRepository;

@ContextConfiguration
@SpringBootTest
class FinanceProjectApplicationTests {
	@Autowired
	OrderRepository ordRepo;
	@Autowired
	ProductRepository prodRepo;
	@Autowired
	CardRepository cardRepo;
	@Autowired
	RegistrationRepository regRepo;
	@Autowired
	ApprovalRepository appRepo;
	@Autowired
	TransactionRepository transRepo;
	
	
	  @Test 
	    void addCardTest(){                //Successful
	            CardTable card = new CardTable();
	            ApprovalTable app = new ApprovalTable();
	            app=appRepo.findApproval(105);
	            System.out.println(app.getApprovalNo());
	            System.out.println(app.getApprovalStatus());
	            
	            card.setApprovalTable(app);
	            card.setCardLimit(30000.00);
	            card.setStartDate(LocalDate.of(2021, 05,24));
	            card.setEndDate(LocalDate.of(2022, 05,24));
	            card.setCustName(regRepo.findRegistration(104).getName());
	            cardRepo.addCard(card);
	    }
	@Test
	void TestDelete() {			//Successful
		System.out.println("..........................");
		
		prodRepo.removeProduct(1102);
	}
	@Test
	void approvalAddTest() {				//Successful
		System.out.println("-----------------");
		ApprovalTable app=new ApprovalTable();
	    RegistrationTable reg= new RegistrationTable();
		reg=regRepo.findRegistration(85);
		System.out.println(reg.getRegId());
		app.setRegistrationTable(reg);
		app.setApprovalStatus("YES");
		app.setCardFee(2000);
		appRepo.addApproval(app);
	}
	@Test
	void transAddTest() {
	TransactionTable tt4=new TransactionTable();
	OrderTable o= new OrderTable();
	o=ordRepo.findOrder(1);
	tt4.setDueAmt(50000.0);
	tt4.setInstallment(50000.0);
	tt4.setMonthNo(3);
	tt4.setTransDate(LocalDate.of(2021, 05,23 ));
	tt4.setOrderTable(o);
	
	transRepo.addTransaction(tt4);
	}
	@Test
	void approvalFindTest() {
		System.out.println("........");
		ApprovalTable app=appRepo.findApproval(1001);
		
		 System.out.println(app.getApprovalStatus());
		 System.out.println("........");
		 
		 Set<ApprovalTable> ApprovalTableSet=appRepo.findAllApprovals();
	            for (ApprovalTable a: ApprovalTableSet) {
	            	System.out.println(a.getApprovalNo());
	            	System.out.println(a.getApprovalStatus());
	            	System.out.println(a.getCardFee());
	            	System.out.println("-----------------");
            }
    }
	
	@Test
	void testFindOrder() {
		OrderTable ord =ordRepo.findOrder(1);
		CardTable crd = ord.getCardTable();
		ProductTable prod = ord.getProductTable();
		System.out.println("........");
		
		 System.out.println("Order Id: " +ord.getOrdId());
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
	void findAllOrders() {
		 Set<OrderTable> ordSet =ordRepo.findAllOrders();
			for (OrderTable o: ordSet) {
				System.out.println(o.getProductTable().getProductName());
				System.out.println(o.getOrdId());
				System.out.println("-----------------");
			}
	}
	@Test
	void findAlltransactions() {
		 Set<TransactionTable> tranSet =transRepo.findAllTransactions();
			for (TransactionTable trans: tranSet) {
				System.out.println(trans.getTransId());
				System.out.println(trans.getTransDate());
				System.out.println("-----------------");
			}
	}
	
	@Test
	void testModifyCard() {
		System.out.println("-----------");
		CardTable card =cardRepo.findCard(987654321);
		
		//card.setCardNo(15681356);
		card.setCustName("JANE");
		card.setCardLimit(40000.0);
		card.setEndDate(LocalDate.of(1996,05,22));

		cardRepo.modifyCard(card);
			}
	@Test
	void testDeleteOrder() {
		OrderTable ord = ordRepo.findOrder(1);
		ordRepo.removeOrder(1);
	}
	
	@Test
	void testAdd() {
	OrderTable ordadd= new OrderTable();
	CardTable crd = new CardTable();
	ProductTable prod= new ProductTable();
	crd=cardRepo.findCard(852014763);
	//System.out.println(crd);
    prod =prodRepo.findProduct(1102);
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
	void addProdTest() {
		ProductTable prod = new ProductTable();
		prod.setProductName("Laptop");
		prodRepo.addProduct(prod);
	}
	@Test
	void addOrderTest() {
		OrderTable ordadd = new OrderTable();
	    CardTable crd = new CardTable();
	    ProductTable prod= new ProductTable();
//	    long a = 987654321;
	  //  ordadd.setCardTable(a);
	    crd.setCardNo(852014763);
	    prod.setProductId(203);
	    ordadd.setProductTable(prod);
		ordadd.setOrderDate(LocalDate.of(2021, 05, 22));
		ordadd.setEmiMonths(5);
		ordadd.setTotalCost(5000.0);
		ordadd.setQuantity(1);
		ordadd.setEmiPerMonth(1000.0);
		ordadd.setRemainingAmount(25000.0);
		ordRepo.addOrder(ordadd);     
	      
		
//		ordadd.setCardTable(crd.setCardNo(1581));
//		ordadd.setCardTable(crd.setCardNo());
		// OrderTable add =ordRepo.addOrder(null);
	}
	@Test
	void ProductFindTest() {
		System.out.println("--------------");
	    System.out.println(prodRepo.findProduct(1102).getProductName());
	}
//	ProductTable prod = ordadd.getProductTable();
		//ordadd.setOrdId(3);
//CardTable crd = ord.setCardTable(crd.setCardNo(56748135););

//ProductTable prod = ord.getProductTable();
//prod.setProductId(999999);
//ord.getProductTable().setProductId(999999);
//ord.setQuantity(1);
//ordRepo.modifyOrder(ord);


//ordRepo.findOrder(2);
//System.out.println(ordRepo.findOrder(2).getEmi());
//System.out.println(ordRepo.findOrder(1));
//System.out.println(e.getEmployeeJob());

 //System.out.println(ord.getProductTable().getProductName());
@Test
void AddRegistertest() {
	System.out.println("-----------------------------------------");
	RegistrationTable reg = new RegistrationTable(); 
	//reg.setRegId(4);
	reg.setName("VISHAL");
	reg.setPhoneNo(123456);
	reg.setEmailId("v@sir");
	reg.setUsername("Vishal");
	reg.setPassword("Sir");
	reg.setAddress("Pune");
	reg.setCardType("Gold");
	reg.setRegistrationDate(LocalDate.of(1986,11,8));
	reg.setDob(LocalDate.of(1986,10,02));
	reg.setAdharCard(62930);
	regRepo.addRegistration(reg);
	System.out.println("----------------------------------------------");
}	
}
