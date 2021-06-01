package com.finance.layer5;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.finance.layer2.ProductTable;
import com.finance.layer4.ProductService;


@CrossOrigin(origins="http://localhost:4200")
@RestController  //REpresentational State Transfer html xml json
public class ProductController {
	
	@Autowired
	ProductService prodServ;
	
	@GetMapping(path="/getProd/{myprodid}")
	@ResponseBody
	
	public ProductTable getProduct(@PathVariable("myprodid") Integer prod )  {
		  System.out.println("Product Controller....Understanding client and talking to service layer...");
		  ProductTable product=null;
				product = prodServ.findProductService(prod);
				return  product;
	}
	
	@GetMapping(path="/getProducts")
	@ResponseBody
	public Set<ProductTable> getAllProducts() {
		System.out.println("Product Controller....Understanding client and talking to service layer...");
		Set<ProductTable> prodSet = prodServ.findProductsService();
		return prodSet;	
	}
	
	@PostMapping(path="/addProduct")
	public void addProduct(@RequestBody ProductTable prod) {
		System.out.println("Product Controller....Understanding client and talking to service layer...");
		ProductTable product=new ProductTable();
		product.setProductId(prod.getProductId());
		product.setProductName(prod.getProductName());
	}	
	
	@PutMapping(path="/modifyProduct")
	   public void modifyProduct(@RequestBody ProductTable prod) {
		   ProductTable product = new ProductTable();
		   product.setProductId(prod.getProductId());
		   product.setProductName(prod.getProductName());
		   prodServ.modifyProductService(prod);   
	      
	   }
}