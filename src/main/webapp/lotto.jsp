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
			int num = (int)(Math.random()*19)+1;
			String sql = "select name from jspstudent where no ="+num; //실행할 SQL명령
			rs = stmt.executeQuery(sql); //sql명령이 select일 경우
			//기타 insert, update, delete명령일 때는 executeUpdate()를 사용한다.
			
			//5. ResultSet객체에 저장되어 있는 자료를 반복문과 next()메서드를 이용하여 차례로 읽어와 처리한다.
			System.out.println("실행쿼리문 : " + sql);
			System.out.println("===쿼리문 실행결과===");
			
			String name="";
			// rs.next() ==> ResultSet 객체의 데이터를 가리키는 포인터를 다음 레코드로 이동시키고 그곳에 데이터가 있으면 true, 없으면 false를 반환한다.
			if(rs.next()){
				
				System.out.println(rs.getNString("name")); // 컬럼명 이용
				name = rs.getNString("name");
			}
			
			%>
			<canvas id="myCanvas" width="200" height="200"
				style="border:1px solid #000000"
			></canvas>
			<script>
				
				var canvas = document.getElementById("myCanvas");
				var ctx = canvas.getContext("2d");
			// 	ctx.fillStyle = "#FF0000";
			// 	ctx.fillRect(0,0,150,75);
				
				ctx.beginPath();
				//원의 중심x좌표, 원의 중심y좌표, 반지름0
				ctx.arc(100,100,100,0,2*Math.PI);
				ctx.stroke();
				
				ctx.font = "60px Arial";
				ctx.fillText("<%=name%>",10,120);
			</script>
			<div class="stage">
				<div class="cube">
					<div class="side_bottom">Bottom</div>
					<div class="slide_top">top</div>
					<div class="slide_back">back</div>
					<div class="slide_right">right</div>
					<div class="slide_left">left</div>
					<div class="slide_front">hover</div>
				</div>
			</div>
			
			<style>
			.stage{
			position : fixed;
			width:100px;
			height:100px;
			perspective:400;
			}
			.cube{
			height:100px;
			width:100px;
			position:relative;
			margin:0 auto;
			transition:all 1s;
			}
			.cube div{
			height : 100px;
			width:100px;
			position:absolute;
			line-height: 100px;
			}
			.slide_top{
			background:rgba(255,241,0,0.7);
			top:-50px;
			left:0px;
			transform:ratateX(90deg);
			}
			.slide_bottom{
			background:rgba(255,241,0.7);
			bottom:-50px;
			left:0px;
			transform:rotateX(-90deg);
			}
			.slide_front{
			background:rgba(215,0,81,0.7);
			top:0px;
			left:0px;
			transform:translateZ(50px);
			
			}
			.slide_back{
			background:rgba(215,0,81,0.7);
			top:0px;
			left:0px;
			transform:translateZ(-50px);
			}
			.slide_right{
			background:rgba(0,160,233,0.7);
			top:0px;
			right:-50px
			transform:translateY(90deg);
			}
			.slide_left{
			background:rgba(0,160,233,0.7);
			top:0px;
			left:-50px;
			transform:translateZ(-90deg);
			}
			.stage:hover.cube{
			transform:rotateX(-360deg);
			}
			</style>
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
	
	
</body>

</html>