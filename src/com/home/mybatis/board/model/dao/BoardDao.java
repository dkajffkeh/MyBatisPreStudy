package com.home.mybatis.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.home.mybatis.board.model.vo.Board;
import com.home.mybatis.board.model.vo.PageInfo;

public class BoardDao {

	public int selectListCount(SqlSession sqlSession) {
				
		return sqlSession.selectOne("boardMapper.selectListCount");
	}

	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi) {
		
		//return (ArrayList)sqlSession.selectList("boardMapper.selectList");
		//마이바티스는 페이징 처리를 위해 RowBounds 라는 객체 제공 ==> 몇개의 게시글 건너띄고 몇개 조회할건지에 대해 정의.
		
		//* offset : 이번에 조회할때 몇개의 게시글 건너띄고 조회할지에 대한 값.
		// ex) boardLimit : 5
		
		//currentPage = 1 ==> 1~5   0생략
		//currentPage = 2 ==> 6~10  5생략
		//currentPage = 3 ==> 11~15 10생략
		//currentPage = 4 ==> 16~20 15생략
		
		int offset = (pi.getCurrentPage())-1*pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset , pi.getBoardLimit());
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null ,rowBounds);
		
		
	}

	
	
}
