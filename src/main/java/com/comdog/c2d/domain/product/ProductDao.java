package com.comdog.c2d.domain.product;

import java.util.List;

import com.comdog.c2d.dto.ProductDto;

public interface ProductDao {
	
	//조회
	List<ProductDto> findAllProducts();
	
	//추가
	void add(ProductDto item);
	
	//변경
	ProductDto findProductById(Long id);

	void update(ProductDto product);

	//삭제
	void delete(Long id);



}
