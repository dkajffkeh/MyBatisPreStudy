package com.home.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.home.mybatis.member.model.vo.Member;

public class MemberDao {

	public int insertMember(SqlSession sqlSession, Member m) {
		//회원객체를 DB로 전달
		return sqlSession.insert("memberMapper.insertMember", m);
	
	}

	public Member loginMember(SqlSession sqlSession, Member m) {
		//selectOne 내부적으로 조회된 결과가 없으면 null 을 반환하는 값이 정의가 돼있음
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}

}
