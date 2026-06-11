package com.comdog.c2d.domain.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.comdog.c2d.dto.MemberDto;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private AuthDao authDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder; //빈 등록돼 있어야 함
	
	/*--로그인--*/
	@Override
	public MemberDto login(MemberDto memberDto) throws Exception{
		// 💡 실무에서는 여기서 memberDto.getPassword()를 꺼내 
        // BCryptPasswordEncoder 등으로 암호화된 비밀번호와 매칭하는 로직이 들어갑니다.
		
		// 1) 이메일로 회원 조회
		MemberDto findMember = authDao.login(memberDto);
		
		// 2) 회원이 없으면 로그인 실패
		if (findMember == null) {
			return null;
		}
		
		// ↓ 디버그용 (확인 후 삭제)
	    System.out.println(">>> 입력 평문: [" + memberDto.getPassword() + "]");
	    System.out.println(">>> DB 해시: [" + findMember.getPassword() + "]");

		
		// 3) 입력한 평문 비밀번호와 DB의 BCrpt 해시 비교
		boolean matched = passwordEncoder.matches(
				memberDto.getPassword(), //사용자가 입력한 평문
				findMember.getPassword() //DB에 저장된 해시
				);
		
		try {
		    matched = passwordEncoder.matches(
		        memberDto.getPassword(),
		        findMember.getPassword()
		    );
		    System.out.println(">>>>> matches 최종 결과: " + matched);  // 눈에 띄게
		} catch (Exception e) {
		    System.out.println(">>>>> matches 예외 발생!");
		    e.printStackTrace();
		}
		
		
		 // 4) 일치하면 회원정보 반환, 아니면 null
	    return matched ? findMember : null;
		
	}
	
	/*--회원가입--*/
	@Override
	public void signup(MemberDto memberDto) throws Exception {
		//평문 비밀번호를 BCrpy로 암호화하여 다시 세팅
		String encodedPw = passwordEncoder.encode(memberDto.getPassword());
		memberDto.setPassword(encodedPw);
		
		//DB에 저장
		authDao.insertMember(memberDto);
	}

	@Override
	public boolean isEmailDuplicated(String email) throws Exception {
		//같은 이메일 회원 수를 세서 1 이상이면 중복
		return authDao.countByEmail(email) > 0;
	}


}
