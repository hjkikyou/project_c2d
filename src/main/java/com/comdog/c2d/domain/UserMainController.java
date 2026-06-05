package com.comdog.c2d.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserMainController {
    
    @GetMapping("/")
    public String home(){
        return "user/index";
    }
    
    @GetMapping("/log_in") 
    public String loginForm() {
        return "user/auth/log_in"; // templates/log_in.html을 찾아감
    }
}
