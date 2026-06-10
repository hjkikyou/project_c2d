package com.comdog.c2d.domain.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comdog.c2d.dto.MemberDto;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private AuthDao authDao;

	@Override
	public MemberDto login(MemberDto memberDto) throws Exception{
		// 💡 실무에서는 여기서 memberDto.getPassword()를 꺼내 
        // BCryptPasswordEncoder 등으로 암호화된 비밀번호와 매칭하는 로직이 들어갑니다.
		return authDao.login(memberDto);
	}


}
