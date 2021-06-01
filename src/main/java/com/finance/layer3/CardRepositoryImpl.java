package com.finance.layer3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.finance.layer2.CardTable;
import com.finance.layer2.OrderTable;

/*
 * CardTable findCard(int cardNo);     //R - find/reading
	List<CardTable> findCard();  
 */
@Repository
public class CardRepositoryImpl implements CardRepository{
	
	@PersistenceContext
	 EntityManager entityManager;//auto injected by spring by reading 
										//persistance.xml file

	@Transactional
	public void addCard(CardTable cRef) {
		System.out.println("Card repo....NO scope of bussiness logic here...");
		entityManager.persist(cRef);
		System.out.println("Card repo....NO scope of bussiness logic here...");
		
	}

	@Transactional
	public CardTable findCard(long cardNo) {
		System.out.println("Card repo....NO scope of bussiness logic here...");
		return entityManager.find(CardTable.class,cardNo);
	
	}

	@Transactional
	public Set<CardTable> findAllCards() {
		// TODO Auto-generated method stub
		 List<CardTable> list = new ArrayList<CardTable>();
	        TypedQuery<CardTable> query = entityManager.createNamedQuery("CardTable.findAll", CardTable.class);
	        list = query.getResultList();
	        Set<CardTable> CardSet = new HashSet<CardTable>(list);
	        return CardSet;
	}

	@Transactional
	public void modifyCard(CardTable cRef) {
		entityManager.merge(cRef);
		
	}

	@Transactional
	public void removeCard(long cardNo) {
		// TODO Auto-generated method stub
		CardTable cardT = entityManager.find(CardTable.class,cardNo);
		entityManager.remove(cardT);
	}

	
	


}