package com.comdog.c2d.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserMainController {
    
    @GetMapping("/")
    public String home(){
        return "user/index";
    }
}