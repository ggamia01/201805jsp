<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="taggs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>logging tag</h2>
<taggs:loggingTag></taggs:loggingTag>
<c:forEach var="i" begin="1" end="10" >
	${i }<br/>
</c:forEach>
<taggs:loggingTag></taggs:loggingTag>

<h2>color logging tag</h2>
<taggs:colorLogging length="5" color="blue"/>
<c:forEach var="i" begin="1" end="10" >
	${i }<br/>
</c:forEach>
<taggs:colorLogging length="5" color="red"/>

<h2>color logging tag</h2>
<taggs:colorLogging color="blue"/>
<c:forEach var="i" begin="1" end="10" >
	${i }<br/>
</c:forEach>
<taggs:colorLogging  color="red"/>
</body>
</html>