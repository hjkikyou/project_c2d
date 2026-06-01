package com.comdog.c2d.domain.contract;

import java.util.List;

import com.comdog.c2d.dto.ContractDto;

public interface ContractService {

	List<ContractDto> findAllContracts();

}
