package com.comdog.c2d.domain.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comdog.c2d.domain.contract.ContractDao;
import com.comdog.c2d.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;

	@Autowired
	ContractDao contractDao; // 3. ContractDao 의존성 주입 추가

	// 조회
	@Override
	public List<Member> findAllMembers() {

		return memberDao.findAllMembers();
	}

	// 추가
	@Override
	public void add(Member item) {
		memberDao.add(item);

	}

	// 변경
	@Override
	public Member findMemeberById(Long id) {

		return memberDao.findMemberById(id);
	}

	@Override
	public void update(Member member) {
		memberDao.update(member);

	}

	// 삭제
	@Override
	@Transactional
	public void delete(Long id) {

		// 1등: 계약 자식들(결제내역, 리뷰) 삭제
		contractDao.deletePaymentByMemberId(id);
		contractDao.deleteReviewByMemberId(id);

		// 2등: 중간 부모 계약(contract) 삭제
		contractDao.deleteByMemberId(id);

		// 3등: 주문의 말단 자식들(배송, 주문 상품 상세)을 전부 먼저 삭제합니다!
		memberDao.deleteDeliveryByMemberId(id);
		memberDao.deleteOrderItemByMemberId(id); // 💡 새로 추가된 순서!

		// 4등: 자식들이 모두 사라졌으니 중간 부모인 주문(orders) 내역을 삭제합니다.
		memberDao.deleteOrdersByMemberId(id);

		// 5등: 마침내 외톨이가 된 회원을 안전하게 최종 삭제합니다.
		memberDao.delete(id);
	}

	// 검색 기능
	@Override
	public List<Member> findMembersByEmail(String keyword) {
		return memberDao.selectMembersByEmail(keyword);
	}

	@Override
	public List<Member> findMembersByName(String keyword) {
		return memberDao.selectMembersByName(keyword);
	}

	@Override
	public List<Member> findMembersByPhone(String keyword) {
		return memberDao.selectMembersByPhone(keyword);
	}
}
