package com.comdog.c2d.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comdog.c2d.dto.Product;
import com.comdog.c2d.service.AdminProductService;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {
	
	@Autowired
	AdminProductService service;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Product> list =service.list();
		
		// 🔍 여기에 이 코드를 넣어서 서버 콘솔에 진짜 뭐가 찍히는지 봐주세요!
	    if (list != null && !list.isEmpty()) {
	        System.out.println("======== [디버깅] 첫 번째 상품 ID: " + list.get(0).getId());
	    }
		
		model.addAttribute("list",list);
		return "admin/product/list";
	}
	
	@GetMapping("/delete/{id}")
		String delete(@PathVariable Long id) {
			service.delete(id);
			
			return "redirect:/admin/product/list";
	}
	@GetMapping("/add")
	String add() {
		return "product/add";
	}
	@PostMapping("/add")
	String add(Product item) {
		service.add(item);
		
		return "redirect:/product/list";
				
	}
	@GetMapping("/update/{id}")
	String update(@PathVariable Long id, Model model) {
		Product item = service.item(id);
	model.addAttribute("item", item);
	return "product/update.html";
	}
	@PostMapping("/update/{id}")
	String update(@PathVariable Long id, Product item) {
	item.setId(id);
	service.update(item);
	return "redirect:../list";
	}
}
