package com.finance.layer3;

import java.util.Set;
import org.springframework.stereotype.Repository;
import com.finance.layer2.ProductTable;

@Repository
public interface ProductRepository {
	void addProduct(ProductTable pRef);                  //C - add/create
	ProductTable findProduct(long productId);             //R - find/reading
	Set<ProductTable> findAllProducts();                     //R - find all/reading all
	void modifyProduct(ProductTable pRef);               //U - modify/update
	void removeProduct(long productId);                   //D - remove/delete
}