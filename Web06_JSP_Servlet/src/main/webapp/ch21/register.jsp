<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<h2>회원 가입하기</h2>
	<form action="../register.do" method="post">
	    <label for="userid">User ID:</label>
	    <input type="text" id="userid" name="userid" required><br>
	    
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








