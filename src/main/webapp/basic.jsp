<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<% UserVo userVo = (UserVo)session.getAttribute("userVo"); %>
	<%=userVo.getName()+"["+userVo.getAlias()+"]님 안녕하세요" %>
<!-- 스크립틀릿 : 자바코드 작성 -->
<% 
	String msg = "first jsp";
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();
	String formattedDtstr = sdf.format(date);
%>
<body>
	hello, World
<!-- 표현식  : 출력을 표현 -->
	<br/> <%=msg %> <!--  yyyy-mm-dd hh:mi:ss -->
	<br/> <%=formattedDtstr %>
</body>
</html>
<!-- http://localhost:8081/basic.jsp -->