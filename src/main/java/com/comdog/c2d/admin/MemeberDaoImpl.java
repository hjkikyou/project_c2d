package com.comdog.c2d.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comdog.c2d.dto.MemberDto;

@Repository
public class MemeberDaoImpl implements MemberDao {

	@Autowired
	SqlSession sql;

	// 조회
	@Override
	public List<MemberDto> findAllMembers() {
		return sql.selectList("member.findAllMembers");
	}

	// 추가
	@Override
	public void add(MemberDto item) {
		sql.insert("member.add", item);
	}

	// 변경
	@Override
	public MemberDto findMemberById(Long id) {
		return sql.selectOne("member.findMemberById", id);
	}

	@Override
	public void update(MemberDto member) {
		sql.update("member.update", member);
	}

	// 삭제
	@Override
	public void delete(Long id) {
		sql.delete("member.delete", id);
	}

	@Override
	public void deleteOrdersByMemberId(Long id) {
		sql.delete("member.deleteOrdersByMemberId", id);
	}

	@Override
	public void deleteDeliveryByMemberId(Long id) {
		sql.delete("member.deleteDeliveryByMemberId", id);
	}

	@Override
	public void deleteOrderItemByMemberId(Long id) {
		sql.delete("member.deleteOrderItemByMemberId", id);
	} // 💡 닫는 중괄호가 빠져있던 부분을 정상적으로 추가했습니다!

	// 검색 기능 추가
	@Override
	public List<MemberDto> selectMembersByEmail(String keyword) {
		return sql.selectList("member.selectMembersByEmail", keyword);
	}

	@Override
	public List<MemberDto> selectMembersByName(String keyword) {
		return sql.selectList("member.selectMembersByName", keyword);
	}

	@Override
	public List<MemberDto> selectMembersByPhone(String keyword) {
		return sql.selectList("member.selectMembersByPhone", keyword);
	}

	// 💡 로그인 기능 추가 (기존 스타일과 통일)
		@Override
		public MemberDto login(MemberDto memberDto) {
			return sql.selectOne("member.login", memberDto);
		}

}