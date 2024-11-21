<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<%--
		* 파일 업로드 라이브러리 추가
		1. commons-fileupload-x.x.jar을 다운로드 및 WEB-INF/lib 폴더에 저장
		2. commons-io.x.x.jar을 다운로드 및 WEB-INF/lib 폴더에 저장, jar은 자바 코드을 모아놓은 압축파일을 의미한다
	 --%>
	 
	 <h2>파일 업로드</h2>
	 <p>파일 선택</p>
	 <form action="uploadFile.jsp" method="POST" enctype="multipart/form-data">
	 <!-- 
	 	file 데이터를 전송하기 위해서는
	 	multipart/form-data encoding type을 추가해야 한다.
	 -->
	 	<input type="text" name="name"><br>
	 	<input type="file" name="files" multiple="multiple"><br>
	 	<input type="submit" value="파일 업로드"><br>
	 </form>
</body>
</html>