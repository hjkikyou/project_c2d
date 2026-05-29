package com.comdog.c2d.domain.order;

import java.util.List;

import com.comdog.c2d.dto.Order;

public interface OrderService {

	//조회
	List<Order> findAllOrders();

}
