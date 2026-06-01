package com.comdog.c2d.domain.contract;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comdog.c2d.dto.ContractDto;

@Repository //DB와 연결되는 DAO 컴포넌트임을 명시
public class ContractDaoImpl implements ContractDao {
	
	
	// MyBatis의 핵심 객체인 SqlSession을 주입받습니다.
    @Autowired
    private SqlSession sql;

	@Override
	public List<ContractDto> selectAll() {
		
		return sql.selectList("contract.selectAll");
	}
	
	@Override
	public void deletePaymentByMemberId(Long id) {
	    sql.delete("contract.deletePaymentByMemberId", id);
	}

	@Override
	public void deleteReviewByMemberId(Long id) {
	    sql.delete("contract.deleteReviewByMemberId", id);
	}

	@Override
	public void deleteByMemberId(Long id) {
	    sql.delete("contract.deleteByMemberId", id);
	}
}
