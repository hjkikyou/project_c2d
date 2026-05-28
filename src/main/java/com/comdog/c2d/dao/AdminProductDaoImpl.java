package com.comdog.c2d.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comdog.c2d.dto.Product;

@Repository
public class AdminProductDaoImpl implements AdminProductDao {
	
	@Autowired
	SqlSession sql;
	
	@Override
	public List<Product> list() {
		return sql.selectList("product.list");
	}

	@Override
	public void delete(Long id) {
		sql.delete("product.delete",id);
		
	}

	@Override
	public void add(Product item) {
		sql.insert("product.add", item);
		
	}

	@Override
	public Product item(Long id) {
	return sql.selectOne("product.item", id);
	}

	@Override
	public void update(Product item) {
		sql.update("product.update", item);
		
	}


}
