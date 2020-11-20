package com.home.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.home.mybatis.common.template.Template;
import com.home.mybatis.member.model.dao.MemberDao;
import com.home.mybatis.member.model.vo.Member;
import static com.home.mybatis.common.template.Template.getSqlSession;;

public class MemberServiceImpl implements MemberService{

	/**
	 * 회원가입용 서비스
	 */
	@Override
	public int insertMember(Member m) {
		
		// 기존 => DB 와 접속된 Connection 객체 생성 (JDBCTemplate) 클래스의 getConnection() 호출
		// MyBatis 객체 생성을 여기서함. 마이바티스 SqlSession 객체 생성. Template 클래스의 getSqlSession()호출
		//JDBC 템플릿 대신 쓰게될 클래스
		SqlSession sqlSession = getSqlSession();
		
		int result = new MemberDao().insertMember(sqlSession,m);
		
		if(result>0) {
		  	sqlSession.commit();
		} 
		
		sqlSession.close();
		
		return result;
	}

	/**
	 * 로그인용 서비스
	 */
	@Override
	public Member loginMember(String userId, String userPwd) {
		
		return null;
	}

	
	
}
