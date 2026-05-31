package com.comdog.c2d.domain.contract;

import java.util.List;

import com.comdog.c2d.dto.ContractListDto;

public interface ContractService {

	List<ContractListDto> findAllContracts();

}
