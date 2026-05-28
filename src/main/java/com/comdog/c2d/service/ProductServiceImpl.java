package com.comdog.c2d.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comdog.c2d.dao.ProductDao;
import com.comdog.c2d.dto.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao; //dao -> productDao로 고쳤음
	
	//추가
	@Override
	public List<Product> findAllProducts() { // 💡 컨트롤러에서 호출한 이름과 똑같이 변경!
		return productDao.findAllProducts(); // 💡 DAO의 메서드 이름도 똑같이 맞춰주는 것이 관례상 가장 좋습니다.
	}
	
	@Override
	public void add(Product item) {
		productDao.add(item);
		
	}
	
	//변경
	@Override
	public Product findProductById(Long id) {
	return productDao.findProductById(id);  // 💡 DAO 메서드도 동일한 이름으로 호출하는 것이 정석입니다
	}

	@Override
	public void update(Product product) {
		productDao.update(product);
	}

	//삭제
	@Override
	public void delete(Long id) {
		productDao.delete(id);
		
	}


	

}
