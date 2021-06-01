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

import com.finance.layer2.RegistrationTable;

@Repository
public class RegistrationRepositoryImpl implements RegistrationRepository {

	 @PersistenceContext
	 EntityManager entityManager;
	

	@Transactional
	public void addRegistration(RegistrationTable rRef) {
		entityManager.persist(rRef);
	}

	@Transactional
	public RegistrationTable findRegistration(long reg_id) {	
		return entityManager.find(RegistrationTable.class, reg_id);
	}

	
	@Transactional
	public Set<RegistrationTable> findAllRegistrations() {
		
		List<RegistrationTable> list = new ArrayList<RegistrationTable>();
		
		TypedQuery<RegistrationTable> query = entityManager.createNamedQuery("RegistrationTable.findAll", RegistrationTable.class);
			  //RegistrationTableSet = (Set<RegistrationTable>) query.getResultList();
		list = query.getResultList();
		Set<RegistrationTable> RegistrationTableSet = new HashSet<RegistrationTable>(list);
		return RegistrationTableSet;
	}


	@Transactional
	public void modifyRegistration(RegistrationTable rRef) {
		entityManager.merge(rRef);
	}

	
	@Transactional
	public void removeRegistration(long reg_id) {
		RegistrationTable regTemp = entityManager.find(RegistrationTable.class, reg_id);
		entityManager.remove(regTemp);
	}

}