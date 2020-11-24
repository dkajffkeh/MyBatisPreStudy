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
import com.home.mybatis.board.model.vo.Reply;

/**
 * Servlet implementation class BoardDetailViewController
 */
@WebServlet("/detail.bo")
public class BoardDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardService bService = new BoardServiceImpl();
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		int result = bService.increaseCount(bno);
		
		if(result>0) {
			
			Board b = bService.selectBoard(bno);
			
			ArrayList<Reply> rList = bService.selectReply(bno);
			
			request.setAttribute("b", b);
			request.setAttribute("rList", rList);
			request.getRequestDispatcher("WEB-INF/views/board/boardDetailView.jsp").forward(request, response);
			
		} else {
			
			request.setAttribute("errorMsg", "유효한 게시글이 아닙니다");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);;
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
