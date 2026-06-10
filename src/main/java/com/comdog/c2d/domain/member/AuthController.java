package com.comdog.c2d.domain.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comdog.c2d.dto.MemberDto;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/auth")
public class AuthController {
    
    @Autowired
    AuthService authService;
    
    /*-- 로그인 기능 (URL: /user/auth/log-in) --*/

    // 로그인 페이지 매핑
    @GetMapping("/log-in")
    public String loginForm(Model model) {
        model.addAttribute("showHeader", false); // 로그인 페이지에서는 헤더를 숨김 처리!
        return "user/auth/log-in"; // templates/user/auth/log-in.html
    }

    // 실제 로그인 처리 매핑
    @PostMapping("/log-in")
    public String loginProcess(MemberDto memberDto, HttpSession session, Model model) throws Exception {
        // email과 password가 담긴 memberDto를 서비스로 전달
        MemberDto loginMember = authService.login(memberDto);
        
        if (loginMember != null) {
            // 보안을 위해 세션 저장 전 패스워드는 소거
            loginMember.setPassword(null);
            // 로그인 성공 시 세션에 회원 정보 저장
            session.setAttribute("loginMember", loginMember);
            return "redirect:/"; // 메인 페이지로 리다이렉트
        } else {
            // 로그인 실패 시 에러 메시지와 함께 다시 로그인 페이지로
            model.addAttribute("loginError", "이메일 또는 비밀번호가 일치하지 않습니다.");
            model.addAttribute("showHeader", false); // 실패해서 다시 돌아갈 때도 헤더 숨김 유지
            return "user/auth/log-in";
        } 
    }

    /*-- 로그아웃 기능 (URL: /user/auth/log-out) --*/
    @GetMapping("/log-out")
    public String logout(HttpSession session) {
        session.invalidate(); // 현재 세션에 저장된 모든 정보(로그인 정보 등)를 삭제
        return "redirect:/"; // 로그아웃 후 메인 페이지로 이동
    }
}