package com.finance.layer5;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finance.dto.CardDto;
import com.finance.layer2.CardTable;
import com.finance.layer4.CardService;


@CrossOrigin(origins="http://localhost:4200")
@RestController  //REpresentational State Transfer html xml json
public class CardController {
	
	@Autowired
	CardService crdServ;

	 @GetMapping(path="/getCard/{mycrdno}") //Get Request in Postman http://localhost:8080/getDept/1
	    @ResponseBody
	    
	    public CardDto getCard(@PathVariable("mycrdno") Long crdno)  {
		  System.out.println("Card Controller....Understanding client and talking to service layer...");
		  CardDto cd = crdServ.findCardDetails(crdno);
		  return cd;
	 }
	 
	 @GetMapping(path="/getCards")
		@ResponseBody
		public Set<CardTable> getAllCards() {
			System.out.println("Card Controller....Understanding client and talking to service layer...");
			Set<CardTable> crdSet = crdServ.findCardService();
			return crdSet;
		}
	 
	 @PostMapping(path="/addCard")
	 public void addCard(@RequestBody CardTable crd) {
		 System.out.println("Card controller Understanding client ");
		 
		 CardTable card = new CardTable();	
		 card.setApprovalTable(crd.getApprovalTable());
		 card.setCardLimit(crd.getCardLimit());
		 card.setCustName(crd.getCustName());
		 card.setEndDate(crd.getEndDate());
		 card.setStartDate(crd.getStartDate());
		 card.setOrderTables(crd.getOrderTables());	 
		 crdServ.addCardService(card);
	 }
	   
	}
	 