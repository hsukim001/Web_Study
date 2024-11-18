<%@page import="java.util.Date"%>
<%@page import="edu.web.homework.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HW1</title>
</head>
<body>
	<%
		// TODO : BoardVO를 저장할 ArrayList 선언
		//ArrayList<BoardVO> list = new ArrayList<>();
		// TODO : 게시글 데이터 5개(임의로 생성)를 list에 추가
		/* Date date = new Date();
		for(int i = 0; i < 5; i++){
			BoardVO vo = new BoardVO();
			vo.setBoardNum(i+1);
			vo.setBoardTitle("게시글"+(i+1));
			vo.setUserId("test"+(i+1));
			vo.setBoardRegDate(date);
			list.add(vo);
		} */
		
		// 강사님 풀이
		ArrayList<BoardVO> list = new ArrayList<>();
		
		list.add(new BoardVO(1, "test1", "mok", new Date()));
		list.add(new BoardVO(2, "test2", "mok", new Date()));
		list.add(new BoardVO(3, "test3", "mok", new Date()));
		list.add(new BoardVO(4, "test4", "mok", new Date()));
		list.add(new BoardVO(5, "test5", "mok", new Date()));
	%>
	
	<%-- table 태그 및 for문을 사용하여 5개의 게시글 데이터 출력 --%>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
		<% for(int i = 0; i < list.size(); i++) { %>
			<tr>
				<td><%=list.get(i).getBoardNum() %></td>
				<td><%=list.get(i).getBoardTitle()%></td>
				<td><%=list.get(i).getUserId() %></td>
				<td><%=list.get(i).getBoardRegDate()%><td>
			</tr>
		<% } %>
		</tbody>
	</table>
</body>
</html>