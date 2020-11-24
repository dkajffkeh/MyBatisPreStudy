package com.home.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.mybatis.board.model.service.BoardService;
import com.home.mybatis.board.model.service.BoardServiceImpl;
import com.home.mybatis.board.model.vo.Board;
import com.home.mybatis.board.model.vo.PageInfo;
import com.home.mybatis.common.template.Pagination;

/**
 * Servlet implementation class BoardSearchController
 */
@WebServlet("/search.bo")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	BoardService bService = new BoardServiceImpl();	
		
	String condition = request.getParameter("condition");
	String keyword = request.getParameter("keyword");
	int currentPage = Integer.parseInt(request.getParameter("currentPage"));	
	int searchCount = bService.selectSearchCount(condition, keyword);
	
	PageInfo pi = Pagination.pageInfo(searchCount, currentPage, 10, 5);
	
	ArrayList<Board> list = bService.selectSearchList(condition, keyword, pi);
	
	request.setAttribute("pi", pi);
	request.setAttribute("list", list);
	request.setAttribute("condition", condition);
	request.setAttribute("keyword", keyword);
	request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
