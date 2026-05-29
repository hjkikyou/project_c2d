package com.comdog.c2d.domain.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comdog.c2d.dto.Member;

@Repository
public class MemeberDaoImpl implements MemberDao {
	
	@Autowired
	SqlSession sql;
	
	// 조회
	@Override
	public List<Member> findAllMembers() {
		return sql.selectList("member.findAllMembers");
	}
	
	// 추가
	@Override
	public void add(Member item) {
		sql.insert("member.add", item);
	}
	
	// 변경
	@Override
	public Member findMemberById(Long id) {
		return sql.selectOne("member.findMemberById", id);
	}

	@Override
	public void update(Member member) {
		sql.update("member.update", member);
	}

	// 삭제
	@Override
	public void delete(Long id) {
		sql.delete("member.delete", id);
	}

	// 검색 기능 추가 (보이지 않는 유령 문자 제거 완료)
	@Override
	public List<Member> selectMembersByEmail(String keyword) {
		return sql.selectList("member.selectMembersByEmail", keyword);
	}

	@Override
	public List<Member> selectMembersByName(String keyword) {
		return sql.selectList("member.selectMembersByName", keyword);
	}

	@Override
	public List<Member> selectMembersByPhone(String keyword) {
		return sql.selectList("member.selectMembersByPhone", keyword);
	}
	
}