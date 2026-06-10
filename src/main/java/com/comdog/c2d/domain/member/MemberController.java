package com.comdog.c2d.domain.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comdog.c2d.dto.MemberDto;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/member")
public class MemberController {
	
	@Autowired
	MemberService service;

	/* -- 조회 -- */
	@GetMapping("/list")
	public String getMemberListPage(
	
	//검색 기능 추가	
	@org.springframework.web.bind.annotation.RequestParam(value = "search", required = false) String search,
	@org.springframework.web.bind.annotation.RequestParam(value = "keyword", required = false) String keyword,
	//-------------
		Model model) {
		
		List<MemberDto> memberList;

		// 검색어(keyword)가 입력되었는지 확인 (공백 제외)
		if (keyword != null && !keyword.trim().isEmpty()) {
			// select 박스의 value 값(email, name, phone)에 따라 서비스 메서드 분기 처리
			if ("email".equals(search)) {
				memberList = service.findMembersByEmail(keyword); // 💡 이메일 검색
			} else if ("name".equals(search)) {
				memberList = service.findMembersByName(keyword);  // 💡 이름 검색
			} else if ("phone".equals(search)) {
				memberList = service.findMembersByPhone(keyword); // 💡 전화번호 검색
			} else {
				memberList = service.findAllMembers();
			}
		} else {
			// 검색어가 없으면 기존처럼 전체 목록 조회
			memberList = service.findAllMembers();
		}
		
		model.addAttribute("viewMemberList", memberList);
		return "admin/member/list";
	}
	 /* -- 추가 --*/
	 @GetMapping("/add")
	 public String showAddForm() {
		 return "admin/member/add";
	 }
	 
	 @PostMapping("/add")
	 String addMember(MemberDto item) {
		 service.add(item);
		 
		 return "redirect:/admin/member/list";
	 }
	 
	 /* -- 변경 -- */
	 @GetMapping("/update/{id}")
	 public String showUpdateForm(@PathVariable Long id, Model model) {
		 MemberDto member = service.findMemeberById(id);
		 model.addAttribute("viewMember", member);
		 
		 return "admin/member/update";
	 }
	 
	 @PostMapping("/update/{id}")
	 String updateMember(@PathVariable Long id, MemberDto member) {
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
	 
	 
	 /*--로그인기능 (URL은 현재 /admin/member/login 으로 매핑됩니다) --*/

	// 로그인 페이지 매핑 (실제 주소: /admin/member/login)
	@GetMapping("/log-in")
	public String loginForm() {
	    return "user/auth/log-in"; // templates/log-in.html
	}

	// 로그인 처리 (실제 주소: /admin/member/login)
	@PostMapping("/log-in")
	public String login(MemberDto memberDto, HttpSession session) {
	    // 💡 memberService -> service 로 변수명 수정!
	    MemberDto loginUser = service.login(memberDto);
	    
	    if (loginUser != null) {
	        // 보안을 위해 세션 저장 전 패스워드는 소거
	        loginUser.setPassword(null);
	        session.setAttribute("loginUser", loginUser);
	        return "redirect:/"; // 메인 페이지로 이동
	    } else {
	        // 로그인 실패 시 쿼리 스트링 에러 파라미터 전달 (실제 주소로 리다이렉트)
	        return "redirect:/user/auth/log-in?error=true";
	    } 
	}

	// 로그아웃 처리 (실제 주소: /admin/member/logout)
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate();
	    return "redirect:/";
	}
	 
	}

