package com.comdog.c2d.domain.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comdog.c2d.dto.Order;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	//조회
	@Override
	public List<Order> findAllOrders() {
		return orderDao.findAllOrders();
	}

}
