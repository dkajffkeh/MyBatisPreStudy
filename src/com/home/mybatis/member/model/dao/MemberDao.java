package com.home.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.home.mybatis.member.model.vo.Member;

public class MemberDao {

	public int insertMember(SqlSession sqlSession, Member m) {
		//회원객체를 DB로 전달
		return sqlSession.insert("memberMapper.insertMember", m);
	
	}

}
