package com.comdog.c2d.service;

import org.springframework.beans.factory.annotation.Autowired;

public class AdminProductServiceImpl implements AdminProductService {
	
	@Autowired
	ProductDao dao;
	
	@Override
	public List<Product> list() {
		return dao.list();
	}

}
