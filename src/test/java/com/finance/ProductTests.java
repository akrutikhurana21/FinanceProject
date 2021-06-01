package com.finance;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.finance.layer2.OrderTable;
import com.finance.layer2.ProductTable;
import com.finance.layer3.ProductRepository;


@ContextConfiguration
@SpringBootTest
class ProductTests {
	
	@Autowired
	ProductRepository prodRepo;
	
	@Test
	void addProdTest() {		//successful
		ProductTable prod = new ProductTable();
		prod.setProductName("LG TV");
		prodRepo.addProduct(prod);
	}
	
	@Test
	void ProductFindTest() {		//successful
		System.out.println("--------------");
	    System.out.println(prodRepo.findProduct(1102).getProductName());
	}
	@Test
	void findAllProductsTest() {		//successful
		 Set<ProductTable> prodSet =prodRepo.findAllProducts();
			for (ProductTable prod: prodSet) {
				System.out.println(prod.getProductId());
				System.out.println(prod.getProductName());
				System.out.println("-----------------");
			}
	}
	
	@Test
    void modifyProductTest() {		//successful
        System.out.println("-----------------");
        ProductTable prod = prodRepo.findProduct(1102);
        prod.setProductName("Samsung");
        prodRepo.modifyProduct(prod);
    }
	
	@Test
	void TestDelete() {		//successful
		prodRepo.removeProduct(78);
	}
	
	
}