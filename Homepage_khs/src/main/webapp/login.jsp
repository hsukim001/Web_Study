<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h2>로그인</h2>
	<form action="login.do" method="post">
		<label for="userid">User ID:</label>
	    <input type="text" id="userid" name="userid" required><br>
	    
	    <label for="password">Password:</label>
	    <input type="password" id="password" name="password" required><br>
	    
	    <input type="submit" value="Submit">
	</form>
</body>
</html>