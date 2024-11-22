<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<%
		String userid = (String) request.getAttribute("userid");
		String email = (String) request.getAttribute("email");
		String emailAgree = (String) request.getAttribute("emailAgree");
		String interests[] = (String []) request.getAttribute("interest");
		String phone = (String) request.getAttribute("phone");
		String introduce = (String) request.getAttribute("introduce");
		
		String interest = (interests == null) ? "없음" : String.join(",", interests);
	%>
	<h2>회원 정보</h2>
	<p>아이디 : <%=userid %></p>
	<p>이메일 : <%=email %></p>
	<p>이메일 수신 동의 : <%=emailAgree %></p>
	<p>취미 : <%=interest %></p>
	<p>휴대폰 : <%=phone %></p>
	<p>소개 : <%=introduce %></p>
	
	<div style="display: flex; gap: 10px;">
		<form action="memberUpdate.do" method="get">
		    <input type="submit" value="수정">
		</form>
		<form action="memberDelete.do" method="get">
			<input type="submit" value="탈퇴">
		</form>
	</div>

</body>
</html>
