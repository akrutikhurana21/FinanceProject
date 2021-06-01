package com.finance.layer3;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.finance.layer2.CardTable;
import com.finance.layer2.OrderTable;


@Repository
public interface OrderRepository {
	void addOrder(OrderTable oRef);   //C - add/create
	OrderTable findOrder(long ordno);     //R - find/reading
	Set<OrderTable> findAllOrders();     //R - find all/reading all
	void modifyOrder(OrderTable oRef); //U - modify/update
	void removeOrder(long ordno); //D - remove/delete	
	Set<OrderTable> findOrdersByCardNo(long cardNo);
}
