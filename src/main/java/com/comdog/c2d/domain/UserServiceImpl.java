package com.comdog.c2d.domain;

import java.time.LocalDateTime;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.comdog.c2d.dto.MemberDto;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, BCryptPasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void signup(MemberDto memberDto) {

        // 1. 이메일 중복 검사
        if (!isEmailAvailable(memberDto.getEmail())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        // 2. 비밀번호 암호화
        String encodedPw = passwordEncoder.encode(memberDto.getPassword());
        memberDto.setPassword(encodedPw);

        // 3. 가입일 설정
        memberDto.setCreatedAt(LocalDateTime.now());

        // 4. 기본값 처리
        if (memberDto.getIsSubscribed() == null) {
            memberDto.setIsSubscribed(false);
        }
        if (memberDto.getUserType() == null || memberDto.getUserType().isEmpty()) {
            memberDto.setUserType("PERSONAL");
        }

        // 5. DB 저장
        userDao.insertMember(memberDto);
    }

    @Override
    public boolean isEmailAvailable(String email) {
        return userDao.countByEmail(email) == 0;
    }
}
