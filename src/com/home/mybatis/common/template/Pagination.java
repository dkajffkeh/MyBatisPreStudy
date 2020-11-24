package com.home.mybatis.common.template;

import com.home.mybatis.board.model.vo.PageInfo;

public class Pagination {
	
	public static PageInfo pageInfo(int listCount, int currentPage, int pageLimit, int boardLimit) {
		
		// * maxPage : 총 페이지 수 (== 제일 마지막 페이지 수)
		//			   listCount, boardLimit
		int maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		// * startPage : 현재 페이지에 보여질 페이징 바의 시작수
		//			     currentPage, pageLimit
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		// * endPage : 현재 페이지에 보여질 페이징 바의 끝수
		//			   startPage, pageLimit, maxPage
		int endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		return new PageInfo(listCount, currentPage, startPage, endPage, maxPage, pageLimit, boardLimit);
	
}

}