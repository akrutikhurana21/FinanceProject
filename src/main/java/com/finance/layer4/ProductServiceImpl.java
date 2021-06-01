package com.finance.layer4;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.layer2.ProductTable;
import com.finance.layer3.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository prodRepo;
	
	@Override
	public void addProductService(ProductTable prodRef) {
		System.out.println("Product Service....Some scope of bussiness logic here...");
			prodRepo.addProduct(prodRef);
		
	}

	@Override
	public ProductTable findProductService(long productId)  {
		System.out.println("Product Service....Some scope of bussiness logic here...");
		ProductTable product = prodRepo.findProduct(productId);
		return product;
	}

	@Override
	public Set<ProductTable> findProductsService() {
		System.out.println("Product Service....Some scope of bussiness logic here...");
		return prodRepo.findAllProducts();
	}

	@Override
	public void modifyProductService(ProductTable prodRef) {
		System.out.println("Product Service....Some scope of bussiness logic here...");
		
		ProductTable prod =prodRepo.findProduct(prodRef.getProductId());
		prodRepo.modifyProduct(prodRef);
		}
	
	}