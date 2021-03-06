<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

</head>
<body>

	<jsp:include page="../common/menubar.jsp"/>
    <!-- 메뉴바 포함할거임 -->
    <div class="outer">
        <br>
        <h1 align="center">회원가입</h1>
        <br>
        <form id="enroll-form" action="insert.me" method="post">
            <table align="center">
                <tr>
                    <td>*ID</td>
                    <td><input type="text" name="userId" id="" required placeholder="아이디를 입력해주세요"></td>
                </tr>
                <tr>
                    <td>*PWD</td>
                    <td><input type="password" name="userPwd" required placeholder="비밀번호를 입력해주세요"></td>
                </tr>
                <tr>
                    <td>*PWD Check</td>
                    <td><input type="password" name="pwdCheck" required placeholder="비밀번호를 한번더 입력해주세요"></td>
                </tr>
                <tr>
                    <td>*NAME</td>
                    <td><input type="text" name="userName" required placeholder="이름을 입력해주세요" ></td>
                </tr>
                <tr>
                    <td>&nbsp;EMAIL</td>
                    <td><input type="email" name="email"></td>
                </tr>
                <tr>
                    <td>&nbsp;BIRTHDAY</td>
                    <td><input type="text" name="birthday" placeholder="생년월일 (6자리)"></td>
                </tr>
                <tr>
                    <td>&nbsp;GENDER</td>
                    <td>
		                      남: <input type="radio" name="gender" value="M">
		                      여: <input type="radio" name="gender" value="F">
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;PHONE</td>
                    <td><input type="text" name="phone" placeholder="핸드폰 번호 -포함"></td>
                </tr>
                <tr>
                    <td>&nbsp;ADDRESS</td>
                    <td><input type="text" name="address" placeholder="주소를 입력해주세요"></td>
                </tr>
            </table>

            <br>
            <div align="center">
                <button type="reset">초기화</button>
                <button type="submit">회원가입</button>      
            </div>
            <br>
            <br>
        </form>
    </div>

</body>
</html>