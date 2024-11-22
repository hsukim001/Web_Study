<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<%
		String userid = (String) request.getAttribute("userid");
		String password = (String) request.getAttribute("password");
		String email = (String) request.getAttribute("email");
		String emailAgree = (String) request.getAttribute("emailAgree");
		String interests[] = (String []) request.getAttribute("interest");
		String phone = (String) request.getAttribute("phone");
		String introduce = (String) request.getAttribute("introduce");
		
		String interest = (interests == null) ? "없음" : String.join(",", interests);
		
	%>
	<h2>회원 정보 수정</h2>
	<form action="memberUpdate.do" method="post">
	    <label for="userid">아이디:</label>
	    <input type="text" id="userid" name="userid" value="<%=userid %>" disabled="disabled"><br>
	    
	    <label for="password">비밀번호:</label>
	    <input type="password" id="password" name="password" value="<%=password %>" required><br>
	    
	    <label for="email">이메일:</label>
	    <input type="email" id="email" name="email" value="<%=email %>" required><br>
	    
	    <label for="emailAgree">이메일 수신 여부:</label>
	    <input type="checkbox" id="emailAgree" name="emailAgree" <%=emailAgree.equals("on") ? "checked" : "" %>><br>
	    
	    <label for="interest">관심사:</label><br>
	    <input type="checkbox" id="interest1" name="interest" value="서버 개발" <%=interest.indexOf("서버 개발") != -1 ? "checked" : "" %>>
	    <label for="interest1">서버 개발</label><br>
	    <input type="checkbox" id="interest2" name="interest" value="앱 개발" <%=interest.indexOf("앱 개발") != -1 ? "checked" : "" %>>
	    <label for="interest2">앱 개발</label><br>
	
	    <label for="phone">휴대폰:</label>
	    <input type="tel" id="phone" name="phone" value="<%=phone %>"><br>
	    
	    <label for="introduce">소개:</label><br>
	    <textarea id="introduce" name="introduce" rows="4" cols="50"><%=introduce %></textarea><br>
	    
	    <input type="submit" value="수정">
	</form>
</body>
</html>