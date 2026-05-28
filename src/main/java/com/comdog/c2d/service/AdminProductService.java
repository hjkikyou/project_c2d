package com.comdog.c2d.service;

import java.util.List;

import com.comdog.c2d.dto.Product;

public interface AdminProductService {
	
		List<Product> list();

		void delete(Long id);

		void add(Product item);

		Product item(Long id);

		void update(Product item);

}
