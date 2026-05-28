package com.comdog.c2d.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/orders")
public class OrdersController {
	
	@GetMapping("/list")
	public String list() {
		return "admin/orders/list";
	}
}
