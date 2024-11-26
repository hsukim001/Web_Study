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
      	// TODO : 로그인된 사용자 아이디를 저장
      	// TODO : form action="update.do" method="post" 생성
      	// TODO : userid를 제외한 모든 정보 수정 가능하게 input 태그 작성
      	//        userid는 읽기만 가능하도록 input 태그 생성
		String userid = (String) session.getAttribute("userid");
	%>
	<h2>회원 정보 수정</h2>
	<form action="update.do" method="post">
	    <label for="userid">User ID:</label>
	    <input type="text" id="userid" name="userid" value="<%=userid %>" readonly="readonly"><br>
	    
	    <label for="password">Password:</label>
	    <input type="password" id="password" name="password" required><br>
	    
	    <label for="email">Email:</label>
	    <input type="email" id="email" name="email" required><br>
	    
	    <label for="emailAgree">Agree to receive emails:</label>
	    <input type="checkbox" id="emailAgree" name="emailAgree"><br>
	    
	    <label for="interest">Interests:</label><br>
	    <input type="checkbox" id="interest1" name="interest" value="서버 개발">
	    <label for="interest1">서버 개발</label><br>
	    <input type="checkbox" id="interest2" name="interest" value="앱 개발">
	    <label for="interest2">앱 개발</label><br>
	
	    <label for="phone">Phone:</label>
	    <input type="tel" id="phone" name="phone"><br>
	    
	    <label for="introduce">Introduction:</label><br>
	    <textarea id="introduce" name="introduce" rows="4" cols="50"></textarea><br>
	    
	    <input type="submit" value="Submit">
	</form>
	
</body>
</html>