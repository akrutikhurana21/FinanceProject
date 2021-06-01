package com.finance;
import java.time.LocalDate;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.finance.layer2.ApprovalTable;
import com.finance.layer2.BankTable;
import com.finance.layer2.CardTable;
import com.finance.layer3.ApprovalRepository;
import com.finance.layer3.CardRepository;
import com.finance.layer3.OrderRepository;
import com.finance.layer3.ProductRepository;
import com.finance.layer3.RegistrationRepository;
import com.finance.layer3.TransactionRepository;


@ContextConfiguration
@SpringBootTest
class CardTests {
	
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
            app=appRepo.findApproval(66);
            System.out.println(app.getApprovalNo());
            System.out.println(app.getApprovalStatus());
            
            card.setApprovalTable(app);
            card.setCardLimit(30000.00);
            card.setStartDate(LocalDate.of(2021, 05,30));
            card.setEndDate(LocalDate.of(2022, 05,30));
            card.setCustName(regRepo.findRegistration(64).getName());
            cardRepo.addCard(card);
    }
	
	@Test
	void modifyCardTest() {			//Successful
		System.out.println("-----------");
		CardTable card =cardRepo.findCard(106);
		
		card.setCustName("JANE");
		card.setCardLimit(40000.0);
		card.setEndDate(LocalDate.of(2022,05,24));

		cardRepo.modifyCard(card);
	}
	
	@Test
	void findCardTest() { 		//Successful
		
		System.out.println("------------");
        CardTable card =cardRepo.findCard(106);
        System.out.println("Approval No : "+card.getApprovalTable().getApprovalNo());
        System.out.println("Card No : "+card.getCardNo());
        System.out.println("Customer Name : "+regRepo.findRegistration(104).getName());
        System.out.println("Start Date : "+card.getStartDate());
        System.out.println("End Date : "+card.getEndDate());
        System.out.println("Card Limit : "+card.getCardLimit());
        
	}
	
	@Test
	void findAllCardsTest() { 
		Set<CardTable> CardTableSet = cardRepo.findAllCards();
		
		for(CardTable card: CardTableSet) {
			
			System.out.println("Approval No : "+card.getApprovalTable().getApprovalNo());
	        System.out.println("Card No : "+card.getCardNo());
	        System.out.println("Customer Name : "+regRepo.findRegistration(104).getName());
	        System.out.println("Start Date : "+card.getStartDate());
	        System.out.println("End Date : "+card.getEndDate());
	        System.out.println("Card Limit : "+card.getCardLimit());
		}
	}
	
	@Test
	void removeCardTest() {
		cardRepo.removeCard(46);
	}
}
