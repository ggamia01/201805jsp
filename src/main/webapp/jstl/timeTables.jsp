<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>구구단</p>
	<table border="1">
		<c:forEach begin="1" end="9" var="i">
	 	<tr>
	 		
	 		<c:forEach begin="2" end="${param.number }" var="j">
	 			<td>	
	 				${j } * ${i } = ${i*j }<br/>
	 			</td>
	 		</c:forEach>
		</tr>
	</c:forEach>
	</table>
</body>
</html>