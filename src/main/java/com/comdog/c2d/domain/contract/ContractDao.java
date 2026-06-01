package com.comdog.c2d.domain.contract;

import java.util.List;

import com.comdog.c2d.dto.ContractDto;

public interface ContractDao {

	List<ContractDto> selectAll();
	
	void deletePaymentByMemberId(Long id);
	void deleteReviewByMemberId(Long id);
	void deleteByMemberId(Long id);

}
