<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .login-area a{
            text-decoration: none;
            color: black;
            font-size: 14px;
        }
        .nav-area {
            background-color: black;
            color:white;
            height:50px;
        }
        .menu{
            display: table-cell;
            width:250px;
            height: 50px;
            vertical-align: middle;
            font-size: 1.3rem;
            font-weight: bold;
            cursor: pointer;
        }
        .menu:hover{
            background-color: darkgray;
        }
        /*
        매 페이지 마다의 공통적인 css
        */
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
    <h1 align="center">Welcome to MyBatis World</h1>
    <br>

    <div class="login-area" align="right">
     <c:choose>
     	<c:when test="${ empty loginUser}">
        	<!-- 1. 로그인 성공전 보여져야할 로그인폼 -->
            <form action="login.me" method="post">
                <table>
                    <tr>
                        <td>아이디</td>
                        <td><input type="text" name="userId"></td>
                        <td rowspan="2"><button type="submit" style="height:50px">로그인</button></td>
                    </tr>
                    <tr>
                        <td>비밀번호</td>
                        <td><input type="password" name="userPwd"></td>                      
                    </tr>        
                    <tr>
                        <td colspan="3" align="center">
                            <a href="enrollForm.me">회원가입</a>
                            <a href="">ID/PWD 찾기</a>
                        </td>
                    </tr>
                </table>
            </form>
            </c:when>
         <c:otherwise>
        <!-- 2. 로그인 성공후 보여져야할 div -->
        <div>
            <table>
                <tr>
                    <td colspan="2"><h3>${sessionScope.loginUser.userName }님 환영합니다</h3></td>              
                </tr>
                <tr>
                    <td><a href="">마이페이지</a></td>
                    <td><a href="logout.me">로그아웃</a></td>
                </tr>
            </table>
        </div> 
       	 </c:otherwise>
       </c:choose>
    </div>
<br>
    <div class="nav-area" align="center">
        <div class="menu">HOME</div>
        <div class="menu">공지사항</div>
        <div class="menu" onclick="location.href='list.bo?currentPage=1'">게시판</div>
        <div class="menu">ETC</div>
    </div>

</body>
</html>