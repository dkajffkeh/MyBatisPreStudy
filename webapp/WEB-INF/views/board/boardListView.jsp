<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .outer{
            width:900px;
            background-color: black;
            color:white;
            margin: auto;
            margin-top: 50px;
        }
    </style>
</head>
<body>

<jsp:include page="../common/menubar.jsp"/>
    <!-- 메뉴바 들어갈 예정-->
    <div class="outer">
        <br>
        <h1 align="center">게시판</h1>
        
        <div class="search-area" align="center">
            <form action="#">
                <select name="condition">
                    <option value="writer">작성자</option>
                    <option value="title">제목</option>
                    <option value="content">내용</option>
                </select>
                <input type="text" name="keyword">
                <button type="submit">검색</button>
            </form>
        </div>
        <br><br>

        <table id="list-area" align="center">
            <thead>
                <tr>
                    <th>글번호</th>
                    <th width="400px">제목</th>
                    <th width="100px">작성자</th>
                    <th>조회수</th>
                    <th width="100px">작성일</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="b" items="${ list }">
                <tr>
                    <td>${ b.boardNo }</td>
                    <td>${ b.boardTitle }</td>
                    <td align="center">${ b.boardWriter }</td>
                    <td align="center">${ b.count }</td>
                    <td align="center">${ b.createDate }</td>
                </tr>
            </c:forEach>    
            </tbody>
        </table>
        
        <div id="paging-area" align="center">
         
         <c:if test="${ pi.currentPage ne 1 }">
            <a href="list.bo?currentPage=${ pi.currentPage-1 }">[이전]</a>
          </c:if>  
 		 <c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
            <a href="list.bo?currentPage=${ p }">[${ p }]</a>
		</c:forEach>
		<c:if test="${ pi.currentPage ne pi.maxPage }">
            <a href="list.bo?currentPage=${ pi.currentPage+1 }">[다음]</a>
       </c:if>
        </div>

        <br><br>
    </div>
</body>
</html>