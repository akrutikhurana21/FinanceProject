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

import com.finance.layer2.OrderTable;
import com.finance.layer2.TransactionTable;



@Repository
public class OrderRepositoryImpl implements OrderRepository {
	
	
	@PersistenceContext
	 EntityManager entityManager;//auto injected by spring by reading 
										//persistance.xml file

	@Transactional
	public void addOrder(OrderTable oRef) {
		entityManager.persist(oRef);
		
	}

	@Transactional
	public OrderTable findOrder(long ordno) {
		System.out.println("Order repo....NO scope of bussiness logic here...");
		return entityManager.find(OrderTable.class,ordno);
	
	}

	@Transactional
	public Set<OrderTable> findAllOrders() {
		// TODO Auto-generated method stub
        List<OrderTable> list = new ArrayList<OrderTable>();
        TypedQuery<OrderTable> query = entityManager.createNamedQuery("OrderTable.findAll", OrderTable.class);
        list = query.getResultList();
        Set<OrderTable> OrderTableSet = new HashSet<OrderTable>(list);
        return OrderTableSet;
	}

	@Transactional
	public void modifyOrder(OrderTable oRef) {
		entityManager.merge(oRef);
		
	}

	@Transactional
	public void removeOrder(long ordno) {
		// TODO Auto-generated method stub
		OrderTable ordT = entityManager.find(OrderTable.class,ordno);
		entityManager.remove(ordT);
	}

	@Transactional
	public Set<OrderTable> findOrdersByCardNo(long cardNo) {
		// TODO Auto-generated method stub
		Set<OrderTable> orderSet;
		Query query=entityManager.createQuery("from OrderTable o where card_no =:mycard",OrderTable.class).setParameter("mycard",cardNo);
		orderSet = new HashSet(query.getResultList());
		return orderSet;
	}

	


}
