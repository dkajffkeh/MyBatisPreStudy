<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>        
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
    <div class="outer">
        <br>
        <h1 align="center">게시판 상세보기</h1>
        <br>
        <table align="center" id="table-area" border="1">
            <tr>
                <td width="100">글번호</td>
                <td width="500">${ b.boardNo }</td>
            </tr>
            <tr>
                <td>제목</td>
                <td>${ b.boardTitle}</td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>${ b.boardWriter }</td>
            </tr>
            <tr>
                <td>조회수</td>
                <td>${ b.count }</td>
            </tr>
            <tr>
                <td>작성일</td>
                <td>${ b.createDate }</td>
            </tr>
            <tr>
                <td>내용</td>
                <td><p style="height:100px">

                    ${ b.boardContent }

                </p></td>
            </tr>
        </table>
<br>
        <table align="center" border="1">
            <tr>
                <th width="100">댓글 작성</th>
                <td width="400"><textarea name="" id="" cols="50" rows="3"></textarea></td>
                <th width="100"><button>등록</button></th>
            </tr>
            <tr>
                <td colspan="3"><b> 댓글(${ rList.size() }) </b></td>

            </tr>
           <c:forEach var="i" items="${ rList }"> 
            <tr>
                <td>${ i.replyWriter }</td>
                <td>${ i.replayContent }</td>
                <td>${ i.createDate }</td>
            </tr>
           </c:forEach> 
        </table>
        
        <br><br>

    </div>
    
</body>
</html>