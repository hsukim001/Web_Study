<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward</title>
</head>
<body>
	<%
		System.out.println("forward 실행 전");
	%>
	
	<!-- 
	forward는 코드 실행중 forward을 만날경우, forward 선언이 된 파일의 페이지로 로드한다.
	또한 url의 경로를 숨길수있다.(forward 된 파일의 경로가 아닌 actionForward.jsp의 경로가 표시됨)
	 -->
	<jsp:forward page="part.jsp"></jsp:forward>
	
	<%
		System.out.println("forward 실행 후");
	%>
</body>
</html>