package com.comdog.c2d.domain.member;

import java.util.List;

import com.comdog.c2d.dto.Member;

public interface MemberDao {

	//조회
	List<Member> findAllMembers();

	//추가
	void add(Member item);
	
	//변경
	Member findMemberById(Long id);

	void update(Member member);

	//삭제
	void deleteDeliveryByMemberId(Long id);
	void deleteOrderItemByMemberId(Long id); 
	void deleteOrdersByMemberId(Long id);
	void delete(Long id);
	
	//검색 기능
	List<Member> selectMembersByEmail(String keyword);

	List<Member> selectMembersByName(String keyword);

	List<Member> selectMembersByPhone(String keyword);

}
