package com.finance.layer4;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.finance.layer2.ApprovalTable;

@Repository
public interface ApprovalService{
	void addApprovalService(ApprovalTable aRef);   //C - add/create
	ApprovalTable findApprovalService(long approvalNo);     //R - find/reading
	Set<ApprovalTable> findAllApprovalsService();     //R - find all/reading all
	void modifyApprovalService(ApprovalTable aRef); //U - modify/update
	//void removeApprovalService(long approvalNo); //D - remove/delete

}
