package com.comdog.c2d.domain.product;

import java.util.List;

import com.comdog.c2d.dto.Product;

public interface ProductDao {
	
	//조회
	List<Product> findAllProducts();
	
	//추가
	void add(Product item);
	
	//변경
	Product findProductById(Long id);

	void update(Product product);

	//삭제
	void deleteOrderItemByProductId(Long id); // 💡 이 줄 추가!
	void delete(Long id); // 기존 메서드



}
