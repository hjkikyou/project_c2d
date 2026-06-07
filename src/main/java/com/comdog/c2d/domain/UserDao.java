package com.comdog.c2d.domain;

import com.comdog.c2d.dto.MemberDto;

public interface UserDao {

    // 회원 등록
    void insertMember(MemberDto memberDto);

    // 이메일로 회원 수 조회 (중복 확인용)
    int countByEmail(String email);
}
