package com.comdog.c2d;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

	  @GetMapping("/")
	    public String home(){
	        return "user/index";
	    }
	  
	  @GetMapping("/admin")
	    public String admin(){
	        return "admin/index";
	    }
}
