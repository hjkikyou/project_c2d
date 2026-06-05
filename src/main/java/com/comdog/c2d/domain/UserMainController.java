package com.comdog.c2d.domain;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserMainController {
    
    @GetMapping("/")
    public String home(){
        return "user/index";
    }
    
    @GetMapping("/log_in")
    public String loginForm(Model model) {
        model.addAttribute("showHeader", false); // 로그인 페이지에서는 헤더를 숨김 처리!
        return "user/auth/log_in";
    }
}
