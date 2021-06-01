package com.finance.layer3;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.finance.layer2.BankTable;


@Repository
public class BankRepositoryImpl implements BankRepository {

	 @PersistenceContext
	 EntityManager entityManager;
	
	@Transactional
	public void addBank(BankTable bRef ) {
		entityManager.persist(bRef);
	}

	@Transactional
	public BankTable findBank(long accountNo) {	
		return entityManager.find(BankTable.class, accountNo);
	}

	@Transactional
	public Set<BankTable> findAllBanks() {
		
		List<BankTable> list = new ArrayList<BankTable>();
		
		TypedQuery<BankTable> query = entityManager.createNamedQuery("BankTable.findAll", BankTable.class);
			  //RegistrationTableSet = (Set<RegistrationTable>) query.getResultList();
		list = query.getResultList();
		Set<BankTable> BankTableSet = new HashSet<BankTable>(list);
		return BankTableSet;
	}

	@Override
	@Transactional
	public void modifyBank(BankTable bRef) {
		entityManager.merge(bRef);
	}

	@Override
	@Transactional
	public void removeBank(long accountNo) {
		BankTable bnkTemp = entityManager.find(BankTable.class, accountNo);
		entityManager.remove(bnkTemp);
	}

}