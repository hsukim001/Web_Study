<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<h2>회원 정보</h2>
	<form action="register.do" method="post">
		<p name="userid">User ID:<p>
	    
	    <p name="password">Password:</p>
	    
	    <p name="email">Email:</p>
	    
	    <p name="emailAgree">Agree to receive emails:</p>
	    
	    <p name="interest">Interests:</p><br>

	    <p name="interest1">서버 개발</p><br>

	    <p name="interest2">앱 개발</p><br>
	
	    <p name="phone">Phone:</p>
	    
	    <textarea name="introduce" rows="4" cols="50"></textarea><br>
	</form>
	    <input type="submit" value="Submit">

</body>
</html>
