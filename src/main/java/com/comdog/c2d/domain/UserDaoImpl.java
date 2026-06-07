package com.comdog.c2d.domain;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.comdog.c2d.dto.MemberDto;

@Repository
public class UserDaoImpl implements UserDao {

    private final SqlSessionTemplate sqlSession;

    // MyBatis mapper namespace
    private static final String NAMESPACE = "user";

    public UserDaoImpl(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void insertMember(MemberDto memberDto) {
        sqlSession.insert(NAMESPACE + "insertMember", memberDto);
    }

    @Override
    public int countByEmail(String email) {
        return sqlSession.selectOne(NAMESPACE + "countByEmail", email);
    }
}