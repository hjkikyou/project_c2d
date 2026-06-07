package com.comdog.c2d.domain;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.comdog.c2d.dto.MemberDto;

@Controller
@RequestMapping("/user") // URL은 /user 로 시작합니다.
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입 폼 페이지
    @GetMapping("/signup")
    public String signupForm() {
        // 🌟 수정됨: 실제 폴더 경로(user/auth/)와 파일명(sign_up) 일치
        return "user/auth/sign_up"; 
    }

    // 회원가입 처리
    @PostMapping("/signup")
    public String signup(@ModelAttribute MemberDto memberDto,
                         @RequestParam(value = "agreePromo", defaultValue = "false") boolean agreePromo,
                         Model model) {
        try {
            memberDto.setIsSubscribed(agreePromo);
            userService.signup(memberDto);
            // 🌟 수정됨: 리다이렉트 URL 경로를 /user/... 로 통일
            return "redirect:/user/signup/success";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMsg", e.getMessage());
            // 🌟 수정됨: 에러 발생 시 다시 보여줄 뷰 경로 일치
            return "user/auth/sign_up"; 
        }
    }

    // 회원가입 완료 페이지
    @GetMapping("/signup/success")
    public String signupSuccess() {
        // (주의) 캡처 이미지에는 성공 페이지 html이 안 보입니다.
        // 만약 auth 폴더 안에 sign_up_success.html 로 만드셨다면 아래처럼 적어야 합니다.
        return "user/auth/sign_up_success"; 
    }

    // 이메일 중복 확인 (비동기)
    @GetMapping("/check-email")
    @ResponseBody
    public boolean checkEmail(@RequestParam String email) {
        return userService.isEmailAvailable(email);
    }
}