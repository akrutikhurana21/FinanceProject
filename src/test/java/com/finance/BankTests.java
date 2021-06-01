package com.finance;

import java.util.Set;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.finance.layer2.BankTable;
import com.finance.layer2.RegistrationTable;
import com.finance.layer3.BankRepository;
import com.finance.layer3.RegistrationRepository;

@ContextConfiguration
@SpringBootTest
 class BankTests {
	@Autowired
	BankRepository bankRepo;
	@Autowired
	RegistrationRepository regRepo;
	
	@Test
	void addBanktest() {			//successful
		System.out.println("-------------------------------------");
		BankTable bank=new BankTable();
	    RegistrationTable reg= new RegistrationTable();
	    reg=regRepo.findRegistration(104);
	    bank.setBankType("KOTK");
	    bank.setIfscCode("KOT012345");
	    bank.setRegistrationTable(reg);
	    bankRepo.addBank(bank);
	}

	@Test
    void findBankTest() {			//successful
        System.out.println("------------");
        BankTable bank =bankRepo.findBank(111);
        System.out.println("Registration Id: " +bank.getRegistrationTable().getRegId());
        System.out.println("Account No: " +bank.getAccountNo());
        System.out.println("Bank Type: " +bank.getBankType());
        System.out.println("IFSC Code: " +bank.getIfscCode());
        
        System.out.println("------------");
	}
	
	@Test
    void findAllBanksTest() {			//successful
        Set<BankTable> BankTableSet = bankRepo.findAllBanks();
        
        for(BankTable bank: BankTableSet) {
        	System.out.println("Registration Id: " +bank.getRegistrationTable().getRegId());
        	System.out.println("Account No: " +bank.getAccountNo());
            System.out.println("Bank Type: " +bank.getBankType());
            System.out.println("IFSC Code: " +bank.getIfscCode()); 
            
            System.out.println("------------");
        }
    }
	
	@Test
	void modifyBankTest() {			//successful
	   System.out.println("---------------------------------------------------------------");
	   BankTable bank = bankRepo.findBank(111);
	   bank.setBankType("KOTAK BANK");
       bankRepo.modifyBank(bank);
	    }
	
	@Test
	void deleteBanktest() {			//successful
		//BankTable bank = bankRepo.findBank(111);
		bankRepo.removeBank(111);
		}
	
	

}