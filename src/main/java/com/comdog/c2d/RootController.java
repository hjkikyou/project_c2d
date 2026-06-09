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
	  
	  @GetMapping("/sign_up_ok")
	  public String showOkPage() {
	      return "user/auth/sign_up_ok"; 
	  }

	@GetMapping("/wishlist")
	public String wishlist() {
		return "user/order/wishlist";
	}

	@GetMapping("/recent")
	public String recent() {
		return "user/order/recent";
	}

	@GetMapping("/board")
	public String board() {
		return "user/board/board";
	}
	
	@GetMapping("/event")
	public String event() {
		return "user/board/event";
	}
	

	@GetMapping("/community_board")
	public String communityBoard() {
		return "user/board/community_board";
	}
	
	@GetMapping("/refurb_list")
	public String refubList() {
		return "user/product/refurb_list";
	}
}
