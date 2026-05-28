package com.comdog.c2d.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin/contract")
public class ContractController {
	
	@GetMapping("/list")
	public String contract() {
		return "admin/contract/list";
	}
}
