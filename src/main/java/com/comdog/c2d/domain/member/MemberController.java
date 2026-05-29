package com.comdog.c2d.domain.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comdog.c2d.dto.Member;

@Controller
@RequestMapping("/admin/member")
public class MemberController {
	
	@Autowired
	MemberService service;

	/* -- 조회 -- */
	 @GetMapping("/list")
	    public String getMemberListPage (Model model) {
		 List<Member> memberList = service.findAllMembers();
		 model.addAttribute("viewMemberList", memberList);
	     
		 return "admin/member/list";
	    }
	 
	 /* -- 추가 --*/
	 @GetMapping("/add")
	 public String showAddForm() {
		 return "admin/member/add";
	 }
	 
	 @PostMapping("/add")
	 String addMember(Member item) {
		 service.add(item);
		 
		 return "redirect:/admin/member/list";
	 }
	 
	 /* -- 변경 -- */
	 @GetMapping("/update/{id}")
	 public String showUpdateForm(@PathVariable Long id, Model model) {
		 Member member = service.findMemeberById(id);
		 model.addAttribute("viewMember", member);
		 
		 return "admin/member/update";
	 }
	 
	 @PostMapping("/update/{id}")
	 String updateMember(@PathVariable Long id, Member member) {
		 member.setId(id);
		 service.update(member);
		 
		 return "redirect:/admin/member/list";
	 }
	 
	 /*---삭제---*/
	 
	 @GetMapping("/delete/{id}")
	 public String delete(@PathVariable Long id) {
			service.delete(id);
			
			return "redirect:/admin/member/list";
	}
	 
	}

