package com.comdog.c2d.domain.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminMainController {
    
    @GetMapping("/admin")
    public String admin(){
        return "admin/index";
    }
}