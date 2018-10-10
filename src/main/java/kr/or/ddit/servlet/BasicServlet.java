package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * BasicServlet.java
 * 
 * @author ASUS
 * @version 1.0
 * @see
 * 
 * <pre>
 * << �����̷�(Modification Information) >>
 * 
 * ������ ��������
 * ------ ------------------------
 * ASUS ���� ����
 * 
 * ���� �ð��� ����ϴ� html�� �����ϴ� ����
 * </pre>
 */
public class BasicServlet extends HttpServlet{
	
	
	//��û http �޼ҵ忡 ���� ����Ǵ� �޼ҵ尡 �޶�����
	//get : doGet
	//post : doPost
	
	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//HttpServletRequest : 요청에 대한 정보
		//HttpServletResponse : 응답에 대한 정보
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		//date format을 이용하여
		//��-��-�� �� ȭ�鿡 ���
		//simpleDateFormat
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date = new Date();
//		String formattedDtStr = sdf.format(date);

		
//		pw.println("hello, world");
//		pw.println(date);
		pw.println("<!DOCTYPE html>");
		pw.println("	<html>");
		pw.println("		<head>");
		pw.println("			<meta charset=\"UTF-8\">");
		pw.println("			<title>Insert title here</title>");
		pw.println("		</head>");
		pw.println("		<body>");
		pw.println("				hello, world <br/>"+date);
		pw.println("		</body>");
		pw.println("	</html>");
		
//		pw.print("hello, world \n"+formattedDtStr);
		
	}
}

// ���� �ڷ� : index.html --> url
// ���� �ڷ� : servlet --> url mapping ���� �ʿ� :web.xml