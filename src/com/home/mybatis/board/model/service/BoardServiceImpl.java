package com.home.mybatis.board.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.home.mybatis.board.model.dao.BoardDao;
import com.home.mybatis.board.model.vo.Board;
import com.home.mybatis.board.model.vo.PageInfo;
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
		
		return 0;
	}

	@Override
	public Board selectBoard(int bno) {
		
		return null;
	}

}
