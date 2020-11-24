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
        #list-area{
        	border: 1px solid white;
        	text-align:center;

        }
        #list-area>tbody>tr:hover {
        	background:darkgrey;
        	cursor:pointer;
        }
        a{
         text-decoration:none;
         color:white;
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
            <form action="search.bo" method="get">
            <!-- 1번페이지가 먼저 보임. -->
            <input type="hidden" name="currentPage" value="1">
                <select name="condition">
                    <option value="writer">작성자</option>
                    <option value="title">제목</option>
                    <option value="content">내용</option>
                </select>
                <input type="text" name="keyword" value="${ keyword }">
                <button type="submit">검색</button>
            </form>
        </div>
       
       <c:if test="${ !empty condition }">
       
       <script>
       	$(function(){
       		
       		$("#search-area option[value=${condition}]").attr("selected",true);
       		
       	})
       
       </script>
       
       </c:if>
        
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
                    <td><a href="detail.bo?bno=${ b.boardNo }">${ b.boardTitle }</a></td>
                    <td align="center">${ b.boardWriter }</td>
                    <td align="center">${ b.count }</td>
                    <td align="center">${ b.createDate }</td>
                </tr>
            </c:forEach>    
            </tbody>
        </table>
        
        <!-- 검색 요청전 페이징바 -->
      <c:choose>
      
      <c:when test="${ empty condition }"> 
       
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
       <br><br>
       </div>
       
       </c:when>       	
       <c:otherwise>
       
        <div id="paging-area" align="center">     
         <c:if test="${ pi.currentPage ne 1 }">
            <a href="search.bo?currentPage=${ pi.currentPage-1 }&condition=${ condition }&keyword=${ keyword }">[이전]</a>
          </c:if>  
 		 <c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
            <a href="search.bo?currentPage=${ p }&condition=${ condition }&keyword=${ keyword }">[${ p }]</a>
		</c:forEach>
		<c:if test="${ pi.currentPage ne pi.maxPage }">
            <a href="search.bo?currentPage=${ pi.currentPage+1 }&condition=${ condition }&keyword=${ keyword }">[다음]</a>
       </c:if>
        </div>
        <br><br>
        
        </c:otherwise>
     
	</c:choose>
        
    </div>
</body>
</html>