package com.comdog.c2d.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/member/list")
    public String memberList(){
        return "member/list";
    }
}
