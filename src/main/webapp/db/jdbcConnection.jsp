<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
		// DB작업에 필요한 객체변수 선언
		Connection conn = null;
	
		try {
			//1. JDBC 드라이버 로딩 ==> Class.forName()을 이용한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. 해당 DB에 접속하기 
			//	==> DriverManager.getConnection()을 이용하고 
			//	==> 접속이 성공하면 Connection객체가 생성된다.
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "song"; //등록된 사용자아이디
			String pass = "java"; //등록된 패스워드
			
			long startTime = System.currentTimeMillis();
			for(int i=0;i<30;i++){
				conn = DriverManager.getConnection(url,user,pass);
				out.println("schema : "+ conn.getSchema());
				%><br/><%
				try{conn.close();}catch(Exception e2){}
			}
			long endTime = System.currentTimeMillis();
			out.println("total time : "+(endTime - startTime)+"ms");
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//6. 사용했던 자원을 반납한다.
			if(conn != null)try{conn.close();}catch(Exception e2){};
		}


	%>
</body>
</html>