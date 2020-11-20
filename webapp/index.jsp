<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- WEB-INF 폴더는 WAS 가 관리하는 폴더기 때문에 일반적 경로 요청이 불가능함
	 WAS 서버로 요청해서 forwarding 방식을 통해서만 접근이 가능
	 -->
	 <!-- 나름대로 서버 요청이 이뤄진것 -->
	 <jsp:forward page="WEB-INF/views/main.jsp"/>

</body>
</html>