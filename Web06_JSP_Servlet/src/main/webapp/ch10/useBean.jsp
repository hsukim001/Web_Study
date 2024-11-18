<%@page import="web.ch10.bean.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useBean</title>
</head>
<body>
	<!-- 
	생성자는 인스턴스를 선언할때 생성되는데
	jsp:useBean을 사용하면 인스턴스 선언이 없어도 자동적으로 인스턴스를 선언하여 호출한다.
	 -->
	<jsp:useBean id="member" class="web.ch10.bean.MemberBean"></jsp:useBean>
	
	<%
		// useBean 코드와 동일한 코드
		// MemberBean member = new MemberBean();
	%>
	
	<%-- useBean 사용 방법1 --%>
	<!-- 
	jsp:setProperty = java의 setter 역할을 수행
	jsp:getProperty = java의 getter 역할을 수행
	
	set,getProperty을 사용할때에는 Bean.java의 멤버변수명과 똑같이 작성해야한다.
	 -->
	<jsp:setProperty property="userId" name="member" value="guest"/>
	
	<p>id 출력 : <jsp:getProperty name="member" property="userId"/></p>
	
	<%-- useBean 사용 방법2 --%>
	<% member.setEmail("test@test.com"); %>
	
	<p>email 출력 : <%= member.getEmail() %></p>
	
	<!-- 
	내장객체 pdf 중요!! 내용
	1. request : request가 택배상자라고 치면 request 택배을 보낼때는 key value로 포장을하고, 포장을 해제하고 데이터를 받을때에는 Attribute -> 키값으로 포장된 내용을 받는다.
	2. response
	3. application
	4. session : 브라우저 내에서 유지되는 형식(client내에서 사용됨), 
		- 장점 : 예를 들어 A페이지에서 B페이지이동 B페이지에서 C페이지 이동시 마다 로그인을할 경우 session에 인증정보를 가지고 있으면 페이지 이동시마다 로그인을 할 필요가 없어진다.
	내장객체 01 pdf 그림 중요 블러그에 기록
	 -->
	
</body>
</html>