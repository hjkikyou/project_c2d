package com.comdog.c2d.domain.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comdog.c2d.dto.ContractDto;


@Controller
@RequestMapping("/admin/contract")
public class ContractController {
	
	@Autowired 
	ContractService service;
	
	//조회
	@GetMapping("/list")
	public String getContractListPage(Model model) {
		List<ContractDto> contractList = service.findAllContracts();
		model.addAttribute("viewContractList", contractList);
		return "admin/contract/list";
	}
	
	//추가
	
}
