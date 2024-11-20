<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id == null) {
		out.print("<script>alert('로그인 실패');</script>");
		out.print("<script>location.href='HW3.jsp'</script>");
	}
	
	if (id.equals("test") && pw.equals("1234")) {
		session.setAttribute("id", id);
		session.setMaxInactiveInterval(60);
		out.print("<script>alert('로그인 성공');</script>");
		out.print("<script>location.href='HW3_login_result.jsp'</script>");
	} else {
		out.print("<script>alert('로그인 실패');</script>");
		out.print("<script>location.href='HW3.jsp'</script>");
	}
%>