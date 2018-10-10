<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--내장객체(implicit)
	request,respose, session, application, out
 --%>
 <%
 	out.equals(pageContext.getOut()); 
 	request.equals( pageContext.getRequest());
 	application.equals(pageContext.getServletContext());
 	
 	//out,request
 	//response, session
 	//application
 %>
 out.equals(pageContext.getOut()) : <%=out.equals(pageContext.getOut()) %><br/>
 request.equals(pageContext.getRequest()) : <%=request.equals(pageContext.getRequest()) %><br/>
 response.equals(pageContext.getResponse()) : <%=response.equals(pageContext.getResponse()) %><br/>
 session.equals(pageContext.getSession()) : <%=session.equals(pageContext.getSession()) %><br/>
 page.equals(pageContext.getPage()) : <%=page.equals(pageContext.getPage()) %><br/>
 application.equals(pageContext.getServletContext()) : <%=application.equals(pageContext.getServletContext()) %><br/>
</body>
</html>