<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과 페이지</title>
</head>
<body>
	<%
		// practiceLogin.jsp에서 전송된
		// saveAgrred가 체크 되어 있으면
		// id, pw에 대한 쿠키를 생성한다.
		// 쿠키 만료 시간은 10분으로 설정
		request.setCharacterEncoding("UTF-8");
		
		String saveAgreed = request.getParameter("saveAgreed");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(saveAgreed != null) { // 아이디 저장이 체크된 경우
			Cookie idCookie = new Cookie("id", id);
			Cookie pwCookie = new Cookie("pw", pw);
			
			idCookie.setMaxAge(60 * 10);
			pwCookie.setMaxAge(60 * 10);
			
			response.addCookie(idCookie);
			response.addCookie(pwCookie);
		}
		
	%>
	
	<h2>로그인 결과 화면</h2>
	<%-- [아이디]님, 환영합니다 출력 --%>
	<p><%=id %>님, 환영합니다.</p>
	
</body>
</html>