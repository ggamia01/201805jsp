<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

	
    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/signin.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<!-- 로그인 처리
logIn.jsp(사용자 아이디, 비밀번호를 입력)
logInProcess.jsp
 -->
<body>
<%-- 브라우저 주소줄에 입력한 경우 : get
	 form 태그의 method 속성 : get/post
 --%>
<!-- <form action="/logIn/logInProcess.jsp" method="post"> -->
<!-- <form action="/logIn" method="get"> -->
<!-- <form action="/dditLogin" method="post"> -->
<!-- 	사용자 아이디 : <input type="text" name="userId" value="brown"/> <br/> -->
<!-- 	사용자 아이디 : <input type="text" name="userId" value="샐리"/> <br/> -->
<!-- 	사용자 비밀번호 : <input type="password" name="password" value="pass1234"/> <br/> -->
<!-- 	<input type="submit" value="로그인"/> -->
<!-- </form> -->






	<div class="container">

		<form class="form-signin" action="/dditLogin" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">userId</label> 
				<input
					type="text" id="inputEmail" class="form-control"
					placeholder="userId" required autofocus name="userId" value="brown"> 
			<label
					for="inputPassword" class="sr-only">Password</label> 
				<input
				type="password" id="inputPassword" class="form-control"
				placeholder="Password" required name="password" value="brownpass">
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
		</form>

	</div>
	<!-- /container -->


	
  
</body>
</html>