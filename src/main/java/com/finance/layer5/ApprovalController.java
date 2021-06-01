package com.finance.layer5;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.finance.layer2.ApprovalTable;
import com.finance.layer2.RegistrationTable;
import com.finance.layer3.RegistrationRepository;
import com.finance.layer4.ApprovalService;



@RestController  //REpresentational State Transfer html xml json
public class ApprovalController {
	
	@Autowired
	ApprovalService apprServ;
	@Autowired
	RegistrationRepository regRepo;
	@GetMapping(path="/getAppr/{myapprovalNo}")
	@ResponseBody
	
	public ApprovalTable getApproval(@PathVariable("myapprovalNo") Integer  apprl )  {
		  System.out.println("approval Controller....Understanding client and talking to service layer...");
		  ApprovalTable approval=null;
				approval = apprServ.findApprovalService(apprl);
				return approval;
	}
	
	@GetMapping(path="/getApprs")
	@ResponseBody
	public Set<ApprovalTable> getAllApprovals() {
		System.out.println("Approval Controller....Understanding client and talking to service layer...");
		Set<ApprovalTable> apprSet = apprServ.findAllApprovalsService();
		return apprSet;	
	}
	
	@PostMapping(path="/addAppr")
	public void addApproval(@RequestBody ApprovalTable appr) {
		System.out.println("Approval Controller....Understanding client and talking to service layer...");
	    RegistrationTable r = new RegistrationTable();
	    r=regRepo.findRegistration(91);
		ApprovalTable a = new ApprovalTable();
		a.setApprovalStatus(appr.getApprovalStatus());
		a.setCardFee(appr.getCardFee());
		a.setCardTable(null);
		a.setRegistrationTable(r);
		apprServ.addApprovalService(a);
		
	}	
//	
//	@PutMapping(path="/modifyAppr")
//	   public void modifyApproval(@RequestBody ApprovalTable appr) {
//		  
//	   }
}