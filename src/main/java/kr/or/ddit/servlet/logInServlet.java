package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class logInServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
//		pw.println("<!DOCTYPE html>");
//		pw.println("	<html>");
//		pw.println("		<head>");
//		pw.println("			<meta charset=\"UTF-8\">");
//		pw.println("			<title>Insert title here</title>");
//		pw.println("		</head>");
//		pw.println("		<body>");
//		for(String str : req.getParameterValues("userId")){
//			pw.println(" userId : "+str+"<br/>");
//		}
//		pw.println(" password : "+ req.getParameter("password"));
//		pw.println("		</body>");
//		pw.println("	</html>");
		
		
		Map<String, String[]> requestMap = req.getParameterMap();
		
		pw.println("<!DOCTYPE html>");
		pw.println("	<html>");
		pw.println("		<head>");
		pw.println("			<meta charset=\"UTF-8\">");
		pw.println("			<title>Insert title here</title>");
		pw.println("		</head>");
		pw.println("		<body>");
		for(String str : requestMap.get("userId")){
			pw.println(" userId : "+str+"<br/>");
		}
		for(String str : requestMap.get("password")){
			pw.println(" password : "+str+"<br/>");
		}
		//alt+shift+r : 관련 변수명을 함께 바꿔준다.
		pw.println("		</body>");
		pw.println("	</html>");
		
	}
	
	
}
