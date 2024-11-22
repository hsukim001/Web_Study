<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String userid = (String) session.getAttribute("userid");
	%>
	
	<form action="memberInfo.do" method="post">
		<h2><%=userid %>님, 환영합니다.</h2>
		<input type="submit" name="submit" value="가입 정보">
	</form>
	<form action="logout.do" method="get">
		<input type="submit" name="logout" value="로그아웃">
	</form>
</body>
</html>