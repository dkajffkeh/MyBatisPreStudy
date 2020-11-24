package com.home.mybatis.board.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.home.mybatis.board.model.dao.BoardDao;
import com.home.mybatis.board.model.vo.Board;
import com.home.mybatis.board.model.vo.PageInfo;
import com.home.mybatis.board.model.vo.Reply;

import static com.home.mybatis.common.template.Template.getSqlSession;

public class BoardServiceImpl implements BoardService {
	
	private BoardDao bDao = new BoardDao();
	
	@Override
	public int selectListCount() {
		
		SqlSession sqlSession = getSqlSession();
		
		int listCount = bDao.selectListCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Board> list = bDao.selectList(sqlSession,pi);
		
		sqlSession.close();
		
		return list;
	}

	@Override
	public int increaseCount(int bno) {
		
		SqlSession sqlSession = getSqlSession();
		
		int result = bDao.increaseCount(sqlSession,bno);
		
		if(result>0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public Board selectBoard(int bno) {
		
		SqlSession sqlSession = getSqlSession();
		
		Board b = bDao.selectBoard(sqlSession,bno);
		
		sqlSession.close();
		
		return b;
	}

	@Override
	public int selectSearchCount(String condition, String keyword) {
		
		SqlSession sqlSession = getSqlSession();
		
		int searchCount = bDao.selectSearchCount(sqlSession,condition,keyword);
		
		sqlSession.close();
		
		return searchCount;
	}

	@Override
	public ArrayList<Board> selectSearchList(String condition, String keyword, PageInfo pi) {
		
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Board> list = bDao.selectSearchList(sqlSession,condition,keyword,pi);
		
		sqlSession.close();
		
		return list;
	}

	@Override
	public ArrayList<Reply> selectReply(int bno) {
		
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Reply> rList = bDao.selectReply(sqlSession,bno);
		
		sqlSession.close();
		
		return rList;
	}

}
