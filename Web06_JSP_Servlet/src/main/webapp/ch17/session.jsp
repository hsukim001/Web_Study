<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<%
		// session 객체 : session 범위에 존재하는 객체
		
		// 세션 생성 시간
		Date createTime = new Date(session.getCreationTime());
		
		// 이 웹 페이지의 마지막 접속 시간
		Date lastAccessTime = new Date(session.getLastAccessedTime());
		
		// 세션 유지 시간 설정 방법1
		// 세션에서 만료시간은 사용자가 화면을 조작할경우 유지시간은 계속 새로 갱신되며 사용하지 않을 경우 유지시간이 흘러 종료된다.
		session.setMaxInactiveInterval(60); // 60초
		
		// 세션 유지 시간 설정 방법2(이제는 잘 사용하지 않는 방법)
		// - web.xml 설정
		// - web.xml 파일 생성 :
		//	 ㄴ 프로젝트 마우스 오른쪽 클릭 - Java EE - Generate Deployment Descriptor stub 선택
		/*
			<session-config>
			<session-timeout>10</session-timeout> // 분 단위
			</session-config>
		*/
		
		// 세션에 키-값 데이터 저장
		session.setAttribute("userid", "kim");
		
	%>
	
	<%-- 
	* HTTP 특성
	- stateless protocol : 통신이 끝나면 상태를 유지하지 않는 특성
	- 쿠키와 세션은 HTTP 특성이 아닌 연결 상태를 유지하기 위해 사용
	
	* 세션(session)
	- 쿠키를 기반으로 사용
	- 서버 측에서 데이터를 관리
	- 세션 ID를 부여하여 브라우저를 종료할 때까지 데이터를 유지
	- 세션 객체 : 사용자를 식별할 수 있는 방법을 제공
		ㄴ 사용자에 대한 정보 저장
	- 세션이 생성되는 시점 : 최초로 프로젝트의 특정 페이지를 불러오는 시점에 생성
	- 주의사항 : 세션은 현재 프로젝트에 실행되는 모든 웹 페이지에 적용됨.
		따라서, 하나의 클라이언트에 세션을 많이 사용하면 충돌이 발생될 수 있음
	 --%>
	
	<h2>세션 아이디 : <%=session.getId() %></h2>
	<h2>세션 생성 시간 : <%=createTime %></h2>
	<h2>마지막 접속 시간 : <%=lastAccessTime %></h2>
	<a href="sessionTest.jsp">sessionTest.jsp 페이지로 이동</a>
	
</body>
</html>