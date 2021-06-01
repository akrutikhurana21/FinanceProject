package com.finance.layer4;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.layer2.OrderTable;
import com.finance.layer3.OrderRepository;
import com.finance.layer4.exceptions.OrderNotFoundException;

@Service
public class OrderServiceImpl  implements OrderService {

	@Autowired
	OrderRepository ordRepo;
	
	@Override
	public void addOrderService(OrderTable ordRef) {
		// TODO Auto-generated method stub
		System.out.println("Order Service....Some scope of bussiness logic here...");
		ordRepo.addOrder(ordRef);

	}

	@Override
	public OrderTable findOrderService(long ordId) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Order Service....Some scope of bussiness logic here...");
		
		OrderTable order = ordRepo.findOrder(ordId);
		if(order==null) {
			throw new OrderNotFoundException("Order Does not exist");
		}
			
		return order;
	}

	@Override
	public Set<OrderTable> findOrdersService() {
		// TODO Auto-generated method stub
		//ordRepo.findAllOrders();
		return ordRepo.findAllOrders();
	}

//	@Override
//	public String modifyOrderService(OrderTable ordRef) throws OrderNotFoundException {
//		// TODO Auto-generated method stub
//		OrderTable order = ordRepo.findOrder(ordRef.getOrdId());
//		if(order==null) {
//		
//			throw new OrderNotFoundException("Order Does not exist");
//			}
//	 else {
//		 ordRepo.modifyOrder(ordRef);
//	 }
//	return "Order modified successfully";
//}

	@Override
	public Set<OrderTable> findOrdersByCardNoService(long cardNo) {
		
		return ordRepo.findOrdersByCardNo(cardNo);
	}
	}


