package com.home.mybatis.board.model.service;

import java.util.ArrayList;

import com.home.mybatis.board.model.vo.Board;
import com.home.mybatis.board.model.vo.PageInfo;

public interface BoardService {
	
	// 1.게시판 리스트 요청시
	int selectListCount();
	
	ArrayList<Board> selectList(PageInfo pi);
	
	int increaseCount(int bno);
	
	Board selectBoard(int bno);

}
