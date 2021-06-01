package com.finance.layer4;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.finance.layer2.OrderTable;
import com.finance.layer2.TransactionTable;
import com.finance.layer4.exceptions.OrderNotFoundException;

@Service
public interface OrderService {
	void addOrderService(OrderTable ordRef) ;   //C - add/create
	OrderTable findOrderService(long ordId) throws OrderNotFoundException;     //R - find/reading
	Set<OrderTable> findOrdersService();     //R - find all/reading all
	//String modifyOrderService(OrderTable ordRef) throws OrderNotFoundException; //U - modify/update
	Set<OrderTable> findOrdersByCardNoService(long cardNo);
	//String removeOrderService(long ordId); //D - remove/delete
}
