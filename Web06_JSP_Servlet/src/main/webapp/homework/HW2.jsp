<%@page import="edu.web.homework.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<%--
   1. HW2.jsp 파일
   - 회원 가입 form 만들기
   - POST 방식
   - action="HW2_memberInfo.jsp"
   - 아이디(text) : name="userid"
   - 패스워드(password) : name="password"
   - 이메일(email) : name="email"
   - 이메일 수신여부(radio 버튼) : name="emailAgree"
   - 관심사항(checkbox, 관심사항 4개 이상 설정) 
     ㄴ 예시) 
      <input type="checkbox" name="interest" value="IT">IT/인터넷
       <input type="checkbox" name="interest" value="movie">영화  
   - 핸드폰(text) : name="phone"
   - 자기소개(<textarea>) : name="introduce"
   
   2. MemberVO.java 파일
   - src/main/java/edu.web.homework 패키지에 MemberVO.java 클래스 생성
   - (변수 개수와 변수 이름은 form 태그 input name 값과 동일하게 작성)
   - MemberVO 기본 생성자 및 매개변수 생성자, getter/setter는 무조건 생성
   - String[] interest; (관심사항은 배열로 변수 선언)
   - request.getParameterValues() : checkbox로 선택된 여러 개의 데이터를 저장
   
   3. HW2_memberInfo.jsp 파일
   - HW2.jsp에서 전송된 데이터를 출력
   - request.getParameter or request.getParameterValues를 
     사용하지 않고 구현
   - 아래 코드를 추가하면 해결됨
   <jsp:useBean id="member" class="edu.web.homework.MemberVO" />
   <jsp:setProperty property="*" name="member" />
   - property="*"의 의미 : HW2.jsp에서 넘어온 모든
      parameter 값을 member 객체에 저장  
      
    --%>
    
    <h2>회원 가입 페이지</h2>
    <form action="HW2_memberInfo.jsp" method="POST">
    	<p>아이디</p>
    	<input type="text" name="userid" placeholder="아이디 입력" required="required">
    	<p>비밀번호</p>
    	<input type="password" name="password" placeholder="비밀번호 입력" required="required">
    	<p>이메일</p>
    	<input type="email" name="email" placeholder="이메일 입력" required="required">
    	
    	<!-- 이메일 수신여부 라디오 버튼 -->
    	<p>이메일 수신여부</p>
    	<input type="radio" name="emailAgree" value="yes">예
    	<input type="radio" name="emailAgree" value="no" checked="checked">아니오
    	
    	<p>전화번호</p>
    	<input type="text" name="phone" placeholder="전화번호 입력" required="required">
    	
    	<!-- 관심사항 체크박스 -->
    	<p>관심사항</p>
    	<input type="checkbox" name="interest" value="IT">IT/인터넷
    	<input type="checkBox" name="interest" value="movie">영화
    	<input type="checkBox" name="interest" value="game">게임
    	<input type="checkBox" name="interest" value="book">독서
    	<input type="checkBox" name="interest" value="fitness">운동
    	
    	<p>자기소개</p>
    	<textarea rows="3" cols="30" name="introduce" placeholder="자기소개 입력" required="required"></textarea>
    	
    	<input type="submit" value="전송">
    </form>
    
    
</body>
</html>