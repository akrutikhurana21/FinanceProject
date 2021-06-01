package com.finance.layer3;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.finance.layer2.ApprovalTable;

@Repository
public interface ApprovalRepository{
	void addApproval(ApprovalTable aRef);   //C - add/create
	ApprovalTable findApproval(long approvalNo);     //R - find/reading
	Set<ApprovalTable> findAllApprovals();     //R - find all/reading all
	void modifyApproval(ApprovalTable aRef); //U - modify/update
	void removeApproval(long approvalNo); //D - remove/delete

}
