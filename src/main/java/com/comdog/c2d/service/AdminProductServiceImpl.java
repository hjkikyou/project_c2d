package com.comdog.c2d.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comdog.c2d.dao.AdminProductDao;
import com.comdog.c2d.dto.Product;

@Service
public class AdminProductServiceImpl implements AdminProductService {
	
	@Autowired
	AdminProductDao dao;
	
	@Override
	public List<Product> list() {
		return dao.list();
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
		
	}

	@Override
	public void add(Product item) {
		dao.add(item);
		
	}

	@Override
	public Product item(Long id) {
	return dao.item(id);
	}

	@Override
	public void update(Product item) {
		dao.update(item);

		
	}

}
