<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 파일 전송은 post method만 가능 -->
<!-- get / /fileUpload : fileUpload.jsp요청
	post / /fileUpload : form전송 처리 -->
<form action="" method="post" enctype="multipart/form-data">
	<input type="text" name="userId" value="borwn"/><br/>
	<input type="file" name="profile" /><br/>
	
	<input type="submit" value="전송"/>
	<%=application.getRealPath("/profile") %>
</form>
</body>
</html>