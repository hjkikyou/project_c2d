package com.comdog.c2d.domain.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comdog.c2d.dto.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	SqlSession sql;
	
	
	//조회
	@Override
	public List<Product> findAllProducts() {
		return sql.selectList("product.findAllProducts"); 
		// 💡 뒤의 "list"를 "findAllProducts"로 맞춰줍니다!
	}
	
	//추가
	@Override
	public void add(Product item) {
		sql.insert("product.add", item);
		
	}
	
	//변경
	@Override
	public Product findProductById(Long id) {
	
		return sql.selectOne("product.findProductById", id);
	}

	@Override
	public void update(Product product) {
		sql.update("product.update", product);
	}


	//삭제
	@Override
	public void delete(Long id) {
		sql.delete("product.delete",id);
		
	}




}
