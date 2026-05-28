package com.comdog.c2d.dao;

import java.util.List;

import com.comdog.c2d.dto.Product;

public interface ProductDao {
	
	//추가
	List<Product> findAllProducts();
	
	void add(Product item);
	
	//변경
	Product findProductById(Long id);

	void update(Product product);

	//삭제
	void delete(Long id);



}
