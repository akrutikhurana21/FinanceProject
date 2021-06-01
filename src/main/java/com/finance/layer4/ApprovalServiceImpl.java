package com.finance.layer4;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.layer2.ApprovalTable;
import com.finance.layer3.ApprovalRepository;

@Service
public class ApprovalServiceImpl implements ApprovalService {
	
	@Autowired
	ApprovalRepository apprRepo;
	
	@Override
	public void addApprovalService(ApprovalTable apprRef) {
		System.out.println("Approval Service....Some scope of bussiness logic here...");
			apprRepo.addApproval(apprRef);
		
	}

	@Override
	public ApprovalTable findApprovalService(long approvalNo)  {
		System.out.println("Approval Service....Some scope of bussiness logic here...");
		ApprovalTable approval = apprRepo.findApproval(approvalNo);
		return approval;
	}

	@Override
	public Set<ApprovalTable> findAllApprovalsService() {
		System.out.println("Product Service....Some scope of bussiness logic here...");
		return apprRepo.findAllApprovals();
	}

	@Override
	public void modifyApprovalService(ApprovalTable apprRef) {
		System.out.println("Approval Service....Some scope of bussiness logic here...");
		
		ApprovalTable prod =apprRepo.findApproval(apprRef.getApprovalNo());
		apprRepo.modifyApproval(apprRef);
		}
	
	}