package com.finance.layer5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finance.dto.BankDto;
import com.finance.layer2.BankTable;
import com.finance.layer2.RegistrationTable;
import com.finance.layer3.BankRepository;
import com.finance.layer3.RegistrationRepository;


@CrossOrigin(origins="http://localhost:4200")
@RestController  //REpresentational State Transfer html xml json
public class BankController {
	
	@Autowired
	BankRepository bnkRepo;
	@Autowired
	RegistrationRepository regRepo;
	
	@PostMapping(path="/addBnk")
	public void addBank(@RequestBody BankDto bnkdto) {
		System.out.println("Bank Controller....Understanding client and talking to service layer...");
	    BankTable b = new BankTable();
	    RegistrationTable r= regRepo.findRegistration(bnkdto.getRegId()); 
	    b.setBankType(bnkdto.getBankType());
	    b.setIfscCode(bnkdto.getIfscCode());
	    b.setRegistrationTable(r);
	    bnkRepo.addBank(b);
		
	    
	}	

}