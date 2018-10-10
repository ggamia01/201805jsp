package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeTables extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("	<html>");
		pw.println("		<head>");
		pw.println("			<meta charset=\"UTF-8\">");
		pw.println("			<title>Insert title here</title>");
		pw.println("		</head>");
		pw.println("		<body>");
		pw.println("<table border='1'>");
		for(int i=1;i<10;i++){
			pw.println("<tr>");
			for(int j=2;j<10;j++){
				pw.println("<td>"+j+"*"+i+"="+i*j+"</td>");			
				
			}
			pw.print("</tr>");
		}
		pw.print("</table>");
		pw.println("				");
		pw.println("		</body>");
		pw.println("	</html>");
		
	}
}
