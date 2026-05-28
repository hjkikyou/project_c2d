package com.comdog.c2d.domain.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comdog.c2d.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;
	
	//조회
	@Override
	public List<Member> findAllMembers(){
		
		return memberDao.findAllMembers();
	}

	//추가
	@Override
	public void add(Member item) {
		memberDao.add(item);
		
	}
	
	//변경
	@Override
	public Member findMemeberById(Long id) {
		
		return memberDao.findMemberById(id); 
	}

	@Override
	public void update(Member member) {
		memberDao.update(member);
		
	}

	//삭제
	@Override
	public void delete(Long id) {
		memberDao.delete(id);
		
	}
}
