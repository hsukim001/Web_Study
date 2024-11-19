<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("UTF-8"); %>
	<jsp:useBean id="member" class="edu.web.homework.MemberVO"></jsp:useBean>
	<jsp:setProperty property="*" name="member"/>
	
	<%
		String[] result = member.getInterest();
	%>
	
	<h2>회원 정보</h2>
	<p>아이디 : <%=member.getUserid() %></p>
	<p>비밀번호 : <%=member.getPassword() %></p>
	<p>이메일 : <%=member.getEmail() %></p>
	<p>이메일 수신 여부 : <%=member.getEmailAgree() %></p>
	<p>전화번호 : <%=member.getPhone() %></p>
	<p>관심사항 : <%=member.getInterestJoin() %></p>
	<p>자기소개 : <%=member.getIntroduce() %></p>
</body>
</html>