<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- scope 테스트 시나리오
1. localhost:8081/im;oicit/scope.jsp에서 전송
request영역 확인

2. 새로운 탭을 열어서 (ctrl +t)
	localhost:8081/im;oicit/scope.jsp
session영역 확인

3. exproler에서 
	localhost:8081/im;oicit/scope.jsp
application영역 확인

4. cookie 삭제 후 2번 테스트
 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
requestScope : <%=request.getAttribute("requestScope") %><br/>
sessionScope : <%=session.getAttribute("sessionScope") %><br/>
applicationScope : <%=application.getAttribute("applicationScope") %><br/>
</body>
</html>