package com.comdog.c2d.domain.member;

import com.comdog.c2d.dto.MemberDto;

public interface AuthDao {
	
	//로그인
	MemberDto login(MemberDto memberDto) throws Exception;

}
