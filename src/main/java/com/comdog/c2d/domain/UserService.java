package com.comdog.c2d.domain;

import com.comdog.c2d.dto.MemberDto;

public interface UserService {

    // 회원가입
    void signup(MemberDto memberDto);

    // 이메일 중복 확인 (true = 사용 가능)
    boolean isEmailAvailable(String email);
}
