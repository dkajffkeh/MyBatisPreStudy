package com.home.mybatis.common.template;

import com.home.mybatis.board.model.vo.PageInfo;

public class Pagination {

	public static PageInfo pageInfo(int listCount, int currentPage, int pageLimit, int boardLimit) {
		
		int maxPage; //제일 마지막 페이지수 총페이지수
		maxPage =  (int)Math.ceil((double)listCount/boardLimit);
		// *startPage :현재 페이지에 보여질 페이징 바의 시작수
		//             currentPage, pageLimit,
		int startPage = (currentPage-1)/pageLimit*pageLimit+1;
		int endPage = startPage + pageLimit + 1;  // 현대 페이지에 보여질 페이징 바의 끝수  startPage, pageLimit , maxPage
		
		if(endPage>maxPage) {
			endPage=maxPage; 
		}
		
		return new PageInfo(listCount,currentPage,startPage,endPage,maxPage,pageLimit,boardLimit);
	}
	
}
