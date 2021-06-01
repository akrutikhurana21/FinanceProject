package com.finance;

import java.time.LocalDate;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.finance.layer2.CardTable;
import com.finance.layer2.RegistrationTable;
import com.finance.layer3.RegistrationRepository;


@ContextConfiguration
@SpringBootTest
class RegistrationTests {
	
	@Autowired
	RegistrationRepository regRepo;

	@Test
	void registerFindtest() { 				//Successful
		System.out.println("-----------------------------------");
		RegistrationTable reg = regRepo.findRegistration(2);
		System.out.println(reg.getRegId());
		System.out.println(reg.getName());
		System.out.println(reg.getPhoneNo());
		System.out.println(reg.getEmailId());
		System.out.println(reg.getUsername());
		System.out.println(reg.getPassword());
		System.out.println(reg.getAddress());
		System.out.println(reg.getCardType());
		System.out.println(reg.getRegistrationDate());
		System.out.println(reg.getDob());
		System.out.println(reg.getAdharCard());
		System.out.println("-----------------------------------");
	}
	
	@Test
	void findAllRegistrationsTest()				//Successful
	{
		
		
		Set<RegistrationTable> regSet = regRepo.findAllRegistrations();
		for (RegistrationTable r: regSet) {
			System.out.println("-----------------------------------");
			System.out.println(r.getRegId());
			System.out.println(r.getName());
			System.out.println(r.getPhoneNo());
			System.out.println(r.getEmailId());
			System.out.println(r.getUsername());
			System.out.println(r.getPassword());
			System.out.println(r.getAddress());
			System.out.println(r.getCardType());
			System.out.println(r.getRegistrationDate());
			System.out.println(r.getDob());
			System.out.println(r.getAdharCard());
			System.out.println("-----------------------------------");
	}
	
	}
	@Test
	void addRegistertest() {			//Successful
		System.out.println("-----------------------------------------");
		RegistrationTable reg = new RegistrationTable(); 

		reg.setName("DHONI");
		reg.setPhoneNo(9874561);
		reg.setEmailId("D@sir");
		reg.setUsername("Dhoni");
		reg.setPassword("BATSMAN");
		reg.setAddress("CHENAI");
		reg.setCardType("Gold");
		reg.setRegistrationDate(LocalDate.of(1986,7,8));
		reg.setDob(LocalDate.of(1991,10,20));
		reg.setAdharCard(77777);
		regRepo.addRegistration(reg);
		System.out.println("----------------------------------------------");
	}
	
	@Test
	void deleteRegistertest() {					//Successful
		System.out.println("-----------------------------------");
		regRepo.removeRegistration(84);
		System.out.println("************************************");
	}
	
	@Test
	void modifyRegistertest() {					//Successful
		System.out.println("-----------------------------------");
		RegistrationTable reg = regRepo.findRegistration(79);
		reg.setAddress("MUMBAI");
	    reg.setName("VISHALSIR");
	    regRepo.modifyRegistration(reg);
	    System.out.println("/////////////////////////////////////");
	}
	
}