package com.comdog.c2d.dao;

import java.util.List;

import com.comdog.c2d.dto.Product;

public interface AdminProductDao {
	
	List<Product> list();

	void delete(Long id);

	void add(Product item);

	Product item(Long id);

	void update(Product item);

}
