<%@tag import="java.sql.SQLException"%>
<%@tag import="java.sql.DriverManager"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.Statement"%>
<%@tag import="java.sql.Connection"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name = "code" type="String"  required="true"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<%
		// DB작업에 필요한 객체변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; // 쿼리문이 select일때만 필요하다.
		
		try {
			//1. JDBC 드라이버 로딩 ==> Class.forName()을 이용한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. 해당 DB에 접속하기 
			//	==> DriverManager.getConnection()을 이용하고 
			//	==> 접속이 성공하면 Connection객체가 생성된다.
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "song"; //등록된 사용자아이디
			String pass = "java"; //등록된 패스워드
			
			conn = DriverManager.getConnection(url,user,pass);
			
			//3. Statement 객체 또는 PreparedStatement 객체 생성 ==> 질의를 수행하고 결과를 받아오는 객체
			//					 ==> 이 객체의 생성은 Connection 객체를 이용한다.
			stmt = conn.createStatement();
			
			//4. Statement객체를 이용하여 질의를 수행하고 결과를 받아서 resultSet객체에 담는다.
			//   (단, ResultSet객체는 Select문일 때만 사용한다.)
			
			String sql = "select prod_id, prod_name from prod where prod_lgu ='"+code+"'"; //실행할 SQL명령
			rs = stmt.executeQuery(sql); //sql명령이 select일 경우
			
			
					
			%>
			<select>
			
			<%		
			while(rs.next()){
				
				%>
				<option value="<%=rs.getString("prod_id") %>"><%=rs.getString("prod_name") %></option>
				<%
			}
			
			%>
			</select>
			<%
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//6. 사용했던 자원을 반납한다.
			if(rs != null)try{rs.close();}catch(Exception e2){};
			if(stmt != null)try{stmt.close();}catch(Exception e2){};
			if(conn != null)try{conn.close();}catch(Exception e2){};
		}


	%>


