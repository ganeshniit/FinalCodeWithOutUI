package com.alibaba.DAO;

import java.util.List;

import com.alibaba.model.Product;

public interface ProductDAO {
	
	void addProduct(Product product);
	List<Product> viewProducts();
	void deleteProductById(int id);
}
