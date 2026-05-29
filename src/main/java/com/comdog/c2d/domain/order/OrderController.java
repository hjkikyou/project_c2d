package com.comdog.c2d.domain.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comdog.c2d.dto.Order;


@Controller
@RequestMapping("/admin/order")
public class OrderController {
	
	@Autowired
	OrderService service;
	
	//조회
	@GetMapping("/list")
	public String getOrderListPage(Model model) {
		List<Order> orderList = service.findAllOrders();
		model.addAttribute("viewOrderList", orderList);
		return "admin/order/list";
	}
}
