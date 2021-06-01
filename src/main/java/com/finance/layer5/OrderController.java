package com.finance.layer5;

import java.util.HashMap;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finance.layer2.CardTable;
import com.finance.layer2.OrderTable;
import com.finance.layer2.ProductTable;
import com.finance.layer2.TransactionTable;
import com.finance.layer4.OrderService;
import com.finance.layer4.exceptions.OrderNotFoundException;

@CrossOrigin(origins="http://localhost:4200")
@RestController 
public class OrderController {
	
	@Autowired
	OrderService ordServ;
	
	 @GetMapping(path="/getOrder/{myordid}") //Get Request in Postman http://localhost:8080/getDept/1
	    @ResponseBody
	    
	    public ResponseEntity<OrderTable> getOrder(@PathVariable("myordid") Integer ord) throws OrderNotFoundException {
		  System.out.println("Order Controller....Understanding client and talking to service layer...");
		  OrderTable order=null;
				order = ordServ.findOrderService(ord);
				if(order==null) {
					Map m = new HashMap();
					m.put("message", "Order Not Found");
					//HeadersBuilder hb = ResponseEntity.notFound();
					
					HttpStatus status =HttpStatus.NOT_FOUND;
					//return new ResponseEntity(m,status);
					return ResponseEntity.notFound().build();
					//return new 
					
				}
				else {
					return ResponseEntity.ok(order);
				}  
	 }
	 @GetMapping(path="/getOrders")
		@ResponseBody
		public Set<OrderTable> getAllOrders() {
			System.out.println("Order Controller....Understanding client and talking to service layer...");
			Set<OrderTable> ordSet= ordServ.findOrdersService();
			return ordSet;
			
		}
	   @PostMapping(path="/addOrder")
	    public void addOrder(@RequestBody OrderTable ord) {
		   System.out.println("Order controller Understanding client ");
		   OrderTable order = new OrderTable();
		   CardTable crd = new CardTable();
		   ProductTable prod= new ProductTable();
		   order.setCardTable(ord.getCardTable());
		   order.setProductTable(ord.getProductTable());
		   order.setOrderDate(ord.getOrderDate());
		   order.setEmiMonths(ord.getEmiMonths());
		   order.setTotalCost(ord.getTotalCost());
		   order.setQuantity(ord.getQuantity());
		   order.setEmiPerMonth(ord.getEmiPerMonth()); 
		   order.setRemainingAmount(ord.getRemainingAmount());
	    }
//	   @PutMapping(path="/modifyOrder")
//	   public void modifyOrder(@RequestBody OrderTable ord) {
//		   OrderTable order = new OrderTable();
//		   order.setQuantity(ord.getQuantity());
//		   order.setEmiPerMonth(ord.getEmiPerMonth()); 
//		   ordServ.modifyOrderService(order);
	      
//	   }
	   @GetMapping(path="/getOrdersByCard/{myCard}")
		@ResponseBody
		public Set<OrderTable> getOrdersByCardNo(@PathVariable("myCard") Integer cardNo) {
			System.out.println("Order Controller....Understanding client and talking to service layer...");
			Set<OrderTable> orderSet = ordServ.findOrdersByCardNoService(cardNo);
			return orderSet;
			
		}
	   
	   
//	   @DeleteMapping(path="/deleteDeptById/{mydno}")
//	   @ResponseBody
//	   public String deleteDepartment(@PathVariable("mydno")Integer dno) {
//	       String statusMsg = null;
//			try {
//				statusMsg = deptServ.removeDepartmentService(dno);
//			} catch (DepartmentNotFoundException e) {
//				// TODO Auto-generated catch block
//				return e.getMessage();
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
//	      return statusMsg;
	   }
	 