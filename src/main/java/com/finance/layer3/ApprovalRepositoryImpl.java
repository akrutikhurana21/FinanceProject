package com.finance.layer3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.finance.layer2.ApprovalTable;

@Repository
public class ApprovalRepositoryImpl implements ApprovalRepository {
	
	
	@PersistenceContext
	 EntityManager entityManager;//auto injected by spring by reading 
										//persistance.xml file
	
	@Transactional//no need of begin transaction and commit rollback
	public void addApproval(ApprovalTable aRef) {//usesA
		entityManager.persist(aRef);

	}
	
	@Transactional
	public ApprovalTable findApproval(long approvalNo) {//producesA Department obj
		System.out.println("ApprovalTable repo....NO scope of bussiness logic here...");
		return entityManager.find(ApprovalTable.class,approvalNo);
		
	}
	
	@Transactional
	public Set<ApprovalTable> findAllApprovals() {
		// TODO Auto-generated method stub
		List<ApprovalTable> list = new ArrayList<ApprovalTable>();
		TypedQuery<ApprovalTable> query = entityManager.createNamedQuery("ApprovalTable.findAll",ApprovalTable.class);
		list = query.getResultList();
		Set<ApprovalTable> ApprovalTableSet = new HashSet<ApprovalTable>(list);		
		return ApprovalTableSet;
	}

	
	@Transactional
	public void modifyApproval(ApprovalTable aRef) {
		entityManager.merge(aRef);

	}

	@Transactional
	public void removeApproval(long approvalNo) {
		ApprovalTable aTemp = entityManager.find(ApprovalTable.class,approvalNo);
		entityManager.remove(aTemp);
		
	}
}