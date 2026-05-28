package com.comdog.c2d.domain.product;

import java.util.List;

import com.comdog.c2d.dto.Product;

public interface ProductService {
		
		//조회
		List<Product> findAllProducts(); // 💡 컨트롤러에서 호출한 이름과 똑같이 변경!
		
		//추가
		void add(Product item);
		
		//변경
		Product findProductById(Long id);
		
		void update(Product product);
		
		//삭제
		void delete(Long id);

		

		

}
