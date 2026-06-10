package com.comdog.c2d.domain.member;

import java.util.List;

import com.comdog.c2d.dto.MemberDto;

public interface MemberService {
	
	//조회
	List<MemberDto> findAllMembers();

	//추가
	void add(MemberDto item);
	
	//변경
	MemberDto findMemeberById(Long id);

	void update(MemberDto member);

	//삭제
	void delete(Long id);
	
	//검색 기능
	List<MemberDto> findMembersByEmail(String keyword);

	List<MemberDto> findMembersByName(String keyword);

	List<MemberDto> findMembersByPhone(String keyword);

	MemberDto login(MemberDto memberDto);

	}
	
	
	
	
	
