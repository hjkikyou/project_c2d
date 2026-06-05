package com.comdog.c2d.domain.order;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comdog.c2d.dto.OrderDetailDto;
import com.comdog.c2d.dto.OrderListDto;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	//조회 [검색]
	@Override
	public List<OrderListDto> searchOrders(Map<String, String> params) {
		
		return orderDao.searchOrders(params);
	}
	
	//상세 조회
	@Override
	public OrderDetailDto findOrderDetail(Long orderId) {
		
		return orderDao.findOrderDetail(orderId);
	}

	//주문 상태 변경
	@Override
	public void updateOrderStatus(Map<String, Object> params) {
		
		orderDao.updateOrderStatus(params);
		
	}

	// 주문 취소
	@Override
	public void cancelOrder(Long orderId) {
		
		orderDao.cancelOrder(orderId);
		
	}

	
	
}
