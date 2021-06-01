package com.finance;

import java.util.Set;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.finance.layer2.ApprovalTable;
import com.finance.layer2.RegistrationTable;
import com.finance.layer3.ApprovalRepository;
import com.finance.layer3.RegistrationRepository;


@ContextConfiguration
@SpringBootTest
class ApprovalTests {
	
	@Autowired
	ApprovalRepository appRepo;
	@Autowired
	RegistrationRepository regRepo;
	
	@Test
	void approvalAddTest() {				//Successful
		System.out.println("-----------------");
		ApprovalTable app=new ApprovalTable();
	    RegistrationTable reg= new RegistrationTable();
		reg=regRepo.findRegistration(64);
		System.out.println(reg.getRegId());
		app.setRegistrationTable(reg);
		app.setApprovalStatus("YES");
		app.setCardFee(2000);
		appRepo.addApproval(app);
	}
	
	@Test
	void approvalFindTest() {		//Successful
		System.out.println("........");
		ApprovalTable app=appRepo.findApproval(1001);
		System.out.println(app.getApprovalNo());
		System.out.println(app.getApprovalStatus());
     	System.out.println(app.getCardFee());
		System.out.println("........");
		 
	}
		 @Test
		 void findAllApprovalsTest() {		//Successful
		 Set<ApprovalTable> ApprovalTableSet=appRepo.findAllApprovals();
	            for (ApprovalTable app: ApprovalTableSet) {
	            	System.out.println(app.getApprovalNo());
	            	System.out.println(app.getApprovalStatus());
	            	System.out.println(app.getCardFee());
	            	System.out.println("-----------------");
            }
	
}
	@Test
    void TestModify() {		//Successful
        System.out.println("-----------------");
        ApprovalTable app = appRepo.findApproval(1001);
        app.setApprovalStatus("YES");
        appRepo.modifyApproval(app);
    }
}