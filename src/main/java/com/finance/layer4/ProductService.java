package com.finance.layer4;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.finance.layer2.ProductTable;

@Service
public interface ProductService {
		public void addProductService(ProductTable prodRef);   //C - add/create
		ProductTable findProductService(long productId);    //R - find/reading
		Set<ProductTable> findProductsService();     //R - find all/reading all
		void modifyProductService(ProductTable prodRef); //U - modify/update
		//void removeDepartmentService(long productId)throws ProductNotFoundException; //D - remove/delete
		
	}
