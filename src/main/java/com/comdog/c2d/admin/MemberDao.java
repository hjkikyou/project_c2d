package com.comdog.c2d.admin;

import java.util.List;

import com.comdog.c2d.dto.MemberDto;

public interface MemberDao {

	//조회
	List<MemberDto> findAllMembers();

	//추가
	void add(MemberDto item);
	
	//변경
	MemberDto findMemberById(Long id);

	void update(MemberDto member);

	//삭제
	void deleteDeliveryByMemberId(Long id);
	void deleteOrderItemByMemberId(Long id); 
	void deleteOrdersByMemberId(Long id);
	void delete(Long id);
	
	//검색 기능
	List<MemberDto> selectMembersByEmail(String keyword);

	List<MemberDto> selectMembersByName(String keyword);

	List<MemberDto> selectMembersByPhone(String keyword);

	MemberDto login(MemberDto memberDto);

}
