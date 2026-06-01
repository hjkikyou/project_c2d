package com.comdog.c2d.domain.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comdog.c2d.dto.ContractDto;

@Service
	public class ContractServiceImpl implements ContractService {
	
	@Autowired
	ContractDao contractDao;
	
	//조회
	@Override
	public List<ContractDto> findAllContracts() {
			
	return contractDao.selectAll();
		}
	
}
