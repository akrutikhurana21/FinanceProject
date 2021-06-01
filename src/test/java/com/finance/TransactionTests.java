package com.finance;



import java.time.LocalDate;

import java.util.HashSet;

import java.util.Set;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.finance.layer2.OrderTable;
import com.finance.layer2.TransactionTable;
import com.finance.layer3.CardRepository;
import com.finance.layer3.OrderRepository;
import com.finance.layer3.ProductRepository;
import com.finance.layer3.RegistrationRepository;
import com.finance.layer3.TransactionRepository;

@ContextConfiguration
@SpringBootTest
class TransactionTests {
	@Autowired
	TransactionRepository tranRepo;
	
	@Autowired
	OrderRepository ordRepo;
	
	@Autowired
	CardRepository crdRepo;
	

	@Autowired
	RegistrationRepository regRepo;
	
	@Test
	void findTransactionTest() {		//successful
		System.out.println("........");

		 TransactionTable trans=new TransactionTable();
		 trans=tranRepo.findTransaction(12);
		 System.out.println("transaction id:"+trans.getTransId());
		 System.out.println("due amt:"+trans.getDueAmt()); 
		 System.out.println("installment:"+trans.getInstallment());
		 System.out.println("order id:"+trans.getOrderTable().getOrdId());
		 System.out.println("month no:"+trans.getMonthNo());
		 System.out.println("Date of transaction:"+trans.getTransDate());

		 
		}
	
	@Test
	void findAllTransactionsTest() {			//successful
		System.out.println("..........................");
		Set<TransactionTable> tranSet = new HashSet<>();
		  tranSet= tranRepo.findAllTransactions();
		 for(TransactionTable trans:tranSet) {
			 System.out.println("trans id:"+trans.getTransId()); 
			 System.out.println("due amt:"+trans.getDueAmt()); 
			 System.out.println("order id:"+trans.getOrderTable().getOrdId());
			 System.out.println("installment:"+trans.getInstallment());
			 System.out.println("month no:"+trans.getMonthNo());
			 System.out.println("Date of transaction:"+trans.getTransDate());
			 System.out.println("..........................");
		 }
		 
		}
	
	@Test
	void modifyTransactionTest() {		//successful
		System.out.println("..........................");
		TransactionTable trans=new TransactionTable();
		trans=tranRepo.findTransaction(91);
		trans.setDueAmt(3720.0);
		tranRepo.modifyTransaction(trans);
		}
	
	@Test
	void addTransactionTest() { 		//successful
		System.out.println("..........................");
		TransactionTable trans=new TransactionTable();
		OrderTable ord= new OrderTable();
		ord=ordRepo.findOrder(108);
		trans.setDueAmt(50000.0);
		trans.setInstallment(50000.0);
		trans.setMonthNo(2);
		trans.setTransDate(LocalDate.of(2021, 05,23 ));
		trans.setOrderTable(ord);
		
		tranRepo.addTransaction(trans);
		
		}
	
	@Test
	void deleteTransactionTest() { 			// Successful if cascade is not given in orderTable 
									//because it can't delete the child when it is having cascade relationship with parent 
		System.out.println("..........................");
		tranRepo.removeTransaction(92);
		}

	@Test
	void findTransactionsByOrderTest() {// find Transactions By Order
		System.out.println("..........................");
		Set<TransactionTable> tranSet2 = new HashSet<>();
		tranSet2=tranRepo.findTransactionsByOrder(1);
		for(TransactionTable trans:tranSet2) {
			 System.out.println("trans id:"+trans.getTransId()); 
			 System.out.println("due amt:"+trans.getDueAmt()); 
			 System.out.println("order id:"+trans.getOrderTable().getOrdId());
			 System.out.println("installment:"+trans.getInstallment());
			 System.out.println("month no:"+trans.getMonthNo());
			 System.out.println("Date of transaction:"+trans.getTransDate());
			 System.out.println("..........................");
		 }
		}
		
	
}

