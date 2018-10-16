<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//jndi connection
		Context initialContext = new InitialContext();
		
// 		initialContext.lookup("java:comp/env/리소스이름")
		DataSource ds =  (DataSource)initialContext.lookup("java:comp/env/jdbc/oracleDB");

		Connection conn= null;
		
		long startTime = System.currentTimeMillis();
		
		for (int i=0; i<30; i++){
			conn = ds.getConnection();
			out.println("scheme : " + conn.getSchema());%><br/><%
			conn.close();
		}
		
		long endTime = System.currentTimeMillis();
		out.println("total time : "+(endTime - startTime)+"ms");
	%>
</body>
</html>