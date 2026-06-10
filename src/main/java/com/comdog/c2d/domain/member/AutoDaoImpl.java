package com.comdog.c2d.domain.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comdog.c2d.dto.MemberDto;

@Repository
public class AutoDaoImpl implements AuthDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// Mapper XML의 namespace와 일치해야 합니다.
    private static final String NAMESPACE = "member";
    
    @Override
    public MemberDto login(MemberDto memberDto) throws Exception{
    	return sqlSession.selectOne(NAMESPACE + ".login", memberDto);
    }

}
