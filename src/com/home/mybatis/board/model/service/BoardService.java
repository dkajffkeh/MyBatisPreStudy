package com.home.mybatis.board.model.service;

import java.util.ArrayList;

import com.home.mybatis.board.model.vo.Board;
import com.home.mybatis.board.model.vo.PageInfo;
import com.home.mybatis.board.model.vo.Reply;

public interface BoardService {
	
	// 1.게시판 리스트 요청시
	int selectListCount();
	
	//2  게시판 검색 요청
	int selectSearchCount(String condition, String keyword);
	ArrayList<Board> selectSearchList(String condition, String keyword, PageInfo pi);
	
	// 게시판 상세조회 요청
	ArrayList<Board> selectList(PageInfo pi);
	int increaseCount(int bno);
	Board selectBoard(int bno);
	
	//댓글 조회 요청
	ArrayList<Reply> selectReply(int bno);
	

}
