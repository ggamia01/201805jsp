<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<p>구구단</p>
	<table border="1">
<%
	for(int i=1;i<10;i++){
%>
		<tr>
		<% for(int j=2;j<10;j++){ %>
			<td>
				<%= j%> * <%=i %> = <%=i*j %>
			</td>
		<% } %>
		</tr>
<%
	}
%>
	</table>
</body>
</html>